package com.fulihui.redisdubbo.demo.producer.dal.dataobj;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Administrator
 */
@Data
public class PromotionChannels implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * promotion_channels.id
     * 主键
     *
     * @mbg.generated 2018-11-29 09:54:59
     */
    private Integer id;
    /**
     * promotion_channels.channels_name
     * 渠道名称
     *
     * @mbg.generated 2018-11-29 09:54:59
     */
    private String channelsName;
    /**
     * promotion_channels.channels_code
     * 渠道标示
     *
     * @mbg.generated 2018-11-29 09:54:59
     */
    private String channelsCode;
    /**
     * promotion_channels.channels_desc
     * 渠道描述说明
     *
     * @mbg.generated 2018-11-29 09:54:59
     */
    private String channelsDesc;
    /**
     * promotion_channels.channels_proportion
     * 渠道推广分成比例
     *
     * @mbg.generated 2018-11-29 09:54:59
     */
    private Double channelsProportion;
    /**
     * promotion_channels.proportion_link
     * 渠道推广链接地址
     *
     * @mbg.generated 2018-11-29 09:54:59
     */
    private String proportionLink;
    /**
     * promotion_channels.channels_income
     * 渠道收入
     *
     * @mbg.generated 2018-11-29 09:54:59
     */
    private Integer channelsIncome;
    /**
     * promotion_channels.account_balance
     * 账户余额
     *
     * @mbg.generated 2018-11-29 09:54:59
     */
    private Integer accountBalance;
    /**
     * promotion_channels.channels_status
     * 渠道状态
     *
     * @mbg.generated 2018-11-29 09:54:59
     */
    private String channelsStatus;
    /**
     * promotion_channels.gmt_create
     * 创建时间
     *
     * @mbg.generated 2018-11-29 09:54:59
     */
    private Date gmtCreate;
    /**
     * promotion_channels.gmt_modified
     * 修改时间
     *
     * @mbg.generated 2018-11-29 09:54:59
     */
    private Date gmtModified;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", channelsName=").append(channelsName);
        sb.append(", channelsCode=").append(channelsCode);
        sb.append(", channelsDesc=").append(channelsDesc);
        sb.append(", channelsProportion=").append(channelsProportion);
        sb.append(", proportionLink=").append(proportionLink);
        sb.append(", channelsIncome=").append(channelsIncome);
        sb.append(", accountBalance=").append(accountBalance);
        sb.append(", channelsStatus=").append(channelsStatus);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", gmtModified=").append(gmtModified);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}