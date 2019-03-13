package com.fulihui.redisdubbo.demo.api.dto;

import lombok.Data;
import org.near.toolkit.model.ToString;

import java.util.Date;

@Data
public class CornerMarkDTO extends ToString {
    /**
    *
    *
    * corner_mark.id
    
     *
     * @mbg.generated 2018-09-18 14:41:02
     */
    private Integer id;

    /**
    *
    *
    * corner_mark.mark_name
     * 角标名称
     *
     * @mbg.generated 2018-09-18 14:41:02
     */
    private String markName;

    /**
    *
    *
    * corner_mark.mark_url
     * 角标url
     *
     * @mbg.generated 2018-09-18 14:41:02
     */
    private String markUrl;

    /**
    *
    *
    * corner_mark.gmt_create
     * 创建时间
     *
     * @mbg.generated 2018-09-18 14:41:02
     */
    private Date gmtCreate;

    /**
    *
    *
    * corner_mark.gmt_modified
     * 修改时间
     *
     * @mbg.generated 2018-09-18 14:41:02
     */
    private Date gmtModified;


}