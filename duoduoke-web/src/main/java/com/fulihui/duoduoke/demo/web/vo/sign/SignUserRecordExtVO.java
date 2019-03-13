package com.fulihui.duoduoke.demo.web.vo.sign;

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
public class SignUserRecordExtVO extends ToString {
    private static final long serialVersionUID = -2392944865423915601L;
    @ApiModelProperty(value = "签到时间")
    private String            signTimeExt;
    @ApiModelProperty(value = "签到类型,SELF=自签 ,SUPPLEMENT=补签")
    private String            signType;
    //机会 翻牌
}