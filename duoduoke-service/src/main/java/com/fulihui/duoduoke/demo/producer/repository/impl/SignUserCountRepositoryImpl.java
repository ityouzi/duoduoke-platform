package com.fulihui.duoduoke.demo.producer.repository.impl;


import com.fulihui.duoduoke.demo.api.dto.sign.SignUserCountDTO;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.SignUserCount;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.SignUserCountExample;
import com.fulihui.duoduoke.demo.producer.repository.SignUserCountRepository;
import com.fulihui.duoduoke.demo.producer.dal.dao.SignUserCountMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Created by lizhi on 2018-10-12.
 */
@Repository
public class SignUserCountRepositoryImpl implements SignUserCountRepository {
    @Autowired
    SignUserCountMapper signUserCountMapper;

    @Override
    public List<SignUserCountDTO> query(SignUserCountExample example) {

        return conv(signUserCountMapper.selectByExample(example));

    }

    @Override
    public long count(SignUserCountExample example) {

        return signUserCountMapper.countByExample(example);
    }

    private SignUserCountDTO conv(SignUserCount src) {
        if (src == null) {
            return null;
        }
        SignUserCountDTO target = new SignUserCountDTO();
        BeanUtils.copyProperties(src, target);
        return target;
    }

    private List<SignUserCountDTO> conv(List<SignUserCount> list) {
        if (CollectionUtils.isEmpty(list)) {
            return Collections.emptyList();
        }
        return list.stream().map(this::conv).collect(Collectors.toList());
    }

    @Override
    public int save(SignUserCountDTO dto) {
        SignUserCount count = new SignUserCount();
        BeanUtils.copyProperties(dto, count);
        count.setGmtCreate(new Date());
        count.setGmtModified(new Date());
        return signUserCountMapper.insertSelective(count);
    }

    @Override
    public int update(SignUserCountDTO dto) {
        SignUserCount count = new SignUserCount();
        BeanUtils.copyProperties(dto, count);
        count.setGmtModified(new Date());
        return signUserCountMapper.updateByPrimaryKeySelective(count);

    }

    @Override
    public SignUserCountDTO query(String userId, Date cycleTime) {
        SignUserCountExample example = new SignUserCountExample();
        SignUserCountExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId);
        criteria.andCycleTimeEqualTo(cycleTime);
        List<SignUserCount> list = signUserCountMapper.selectByExample(example);
        if (com.fulihui.duoduoke.demo.api.util.Collections.isEmpty(list)) {
            return null;
        }
        return toDTO(list.get(0));
    }

    private SignUserCountDTO toDTO(SignUserCount count) {
        if (count == null) {
            return null;
        }
        SignUserCountDTO dto = new SignUserCountDTO();
        BeanUtils.copyProperties(count, dto);
        return dto;
    }
}
