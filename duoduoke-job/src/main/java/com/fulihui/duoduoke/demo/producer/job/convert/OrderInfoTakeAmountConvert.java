package com.fulihui.duoduoke.demo.producer.job.convert;

import static java.lang.String.valueOf;
import static org.near.toolkit.common.DateUtils.newFormat;
import static org.near.toolkit.common.DateUtils.parseNewFormat;
import static org.near.toolkit.common.EnumUtil.queryByCode;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import com.fulihui.duoduoke.demo.api.enums.DuoDuoOrderStatusEnum;
import com.fulihui.duoduoke.demo.api.enums.UserOrderStatusEnum;
import com.fulihui.duoduoke.demo.api.request.OrderInfoTakeAmountRequest;
import com.fulihui.duoduoke.demo.web.weixin.duoapi.result.OrderSnIncrementResult;
import org.apache.http.util.TextUtils;



/**
 * @author wahaha
 */
public class  OrderInfoTakeAmountConvert {
    /**
     * uinx  时间戳转换成时间
     *
     * @param timestampString
     * @param formats
     * @return
     * @throws ParseException
     */
    public static  Date unixToDate(String timestampString, String formats) throws ParseException {
        if (TextUtils.isEmpty(formats)) {
            formats = "yyyy-MM-dd HH:mm:ss";
        }

        Long timestamp = Long.parseLong(timestampString) * 1000;
        String format = new SimpleDateFormat(formats, Locale.CHINA).format(new Date(timestamp));
        return parseNewFormat(format);
    }


    public static OrderInfoTakeAmountRequest convertOrderInfoRequest(OrderSnIncrementResult.OrderListGetResponseBean.OrderListBean bean) throws ParseException {
        OrderInfoTakeAmountRequest info = new OrderInfoTakeAmountRequest();
        info.setOrderSn(bean.getOrder_sn());
        info.setOrderAmount(bean.getOrder_amount());
        if (bean.getOrder_create_time() != null) {
            Date orderCreateTime = unixToDate(valueOf(bean.getOrder_create_time()), newFormat);
            info.setOrderCreateTime(orderCreateTime);
        }

        if (bean.getOrder_receive_time() != null) {
            Date orderReceiveTime = unixToDate(valueOf(bean.getOrder_receive_time()), newFormat);
            info.setOrderReceiveTime(orderReceiveTime);
        }

        if (bean.getOrder_verify_time() != null) {
            Date orderVerifyTime = unixToDate(valueOf(bean.getOrder_verify_time()), newFormat);
            info.setOrderVerifyTime(orderVerifyTime);
        }
        if (bean.getOrder_modify_at() != null) {
            Date orderModifyAt = unixToDate(valueOf(bean.getOrder_modify_at()), newFormat);
            info.setOrderModifyAt(orderModifyAt);
        }
        if (bean.getOrder_group_success_time() != null) {
            Date orderGroupSuccessTime = unixToDate(valueOf(bean.getOrder_group_success_time()),
                    newFormat);
            info.setOrderGroupSuccessTime(orderGroupSuccessTime);
        }
        if (bean.getOrder_pay_time() != null) {
            Date orderPayTime = unixToDate(valueOf(bean.getOrder_pay_time()), newFormat);
            info.setOrderPayTime(orderPayTime);
        }
        info.setAuthDuoId(valueOf(bean.getAuth_duo_id()));
        info.setBatchNo(bean.getBatch_no());
        info.setCustomParameters(bean.getCustom_parameters());
        info.setGoodsId(bean.getGoods_id());
        info.setGoodsName(bean.getGoods_name());
        info.setStatus(bean.getStatus());
        info.setGoodsPrice(bean.getGoods_price());
        info.setGoodsQuantity(bean.getGoods_quantity());
        info.setGoodsThumbnailUrl(bean.getGoods_thumbnail_url());
        info.setType(valueOf(bean.getType()));
        info.setPId(bean.getP_id());
        info.setGroupId(valueOf(bean.getGroup_id()));
        String orderStatus = valueOf(bean.getOrder_status());
        info.setOrderStatus(orderStatus);
        info.setOrderStatusDesc(bean.getOrder_status_desc());
        info.setPromotionAmount(bean.getPromotion_amount());
        info.setPromotionRate(bean.getPromotion_rate());
        DuoDuoOrderStatusEnum staEnum = queryByCode(orderStatus, DuoDuoOrderStatusEnum.class);
        UserOrderStatusEnum uStatus = queryByCode(staEnum.getUserOrderStatus(),
                UserOrderStatusEnum.class);
        info.setUserOrderStatus(uStatus.getCode());
        info.setUserOrderStatusDesc(uStatus.getDesc());

        return info;
    }

}
