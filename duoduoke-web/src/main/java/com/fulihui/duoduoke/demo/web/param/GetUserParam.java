package com.fulihui.duoduoke.demo.web.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.near.toolkit.model.ToString;

/**
 * @author lizhi
 * @date 2018-8-8
 */
@Setter
@Getter
public class GetUserParam extends ToString {
    private static final long serialVersionUID = -8161823651563725077L;
    @ApiModelProperty("用户信息对象，不包含 openid 等敏感信息")
    private String userInfo;


}
