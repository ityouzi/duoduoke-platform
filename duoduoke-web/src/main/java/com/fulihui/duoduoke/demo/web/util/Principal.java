package com.fulihui.duoduoke.demo.web.util;

import lombok.Getter;
import lombok.Setter;
import org.near.toolkit.model.ToString;

/**
 * 用户主体信息
 *
 * @author lizhi
 * @date 2018-7-14
 */
@Setter @Getter
public class Principal extends ToString {
    private static final long serialVersionUID = -5804540501666631657L;

    /**
     * 用户唯一标识
     */
    private String userId;
    /**
     * 微信 openid
     */
    private String openId;

}
