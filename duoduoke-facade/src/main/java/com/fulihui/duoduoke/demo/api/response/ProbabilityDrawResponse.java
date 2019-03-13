package com.fulihui.duoduoke.demo.api.response;


import com.fulihui.duoduoke.demo.api.dto.ActivitySignPrizeDTO;
import lombok.Getter;
import lombok.Setter;
import org.near.toolkit.model.ToString;

import java.util.List;

/**
 * @author lizhi
 * @date 2018-10-19
 */
@Setter
@Getter
public class ProbabilityDrawResponse extends ToString {
    private static final long serialVersionUID = 2736634633127983810L;
    private Integer prizeId;

    private List<ActivitySignPrizeDTO> activityPrize;
    private String userId;
    private Integer signAwardId;

}
