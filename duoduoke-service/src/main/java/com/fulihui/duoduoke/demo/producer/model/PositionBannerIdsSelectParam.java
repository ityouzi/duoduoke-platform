package com.fulihui.duoduoke.demo.producer.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PositionBannerIdsSelectParam {

    private Long positionBannerId;
    private String status;
    private Date startTime;
    private Date endTime;

}
