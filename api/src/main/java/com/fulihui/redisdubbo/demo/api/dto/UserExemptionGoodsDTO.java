package com.fulihui.redisdubbo.demo.api.dto;

import lombok.Data;
import org.near.toolkit.model.ToString;

import java.util.Date;
import java.util.List;

@Data
public class UserExemptionGoodsDTO extends ToString {
    /**
    *
    *
    * user_exemption_goods.id
     * id
     *
     * @mbg.generated 2018-11-14 13:50:38
     */
    private Integer           id;

    /**
    *
    *
    * user_exemption_goods.activity_id
     * 活动id
     *
     * @mbg.generated 2018-11-14 13:50:38
     */
    private Integer           activityId;

    /**
    *
    *
    * user_exemption_goods.goods_id
     * 商品id
     *
     * @mbg.generated 2018-11-14 13:50:38
     */
    private Long              goodsId;

    /**
    *
    *
    * user_exemption_goods.user_id
     * 用户唯一标识
     *
     * @mbg.generated 2018-11-14 13:50:38
     */
    private String            userId;

    /**
    *
    *
    * user_exemption_goods.pay_amount
     * 付款金额，单位为分
     *
     * @mbg.generated 2018-11-14 13:50:38
     */
    private Integer           payAmount;

    /**
    *
    *
    * user_exemption_goods.back_amount
     * 返现金额，单位为分
     *
     * @mbg.generated 2018-11-14 13:50:38
     */
    private Integer           backAmount;

    /**
    *
    *
    * user_exemption_goods.state
     * 状态 [1:未使用][2:已使用][3:过期失效]
     *
     * @mbg.generated 2018-11-14 13:50:38
     */
    private String            state;

    //查询使用集合
    private List<String>      states;

    /**
    *
    *
    * user_exemption_goods.order_sn
     * 推广订单编号
     *
     * @mbg.generated 2018-11-14 13:50:38
     */
    private String            orderSn;

    /**
    *
    *
    * user_exemption_goods.gmt_create
     * 创建时间
     *
     * @mbg.generated 2018-11-14 13:50:38
     */
    private Date              gmtCreate;

    /**
    *
    *
    * user_exemption_goods.gmt_modified
     * 修改时间
     *
     * @mbg.generated 2018-11-14 13:50:38
     */
    private Date              gmtModified;

    private Integer exemptionGoodsId;


    private static final long serialVersionUID = 1L;

}