package com.fulihui.duoduoke.demo.producer.repository.impl;

import com.fulihui.duoduoke.demo.api.dto.GoodsKeywordInfoDTO;
import com.fulihui.duoduoke.demo.producer.repository.KeywordInfoRepository;
import com.fulihui.duoduoke.demo.producer.dal.dao.GoodsKeywordInfoMapper;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.GoodsKeywordInfo;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.GoodsKeywordInfoExample;
import org.near.toolkit.common.StringUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @Description:
 * @Author: xiaoming
 * @version: v 0.1 2018/7/16 0016 18:26
 */
@Repository
public class KeywordRepositoryImpl implements KeywordInfoRepository {
    @Autowired
    GoodsKeywordInfoMapper goodsKeywordInfoMapper;

    @Override
    public List<GoodsKeywordInfoDTO> queryKeywordInfo(String keyword, int page,
                                                      int rows) {
        GoodsKeywordInfoExample example = new GoodsKeywordInfoExample();
        GoodsKeywordInfoExample.Criteria criteria = example.createCriteria();
        example.setOrderByClause("sort DESC");
        example.setOffset(page);
        example.setLimit(rows);
        if (StringUtil.isNotEmpty(keyword)) {
            criteria.andKeywordEqualTo(keyword);
        }
        List<GoodsKeywordInfo> goodsKeywordInfos =
                goodsKeywordInfoMapper.selectByExample(example);
        return convert(goodsKeywordInfos);
    }

    @Override
    public long count(String keyword) {
        GoodsKeywordInfoExample example = new GoodsKeywordInfoExample();
        GoodsKeywordInfoExample.Criteria criteria = example.createCriteria();
        if (StringUtil.isNotEmpty(keyword)) {
            criteria.andKeywordEqualTo(keyword);
        }
        return goodsKeywordInfoMapper.countByExample(example);
    }

    private List<GoodsKeywordInfoDTO> convert(List<GoodsKeywordInfo> infos) {
        if (CollectionUtils.isEmpty(infos)) {
            return Collections.emptyList();
        }
        return infos.stream().map(i -> {
            GoodsKeywordInfoDTO infoDTO = new GoodsKeywordInfoDTO();
            BeanUtils.copyProperties(i, infoDTO);
            return infoDTO;
        }).collect(Collectors.toList());
    }


}
