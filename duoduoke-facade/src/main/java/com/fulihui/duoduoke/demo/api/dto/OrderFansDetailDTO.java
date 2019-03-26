package com.fulihui.duoduoke.demo.api.dto;

import lombok.Getter;
import lombok.Setter;
import org.near.toolkit.model.ToString;

import java.util.Date;

/**
 * @author lizhi
 * @date 2018-8-1*/
@Setter
@Getter
public class OrderFansDetailDTO extends ToString {

  private static final long serialVersionUID = -5635939755634122179L;
  /**
   * order_fans_detail.id
   *
   * @mbg.generated 2018-08-01 14:38:16
   */
  private Integer id;

  /**
   * order_fans_detail.orderSn
   *
   * @mbg.generated 2018-08-01 14:38:16
   */
  private String orderSn;

  /**
   * order_fans_detail.user_id
   *
   * @mbg.generated 2018-08-01 14:38:16
   */
  private String userId;

  /**
   * order_fans_detail.p_user_id
   *
   * @mbg.generated 2018-08-01 14:38:16
   */
  private String pUserId;

  /**
   * order_fans_detail.fans_amount
   *
   * @mbg.generated 2018-08-01 14:38:16
   */
  private Integer fansAmount;

  /**
   * order_fans_detail.level
   *
   * @mbg.generated 2018-08-01 14:38:16
   */
  private Integer level;

  /** @mbg.generated 2018-08-01 14:38:16 */
  private Date gmtCreate;

  /** @mbg.generated 2018-08-01 14:38:16 */
  private Date gmtModified;

  /**
   * order_fans_detail.order_status 状态
   *
   * @mbg.generated 2018-08-01 14:38:16
   */
  private String orderStatus;

  private String orderStatusDesc;

  /**
   * order_fans_detail.fans_type 订单粉丝类型
   *
   * @mbg.generated 2018-08-01 14:38:16
   */
  private String fansType;
  /** */
  private Date orderCreateTime;

  /**
   * order_fans_detail.proportion_snapshot 比例快照
   *
   * @mbg.generated 2018-08-02 12:25:17
   */
  private Integer proportionSnapshot;
}
