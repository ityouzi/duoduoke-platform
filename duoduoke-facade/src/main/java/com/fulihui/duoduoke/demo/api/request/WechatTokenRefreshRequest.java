package com.fulihui.duoduoke.demo.api.request;

import lombok.Getter;
import lombok.Setter;
import org.near.toolkit.model.ToString;

import java.util.Date;

/**
 * @author lizhi
 */
@Getter
@Setter
public class WechatTokenRefreshRequest extends ToString {
    private static final long serialVersionUID = -8956653808092559899L;

    private String            appid;

    private String            appSecret;

    private String            tokenValue;

    private String            tokenRefreshValue;

    private Long              expiresIn;

    private Date              lastGmtModified;
}
