package com.fulihui.duoduoke.demo.producer.repository.impl;

import com.fulihui.duoduoke.demo.api.dto.sign.SignUserRecordDTO;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.SignUserRecord;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.SignUserRecordExample;
import com.fulihui.duoduoke.demo.producer.repository.SignUserRecordRepository;
import com.fulihui.duoduoke.demo.producer.dal.convert.SignUserRecordConvert;
import com.fulihui.duoduoke.demo.producer.dal.dao.ExtSignUserRecordMapper;
import com.fulihui.duoduoke.demo.producer.dal.dao.SignUserRecordMapper;
import org.near.toolkit.common.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


/**
 * @author lizhi
 * @date 2018-10-12
 */
@Repository
public class SignUserRecordRepositoryImpl implements SignUserRecordRepository {
    @Autowired
    SignUserRecordMapper signUserRecordMapper;

    @Autowired
    ExtSignUserRecordMapper extSignUserRecordMapper;

    @Override
    public long countByExample(SignUserRecordExample example) {
        return signUserRecordMapper.countByExample(example);
    }

    @Override
    public int updateByExampleSelective(SignUserRecord record, SignUserRecordExample example) {
        record.setGmtModified(new Date());
        return signUserRecordMapper.updateByExampleSelective(record, example);

    }

    @Override
    public int insertSelective(SignUserRecord record) {
        record.setGmtCreate(new Date());
        record.setGmtModified(new Date());
        return signUserRecordMapper.insertSelective(record);
    }

    @Override
    public boolean update(SignUserRecord record) {
        record.setGmtModified(new Date());
        return signUserRecordMapper.updateByPrimaryKeySelective(record) > 0;
    }

    @Override
    public List<SignUserRecordDTO> selectByExample(SignUserRecordExample example) {
        List<SignUserRecord> list = signUserRecordMapper.selectByExample(example);
        return SignUserRecordConvert.convert(list);
    }

    @Override
    public List<SignUserRecordDTO> queryByCycleTime(String userId, Date cycleTime,
                                                    String sortInfo) {
        SignUserRecordExample example = new SignUserRecordExample();
        if (StringUtil.isNotBlank(sortInfo)) {
            example.setOrderByClause(sortInfo);
        }
        SignUserRecordExample.Criteria criteria = example.createCriteria();
        if (StringUtil.isNotBlank(userId)) {
            criteria.andUserIdEqualTo(userId);
        }

        criteria.andCycleTimeEqualTo(cycleTime);
        List<SignUserRecord> list = signUserRecordMapper.selectByExample(example);
        return SignUserRecordConvert.convert(list);
    }

    @Override
    public List<SignUserRecordDTO> queryBySignTimeExt(String userId, Date signTimeExt,
                                                      String sortInfo) {
        SignUserRecordExample example = new SignUserRecordExample();
        if (StringUtil.isNotBlank(sortInfo)) {
            example.setOrderByClause(sortInfo);
        }

        example.createCriteria().andSignTimeExtEqualTo(signTimeExt).andUserIdEqualTo(userId);
        List<SignUserRecord> list = signUserRecordMapper.selectByExample(example);
        return SignUserRecordConvert.convert(list);
    }

    @Override
    public List<SignUserRecordDTO> queryBySignTimeExt(Date signTimeExt, String sortInfo, int page,
                                                      int rows) {
        SignUserRecordExample example = new SignUserRecordExample();
        if (StringUtil.isNotBlank(sortInfo)) {
            example.setOrderByClause(sortInfo);
        }
        int i = page > 1 ? (page - 1) * rows : 0;
        example.setOffset(i);
        example.setLimit(rows);
        example.createCriteria().andSignTimeExtEqualTo(signTimeExt);
        List<SignUserRecord> list = signUserRecordMapper.selectByExample(example);
        return SignUserRecordConvert.convert(list);
    }

    @Override
    public List<SignUserRecordDTO> queryPk(String userId, Integer id) {
        SignUserRecordExample example = new SignUserRecordExample();
        example.createCriteria().andUserIdEqualTo(userId).andIdEqualTo(id);
        List<SignUserRecord> list = signUserRecordMapper.selectByExample(example);
        return SignUserRecordConvert.convert(list);
    }

    @Override
    public List<SignUserRecordDTO> queryByCycleTime(String userId, Integer id, Date signTimeExt,
                                                    Date cycleTime) {
        SignUserRecordExample example = new SignUserRecordExample();
        example.createCriteria().andUserIdEqualTo(userId).andIdEqualTo(id)
                .andSignTimeExtEqualTo(signTimeExt).andCycleTimeEqualTo(cycleTime);
        List<SignUserRecord> list = signUserRecordMapper.selectByExample(example);
        return SignUserRecordConvert.convert(list);
    }

    @Override
    public boolean modifyCount(SignUserRecord record) {
        return extSignUserRecordMapper.modifyCount(record);
    }

    @Override
    public List<SignUserRecordDTO> select(Date cycleTime) {
        List<SignUserRecord> list = extSignUserRecordMapper.select(cycleTime);
        return SignUserRecordConvert.convert(list);
    }

    @Override
    public List<SignUserRecordDTO> queryBeforeSignUser(int page, int rows) {
        List<SignUserRecord> list = extSignUserRecordMapper.queryBeforeSignUser(page, rows);
        return SignUserRecordConvert.convert(list);
    }
}
