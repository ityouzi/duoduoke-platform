package com.fulihui.duoduoke.demo.web.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.near.toolkit.model.ToString;

/**
 *
 * @author lizhi
 * @date 2018-10-11
 */

@Getter
@Setter
public class SignUserConfigParam extends ToString {
    private static final long serialVersionUID = -2392944865423915601L;
    @ApiModelProperty(value = "状态[1:启用,0:禁用]")
    private String            state;
}
