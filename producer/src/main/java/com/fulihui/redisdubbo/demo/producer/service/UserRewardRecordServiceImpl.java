package com.fulihui.redisdubbo.demo.producer.service;


import com.fulihui.redisdubbo.demo.api.api.UserRewardRecordService;
import com.fulihui.redisdubbo.demo.api.dto.UserRewardRecordDTO;
import com.fulihui.redisdubbo.demo.api.request.UserRewardRecordRequest;
import com.fulihui.redisdubbo.demo.producer.dal.dataobj.UserRewardRecord;
import com.fulihui.redisdubbo.demo.producer.dal.dataobj.UserRewardRecordExample;
import com.fulihui.redisdubbo.demo.producer.repository.UserRewardRecordRepository;
import org.apache.dubbo.config.annotation.Service;
import org.near.servicesupport.error.Errors;
import org.near.servicesupport.result.BaseResult;
import org.near.servicesupport.result.ResultBuilder;
import org.near.servicesupport.result.TPageResult;
import org.near.servicesupport.result.TSingleResult;
import org.near.servicesupport.util.ServiceAssert;
import org.near.toolkit.common.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: xiaoming
 * @version: v 0.1 2018/9/3 0003 17:04
 */
@Service(version = "${demo.service.version}")

public class UserRewardRecordServiceImpl implements UserRewardRecordService {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserRewardRecordRepository userRewardRecordRepository;

    @Override
    public BaseResult insert(UserRewardRecordRequest request) {
        ServiceAssert.notNull(request, Errors.Commons.REQUEST_PARAMETER_ERROR);
        UserRewardRecord rewardRecord = new UserRewardRecord();
        BeanUtils.copyProperties(request, rewardRecord);
        Integer insert = userRewardRecordRepository.insert(rewardRecord);
        return insert > 0 ? ResultBuilder.succ() : ResultBuilder.fail(1001, "保存失败");
    }

    @Override
    public TPageResult<UserRewardRecordDTO> query(UserRewardRecordRequest request) {
        ServiceAssert.notNull(request, Errors.Commons.REQUEST_PARAMETER_ERROR);
        UserRewardRecordExample example = new UserRewardRecordExample();
        if (StringUtil.isNotEmpty(request.getOrderBy())) {
            example.setOrderByClause(request.getOrderBy());
        }
        UserRewardRecordExample.Criteria criteria = example.createCriteria();
        if (StringUtil.isNotEmpty(request.getOrderSn())) {
            criteria.andOrderSnEqualTo(request.getOrderSn());
        }
        if (StringUtil.isNotEmpty(request.getUserId())) {
            criteria.andUserIdEqualTo(request.getUserId());
        }
        if (StringUtil.isNotEmpty(request.getHelpUserId())) {
            criteria.andHelpUserIdEqualTo(request.getHelpUserId());
        }
        if (request.getStartCreateTime() != null) {
            criteria.andCreateTimeGreaterThanOrEqualTo(request.getStartCreateTime());
        }
        if (request.getStopCreateTime() != null) {
            criteria.andCreateTimeLessThanOrEqualTo(request.getStopCreateTime());
        }
        List<UserRewardRecordDTO> list = userRewardRecordRepository.query(example);
        if (CollectionUtils.isEmpty(list)) {
            return ResultBuilder.succTPage(new ArrayList<>(), 1, 100, list.size());
        }
        return ResultBuilder.succTPage(list, 1, 100, 0);
    }

    @Override
    public TSingleResult<Double> sumPercent(UserRewardRecordRequest request) {
        ServiceAssert.notNull(request, Errors.Commons.REQUEST_PARAMETER_ERROR);
        ServiceAssert.notNull(request.getUserId(), Errors.Commons.REQUEST_PARAMETER_ERROR);
        Double integer = userRewardRecordRepository.sumPercent(request.getUserId(),
                request.getOrderSn());
        return ResultBuilder.succTSingle(integer);
    }
}
