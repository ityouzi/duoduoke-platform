package com.fulihui.duoduoke.demo.web.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.near.webmvcsupport.view.PageForm;

/**
 * @author lizhi
 * @date 2018-8-20
 */
@Setter @Getter
public class UserFansParam extends PageForm {
    @ApiModelProperty(value = "1=查询一级粉丝,2=查询二级粉丝")
    private String level;

}
