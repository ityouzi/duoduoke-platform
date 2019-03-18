package com.fulihui.duoduoke.demo.producer.repository.impl;


import com.fulihui.duoduoke.demo.api.request.DuoduoGoodsInfoUpdateRequest;
import com.fulihui.duoduoke.demo.common.util.RedisUtils;
import com.fulihui.duoduoke.demo.producer.dal.dao.DuoduoGoodsInfoMapper;
import com.fulihui.duoduoke.demo.producer.dal.dao.ExtDuoduoGoodsInfoMapper;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.DuoduoGoodsInfo;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.DuoduoGoodsInfoExample;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.ExtDuoduoGoodsInfoExample;
import com.fulihui.duoduoke.demo.producer.repository.AppConfigRepository;
import com.fulihui.duoduoke.demo.producer.repository.DuoduoGoodsInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
 * @Description:
 * @Author: xiaoming
 * @version: v 0.1 2018/8/3 0003 10:57
 * 两张表,不要在其他层级调用mapper
 */
@Repository
public class DuoduoGoodsInfoRepositoryImpl implements DuoduoGoodsInfoRepository {

    @Autowired
    AppConfigRepository appConfigRepository;


    @Autowired
    RedisUtils redisUtils;


    @Autowired
    private DuoduoGoodsInfoMapper duoduoGoodsInfoMapper;

    @Autowired
    private ExtDuoduoGoodsInfoMapper extDuoduoGoodsInfoMapper;


    @Override
    public long insert(DuoduoGoodsInfo duoduoGoodsInfo) {


        return duoduoGoodsInfoMapper.insert(duoduoGoodsInfo);


    }

    @Override
    public long insert(DuoduoGoodsInfo duoduoGoodsInfo, int table) {


        return duoduoGoodsInfoMapper.insert(duoduoGoodsInfo);


    }

    @Override
    public String getUseTableName() {
        return null;
    }

    @Override
    public long count(DuoduoGoodsInfoExample example) {


        return duoduoGoodsInfoMapper.countByExample(example);
    }


    @Override
    public int updateGoodsState(DuoduoGoodsInfoUpdateRequest request) {


        return extDuoduoGoodsInfoMapper.updateState(request.getState(), request.getCouponStartTimeLessThanOrEqualTo(),
                request.getCouponEndTimeLessThanOrEqualTo(), request.getStateOld());


    }

    @Override
    public int batchInsert(List<DuoduoGoodsInfo> duoduoGoodsInfos, int table) {


        return extDuoduoGoodsInfoMapper.batchInsert(duoduoGoodsInfos);

    }

    @Override
    public int batchDelete(List<String> goodsIds) {

        return extDuoduoGoodsInfoMapper.batchDelete(goodsIds);

    }

    @Override
    public int deleteAll() {
        return extDuoduoGoodsInfoMapper.deleteAll();
    }


    @Override
    public int updateDetailByGoodsId(DuoduoGoodsInfo duoduoGoodsInfo) {
        return extDuoduoGoodsInfoMapper.updateDetailByGoodsId(duoduoGoodsInfo);
    }


    @Override
    public int updateByPrimaryKeySelective(DuoduoGoodsInfo duoduoGoodsInfo) {

        return duoduoGoodsInfoMapper.updateByPrimaryKeySelective(duoduoGoodsInfo);

    }

    @Override
    public int updateByPrimaryKeySelective(DuoduoGoodsInfo duoduoGoodsInfo, int table) {

        return duoduoGoodsInfoMapper.updateByPrimaryKeySelective(duoduoGoodsInfo);

    }


    @Override
    public DuoduoGoodsInfo selectByPrimaryKey(Integer id) {
        return duoduoGoodsInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public DuoduoGoodsInfo selectByGoodsId(Long goodsId) {

        List<DuoduoGoodsInfo> list = extDuoduoGoodsInfoMapper.selectByGoodsId(goodsId);


        if (CollectionUtils.isEmpty(list)) {
            return null;
        } else {
            return list.get(0);
        }
    }

    @Override
    public DuoduoGoodsInfo selectByGoodsIdTable(Long goodsId, int table) {


        List<DuoduoGoodsInfo> list = extDuoduoGoodsInfoMapper.selectByGoodsId(goodsId);
        if (CollectionUtils.isEmpty(list)) {
            return null;
        } else {
            return list.get(0);
        }
    }


    @Override
    public List<DuoduoGoodsInfo> selectByExample(DuoduoGoodsInfoExample example) {

        return duoduoGoodsInfoMapper.selectByExample(example);

    }


    @Override
    public List<DuoduoGoodsInfo> selectListByExample(DuoduoGoodsInfoExample example) {

        return extDuoduoGoodsInfoMapper.selectByExample(example);

    }


    @Override
    public List<DuoduoGoodsInfo> selectByExtExample(ExtDuoduoGoodsInfoExample example) {

        return extDuoduoGoodsInfoMapper.selectByExtExample(example);

    }

    @Override
    public long countByExtExample(ExtDuoduoGoodsInfoExample example) {

        return extDuoduoGoodsInfoMapper.countByExtExample(example);

    }

    @Override
    public int deleteOldChoice(Date endUpdate) {
        return extDuoduoGoodsInfoMapper.deleteChoice(endUpdate);

    }

}
