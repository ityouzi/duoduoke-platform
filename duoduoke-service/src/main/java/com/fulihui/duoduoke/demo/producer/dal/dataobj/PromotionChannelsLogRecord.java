package com.fulihui.duoduoke.demo.producer.dal.dataobj;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class PromotionChannelsLogRecord implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * promotion_channels_log_record.id
     *
     * @mbg.generated 2018-12-03 15:53:46
     */
    private Integer id;
    /**
     * promotion_channels_log_record.promotion_channels_id
     * 用户id
     *
     * @mbg.generated 2018-12-03 15:53:46
     */
    private Integer promotionChannelsId;
    /**
     * promotion_channels_log_record.gmt_create
     * 创建时间
     *
     * @mbg.generated 2018-12-03 15:53:46
     */
    private Date gmtCreate;
    /**
     * promotion_channels_log_record.gmt_modified
     * 修改时间
     *
     * @mbg.generated 2018-12-03 15:53:46
     */
    private Date gmtModified;
    /**
     * promotion_channels_log_record.channels_proportion_before
     * 渠道推广比例修改前
     *
     * @mbg.generated 2018-12-03 15:53:46
     */
    private Double channelsProportionBefore;
    /**
     * promotion_channels_log_record.channels_proportion_after
     * 渠道推广比例修改后
     *
     * @mbg.generated 2018-12-03 15:53:46
     */
    private Double channelsProportionAfter;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", promotionChannelsId=").append(promotionChannelsId);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", gmtModified=").append(gmtModified);
        sb.append(", channelsProportionBefore=").append(channelsProportionBefore);
        sb.append(", channelsProportionAfter=").append(channelsProportionAfter);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}