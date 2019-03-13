package com.fulihui.redisdubbo.demo.producer.repository.impl;

import com.fulihui.redisdubbo.demo.api.enums.AppConfigEnum;
import com.fulihui.redisdubbo.demo.api.enums.DuoDuoGoodsTableEnum;
import com.fulihui.redisdubbo.demo.api.request.DuoduoGoodsInfoUpdateRequest;
import com.fulihui.redisdubbo.demo.producer.dal.dao.*;
import com.fulihui.redisdubbo.demo.producer.dal.dataobj.*;
import com.fulihui.redisdubbo.demo.producer.repository.AppConfigRepository;
import com.fulihui.redisdubbo.demo.producer.repository.DuoduoGoodsInfoRepository;
import com.fulihui.redisdubbo.demo.weixin.common.config.RedisContent;
import com.fulihui.redisdubbo.demo.weixin.common.util.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
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
    private DuoduoGoodsInfoZEROMapper duoduoGoodsInfoZEROMapper;
    @Autowired
    private ExtDuoduoGoodsInfoMapper extDuoduoGoodsInfoMapper;
    @Autowired
    private ExtDuoduoGoodsInfoZEROMapper extDuoduoGoodsInfoZEROMapper;
    @Autowired
    private GoodsTabelMapper goodsTabelMapper;

    @Override
    public long insert(DuoduoGoodsInfo duoduoGoodsInfo) {
        int i = queryRedis() % 2;
        if (i == DuoDuoGoodsTableEnum.ZERO.getCode()) {
            return duoduoGoodsInfoZEROMapper.insert(duoduoGoodsInfo);
        } else {
            return duoduoGoodsInfoMapper.insert(duoduoGoodsInfo);
        }

    }

    @Override
    public long insert(DuoduoGoodsInfo duoduoGoodsInfo, int table) {
        int i = queryRedis() + table;
        if (i % 2 == DuoDuoGoodsTableEnum.ZERO.getCode()) {
            return duoduoGoodsInfoZEROMapper.insert(duoduoGoodsInfo);
        } else {
            return duoduoGoodsInfoMapper.insert(duoduoGoodsInfo);
        }

    }

    @Override
    public long count(DuoduoGoodsInfoExample example) {
        int i = queryRedis() % 2;
        if (i == DuoDuoGoodsTableEnum.ZERO.getCode()) {
            return duoduoGoodsInfoZEROMapper.countByExample(example);
        } else {
            return duoduoGoodsInfoMapper.countByExample(example);

        }
    }

    @Override
    public Long queryCommisionConfig() {
        String queryConfig = appConfigRepository.queryConfig(Integer.valueOf(AppConfigEnum.COMMISSION_PERCENTAGE.getCode()));
        return Long.parseLong(queryConfig);
    }

    @Override
    public int updateGoodsState(DuoduoGoodsInfoUpdateRequest request) {
        int i = queryRedis() % 2;
        if (i == DuoDuoGoodsTableEnum.ZERO.getCode()) {
            return extDuoduoGoodsInfoZEROMapper.updateState(request.getState(), request.getCouponStartTimeLessThanOrEqualTo(),
                    request.getCouponEndTimeLessThanOrEqualTo(), request.getStateOld());
        } else {
            return extDuoduoGoodsInfoMapper.updateState(request.getState(), request.getCouponStartTimeLessThanOrEqualTo(),
                    request.getCouponEndTimeLessThanOrEqualTo(), request.getStateOld());
        }

    }

    @Override
    public int batchInsert(List<DuoduoGoodsInfo> duoduoGoodsInfos, int table) {
        //每天0点保存，缓存中表还没有更新，+1
        int i = queryRedis() + table;
        if (i % 2 == DuoDuoGoodsTableEnum.ZERO.getCode()) {
            return extDuoduoGoodsInfoZEROMapper.batchInsert(duoduoGoodsInfos);
        } else {
            return extDuoduoGoodsInfoMapper.batchInsert(duoduoGoodsInfos);
        }
    }

    @Override
    public int batchDelete(List<String> goodsIds) {
        int i = queryRedis() % 2;
        if (i == DuoDuoGoodsTableEnum.ZERO.getCode()) {
            return extDuoduoGoodsInfoZEROMapper.batchDelete(goodsIds);
        } else {
            return extDuoduoGoodsInfoMapper.batchDelete(goodsIds);
        }
    }

    @Override
    public int deleteAll() {
        int i = queryRedis() + 1;
        int table = i % 2;
        if (table == DuoDuoGoodsTableEnum.ZERO.getCode()) {
            return extDuoduoGoodsInfoZEROMapper.deleteAll();
        } else {
            return extDuoduoGoodsInfoMapper.deleteAll();
        }
    }


    @Override
    public int updateDetailByGoodsId(DuoduoGoodsInfo duoduoGoodsInfo) {
        int i = queryRedis() % 2;
        if (i == DuoDuoGoodsTableEnum.ZERO.getCode()) {
            return extDuoduoGoodsInfoZEROMapper.updateDetailByGoodsId(duoduoGoodsInfo);
        } else {
            return extDuoduoGoodsInfoMapper.updateDetailByGoodsId(duoduoGoodsInfo);
        }
    }


    @Override
    public int updateByPrimaryKeySelective(DuoduoGoodsInfo duoduoGoodsInfo) {
        int i = queryRedis() % 2;
        if (i == DuoDuoGoodsTableEnum.ZERO.getCode()) {
            return duoduoGoodsInfoZEROMapper.updateByPrimaryKeySelective(duoduoGoodsInfo);
        } else {
            return duoduoGoodsInfoMapper.updateByPrimaryKeySelective(duoduoGoodsInfo);
        }
    }

    @Override
    public int updateByPrimaryKeySelective(DuoduoGoodsInfo duoduoGoodsInfo, int table) {
        int i = (queryRedis() + table) % 2;
        if (i == DuoDuoGoodsTableEnum.ZERO.getCode()) {
            return duoduoGoodsInfoZEROMapper.updateByPrimaryKeySelective(duoduoGoodsInfo);
        } else {
            return duoduoGoodsInfoMapper.updateByPrimaryKeySelective(duoduoGoodsInfo);
        }
    }


    @Override
    public DuoduoGoodsInfo selectByPrimaryKey(Integer id) {
        int i = queryRedis() % 2;
        if (i == DuoDuoGoodsTableEnum.ZERO.getCode()) {
            return duoduoGoodsInfoZEROMapper.selectByPrimaryKey(id);
        } else {
            return duoduoGoodsInfoMapper.selectByPrimaryKey(id);
        }
    }

    @Override
    public DuoduoGoodsInfo selectByGoodsId(Long goodsId) {
        List<DuoduoGoodsInfo> list = new ArrayList<>();
        int i = queryRedis() % 2;
        if (i == DuoDuoGoodsTableEnum.ZERO.getCode()) {
            list = extDuoduoGoodsInfoZEROMapper.selectByGoodsId(goodsId);
        } else {
            list = extDuoduoGoodsInfoMapper.selectByGoodsId(goodsId);
        }
        if (CollectionUtils.isEmpty(list)) {
            return null;
        } else {
            return list.get(0);
        }
    }

    @Override
    public DuoduoGoodsInfo selectByGoodsIdTable(Long goodsId, int table) {
        List<DuoduoGoodsInfo> list = new ArrayList<>();
        int i = queryRedis() + table;
        if (i % 2 == DuoDuoGoodsTableEnum.ZERO.getCode()) {
            list = extDuoduoGoodsInfoZEROMapper.selectByGoodsId(goodsId);
        } else {
            list = extDuoduoGoodsInfoMapper.selectByGoodsId(goodsId);
        }
        if (CollectionUtils.isEmpty(list)) {
            return null;
        } else {
            return list.get(0);
        }
    }


    @Override
    public List<DuoduoGoodsInfo> selectByExample(DuoduoGoodsInfoExample example) {
        int i = queryRedis() % 2;
        if (i == DuoDuoGoodsTableEnum.ZERO.getCode()) {
            return duoduoGoodsInfoZEROMapper.selectByExample(example);
        } else {
            return duoduoGoodsInfoMapper.selectByExample(example);
        }
    }


    @Override
    public List<DuoduoGoodsInfo> selectListByExample(DuoduoGoodsInfoExample example) {
        int i = queryRedis() % 2;
        if (i == DuoDuoGoodsTableEnum.ZERO.getCode()) {
            return extDuoduoGoodsInfoZEROMapper.selectByExample(example);
        } else {
            return extDuoduoGoodsInfoMapper.selectByExample(example);
        }
    }


    public int queryRedis() {
        Object object = this.redisUtils.get(RedisContent.DUODUO_GOODS_TABLE);
        if (object == null) {
            GoodsTabelExample example = new GoodsTabelExample();
            List<GoodsTabel> goodsTabels = goodsTabelMapper.selectByExample(example);
            if (CollectionUtils.isEmpty(goodsTabels)) {
                this.redisUtils.set(RedisContent.DUODUO_GOODS_TABLE, DuoDuoGoodsTableEnum.ONE.getCode());
            } else {
                GoodsTabel goodsTabel = goodsTabels.get(0);
                if (goodsTabel.getTableId() != null) {
                    this.redisUtils.set(RedisContent.DUODUO_GOODS_TABLE, goodsTabel.getTableId());
                }
            }
            return Integer.parseInt(redisUtils.get(RedisContent.DUODUO_GOODS_TABLE).toString());
        }
        return Integer.parseInt(object.toString());
    }

    @Override
    public String getUseTableName() {
        return "duoduo_goods_info" + ((queryRedis() % 2 == DuoDuoGoodsTableEnum.ZERO.getCode()) ? "_0" : "");
    }

    @Override
    public List<DuoduoGoodsInfo> selectByExtExample(ExtDuoduoGoodsInfoExample example) {
        int i = queryRedis() % 2;
        if (i == DuoDuoGoodsTableEnum.ZERO.getCode()) {
            return extDuoduoGoodsInfoZEROMapper.selectByExtExample(example);
        } else {
            return extDuoduoGoodsInfoMapper.selectByExtExample(example);
        }
    }

    @Override
    public long countByExtExample(ExtDuoduoGoodsInfoExample example) {
        int i = queryRedis() % 2;
        if (i == DuoDuoGoodsTableEnum.ZERO.getCode()) {
            return extDuoduoGoodsInfoZEROMapper.countByExtExample(example);
        } else {
            return extDuoduoGoodsInfoMapper.countByExtExample(example);
        }
    }

    @Override
    public int deleteOldChoice(Date endUpdate) {
        int i = queryRedis() % 2;
        if (i == DuoDuoGoodsTableEnum.ZERO.getCode()) {
            return extDuoduoGoodsInfoZEROMapper.deleteChoice(endUpdate);
        } else {
            return extDuoduoGoodsInfoMapper.deleteChoice(endUpdate);
        }
    }

}
