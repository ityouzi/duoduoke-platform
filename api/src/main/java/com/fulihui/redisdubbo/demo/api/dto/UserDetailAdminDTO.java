package com.fulihui.redisdubbo.demo.api.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author: JY
 * @date: 2018/8/1 14:29
 */
@Setter
@Getter
public class UserDetailAdminDTO {

    /**
     * 用户Id
     */
    private  String userId;

    /**
     * 创建时间
     */
    private Date gmtCreate;

    /**
     * 推荐人Id
     */
    private String userReferee;

    /**
     * 一级粉丝数
     */
    private Integer oneFansNum;

    /**
     * 二级粉丝数
     */
    private Integer twoFansNum;

    /**
     * 账户余额
     */
    private Integer balance;
}
