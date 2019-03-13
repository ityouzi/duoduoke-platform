package com.fulihui.duoduoke.demo.api.api;


import com.fulihui.duoduoke.demo.api.request.UserPosterImgRequest;
import com.fulihui.duoduoke.demo.api.request.UserQrcodeImgRequest;
import com.fulihui.duoduoke.demo.api.dto.UserPosterImgDTO;
import org.near.servicesupport.result.TMultiResult;
import org.near.servicesupport.result.TSingleResult;

/**
 * @Description:
 * @Author: xiaoming
 * @version: v 0.1 2018/7/30 0030 19:09
 */
public interface UserPosterImgService {


    /**
     * 查询
     *
     * @param request
     * @return
     */
    TMultiResult<UserPosterImgDTO> query(UserPosterImgRequest request);


    TSingleResult<String> goodsQrcodeImg(UserQrcodeImgRequest request);


}
