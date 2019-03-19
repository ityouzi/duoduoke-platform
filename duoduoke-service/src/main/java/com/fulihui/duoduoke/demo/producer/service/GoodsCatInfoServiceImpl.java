package com.fulihui.duoduoke.demo.producer.service;


import com.fulihui.duoduoke.demo.api.api.GoodsCatInfoService;
import com.fulihui.duoduoke.demo.api.dto.GoodsCatInfoDTO;
import com.fulihui.duoduoke.demo.api.dto.GoodsCatInfoTreeNodeDTO;
import com.fulihui.duoduoke.demo.api.request.GoodsCatInfoRequest;
import com.fulihui.duoduoke.demo.common.util.BeanConvUtil;
import com.fulihui.duoduoke.demo.producer.dal.dao.ExtGoodsCatInfoMapper;
import com.fulihui.duoduoke.demo.producer.dal.dao.GoodsCatInfoMapper;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.GoodsCatInfo;
import com.fulihui.duoduoke.demo.producer.repository.GoodsCatInfoRepository;
import com.google.common.collect.Lists;
import org.apache.dubbo.config.annotation.Service;
import org.near.servicesupport.error.Errors;
import org.near.servicesupport.result.ResultBuilder;
import org.near.servicesupport.result.TMultiResult;
import org.near.servicesupport.result.TPageResult;
import org.near.servicesupport.result.TSingleResult;
import org.near.servicesupport.util.ServiceAssert;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lizhi
 * @date 2018-7-7
 */
@Service(version = "${demo.service.version}")

public class GoodsCatInfoServiceImpl implements GoodsCatInfoService {

    @Autowired
    ExtGoodsCatInfoMapper extGoodsCatInfoMapper;

    @Autowired
    GoodsCatInfoMapper goodsCatInfoMapper;

    @Autowired
    GoodsCatInfoRepository goodsCatInfoRepository;

    @Override
    public TPageResult<GoodsCatInfoTreeNodeDTO> queryTree(GoodsCatInfoRequest request) {
        ServiceAssert.notNull(request, Errors.Commons.REQUEST_PARAMETER_ERROR);

        GoodsCatInfo dataModel = new GoodsCatInfo();

        //数据转换
        BeanUtils.copyProperties(request, dataModel);

        List<GoodsCatInfoTreeNodeDTO> tree = goodsCatInfoRepository.queryTree(dataModel,
                request.start4Mysql(), request.getRows());
        if (CollectionUtils.isEmpty(tree)) {
            return ResultBuilder.succTPage(Lists.newArrayList(), request.getPage(),
                    request.getRows(), 0);
        }

        //查询条数
        long count = goodsCatInfoRepository.count(dataModel);

        return ResultBuilder.succTPage(tree, request.getPage(), request.getRows(), (int) count);
    }

    @Override
    public TMultiResult<GoodsCatInfoTreeNodeDTO> tree(GoodsCatInfoRequest request) {
        ServiceAssert.notNull(request, Errors.Commons.REQUEST_PARAMETER_ERROR);
        List<GoodsCatInfoTreeNodeDTO> tree = goodsCatInfoRepository.tree(request.getParentCatId(),
                request.getLevelList(), request.getStatus());
        return ResultBuilder.succTMulti(tree);
    }

    /**
     * 保存对象
     *
     * @return
     */
    @Override
    public TSingleResult<Boolean> update(GoodsCatInfoRequest infoRequest) {

        GoodsCatInfo dataModel = new GoodsCatInfo();
        //数据转换
        BeanUtils.copyProperties(infoRequest, dataModel);

        return ResultBuilder
                .succTSingle(goodsCatInfoMapper.updateByPrimaryKeySelective(dataModel) > 0);
    }

    @Override
    public TSingleResult<List<GoodsCatInfoDTO>> queryByCatIdArrays(List<Integer> idArrays) {


        List<GoodsCatInfo> catInfoList = extGoodsCatInfoMapper.queryByIDArray(idArrays);

        List<GoodsCatInfoDTO> list = new ArrayList<>();

        if (catInfoList != null) {
            list = BeanConvUtil.copy(catInfoList, GoodsCatInfoDTO.class);
        }

        return ResultBuilder.succTSingle(list);
    }

    @Override
    public TMultiResult<GoodsCatInfoDTO> selectByLevel(GoodsCatInfoRequest request) {
        ServiceAssert.notNull(request, Errors.Commons.REQUEST_PARAMETER_ERROR);
        List<GoodsCatInfo> catInfoList = goodsCatInfoRepository
                .selectByLevel(Integer.parseInt(request.getLevel()));
        List<GoodsCatInfoDTO> list = catInfoList.stream().map(item -> {
            GoodsCatInfoDTO model = new GoodsCatInfoDTO();
            BeanUtils.copyProperties(item, model);
            return model;
        }).collect(Collectors.toList());
        return ResultBuilder.succTMulti(list);
    }
}
