package com.fulihui.redisdubbo.demo.producer.dal.dao;

import com.fulihui.redisdubbo.demo.producer.dal.dataobj.SignUserRecord;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface ExtSignUserRecordMapper {

    boolean modifyCount(SignUserRecord record);

    List<SignUserRecord> select(@Param("cycleTime") Date cycleTime);

    List<SignUserRecord> queryBeforeSignUser(@Param("offset") int offset, @Param("limit") int limit);

}