package com.fulihui.duoduoke.demo.producer.repository;

import com.fulihui.duoduoke.demo.api.dto.sign.SignAwardDTO;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.SignAward;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.SignAwardExample;

import java.util.List;


public interface SignAwardRepository {
    long countByExample(SignAwardExample example);

    int insertSelective(SignAward record);

    List<SignAwardDTO> selectByExample(SignAwardExample example);

    SignAwardDTO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SignAward record);

    List<SignAwardDTO> queryLastValidity(String prizeType, String prizeStatus, String activityType);


    long sumPrizeMoney(String userId, List<String> prizeType, List<String> prizeStatus, List<String> activityType);


    long queryExceedDayCount(String prizeStatus, String bindOrderStatus);

    List<SignAwardDTO> queryExceedDay(String prizeStatus, String bindOrderStatus, int page, int size);
}