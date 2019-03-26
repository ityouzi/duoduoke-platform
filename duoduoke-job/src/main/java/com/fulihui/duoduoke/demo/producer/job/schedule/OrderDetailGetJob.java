package com.fulihui.duoduoke.demo.producer.job.schedule;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import com.fulihui.duoduoke.demo.api.api.OrderInfoService;
import com.fulihui.duoduoke.demo.api.dto.OrderInfoDTO;
import com.fulihui.duoduoke.demo.api.enums.DuoDuoOrderStatusEnum;
import com.fulihui.duoduoke.demo.api.enums.OrderPromoTypeEnum;
import com.fulihui.duoduoke.demo.api.enums.UserOrderStatusEnum;
import com.fulihui.duoduoke.demo.api.request.OrderInfoTakeAmountRequest;
import com.fulihui.duoduoke.demo.api.request.OrderQueryInfoRequest;
import com.fulihui.duoduoke.demo.common.config.DuoDuoKeConfig;
import com.fulihui.duoduoke.demo.common.crypto.AESCoder;
import com.fulihui.duoduoke.demo.producer.job.config.AesKeyConfig;
import com.fulihui.duoduoke.demo.producer.job.convert.OrderInfoTakeAmountConvert;
import com.fulihui.duoduoke.demo.producer.job.model.CustomParameters;
import com.fulihui.duoduoke.demo.producer.job.util.SignUtil;
import com.fulihui.duoduoke.demo.web.weixin.duoapi.DuoHttpClient;
import com.fulihui.duoduoke.demo.web.weixin.duoapi.request.DuoOrderDetailGetRequest;
import com.fulihui.duoduoke.demo.web.weixin.duoapi.result.DuoOrderDetailGetResult;
import com.fulihui.duoduoke.demo.web.weixin.duoapi.result.OrderSnIncrementResult;
import com.fulihui.duoduoke.demo.web.weixin.weixin.util.ClassFieldsUtil;
import org.apache.dubbo.config.annotation.Reference;
import org.near.servicesupport.result.TPageResult;
import org.near.toolkit.common.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;

import static com.google.common.collect.Lists.newArrayList;
import static org.near.servicesupport.util.ServiceResultUtil.checkResult;
import static org.near.toolkit.common.StringUtil.isBlank;


/**
 * @author wahaha
 */
public class OrderDetailGetJob implements SimpleJob {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderDetailGetJob.class);

    private volatile boolean running = false;
    @Autowired
    AesKeyConfig aesKeyConfig;
    @Autowired
    DuoHttpClient duoHttpClient;
    @Autowired
    DuoDuoKeConfig duoDuoKeConfig;
    @Reference
    OrderInfoService orderInfoService;

    @Override
    public void execute(ShardingContext shardingContext) {
        LOGGER.info("running:{}", running);
        if (running) {
            LOGGER.warn("running值没改掉");
            return;
        }

        running = true;
        OrderQueryInfoRequest request = new OrderQueryInfoRequest();
        request.setOrderStatus(newArrayList(DuoDuoOrderStatusEnum.C_RECEIPT.getCode(),
                DuoDuoOrderStatusEnum.Y_GROUP.getCode()));
        request.setRows(50);
        request.setUserOrderStatus(newArrayList(UserOrderStatusEnum.TO_BE_SETTLEMENT.getCode(),
                UserOrderStatusEnum.TO_BE_CONFIRMED.getCode()));
        TPageResult<OrderInfoDTO> result = orderInfoService.queryPage(request);

        checkResult(result);

        int totalPage = result.getTotalPage();
        for (int i = 1; i <= totalPage; i++) {
            request.setPage(i);
            TPageResult<OrderInfoDTO> pageResult = orderInfoService.queryPage(request);

            List<OrderInfoDTO> values = pageResult.getValues();

            if (!CollectionUtils.isEmpty(values)) {
                for (OrderInfoDTO item : values) {
                    DuoOrderDetailGetRequest getRequest = new DuoOrderDetailGetRequest();
                    getRequest.setType("pdd.ddk.order.detail.get");
                    getRequest.setClient_id(duoDuoKeConfig.getClientId());
                    getRequest.setOrder_sn(item.getOrderSn());
                    getRequest.setTimestamp(System.currentTimeMillis() + "");
                    Map<String, Object> strValMap = ClassFieldsUtil.obj2StrValMap(getRequest);
                    String sign = SignUtil.genServiceSign(ClassFieldsUtil.obj2StrVal(getRequest), strValMap,
                            duoDuoKeConfig.getClientSecret());
                    getRequest.setSign(sign);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        LOGGER.error(e.getMessage(), e);
                    }
                    DuoOrderDetailGetResult duoResult = duoHttpClient.invokeService(getRequest);
                    LOGGER.debug("duoResult:{}", JSON.toJSON(duoResult));
                    if (duoResult != null && duoResult.getOrderDetailResponse() != null) {
                        DuoOrderDetailGetResult.OrderDetailResponseBean bean = duoResult
                                .getOrderDetailResponse();
                        if (isBlank(bean.getCustomParameters())) {
                            LOGGER.info("抓取订单的接口,如果接口返回自定义参数没有值,忽略该条信息,bean:{}", bean);
                            continue;
                        }
                        if ("-1".equals(bean.getCustomParameters())) {
                            LOGGER.info("抓取订单的接口,如果接口返回自定义参数没有值,忽略该条信息,bean:{}", bean);
                            continue;
                        }
                        try {
                            AESCoder aesCoder = AESCoder.getInstance();

                            String parameters = aesCoder.decryptString(bean.getCustomParameters(),
                                    aesKeyConfig.getAesKey());
                            if (StringUtil.isBlank(parameters)) {
                                continue;
                            }

                            CustomParameters object = JSONObject.parseObject(parameters,
                                    CustomParameters.class);
                            if (object == null) {
                                continue;
                            }
                            String userId = object.getUserId();
                            bean.setCustomParameters(userId);
                            //订单数据转换request

                            OrderSnIncrementResult.OrderListGetResponseBean.OrderListBean orderListBean = getOrderListBean(
                                    bean);

                            OrderInfoTakeAmountRequest takeAmountRequest = OrderInfoTakeAmountConvert
                                    .convertOrderInfoRequest(orderListBean);
                            //订单推荐人
                            takeAmountRequest.setOrderUserReferee(object.getOrderUserReferee());
                            //订单推广来源
                            if (StringUtil.isNotBlank(object.getOrderSource())) {
                                takeAmountRequest.setOrderPromotionSource(object.getOrderSource());
                            }
                            //订单推广的渠道标示
                            if (StringUtil.isNotBlank(object.getChannelsCode())) {
                                takeAmountRequest.setChannelsCode(object.getChannelsCode());
                            }
                            takeAmountRequest.setPromoType(OrderPromoTypeEnum.ORDINARY.getCode());

                            orderInfoService.takeOrderInfoAmount(takeAmountRequest);

                        } catch (Exception e) {
                            LOGGER.error(e.getMessage(), e);
                        }
                    }
                }
            }
        }

        running = false;
    }

    private OrderSnIncrementResult.OrderListGetResponseBean.OrderListBean getOrderListBean(DuoOrderDetailGetResult.OrderDetailResponseBean bean) {
        OrderSnIncrementResult.OrderListGetResponseBean.OrderListBean orderListBean = new OrderSnIncrementResult.OrderListGetResponseBean.OrderListBean();

        orderListBean.setOrderSn(bean.getOrderSn());
        orderListBean.setGoodsId(bean.getGoodsId());
        orderListBean.setGoodsName(bean.getGoodsName());
        orderListBean.setGoodsThumbnailUrl(bean.getGoodsThumbnailUrl());
        orderListBean.setBatchNo(bean.getBatchNo());
        orderListBean.setOrderStatusDesc(bean.getOrderStatusDesc());
        orderListBean.setCustomParameters(bean.getCustomParameters());
        orderListBean.setPId(bean.getPId());

        if (StringUtil.isNotBlank(bean.getGoodsQuantity())) {
            orderListBean.setGoodsQuantity(bean.getGoodsQuantity());
        }

        if (StringUtil.isNotBlank(bean.getGoodsPrice())) {
            orderListBean.setGoodsPrice(bean.getGoodsPrice());

        }

        if (StringUtil.isNotBlank(bean.getOrderAmount())) {
            orderListBean.setOrderAmount(bean.getOrderAmount());

        }
        if (StringUtil.isNotBlank(bean.getOrderCreateTime())) {
            orderListBean.setOrderCreateTime(bean.getOrderCreateTime());

        }
        if (StringUtil.isNotBlank(bean.getOrderSettleTime())) {
            orderListBean.setOrderSettleTime(bean.getOrderSettleTime());
        }

        if (StringUtil.isNotBlank(bean.getOrderVerifyTime())) {
            orderListBean.setOrderVerifyTime(bean.getOrderVerifyTime());
        }

        if (StringUtil.isNotBlank(bean.getOrderReceiveTime())) {
            orderListBean.setOrderReceiveTime(bean.getOrderReceiveTime());

        }

        if (StringUtil.isNotBlank(bean.getOrderPayTime())) {
            orderListBean.setOrderPayTime(bean.getOrderPayTime());
        }

        if (StringUtil.isNotBlank(bean.getPromotionRate())) {
            orderListBean.setPromotionRate(bean.getPromotionRate());
        }

        if (StringUtil.isNotBlank(bean.getOrderAmount())) {
            orderListBean.setOrderAmount((bean.getOrderAmount()));
        }

        if (StringUtil.isNotBlank(bean.getOrderStatus())) {
            orderListBean.setOrderStatus((bean.getOrderStatus()));

        }

        if (StringUtil.isNotBlank(bean.getOrderGroupSuccessTime())) {
            orderListBean
                    .setOrderGroupSuccessTime((bean.getOrderGroupSuccessTime()));
        }

        if (StringUtil.isNotBlank(bean.getOrderModifyAt())) {
            orderListBean.setOrderModifyAt((bean.getOrderModifyAt()));
        }

        if (StringUtil.isNotBlank(bean.getType())) {
            orderListBean.setType((bean.getType()));

        }

        if (StringUtil.isNotBlank(bean.getAuthDuoId())) {
            orderListBean.setAuthDuoId((bean.getAuthDuoId()));

        }

        if (StringUtil.isNotBlank(bean.getOrderVerifyTime())) {
            orderListBean.setOrderVerifyTime((bean.getOrderVerifyTime()));
        }

        if (StringUtil.isNotBlank(bean.getGroupId())) {
            orderListBean.setGroupId((bean.getGroupId()));
        }
        return orderListBean;
    }
}
