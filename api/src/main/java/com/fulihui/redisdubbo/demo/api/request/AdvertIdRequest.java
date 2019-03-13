package com.fulihui.redisdubbo.demo.api.request;

import lombok.Getter;
import lombok.Setter;
import org.near.servicesupport.request.AbstractServiceRequest;

/**
 *
 * @author lizhi
 * @date 2018-8-30
 */
@Getter
@Setter
public class AdvertIdRequest extends AbstractServiceRequest {
    private static final long serialVersionUID = 2173208572370352221L;

    private Integer id;
}
