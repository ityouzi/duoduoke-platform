package com.fulihui.redisdubbo.demo.producer.repository;

import com.fulihui.redisdubbo.demo.api.dto.UserRewardRecordDTO;
import com.fulihui.redisdubbo.demo.producer.dal.dataobj.UserRewardRecord;
import com.fulihui.redisdubbo.demo.producer.dal.dataobj.UserRewardRecordExample;

import java.util.List;


public interface UserRewardRecordRepository {

    Integer insert(UserRewardRecord record);


    List<UserRewardRecordDTO> query(UserRewardRecordExample example);

    long count(UserRewardRecordExample example);

    Double sumPercent(String userId, String orderSn);

}