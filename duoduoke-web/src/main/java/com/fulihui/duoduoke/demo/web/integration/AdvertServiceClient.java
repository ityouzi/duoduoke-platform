package com.fulihui.duoduoke.demo.web.integration;



import com.fulihui.duoduoke.demo.api.dto.AdvertDTO;
import com.fulihui.duoduoke.demo.api.dto.BannerDto;
import com.fulihui.duoduoke.demo.api.request.AdvertRequest;


import com.fulihui.duoduoke.demo.api.request.BannerSelectRequest;
import org.near.servicesupport.result.TMultiResult;
import org.near.servicesupport.result.TSingleResult;

import java.util.List;

/**
 * @Description:
 * @Author: xiaoming
 * @version: v 0.1 2018/8/2 0002 14:30
 */
public interface AdvertServiceClient {

    /**
     * @param request
     * @return
     */
    TMultiResult<AdvertDTO> queryAdvert(AdvertRequest request);


    TSingleResult<List<BannerDto>> selectBanner(BannerSelectRequest bannerSelectRequest);

}
