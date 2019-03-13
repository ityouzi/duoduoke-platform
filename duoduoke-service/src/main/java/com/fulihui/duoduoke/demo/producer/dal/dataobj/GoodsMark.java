package com.fulihui.duoduoke.demo.producer.dal.dataobj;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class GoodsMark implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * goods_mark.id
     *
     * @mbg.generated 2018-09-20 09:47:19
     */
    private Integer id;
    /**
     * goods_mark.goods_id
     * 商品编码
     *
     * @mbg.generated 2018-09-20 09:47:19
     */
    private Long goodsId;
    /**
     * goods_mark.mark_id
     * 角标id
     *
     * @mbg.generated 2018-09-20 09:47:19
     */
    private Integer markId;
    /**
     * goods_mark.start_time
     * 角标开始时间
     *
     * @mbg.generated 2018-09-20 09:47:19
     */
    private Date startTime;
    /**
     * goods_mark.stop_time
     * 角标结束时间
     *
     * @mbg.generated 2018-09-20 09:47:19
     */
    private Date stopTime;
    /**
     * goods_mark.gmt_create
     * 创建时间
     *
     * @mbg.generated 2018-09-20 09:47:19
     */
    private Date gmtCreate;
    /**
     * goods_mark.gmt_modified
     * 修改时间
     *
     * @mbg.generated 2018-09-20 09:47:19
     */
    private Date gmtModified;
    /**
     * goods_mark.mark_url
     * 角标url
     *
     * @mbg.generated 2018-09-18 14:41:25
     */
    private String markUrl;
    private String markName;


}