package com.fulihui.duoduoke.demo.web.param.sgin;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.near.toolkit.model.ToString;

/**
 *
 * @author lizhi
 * @date 2018-10-15
 */

@Setter
@Getter
public class SignShareParam extends ToString {
    private static final long serialVersionUID = -5778703972686014917L;
    @ApiModelProperty("签到id")
    private Integer           signId;

}
