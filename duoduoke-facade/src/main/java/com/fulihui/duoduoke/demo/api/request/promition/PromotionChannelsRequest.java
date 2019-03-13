package com.fulihui.duoduoke.demo.api.request.promition;

import lombok.Getter;
import lombok.Setter;
import org.near.servicesupport.request.PageRequest;

/**
 *
 * @author lizhi
 * @date 2018-11-29
 */
@Setter
@Getter
public class PromotionChannelsRequest extends PageRequest {
    private static final long serialVersionUID = 2337736014177008877L;

    /**
     *
     *
     * promotion_channels.id
     * 主键
     *
     * @mbg.generated 2018-11-29 09:54:59
     */
    private Integer id;

    /**
     *
     *
     * promotion_channels.channels_name
     * 渠道名称
     *
     * @mbg.generated 2018-11-29 09:54:59
     */
    private String channelsName;

    /**
     *
     *
     * promotion_channels.channels_code
     * 渠道标示
     *
     * @mbg.generated 2018-11-29 09:54:59
     */
    private String channelsCode;

    /**
     *
     *
     * promotion_channels.channels_desc
     * 渠道描述说明
     *
     * @mbg.generated 2018-11-29 09:54:59
     */
    private String channelsDesc;

    /**
     *
     *
     * promotion_channels.channels_proportion
     * 渠道推广分成比例
     *
     * @mbg.generated 2018-11-29 09:54:59
     */
    private Double channelsProportion;

    /**
     *
     *
     * promotion_channels.proportion_link
     * 渠道推广链接地址
     *
     * @mbg.generated 2018-11-29 09:54:59
     */
    private String proportionLink;

    /**
     *
     *
     * promotion_channels.channels_income
     * 渠道收入
     *
     * @mbg.generated 2018-11-29 09:54:59
     */
    private Integer channelsIncome;

    /**
     *
     *
     * promotion_channels.account_balance
     * 账户余额
     *
     * @mbg.generated 2018-11-29 09:54:59
     */
    private Integer accountBalance;

    /**
     *
     *
     * promotion_channels.channels_status
     * 渠道状态
     *
     * @mbg.generated 2018-11-29 09:54:59
     */
    private String channelsStatus;


}
