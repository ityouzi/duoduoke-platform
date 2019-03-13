package com.fulihui.duoduoke.demo.web.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.near.toolkit.model.ToString;

/**
 * @author lizhi
 * @date 2018-8-20
 */
@Setter @Getter
public class UserFansVO extends ToString {
    private static final long serialVersionUID = 927916913269966301L;

    @ApiModelProperty(value = "微信昵称")
    private String nickName;
    @ApiModelProperty(value = "用户id")
    private String userId;
    @ApiModelProperty(value = "创建时间")
    private String gmtCreate;
    @ApiModelProperty(value = "头像")
    private String avatarUrl;
}
