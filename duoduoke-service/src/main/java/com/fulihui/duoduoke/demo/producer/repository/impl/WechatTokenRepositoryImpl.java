package com.fulihui.duoduoke.demo.producer.repository.impl;

import com.fulihui.duoduoke.demo.api.dto.WechatTokenDTO;
import com.fulihui.duoduoke.demo.api.enums.WechatTokenTypeEnum;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.WechatToken;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.WechatTokenExample;
import com.fulihui.duoduoke.demo.producer.repository.WechatTokenRepository;
import com.fulihui.duoduoke.demo.producer.dal.dao.WechatTokenMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lizhi
 */
@Repository
public class WechatTokenRepositoryImpl implements WechatTokenRepository {
    @Autowired
    private WechatTokenMapper wechatTokenMapper;

    @Override
    public void insert(WechatToken record, String operator) {
        Date now = new Date();
        record.setGmtCreate(now);
        record.setCreateBy(operator);
        record.setGmtModified(now);
        record.setModifiedBy(operator);
        wechatTokenMapper.insertSelective(record);
    }

    @Override
    public boolean update(WechatToken record, String operator) {
        record.setGmtModified(new Date());
        record.setModifiedBy(operator);
        return wechatTokenMapper.updateByPrimaryKeySelective(record) > 0;
    }

    @Override
    public WechatToken queryByType(String appid, WechatTokenTypeEnum tokenType) {
        WechatTokenExample example = new WechatTokenExample();
        example.createCriteria().andAppidEqualTo(appid).andTokenTypeEqualTo(tokenType.getCode());
        List<WechatToken> list = wechatTokenMapper.selectByExample(example);
        return CollectionUtils.isEmpty(list) ? null : list.get(0);
    }

    @Override
    public int updateByExampleSelective(WechatToken record, WechatTokenExample example) {
        record.setGmtModified(new Date());
        return wechatTokenMapper.updateByExampleSelective(record, example);
    }

    @Override
    public long countByExample(WechatTokenExample example) {
        return wechatTokenMapper.countByExample(example);
    }

    @Override
    public List<WechatTokenDTO> selectByExample(WechatTokenExample example) {
        List<WechatToken> list = wechatTokenMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(list)) {
            return Collections.emptyList();
        }
        return list.stream().map(item -> {
            WechatTokenDTO dto = new WechatTokenDTO();
            BeanUtils.copyProperties(item, dto);
            return dto;
        }).collect(Collectors.toList());
    }
}
