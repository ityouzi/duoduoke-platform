package com.fulihui.duoduoke.demo.api.request;


import lombok.Getter;
import lombok.Setter;
import org.near.servicesupport.request.PageRequest;

import java.util.Date;

/**
 * @author lizhi
 * @date 2018-7-13
 */
@Setter @Getter
public class UserFormRequest extends PageRequest {
    private static final long serialVersionUID = -1633989391345839918L;
    /**
     * 开始时间
     */
    private Date startDate;
    /**
     * 结束时间
     */
    private Date endDate;
    /**
     * 状态
     */
    private String status;
}
