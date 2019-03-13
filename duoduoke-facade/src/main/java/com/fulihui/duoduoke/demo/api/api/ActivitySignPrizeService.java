package com.fulihui.duoduoke.demo.api.api;


import com.fulihui.duoduoke.demo.api.request.ActivitySignPrizeRequest;
import com.fulihui.duoduoke.demo.api.dto.ActivitySignPrizeDTO;
import org.near.servicesupport.result.TMultiResult;
import org.near.servicesupport.result.TSingleResult;

/**
 * @author: JY
 * @date: 2018/10/11 14:19
 */
public interface ActivitySignPrizeService {

    TMultiResult<ActivitySignPrizeDTO> list(ActivitySignPrizeRequest request);

    TSingleResult<Boolean> insert(ActivitySignPrizeDTO signPrizeDTO);

    TSingleResult<Boolean> update(ActivitySignPrizeDTO signPrizeDTO);
}
