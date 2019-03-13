package com.fulihui.duoduoke.demo.web.param.sgin;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.near.webmvcsupport.view.PageForm;

/**
 *
 * @author lizhi
 * @date 2018-10-15
 */
@Getter
@Setter
public class UserSignAwardParam extends PageForm {
    private static final long serialVersionUID = -5778703972686014917L;
    @ApiModelProperty("奖品状态,[0:未使用, 1:已绑定, 2:奖金已发放, 3: 已过期]")
    private String            awardStatus;
}