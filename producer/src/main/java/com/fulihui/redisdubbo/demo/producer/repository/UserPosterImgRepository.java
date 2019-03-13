package com.fulihui.redisdubbo.demo.producer.repository;

import com.fulihui.redisdubbo.demo.api.dto.UserPosterImgDTO;
import com.fulihui.redisdubbo.demo.producer.dal.dataobj.UserPosterImg;

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