package com.fulihui.duoduoke.demo.api.request;

import lombok.Getter;
import lombok.Setter;
import org.near.servicesupport.request.PageRequest;

@Getter
@Setter
public class GoodsDoublesRewardSelectRequest extends PageRequest{

    //状态
    private String state;
    //条件
    private String strKey;
    //条件内容
    private String strValue;
    //id
    private String id;

}
