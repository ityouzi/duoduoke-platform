package com.fulihui.duoduoke.demo.producer.dal.dataobj;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class PromotionChannelsLink implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * promotion_channels_link.id
     *
     * @mbg.generated 2018-12-07 10:10:56
     */
    private Integer id;
    /**
     * promotion_channels_link.channels_code
     * 渠道code
     *
     * @mbg.generated 2018-12-07 10:10:56
     */
    private String channelsCode;
    /**
     * promotion_channels_link.gmt_create
     * 创建时间
     *
     * @mbg.generated 2018-12-07 10:10:56
     */
    private Date gmtCreate;
    /**
     * promotion_channels_link.gmt_modified
     * 修改时间
     *
     * @mbg.generated 2018-12-07 10:10:56
     */
    private Date gmtModified;
    /**
     * promotion_channels_link.config_info
     * 栏目配置链接信息
     *
     * @mbg.generated 2018-12-07 10:10:56
     */
    private String configInfo;
    /**
     * promotion_channels_link.link_time
     * 栏目链接生成日期
     *
     * @mbg.generated 2018-12-07 10:10:56
     */
    private Date linkTime;
    /**
     * promotion_channels_link.p_id
     *
     * @mbg.generated 2018-12-07 10:10:56
     */
    private String pId;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", channelsCode=").append(channelsCode);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", gmtModified=").append(gmtModified);
        sb.append(", configInfo=").append(configInfo);
        sb.append(", linkTime=").append(linkTime);
        sb.append(", pId=").append(pId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}