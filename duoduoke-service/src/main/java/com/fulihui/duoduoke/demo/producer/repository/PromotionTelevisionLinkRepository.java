package com.fulihui.duoduoke.demo.producer.repository;

import com.fulihui.duoduoke.demo.api.dto.PromotionTelevisionLinkDTO;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.PromotionTelevisionLink;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.PromotionTelevisionLinkExample;

import java.util.List;


/**
 * @author Administrator
 */
public interface PromotionTelevisionLinkRepository {
    long countByExample(PromotionTelevisionLinkExample example);

    int insertSelective(PromotionTelevisionLink record);

    List<PromotionTelevisionLinkDTO> selectByExample(PromotionTelevisionLinkExample example);

    PromotionTelevisionLinkDTO selectByPrimaryKey(Integer id);

    int update(PromotionTelevisionLink record);

}