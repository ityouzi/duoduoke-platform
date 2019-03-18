package com.fulihui.duoduoke.demo.producer.manager.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fulihui.duoduoke.demo.api.dto.DuoduoGoodsInfoDTO;
import com.fulihui.duoduoke.demo.api.enums.DuoDuoGoodsLevelEnum;
import com.fulihui.duoduoke.demo.api.enums.GoodsChooseEnum;
import com.fulihui.duoduoke.demo.api.enums.GoodsStateEnum;
import com.fulihui.duoduoke.demo.api.request.*;
import com.fulihui.duoduoke.demo.api.response.DuoduoGoodsCheckResponse;
import com.fulihui.duoduoke.demo.api.response.GoodsSearchResponse;
import com.fulihui.duoduoke.demo.producer.manager.DuoduoGoodsManager;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.DuoGoodsInfo;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.DuoduoGoodsInfoExample;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.GoodsCatInfo;
import com.fulihui.duoduoke.demo.producer.repository.DuoGoodsInfoRepository;
import com.fulihui.duoduoke.demo.producer.repository.GoodsCatInfoRepository;
import com.fulihui.duoduoke.demo.producer.util.ClassFieldsUtil;
import com.fulihui.duoduoke.demo.producer.util.SignUtil;
import com.fulihui.duoduoke.demo.common.config.DuoDuoKeConfig;
import com.fulihui.duoduoke.demo.common.config.RedisContent;
import com.fulihui.duoduoke.demo.common.util.RedisUtils;
import com.fulihui.duoduoke.demo.web.weixin.duoapi.DuoHttpClient;
import com.fulihui.duoduoke.demo.web.weixin.duoapi.request.DuoGoodsDetailRequest;
import com.fulihui.duoduoke.demo.web.weixin.duoapi.request.DuoGoodsRecommendRequest;
import com.fulihui.duoduoke.demo.web.weixin.duoapi.request.DuoGoodsRequest;
import com.fulihui.duoduoke.demo.web.weixin.duoapi.result.*;
import org.near.servicesupport.result.ResultBuilder;
import org.near.servicesupport.result.TPageResult;
import org.near.toolkit.common.DateUtils;
import org.near.toolkit.common.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by lizhi on 2018/7/7 0007.
 */
@Component
public class DuoduoGoodsManagerImpl implements DuoduoGoodsManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(DuoduoGoodsManagerImpl.class);
    private static int totalMaxPage = 50;
    @Autowired
    DuoDuoKeConfig duoDuoKeConfig;
    @Autowired
    RedisUtils redisUtils;
    @Autowired
    private DuoHttpClient duoHttpClient;
    @Autowired
    private GoodsCatInfoRepository goodsCatInfoRepository;
    @Autowired
    private DuoGoodsInfoRepository duoduoGoodsIfoRepository;
    private int row = 100;

    /**
     * 更新优选商品
     *
     * @return
     */
    @Override
    public boolean saveOrUpdateDuoduoGoods() {
        Integer saveDay = 0;
        Object object = this.redisUtils.get(RedisContent.DUODUO_GOODS_SERCH);
        if (object != null) {
            GoodsSearchRequest request = JSONObject.parseObject(object.toString(),
                    GoodsSearchRequest.class);
            if (request != null && request.getSaveDay() != null) {
                saveDay = request.getSaveDay();
            }
        }
        Date date = new Date();
        Date newDate = date;
        if (saveDay > 0) {
            Integer subDays = saveDay + 1;
            newDate = DateUtils.addDays(date, -subDays);
        }

        DuoduoGoodsInfoExample exampleIS = new DuoduoGoodsInfoExample();
        DuoduoGoodsInfoExample.Criteria criteria = exampleIS.createCriteria();
        criteria.andIsChooseEqualTo(GoodsChooseEnum.IS.getCode());
        criteria.andStateEqualTo(GoodsStateEnum.ON.getCode());
        criteria.andChooseSortGreaterThan(0);
        long count = duoduoGoodsIfoRepository.count(exampleIS);
        long totalPage = count % 100 == 0 ? count / 100 : count / 100 + 1;
        if (totalPage > 50) {
            totalPage = totalMaxPage;
        }

        for (int i = 0; i < totalPage; i++) {
            DuoduoGoodsInfoExample example = new DuoduoGoodsInfoExample();
            DuoduoGoodsInfoExample.Criteria criterias = example.createCriteria();
            criterias.andIsChooseEqualTo(GoodsChooseEnum.IS.getCode());
            criterias.andStateEqualTo(GoodsStateEnum.ON.getCode());
            criterias.andChooseSortGreaterThan(0);
            int offset = i > 1 ? (i - 1) * 100 : 0;
            example.setOffset(offset);
            exampleIS.setLimit(100);
            List<DuoGoodsInfo> duoGoodsInfos = duoduoGoodsIfoRepository.selectByExample(example);
            if (!CollectionUtils.isEmpty(duoGoodsInfos)) {
                updateGoods(duoGoodsInfos, newDate, saveDay);

            }
        }
        return true;
    }

    /**
     * 保存orupdate拼多多商品信息
     *
     * @return
     */
    @Override
    public boolean saveDuoduoGoods() {
        List<GoodsCatInfo> goodsCatInfos = goodsCatInfoRepository.selectByLevel(
                DuoDuoGoodsLevelEnum.ONE.getCode());
        List<GoodsCatInfo> twogoodsCatInfos = goodsCatInfoRepository.selectByLevel(
                DuoDuoGoodsLevelEnum.TWO.getCode());

        List<Integer> twoCatIds = twogoodsCatInfos.stream().map(i -> {
            return i.getCatId();
        }).collect(Collectors.toList());

        for (GoodsCatInfo info : goodsCatInfos) {
            Integer catId = info.getCatId();
            //查询总条数
            DuoGoodsResult duoduoGoodsResult = queryDuoduoGoods(catId, 1, 10);
            if (duoduoGoodsResult.isSuccess()) {
                String total_count = duoduoGoodsResult.getTotal_count();
                if (StringUtil.isNotEmpty(total_count)) {
                    int total = Integer.parseInt(total_count);
                    int size = total % 100 == 0 ? total / 100 : total / 100 + 1;
                    //拼多多最多支持类目查询10000条数据
                    if (size > 100) {
                        size = 100;
                    }
                    for (int i = size; i >= 1; i--) {
                        DuoGoodsResult result = queryDuoduoGoods(catId, i, row);
                        if (result.isSuccess()) {
                            List<DuoGoodsApiResult> goods_list = result.getGoods_list();
                            if (!CollectionUtils.isEmpty(goods_list)) {
                                try {
                                    Map<String, DuoGoodsInfo> goodsinfo = new HashMap<>();
                                    for (DuoGoodsApiResult apiResult : goods_list) {
                                        DuoGoodsInfo duoGoodsInfo = convertGoods(apiResult);
                                        if (duoGoodsInfo != null) {
                                            if (twoCatIds.contains(duoGoodsInfo.getLevelTwo())) {
                                                duoGoodsInfo.setGmtCreate(new Date());
                                                duoGoodsInfo.setGmtModified(new Date());
                                            }
                                            goodsinfo.put(apiResult.getGoods_id(), duoGoodsInfo);
                                        }

                                    }
                                    if (!CollectionUtils.isEmpty(goodsinfo)) {
                                        Collection<DuoGoodsInfo> values = goodsinfo.values();
                                        List<DuoGoodsInfo> list = new ArrayList<>();
                                        list.addAll(values);
                                        duoduoGoodsIfoRepository.batchInsert(list, 1);

                                    }

                                } catch (Exception e) {
                                    LOGGER.error(e.getMessage(), e);
                                }

                            } else {
                                break;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }


    @Override
    public void updateGoods(List<DuoGoodsInfo> result, Date saveDate, Integer saveDay) {
        Map<String, DuoGoodsInfo> goodsinfo = new HashMap<>();
        for (DuoGoodsInfo info : result) {
            DuoGoodsInfo duoGoodsInfo = duoduoGoodsIfoRepository.selectByGoodsIdTable(info.getGoodsId(), 1);
            try {
                if (duoGoodsInfo == null) {
                    if (info.getCouponStartTime() != null && info.getCouponEndTime() != null) {
                        Date couponStartTime = info.getCouponStartTime();
                        Date couponEndTime = info.getCouponEndTime();
                        Date gmtModified = info.getGmtModified();
                        Date now = new Date();
                        if (couponEndTime.getTime() < now.getTime() || couponStartTime.getTime() > now.getTime()) {
                            continue;
                        }
                        Integer sort = info.getSort();
                        if (sort == 8) {
                            if (saveDay > 0) {
                                if (gmtModified.getTime() < saveDate.getTime()) {
                                    continue;
                                }
                            }
                        }
                    }
                    goodsinfo.put(info.getGoodsId() + "", info);
                } else {
                    DuoGoodsInfo updateInfo = new DuoGoodsInfo();
                    updateInfo.setId(duoGoodsInfo.getId());
                    updateInfo.setIsChoose(GoodsChooseEnum.IS.getCode());
                    updateInfo.setChooseSort(info.getChooseSort());
                    if (duoGoodsInfo.getState().equals(GoodsStateEnum.INIT.getCode())) {
                        updateInfo.setState(GoodsStateEnum.ON.getCode());
                    }
                    duoduoGoodsIfoRepository.updateByPrimaryKeySelective(updateInfo, 1);
                }
                if (!CollectionUtils.isEmpty(goodsinfo)) {
                    Collection<DuoGoodsInfo> values = goodsinfo.values();
                    List<DuoGoodsInfo> list = new ArrayList<>();
                    list.addAll(values);
                    duoduoGoodsIfoRepository.batchInsert(list, 1);
                }
            } catch (Exception e) {
                LOGGER.error(e.getMessage(), e);
            }

        }


    }

    @Override
    public boolean checkDuoduoGoods(DuoduoGoodsCheckRequest request) {

        //优选
        DuoduoGoodsInfoExample exampleIS = new DuoduoGoodsInfoExample();
        DuoduoGoodsInfoExample.Criteria criteria = exampleIS.createCriteria();
        criteria.andIsChooseEqualTo(GoodsChooseEnum.IS.getCode());
        long count = duoduoGoodsIfoRepository.count(exampleIS);
        long totalPage = count % 100 == 0 ? count / 100 : count / 100 + 1;

        for (int i = 0; i < totalPage; i++) {
            DuoduoGoodsInfoExample example = new DuoduoGoodsInfoExample();
            DuoduoGoodsInfoExample.Criteria criterias = example.createCriteria();
            criterias.andIsChooseEqualTo(GoodsChooseEnum.IS.getCode());
            int offset = i > 1 ? (i - 1) * 100 : 0;
            example.setOffset(offset);
            exampleIS.setLimit(100);
            List<DuoGoodsInfo> list = duoduoGoodsIfoRepository.selectByExample(example);
            if (!CollectionUtils.isEmpty(list)) {
                DuoduoGoodsCheckResponse response = new DuoduoGoodsCheckResponse();

                List<DuoduoGoodsInfoDTO> collect = list.stream().map(item -> {
                    DuoduoGoodsInfoDTO d = new DuoduoGoodsInfoDTO();
                    BeanUtils.copyProperties(item, d);
                    return d;
                }).collect(Collectors.toList());

                response.setResult(collect);
            }
        }


        return true;
    }

    @Override
    public void checkGoods(List<DuoGoodsInfo> duoGoodsInfos) {
        for (DuoGoodsInfo info : duoGoodsInfos) {
            try {
                List<String> goods = new ArrayList<>();
                DuoGoodsDetailResult duoduoGoodsDetailResult = queryDuoduoGoodDetail(info.getGoodsId());
                if (duoduoGoodsDetailResult.isSuccess()) {
                    List<DuoGoodsDetailApiResult> goods_details = duoduoGoodsDetailResult.getGoods_details();
                    if (CollectionUtils.isEmpty(goods_details)) {
                        goods.add(info.getGoodsId() + "");
                    } else {
                        updateGoods(duoduoGoodsDetailResult, info);
                    }
                }
                if (!CollectionUtils.isEmpty(goods)) {
                    duoduoGoodsIfoRepository.batchDelete(goods);
                }
            } catch (Exception e) {
                LOGGER.error("批量删除商品错误", e, info.getGoodsId());
            }
        }
    }

    @Override
    public List<DuoGoodsInfo> queryChannelGoods(GoodsInfoRecommendRequest infoRequest) {
        String millis = String.valueOf(System.currentTimeMillis());
        List<DuoGoodsInfo> infoList = new ArrayList<>();
        DuoGoodsRecommendRequest request = new DuoGoodsRecommendRequest();
        int channelType = infoRequest.getChannelType();
        int rows = infoRequest.getRows();
        request.setType("pdd.ddk.goods.recommend.get");
        request.setClient_id(duoDuoKeConfig.getClientId());
        request.setTimestamp(millis);
        request.setChannel_type(channelType);
        request.setOffset(infoRequest.start4Mysql());
        request.setLimit(rows);

        Map<String, Object> stringObjectMap = ClassFieldsUtil.obj2StrValMap(request);
        String sign = SignUtil
                .genServiceSign(ClassFieldsUtil.obj2StrVal(request), stringObjectMap, duoDuoKeConfig.getClientSecret());
        request.setSign(sign);
        DuoGoodsRecommendResult duoduoGoodsRecommendResult = duoHttpClient.invokeService(request);
        if (duoduoGoodsRecommendResult.isSuccess()) {
            List<DuoGoodsApiResult> list = duoduoGoodsRecommendResult.getList();
            for (DuoGoodsApiResult apiResult : list) {
                DuoGoodsInfo duoGoodsInfo = convertGoods(apiResult);
                if (duoGoodsInfo != null) {
                    infoList.add(duoGoodsInfo);
                } else {
                    infoList.add(new DuoGoodsInfo());
                }
            }
        }
        return infoList;
    }

    @Override
    public TPageResult<DuoGoodsInfo> queryGoods(GetDuoduoGoodsListRequest getDuoduoGoodsListRequest) {
        Date date = new Date();
        long l = date.getTime() / 1000;

        DuoGoodsRequest request = new DuoGoodsRequest();
        request.setType("pdd.ddk.goods.search");
        request.setClient_id(duoDuoKeConfig.getClientId());

        request.setCat_id(getDuoduoGoodsListRequest.getCatId());
        request.setSort_type(getDuoduoGoodsListRequest.getSortType());
        request.setKeyword(getDuoduoGoodsListRequest.getKeyword());
        request.setWith_coupon(false);

        if (getDuoduoGoodsListRequest.getPage() == 0) {
            getDuoduoGoodsListRequest.setPage(1);
        }
        request.setPage(getDuoduoGoodsListRequest.getPage());
        request.setPage_size(getDuoduoGoodsListRequest.getPageSize());
        request.setTimestamp(l + "");
        Map<String, Object> stringObjectMap = ClassFieldsUtil.obj2StrValMap(request);
        String sign = SignUtil.genServiceSign(ClassFieldsUtil.obj2StrVal(request), stringObjectMap,
                duoDuoKeConfig.getClientSecret());
        request.setSign(sign);
        DuoGoodsResult duoduoGoodsResult = duoHttpClient.invokeService(request);

        List<DuoGoodsInfo> infoList = null;
        int count = 0;
        if (duoduoGoodsResult.isSuccess()) {
            List<DuoGoodsApiResult> list = duoduoGoodsResult.getGoods_list();
            infoList = new ArrayList<>(list.size());
            for (DuoGoodsApiResult apiResult : list) {
                DuoGoodsInfo duoGoodsInfo = convertGoods(apiResult);
                if (duoGoodsInfo != null) {
                    infoList.add(duoGoodsInfo);
                } else {
                    infoList.add(new DuoGoodsInfo());
                }
            }
            count = Integer.parseInt(duoduoGoodsResult.getTotal_count());
            //拼多多最多支持查询前10000条数据
            if (count > 10000) {
                count = 10000;
            }
        }

        return ResultBuilder.succTPage(infoList, getDuoduoGoodsListRequest.getPageSize(), getDuoduoGoodsListRequest.getPage(), count);
    }


    public DuoGoodsResult queryDuoduoGoods(Integer catId, Integer page, Integer pageSize) {
        DuoGoodsRequest request = new DuoGoodsRequest();
        request.setCat_id(catId + "");
        request.setWith_coupon(false);
        List<DuoduoGoodsRange> list = new ArrayList<>();
        DuoduoGoodsRange range = new DuoduoGoodsRange();
        range.setRange_id(5);
        range.setRange_from(100);
        list.add(range);
        DuoduoGoodsRange range1 = new DuoduoGoodsRange();
        range1.setRange_id(2);
        range1.setRange_from(1);
        list.add(range1);
        request.setRange_list(JSON.toJSONString(list));
        DuoGoodsResult duoduoGoodsResult = duoduoGoodsRequest(page, pageSize, request);
        return duoduoGoodsResult;
    }

    public DuoGoodsInfo convertGoods(DuoGoodsApiResult result) {
        String goods_image_url = result.getGoods_image_url();
        DuoGoodsInfo info = new DuoGoodsInfo();
        if (StringUtil.isNotEmpty(goods_image_url)) {
            String cat_ids = result.getCat_ids();
            if (StringUtil.isNotEmpty(cat_ids)) {
                String substring = cat_ids.substring(1, cat_ids.length() - 1);
                String[] split = substring.split(",");
                info.setLevelOne(Integer.parseInt(split[0]));
                info.setLevelTwo(Integer.parseInt(split[1]));
                info.setLevelThree(Integer.parseInt(split[2]));
            }
            info.setGoodsId(Long.parseLong(result.getGoods_id()));
            info.setGoodsName(result.getGoods_name());
            info.setGoodsDesc(result.getGoods_desc());
            info.setGoodsThumbnailUrl(result.getGoods_thumbnail_url());
            info.setGoodsImageUrl(result.getGoods_image_url());
            info.setSoldQuantity(result.getSold_quantity());
            info.setMallName(result.getMall_name());
            info.setMinNormalPrice(result.getMin_normal_price());
            info.setMinGroupPrice(result.getMin_group_price());
            info.setOptName(result.getOpt_name());
            info.setOptId(result.getOpt_id());
            info.setCatIds(result.getCat_ids());
            info.setHasCoupon(result.hashCode() + "");
            info.setAvgServ(result.getAvg_serv());
            info.setAvgLgst(result.getAvg_lgst());
            info.setAvgDesc(result.getAvg_desc());
            info.setGoodsEvalCount(result.getGoods_eval_count());
            info.setGoodsEvalScore(result.getGoods_eval_score());
            info.setPromotionRate(result.getPromotion_rate());
            info.setSaleNum24(result.getSale_num24());
            boolean has_coupon = result.isHas_coupon();
            info.setHasCoupon(has_coupon + "");
            Date now = new Date();
            if (has_coupon) {
                //优惠券
                String coupon_end_time = result.getCoupon_end_time();
                String coupon_start_time = result.getCoupon_start_time();
                Long endTime = Long.parseLong(coupon_end_time) * 1000;
                Long startTime = Long.parseLong(coupon_start_time) * 1000;
                info.setCouponEndTime(new Date(endTime));
                info.setCouponStartTime(new Date(startTime));
                info.setCouponRemainQuantity(result.getCoupon_remain_quantity());
                info.setCouponTotalQuantity(result.getCoupon_total_quantity());
                info.setCouponDiscount(result.getCoupon_discount());
                info.setCouponMinOrderAmount(result.getCoupon_min_order_amount());
                if (startTime < now.getTime() && now.getTime() < endTime) {
                    info.setState(GoodsStateEnum.ON.getCode());
                } else if (endTime < now.getTime()) {
                    return null;
                } else if (now.getTime() < startTime) {
                    info.setState(GoodsStateEnum.INIT.getCode());
                }
            } else {
                info.setState(GoodsStateEnum.ON.getCode());
            }
            info.setSort(8);
            info.setIsChoose(GoodsChooseEnum.NO.getCode());
            info.setChooseSort(0);

            return info;
        }
        return null;


    }

    /**
     * 数据库中存有数据，拉取拼多多最新数据
     *
     * @param info
     * @return
     */
    @Override
    public DuoGoodsInfo updateDuoduoGoodDetail(DuoGoodsInfo info) {
        try {
            Long goodsId = info.getGoodsId();
            DuoGoodsDetailResult duoduoGoodsDetailResult = queryDuoduoGoodDetail(goodsId);
            DuoGoodsInfo duoGoodsInfo = updateGoods(duoduoGoodsDetailResult, info);
            if (duoGoodsInfo == null) {
                return info;
            } else {
                return duoGoodsInfo;
            }
        } catch (Exception e) {
            LOGGER.error("更新商品错误", e, info.getGoodsId());
        }
        return null;
    }

    /**
     * 数据库中无数据，拉取商品数据详情
     *
     * @param goodsId
     * @return
     */
    @Override
    public DuoGoodsInfo getDuoduoGoodDetail(Long goodsId) {
        //调用多多接口
        DuoGoodsDetailResult duoduoGoodsDetailResult = queryDuoduoGoodDetail(goodsId);

        //数据转换
        DuoGoodsInfo goodsInfos = convertGoodsInfo(duoduoGoodsDetailResult);
        return goodsInfos;
    }

    public DuoGoodsDetailResult queryDuoduoGoodDetail(Long goodId) {
        DuoGoodsDetailRequest request = new DuoGoodsDetailRequest();
        request.setType("pdd.ddk.goods.detail");
        request.setClient_id(duoDuoKeConfig.getClientId());
        Date date = new Date();
        long l = date.getTime() / 1000;
        request.setTimestamp(l + "");
        request.setGoods_id_list("[" + goodId + "]");
        Map<String, Object> stringObjectMap = ClassFieldsUtil.obj2StrValMap(request);
        String sign = SignUtil.genServiceSign(ClassFieldsUtil.obj2StrVal(request), stringObjectMap,
                duoDuoKeConfig.getClientSecret());
        request.setSign(sign);
        DuoGoodsDetailResult duoduoGoodsResult = duoHttpClient.invokeService(request);
        return duoduoGoodsResult;
    }

    /**
     * 详情列表更新
     *
     * @param result
     * @param goodsInfo
     * @return
     */
    public DuoGoodsInfo updateGoods(DuoGoodsDetailResult result, DuoGoodsInfo goodsInfo) {

        List<DuoGoodsDetailApiResult> goodsDetailList = result.getGoods_details();
        if (!CollectionUtils.isEmpty(goodsDetailList)) {
            DuoGoodsDetailApiResult detailResult = goodsDetailList.get(0);
            DuoGoodsInfo info = new DuoGoodsInfo();
            info.setId(goodsInfo.getId());
            if (StringUtil.isEmpty(goodsInfo.getGoodsDesc())) {
                info.setGoodsDesc(detailResult.getGoods_desc());
            }
            if (StringUtil.isEmpty(goodsInfo.getGoodsGalleryUrls())) {
                info.setGoodsGalleryUrls(detailResult.getGoods_gallery_urls());
            }
            info.setGoodsId(Long.parseLong(detailResult.getGoods_id()));
            info.setSoldQuantity(detailResult.getSold_quantity());
            info.setAvgServ(detailResult.getAvg_serv());
            info.setAvgLgst(detailResult.getAvg_lgst());
            info.setAvgDesc(detailResult.getAvg_desc());
            info.setGoodsEvalCount(detailResult.getGoods_eval_count());
            info.setGoodsEvalScore(detailResult.getGoods_eval_score());
            info.setMinGroupPrice(detailResult.getMin_group_price());
            info.setPromotionRate(detailResult.getPromotion_rate());
            info.setHasCoupon(detailResult.isHas_coupon() + "");
            if (detailResult.isHas_coupon()) {
                info.setCouponRemainQuantity(detailResult.getCoupon_remain_quantity());
                String coupon_end_time = detailResult.getCoupon_end_time();
                String coupon_start_time = detailResult.getCoupon_start_time();
                if (StringUtil.isNotEmpty(coupon_end_time)) {
                    Long endTime = Long.parseLong(coupon_end_time) * 1000;
                    info.setCouponEndTime(new Date(endTime));
                }
                if (StringUtil.isNotEmpty(coupon_start_time)) {
                    Long startTime = Long.parseLong(coupon_start_time) * 1000;
                    info.setCouponStartTime(new Date(startTime));
                }
                info.setCouponTotalQuantity(detailResult.getCoupon_total_quantity());
                info.setCouponDiscount(detailResult.getCoupon_discount());
                info.setCouponMinOrderAmount(detailResult.getCoupon_min_order_amount());
            }
            Date now = new Date();
            info.setDetailUpdate(now);
            info.setGmtModified(now);
            duoduoGoodsIfoRepository.updateByPrimaryKeySelective(info);
            return info;
        }
        return null;
    }


    public DuoGoodsInfo updateGoodInfos(DuoGoodsApiResult result, DuoGoodsInfo goodsInfo) {

        DuoGoodsInfo info = new DuoGoodsInfo();
        info.setId(goodsInfo.getId());
        if (!StringUtil.isEmpty(goodsInfo.getGoodsDesc())) {
            info.setGoodsDesc(result.getGoods_desc());
        }
        info.setGoodsId(Long.parseLong(result.getGoods_id()));
        info.setSoldQuantity(result.getSold_quantity());
        info.setAvgServ(result.getAvg_serv());
        info.setAvgLgst(result.getAvg_lgst());
        info.setAvgDesc(result.getAvg_desc());
        info.setGoodsEvalCount(result.getGoods_eval_count());
        info.setGoodsEvalScore(result.getGoods_eval_score());
        info.setPromotionRate(result.getPromotion_rate());
        info.setHasCoupon(result.isHas_coupon() + "");
        if (result.isHas_coupon()) {
            info.setCouponRemainQuantity(result.getCoupon_remain_quantity());
            String coupon_end_time = result.getCoupon_end_time();
            String coupon_start_time = result.getCoupon_start_time();
            if (StringUtil.isNotEmpty(coupon_end_time)) {
                Long endTime = Long.parseLong(coupon_end_time) * 1000;
                info.setCouponEndTime(new Date(endTime));
            }
            if (StringUtil.isNotEmpty(coupon_start_time)) {
                Long startTime = Long.parseLong(coupon_start_time) * 1000;
                info.setCouponStartTime(new Date(startTime));
            }
            info.setCouponTotalQuantity(result.getCoupon_total_quantity());
            info.setCouponDiscount(result.getCoupon_discount());
            info.setCouponMinOrderAmount(result.getCoupon_min_order_amount());
        }
        info.setMinGroupPrice(result.getMin_group_price());
        duoduoGoodsIfoRepository.updateByPrimaryKeySelective(info);
        return info;
    }

    /**
     * 数据库中没有数据平多多商品类型转换
     *
     * @param result
     * @return
     */
    private DuoGoodsInfo convertGoodsInfo(DuoGoodsDetailResult result) {
        DuoGoodsInfo info = new DuoGoodsInfo();
        if (result.isSuccess()) {
            List<DuoGoodsDetailApiResult> goodsDetails = result.getGoods_details();
            if (!CollectionUtils.isEmpty(goodsDetails)) {
                DuoGoodsDetailApiResult detailInfo = goodsDetails.get(0);
                info.setGoodsId(Long.parseLong(detailInfo.getGoods_id()));
                info.setGoodsName(detailInfo.getGoods_name());
                info.setGoodsDesc(detailInfo.getGoods_desc());
                info.setGoodsThumbnailUrl(detailInfo.getGoods_thumbnail_url());
                info.setGoodsImageUrl(detailInfo.getGoods_image_url());
                info.setSoldQuantity(detailInfo.getSold_quantity());
                info.setMallName(detailInfo.getMall_name());
                info.setMinNormalPrice(detailInfo.getMin_normal_price());
                info.setMinGroupPrice(detailInfo.getMin_group_price());
                info.setOptName(detailInfo.getOpt_name());
                info.setOptId(detailInfo.getOpt_id());
                info.setCatIds(detailInfo.getCat_ids());
                info.setHasCoupon(result.hashCode() + "");
                info.setAvgServ(detailInfo.getAvg_serv());
                info.setAvgLgst(detailInfo.getAvg_lgst());
                info.setAvgDesc(detailInfo.getAvg_desc());
                info.setGoodsEvalCount(detailInfo.getGoods_eval_count());
                info.setGoodsEvalScore(detailInfo.getGoods_eval_score());
                info.setPromotionRate(detailInfo.getPromotion_rate());
                info.setGoodsGalleryUrls(detailInfo.getGoods_gallery_urls());
                boolean has_coupon = detailInfo.isHas_coupon();
                info.setHasCoupon(has_coupon + "");
                Date now = new Date();
                if (has_coupon) {
                    //优惠券
                    String coupon_end_time = detailInfo.getCoupon_end_time();
                    String coupon_start_time = detailInfo.getCoupon_start_time();
                    if (StringUtil.isNotEmpty(coupon_end_time) && StringUtil.isNotEmpty(coupon_start_time)) {
                        Long endTime = Long.parseLong(coupon_end_time) * 1000;
                        info.setCouponEndTime(new Date(endTime));
                        Long startTime = Long.parseLong(coupon_start_time) * 1000;
                        info.setCouponStartTime(new Date(startTime));
                        if (startTime < now.getTime() && now.getTime() < endTime) {
                            info.setState(GoodsStateEnum.ON.getCode());
                        } else if (endTime < now.getTime()) {
                            return null;
                        } else if (now.getTime() < startTime) {
                            info.setState(GoodsStateEnum.INIT.getCode());
                        }
                    }
                    info.setCouponRemainQuantity(detailInfo.getCoupon_remain_quantity());
                    info.setCouponTotalQuantity(detailInfo.getCoupon_total_quantity());
                    info.setCouponDiscount(detailInfo.getCoupon_discount());
                    info.setCouponMinOrderAmount(detailInfo.getCoupon_min_order_amount());

                } else {
                    info.setState(GoodsStateEnum.ON.getCode());
                }
                info.setSort(8);
                info.setIsChoose(GoodsChooseEnum.NO.getCode());
                info.setChooseSort(0);
                String cat_ids = detailInfo.getCat_ids();
                if (StringUtil.isNotEmpty(cat_ids)) {
                    String substring = cat_ids.substring(1, cat_ids.length() - 1);
                    String[] split = substring.split(",");
                    info.setLevelOne(Integer.parseInt(split[0]));
                    info.setLevelTwo(Integer.parseInt(split[1]));
                    info.setLevelThree(Integer.parseInt(split[2]));
                }
                info.setGoodsDesc(detailInfo.getGoods_desc());
                return info;
            }
        }
        return null;

    }


    public DuoGoodsResult duoduoGoodsRequest(Integer page, Integer pageSize, DuoGoodsRequest request) {
        request.setType("pdd.ddk.goods.search");
        request.setClient_id(duoDuoKeConfig.getClientId());
        Date date = new Date();
        long l = date.getTime() / 1000;
        request.setTimestamp(l + "");
        request.setPage(page);
        if (pageSize != null) {
            request.setPage_size(pageSize);
        }
        Map<String, Object> stringObjectMap = ClassFieldsUtil.obj2StrValMap(request);
        String sign = SignUtil.genServiceSign(ClassFieldsUtil.obj2StrVal(request), stringObjectMap,
                duoDuoKeConfig.getClientSecret());
        request.setSign(sign);
        DuoGoodsResult duoduoGoodsResult = duoHttpClient.invokeService(request);
        return duoduoGoodsResult;
    }


    @Override
    public GoodsSearchResponse duoduoGoodsSearch(Integer page, Integer rows, Integer totalMaxPage, GoodsSearchRequest request, String isChoose) {
        GoodsSearchResponse response = new GoodsSearchResponse();
        int repeat = 0;
        int exception = 0;
        int insert = 0;
        //List<String> successGoodsId = new ArrayList<>();
        for (int i = page; i <= totalMaxPage; i++) {
            DuoGoodsRequest goodsRequest = new DuoGoodsRequest();
            goodsRequest.setRange_list(request.getRange_list());
            goodsRequest.setWith_coupon(request.isWith_coupon());
            goodsRequest.setGoods_id_list(request.getGoodIds());
            goodsRequest.setSort_type(request.getSort_type());
            DuoGoodsResult result = duoduoGoodsRequest(i, rows, goodsRequest);
            if (result.isSuccess()) {
                List<DuoGoodsApiResult> goods_list = result.getGoods_list();
                if (!CollectionUtils.isEmpty(goods_list)) {
                    Map<String, DuoGoodsInfo> goodsinfo = new HashMap<>();
                    for (DuoGoodsApiResult apiResult : goods_list) {
                        DuoGoodsInfo duoGoodsInfo = duoduoGoodsIfoRepository.selectByGoodsId(Long.parseLong(apiResult.getGoods_id()));
                        try {
                            if (duoGoodsInfo == null) {
                                DuoGoodsInfo goodsInfo = convertGoods(apiResult);
                                if (goodsInfo != null) {
                                    goodsInfo.setGmtCreate(new Date());
                                    goodsInfo.setGmtModified(new Date());
                                    if (StringUtil.equals(isChoose, GoodsChooseEnum.IS.getCode())) {
                                        goodsInfo.setIsChoose(GoodsChooseEnum.IS.getCode());
                                        goodsInfo.setChooseSort(0);
                                    }
                                    goodsinfo.put(apiResult.getGoods_id(), goodsInfo);
                                    //successGoodsId.add(apiResult.getGoods_id());
                                } else {
                                    exception++;
                                }

                            } else {
                                repeat++;
                                if (StringUtil.equals(isChoose, GoodsChooseEnum.IS.getCode())) {
                                    if (duoGoodsInfo.getIsChoose().equals(GoodsChooseEnum.NO.getCode())) {
                                        DuoGoodsInfo goodsInfo = new DuoGoodsInfo();
                                        goodsInfo.setId(duoGoodsInfo.getId());
                                        goodsInfo.setGmtModified(new Date());
                                        goodsInfo.setIsChoose(GoodsChooseEnum.IS.getCode());
                                        goodsInfo.setChooseSort(0);
                                        duoduoGoodsIfoRepository.updateByPrimaryKeySelective(goodsInfo);
                                    }
                                }
                            }

                        } catch (Exception e) {
                            LOGGER.error(e.getMessage(), e);
                        }

                    }
                    if (!CollectionUtils.isEmpty(goodsinfo)) {
                        Collection<DuoGoodsInfo> values = goodsinfo.values();
                        if (!CollectionUtils.isEmpty(values)) {
                            List<DuoGoodsInfo> list = new ArrayList<>();
                            list.addAll(values);
                            insert = duoduoGoodsIfoRepository.batchInsert(list, 0) + insert;
                        }
                    }
                }
            }
        }
        response.setSuccess(insert);
        response.setRepeat(repeat);
        response.setException(exception);
        //response.setGoodsId(successGoodsId);
        return response;
    }


}
