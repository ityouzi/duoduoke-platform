package com.fulihui.redisdubbo.demo.api.dto;

import lombok.Getter;
import lombok.Setter;
import org.near.toolkit.model.ToString;

import java.util.Date;

@Setter
@Getter
public class HomeColumnDTO extends ToString {
    /**
    *
    *
    * home_column.id
    
     *
     * @mbg.generated 2018-08-15 14:18:34
     */
    private Integer id;

    /**
    *
    *
    * home_column.column_name
     * 入口名称
     *
     * @mbg.generated 2018-08-15 14:18:34
     */
    private String columnName;

    /**
    *
    *
    * home_column.column_img
     * 入口图
     *
     * @mbg.generated 2018-08-15 14:18:34
     */
    private String columnImg;

    /**
    *
    *
    * home_column.column_url
     * 入口路径
     *
     * @mbg.generated 2018-08-15 14:18:34
     */
    private String columnUrl;

    /**
    *
    *
    * home_column.banner_img
     *  栏目图
     *
     * @mbg.generated 2018-08-15 14:18:34
     */
    private String bannerImg;

    /**
    *
    *
    * home_column.channel_type
     * 类型
     *
     * @mbg.generated 2018-08-15 14:18:34
     */
    private Integer channelType;

    /**
    *
    *
    * home_column.gmt_create
     * 创建时间
     *
     * @mbg.generated 2018-08-15 14:18:34
     */
    private Date gmtCreate;

    /**
    *
    *
    * home_column.gmt_modified
     * 修改时间
     *
     * @mbg.generated 2018-08-15 14:18:34
     */
    private Date gmtModified;

}