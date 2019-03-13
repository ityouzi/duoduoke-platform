package com.fulihui.duoduoke.demo.producer.dal.dao;

import org.apache.ibatis.annotations.Param;

public interface ExtUserRewardRecordMapper {

    Double sumPercent(@Param("userId") String userId, @Param("orderSn") String orderSn);


}