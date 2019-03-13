package com.fulihui.redisdubbo.demo.producer.repository.impl;

import com.fulihui.redisdubbo.demo.api.dto.UserFormRecordDTO;
import com.fulihui.redisdubbo.demo.api.enums.SwitchEnum;
import com.fulihui.redisdubbo.demo.api.util.Collections;
import com.fulihui.redisdubbo.demo.producer.dal.dao.ExtUserFormRecordMapper;
import com.fulihui.redisdubbo.demo.producer.dal.dao.UserFormRecordMapper;
import com.fulihui.redisdubbo.demo.producer.dal.dataobj.UserFormRecord;
import com.fulihui.redisdubbo.demo.producer.dal.dataobj.UserFormRecordExample;
import com.fulihui.redisdubbo.demo.producer.repository.UserFormRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Created by lizhi on 2018-7-12.
 */
@Repository
public class UserFormRepositoryImpl implements UserFormRepository {
    @Autowired
    UserFormRecordMapper userFormRecordMapper;

    @Autowired
    ExtUserFormRecordMapper extUserFormRecordMapper;

    @Override
    public List<UserFormRecordDTO> query(String userId, String status) {
        UserFormRecordExample example = new UserFormRecordExample();
        example.setOrderByClause(" create_time desc");
        example.createCriteria().andUserIdEqualTo(userId).andFormStatusEqualTo(status);
        List<UserFormRecord> list = userFormRecordMapper.selectByExample(example);
        return convert(list);


    }

    private List<UserFormRecordDTO> convert(List<UserFormRecord> list) {
        if (CollectionUtils.isEmpty(list)) {
            return Collections.emptyList();
        }
        return list.stream().map(it -> {
            UserFormRecordDTO dto = new UserFormRecordDTO();
            BeanUtils.copyProperties(it, dto);
            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public List<UserFormRecordDTO> query(UserFormRecordExample example) {
        List<UserFormRecord> list = userFormRecordMapper.selectByExample(example);
        return convert(list);
    }

    @Override
    public void updateInvalid(String formStatus, int day, String desc) {
        extUserFormRecordMapper.update(formStatus, day, desc, SwitchEnum.ENABLE.getCode());
    }

    @Override
    public void update(UserFormRecord record) {
        record.setUpdateTime(new Date());
        userFormRecordMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int insert(UserFormRecord record) {
        Assert.notNull(record, "UserFormRepositoryImpl.UserFormRecord is not null");
        record.setCreateTime(new Date());
        record.setUpdateTime(new Date());
        userFormRecordMapper.insertSelective(record);
        return record.getId();
    }

    @Override
    public int count(UserFormRecordExample example) {
        return (int) userFormRecordMapper.countByExample(example);
    }
}
