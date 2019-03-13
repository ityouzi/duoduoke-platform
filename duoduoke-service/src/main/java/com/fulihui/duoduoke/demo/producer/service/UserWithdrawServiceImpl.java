package com.fulihui.duoduoke.demo.producer.service;


import com.fulihui.duoduoke.demo.api.api.UserWithdrawService;
import com.fulihui.duoduoke.demo.api.dto.UserWithdrawDTO;
import com.fulihui.duoduoke.demo.api.enums.WithdrawStatusEnum;
import com.fulihui.duoduoke.demo.api.request.UserWithdrawCreateRequest;
import com.fulihui.duoduoke.demo.api.request.UserWithdrawModifyRequest;
import com.fulihui.duoduoke.demo.api.request.UserWithdrawRequest;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.UserWithdraw;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.UserWithdrawExample;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.UserWithdrawStatus;
import com.fulihui.duoduoke.demo.producer.repository.UserWithdrawRepository;
import com.fulihui.duoduoke.demo.producer.repository.UserWithdrawStatusRepository;
import com.fulihui.duoduoke.demo.producer.dal.dao.UserWithdrawMapper;
import com.fulihui.duoduoke.demo.common.except.BizException;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Service;
import org.near.servicesupport.error.Errors;
import org.near.servicesupport.error.InvokeServiceException;
import org.near.servicesupport.request.TPageRequest;
import org.near.servicesupport.result.ResultBuilder;
import org.near.servicesupport.result.TPageResult;
import org.near.servicesupport.result.TSingleResult;
import org.near.servicesupport.util.ServiceAssert;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * @author: JY
 * @date: 2018/7/12 15:04
 */
@Service(version = "${demo.service.version}")

public class UserWithdrawServiceImpl implements UserWithdrawService {

    @Autowired
    UserWithdrawMapper userWithdrawMapper;

    @Autowired
    UserWithdrawStatusRepository userWithdrawStatusRepository;

    @Autowired
    UserWithdrawRepository userWithdrawRepository;

    /**
     * 分页查询
     *
     * @param request
     * @return
     */
    @Override
    public TPageResult<UserWithdrawDTO> queryPage(TPageRequest<UserWithdrawDTO> request) {

        UserWithdrawDTO userWithdraw = request.getCondition();

        //查询条件
        UserWithdrawExample example = new UserWithdrawExample();
        //创建查询条件
        UserWithdrawExample.Criteria criteria = example.createCriteria();

        //用户id
        if (StringUtils.isNotEmpty(userWithdraw.getUserId())) {
            criteria.andUserIdEqualTo(userWithdraw.getUserId());
        }

        //状态
        if (userWithdraw.getStatus() != null) {
            criteria.andStatusEqualTo(userWithdraw.getStatus());
        }

        //查询条数
        Long totalCount = userWithdrawMapper.countByExample(example);

        //分页查询
        example.setOffset(request.start4Mysql());
        example.setLimit(request.getRows());
        example.setOrderByClause(" gmt_modified desc");
        List<UserWithdraw> withdrawList = userWithdrawMapper.selectByExample(example);

        List<UserWithdrawDTO> resultList = new ArrayList<>();

        //数据转换
        if (withdrawList != null && withdrawList.size() > 0) {
            withdrawList.forEach((item) -> {
                UserWithdrawDTO withdrawDTO = convert(item);
                resultList.add(withdrawDTO);
            });
        }

        return ResultBuilder.succTPage(resultList, request.getPage(), request.getRows(),
                totalCount.intValue());
    }

    private UserWithdrawDTO convert(UserWithdraw item) {
        UserWithdrawDTO withdrawDTO = new UserWithdrawDTO();
        BeanUtils.copyProperties(item, withdrawDTO);
        return withdrawDTO;
    }

    @Override
    public TSingleResult<Long> queryCount(UserWithdrawRequest request) {
        ServiceAssert.notNull(request, Errors.Commons.REQUEST_PARAMETER_ERROR);
        //查询条件
        UserWithdrawExample example = new UserWithdrawExample();
        //创建查询条件
        UserWithdrawExample.Criteria criteria = example.createCriteria();

        criteria.andUserIdEqualTo(request.getUserId());
        if (!CollectionUtils.isEmpty(request.getStatus())) {
            criteria.andStatusIn(request.getStatus());
        }
        long count = userWithdrawMapper.countByExample(example);

        return ResultBuilder.succTSingle(count);
    }

    /**
     * 插入数据
     *
     * @param request
     * @return
     */
    @Override
    @Transactional
    public TSingleResult<Long> insert(UserWithdrawCreateRequest request) {

        UserWithdraw userWithdraw = new UserWithdraw();
        BeanUtils.copyProperties(request, userWithdraw);

        //判断该用户是否有未完成的提现订单
        List<String> statusArray = Lists.newArrayList();
        statusArray.add(WithdrawStatusEnum.waitAudit.getCode());
        statusArray.add(WithdrawStatusEnum.auditPass.getCode());
        statusArray.add(WithdrawStatusEnum.withdrawing.getCode());
        boolean hasWithdrawing = userWithdrawRepository.hasWithdrawing(userWithdraw.getUserId(),
                statusArray);
        //如果有
        if (hasWithdrawing) {
            throw new BizException(1, "已有提现订单");
        }

        //设置时间
        userWithdraw.setGmtCreate(Calendar.getInstance().getTime());
        userWithdraw.setGmtModified(Calendar.getInstance().getTime());
        //插入待审核的状态
        userWithdraw.setStatus(WithdrawStatusEnum.waitAudit.getCode());
        //自动审核
        userWithdraw.setAuditTime(Calendar.getInstance().getTime());
        userWithdraw.setAuditor("admin");
        userWithdraw.setAuditRemark("");
        //执行插入
        int success = userWithdrawMapper.insertSelective(userWithdraw);

        if (success > 0) {
            //插入更新状态
            UserWithdrawStatus withdrawStatus = new UserWithdrawStatus();
            withdrawStatus.setStatus(userWithdraw.getStatus());
            withdrawStatus.setWithdrawId(userWithdraw.getId());
            success = userWithdrawStatusRepository.insert(withdrawStatus);
        }

        if (success > 0) {
            return ResultBuilder.succTSingle(userWithdraw.getId());
        }

        throw new BizException(1, "审核更新失败");
    }

    /**
     * 查看详情
     *
     * @return
     */
    @Override
    public TSingleResult<UserWithdrawDTO> detailById(Long id) {


        //查询详情
        UserWithdraw userWithdraw = userWithdrawMapper.selectByPrimaryKey(id);

        UserWithdrawDTO withdrawDTO = new UserWithdrawDTO();

        //转换数据
        if (userWithdraw != null) {
            BeanUtils.copyProperties(userWithdraw, withdrawDTO);
        }

        return ResultBuilder.succTSingle(withdrawDTO);
    }

    /**
     * 更新状态
     *
     * @param request
     * @return
     */
    @Transactional
    @Override
    public TSingleResult<Boolean> modifyStatus(UserWithdrawModifyRequest request) {

        UserWithdraw model = new UserWithdraw();
        model.setId(request.getId());
        model.setStatus(request.getStatusEnum().getCode());
        model.setGmtModified(Calendar.getInstance().getTime());

        // 审核成功/失败
        if (request.getStatusEnum() == WithdrawStatusEnum.auditPass
                || request.getStatusEnum() == WithdrawStatusEnum.auditReject) {
            model.setAuditor(request.getAuditor());
            model.setAuditTime(Calendar.getInstance().getTime());
            model.setAuditRemark(request.getRemark());
        }

        //执行更新
        int success = userWithdrawMapper.updateByPrimaryKeySelective(model);

        UserWithdrawStatus withdrawStatus = new UserWithdrawStatus();
        withdrawStatus.setId(request.getId());
        withdrawStatus.setStatus(request.getStatusEnum().getCode());
        withdrawStatus.setWithdrawId(model.getId());

        if (success > 0) {
            success = userWithdrawStatusRepository.insert(withdrawStatus);
        }

        if (success > 0) {
            return ResultBuilder.succTSingle(true);
        }

        throw new InvokeServiceException(1, "更新失败");
    }
}
