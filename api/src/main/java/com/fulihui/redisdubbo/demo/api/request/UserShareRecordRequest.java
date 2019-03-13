package com.fulihui.redisdubbo.demo.api.request;

import lombok.Getter;
import lombok.Setter;
import org.near.servicesupport.request.PageRequest;

/**
 * @author lizhi
 * @date 2018-8-30
 */
@Setter
@Getter
public class UserShareRecordRequest extends PageRequest {


    private static final long serialVersionUID = -1850297517987123929L;
    private Integer id;
}
