package com.fulihui.duoduoke.demo.api.dto.sign;

import lombok.Getter;
import lombok.Setter;
import org.near.toolkit.model.ToString;

import java.util.Date;

/**
 * @author Administrator
 */
@Setter
@Getter
public class SignInConfigDTO extends ToString {
    private static final long serialVersionUID = -8661692309174273040L;
    /**
     * @mbg.generated 2018-10-11 16:12:28
     */
    private Long              id;

    /**
    * sign_in_config.days
     * 签到天数（目前最大七天）
     * @mbg.generated 2018-10-11 16:12:28
     */
    private Integer           days;

    /**
    * sign_in_config.gmt_create
     * @mbg.generated 2018-10-11 16:12:28
     */
    private Date              gmtCreate;

    /**
     * sign_in_config.gmt_modified
     * @mbg.generated 2018-10-11 16:12:28
     */
    private Date              gmtModified;

}