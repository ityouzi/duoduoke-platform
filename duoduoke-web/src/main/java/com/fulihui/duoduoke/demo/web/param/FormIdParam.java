package com.fulihui.duoduoke.demo.web.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.near.webmvcsupport.view.PageForm;

/**
 * @author lizhi
 * @date 2018-7-13
 */
@Setter
@Getter
public class FormIdParam extends PageForm {
    private static final long serialVersionUID = -3914528126140749695L;
    /**
     * formId
     */
    @ApiModelProperty("formId")
    private String formId;
}
