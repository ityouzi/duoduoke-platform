package com.fulihui.redisdubbo.demo.producer.dal.dao;

import com.fulihui.redisdubbo.demo.api.dto.RedPackageGoodsDTO;
import com.fulihui.redisdubbo.demo.producer.dal.dataobj.DuoduoGoodsInfo;

import java.util.List;
import java.util.Map;


public interface ExtRedPackageGoodsMapper {

    /**
     * 查询列表
     *
     * @param params
     * @return
     */
    List<RedPackageGoodsDTO> queryFieldGoods(Map<String, Object> params);

    /**
     * 查询数量
     *
     * @param params
     * @return
     */
    int queryFieldGoodsCount(Map<String, Object> params);

    /**
     * 查询需要更新的商品
     *
     * @return
     */
    List<DuoduoGoodsInfo> queryUsingGoods(Map<String, Object> params);
}