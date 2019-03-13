package com.fulihui.redisdubbo.demo.param;


import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.near.toolkit.model.ToString;

/**
 * @Description:
 * @Author: xiaoming
 * @version: v 0.1 2018/7/10 0010 18:30
 */
@Setter
@Getter
public class UserImgParam extends ToString {

    @ApiModelProperty("昵称")
    private String nickName;

    @ApiModelProperty("头像")
    private String avatarUrl;


}
