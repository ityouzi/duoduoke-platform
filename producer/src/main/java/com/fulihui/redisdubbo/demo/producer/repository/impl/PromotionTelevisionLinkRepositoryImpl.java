package com.fulihui.redisdubbo.demo.producer.repository.impl;

import com.fulihui.redisdubbo.demo.api.dto.PromotionTelevisionLinkDTO;
import com.fulihui.redisdubbo.demo.api.util.Collections;
import com.fulihui.redisdubbo.demo.producer.dal.dao.PromotionTelevisionLinkMapper;
import com.fulihui.redisdubbo.demo.producer.dal.dataobj.PromotionTelevisionLink;
import com.fulihui.redisdubbo.demo.producer.dal.dataobj.PromotionTelevisionLinkExample;
import com.fulihui.redisdubbo.demo.producer.repository.PromotionTelevisionLinkRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Created by lizhi on 2018-12-06.
 */
@Repository
public class PromotionTelevisionLinkRepositoryImpl implements PromotionTelevisionLinkRepository {

    @Autowired
    PromotionTelevisionLinkMapper promotionTelevisionLinkMapper;

    @Override
    public long countByExample(PromotionTelevisionLinkExample example) {
        return promotionTelevisionLinkMapper.countByExample(example);
    }

    @Override
    public int insertSelective(PromotionTelevisionLink record) {
        record.setGmtModified(new Date());
        record.setGmtCreate(new Date());
        return promotionTelevisionLinkMapper.insertSelective(record);
    }

    @Override
    public List<PromotionTelevisionLinkDTO> selectByExample(PromotionTelevisionLinkExample example) {

        List<PromotionTelevisionLink> list = promotionTelevisionLinkMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(list)) {
            return Collections.emptyList();
        }
        return list.stream().map(this::convert).collect(Collectors.toList());
    }

    private PromotionTelevisionLinkDTO convert(PromotionTelevisionLink item) {
        if (item == null) {
            return null;
        }
        PromotionTelevisionLinkDTO it = new PromotionTelevisionLinkDTO();
        BeanUtils.copyProperties(item, it);
        return it;
    }

    @Override
    public PromotionTelevisionLinkDTO selectByPrimaryKey(Integer id) {
        PromotionTelevisionLink link = promotionTelevisionLinkMapper.selectByPrimaryKey(id);
        return convert(link);
    }

    @Override
    public int update(PromotionTelevisionLink record) {
        record.setGmtModified(new Date());
        return promotionTelevisionLinkMapper.updateByPrimaryKeySelective(record);
    }
}
