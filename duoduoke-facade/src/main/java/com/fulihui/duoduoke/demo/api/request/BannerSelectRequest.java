package com.fulihui.duoduoke.demo.api.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BannerSelectRequest {

    private String positionCode;
    private String moduleCode;
    private String status;
    private String hasTimeCondition;

}
