package com.fulihui.duoduoke.demo.web.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.near.webmvcsupport.view.PageForm;

/**
 * @author lizhi
 * @date 2018-8-20
 */
@Setter
@Getter
public class FansOrderParam extends PageForm {
    @ApiModelProperty(value = "-1=未支付," +
            "1=已付款," +
            "3=已补贴," +
            "4=无效")
    private String orderStatus;

}
