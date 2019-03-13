package com.fulihui.duoduoke.demo.web.vo.sign;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.near.toolkit.model.ToString;

/**
 *
 * @author lizhi
 * @date 2018-10-17
 */
@Setter
@Getter
public class SignQuerySupplementVO extends ToString {
    private static final long serialVersionUID = -4267395599245166452L;

    @ApiModelProperty(value = "分享标题")
    private String            title;
    @ApiModelProperty(value = "分享图")
    private String            imgUrl;
    @ApiModelProperty(value = "能不能补签,isSupplement=可以补签，false =今天补签达到上线")
    private Boolean           isSupplement;
    @ApiModelProperty(value = "补签的周期时间")
    private String            cycleTime;
}
