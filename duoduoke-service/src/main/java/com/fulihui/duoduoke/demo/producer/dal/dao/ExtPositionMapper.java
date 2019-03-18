package com.fulihui.duoduoke.demo.producer.dal.dao;


import com.fulihui.duoduoke.demo.producer.model.PositionAddSelectModel;

public interface ExtPositionMapper {

    Long selectByPosition(PositionAddSelectModel position);

}