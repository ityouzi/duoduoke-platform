package com.fulihui.redisdubbo.demo.api.request;

import lombok.Getter;
import lombok.Setter;
import org.near.servicesupport.request.PageRequest;

import java.util.Date;

/**
 * @author lizhi
 * @date 2018-8-31
 */
@Setter
@Getter
public class OrderFetchRequest extends PageRequest {
    private static final long serialVersionUID = 304866716839312538L;

    private  Date start;
    private Date end;
}
