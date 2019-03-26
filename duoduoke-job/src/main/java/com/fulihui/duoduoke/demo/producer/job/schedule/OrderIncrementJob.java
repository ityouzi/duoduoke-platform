package com.fulihui.duoduoke.demo.producer.job.schedule;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import com.fulihui.duoduoke.demo.api.api.OrderInfoService;
import com.fulihui.duoduoke.demo.api.api.promotion.PromotionChannelsService;
import com.fulihui.duoduoke.demo.api.dto.promotion.PromotionChannelsDTO;
import com.fulihui.duoduoke.demo.api.enums.OrderPromoTypeEnum;
import com.fulihui.duoduoke.demo.api.request.OrderInfoTakeAmountRequest;
import com.fulihui.duoduoke.demo.common.config.DuoDuoKeConfig;
import com.fulihui.duoduoke.demo.common.crypto.AESCoder;
import com.fulihui.duoduoke.demo.producer.job.Consts;
import com.fulihui.duoduoke.demo.producer.job.config.AesKeyConfig;
import com.fulihui.duoduoke.demo.producer.job.convert.OrderInfoTakeAmountConvert;
import com.fulihui.duoduoke.demo.producer.job.model.CustomParameters;
import com.fulihui.duoduoke.demo.producer.job.util.DateTimestampUtil;
import com.fulihui.duoduoke.demo.producer.job.util.SignUtil;
import com.fulihui.duoduoke.demo.web.weixin.duoapi.DuoHttpClient;
import com.fulihui.duoduoke.demo.web.weixin.duoapi.request.DuoOrderIncrementRequest;
import com.fulihui.duoduoke.demo.web.weixin.duoapi.result.OrderSnIncrementResult;
import com.fulihui.duoduoke.demo.web.weixin.weixin.util.ClassFieldsUtil;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.near.servicesupport.result.TSingleResult;
import org.near.toolkit.common.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.*;

import static java.lang.String.valueOf;
import static org.near.toolkit.common.DateUtils.*;


/**
 * @author lizhi
 * @date 2018-7-10
 */
@Component
public class OrderIncrementJob implements SimpleJob {
    private static final Logger LOGGER = LoggerFactory
            .getLogger(OrderIncrementJob.class);

    private static final Logger JOB_MONITOR_LOGGER = LoggerFactory
            .getLogger(Consts.LoggerName.JOB_MONITOR);

    @Autowired
    DuoDuoKeConfig duoDuoKeConfig;

    @Autowired
    DuoHttpClient duoHttpClient;

    @org.apache.dubbo.config.annotation.Reference
    OrderInfoService orderInfoService;

    @Autowired
    AesKeyConfig aesKeyConfig;

    @Value("${web.order.mock}")
    private Boolean orderMock;

    @Value("${web.order.url}")
    private String orderUrl;

    @Value("${job.compensate}")
    private Boolean compensate;
    @Value("${job.compensateDay}")
    private Integer compensateDay;
    private volatile boolean running = false;

    @Reference
    PromotionChannelsService promotionChannelsService;

    @Override
    public void execute(ShardingContext shardingContext) {

        LOGGER.info("订单拉取数据开始:{}", formatNewFormat(new Date()));

        LOGGER.info("running:{}", running);
        if (running) {
            LOGGER.warn("running值没改掉");
            return;
        }
        running = true;
        try {
            fetchData();
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        running = false;
        LOGGER.info("running改值成功");
        LOGGER.info("订单拉取数据结束:{}", formatNewFormat(new Date()));

    }

    private Date orderModifyAt;

    void fetchData() {
        int page = 1;
        int pageSize = 100;
        //当前时间
        int totalPage = 1;
        Date now;
        if (compensate) {
            now = addDays(new Date(), compensateDay);
        } else {
            now = new Date();
        }

        Date start = addDays(now, -1);
        if (orderMock) {
            JOB_MONITOR_LOGGER.debug("订单mock,查询一天内数据,时间忽略");
        } else {
            if (orderModifyAt != null) {
                start = orderModifyAt;
            }
        }
        JOB_MONITOR_LOGGER.info("拉取时间最大时间:{},{}", formatNewFormat(start), formatNewFormat(now));

        //从第一页开始获取 //1533720039000 1533720545579
        OrderSnIncrementResult result = getOrderSnIncrementResult(page, pageSize, now, start);

        LOGGER.info("result:{}", JSON.toJSONString(result));
        if (result != null && result.isSuccess()) {
            totalPage = getTotalPage(pageSize, totalPage, result, Boolean.TRUE);
        }

        for (int i = 2; i <= totalPage; i++) {
            result = getOrderSnIncrementResult(i, pageSize, now, start);

            if (result != null && result.isSuccess()) {
                getTotalPage(pageSize, totalPage, result, Boolean.FALSE);
            }
        }
    }

    private int getTotalPage(int pageSize, int totalPage, OrderSnIncrementResult result,
                             boolean isMax) {
        OrderSnIncrementResult.OrderListGetResponseBean getResponse = result.getOrderListGetResponse();
        if (getResponse != null) {
            Integer totalCount = getResponse.getTotalCount();
            totalPage = totalCount % pageSize == 0 ? totalCount / pageSize
                    : totalCount / pageSize + 1;
            totalPage = totalPage > 0 ? totalPage : 1;
            LOGGER.info("总条数:{},总页数:{}", totalCount, totalPage);

            try {
                if (orderMock) {
                    JOB_MONITOR_LOGGER.debug("订单mock,查询一个月数据,不查找最大时间");
                } else {
                    if (isMax) {
                        Optional<OrderSnIncrementResult.OrderListGetResponseBean.OrderListBean> max = getResponse.getOrderList().stream()
                                .max(Comparator.comparing(OrderSnIncrementResult.OrderListGetResponseBean.OrderListBean::getOrderModifyAt));
                        if (max.isPresent()) {
                            orderModifyAt = OrderInfoTakeAmountConvert
                                    .unixToDate(valueOf(max.get().getOrderModifyAt()), newFormat);
                        }
                    }
                }
            } catch (ParseException e) {
                JOB_MONITOR_LOGGER.error(e.getMessage(), e);
                orderModifyAt = addDays(new Date(), -30);
            }
            List<OrderSnIncrementResult.OrderListGetResponseBean.OrderListBean> orderList = getResponse.getOrderList();
            for (OrderSnIncrementResult.OrderListGetResponseBean.OrderListBean bean : orderList) {
                if (bean == null) {
                    continue;
                }

                if (StringUtil.isNotBlank(bean.getCustomParameters())
                        && "-1".equals(bean.getCustomParameters())) {
                    LOGGER.info("抓取订单的接口,如果接口返回自定义参数没有值,忽略该条信息,bean:{}", bean);
                    continue;
                }
                try {

                    if (bean.getCustomParameters().equals(StringUtil.EMPTY_STRING)) {
                        String pid = bean.getPId();
                        TSingleResult<PromotionChannelsDTO> singleResult = promotionChannelsService
                                .queryByPid(pid);
                        boolean b = singleResult != null && singleResult.getValue() != null;
                        if (b) {

                            LOGGER.info("推广位Pid拉取,pid:{}", pid);
                            //订单数据转换request
                            OrderInfoTakeAmountRequest request = OrderInfoTakeAmountConvert
                                    .convertOrderInfoRequest(bean);
                            request.setPromoType(OrderPromoTypeEnum.ORDINARY.getCode());
                            LOGGER.debug("最后更新:{}", formatNewFormat(orderModifyAt));
                            orderInfoService.takeOrderInfoAmount(request);
                        }
                    } else {
                        AESCoder aesCoder = AESCoder.getInstance();
                        //解密
                        String parameters = aesCoder.decryptString(bean.getCustomParameters(),
                                aesKeyConfig.getAesKey());
                        if (StringUtil.isBlank(parameters)) {
                            continue;
                        }
                        //自定义参数
                        CustomParameters object = JSONObject.parseObject(parameters,
                                CustomParameters.class);
                        if (object == null) {
                            continue;
                        }
                        String userId = object.getUserId();
                        bean.setCustomParameters(userId);
                        //订单数据转换request
                        OrderInfoTakeAmountRequest request = OrderInfoTakeAmountConvert
                                .convertOrderInfoRequest(bean);

                        //订单推荐人
                        request.setOrderUserReferee(object.getOrderUserReferee());
                        //订单推广来源
                        if (StringUtil.isNotBlank(object.getOrderSource())) {
                            request.setOrderPromotionSource(object.getOrderSource());
                        }
                        //订单推广的渠道标示
                        if (StringUtil.isNotBlank(object.getChannelsCode())) {
                            request.setChannelsCode(object.getChannelsCode());
                        }
                        LOGGER.debug("最后更新:{}", formatNewFormat(orderModifyAt));

                        request.setPromoType(OrderPromoTypeEnum.ORDINARY.getCode());

                        orderInfoService.takeOrderInfoAmount(request);
                    }
                } catch (Exception e) {
                    LOGGER.error(e.getMessage(), e);
                }
            }
        }
        return totalPage;
    }

    private OrderSnIncrementResult getOrderSnIncrementResult(int page, int pageSize, Date now,
                                                             Date start) {

        //如果mock
        if (orderMock) {
            try {
                CloseableHttpClient httpClient = HttpClients.createDefault();
                String url = String.format(orderUrl, "Promotion");
                LOGGER.info(url);
                URIBuilder builder = new URIBuilder(url);
                builder.addParameter("page", page + "");
                builder.addParameter("rows", pageSize + "");
                builder.addParameter("startUpdateTime", formatNewFormat(start));
                builder.addParameter("endUpdateTime", formatNewFormat(now));
                HttpPost post = new HttpPost(builder.build());
                HttpResponse response = httpClient.execute(post);
                HttpEntity entity = response.getEntity();
                String respStr = EntityUtils.toString(entity);
                LOGGER.info("success Response: {}", respStr);
                OrderSnIncrementResult result = JSONObject.parseObject(respStr,
                        OrderSnIncrementResult.class);
                result.setSuccess(StringUtil.isBlank(result.getError_code())
                        || StringUtil.isBlank(result.getError_msg()));
                return result;
            } catch (URISyntaxException | IOException e) {
                e.printStackTrace();
            }

        }

        DuoOrderIncrementRequest request = new DuoOrderIncrementRequest();
        request.setPage(page);
        request.setPage_size(pageSize);
        request.setType("pdd.ddk.order.list.increment.get");
        request.setClient_id(duoDuoKeConfig.getClientId());
        request.setTimestamp(System.currentTimeMillis() + "");
        request.setReturn_count(true);
        request.setEnd_update_time(DateTimestampUtil.getSecondTimestamp(now));
        request.setStart_update_time(DateTimestampUtil.getSecondTimestamp(start));
        Map<String, Object> strValMap = ClassFieldsUtil.obj2StrValMap(request);
        String sign = SignUtil.genServiceSign(ClassFieldsUtil.obj2StrVal(request), strValMap,
                duoDuoKeConfig.getClientSecret());
        request.setSign(sign);
        return duoHttpClient.invokeService(request);
    }

    public static void main(String[] args) {

        String parameters = "";
        System.out.println(StringUtil.isNotBlank(parameters));
        CustomParameters object = JSONObject.parseObject(parameters, CustomParameters.class);
        System.out.println(object);
    }
}
