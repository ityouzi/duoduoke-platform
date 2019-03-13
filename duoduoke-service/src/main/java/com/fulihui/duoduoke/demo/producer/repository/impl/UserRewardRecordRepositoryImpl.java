package com.fulihui.duoduoke.demo.producer.repository.impl;

import com.fulihui.duoduoke.demo.api.dto.UserRewardRecordDTO;
import com.fulihui.duoduoke.demo.api.util.Collections;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.UserRewardRecord;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.UserRewardRecordExample;
import com.fulihui.duoduoke.demo.producer.repository.UserRewardRecordRepository;
import com.fulihui.duoduoke.demo.producer.dal.dao.ExtUserRewardRecordMapper;
import com.fulihui.duoduoke.demo.producer.dal.dao.UserRewardRecordMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @Description:
 * @Author: xiaoming
 * @version: v 0.1 2018/9/3 0003 17:00
 */
@Repository
public class UserRewardRecordRepositoryImpl implements UserRewardRecordRepository {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserRewardRecordMapper userRewardRecordMapper;

    @Autowired
    private ExtUserRewardRecordMapper extUserRewardRecordMapper;

    @Override
    public Integer insert(UserRewardRecord record) {
        record.setCreateTime(new Date());
        record.setUpdateTime(new Date());
        return userRewardRecordMapper.insert(record);
    }

    @Override
    public List<UserRewardRecordDTO> query(UserRewardRecordExample example) {
        List<UserRewardRecord> userRewardRecords = userRewardRecordMapper.selectByExample(example);

        if (CollectionUtils.isEmpty(userRewardRecords)) {
            return Collections.emptyList();
        }
        return userRewardRecords.stream().map(it -> {
            UserRewardRecordDTO dto = new UserRewardRecordDTO();
            BeanUtils.copyProperties(it, dto);
            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public long count(UserRewardRecordExample example) {
        return userRewardRecordMapper.countByExample(example);
    }

    @Override
    public Double sumPercent(String userId
            , String orderSn) {
        return extUserRewardRecordMapper.sumPercent(userId, orderSn);
    }
}
