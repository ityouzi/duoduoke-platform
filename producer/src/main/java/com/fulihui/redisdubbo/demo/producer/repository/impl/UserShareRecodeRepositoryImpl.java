package com.fulihui.redisdubbo.demo.producer.repository.impl;


import com.fulihui.redisdubbo.demo.producer.dal.dao.UserShareRecordMapper;
import com.fulihui.redisdubbo.demo.producer.dal.dataobj.UserShareRecord;
import com.fulihui.redisdubbo.demo.producer.repository.UserShareRecodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * @Description:
 * @Author: xiaoming
 * @version: v 0.1 2018/8/24 0024 14:37
 */
@Repository
public class UserShareRecodeRepositoryImpl implements UserShareRecodeRepository {

    @Autowired
    private UserShareRecordMapper userShareRecordMapper;

    @Override
    public UserShareRecord selectByPrimaryKey(Integer id) {
        return userShareRecordMapper.selectByPrimaryKey(id);
    }

    @Override
    public int insert(UserShareRecord userShareRecord) {
        userShareRecord.setCreateTime(new Date());
        userShareRecord.setUpdateTime(new Date());
        return userShareRecordMapper.insert(userShareRecord);
    }


}
