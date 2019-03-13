package com.fulihui.redisdubbo.demo.weixin.weixin.result;

import lombok.Getter;
import lombok.Setter;

/**
 * jsapi票据接口返回参数
 * Created by Willard on 2015/9/24.
 */
@Setter
@Getter
public class JsapiTicketWeixinResult extends WeixinJsonResult {
    private static final long serialVersionUID = -3438620745926360825L;

    private String            ticket;

    private int               expires_in;

}
