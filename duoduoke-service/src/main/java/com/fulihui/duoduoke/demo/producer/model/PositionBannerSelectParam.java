package com.fulihui.duoduoke.demo.producer.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class PositionBannerSelectParam {

    private List<Long> positionBannerIds;

    private Date startTime;

    private Date endTime;

    private String status;

}
