package com.fulihui.duoduoke.demo.producer.dal.dao;

import com.fulihui.duoduoke.demo.producer.dal.dataobj.RedPackageGoods;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.RedPackageGoodsExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RedPackageGoodsMapper {
    long countByExample(RedPackageGoodsExample example);

    int deleteByExample(RedPackageGoodsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RedPackageGoods record);

    int insertSelective(RedPackageGoods record);

    List<RedPackageGoods> selectByExample(RedPackageGoodsExample example);

    RedPackageGoods selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RedPackageGoods record, @Param("example") RedPackageGoodsExample example);

    int updateByExample(@Param("record") RedPackageGoods record, @Param("example") RedPackageGoodsExample example);

    int updateByPrimaryKeySelective(RedPackageGoods record);

    int updateByPrimaryKey(RedPackageGoods record);
}