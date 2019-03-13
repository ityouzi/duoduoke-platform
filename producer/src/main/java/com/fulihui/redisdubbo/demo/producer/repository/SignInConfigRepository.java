package com.fulihui.redisdubbo.demo.producer.repository;

import com.fulihui.redisdubbo.demo.api.dto.sign.SignInConfigDTO;
import com.fulihui.redisdubbo.demo.producer.dal.dataobj.SignInConfig;
import com.fulihui.redisdubbo.demo.producer.dal.dataobj.SignInConfigExample;

import java.util.List;

/**
 * @author Administrator
 */
public interface SignInConfigRepository {

    long countByExample(SignInConfigExample example);

    int insertSelective(SignInConfig record);

    List<SignInConfigDTO> selectByExample(SignInConfigExample example);

}