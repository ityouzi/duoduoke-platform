package com.fulihui.duoduoke.demo.producer.repository;

import com.fulihui.duoduoke.demo.api.dto.promotion.PromotionChannelsDTO;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.PromotionChannels;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.PromotionChannelsExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * @author lizhi
 * @date 2018-11-29
 */
public interface PromotionChannelsRepository {

    long count(PromotionChannelsExample example);

    int insert(PromotionChannels record);

    List<PromotionChannelsDTO> query(PromotionChannelsExample example);

    PromotionChannelsDTO queryByPk(Integer id);

    PromotionChannelsDTO queryByCode(String channelsCode);

    List<PromotionChannelsDTO> queryByPid(@Param("pId") String pId,
                                          @Param("channelsStatus") String channelsStatus);

    boolean modifyIncomeBalance(String channelsCode, long income, long balance);

    int update(PromotionChannels record);

}
