package com.fulihui.duoduoke.demo.api.request;

import lombok.Getter;
import lombok.Setter;
import org.near.servicesupport.request.PageRequest;

import java.util.Date;

/**
 * @author: JY
 * @date: 2018/8/1 14:52
 */
@Setter @Getter
public class UserDetailAdminRequest extends PageRequest {

    /**
     * 用户id
     */
    private String userId;

    /**
     * 推荐人id
     */
    private String userReferee;

    /**
     * 注册时间
     */
    private Date startTime;

    /**
     * 注册时间
     */
    private Date endTime;
}
