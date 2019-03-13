package com.fulihui.redisdubbo.demo.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author lizhi
 * @date 2018-9-7
 */
@Getter
@Setter
public class RedPackageFieldParam extends FormIdParam {
    private static final long serialVersionUID = -5011869784209847386L;

    /**
     * 红包专场id
     */
    @ApiModelProperty("红包专场id")
    private String            fieldId;
    /**
     * 状态   1=
     */
    @ApiModelProperty("状态,1=进行中,2=已过期,3=助力成功,4=助力失败")
    private String            status;
}