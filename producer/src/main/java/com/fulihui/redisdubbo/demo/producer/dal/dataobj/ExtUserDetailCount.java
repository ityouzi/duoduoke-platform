package com.fulihui.redisdubbo.demo.producer.dal.dataobj;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author: JY
 * @date: 2018/8/1 14:42
 */
@Setter
@Getter
public class ExtUserDetailCount {

    private String userReferee;

    private Date regDate;

    private Long count;
}

