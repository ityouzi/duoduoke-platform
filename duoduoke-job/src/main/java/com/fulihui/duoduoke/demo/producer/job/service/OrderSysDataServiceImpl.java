package com.fulihui.duoduoke.demo.producer.job.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fulihui.duoduoke.demo.api.api.OrderInfoService;
import com.fulihui.duoduoke.demo.api.api.job.OrderSysDataService;
import com.fulihui.duoduoke.demo.api.api.promotion.PromotionChannelsService;
import com.fulihui.duoduoke.demo.api.dto.promotion.PromotionChannelsDTO;
import com.fulihui.duoduoke.demo.api.enums.OrderPromoTypeEnum;
import com.fulihui.duoduoke.demo.api.request.OrderInfoTakeAmountRequest;
import com.fulihui.duoduoke.demo.common.config.DuoDuoKeConfig;
import com.fulihui.duoduoke.demo.common.crypto.AESCoder;
import com.fulihui.duoduoke.demo.producer.job.convert.OrderInfoTakeAmountConvert;
import com.fulihui.duoduoke.demo.web.weixin.duoapi.DuoHttpClient;
import com.fulihui.duoduoke.demo.web.weixin.duoapi.request.OrderColorIncrementRequest;
import com.fulihui.duoduoke.demo.web.weixin.duoapi.result.OrderColorIncrementResult;
import com.fulihui.duoduoke.demo.web.weixin.duoapi.result.OrderSnIncrementResult;
import com.fulihui.duoduoke.demo.web.weixin.weixin.util.ClassFieldsUtil;
import com.fulihui.duoduoke.demo.producer.job.Consts;
import com.fulihui.duoduoke.demo.producer.job.config.AesKeyConfig;
import com.fulihui.duoduoke.demo.producer.job.model.CustomParameters;
import com.fulihui.duoduoke.demo.producer.job.util.DateTimestampUtil;
import org.apache.dubbo.config.annotation.Service;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.near.servicesupport.result.TSingleResult;
import org.near.toolkit.common.DateUtils;
import org.near.toolkit.common.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.*;

import static com.fulihui.duoduoke.demo.producer.job.util.SignUtil.genServiceSign;
import static java.lang.String.valueOf;
import static org.near.toolkit.common.DateUtils.*;


/**
 * @author wahaha
 */
@Service(version = "${demo.service.version}")
public class OrderSysDataServiceImpl implements OrderSysDataService {

    private static final Logger JOB_MONITOR_LOGGER = LoggerFactory
            .getLogger(Consts.LoggerName.JOB_MONITOR);
    private static final Logger LOGGER = LoggerFactory
            .getLogger(OrderSysDataServiceImpl.class);

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
    private Date orderModifyAt;

    @org.apache.dubbo.config.annotation.Reference
    private PromotionChannelsService promotionChannelsService;

    @Override
    public void fetchColor(Date date, boolean ignoreModifyAt) {
        int page = 1;
        int pageSize = 100;
        //当前时间
        int totalPage = 1;
        Date now;
        if (compensate) {
            now = DateUtils.addDays(date, compensateDay);
        } else {
            now = date;
        }
        JOB_MONITOR_LOGGER.info("fetchColor:{}", DateUtils.formatNewFormat(now));
        Date start = addDays(now, -1);
        if (orderMock) {
            JOB_MONITOR_LOGGER.debug("订单mock,查询一天内数据,时间忽略");
        } else {
            if (orderModifyAt != null && ignoreModifyAt) {
                // start = orderModifyAt;
            }
        }
        JOB_MONITOR_LOGGER.info("拉取时间最大时间:{},{}", formatNewFormat(start), formatNewFormat(now));

        //从第一页开始获取 //1533720039000 1533720545579
        OrderColorIncrementResult result = getOrderSnIncrementResult(page, pageSize, now, start);

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

    private int getTotalPage(int pageSize, int totalPage, OrderColorIncrementResult result,
                             boolean isMax) {
        OrderColorIncrementResult.OrderListGetResponseBean getResponse = result
                .getOrder_list_get_response();
        if (getResponse != null) {
            Integer totalCount = getResponse.getTotal_count();
            totalPage = totalCount % pageSize == 0 ? totalCount / pageSize
                    : totalCount / pageSize + 1;
            totalPage = totalPage > 0 ? totalPage : 1;
            LOGGER.info("总条数:{},总页数:{}", totalCount, totalPage);

            try {
                if (orderMock) {
                    JOB_MONITOR_LOGGER.debug("订单mock,查询一个月数据,不查找最大时间");
                } else {
                    if (isMax) {

                        List<OrderColorIncrementResult.OrderListGetResponseBean.OrderListBean> orderList = getResponse
                                .getOrder_list();
                        Optional<OrderColorIncrementResult.OrderListGetResponseBean.OrderListBean> max = orderList
                                .stream().max(Comparator.comparing(
                                        OrderColorIncrementResult.OrderListGetResponseBean.OrderListBean::getOrder_modify_at));
                        if (max.isPresent()) {
                            orderModifyAt = OrderInfoTakeAmountConvert
                                    .unixToDate(valueOf(max.get().getOrder_modify_at()), newFormat);
                        }
                    }
                }
            } catch (ParseException e) {
                JOB_MONITOR_LOGGER.error(e.getMessage(), e);
                orderModifyAt = addDays(new Date(), -1);
            }
            List<OrderColorIncrementResult.OrderListGetResponseBean.OrderListBean> orderList = getResponse
                    .getOrder_list();
            for (OrderColorIncrementResult.OrderListGetResponseBean.OrderListBean bean : orderList) {
                if (bean == null) {
                    continue;
                }
                OrderSnIncrementResult.OrderListGetResponseBean.OrderListBean listBean = new OrderSnIncrementResult.OrderListGetResponseBean.OrderListBean();
                BeanUtils.copyProperties(bean, listBean);

                try {
                    String customParameters = listBean.getCustom_parameters();
                    if ((StringUtil.isNotBlank(customParameters) && "-1".equals(customParameters))
                            || (customParameters.equals(StringUtil.EMPTY_STRING))
                            || (StringUtil.isBlank(customParameters))) {
                        String pid = listBean.getP_id();
                        TSingleResult<PromotionChannelsDTO> singleResult = promotionChannelsService
                                .queryByPid(pid);
                        boolean b = singleResult != null && singleResult.getValue() != null;
                        if (b) {
                            LOGGER.info("推广位Pid拉取,pid:{}", pid);
                            //订单数据转换request
                            OrderInfoTakeAmountRequest request = OrderInfoTakeAmountConvert
                                    .convertOrderInfoRequest(listBean);
                            //染色
                            request.setPromoType(OrderPromoTypeEnum.DYEING.getCode());
                            LOGGER.debug("最后更新:{}", formatNewFormat(orderModifyAt));
                            orderInfoService.takeOrderInfoAmount(request);
                        } else {
                            OrderInfoTakeAmountRequest request = OrderInfoTakeAmountConvert
                                    .convertOrderInfoRequest(listBean);
                            //染色
                            request.setPromoType(OrderPromoTypeEnum.DYEING.getCode());
                            LOGGER.debug("最后更新:{}", formatNewFormat(orderModifyAt));
                            request.setLanding(Boolean.TRUE);
                            orderInfoService.takeOrderInfoAmount(request);

                        }
                    } else {
                        AESCoder aesCoder = AESCoder.getInstance();
                        //解密
                        String parameters = aesCoder.decryptString(listBean.getCustom_parameters(),
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
                        listBean.setCustom_parameters(userId);
                        //订单数据转换request
                        OrderInfoTakeAmountRequest request = OrderInfoTakeAmountConvert
                                .convertOrderInfoRequest(listBean);

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

                        //染色
                        request.setPromoType(OrderPromoTypeEnum.DYEING.getCode());
                        orderInfoService.takeOrderInfoAmount(request);
                    }
                } catch (Exception e) {
                    LOGGER.error(e.getMessage(), e);
                }
            }
        }
        return totalPage;
    }

    public static void main(String[] args) {
        AESCoder aesCoder = AESCoder.getInstance();
        String s = "UmT6iPgpxU9TLdPWGfsTs7tffoY0R_IfKYCmBvCNvArDhdksFsXDXVyiefMlHgy6vFiTIuWMUYA5jkuYH40yBhppJJIkqF_0zVl4iW0CMtxInGE-i-1kB-Azcs1e4aknOcuqUYCWHI94148CLALkaQ";
        String parameters = aesCoder.decryptString(s, "oLhMH2xotVCzK7d8urGzeA==");
        System.out.println(parameters);
    }

    private OrderColorIncrementResult getOrderSnIncrementResult(int page, int pageSize, Date now,
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
                OrderColorIncrementResult result = JSONObject.parseObject(respStr,
                        OrderColorIncrementResult.class);
                result.setSuccess(StringUtil.isBlank(result.getError_code())
                        || StringUtil.isBlank(result.getError_msg()));
                return result;
            } catch (URISyntaxException | IOException e) {
                e.printStackTrace();
            }

        }

        OrderColorIncrementRequest request = new OrderColorIncrementRequest();
        request.setPage(page);
        request.setPage_size(pageSize);
        request.setType("pdd.ddk.color.order.increment.get");
        request.setClient_id(duoDuoKeConfig.getClientId());
        request.setTimestamp(System.currentTimeMillis() + "");
        request.setReturn_count(true);
        request.setEnd_update_time(DateTimestampUtil.getSecondTimestamp(now));
        request.setStart_update_time(DateTimestampUtil.getSecondTimestamp(start));
        Map<String, Object> strValMap = ClassFieldsUtil.obj2StrValMap(request);
        String sign = genServiceSign(ClassFieldsUtil.obj2StrVal(request), strValMap,
                duoDuoKeConfig.getClientSecret());
        request.setSign(sign);
        return duoHttpClient.invokeService(request);
    }
}
