package com.fulihui.duoduoke.demo.api.dto.promotion;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.near.toolkit.model.ToString;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PromotionChannelsLogRecordDTO extends ToString {
    private static final long serialVersionUID = -5381610371737129129L;
    /**
    *
    *
    * promotion_channels_log_record.id
    
     *
     * @mbg.generated 2018-11-29 14:40:46
     */
    private Integer id;

    /**
    *
    *
    * promotion_channels_log_record.promotion_channels_id
     * 用户id
     *
     * @mbg.generated 2018-11-29 14:40:46
     */
    private Integer promotionChannelsId;

    /**
    *
    *
    * promotion_channels_log_record.gmt_create
     * 创建时间
     *
     * @mbg.generated 2018-11-29 14:40:46
     */
    private Date    gmtCreate;

    /**
    *
    *
    * promotion_channels_log_record.gmt_modified
     * 修改时间
     *
     * @mbg.generated 2018-11-29 14:40:46
     */
    private Date    gmtModified;

    private Double channelsProportionBefore;

    /**
     *
     *
     * promotion_channels_log_record.channels_proportion_after
     * 渠道推广比例修改后
     *
     * @mbg.generated 2018-11-29 14:50:10
     */
    private Double channelsProportionAfter;

}