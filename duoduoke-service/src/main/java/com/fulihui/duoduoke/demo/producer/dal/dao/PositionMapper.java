package com.fulihui.duoduoke.demo.producer.dal.dao;



import com.fulihui.duoduoke.demo.producer.dal.dataobj.Position;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.PositionExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PositionMapper {
    long countByExample(PositionExample example);

    int deleteByExample(PositionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Position record);

    int insertSelective(Position record);

    List<Position> selectByExample(PositionExample example);

    Position selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Position record, @Param("example") PositionExample example);

    int updateByExample(@Param("record") Position record, @Param("example") PositionExample example);

    int updateByPrimaryKeySelective(Position record);

    int updateByPrimaryKey(Position record);
}