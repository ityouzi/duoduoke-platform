package com.fulihui.redisdubbo.demo.api.dto;

import lombok.Data;
import org.near.toolkit.model.ToString;

import java.util.Date;

@Data
public class GoodsMarkDTO extends ToString {
    /**
    *
    *
    * goods_mark.id
    
     *
     * @mbg.generated 2018-09-18 14:41:25
     */
    private Integer id;

    /**
    *
    *
    * goods_mark.goods_id
     * 商品编码
     *
     * @mbg.generated 2018-09-18 14:41:25
     */
    private Long goodsId;

    /**
    *
    *
    * goods_mark.mark_id
     * 角标id
     *
     * @mbg.generated 2018-09-18 14:41:25
     */
    private Integer markId;

    /**
    *
    *
    * goods_mark.mark_url
     * 角标url
     *
     * @mbg.generated 2018-09-18 14:41:25
     */
    private String markUrl;

    /**
    *
    *
    * goods_mark.start_time
     * 角标开始时间
     *
     * @mbg.generated 2018-09-18 14:41:25
     */
    private Date startTime;

    /**
    *
    *
    * goods_mark.stop_time
     * 角标结束时间
     *
     * @mbg.generated 2018-09-18 14:41:25
     */
    private Date stopTime;

    /**
    *
    *
    * goods_mark.gmt_create
     * 创建时间
     *
     * @mbg.generated 2018-09-18 14:41:25
     */
    private Date gmtCreate;

    /**
    *
    *
    * goods_mark.gmt_modified
     * 修改时间
     *
     * @mbg.generated 2018-09-18 14:41:25
     */
    private Date gmtModified;

    private String markName;




}