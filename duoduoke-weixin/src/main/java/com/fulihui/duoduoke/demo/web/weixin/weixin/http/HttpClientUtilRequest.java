package com.fulihui.duoduoke.demo.web.weixin.weixin.http;


import java.util.Map;

import org.near.toolkit.model.ToString;

import lombok.Getter;
import lombok.Setter;

/**
 * @author lizhi
 */
@Getter
@Setter
public class HttpClientUtilRequest extends ToString {

    private static final long serialVersionUID = 2886724715255332438L;
    /**
     * 请求地址
     */
    private String url;
    /**
     * 请求参数
     */
    private Map<String, String> params;
    /**
     * 请求数据
     */
    private String data;
    /**
     * 证书文件路径
     */
    private String certFile;
    /**
     * 证书密码
     */
    private String certPwd;
    /**
     * 请求后缀
     */
    private String urlFoot;
}
