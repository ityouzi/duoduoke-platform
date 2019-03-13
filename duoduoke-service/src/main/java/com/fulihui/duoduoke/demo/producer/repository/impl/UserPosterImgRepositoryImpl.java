package com.fulihui.duoduoke.demo.producer.repository.impl;

import com.fulihui.duoduoke.demo.api.dto.UserPosterImgDTO;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.UserPosterImg;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.UserPosterImgExample;
import com.fulihui.duoduoke.demo.producer.repository.UserPosterImgRepository;
import com.fulihui.duoduoke.demo.producer.dal.convert.UserPosterImgConvert;
import com.fulihui.duoduoke.demo.producer.dal.dao.UserPosterImgMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import java.util.Date;
import java.util.List;


/**
 * @Description:
 * @Author: xiaoming
 * @version: v 0.1 2018/7/30 0030 18:19
 */
@Repository
public class UserPosterImgRepositoryImpl implements UserPosterImgRepository {

    @Autowired
    private UserPosterImgMapper userPosterImgMapper;


    @Override
    public int insert(UserPosterImg userPosterImg) {
        Assert.notNull(userPosterImg, "UserPosterImg is not null");
        userPosterImg.setGmtCreate(new Date());
        userPosterImg.setGmtModified(new Date());
        return userPosterImgMapper.insert(userPosterImg);
    }

    @Override
    public List<UserPosterImgDTO> query(String userId) {
        UserPosterImgExample example = new UserPosterImgExample();
        UserPosterImgExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId);
        List<UserPosterImg> userPosterImgs = userPosterImgMapper.selectByExample(example);
        return UserPosterImgConvert.convert(userPosterImgs);
    }


}
