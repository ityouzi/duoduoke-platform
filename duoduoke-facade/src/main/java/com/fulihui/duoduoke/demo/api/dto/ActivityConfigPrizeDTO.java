package com.fulihui.duoduoke.demo.api.dto;

import lombok.Data;

import java.util.List;

/**
 * @author: JY
 * @date: 2018/10/16 15:10
 */
@Data
public class ActivityConfigPrizeDTO extends ActivityConfigDTO {

    private List<ActivitySignPrizeDTO> activityPrize;

}
