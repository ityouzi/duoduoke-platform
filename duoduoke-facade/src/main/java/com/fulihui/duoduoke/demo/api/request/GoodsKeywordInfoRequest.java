package com.fulihui.duoduoke.demo.api.request;

import lombok.Getter;
import lombok.Setter;
import org.near.servicesupport.request.PageRequest;

/**
 * @author Administrator
 */
@Setter
@Getter
public class GoodsKeywordInfoRequest extends PageRequest {

    private static final long serialVersionUID = 2297006254125276368L;
    private String            keyword;

}