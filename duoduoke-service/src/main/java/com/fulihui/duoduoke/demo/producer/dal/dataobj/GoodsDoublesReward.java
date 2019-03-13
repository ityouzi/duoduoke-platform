package com.fulihui.duoduoke.demo.producer.dal.dataobj;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class GoodsDoublesReward implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * goods_doubles_reward.id
     *
     * @mbg.generated 2018-09-26 12:31:23
     */
    private Integer id;
    /**
     * goods_doubles_reward.goods_id
     * 商品编码
     *
     * @mbg.generated 2018-09-26 12:31:23
     */
    private Long goodsId;
    /**
     * goods_doubles_reward.reward_percent
     * 奖励翻倍比例
     *
     * @mbg.generated 2018-09-26 12:31:23
     */
    private Float rewardPercent;
    /**
     * goods_doubles_reward.state
     * 状态[0:未开始（启用）,1:进行中（启用）,2:已结束（启用）,3:已下架(关闭)]
     *
     * @mbg.generated 2018-09-26 12:31:23
     */
    private String state;
    /**
     * goods_doubles_reward.start_time
     * 开始时间
     *
     * @mbg.generated 2018-09-26 12:31:23
     */
    private Date startTime;
    /**
     * goods_doubles_reward.stop_time
     * 结束时间
     *
     * @mbg.generated 2018-09-26 12:31:23
     */
    private Date stopTime;
    /**
     * goods_doubles_reward.activity_stop_time
     * 结束时间
     *
     * @mbg.generated 2018-09-26 12:31:23
     */
    private Date activityStopTime;
    /**
     * goods_doubles_reward.gmt_create
     * 创建时间
     *
     * @mbg.generated 2018-09-26 12:31:23
     */
    private Date gmtCreate;
    /**
     * goods_doubles_reward.gmt_modified
     * 修改时间
     *
     * @mbg.generated 2018-09-26 12:31:23
     */
    private Date gmtModified;
    /**
     * goods_doubles_reward.goods_name
     *
     * @mbg.generated 2018-09-26 12:31:23
     */
    private String goodsName;
    /**
     * goods_doubles_reward.min_normal_price
     *
     * @mbg.generated 2018-09-26 12:31:23
     */
    private Long minNormalPrice;
    /**
     * goods_doubles_reward.min_group_price
     *
     * @mbg.generated 2018-09-26 12:31:23
     */
    private Long minGroupPrice;
    /**
     * goods_doubles_reward.promotion_rate
     *
     * @mbg.generated 2018-09-26 12:31:23
     */
    private String promotionRate;
    /**
     * goods_doubles_reward.self_promotion
     *
     * @mbg.generated 2018-09-26 12:31:23
     */
    private String selfPromotion;
    /**
     * goods_doubles_reward.sum_promotion
     *
     * @mbg.generated 2018-09-26 12:31:23
     */
    private String sumPromotion;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", goodsId=").append(goodsId);
        sb.append(", rewardPercent=").append(rewardPercent);
        sb.append(", state=").append(state);
        sb.append(", startTime=").append(startTime);
        sb.append(", stopTime=").append(stopTime);
        sb.append(", activityStopTime=").append(activityStopTime);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", gmtModified=").append(gmtModified);
        sb.append(", goodsName=").append(goodsName);
        sb.append(", minNormalPrice=").append(minNormalPrice);
        sb.append(", minGroupPrice=").append(minGroupPrice);
        sb.append(", promotionRate=").append(promotionRate);
        sb.append(", selfPromotion=").append(selfPromotion);
        sb.append(", sumPromotion=").append(sumPromotion);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}