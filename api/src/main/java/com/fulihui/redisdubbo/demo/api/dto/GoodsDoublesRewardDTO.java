package com.fulihui.redisdubbo.demo.api.dto;

import lombok.Getter;
import lombok.Setter;
import org.near.toolkit.model.ToString;

import java.util.Date;

@Setter
@Getter
public class GoodsDoublesRewardDTO  extends ToString {    /**
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

}
