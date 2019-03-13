package com.fulihui.duoduoke.demo.api.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Administrator
 */
@Setter
@Getter
public class UserRedPackageRecordDTO implements Serializable {
    /**
     * user_red_package_record.id
     * 主键
     *
     * @mbg.generated 2018-09-10 11:14:35
     */
    private Integer id;

    /**
     * user_red_package_record.user_id
     * 用户id
     *
     * @mbg.generated 2018-09-10 11:14:35
     */
    private String userId;

    /**
     * user_red_package_record.field_id
     * 专场ID
     *
     * @mbg.generated 2018-09-10 11:14:35
     */
    private Integer fieldId;

    /**
     * user_red_package_record.gmt_create
     * 创建时间
     *
     * @mbg.generated 2018-09-10 11:14:35
     */
    private Date gmtCreate;

    /**
     * user_red_package_record.gmt_modified
     * 修改时间
     *
     * @mbg.generated 2018-09-10 11:14:35
     */
    private Date gmtModified;

    private String help;

    /**
     * user_red_package_record.end_time
     *
     * @mbg.generated 2018-09-10 13:59:29
     */
    private Date endTime;


    private static final long serialVersionUID = 1L;

}