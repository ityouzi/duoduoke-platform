package com.fulihui.duoduoke.demo.producer.repository;

import com.fulihui.duoduoke.demo.api.dto.UserRewardRecordDTO;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.UserRewardRecord;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.UserRewardRecordExample;

import java.util.List;


public interface UserRewardRecordRepository {

    Integer insert(UserRewardRecord record);


    List<UserRewardRecordDTO> query(UserRewardRecordExample example);

    long count(UserRewardRecordExample example);

    Double sumPercent(String userId, String orderSn);

}