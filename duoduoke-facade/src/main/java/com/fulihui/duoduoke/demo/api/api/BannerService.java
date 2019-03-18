package com.fulihui.duoduoke.demo.api.api;


import com.fulihui.duoduoke.demo.api.dto.BannerDto;
import com.fulihui.duoduoke.demo.api.request.BannerAddRequest;
import com.fulihui.duoduoke.demo.api.request.BannerSelectRequest;
import com.fulihui.duoduoke.demo.api.request.BannerUpdateRequest;
import org.near.servicesupport.result.BaseResult;
import org.near.servicesupport.result.TSingleResult;

import java.util.List;

public interface BannerService {

    //1.增加 传参  返回成功失败
    BaseResult addBanner(BannerAddRequest bannerAddRequest);

    //2.删除 传参  返回成功失败
    BaseResult deleteBanner(Long positionBannerId);

    //3.修改 传参  返回成功失败  只能修改 图片 动作 排序  状态
    BaseResult updateBanner(BannerUpdateRequest bannerUpdateRequest);

    //4.查询 传参  返回结果
    TSingleResult<List<BannerDto>> selectBanner(BannerSelectRequest bannerSelectRequest);

}
