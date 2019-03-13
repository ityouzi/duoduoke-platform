package com.fulihui.duoduoke.demo.web.param;


import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @Description:
 * @Author: xiaoming
 * @version: v 0.1 2018/7/10 0010 18:30
 */
@Setter
@Getter
public class GoodCatParam extends FormIdParam {
    private static final long serialVersionUID = 6207131546454549415L;
    /**
     * code
     */
    @ApiModelProperty("类目ID")
    private Integer catId;


}
