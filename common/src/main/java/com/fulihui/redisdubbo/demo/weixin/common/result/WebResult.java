package com.fulihui.redisdubbo.demo.weixin.common.result;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author: JY
 * @date: 2018/7/6 15:49
 */
@Getter
@Setter
@ToString
public class WebResult<T> {

    public static int SUCCESS =0;
    public static int FAIL =1;

    private int code;

    private String msg;

    private T data;

    private T  dataExtMsg;
}
