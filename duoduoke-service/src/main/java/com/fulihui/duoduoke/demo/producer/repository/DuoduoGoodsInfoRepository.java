package com.fulihui.duoduoke.demo.producer.repository;

import com.fulihui.duoduoke.demo.api.request.DuoduoGoodsInfoUpdateRequest;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.DuoduoGoodsInfo;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.DuoduoGoodsInfoExample;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.ExtDuoduoGoodsInfoExample;

import java.util.Date;
import java.util.List;


/**
 * Created by lizhi on 2018/7/7 0007.
 */
public interface DuoduoGoodsInfoRepository {


    long insert(DuoduoGoodsInfo duoduoGoodsInfo);


    int batchInsert(List<DuoduoGoodsInfo> duoduoGoodsInfos, int table);

    int updateDetailByGoodsId(DuoduoGoodsInfo duoduoGoodsInfo);


    int updateByPrimaryKeySelective(DuoduoGoodsInfo duoduoGoodsInfo);

    int updateByPrimaryKeySelective(DuoduoGoodsInfo duoduoGoodsInfo, int table);


    DuoduoGoodsInfo selectByPrimaryKey(Integer id);

    DuoduoGoodsInfo selectByGoodsId(Long goodsId);


    List<DuoduoGoodsInfo> selectByExample(DuoduoGoodsInfoExample example);

    long count(DuoduoGoodsInfoExample example);

    Long queryCommisionConfig();

    int updateGoodsState(DuoduoGoodsInfoUpdateRequest request);

    List<DuoduoGoodsInfo> selectListByExample(DuoduoGoodsInfoExample example);

    int batchDelete(List<String> goodsIds);


    DuoduoGoodsInfo selectByGoodsIdTable(Long goodsId, int table);

    int deleteAll();

    long insert(DuoduoGoodsInfo duoduoGoodsInfo, int table);


    /**
     * 获取正在使用的表
     *
     * @return
     */
    String getUseTableName();

    /**
     * 查询列表
     *
     * @param example
     * @return
     */
    List<DuoduoGoodsInfo> selectByExtExample(ExtDuoduoGoodsInfoExample example);

    /**
     * 查询条数
     *
     * @param example
     * @return
     */
    long countByExtExample(ExtDuoduoGoodsInfoExample example);

    /**
     * 根据更新时间删除非人工优选商品
     *
     * @param endUpdate
     * @return
     */
    int deleteOldChoice(Date endUpdate);
}
