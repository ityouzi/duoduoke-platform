package com.fulihui.duoduoke.demo.web.integration.impl;


import com.fulihui.duoduoke.demo.api.api.sign.SignAwardService;
import com.fulihui.duoduoke.demo.api.dto.sign.SignAwardDTO;
import com.fulihui.duoduoke.demo.api.request.sign.SignAwardRequest;
import com.fulihui.duoduoke.demo.web.integration.SignAwardServiceClient;
import org.near.servicesupport.result.TPageResult;
import org.near.servicesupport.result.TSingleResult;
import org.near.servicesupport.util.ServiceResultUtil;
import org.springframework.stereotype.Component;

/**
 * Created by lizhi on 2018-10-17.
 */
@Component
public class SignAwardServiceClientImpl implements SignAwardServiceClient {
    @org.apache.dubbo.config.annotation.Reference
    SignAwardService signAwardService;

    @Override
    public TPageResult<SignAwardDTO> queryPage(SignAwardRequest request) {
        TPageResult<SignAwardDTO> result = signAwardService.queryPage(request);
        ServiceResultUtil.checkResult(result);
        return result;
    }


    @Override
    public TSingleResult<SignAwardDTO> selectByPrimaryKey(SignAwardRequest request) {
        TSingleResult<SignAwardDTO> result = signAwardService.selectByPrimaryKey(request);
        ServiceResultUtil.checkResult(result);
        return result;
    }

    @Override
    public TSingleResult<Long> sumPrizeMoney(SignAwardRequest request) {
        TSingleResult<Long> result = signAwardService.sumPrizeMoney(request);
        ServiceResultUtil.checkResult(result);
        return result;
    }
}
