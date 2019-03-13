package com.fulihui.duoduoke.demo.api.request;

import lombok.Getter;
import lombok.Setter;
import org.near.servicesupport.request.PageRequest;

import java.util.Date;

/**
 * @author lizhi
 * @date 2018-8-1
 */
@Setter @Getter
public class UserFansDetailRequest extends PageRequest {
    private static final long serialVersionUID = 3579647290233975594L;

    private String userId;

    private Date statisticsDate;

    private Date gmtCreate;
}
