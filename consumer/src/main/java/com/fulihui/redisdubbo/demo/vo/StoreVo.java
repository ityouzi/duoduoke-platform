package com.fulihui.redisdubbo.demo.vo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class StoreVo  {

    /**
     * id
     * */
    private Long id;
    /**
     * 专场图
     * */
    private String storeUrl;
    /**
     * 前端展现位置
     * */
    private int preferenceNumber;

}
