package com.fulihui.redisdubbo.demo.producer.dal.dataobj;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author: JY
 * @date: 2018/7/13 14:24
 * 用户总额
 */
@Setter
@Getter
public class UserAccountTotal {

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
