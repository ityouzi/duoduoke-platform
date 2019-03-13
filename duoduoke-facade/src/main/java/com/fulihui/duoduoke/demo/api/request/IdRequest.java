package com.fulihui.duoduoke.demo.api.request;

import lombok.Getter;
import lombok.Setter;
import org.near.servicesupport.request.PageRequest;

/**
 * @author Administrator
 */
@Getter
@Setter
public class IdRequest extends PageRequest {
    private static final long serialVersionUID = 2173208572370352221L;

    private Integer           id;

    private String            state;

    private String            bindOrderStatus;
}
