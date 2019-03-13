package com.fulihui.duoduoke.demo.producer.repository;


import com.fulihui.duoduoke.demo.api.dto.OrderInfoDTO;
import com.fulihui.duoduoke.demo.api.dto.promotion.GroupChannelsOrderDTO;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.PromotionChannelsOrderExample;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.PromotionChannelsOrder;

import java.util.Date;
import java.util.List;

public interface PromotionChannelsOrderRepository {
    long countByExample(PromotionChannelsOrderExample example);

    int deleteByPrimaryKey(Integer id);

    int insertSelective(PromotionChannelsOrder record);

    List<OrderInfoDTO> selectByExample(PromotionChannelsOrderExample example);

    OrderInfoDTO query(String orderSn, String channelsCode);

    OrderInfoDTO query(String orderSn);

    PromotionChannelsOrder selectByPrimaryKey(Integer id);

    int update(PromotionChannelsOrder record);

    List<GroupChannelsOrderDTO> queryGroup(int start, int rows, String channelsCode, Date startDate,
                                           Date endDate, String promoType,
                                           List<String> orderStatusList,
                                           List<String> userOrderStatusList,
                                           Date startDateModify, Date endDateModify);

    int queryGroupCount(String channelsCode, Date startDate, Date endDate, String promoType,
                        List<String> orderStatusList, List<String> userOrderStatusList, Date startDateModify, Date endDateModify);


    List<GroupChannelsOrderDTO> queryGroupModify(int start, int rows, String channelsCode, Date startDate,
                                                 Date endDate, String promoType,
                                                 List<String> orderStatusList,
                                                 List<String> userOrderStatusList,
                                                 Date startDateModify, Date endDateModify);

    int queryGroupCountModify(String channelsCode, Date startDate, Date endDate, String promoType,
                              List<String> orderStatusList, List<String> userOrderStatusList, Date startDateModify, Date endDateModify);
}