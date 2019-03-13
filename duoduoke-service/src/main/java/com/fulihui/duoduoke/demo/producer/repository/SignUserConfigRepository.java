package com.fulihui.duoduoke.demo.producer.repository;

import com.fulihui.duoduoke.demo.api.dto.sign.SignUserConfigDTO;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.SignUserConfig;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.SignUserConfigExample;

import java.util.List;


public interface SignUserConfigRepository {

    long countByExample(SignUserConfigExample example);

    int insertSelective(SignUserConfig record);

    int updateSelective(SignUserConfig record);

    List<SignUserConfigDTO> selectByExample(SignUserConfigExample example);

    SignUserConfigDTO selectByPrimaryKey(String userId);

}