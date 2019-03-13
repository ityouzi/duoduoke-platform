package com.fulihui.duoduoke.demo.producer.dal.dataobj;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class PromotionTelevisionLink implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * promotion_television_link.id
     *
     * @mbg.generated 2018-12-06 14:02:41
     */
    private Integer id;
    /**
     * promotion_television_link.television_type
     * 频道推广类型
     *
     * @mbg.generated 2018-12-06 14:02:41
     */
    private String televisionType;
    /**
     * promotion_television_link.link
     * 链接地址
     *
     * @mbg.generated 2018-12-06 14:02:41
     */
    private String link;
    /**
     * promotion_television_link.channels_code
     * 渠道code
     *
     * @mbg.generated 2018-12-06 14:02:41
     */
    private String channelsCode;
    /**
     * promotion_television_link.gmt_create
     * 创建时间
     *
     * @mbg.generated 2018-12-06 14:02:41
     */
    private Date gmtCreate;
    /**
     * promotion_television_link.gmt_modified
     * 修改时间
     *
     * @mbg.generated 2018-12-06 14:02:41
     */
    private Date gmtModified;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", televisionType=").append(televisionType);
        sb.append(", link=").append(link);
        sb.append(", channelsCode=").append(channelsCode);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", gmtModified=").append(gmtModified);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}