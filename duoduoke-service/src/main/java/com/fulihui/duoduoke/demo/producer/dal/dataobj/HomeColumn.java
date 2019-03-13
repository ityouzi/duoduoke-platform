package com.fulihui.duoduoke.demo.producer.dal.dataobj;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
public class HomeColumn implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * home_column.id
     *
     * @mbg.generated 2018-08-15 14:18:34
     */
    private Integer id;
    /**
     * home_column.column_name
     * 入口名称
     *
     * @mbg.generated 2018-08-15 14:18:34
     */
    private String columnName;
    /**
     * home_column.column_img
     * 入口图
     *
     * @mbg.generated 2018-08-15 14:18:34
     */
    private String columnImg;
    /**
     * home_column.column_url
     * 入口路径
     *
     * @mbg.generated 2018-08-15 14:18:34
     */
    private String columnUrl;
    /**
     * home_column.banner_img
     * 栏目图
     *
     * @mbg.generated 2018-08-15 14:18:34
     */
    private String bannerImg;
    /**
     * home_column.channel_type
     * 类型
     *
     * @mbg.generated 2018-08-15 14:18:34
     */
    private Integer channelType;
    /**
     * home_column.gmt_create
     * 创建时间
     *
     * @mbg.generated 2018-08-15 14:18:34
     */
    private Date gmtCreate;
    /**
     * home_column.gmt_modified
     * 修改时间
     *
     * @mbg.generated 2018-08-15 14:18:34
     */
    private Date gmtModified;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", columnName=").append(columnName);
        sb.append(", columnImg=").append(columnImg);
        sb.append(", columnUrl=").append(columnUrl);
        sb.append(", bannerImg=").append(bannerImg);
        sb.append(", channelType=").append(channelType);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", gmtModified=").append(gmtModified);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}