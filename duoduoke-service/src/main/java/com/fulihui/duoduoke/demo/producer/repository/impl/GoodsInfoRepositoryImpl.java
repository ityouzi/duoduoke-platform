package com.fulihui.duoduoke.demo.producer.repository.impl;


import com.fulihui.duoduoke.demo.api.request.GoodsInfoUpdateRequest;
import com.fulihui.duoduoke.demo.producer.dal.dao.GoodsInfoMapper;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.GoodsInfo;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.GoodsInfoExample;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.GoodsInfoWithBLOBs;
import com.fulihui.duoduoke.demo.producer.repository.GoodsInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
 * @Description:
 * @Author: xiaoming
 * @version: v 0.1 2018/8/3 0003 10:57
 */
@Repository
public class GoodsInfoRepositoryImpl implements GoodsInfoRepository {
    @Autowired
    GoodsInfoMapper goodsInfoMapper;

    @Override
    public long insert(GoodsInfoWithBLOBs goodsInfo) {
        goodsInfo.setGmtCreate(new Date());
        goodsInfo.setGmtModified(new Date());
        goodsInfoMapper.insertSelective(goodsInfo);
        return goodsInfo.getId();
    }

    @Override
    public int batchInsert(List<GoodsInfo> list, int table) {
        return 0;
    }

    @Override
    public int updateDetailByGoodsId(GoodsInfo goodsInfo) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(GoodsInfo goodsInfo) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(GoodsInfo goodsInfo, int table) {
        return 0;
    }

    @Override
    public GoodsInfo selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public GoodsInfo selectByGoodsId(String goodsId) {
        GoodsInfoExample example = new GoodsInfoExample();
        example.createCriteria().andGoodsIdEqualTo(goodsId);
        List<GoodsInfo> goods = goodsInfoMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(goods)) {
            return null;
        }
        return goods.get(0);
    }

    @Override
    public List<GoodsInfo> selectByExample(GoodsInfoExample example) {
        return null;
    }

    @Override
    public long count(GoodsInfoExample example) {
        return 0;
    }

    @Override
    public int updateGoodsState(GoodsInfoUpdateRequest request) {
        return 0;
    }

    @Override
    public List<GoodsInfo> selectListByExample(GoodsInfoExample example) {
        return null;
    }

    @Override
    public int batchDelete(List<String> goodsIds) {
        return 0;
    }

    @Override
    public GoodsInfo selectByGoodsIdTable(Long goodsId, int table) {
        return null;
    }

    @Override
    public int deleteAll() {
        return 0;
    }

    @Override
    public long insert(GoodsInfo goodsInfo, int table) {
        return 0;
    }

    @Override
    public String getUseTableName() {
        return null;
    }

    @Override
    public long countByExtExample(GoodsInfoExample example) {
        return 0;
    }

    @Override
    public int deleteOldChoice(Date endUpdate) {
        return 0;
    }
}
