package com.fulihui.duoduoke.demo.api.request;

import lombok.Getter;
import lombok.Setter;
import org.near.servicesupport.request.PageRequest;

/**
 * @author: JY
 * @date: 2018/9/3 15:53
 */
@Setter
@Getter
public class RedPackageFieldRequest extends PageRequest {

    private Integer id;

    /**
     * 专场名称
     */
    private String  title;

    /**
     * 专场状态[1:有效][2:无效]
     */
    private Short   state;

}
