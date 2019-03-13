package com.fulihui.redisdubbo.demo.api.dto;

import lombok.Data;
import org.near.toolkit.model.ToString;

import java.util.Date;

/**
 *
 * @author lizhi
 * @date 2018-12-06
 */
@Data
public class PromotionTelevisionLinkDTO extends ToString {
    private static final long serialVersionUID = 9022261240581267381L;
    /**
     *
     *
     * promotion_television_link.id
    
     *
     * @mbg.generated 2018-12-06 14:02:41
     */
    private Integer id;

    /**
     *
     *
     * promotion_television_link.television_type
     * 频道推广类型
     *
     * @mbg.generated 2018-12-06 14:02:41
     */
    private String  televisionType;

    /**
     *
     *
     * promotion_television_link.link
     * 链接地址
     *
     * @mbg.generated 2018-12-06 14:02:41
     */
    private String  link;

    /**
     *
     *
     * promotion_television_link.channels_code
     * 渠道code
     *
     * @mbg.generated 2018-12-06 14:02:41
     */
    private String  channelsCode;

    /**
     *
     *
     * promotion_television_link.gmt_create
     * 创建时间
     *
     * @mbg.generated 2018-12-06 14:02:41
     */
    private Date    gmtCreate;

    /**
     *
     *
     * promotion_television_link.gmt_modified
     * 修改时间
     *
     * @mbg.generated 2018-12-06 14:02:41
     */
    private Date    gmtModified;
}
