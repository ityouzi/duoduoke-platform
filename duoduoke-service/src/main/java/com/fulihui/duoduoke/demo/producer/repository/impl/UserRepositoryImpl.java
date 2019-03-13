/*
 * Copyright (c) 2017.  Willard Hu. All rights reserved.
 */

package com.fulihui.duoduoke.demo.producer.repository.impl;

import com.fulihui.duoduoke.demo.api.dto.UserDTO;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.UserDetail;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.UserDetailExample;
import com.fulihui.duoduoke.demo.producer.repository.UserRepository;
import com.fulihui.duoduoke.demo.producer.dal.dao.ExtUserDetailMapper;
import com.fulihui.duoduoke.demo.producer.dal.dao.UserDetailMapper;
import org.apache.commons.codec.binary.Base64;
import org.near.toolkit.common.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @author lizhi
 */
@Repository
public class UserRepositoryImpl implements UserRepository {
    @Autowired
    ExtUserDetailMapper extUserDetailMapper;
    @Autowired
    private UserDetailMapper userDetailMapper;

    public static void main(String[] args) {
        System.out.println(new String(Base64.decodeBase64("56aP5Yip5aSn5L2/5a+85biILeWwj+m6pg==")));
    }

    @Override
    public void insert(UserDetail record, String operator) {
        Date now = new Date();
        // emoji 处理
        if (StringUtil.isNotBlank(record.getNickname())) {
            record.setNickname(Base64.encodeBase64String(record.getNickname().getBytes()));
        }
        record.setGmtCreate(now);
        record.setCreateBy(operator);
        record.setGmtModified(now);
        record.setModifiedBy(operator);

        userDetailMapper.insertSelective(record);
    }

    @Override
    public boolean update(UserDetail record, String operator) {
        record.setGmtModified(new Date());
        record.setModifiedBy(operator);
        return extUserDetailMapper.updateByPrimaryKeySelective(record) > 0;
    }

    @Override
    public UserDTO queryByUserId(String userId) {
        UserDetailExample example = new UserDetailExample();
        example.createCriteria().andUserIdEqualTo(userId);
        List<UserDetail> userDetails = userDetailMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(userDetails)) {
            return null;
        }
        return convert(userDetails).get(0);
    }

    @Override
    public List<UserDTO> query(UserDetailExample example) {
        List<UserDetail> list = userDetailMapper.selectByExample(example);
        return convert(list);
    }

    @Override
    public long count(UserDetailExample example) {
        return userDetailMapper.countByExample(example);
    }

    @Override
    public List<UserDTO> queryByUserIds(List<String> userIds) {
        UserDetailExample example = new UserDetailExample();
        example.createCriteria().andUserIdIn(userIds);
        return convert(userDetailMapper.selectByExample(example));
    }

    private UserDTO convert(UserDetail src) {
        if (src == null) {
            return null;
        }
        UserDTO target = new UserDTO();
        target.setUserId(src.getUserId());
        if (StringUtil.isNotBlank(src.getNickname())) {
            target.setNickname(new String(Base64.decodeBase64(src.getNickname())));
        }
        // emoji 处理
        target.setName(src.getName());
        target.setGender(src.getGender());
        target.setAvatarUrl(src.getAvatarUrl());
        target.setIdCard(src.getIdCard());
        target.setId(src.getId());
        target.setMobileNo(src.getMobileNo());
        target.setBirthday(src.getBirthday());
        target.setCreateBy(src.getCreateBy());
        target.setMarker(src.getMarker());
        target.setGmtCreate(src.getGmtCreate());
        target.setModifiedBy(src.getModifiedBy());
        target.setGmtModified(src.getGmtModified());
        target.setUserReferee(src.getUserReferee());
        target.setRegDate(src.getRegDate());
        target.setUserSource(src.getUserSource());
        target.setLevel(src.getLevel());
        target.setRegUrl(src.getRegUrl());
        target.setUserRefereeIds(src.getUserRefereeIds());
        return target;
    }

    private List<UserDTO> convert(List<UserDetail> list) {
        if (CollectionUtils.isEmpty(list)) {
            return Collections.emptyList();
        }
        return list.stream().map(this::convert).collect(Collectors.toList());
    }
}
