package com.fulihui.redisdubbo.demo.param.sgin;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.near.toolkit.model.ToString;

/**
 *
 * @author lizhi
 * @date 2018-10-18
 */
@Setter
@Getter
public class FlopTypeParam  extends ToString {
    private static final long serialVersionUID = -6126747304607722642L;
    @ApiModelProperty(value = "翻牌类型  [1:签到翻牌] [2:分享翻牌]'")
    private String            flopType;

}
