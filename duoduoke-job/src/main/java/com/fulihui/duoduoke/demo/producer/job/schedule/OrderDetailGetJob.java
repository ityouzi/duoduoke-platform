package com.fulihui.duoduoke.demo.producer.job.schedule;

import static com.google.common.collect.Lists.newArrayList;
import static org.near.servicesupport.util.ServiceResultUtil.checkResult;
import static org.near.toolkit.common.StringUtil.isBlank;

import java.util.List;
import java.util.Map;

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

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;


/**
 * @author wahaha
 */
public class OrderDetailGetJob implements SimpleJob {

    private static final Logger LOGGER  = LoggerFactory.getLogger(OrderDetailGetJob.class);

    private volatile boolean    running = false;
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
                    if (duoResult != null && duoResult.getOrder_detail_response() != null) {
                        DuoOrderDetailGetResult.OrderDetailResponseBean bean = duoResult
                            .getOrder_detail_response();
                        if (isBlank(bean.getCustom_parameters())) {
                            LOGGER.info("抓取订单的接口,如果接口返回自定义参数没有值,忽略该条信息,bean:{}", bean);
                            continue;
                        }
                        if ("-1".equals(bean.getCustom_parameters())) {
                            LOGGER.info("抓取订单的接口,如果接口返回自定义参数没有值,忽略该条信息,bean:{}", bean);
                            continue;
                        }
                        try {
                            AESCoder aesCoder = AESCoder.getInstance();

                            String parameters = aesCoder.decryptString(bean.getCustom_parameters(),
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
                            bean.setCustom_parameters(userId);
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

        orderListBean.setOrder_sn(bean.getOrder_sn());
        orderListBean.setGoods_id(bean.getGoods_id());
        orderListBean.setGoods_name(bean.getGoods_name());
        orderListBean.setGoods_thumbnail_url(bean.getGoods_thumbnail_url());
        orderListBean.setBatch_no(bean.getBatch_no());
        orderListBean.setOrder_status_desc(bean.getOrder_status_desc());
        orderListBean.setCustom_parameters(bean.getCustom_parameters());
        orderListBean.setP_id(bean.getPid());

        if (StringUtil.isNotBlank(bean.getGoods_quantity())) {
            orderListBean.setGoods_quantity(Integer.valueOf(bean.getGoods_quantity()));
        }

        if (StringUtil.isNotBlank(bean.getGoods_price())) {
            orderListBean.setGoods_price(Integer.valueOf(bean.getGoods_price()));

        }

        if (StringUtil.isNotBlank(bean.getOrder_amount())) {
            orderListBean.setOrder_amount(Integer.valueOf(bean.getOrder_amount()));

        }
        if (StringUtil.isNotBlank(bean.getOrder_create_time())) {
            orderListBean.setOrder_create_time(Integer.valueOf(bean.getOrder_create_time()));

        }
        if (StringUtil.isNotBlank(bean.getOrder_settle_time())) {
            orderListBean.setOrder_settle_time(Integer.valueOf(bean.getOrder_settle_time()));
        }

        if (StringUtil.isNotBlank(bean.getOrder_verify_time())) {
            orderListBean.setOrder_verify_time(Integer.valueOf(bean.getOrder_verify_time()));
        }

        if (StringUtil.isNotBlank(bean.getOrder_receive_time())) {
            orderListBean.setOrder_receive_time(Integer.valueOf(bean.getOrder_receive_time()));

        }

        if (StringUtil.isNotBlank(bean.getOrder_pay_time())) {
            orderListBean.setOrder_pay_time(Integer.valueOf(bean.getOrder_pay_time()));
        }

        if (StringUtil.isNotBlank(bean.getPromotion_rate())) {
            orderListBean.setPromotion_rate(Integer.valueOf(bean.getPromotion_rate()));
        }

        if (StringUtil.isNotBlank(bean.getPromotion_amount())) {
            orderListBean.setPromotion_amount(Integer.valueOf(bean.getPromotion_amount()));
        }

        if (StringUtil.isNotBlank(bean.getOrder_status())) {
            orderListBean.setOrder_status(Integer.valueOf(bean.getOrder_status()));

        }

        if (StringUtil.isNotBlank(bean.getOrder_group_success_time())) {
            orderListBean
                .setOrder_group_success_time(Integer.valueOf(bean.getOrder_group_success_time()));
        }

        if (StringUtil.isNotBlank(bean.getOrder_modify_at())) {
            orderListBean.setOrder_modify_at(Integer.valueOf(bean.getOrder_modify_at()));
        }

        if (StringUtil.isNotBlank(bean.getType())) {
            orderListBean.setType(Integer.valueOf(bean.getType()));

        }

        if (StringUtil.isNotBlank(bean.getAuth_duo_id())) {
            orderListBean.setAuth_duo_id(Integer.valueOf(bean.getAuth_duo_id()));

        }

        if (StringUtil.isNotBlank(bean.getOrder_verify_time())) {
            orderListBean.setVerify_time(Long.valueOf(bean.getOrder_verify_time()));
        }

        if (StringUtil.isNotBlank(bean.getGroup_id())) {
            orderListBean.setGroup_id(Long.valueOf(bean.getGroup_id()));
        }
        return orderListBean;
    }
}
