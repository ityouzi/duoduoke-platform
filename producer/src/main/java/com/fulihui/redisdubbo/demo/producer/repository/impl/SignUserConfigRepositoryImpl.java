package com.fulihui.redisdubbo.demo.producer.repository.impl;


import com.fulihui.redisdubbo.demo.api.dto.sign.SignUserConfigDTO;
import com.fulihui.redisdubbo.demo.api.util.Collections;
import com.fulihui.redisdubbo.demo.producer.dal.dao.SignUserConfigMapper;
import com.fulihui.redisdubbo.demo.producer.dal.dataobj.SignUserConfig;
import com.fulihui.redisdubbo.demo.producer.dal.dataobj.SignUserConfigExample;
import com.fulihui.redisdubbo.demo.producer.repository.SignUserConfigRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author lizhi
 * @date 2018-10-12
 */
@Repository
public class SignUserConfigRepositoryImpl implements SignUserConfigRepository {
    @Autowired
    SignUserConfigMapper signUserConfigMapper;

    @Override
    public long countByExample(SignUserConfigExample example) {
        return signUserConfigMapper.countByExample(example);
    }

    @Override
    public int insertSelective(SignUserConfig record) {
        return signUserConfigMapper.insertSelective(record);
    }

    @Override
    public int updateSelective(SignUserConfig record) {
        return signUserConfigMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<SignUserConfigDTO> selectByExample(SignUserConfigExample example) {
        List<SignUserConfig> list = signUserConfigMapper.selectByExample(example);
        return convertConfig(list);
    }

    private List<SignUserConfigDTO> convertConfig(List<SignUserConfig> list) {
        if (Collections.isEmpty(list)) {
            return Collections.emptyList();
        }
        return Collections.transform(list, this::convertConfig);
    }

    private SignUserConfigDTO convertConfig(SignUserConfig item) {
        if (item == null) {
            return null;
        }
        SignUserConfigDTO target = new SignUserConfigDTO();
        BeanUtils.copyProperties(item, target);
        return target;
    }

    @Override
    public SignUserConfigDTO selectByPrimaryKey(String userId) {
        SignUserConfig config = signUserConfigMapper.selectByPrimaryKey(userId);
        return convertConfig(config);
    }
}
