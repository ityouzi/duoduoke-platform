package com.fulihui.redisdubbo.demo.api.request;

import lombok.Getter;
import lombok.Setter;
import org.near.servicesupport.request.PageRequest;

import java.util.Date;
import java.util.List;

/**
 * @Description:
 * @Author: xiaoming
 * @version: v 0.1 2018/11/13 0013 14:26
 */
@Setter
@Getter
public class ExemptionRequest extends PageRequest {

    private static final long serialVersionUID = 2343680734871598491L;
    /**
     * AdvertStateEnum
     */
    private String            state;

    /**
     *
     *
     * advert.start_time
     * 开始时间
     *
     * @mbg.generated 2018-08-02 11:24:12
     */
    private Date              startTime;

    /**
     *
     *
     * advert.stop_time
     * 结束时间
     *
     * @mbg.generated 2018-08-02 11:24:12
     */
    private Date              stopTime;

    /**
     * 活动Id
     */
    private Integer           activityId;

    /**
     * 多个活动
     */
    private List<Integer>     activityIds;

    /**
     * 商品Id
     */
    private Long              goodsId;

    private Integer           id;

}
