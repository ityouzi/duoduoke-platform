package com.fulihui.redisdubbo.demo.producer.dal.dao;

import com.fulihui.redisdubbo.demo.producer.dal.dataobj.GoodsMark;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: JY
 * @date: 2018/9/19 16:38
 */
public interface ExtGoodsMarkMapper {

    int updateGoodsMarkByMarkId(@Param("markId") Integer markId, @Param("markUrl") String markUrl);

    GoodsMark selectByIdTime(GoodsMark record);

    /**
     * 查询有效商品角标数据
     *
     * @return
     */
    List<GoodsMark> queryUsingGoodsMark();
}
