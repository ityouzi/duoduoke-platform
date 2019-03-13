package com.fulihui.redisdubbo.demo.producer.repository.impl;

import com.fulihui.redisdubbo.demo.api.dto.WechatAuthDTO;
import com.fulihui.redisdubbo.demo.api.enums.UserTypeEnum;
import com.fulihui.redisdubbo.demo.producer.dal.dao.WechatAuthMapper;
import com.fulihui.redisdubbo.demo.producer.dal.dataobj.WechatAuth;
import com.fulihui.redisdubbo.demo.producer.dal.dataobj.WechatAuthExample;
import com.fulihui.redisdubbo.demo.producer.repository.WechatAuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
 * @author Willard Hu on 2017/10/31.
 */
@Repository
public class WechatAuthRepositoryImpl implements WechatAuthRepository {
    @Autowired
    private WechatAuthMapper wechatAuthMapper;

    public static WechatAuthDTO convert(WechatAuth record) {
        if (record == null) {
            return null;
        }
        WechatAuthDTO dto = new WechatAuthDTO();
        dto.setId(record.getId());
        dto.setOpenId(record.getOpenId());
        dto.setUserId(record.getUserId());
        dto.setUserType(record.getUserType());
        dto.setAppid(record.getAppid());
        dto.setUnionid(record.getUnionid());
        dto.setSubscribe(record.getSubscribe());
        dto.setCreateBy(record.getCreateBy());
        dto.setGmtCreate(record.getGmtCreate());
        dto.setModifiedBy(record.getModifiedBy());
        dto.setGmtModified(record.getGmtModified());
        return dto;
    }

    @Override
    public void insert(WechatAuth record, String operator) {
        Date now = new Date();
        record.setGmtCreate(now);
        record.setCreateBy(operator);
        record.setGmtModified(now);
        record.setModifiedBy(operator);
        wechatAuthMapper.insertSelective(record);
    }

    @Override
    public boolean update(WechatAuth record, String operator) {
        record.setGmtModified(new Date());
        record.setModifiedBy(operator);
        return wechatAuthMapper.updateByPrimaryKeySelective(record) > 0;
    }

    @Override
    public boolean delete(String userId, UserTypeEnum userTypeEnum) {
        WechatAuthExample example = new WechatAuthExample();
        example.createCriteria().andUserIdEqualTo(userId)
                .andUserTypeEqualTo(userTypeEnum.getCode());
        return wechatAuthMapper.deleteByExample(example) > 0;
    }

    @Override
    public WechatAuthDTO queryByOpenId(String openId, UserTypeEnum userTypeEnum) {
        WechatAuthExample example = new WechatAuthExample();
        example.createCriteria().andOpenIdEqualTo(openId)
                .andUserTypeEqualTo(userTypeEnum.getCode());
        List<WechatAuth> list = wechatAuthMapper.selectByExample(example);
        return CollectionUtils.isEmpty(list) ? null : convert(list.get(0));
    }

    @Override
    public WechatAuthDTO queryByUserId(String userId, UserTypeEnum userTypeEnum) {
        WechatAuthExample example = new WechatAuthExample();
        example.createCriteria().andUserIdEqualTo(userId)
                .andUserTypeEqualTo(userTypeEnum.getCode());
        List<WechatAuth> list = wechatAuthMapper.selectByExample(example);
        return CollectionUtils.isEmpty(list) ? null : convert(list.get(0));
    }
}
