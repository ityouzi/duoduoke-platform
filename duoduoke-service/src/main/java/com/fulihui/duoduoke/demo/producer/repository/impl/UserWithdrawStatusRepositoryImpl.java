package com.fulihui.duoduoke.demo.producer.repository.impl;


import com.fulihui.duoduoke.demo.producer.dal.dataobj.UserWithdrawStatus;
import com.fulihui.duoduoke.demo.producer.repository.UserWithdrawStatusRepository;
import com.fulihui.duoduoke.demo.producer.dal.dao.UserWithdrawStatusMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;


/**
 * @author: JY
 * @date: 2018/7/13 10:11
 */
@Service
public class UserWithdrawStatusRepositoryImpl implements UserWithdrawStatusRepository {

    @Autowired
    UserWithdrawStatusMapper userWithdrawStatusMapper;

    /**
     * 插入数据
     *
     * @param model
     * @return
     */
    @Override
    public int insert(UserWithdrawStatus model) {

        model.setGmtCreate(Calendar.getInstance().getTime());

        return userWithdrawStatusMapper.insert(model);
    }

}
