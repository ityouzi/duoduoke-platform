package com.fulihui.redisdubbo.demo.api.api;


import com.fulihui.redisdubbo.demo.api.dto.UserPosterImgDTO;
import com.fulihui.redisdubbo.demo.api.request.UserPosterImgRequest;
import com.fulihui.redisdubbo.demo.api.request.UserQrcodeImgRequest;
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
