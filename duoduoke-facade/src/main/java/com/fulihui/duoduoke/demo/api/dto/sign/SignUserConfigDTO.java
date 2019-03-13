package com.fulihui.duoduoke.demo.api.dto.sign;

import lombok.Data;
import org.near.toolkit.model.ToString;

import java.util.Date;

/**
 * The type Sign user config dto.
 *
 * @author Administrator
 */
@Data
public class SignUserConfigDTO extends ToString {
    private static final long serialVersionUID = 4466330976769011252L;
    /**
    *
    *
    * sign_user_config.user_id
     * 用户唯一标识
     *
     * @mbg.generated 2018-10-11 10:36:27
     */
    private String            userId;

    /**
    *
    *
    * sign_user_config.state
     * 状态[1:启用,0:禁用]
     *
     * @mbg.generated 2018-10-11 10:36:27
     */
    private String            state;

    private Date              gmtCreate;

    /**
     *
     *
     * sign_user_config.gmt_modified
     * 修改时间
     *
     * @mbg.generated 2018-10-11 14:25:29
     */
    private Date              gmtModified;

}