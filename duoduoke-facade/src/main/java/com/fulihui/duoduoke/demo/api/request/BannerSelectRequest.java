package com.fulihui.duoduoke.demo.api.request;

import lombok.Getter;
import lombok.Setter;
import org.near.toolkit.model.ToString;

@Getter
@Setter
public class BannerSelectRequest  extends ToString {

    private String positionCode;
    private String moduleCode;
    private String status;
    private String hasTimeCondition;

}
