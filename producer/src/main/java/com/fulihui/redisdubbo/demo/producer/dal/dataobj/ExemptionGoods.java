package com.fulihui.redisdubbo.demo.producer.dal.dataobj;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ExemptionGoods implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * exemption_goods.id
     * id
     *
     * @mbg.generated 2018-11-16 09:58:16
     */
    private Integer id;
    /**
     * exemption_goods.activity_id
     * 活动id
     *
     * @mbg.generated 2018-11-16 09:58:16
     */
    private Integer activityId;
    /**
     * exemption_goods.goods_id
     * 商品id
     *
     * @mbg.generated 2018-11-16 09:58:16
     */
    private Long goodsId;
    /**
     * exemption_goods.exemption_goods_name
     * 免单商品页标题
     *
     * @mbg.generated 2018-11-16 09:58:16
     */
    private String exemptionGoodsName;
    /**
     * exemption_goods.goods_desc
     * 自定义说明
     *
     * @mbg.generated 2018-11-16 09:58:16
     */
    private String goodsDesc;
    /**
     * exemption_goods.pay_amount
     * 付款金额，单位为分
     *
     * @mbg.generated 2018-11-16 09:58:16
     */
    private Integer payAmount;
    /**
     * exemption_goods.back_amount
     * 返现金额，单位为分
     *
     * @mbg.generated 2018-11-16 09:58:16
     */
    private Integer backAmount;
    /**
     * exemption_goods.exemption_num
     * 免单输量
     *
     * @mbg.generated 2018-11-16 09:58:16
     */
    private Integer exemptionNum;
    /**
     * exemption_goods.state
     * 商品状态 [1:开启][2:关闭][3:不展示]
     *
     * @mbg.generated 2018-11-16 09:58:16
     */
    private Integer state;
    /**
     * exemption_goods.sort
     * 排序
     *
     * @mbg.generated 2018-11-16 09:58:16
     */
    private Integer sort;
    /**
     * exemption_goods.gmt_create
     * 创建时间
     *
     * @mbg.generated 2018-11-16 09:58:16
     */
    private Date gmtCreate;
    /**
     * exemption_goods.gmt_modified
     * 修改时间
     *
     * @mbg.generated 2018-11-16 09:58:16
     */
    private Date gmtModified;
    /**
     * exemption_goods.surplus_num
     * 剩余数量
     *
     * @mbg.generated 2018-11-16 09:58:16
     */
    private Integer surplusNum;
    /**
     * exemption_goods.receive_num
     * 领取数量
     *
     * @mbg.generated 2018-11-16 09:58:16
     */
    private Integer receiveNum;
    /**
     * exemption_goods.order_quantity_num
     * 实时下单数量
     *
     * @mbg.generated 2018-11-16 09:58:16
     */
    private Integer orderQuantityNum;
    /**
     * exemption_goods.gmt_receive
     * 抢单抢完时间,加单更新
     *
     * @mbg.generated 2018-11-16 09:58:16
     */
    private Date gmtReceive;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", activityId=").append(activityId);
        sb.append(", goodsId=").append(goodsId);
        sb.append(", exemptionGoodsName=").append(exemptionGoodsName);
        sb.append(", goodsDesc=").append(goodsDesc);
        sb.append(", payAmount=").append(payAmount);
        sb.append(", backAmount=").append(backAmount);
        sb.append(", exemptionNum=").append(exemptionNum);
        sb.append(", state=").append(state);
        sb.append(", sort=").append(sort);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", gmtModified=").append(gmtModified);
        sb.append(", surplusNum=").append(surplusNum);
        sb.append(", receiveNum=").append(receiveNum);
        sb.append(", orderQuantityNum=").append(orderQuantityNum);
        sb.append(", gmtReceive=").append(gmtReceive);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}