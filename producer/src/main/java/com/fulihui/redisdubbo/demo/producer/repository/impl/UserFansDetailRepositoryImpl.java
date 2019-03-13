package com.fulihui.redisdubbo.demo.producer.repository.impl;

import com.fulihui.redisdubbo.demo.api.dto.UserFansDetailDTO;
import com.fulihui.redisdubbo.demo.producer.dal.dao.ExtUserFansDetailMapper;
import com.fulihui.redisdubbo.demo.producer.dal.dao.UserFansDetailMapper;
import com.fulihui.redisdubbo.demo.producer.dal.dataobj.UserFansDetail;
import com.fulihui.redisdubbo.demo.producer.dal.dataobj.UserFansDetailExample;
import com.fulihui.redisdubbo.demo.producer.repository.UserFansDetailRepository;
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
 * @date 2018-7-30
 */
@Repository
public class UserFansDetailRepositoryImpl implements UserFansDetailRepository {
    @Autowired
    private UserFansDetailMapper userFansDetailMapper;
    @Autowired
    private ExtUserFansDetailMapper extUserFansDetailMapper;


    @Override
    public void insert(UserFansDetail record) {
        record.setGmtCreate(new Date());
        record.setGmtModified(new Date());
        userFansDetailMapper.insertSelective(record);
    }

    @Override
    public boolean update(UserFansDetail record) {
        record.setGmtModified(new Date());
        return userFansDetailMapper.updateByPrimaryKeySelective(record) > 0;
    }

    @Override
    public boolean delete(String userId) {
        UserFansDetailExample example = new UserFansDetailExample();
        example.createCriteria().andUserIdEqualTo(userId);
        return userFansDetailMapper.deleteByExample(example) > 0;
    }

    @Override
    public List<UserFansDetailDTO> query(String userId, Date statisticsDate) {
        UserFansDetailExample example = new UserFansDetailExample();
        example.createCriteria().andUserIdEqualTo(userId).andStatisticsDateEqualTo(statisticsDate);
        List<UserFansDetail> list = userFansDetailMapper.selectByExample(example);
        return convert(list);

    }

    @Override
    public List<UserFansDetailDTO> querySumByUserId(String userId, Date gmtCreate) {
        List<UserFansDetail> list = extUserFansDetailMapper.querySumByUserId(userId, gmtCreate);
        return convert(list);
    }

    private List<UserFansDetailDTO> convert(List<UserFansDetail> list) {
        if (CollectionUtils.isEmpty(list)) {
            return Collections.emptyList();
        }
        return list.stream().map(this::convert).collect(Collectors.toList());
    }

    private UserFansDetailDTO convert(UserFansDetail item) {
        if (item == null) {
            return null;
        }
        UserFansDetailDTO dto = new UserFansDetailDTO();
        BeanUtils.copyProperties(item, dto);
        return dto;
    }
}
