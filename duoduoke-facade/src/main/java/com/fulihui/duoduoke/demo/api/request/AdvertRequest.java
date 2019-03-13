package com.fulihui.duoduoke.demo.api.request;

import lombok.Getter;
import lombok.Setter;
import org.near.servicesupport.request.PageRequest;

import java.util.Date;

/**
 * @Description:
 * @Author: xiaoming
 * @version: v 0.1 2018/8/2 0002 14:45
 */
@Setter @Getter
public class AdvertRequest extends PageRequest {


    private static final long serialVersionUID = 2343680734871598491L;
    /**
     * AdvertStateEnum
     */
    private String state;

    /**
     *
     *
     * advert.start_time
     * 开始时间
     *
     * @mbg.generated 2018-08-02 11:24:12
     */
    private Date startTime;

    /**
     *
     *
     * advert.stop_time
     * 结束时间
     *
     * @mbg.generated 2018-08-02 11:24:12
     */
    private Date stopTime;

    /**
     *  类型[1:小程序,0:h5]
     */
    private String type;

}
