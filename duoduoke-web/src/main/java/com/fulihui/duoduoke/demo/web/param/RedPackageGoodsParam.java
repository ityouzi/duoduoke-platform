package com.fulihui.duoduoke.demo.web.param;

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
public class RedPackageGoodsParam extends FormIdParam {
    private static final long serialVersionUID = -5011869784209847386L;

    /**
     * 红包专场id
     */
    @ApiModelProperty("红包专场id")
    private String            fieldId;
    /**
     * 红包专场商品类型
     */
    @ApiModelProperty("红包专场商品类型, 1:基础红包专场商品  2:助力红包专场商品 ")
    private String            rpfType;
    @ApiModelProperty("领取id")
    private String            recordId;
}