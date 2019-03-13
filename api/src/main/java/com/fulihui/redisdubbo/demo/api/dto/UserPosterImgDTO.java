package com.fulihui.redisdubbo.demo.api.dto;

import lombok.Getter;
import lombok.Setter;
import org.near.toolkit.model.ToString;

import java.util.Date;

@Setter
@Getter
public class UserPosterImgDTO extends ToString {
    /**
    *
    *
    * user_poster_img.id
    
     *
     * @mbg.generated 2018-07-30 17:58:18
     */
    private Integer id;

    /**
    *
    *
    * user_poster_img.user_id
     * 用户唯一标识
     *
     * @mbg.generated 2018-07-30 17:58:18
     */
    private String userId;

    /**
    *
    *
    * user_poster_img.poster_img
     * 用户海报图
     *
     * @mbg.generated 2018-07-30 17:58:18
     */
    private String posterImg;

    /**
    *
    *
    * user_poster_img.gmt_create
     * 创建时间
     *
     * @mbg.generated 2018-07-30 17:58:18
     */
    private Date gmtCreate;

    /**
    *
    *
    * user_poster_img.gmt_modified
     * 修改时间
     *
     * @mbg.generated 2018-07-30 17:58:18
     */
    private Date gmtModified;



}