package com.fulihui.redisdubbo.demo.api.request;

import lombok.Getter;
import lombok.Setter;
import org.near.servicesupport.request.PageRequest;

import java.util.List;

/**
 * @author: JY
 * @date: 2018/8/13 16:53
 */
@Setter @Getter
public class SendTaskRequest extends PageRequest {

    private List<Integer> state;

    private Integer type;

}
