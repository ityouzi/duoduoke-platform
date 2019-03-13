package com.fulihui.redisdubbo.demo.producer.repository.impl;


import com.fulihui.redisdubbo.demo.api.dto.sign.SignAwardDTO;
import com.fulihui.redisdubbo.demo.api.util.Collections;
import com.fulihui.redisdubbo.demo.producer.dal.dao.ExtSignAwardMapper;
import com.fulihui.redisdubbo.demo.producer.dal.dao.SignAwardMapper;
import com.fulihui.redisdubbo.demo.producer.dal.dataobj.SignAward;
import com.fulihui.redisdubbo.demo.producer.dal.dataobj.SignAwardExample;
import com.fulihui.redisdubbo.demo.producer.repository.SignAwardRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by lizhi on 2018-10-17.
 */
@Repository
public class SignAwardRepositoryImpl implements SignAwardRepository {
    @Autowired
    SignAwardMapper signAwardMapper;
    @Autowired
    ExtSignAwardMapper extSignAwardMapper;

    public static List<SignAwardDTO> convert(List<SignAward> list) {
        if (CollectionUtils.isEmpty(list)) {
            return Collections.emptyList();
        }
        return list.stream().map(it -> {
            SignAwardDTO dto = new SignAwardDTO();
            BeanUtils.copyProperties(it, dto);
            return dto;
        }).collect(Collectors.toList());
    }

    public static SignAwardDTO convert(SignAward item) {

        if (item == null) {
            return null;
        }
        SignAwardDTO dto = new SignAwardDTO();
        BeanUtils.copyProperties(item, dto);
        return dto;

    }

    @Override
    public long countByExample(SignAwardExample example) {
        return signAwardMapper.countByExample(example);
    }

    @Override
    public int insertSelective(SignAward record) {
        record.setGmtCreate(new Date());
        record.setGmtModified(new Date());
        return signAwardMapper.insertSelective(record);
    }

    @Override
    public List<SignAwardDTO> selectByExample(SignAwardExample example) {
        List<SignAward> list = signAwardMapper.selectByExample(example);
        return convert(list);
    }

    @Override
    public SignAwardDTO selectByPrimaryKey(Integer id) {
        SignAward signAward = signAwardMapper.selectByPrimaryKey(id);
        return convert(signAward);
    }

    @Override
    public int updateByPrimaryKeySelective(SignAward record) {
        record.setGmtModified(new Date());
        return signAwardMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<SignAwardDTO> queryLastValidity(String prizeType, String prizeStatus, String activityType) {
        List<SignAward> list = extSignAwardMapper.queryLastValidity(prizeType, prizeStatus, activityType);
        return convert(list);
    }

    @Override
    public long sumPrizeMoney(String userId, List<String> prizeType, List<String> prizeStatus, List<String> activityType) {
        return extSignAwardMapper.querySumPrizeMoney(userId, prizeType, prizeStatus, activityType);
    }

    @Override
    public long queryExceedDayCount(String prizeStatus, String bindOrderStatus) {
        return extSignAwardMapper.queryExceedDayCount(prizeStatus, bindOrderStatus);
    }

    @Override
    public List<SignAwardDTO> queryExceedDay(String prizeStatus, String bindOrderStatus, int page, int size) {
        List<SignAward> list = extSignAwardMapper.queryExceedDay(prizeStatus, bindOrderStatus, page, size);
        return convert(list);
    }

}
