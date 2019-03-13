package com.fulihui.duoduoke.demo.producer.dal.dataobj;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author: JY
 * @date: 2018/8/1 14:42
 */
@Setter
@Getter
public class UserDetailAdmin {
    private String userId;

    private Date gmtCreate;

    private String userReferee;

    private Integer oneFansNum;

    private Integer twoFansNum;

    private Integer balance;
}
