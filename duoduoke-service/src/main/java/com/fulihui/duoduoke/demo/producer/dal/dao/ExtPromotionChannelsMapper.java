package com.fulihui.duoduoke.demo.producer.dal.dao;

import com.fulihui.duoduoke.demo.producer.dal.dataobj.PromotionChannels;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * Created by lizhi on 2018-12-06.
 */
public interface ExtPromotionChannelsMapper {

    boolean updateIncomeBalance(@Param("channelsCode") String channelsCode,
                                @Param("channelsIncome") long channelsIncome,
                                @Param("accountBalance") long accountBalance);

    List<PromotionChannels> queryByPid(@Param("pId") String pId,
                                       @Param("channelsStatus") String channelsStatus);
}
