package com.fulihui.duoduoke.demo.web.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.near.toolkit.model.ToString;

/**
 * @Description:
 * @Author: xiaoming
 * @version: v 0.1 2018/8/15 0015 16:04
 */
@Setter
@Getter
public class HomeColumnVO extends ToString {

    @ApiModelProperty(value = "id")
    private Integer id;

    /**
     *
     *
     * home_column.column_name
     * 入口名称
     *
     * @mbg.generated 2018-08-15 14:18:34
     */
    @ApiModelProperty(value = "入口名称")
    private String columnName;

    /**
     *
     *
     * home_column.column_img
     * 入口图
     *
     * @mbg.generated 2018-08-15 14:18:34
     */
    @ApiModelProperty(value = "入口图")
    private String columnImg;

    /**
     *
     *
     * home_column.column_url
     * 入口路径
     *
     * @mbg.generated 2018-08-15 14:18:34
     */
    @ApiModelProperty(value = "入口路径")
    private String columnUrl;


    /**
     *
     *
     * home_column.channel_type
     * 类型
     *
     * @mbg.generated 2018-08-15 14:18:34
     */
    @ApiModelProperty(value = "类型")
    private Integer channelType;
}
