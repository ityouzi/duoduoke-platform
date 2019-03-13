package com.fulihui.duoduoke.demo.web.param.sgin;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author lizhi
 * @date 2018-10-17
 */
@Setter
@Getter
public class DrawParam extends FlopTypeParam {
    private static final long serialVersionUID = 2320921257065157277L;
    @ApiModelProperty("签到id")
    private Integer           signId;

}
