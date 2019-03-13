package com.fulihui.redisdubbo.demo.param.sgin;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * ssm
 * @author Administrator
 */
@Getter
@Setter
public class SignAwardParam {
    private static final long serialVersionUID = -5778703972686014917L;
    @ApiModelProperty(value = "主键id")
    private Integer           signAwardId;
}