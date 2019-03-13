package com.fulihui.redisdubbo.demo.api.request;

import lombok.Getter;
import lombok.Setter;
import org.near.servicesupport.request.PageRequest;

/**
 * @author lizhi
 */
@Getter
@Setter
public class WechatTokenQueryRequest extends PageRequest {
    private static final long serialVersionUID = -8956653808092559899L;

    private String            appid;

    private String            appSecret;

    private String            tokenType;
}
