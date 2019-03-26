package com.fulihui.duoduoke.demo.producer.dal.dataobj;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
public class OrderFansDetail implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * order_fans_detail.id
     *
     * @mbg.generated 2018-08-22 13:53:38
     */
    private Integer id;
    /**
     * order_fans_detail.orderSn
     * 订单号
     *
     * @mbg.generated 2018-08-22 13:53:38
     */
    private String orderSn;
    /**
     * order_fans_detail.user_id
     * 用户id
     *
     * @mbg.generated 2018-08-22 13:53:38
     */
    private String userId;
    /**
     * order_fans_detail.p_user_id
     * 返利的用户id
     *
     * @mbg.generated 2018-08-22 13:53:38
     */
    private String pUserId;
    /**
     * order_fans_detail.fans_amount
     *
     * @mbg.generated 2018-08-22 13:53:38
     */
    private Integer fansAmount;
    /**
     * order_fans_detail.level
     *
     * @mbg.generated 2018-08-22 13:53:38
     */
    private Integer level;
    /**
     * order_fans_detail.gmt_create
     * 创建时间
     *
     * @mbg.generated 2018-08-22 13:53:38
     */
    private Date gmtCreate;
    /**
     * order_fans_detail.gmt_modified
     * 修改时间
     *
     * @mbg.generated 2018-08-22 13:53:38
     */
    private Date gmtModified;
    /**
     * order_fans_detail.order_status
     * 状态
     *
     * @mbg.generated 2018-08-22 13:53:38
     */
    private String orderStatus;
    /**
     * order_fans_detail.order_status_desc
     *
     * @mbg.generated 2018-08-22 13:53:38
     */
    private String orderStatusDesc;
    /**
     * order_fans_detail.fans_type
     * 订单粉丝类型
     *
     * @mbg.generated 2018-08-22 13:53:38
     */
    private String fansType;
    /**
     * order_fans_detail.order_create_time
     * 订单生成时间
     *
     * @mbg.generated 2018-08-22 13:53:38
     */
    private Date orderCreateTime;
    /**
     * order_fans_detail.proportion_snapshot
     * 比例快照
     *
     * @mbg.generated 2018-08-22 13:53:38
     */
    private Integer proportionSnapshot;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", orderSn=").append(orderSn);
        sb.append(", userId=").append(userId);
        sb.append(", pUserId=").append(pUserId);
        sb.append(", fansAmount=").append(fansAmount);
        sb.append(", level=").append(level);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", gmtModified=").append(gmtModified);
        sb.append(", orderStatus=").append(orderStatus);
        sb.append(", orderStatusDesc=").append(orderStatusDesc);
        sb.append(", fansType=").append(fansType);
        sb.append(", orderCreateTime=").append(orderCreateTime);
        sb.append(", proportionSnapshot=").append(proportionSnapshot);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}