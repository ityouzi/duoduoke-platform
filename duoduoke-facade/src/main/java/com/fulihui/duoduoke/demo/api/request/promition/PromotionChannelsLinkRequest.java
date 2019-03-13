package com.fulihui.duoduoke.demo.api.request.promition;

import lombok.Data;
import org.near.servicesupport.request.PageRequest;

import java.util.Date;

/**
 * @author Administrator
 */
@Data

public class PromotionChannelsLinkRequest extends PageRequest {
    private static final long serialVersionUID = -153793001479307462L;
    /**
    *
    *
    * promotion_channels_link.id
    
     *
     * @mbg.generated 2018-12-07 09:30:49
     */
    private Integer           id;

    /**
    *
    *
    * promotion_channels_link.channels_code
     * 渠道code
     *
     * @mbg.generated 2018-12-07 09:30:49
     */
    private String            channelsCode;

    /**
    *
    *
    * promotion_channels_link.gmt_create
     * 创建时间
     *
     * @mbg.generated 2018-12-07 09:30:49
     */
    private Date              gmtCreate;

    /**
    *
    *
    * promotion_channels_link.gmt_modified
     * 修改时间
     *
     * @mbg.generated 2018-12-07 09:30:49
     */
    private Date              gmtModified;

    /**
    *
    *
    * promotion_channels_link.config_info
     * 栏目配置链接信息
     *
     * @mbg.generated 2018-12-07 09:30:49
     */
    private String            configInfo;

    /**
    *
    *
    * promotion_channels_link.link_time
     * 栏目链接生成日期
     *
     * @mbg.generated 2018-12-07 09:30:49
     */
    private Date              linkTime;

    private String            pId;
}