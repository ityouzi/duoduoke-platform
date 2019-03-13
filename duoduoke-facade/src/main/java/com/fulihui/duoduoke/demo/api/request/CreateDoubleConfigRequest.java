package com.fulihui.duoduoke.demo.api.request;

import lombok.Getter;
import lombok.Setter;
import org.near.servicesupport.request.AbstractServiceRequest;

import java.util.Date;


@Getter
@Setter
public class CreateDoubleConfigRequest extends AbstractServiceRequest {
    //goodsIds 商品ids
    private String goodsIds;
    //翻倍比例
    private float doubleRate;
    //加倍开始时间
    private String startDateStr;
    //加倍结束时间
    private String endDateStr;
    //活动结束时间
    private String activeEndDateStr;
    //加倍开始时间
    private Date startDate;
    //加倍结束时间
    private Date endDate;
    //活动结束时间
    private Date activeEndDate;
    //活动状态
    private String state;
    //多多商品IDList
    private String[] goodsIdList;

    private Integer id;

    private String goodsId;
}
