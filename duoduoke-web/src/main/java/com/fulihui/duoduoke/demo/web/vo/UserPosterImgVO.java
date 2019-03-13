package com.fulihui.duoduoke.demo.web.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @Description:
 * @Author: xiaoming
 * @version: v 0.1 2018/7/31 0031 15:02
 */
@Setter @Getter
public class UserPosterImgVO {

    @ApiModelProperty(value = "主键")
    private Integer id;

    @ApiModelProperty(value = "userId")
    private String userId;

    @ApiModelProperty(value = "海报")
    private String posterImg;
}
