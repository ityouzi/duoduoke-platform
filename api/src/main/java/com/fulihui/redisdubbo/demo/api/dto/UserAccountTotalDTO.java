package com.fulihui.redisdubbo.demo.api.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: JY
 * @date: 2018/7/13 14:37
 */
@Setter
@Getter
public class UserAccountTotalDTO implements Serializable {
    private static final long serialVersionUID = -6214302388399355583L;
    /**
     * 用户创建时间
     */
    private Date gmtCreate;

    /**
     * 账号余额
     */
    private Long balance;

    /**
     * 累计总额
     */
    private Long sumAmount;
}
