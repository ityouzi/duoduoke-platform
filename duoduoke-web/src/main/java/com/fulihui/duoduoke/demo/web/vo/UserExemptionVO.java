package com.fulihui.duoduoke.demo.web.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.near.toolkit.model.ToString;

/**
 * @Description:
 * @Author: xiaoming
 * @version: v 0.1 2018/11/14 0014 16:58
 */
@Setter
@Getter
public class UserExemptionVO extends ToString {


    @ApiModelProperty(value = "是否成功")
    private boolean           success = false;
    @ApiModelProperty(value = "错误码")
    private String            errorCode;
    @ApiModelProperty(value = "错误码信息")
    private String            errorMessage;







}
