package com.fulihui.duoduoke.demo.producer.dal.dataobj;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class UserExemptionGoods implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * user_exemption_goods.id
     * id
     *
     * @mbg.generated 2018-11-19 15:18:26
     */
    private Integer id;
    /**
     * user_exemption_goods.activity_id
     * 活动id
     *
     * @mbg.generated 2018-11-19 15:18:26
     */
    private Integer activityId;
    /**
     * user_exemption_goods.goods_id
     * 商品id
     *
     * @mbg.generated 2018-11-19 15:18:26
     */
    private Long goodsId;
    /**
     * user_exemption_goods.user_id
     * 用户唯一标识
     *
     * @mbg.generated 2018-11-19 15:18:26
     */
    private String userId;
    /**
     * user_exemption_goods.pay_amount
     * 付款金额，单位为分
     *
     * @mbg.generated 2018-11-19 15:18:26
     */
    private Integer payAmount;
    /**
     * user_exemption_goods.back_amount
     * 返现金额，单位为分
     *
     * @mbg.generated 2018-11-19 15:18:26
     */
    private Integer backAmount;
    /**
     * user_exemption_goods.state
     * 状态 [1:未使用][2:已使用][3:过期失效][4:已结算]
     *
     * @mbg.generated 2018-11-19 15:18:26
     */
    private String state;
    private List<String> states;
    /**
     * user_exemption_goods.order_sn
     * 推广订单编号
     *
     * @mbg.generated 2018-11-19 15:18:26
     */
    private String orderSn;
    /**
     * user_exemption_goods.gmt_create
     * 创建时间
     *
     * @mbg.generated 2018-11-19 15:18:26
     */
    private Date gmtCreate;
    /**
     * user_exemption_goods.gmt_modified
     * 修改时间
     *
     * @mbg.generated 2018-11-19 15:18:26
     */
    private Date gmtModified;
    /**
     * user_exemption_goods.bind_order_status
     * 绑定的订单状态
     *
     * @mbg.generated 2018-11-19 15:18:26
     */
    private String bindOrderStatus;
    /**
     * user_exemption_goods.exemption_goods_id
     *
     * @mbg.generated 2018-11-19 15:18:26
     */
    private Integer exemptionGoodsId;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", activityId=").append(activityId);
        sb.append(", goodsId=").append(goodsId);
        sb.append(", userId=").append(userId);
        sb.append(", payAmount=").append(payAmount);
        sb.append(", backAmount=").append(backAmount);
        sb.append(", state=").append(state);
        sb.append(", orderSn=").append(orderSn);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", gmtModified=").append(gmtModified);
        sb.append(", bindOrderStatus=").append(bindOrderStatus);
        sb.append(", exemptionGoodsId=").append(exemptionGoodsId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}