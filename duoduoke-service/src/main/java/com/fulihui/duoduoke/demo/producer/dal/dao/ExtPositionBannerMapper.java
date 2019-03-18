package com.fulihui.duoduoke.demo.producer.dal.dao;


import com.fulihui.duoduoke.demo.api.dto.BannerDto;
import com.fulihui.duoduoke.demo.api.request.BannerSelectRequest;


import java.util.List;

public interface ExtPositionBannerMapper {

    List<BannerDto> selectPositionBanner(BannerSelectRequest bannerSelectRequest);

}

