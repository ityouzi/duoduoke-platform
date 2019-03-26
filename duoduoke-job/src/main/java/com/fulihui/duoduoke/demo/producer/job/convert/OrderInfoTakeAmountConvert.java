package com.fulihui.duoduoke.demo.producer.job.convert;

import com.fulihui.duoduoke.demo.api.enums.DuoDuoOrderStatusEnum;
import com.fulihui.duoduoke.demo.api.enums.UserOrderStatusEnum;
import com.fulihui.duoduoke.demo.api.request.OrderInfoTakeAmountRequest;
import com.fulihui.duoduoke.demo.web.weixin.duoapi.result.OrderSnIncrementResult;
import org.apache.http.util.TextUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static java.lang.String.valueOf;
import static org.near.toolkit.common.DateUtils.newFormat;
import static org.near.toolkit.common.DateUtils.parseNewFormat;
import static org.near.toolkit.common.EnumUtil.queryByCode;


/**
 * @author wahaha
 */
public class OrderInfoTakeAmountConvert {
    /**
     * uinx  时间戳转换成时间
     *
     * @param timestampString
     * @param formats
     * @return
     * @throws ParseException
     */
    public static Date unixToDate(String timestampString, String formats) throws ParseException {
        if (TextUtils.isEmpty(formats)) {
            formats = "yyyy-MM-dd HH:mm:ss";
        }

        Long timestamp = Long.parseLong(timestampString) * 1000;
        String format = new SimpleDateFormat(formats, Locale.CHINA).format(new Date(timestamp));
        return parseNewFormat(format);
    }


    public static OrderInfoTakeAmountRequest convertOrderInfoRequest(OrderSnIncrementResult.OrderListGetResponseBean.OrderListBean bean) throws ParseException {
        OrderInfoTakeAmountRequest info = new OrderInfoTakeAmountRequest();
        info.setOrderSn(bean.getOrderSn());
        info.setOrderAmount(Integer.valueOf(bean.getOrderAmount()));
        if (bean.getOrderCreateTime() != null) {
            Date orderCreateTime = unixToDate(bean.getOrderCreateTime(), newFormat);
            info.setOrderCreateTime(orderCreateTime);
        }

        if (bean.getOrderReceiveTime() != null) {
            Date orderReceiveTime = unixToDate(bean.getOrderReceiveTime(), newFormat);
            info.setOrderReceiveTime(orderReceiveTime);
        }

        if (bean.getOrderVerifyTime() != null) {
            Date orderVerifyTime = unixToDate(bean.getOrderVerifyTime(), newFormat);
            info.setOrderVerifyTime(orderVerifyTime);
        }
        if (bean.getOrderModifyAt() != null) {
            Date orderModifyAt = unixToDate(bean.getOrderModifyAt(), newFormat);
            info.setOrderModifyAt(orderModifyAt);
        }
        if (bean.getOrderGroupSuccessTime() != null) {
            Date orderGroupSuccessTime = unixToDate(bean.getOrderGroupSuccessTime(),
                    newFormat);
            info.setOrderGroupSuccessTime(orderGroupSuccessTime);
        }
        if (bean.getOrderPayTime() != null) {
            Date orderPayTime = unixToDate(bean.getOrderPayTime(), newFormat);
            info.setOrderPayTime(orderPayTime);
        }
        info.setAuthDuoId(bean.getAuthDuoId());
        info.setBatchNo(bean.getBatchNo());
        info.setCustomParameters(bean.getCustomParameters());
        info.setGoodsId(bean.getGoodsId());
        info.setGoodsName(bean.getGoodsName());
        info.setStatus(bean.getStatus());


        info.setGoodsPrice(Integer.valueOf(bean.getGoodsPrice()));
        info.setGoodsQuantity(Integer.valueOf(bean.getGoodsQuantity()));
        info.setGoodsThumbnailUrl(bean.getGoodsThumbnailUrl());
        info.setType(valueOf(bean.getType()));
        info.setPId(bean.getPId());
        info.setGroupId(valueOf(bean.getGroupId()));
        String orderStatus = valueOf(bean.getOrderStatus());
        info.setOrderStatus(orderStatus);
        info.setOrderStatusDesc(bean.getOrderStatusDesc());
        info.setPromotionAmount(Integer.valueOf(bean.getPromotionAmount()));
        info.setPromotionRate(Integer.valueOf(bean.getPromotionRate()));
        DuoDuoOrderStatusEnum staEnum = queryByCode(orderStatus, DuoDuoOrderStatusEnum.class);
        UserOrderStatusEnum uStatus = queryByCode(staEnum.getUserOrderStatus(),
                UserOrderStatusEnum.class);
        info.setUserOrderStatus(uStatus.getCode());
        info.setUserOrderStatusDesc(uStatus.getDesc());

        return info;
    }

}
