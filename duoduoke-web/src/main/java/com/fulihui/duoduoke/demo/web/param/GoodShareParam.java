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
public class GoodShareParam extends FormIdParam {
    /**
     * 商品id
     */
    @ApiModelProperty("商品id")
    private Long goodsId;

    @ApiModelProperty("分享Pid")
    private String sharePid;

}
