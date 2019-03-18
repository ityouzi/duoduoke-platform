package com.fulihui.duoduoke.demo.producer.repository.impl;


import com.fulihui.duoduoke.demo.api.dto.GoodsCatInfoTreeNodeDTO;
import com.fulihui.duoduoke.demo.api.enums.GoodsCatInfoStatusEnum;
import com.fulihui.duoduoke.demo.producer.repository.GoodsCatInfoRepository;
import com.fulihui.duoduoke.demo.producer.dal.dao.ExtGoodsCatInfoMapper;
import com.fulihui.duoduoke.demo.producer.dal.dao.GoodsCatInfoMapper;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.GoodsCatInfo;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.GoodsCatInfoExample;
import org.near.toolkit.common.StringUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lizhi
 * @date 2018-7-6
 */
@Repository
public class GoodsCatInfoRepositoryImpl implements GoodsCatInfoRepository {
    @Autowired
    GoodsCatInfoMapper goodsCatInfoMapper;
    @Autowired
    ExtGoodsCatInfoMapper extGoodsCatInfoMapper;

    @Override
    public GoodsCatInfo selectByPrimaryKey(Integer id) {
        GoodsCatInfo goodsCatInfo = goodsCatInfoMapper.selectByPrimaryKey(id);
        return goodsCatInfo;
    }

    @Override
    public int insert(GoodsCatInfo goodsCatInfo) {
        return goodsCatInfoMapper.insertSelective(goodsCatInfo);
    }

    @Override
    public int count(GoodsCatInfo dataModel) {
        GoodsCatInfoExample example = getGoodsCatInfoExample(dataModel);
        long l = goodsCatInfoMapper.countByExample(example);
        return (int) l;
    }

    @Override
    public List<GoodsCatInfoTreeNodeDTO> tree(Integer parentCatId, List levelList, String status) {
        List<GoodsCatInfo> tree = extGoodsCatInfoMapper.tree(parentCatId, null, null, levelList, status);
        return convert(tree);
    }

    @Override
    public List<GoodsCatInfo> selectByLevel(Integer level) {
        GoodsCatInfoExample example = new GoodsCatInfoExample();
        GoodsCatInfoExample.Criteria criteria = example.createCriteria();
        criteria.andLevelEqualTo(level + "");
        criteria.andStatusEqualTo(GoodsCatInfoStatusEnum.IS.getCode());
        example.setOrderByClause("sort_index DESC");
        return goodsCatInfoMapper.selectByExample(example);
    }

    @Override
    public List<GoodsCatInfoTreeNodeDTO> queryTree(GoodsCatInfo dataModel, int page, int rows) {
        GoodsCatInfoExample example = getGoodsCatInfoExample(dataModel);

        example.setOffset(page);
        example.setLimit(rows);
        example.setOrderByClause(" sort_index desc");


        List<GoodsCatInfo> tree = goodsCatInfoMapper.selectByExample(example);
        return convert(tree);
    }

    private List<GoodsCatInfoTreeNodeDTO> convert(List<GoodsCatInfo> tree) {
        if (CollectionUtils.isEmpty(tree)) {
            return Collections.emptyList();
        }
        return tree.stream().map(i -> {
            GoodsCatInfoTreeNodeDTO infoTreeNodeDTO = new GoodsCatInfoTreeNodeDTO();
            BeanUtils.copyProperties(i, infoTreeNodeDTO);
            return infoTreeNodeDTO;
        }).collect(Collectors.toList());
    }

    private GoodsCatInfoExample getGoodsCatInfoExample(GoodsCatInfo dataModel) {
        GoodsCatInfoExample example = new GoodsCatInfoExample();
        GoodsCatInfoExample.Criteria criteria = example.createCriteria();
        if (StringUtil.isNotBlank(dataModel.getLevel())) {
            criteria.andLevelEqualTo(dataModel.getLevel());
        }
        if (dataModel.getParentCatId() != null) {
            criteria.andParentCatIdEqualTo(dataModel.getParentCatId());
        }
        if (StringUtil.isNotBlank(dataModel.getCatName())) {
            criteria.andCatNameLike("%" + dataModel.getCatName() + "%");
        }
        if (dataModel.getCatId() != null) {
            criteria.andCatIdEqualTo(dataModel.getCatId());
        }
        if (dataModel.getStatus() != null) {
            criteria.andStatusEqualTo(dataModel.getStatus());
        }
        return example;
    }
}
