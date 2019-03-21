package com.fulihui.duoduoke.demo.producer.repository;

import com.fulihui.duoduoke.demo.api.request.GoodsInfoUpdateRequest;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.GoodsInfo;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.GoodsInfoExample;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.GoodsInfoWithBLOBs;

import java.util.Date;
import java.util.List;


/**
 *
 * @author lizhi
 * @date 2018/7/7 0007
 */
public interface GoodsInfoRepository {


    long insert(GoodsInfo goodsInfo);


    int batchInsert(List<GoodsInfo> list, int table);

    int updateDetailByGoodsId(GoodsInfo goodsInfo);


    int updateByPrimaryKeySelective(GoodsInfo goodsInfo);

    int updateByPrimaryKeySelective(GoodsInfo goodsInfo, int table);


    GoodsInfo selectByPrimaryKey(Integer id);

    GoodsInfo selectByGoodsId(String goodsId);


    List<GoodsInfo> selectByExample(GoodsInfoExample example);

    long count(GoodsInfoExample example);


    int updateGoodsState(GoodsInfoUpdateRequest request);

    List<GoodsInfo> selectListByExample(GoodsInfoExample example);

    int batchDelete(List<String> goodsIds);


    GoodsInfo selectByGoodsIdTable(Long goodsId, int table);

    int deleteAll();

    long insert(GoodsInfo goodsInfo, int table);


    /**
     * 获取正在使用的表
     *
     * @return
     */
    String getUseTableName();


    /**
     * 查询条数
     *
     * @param example
     * @return
     */
    long countByExtExample(GoodsInfoExample example);

    /**
     * 根据更新时间删除非人工优选商品
     *
     * @param endUpdate
     * @return
     */
    int deleteOldChoice(Date endUpdate);
}
