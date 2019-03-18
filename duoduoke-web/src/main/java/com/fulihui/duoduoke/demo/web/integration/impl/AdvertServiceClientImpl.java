package com.fulihui.duoduoke.demo.web.integration.impl;

import com.fulihui.duoduoke.demo.api.api.AdvertService;
import com.fulihui.duoduoke.demo.api.api.BannerService;
import com.fulihui.duoduoke.demo.api.dto.AdvertDTO;
import com.fulihui.duoduoke.demo.api.dto.BannerDto;
import com.fulihui.duoduoke.demo.api.request.AdvertRequest;
import com.fulihui.duoduoke.demo.api.request.BannerSelectRequest;
import com.fulihui.duoduoke.demo.web.integration.AdvertServiceClient;
import org.apache.dubbo.config.annotation.Reference;
import org.near.servicesupport.result.TMultiResult;
import org.near.servicesupport.result.TSingleResult;
import org.near.servicesupport.util.ServiceResultUtil;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author lizhi
 * @date 2018-9-17
 */
@Component
public class AdvertServiceClientImpl implements AdvertServiceClient {
    @Reference
    AdvertService advertService;
    @Reference

    BannerService bannerService;

    @Override
    public TMultiResult<AdvertDTO> queryAdvert(AdvertRequest request) {
        TMultiResult<AdvertDTO> result = advertService.queryAdvert(request);
        ServiceResultUtil.checkResult(result);
        return result;
    }

    @Override
    public TSingleResult<List<BannerDto>> selectBanner(BannerSelectRequest bannerSelectRequest) {
        TSingleResult<List<BannerDto>> result = bannerService.selectBanner(bannerSelectRequest);
        ServiceResultUtil.checkResult(result);
        return result;
    }


}
