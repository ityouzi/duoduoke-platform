package com.fulihui.duoduoke.demo.api.dto;

import lombok.Getter;
import lombok.Setter;
import org.near.toolkit.model.ToString;

/**
 * @author: JY
 * @date: 2018/8/22 14:39 优选商品拉取
 */
@Setter
@Getter
public class GoodOptimizationDTO extends ToString {

  /** 佣金比率 */
  private Integer promotionRate;

  /** 是否有优惠券 */
  private String hasCoupon;

  /** 销量 */
  private Integer soldQuantity;

  /** 总条数 */
  private Integer count;
}
