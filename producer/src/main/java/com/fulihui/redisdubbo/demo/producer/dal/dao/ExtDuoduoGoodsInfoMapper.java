package com.fulihui.redisdubbo.demo.producer.dal.dao;


import com.fulihui.redisdubbo.demo.producer.dal.dataobj.DuoduoGoodsInfo;
import com.fulihui.redisdubbo.demo.producer.dal.dataobj.DuoduoGoodsInfoExample;
import com.fulihui.redisdubbo.demo.producer.dal.dataobj.ExtDuoduoGoodsInfoExample;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;


public interface ExtDuoduoGoodsInfoMapper {

    int batchInsert(List<DuoduoGoodsInfo> record);

    int updateDetailByGoodsId(DuoduoGoodsInfo record);

    List<DuoduoGoodsInfo> selectByGoodsId(Long goodsId);

    int updateState(@Param("state") String state, @Param("couponStartTime") Date couponStartTime,
                    @Param("couponEndTime") Date couponEndTime, @Param("oldState") String oldState);

    List<DuoduoGoodsInfo> selectByExample(DuoduoGoodsInfoExample example);

    int batchDelete(List<String> goodIds);


    int deleteAll();

    /**
     * 查询列表
     *
     * @param example
     * @return
     */
    List<DuoduoGoodsInfo> selectByExtExample(ExtDuoduoGoodsInfoExample example);

    long countByExtExample(ExtDuoduoGoodsInfoExample example);

    int deleteChoice(Date endUpdate);
}