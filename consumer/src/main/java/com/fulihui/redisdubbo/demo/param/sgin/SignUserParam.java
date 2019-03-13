package com.fulihui.redisdubbo.demo.param.sgin;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.near.toolkit.model.ToString;

/**
 *
 * @author lizhi
 * @date 2018-10-12
 */

@Setter
@Getter
public class SignUserParam extends ToString {
    private static final long serialVersionUID = -5778703972686014917L;
    @ApiModelProperty("签到id ")
    private Integer           id;
    @ApiModelProperty("签到类型[SELF=自签 ,SUPPLEMENT=补签]")
    private String            signType;
    @ApiModelProperty("签到被帮助者id")
    private String            signHelpUserId;
    @ApiModelProperty("签到周期时间")
    private String            cycleTime;
}
