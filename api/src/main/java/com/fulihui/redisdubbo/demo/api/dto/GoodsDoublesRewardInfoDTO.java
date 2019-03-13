package com.fulihui.redisdubbo.demo.api.dto;

import lombok.Getter;
import lombok.Setter;
import org.near.toolkit.model.ToString;

import java.util.Date;

@Setter
@Getter
public class GoodsDoublesRewardInfoDTO extends ToString {


    /**
     *
     *
     * goods_doubles_reward.id

     *
     * @mbg.generated 2018-09-19 16:20:48
     */
    private Integer id;

    /**
     *
     *
     * goods_doubles_reward.goods_id
     * 商品编码
     *
     * @mbg.generated 2018-09-19 16:20:48
     */
    private Long goodsId;

    /**
     *
     *
     * goods_doubles_reward.reward_percent
     * 奖励翻倍比例
     *
     * @mbg.generated 2018-09-19 16:20:48
     */
    private Float rewardPercent;

    /**
     *
     *
     * goods_doubles_reward.state
     * 状态[1:启用,0:禁用]
     *
     * @mbg.generated 2018-09-19 16:20:48
     */
    private String state;

    /**
     *
     *
     * goods_doubles_reward.start_time
     * 开始时间
     *
     * @mbg.generated 2018-09-19 16:20:48
     */
    private Date startTime;

    /**
     *
     *
     * goods_doubles_reward.stop_time
     * 结束时间
     *
     * @mbg.generated 2018-09-19 16:20:48
     */
    private Date stopTime;

    /**
     *
     *
     * goods_doubles_reward.activity_stop_time
     * 结束时间
     *
     * @mbg.generated 2018-09-19 16:20:48
     */
    private Date activityStopTime;

    /**
     *
     *
     * goods_doubles_reward.gmt_create
     * 创建时间
     *
     * @mbg.generated 2018-09-19 16:20:48
     */
    private Date gmtCreate;

    /**
     *
     *
     * duoduo_goods_info.goods_name
     * 商品标题
     *
     * @mbg.generated 2018-07-11 11:22:20
     */
    private String goodsName;

    /**
     *
     *
     * duoduo_goods_info.min_normal_price
     * 最小单买价格单位为分
     *
     *
     */
    private Integer minNormalPrice;

    /**
     *
     *
     * duoduo_goods_info.min_group_price
     *
     *
     *
     */
    private Integer minGroupPrice;

    /**
     *
     *
     * duoduo_goods_info.promotion_rate
     * 佣金比例千分比
     *
     * @mbg.generated 2018-07-11 11:22:20
     */
    private Integer promotionRate;
    /**
     *
     *
     * duoduo_goods_info.selfPromotion
     * 自购佣金 分
     *
     * @mbg.generated 2018-07-11 11:22:20
     */
    private Integer selfPromotion;

    /**
     *
     *
     * duoduo_goods_info.selfPromotion
     * 总佣金 分
     *
     * @mbg.generated 2018-07-11 11:22:20
     */
    private Integer sumPromotion;

}
