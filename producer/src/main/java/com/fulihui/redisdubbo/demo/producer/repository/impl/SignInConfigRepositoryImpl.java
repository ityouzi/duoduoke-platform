package com.fulihui.redisdubbo.demo.producer.repository.impl;


import com.fulihui.redisdubbo.demo.api.dto.sign.SignInConfigDTO;
import com.fulihui.redisdubbo.demo.producer.dal.convert.SignInConfigConvert;
import com.fulihui.redisdubbo.demo.producer.dal.dao.SignInConfigMapper;
import com.fulihui.redisdubbo.demo.producer.dal.dataobj.SignInConfig;
import com.fulihui.redisdubbo.demo.producer.dal.dataobj.SignInConfigExample;
import com.fulihui.redisdubbo.demo.producer.repository.SignInConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author lizhi
 * @date 2018-10-12
 */
@Repository
public class SignInConfigRepositoryImpl implements SignInConfigRepository {
    @Autowired
    SignInConfigMapper signInConfigMapper;

    @Override
    public long countByExample(SignInConfigExample example) {
        return signInConfigMapper.countByExample(example);
    }

    @Override
    public int insertSelective(SignInConfig record) {
        return signInConfigMapper.insertSelective(record);
    }

    @Override
    public List<SignInConfigDTO> selectByExample(SignInConfigExample example) {
        List<SignInConfig> list = signInConfigMapper.selectByExample(example);
        return SignInConfigConvert.convert(list);
    }

}
