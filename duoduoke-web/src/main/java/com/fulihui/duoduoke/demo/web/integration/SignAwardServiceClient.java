package com.fulihui.duoduoke.demo.web.integration;


import com.fulihui.duoduoke.demo.api.dto.sign.SignAwardDTO;
import com.fulihui.duoduoke.demo.api.request.sign.SignAwardRequest;
import org.near.servicesupport.result.TPageResult;
import org.near.servicesupport.result.TSingleResult;

/**
 *
 * @author lizhi
 * @date 2018-10-17
 */
public interface SignAwardServiceClient {

    TPageResult<SignAwardDTO> queryPage(SignAwardRequest request);

    TSingleResult<SignAwardDTO> selectByPrimaryKey(SignAwardRequest request);

    TSingleResult<Long> sumPrizeMoney(SignAwardRequest request);
}
