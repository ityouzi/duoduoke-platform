package com.fulihui.redisdubbo.demo.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.near.toolkit.model.ToString;

/**
 * @author lizhi
 * @date 2018-7-13
 */
@Setter @Getter
@NoArgsConstructor
@AllArgsConstructor
public class AuthTokenVO extends ToString {
    private static final long serialVersionUID = -7050138087574196398L;
    @ApiModelProperty(value = "用户id")
    private String userId;
    @ApiModelProperty(value = "请求token")
    private String token;
    @ApiModelProperty(value = "token失效时间")
    private Long expiresIn;
    @ApiModelProperty(value = "id")
    private Integer id;

}
