package com.fulihui.duoduoke.demo.producer.repository;

import com.fulihui.duoduoke.demo.api.dto.UserPosterImgDTO;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.UserPosterImg;

import java.util.List;


/**
 * @Description:
 * @Author: xiaoming
 * @version: v 0.1 2018/7/30 0030 18:22
 */
public interface UserPosterImgRepository {


    int insert(UserPosterImg userPosterImg);

    List<UserPosterImgDTO> query(String userId);

}