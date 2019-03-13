package com.fulihui.redisdubbo.demo.producer.repository;


import com.fulihui.redisdubbo.demo.api.dto.UserFormRecordDTO;
import com.fulihui.redisdubbo.demo.producer.dal.dataobj.UserFormRecord;
import com.fulihui.redisdubbo.demo.producer.dal.dataobj.UserFormRecordExample;

import java.util.List;

/**
 * @author lizhi
 * @date 2018-7-12
 */
public interface UserFormRepository {
    List<UserFormRecordDTO> query(String userId, String status);

    List<UserFormRecordDTO> query(UserFormRecordExample example);

    void updateInvalid(String formStatus, int day, String desc);

    void update(UserFormRecord record);

    int insert(UserFormRecord record);

    int count(UserFormRecordExample example);
}
