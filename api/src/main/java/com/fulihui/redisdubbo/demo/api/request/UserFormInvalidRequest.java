package com.fulihui.redisdubbo.demo.api.request;

import lombok.Getter;
import lombok.Setter;
import org.near.servicesupport.request.AbstractServiceRequest;

/**
 * @author lizhi
 * @date 2018-7-13
 */
@Setter @Getter
public class UserFormInvalidRequest extends AbstractServiceRequest {
    private static final long serialVersionUID = -6703049786381802947L;
    /**
     * @see com.fulihui.duoduoke.facade.enums.SwitchEnum
     */
    private String formStatus;

    private Integer day;

    private String desc;
}
