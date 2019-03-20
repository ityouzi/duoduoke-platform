package com.fulihui.duoduoke.demo.producer.service;

import com.fulihui.duoduoke.demo.api.api.GoodsCatInfoService;
import com.fulihui.duoduoke.demo.api.dto.GoodsCatInfoDTO;
import com.fulihui.duoduoke.demo.api.dto.GoodsCatInfoTreeNodeDTO;
import com.fulihui.duoduoke.demo.api.enums.GoodsStateEnum;
import com.fulihui.duoduoke.demo.api.request.GoodsCatInfoRequest;
import com.fulihui.duoduoke.demo.common.config.DuoDuoKeConfig;
import com.fulihui.duoduoke.demo.common.util.BeanConvUtil;
import com.fulihui.duoduoke.demo.producer.dal.dao.ExtGoodsCatInfoMapper;
import com.fulihui.duoduoke.demo.producer.dal.dao.GoodsCatInfoMapper;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.GoodsCatInfo;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.GoodsInfo;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.GoodsInfoWithBLOBs;
import com.fulihui.duoduoke.demo.producer.repository.GoodsCatInfoRepository;
import com.fulihui.duoduoke.demo.producer.repository.GoodsInfoRepository;
import com.fulihui.duoduoke.demo.producer.util.ClassFieldsUtil;
import com.fulihui.duoduoke.demo.web.weixin.duoapi.DuoHttpClient;
import com.fulihui.duoduoke.demo.web.weixin.duoapi.request.DuoCatRequest;
import com.fulihui.duoduoke.demo.web.weixin.duoapi.request.DuoGoodsSearchRequest;
import com.fulihui.duoduoke.demo.web.weixin.duoapi.result.DuoCatApiResult;
import com.fulihui.duoduoke.demo.web.weixin.duoapi.result.DuoCatResult;
import com.fulihui.duoduoke.demo.web.weixin.duoapi.result.DuoGoodsSearchResult;
import com.google.common.collect.Lists;
import org.apache.dubbo.config.annotation.Service;
import org.near.servicesupport.error.Errors;
import org.near.servicesupport.result.ResultBuilder;
import org.near.servicesupport.result.TMultiResult;
import org.near.servicesupport.result.TPageResult;
import org.near.servicesupport.result.TSingleResult;
import org.near.servicesupport.util.ServiceAssert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.fulihui.duoduoke.demo.producer.util.SignUtil.genServiceSign;

/**
 * @author lizhi
 * @date 2018-7-7
 */
@Service(version = "${demo.service.version}")

public class GoodsCatInfoServiceImpl implements GoodsCatInfoService {
    private static final Logger LOGGER = LoggerFactory
            .getLogger(GoodsCatInfoServiceImpl.class);

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

    @Autowired
    DuoDuoKeConfig duoDuoKeConfig;
    @Autowired
    DuoHttpClient duoHttpClient;
    @Autowired
    GoodsInfoRepository goodsInfoRepository;

    @Override
    public void doCatSyc() {
        List<GoodsCatInfo> catInfoList = goodsCatInfoRepository.selectByLevel(2);

        List<DuoCatApiResult> goodsCatsList = Lists.newArrayList();
        for (GoodsCatInfo info : catInfoList) {
            DuoCatRequest request = new DuoCatRequest();
            request.setType("pdd.goods.cats.get");
            request.setClient_id(duoDuoKeConfig.getClientId());
            request.setTimestamp(String.valueOf(System.currentTimeMillis()));
            request.setParent_cat_id(info.getCatId() + "");
            Map<String, Object> map = ClassFieldsUtil.obj2StrValMap(request);
            String sign = genServiceSign(ClassFieldsUtil.obj2StrVal(request), map, duoDuoKeConfig.getClientSecret());
            request.setSign(sign);
            DuoCatResult result = duoHttpClient.invokeService(request);
            goodsCatsList.addAll(result.getGoodsCatsList());
        }

        for (DuoCatApiResult result : goodsCatsList) {
            DuoGoodsSearchRequest request = new DuoGoodsSearchRequest();
            request.setType("pdd.ddk.goods.search");
            request.setClient_id(duoDuoKeConfig.getClientId());
            request.setTimestamp(String.valueOf(System.currentTimeMillis()));
            request.setSort_type("0");
            request.setWith_coupon("true");
            request.setCat_id(result.getCatId());
            Map<String, Object> strValMap = ClassFieldsUtil.obj2StrValMap(request);
            List<String> strings = ClassFieldsUtil.obj2StrVal(request);
            String sign = genServiceSign(strings, strValMap, duoDuoKeConfig.getClientSecret());
            request.setSign(sign);
            DuoGoodsSearchResult goodsSearchResult = duoHttpClient.invokeService(request);
            LOGGER.debug("result:{}", goodsSearchResult);
            DuoGoodsSearchResult.GoodsSearchResponseBean goodsSearchResponse = goodsSearchResult.getGoodsSearchResponse();
            List<DuoGoodsSearchResult.GoodsSearchResponseBean.GoodsListBean> goodsList = goodsSearchResponse.getGoodsList();
            if (goodsList != null) {
                for (DuoGoodsSearchResult.GoodsSearchResponseBean.GoodsListBean item : goodsList) {
                    GoodsInfo goodsInfo = goodsInfoRepository.selectByGoodsId(item.getGoodsId());
                    if (goodsInfo == null) {


                        GoodsInfoWithBLOBs info = new GoodsInfoWithBLOBs();


                        info.setGoodsDesc(item.getGoodsDesc());
                        info.setGoodsGalleryUrls(item.getGoodsGalleryUrls());
                        info.setGoodsId(item.getGoodsId());
                        info.setGoodsName(item.getGoodsName());
                        info.setGoodsThumbnailUrl(item.getGoodsThumbnailUrl());

                        info.setGoodsImageUrl(item.getGoodsImageUrl());
                        info.setSoldQuantity(item.getSoldQuantity());
                        info.setMallName(item.getMallName());

                        info.setMinNormalPrice(item.getMinNormalPrice());
                        info.setState(GoodsStateEnum.ON.getCode());

                        info.setMinGroupPrice(item.getMinGroupPrice());
                        info.setCatIds(item.getCategory_id().toString());
                        info.setHasCoupon(String.valueOf(item.isHasCoupon()));

                        info.setAvgServ(item.getAvgServ());
                        info.setAvgLgst(item.getAvgLgst());
                        info.setAvgDesc(item.getAvgDesc());
                        info.setDetailUpdate(new Date());
                        info.setIsChoose("1");
                        info.setChooseSort(0);
                        info.setSort(0);
                        goodsInfoRepository.insert(info);
                    }
                }

            }
        }

    }
}
