package com.fulihui.redisdubbo.demo.api.request;

import lombok.Getter;
import lombok.Setter;
import org.near.servicesupport.request.AbstractServiceRequest;

/**
 * @author lizhi
 * @date 2018-8-28*/
@Setter
@Getter
public class AppSendMessageRequest extends AbstractServiceRequest {

    private static final long serialVersionUID = 7805197063579196017L;
    private Integer           id;
    private String            type;
    private String            userId;
    private String            content;
    private String            formId;
    private String            page;
}
