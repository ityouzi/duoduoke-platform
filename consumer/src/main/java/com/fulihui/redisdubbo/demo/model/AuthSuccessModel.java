package com.fulihui.redisdubbo.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.near.toolkit.model.ToString;

/**
 * Created by IntelliJ IDEA.
 * User:   lizhi
 * Date: 2018-5-31
 * Time: 15:16
 *
 * @author lizhi
 */
@Getter
@Setter
public class AuthSuccessModel extends ToString {

    private static final long serialVersionUID = -2904607438830675058L;
    /**
     * {"session_key":"2\/0TDEpMccdYdn7ee\/1Vxg==","openid":"oXx034yoSype8AqysLa3dI-z_Ou0"}
     */

    @JsonProperty(value = "openid")
    private String openId;

    @JsonProperty(value = "session_key")
    private String sessionKey;
}
