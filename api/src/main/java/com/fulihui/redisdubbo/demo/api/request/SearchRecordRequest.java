package com.fulihui.redisdubbo.demo.api.request;

import lombok.Getter;
import lombok.Setter;
import org.near.servicesupport.request.PageRequest;

import java.util.Date;

/**
 * @author: JY
 * @date: 2018/7/30 11:15
 */
@Setter @Getter
public class SearchRecordRequest extends PageRequest {

    private Date startTime;

    private Date endTime;

}
