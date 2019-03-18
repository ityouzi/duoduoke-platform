package com.fulihui.duoduoke.demo.producer.repository;

import com.fulihui.duoduoke.demo.api.request.DuoduoGoodsInfoUpdateRequest;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.DuoGoodsInfo;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.DuoduoGoodsInfoExample;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.ExtDuoduoGoodsInfoExample;

import java.util.Date;
import java.util.List;


/**
 * Created by lizhi on 2018/7/7 0007.
 */
public interface DuoGoodsInfoRepository {


    long insert(DuoGoodsInfo duoGoodsInfo);


    int batchInsert(List<DuoGoodsInfo> duoGoodsInfos, int table);

    int updateDetailByGoodsId(DuoGoodsInfo duoGoodsInfo);


    int updateByPrimaryKeySelective(DuoGoodsInfo duoGoodsInfo);

    int updateByPrimaryKeySelective(DuoGoodsInfo duoGoodsInfo, int table);


    DuoGoodsInfo selectByPrimaryKey(Integer id);

    DuoGoodsInfo selectByGoodsId(Long goodsId);


    List<DuoGoodsInfo> selectByExample(DuoduoGoodsInfoExample example);

    long count(DuoduoGoodsInfoExample example);



    int updateGoodsState(DuoduoGoodsInfoUpdateRequest request);

    List<DuoGoodsInfo> selectListByExample(DuoduoGoodsInfoExample example);

    int batchDelete(List<String> goodsIds);


    DuoGoodsInfo selectByGoodsIdTable(Long goodsId, int table);

    int deleteAll();

    long insert(DuoGoodsInfo duoGoodsInfo, int table);


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
    List<DuoGoodsInfo> selectByExtExample(ExtDuoduoGoodsInfoExample example);

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
