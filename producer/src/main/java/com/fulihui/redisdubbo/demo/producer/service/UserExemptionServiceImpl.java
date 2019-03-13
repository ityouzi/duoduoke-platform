package com.fulihui.redisdubbo.demo.producer.service;


import com.fulihui.redisdubbo.demo.api.api.UserExemptionService;
import com.fulihui.redisdubbo.demo.api.dto.ExemptionGoodsDTO;
import com.fulihui.redisdubbo.demo.api.dto.UserExemptionGoodsDTO;
import com.fulihui.redisdubbo.demo.api.enums.DuoDuoOrderStatusEnum;
import com.fulihui.redisdubbo.demo.api.enums.UserAccountBizCode;
import com.fulihui.redisdubbo.demo.api.enums.UserExemptionStateEnum;
import com.fulihui.redisdubbo.demo.api.enums.UserOrderStatusEnum;
import com.fulihui.redisdubbo.demo.api.request.IdRequest;
import com.fulihui.redisdubbo.demo.api.request.UserExemptionRequest;
import com.fulihui.redisdubbo.demo.producer.dal.dataobj.ExemptionGoods;
import com.fulihui.redisdubbo.demo.producer.dal.dataobj.OrderInfo;
import com.fulihui.redisdubbo.demo.producer.dal.dataobj.UserExemptionGoods;
import com.fulihui.redisdubbo.demo.producer.manager.ExemptionOrderManager;
import com.fulihui.redisdubbo.demo.producer.manager.SignOrderReceiptManager;
import com.fulihui.redisdubbo.demo.producer.repository.ExemptionGoodsRepository;
import com.fulihui.redisdubbo.demo.producer.repository.OrderInfoRepository;
import com.fulihui.redisdubbo.demo.producer.repository.UserExemptionGoodsRepository;
import com.fulihui.redisdubbo.demo.weixin.common.util.BeanConvUtil;
import org.apache.dubbo.config.annotation.Service;
import org.near.servicesupport.error.Errors;
import org.near.servicesupport.result.*;
import org.near.servicesupport.util.ServiceAssert;
import org.near.toolkit.common.EnumUtil;
import org.near.toolkit.common.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static com.fulihui.redisdubbo.demo.api.enums.UserOrderStatusEnum.ALREADY_TO_ACCOUNT;
import static org.near.servicesupport.util.ServiceAssert.notNull;


/**
 * @author wangll
 * @create 2018-11-14 15:50
 * @description
 */
@Service(version = "${demo.service.version}")

public class UserExemptionServiceImpl implements UserExemptionService {
    protected Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    ExemptionOrderManager exemptionOrderManager;
    @Autowired
    SignOrderReceiptManager signOrderReceiptManager;
    @Autowired
    private UserExemptionGoodsRepository userExemptionGoodsRepository;
    @Autowired
    private ExemptionGoodsRepository exemptionGoodsRepository;
    @Autowired
    private OrderInfoRepository orderInfoRepository;

    @Override
    public TMultiResult<UserExemptionGoodsDTO> query(UserExemptionGoodsDTO userExemptionGoodsDTO) {
        ServiceAssert.notNull(userExemptionGoodsDTO, Errors.Commons.REQUEST_PARAMETER_ERROR);

        UserExemptionGoods userExemptionGoods = new UserExemptionGoods();
        BeanUtils.copyProperties(userExemptionGoodsDTO, userExemptionGoods);

        List<UserExemptionGoods> list = userExemptionGoodsRepository
                .selectByExample(userExemptionGoods);
        List<UserExemptionGoodsDTO> dtos = convert(list);
        return ResultBuilder.succTMulti(dtos);
    }

    @Override
    public TSingleResult<Boolean> insert(UserExemptionGoodsDTO userExemptionGoodsDTO) {
        UserExemptionGoods userExemptionGoods = BeanConvUtil.copy(userExemptionGoodsDTO,
                UserExemptionGoods.class);

        //初始时间
        boolean success = userExemptionGoodsRepository.insert(userExemptionGoods) > 0;

        return ResultBuilder.succTSingle(success);
    }

    @Override
    public TSingleResult<Boolean> update(UserExemptionGoodsDTO userExemptionGoodsDTO) {
        UserExemptionGoods userExemptionGoods = BeanConvUtil.copy(userExemptionGoodsDTO,
                UserExemptionGoods.class);

        boolean success = userExemptionGoodsRepository.updateById(userExemptionGoods) > 0;

        return ResultBuilder.succTSingle(success);
    }

    @Override
    @Transactional
    public BaseResult robbingOrder(UserExemptionRequest userExemptionRequest) {
        ServiceAssert.notNull(userExemptionRequest, Errors.Commons.REQUEST_PARAMETER_ERROR);
        ServiceAssert.notNull(userExemptionRequest.getExemptionGoodsDTO(),
                Errors.Commons.REQUEST_PARAMETER_ERROR);
        ServiceAssert.notNull(userExemptionRequest.getUserExemptionGoodsDTO(),
                Errors.Commons.REQUEST_PARAMETER_ERROR);
        ExemptionGoodsDTO exemptionGoodsDTO = userExemptionRequest.getExemptionGoodsDTO();
        UserExemptionGoodsDTO userExemptionGoodsDTO = userExemptionRequest
                .getUserExemptionGoodsDTO();
        ExemptionGoods exemptionGoods = BeanConvUtil.copy(exemptionGoodsDTO, ExemptionGoods.class);
        int i = exemptionGoodsRepository.addReceiveNum(exemptionGoods);

        if (i > 0) {
            UserExemptionGoods userExemptionGoods = BeanConvUtil.copy(userExemptionGoodsDTO,
                    UserExemptionGoods.class);
            //初始时间
            boolean success = userExemptionGoodsRepository.insert(userExemptionGoods) > 0;
            if (!success) {
                throw new RuntimeException(Errors.Commons.SYSTEM_ERROR.getErrmsg());
            }
        } else {
            throw new RuntimeException(Errors.Commons.SYSTEM_ERROR.getErrmsg());
        }
        return ResultBuilder.succ();
    }

    @Override
    public TSingleResult<Boolean> del(IdRequest request) {
        boolean success = userExemptionGoodsRepository.del(request.getId()) > 0;

        return ResultBuilder.succTSingle(success);
    }

    @Override
    public TSingleResult<UserExemptionGoodsDTO> selectByPrimaryKey(IdRequest request) {
        ServiceAssert.notNull(request, Errors.Commons.REQUEST_PARAMETER_ERROR);
        ServiceAssert.notNull(request.getId(), Errors.Commons.REQUEST_PARAMETER_ERROR);
        UserExemptionGoods userExemptionGoods = userExemptionGoodsRepository
                .selectByPrimaryKey(request.getId());
        UserExemptionGoodsDTO userExemptionGoodsDTO = new UserExemptionGoodsDTO();
        BeanUtils.copyProperties(userExemptionGoods, userExemptionGoodsDTO);
        return ResultBuilder.succTSingle(userExemptionGoodsDTO);
    }

    @Override
    public TPageResult<UserExemptionGoodsDTO> queryReceipt(IdRequest request) {

        notNull(request, Errors.Commons.REQUEST_PARAMETER_ERROR);

        List<UserExemptionGoods> list = userExemptionGoodsRepository.queryExceedDay(
                request.getState(), request.getBindOrderStatus(), request.start4Mysql(),
                request.getRows());

        long count = 0;
        if (!CollectionUtils.isEmpty(list)) {
            count = userExemptionGoodsRepository.queryExceedDayCount(request.getState(),
                    request.getBindOrderStatus());
        }
        return ResultBuilder.succTPage(convert(list), request.getPage(), request.getRows(),
                (int) count);

    }

    @Override
    @Transactional
    public TSingleResult<UserExemptionGoodsDTO> confirmReceipt(IdRequest request) {
        notNull(request, Errors.Commons.REQUEST_PARAMETER_ERROR);
        notNull(request.getId(), Errors.Commons.REQUEST_PARAMETER_ERROR);
        UserExemptionGoods goods = userExemptionGoodsRepository.selectByPrimaryKey(request.getId());
        if (goods == null) {
            return ResultBuilder.failTSingle(Errors.Commons.SYSTEM_ERROR);
        }
        //奖金已发放
        if (StringUtil.equals(UserExemptionStateEnum.SETTLE.getCode(), goods.getState())) {
            return ResultBuilder.succTSingle(convert(goods));
        }
        String orderSn = goods.getOrderSn();
        String userId = goods.getUserId();
        List<OrderInfo> list = orderInfoRepository.queryByOrderSn(orderSn, userId);
        if (CollectionUtils.isEmpty(list)) {
            return ResultBuilder.succTSingle(convert(goods));
        }
        OrderInfo info = list.get(0);

        String userOrderStatus = info.getUserOrderStatus();
        UserOrderStatusEnum userEnum = EnumUtil.queryByCode(userOrderStatus,
                UserOrderStatusEnum.class);
        if (userEnum != UserOrderStatusEnum.INVALID) {
            UserExemptionGoods item = new UserExemptionGoods();
            item.setId(request.getId());
            item.setState(UserExemptionStateEnum.SETTLE.getCode());
            int i = userExemptionGoodsRepository.updateById(item);
            if (i > 0) {
                OrderInfo orderInfo = new OrderInfo();
                orderInfo.setCustomParameters(userId);
                orderInfo.setOrderSn(orderSn);
                orderInfo.setUserOrderStatus(ALREADY_TO_ACCOUNT.getCode());
                orderInfo.setUserOrderStatusDesc(ALREADY_TO_ACCOUNT.getDesc());
                orderInfo.setOrderStatus(DuoDuoOrderStatusEnum.AUDIT_SUCCESS.getCode());
                orderInfo.setOrderStatusDesc(DuoDuoOrderStatusEnum.AUDIT_SUCCESS.getDesc());
                orderInfoRepository.update(orderInfo);
                Integer backAmount = goods.getBackAmount();
                signOrderReceiptManager.addMoneyToBalance(orderSn, Long.valueOf(backAmount), userId,
                        orderSn + "免单返现奖励", UserAccountBizCode.ORDER_FREE_REWARD.getCode());
            }
        } else {
            String orderStatus = info.getOrderStatus();
            String goodsId = info.getGoodsId();
            exemptionOrderManager.invalid(userId, orderSn, goodsId, orderStatus);
        }
        UserExemptionGoods primaryKey = userExemptionGoodsRepository
                .selectByPrimaryKey(request.getId());
        return ResultBuilder.succTSingle(convert(primaryKey));
    }

    @Override
    @Transactional
    public BaseResult updateStateAndNums(UserExemptionGoodsDTO userExemptionGoodsDTO) {
        UserExemptionGoods item = new UserExemptionGoods();
        item.setId(userExemptionGoodsDTO.getId());
        item.setState(UserExemptionStateEnum.INVALID.getCode());
        int i = userExemptionGoodsRepository.updateById(item);
        logger.info("更新用户免单商品状态," + i);
        if (i > 0) {
            ExemptionGoods exemptionGoods = new ExemptionGoods();
            exemptionGoods.setId(userExemptionGoodsDTO.getExemptionGoodsId());
            exemptionGoods.setSurplusNum(1);
            exemptionGoods.setReceiveNum(1);
            int result = exemptionGoodsRepository.subReceiveNum(exemptionGoods);
            logger.info("更新免单商品状态," + result);
            if (result > 0) {
                return ResultBuilder.succ();
            } else {
                throw new RuntimeException(Errors.Commons.SYSTEM_ERROR.getErrmsg());
            }

        } else {
            throw new RuntimeException(Errors.Commons.SYSTEM_ERROR.getErrmsg());
        }

    }

    private List<UserExemptionGoodsDTO> convert(List<UserExemptionGoods> list) {
        if (CollectionUtils.isEmpty(list)) {
            return Collections.emptyList();
        }
        return list.stream().map(this::convert).collect(Collectors.toList());
    }

    private UserExemptionGoodsDTO convert(UserExemptionGoods i) {
        if (i == null) {
            return null;
        }
        UserExemptionGoodsDTO userExemptionGoodsDTO = new UserExemptionGoodsDTO();
        BeanUtils.copyProperties(i, userExemptionGoodsDTO);
        return userExemptionGoodsDTO;
    }
}
