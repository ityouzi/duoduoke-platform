package com.fulihui.duoduoke.demo.producer.dal.dao;


import com.fulihui.duoduoke.demo.producer.dal.dataobj.DuoGoodsInfo;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.DuoduoGoodsInfoExample;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.ExtDuoduoGoodsInfoExample;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;


public interface ExtDuoduoGoodsInfoMapper {

    int batchInsert(List<DuoGoodsInfo> record);

    int updateDetailByGoodsId(DuoGoodsInfo record);

    List<DuoGoodsInfo> selectByGoodsId(Long goodsId);

    int updateState(@Param("state") String state, @Param("couponStartTime") Date couponStartTime,
                    @Param("couponEndTime") Date couponEndTime, @Param("oldState") String oldState);

    List<DuoGoodsInfo> selectByExample(DuoduoGoodsInfoExample example);

    int batchDelete(List<String> goodIds);


    int deleteAll();

    /**
     * 查询列表
     *
     * @param example
     * @return
     */
    List<DuoGoodsInfo> selectByExtExample(ExtDuoduoGoodsInfoExample example);

    long countByExtExample(ExtDuoduoGoodsInfoExample example);

    int deleteChoice(Date endUpdate);
}