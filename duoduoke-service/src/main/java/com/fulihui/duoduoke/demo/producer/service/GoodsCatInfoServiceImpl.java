package com.fulihui.duoduoke.demo.producer.service;

import com.alibaba.fastjson.JSON;
import com.fulihui.duoduoke.demo.api.api.GoodsCatInfoService;
import com.fulihui.duoduoke.demo.api.dto.GoodsCatInfoDTO;
import com.fulihui.duoduoke.demo.api.dto.GoodsCatInfoTreeNodeDTO;
import com.fulihui.duoduoke.demo.api.request.GoodsCatInfoRequest;
import com.fulihui.duoduoke.demo.common.config.DuoDuoKeConfig;
import com.fulihui.duoduoke.demo.common.util.BeanConvUtil;
import com.fulihui.duoduoke.demo.producer.dal.dao.ExtGoodsCatInfoMapper;
import com.fulihui.duoduoke.demo.producer.dal.dao.GoodsCatInfoMapper;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.GoodsCatInfo;
import com.fulihui.duoduoke.demo.producer.manager.GoodsManager;
import com.fulihui.duoduoke.demo.producer.repository.GoodsCatInfoRepository;
import com.fulihui.duoduoke.demo.producer.util.ClassFieldsUtil;
import com.fulihui.duoduoke.demo.web.weixin.duoapi.DuoHttpClient;
import com.fulihui.duoduoke.demo.web.weixin.duoapi.request.DuoCatRequest;
import com.fulihui.duoduoke.demo.web.weixin.duoapi.request.DuoGoodsSearchRequest;
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

    @Override
    public void doCatSyc() {
        List<GoodsCatInfo> catInfoList = goodsCatInfoRepository.selectByLevel(2);

        List<DuoCatResult.GoodsCatsGetResponseBean.GoodsCatsListBean> goodsCatsList = Lists.newArrayList();
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
            goodsCatsList.addAll(result.getGoodsCatsGetResponse().getGoodsCatsList());
        }

        for (DuoCatResult.GoodsCatsGetResponseBean.GoodsCatsListBean result : goodsCatsList) {


            int page = 1;
            int pageSize = 100;


            DuoGoodsSearchRequest request = new DuoGoodsSearchRequest();
            convertReq(result, request);
            request.setPage(page + "");
            request.setPage_size(pageSize + "");
            request.setTimestamp(String.valueOf(System.currentTimeMillis()));

            Map<String, Object> strValMap = ClassFieldsUtil.obj2StrValMap(request);
            List<String> strings = ClassFieldsUtil.obj2StrVal(request);
            String sign = genServiceSign(strings, strValMap, duoDuoKeConfig.getClientSecret());
            request.setSign(sign);
            DuoGoodsSearchResult searchResult = duoHttpClient.invokeService(request);
            LOGGER.debug("result:{}", searchResult);
            if (searchResult == null || searchResult.getGoodsSearchResponse() == null) {
                continue;
            }
            DuoGoodsSearchResult.GoodsSearchResponseBean searchResponse = searchResult.getGoodsSearchResponse();
            Integer totalCount = searchResponse.getTotal_count();
            int totalPage = totalCount % pageSize == 0 ? totalCount / pageSize
                    : totalCount / pageSize + 1;
            totalPage = totalPage > 0 ? totalPage : 1;
            LOGGER.info("总条数:{},总页数:{}", totalCount, totalPage);
            for (int i = 1; i <= totalPage; i++) {

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                DuoGoodsSearchRequest newRequest = new DuoGoodsSearchRequest();

                convertReq(result, newRequest);
                newRequest.setPage(i + "");
                newRequest.setPage_size(pageSize + "");
                newRequest.setTimestamp(String.valueOf(System.currentTimeMillis()));
                Map<String, Object> newStrValMap = ClassFieldsUtil.obj2StrValMap(newRequest);
                List<String> newStrings = ClassFieldsUtil.obj2StrVal(newRequest);
                String newSign = genServiceSign(newStrings, newStrValMap, duoDuoKeConfig.getClientSecret());
                newRequest.setSign(newSign);
                searchResult = duoHttpClient.invokeService(newRequest);


                LOGGER.debug("result:{}", searchResult);
                if (searchResult == null || searchResult.getGoodsSearchResponse() == null) {
                    continue;
                }


                List<DuoGoodsSearchResult.GoodsSearchResponseBean.GoodsListBean> goodsList = searchResponse.getGoodsList();
                if (goodsList != null) {
                    for (DuoGoodsSearchResult.GoodsSearchResponseBean.GoodsListBean item : goodsList) {
                        insert(item);
                    }

                }
            }
        }
    }

    @Autowired
    GoodsManager goodsManager;

    void insert(DuoGoodsSearchResult.GoodsSearchResponseBean.GoodsListBean item) {
        goodsManager.saveGoods(item);
    }

    private void convertReq(DuoCatResult.GoodsCatsGetResponseBean.GoodsCatsListBean result, DuoGoodsSearchRequest request) {
        ArrayList<DuoGoodsSearchRequest.Range> rangeList = Lists.newArrayList();

        DuoGoodsSearchRequest.Range range = new DuoGoodsSearchRequest.Range();
        DuoGoodsSearchRequest.Range range1 = new DuoGoodsSearchRequest.Range();
        range.setRange_id(5);
        range.setRange_from(100);
        rangeList.add(range);
        range1.setRange_id(2);
        range1.setRange_from(1);
        rangeList.add(range1);
        String array = JSON.toJSONString(rangeList);

        request.setRange_list(array);
        request.setWith_coupon(Boolean.TRUE.toString());
        request.setType("pdd.ddk.goods.search");
        request.setClient_id(duoDuoKeConfig.getClientId());

        request.setSort_type("0");
        request.setCat_id(result.getCatId());
    }


}
