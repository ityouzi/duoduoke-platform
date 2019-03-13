package com.fulihui.duoduoke.demo.producer.dal.dao;

import org.apache.ibatis.annotations.Param;

public interface ExtTemplateSendTaskMapper {

    /**
     * 修改任务发送记录
     *
     * @param id
     * @param count
     * @param recordType
     * @return
     */
    int updateRecordCount(@Param("id") Integer id, @Param("count") Integer count, @Param("recordType") int recordType);

    /**
     * 修改任务状态
     *
     * @param id
     * @param state
     * @return
     */
    int updateState(@Param("id") Integer id, @Param("state") Integer state);
}