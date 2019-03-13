package com.fulihui.redisdubbo.demo.producer.repository;

import com.fulihui.redisdubbo.demo.api.dto.sign.SignUserCountDTO;
import com.fulihui.redisdubbo.demo.producer.dal.dataobj.SignUserCountExample;

import java.util.Date;
import java.util.List;


/**
 * Created by lizhi on 2018-10-12.
 */
public interface SignUserCountRepository {

    List<SignUserCountDTO> query(SignUserCountExample example);

    long count(SignUserCountExample example);

    int save(SignUserCountDTO dto);

    int update(SignUserCountDTO dto);

    SignUserCountDTO query(String userId, Date cycleTime);
}
