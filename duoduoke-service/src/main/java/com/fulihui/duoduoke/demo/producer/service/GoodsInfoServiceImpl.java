package com.fulihui.duoduoke.demo.producer.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fulihui.duoduoke.demo.api.api.GoodsInfoService;
import com.fulihui.duoduoke.demo.api.dto.DuoduoGoodsInfoDTO;
import com.fulihui.duoduoke.demo.api.dto.GoodsTabelDTO;
import com.fulihui.duoduoke.demo.api.enums.GoodsChooseEnum;
import com.fulihui.duoduoke.demo.api.enums.GoodsStateEnum;
import com.fulihui.duoduoke.demo.api.request.*;
import com.fulihui.duoduoke.demo.api.response.GoodsSearchInfoResponse;
import com.fulihui.duoduoke.demo.api.response.GoodsSearchResponse;
import com.fulihui.duoduoke.demo.common.config.DuoDuoKeConfig;
import com.fulihui.duoduoke.demo.common.config.RedisContent;
import com.fulihui.duoduoke.demo.common.util.RedisUtils;
import com.fulihui.duoduoke.demo.producer.dal.dao.GoodSearchRecordMapper;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.DuoGoodsInfo;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.DuoduoGoodsInfoExample;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.ExtDuoduoGoodsInfoExample;
import com.fulihui.duoduoke.demo.producer.manager.DuoduoGoodsManager;
import com.fulihui.duoduoke.demo.producer.repository.DuoGoodsInfoRepository;
import com.fulihui.duoduoke.demo.producer.util.ClassFieldsUtil;
import com.fulihui.duoduoke.demo.producer.util.Consts;
import com.fulihui.duoduoke.demo.web.weixin.duoapi.DuoHttpClient;
import com.fulihui.duoduoke.demo.web.weixin.duoapi.request.DuoGoodsSearchRequest;
import com.fulihui.duoduoke.demo.web.weixin.duoapi.result.DuoGoodsSearchResult;
import com.google.common.collect.Lists;
import org.apache.dubbo.config.annotation.Service;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.near.servicesupport.error.Errors;
import org.near.servicesupport.result.BaseResult;
import org.near.servicesupport.result.ResultBuilder;
import org.near.servicesupport.result.TPageResult;
import org.near.servicesupport.result.TSingleResult;
import org.near.servicesupport.util.ServiceAssert;
import org.near.toolkit.common.DateUtils;
import org.near.toolkit.common.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;
import java.util.stream.Collectors;

import static com.fulihui.duoduoke.demo.producer.util.SignUtil.genServiceSign;
import static org.springframework.util.CollectionUtils.isEmpty;

/**
 * The type Goods info service.
 *
 * @author lizhi
 * @date 2018 -7-9
 */
@Service(version = "${demo.service.version}")

public class GoodsInfoServiceImpl implements GoodsInfoService {

    private static final Logger LOGGER = LoggerFactory
            .getLogger(GoodsInfoServiceImpl.class);
    /**
     * The Template.
     */

    private static final Logger JOB_GOODS_LOGGER = LoggerFactory
            .getLogger(Consts.LoggerName.JOB_MONITOR);
    /**
     * The Duo duo ke config.
     */
    @Autowired
    DuoDuoKeConfig duoDuoKeConfig;
    /**
     * The Duoduo http client.
     */
    @Autowired
    DuoHttpClient duoHttpClient;
    /**
     * The Good search record mapper.
     */
    @Autowired
    GoodSearchRecordMapper goodSearchRecordMapper;
    /**
     * The Duoduo goods info repository.
     */
    @Autowired
    DuoGoodsInfoRepository duoGoodsInfoRepository;
    /**
     * The Duoduo goods manager.
     */
    @Autowired
    DuoduoGoodsManager duoduoGoodsManager;
    /**
     * The Goods tabel mapper.
     */

    /**
     * The Redis utils.
     */
    @Autowired
    RedisUtils redisUtils;


    @Override
    public TPageResult<GoodsSearchInfoResponse> search(GoodsSearchInfoRequest infoRequest) {

        long start = System.currentTimeMillis();

        LOGGER.debug("测试优雅关闭,start:{}", start);

        ServiceAssert.notNull(infoRequest, Errors.Commons.REQUEST_PARAMETER_ERROR);
        String millis = String.valueOf(System.currentTimeMillis());
        DuoGoodsSearchRequest search = new DuoGoodsSearchRequest();
        search.setType("pdd.ddk.goods.search");
        search.setClient_id(duoDuoKeConfig.getClientId());
        search.setTimestamp(millis);
        search.setSort_type(infoRequest.getSort_type());
        search.setWith_coupon(infoRequest.getWith_coupon());
        search.setKeyword(infoRequest.getKeyword());
        search.setCat_id(infoRequest.getCat_id());
        search.setPage(infoRequest.getPage() + "");
        search.setPage_size(infoRequest.getRows() + "");
        if (infoRequest.getRange_list() != null) {
            search.setRange_list(JSON.toJSONString(infoRequest.getRange_list()));
        }
        Map<String, Object> strValMap = ClassFieldsUtil.obj2StrValMap(search);
        String sign = genServiceSign(ClassFieldsUtil.obj2StrVal(search), strValMap,
                duoDuoKeConfig.getClientSecret());
        search.setSign(sign);
        List<GoodsSearchInfoResponse> collect = Lists.newArrayList();
        Integer count = 0;
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            URIBuilder builder = new URIBuilder("https://gw-api.pinduoduo.com/api/router");
            builder.addParameter("data_type", "JSON");
            if (StringUtil.isNotBlank(search.getType())) {
                builder.addParameter("type", "pdd.ddk.goods.search");
            }
            if (StringUtil.isNotBlank(search.getTimestamp())) {
                builder.addParameter("timestamp", millis);
            }
            if (StringUtil.isNotBlank(search.getClient_id())) {
                builder.addParameter("client_id", duoDuoKeConfig.getClientId());
            }

            if (search.getKeyword() != null) {
                builder.addParameter("keyword", search.getKeyword());
            }
            if (search.getCat_id() != null) {
                builder.addParameter("cat_id", search.getCat_id());
            }
            if (StringUtil.isNotBlank(search.getSort_type())) {
                builder.addParameter("sort_type", search.getSort_type());
            }

            if (StringUtil.isNotBlank(search.getWith_coupon())) {
                builder.addParameter("with_coupon", search.getWith_coupon());
            }

            if (StringUtil.isNotBlank(search.getPage())) {
                builder.addParameter("page", search.getPage());
            }

            if (StringUtil.isNotBlank(search.getPage_size())) {
                builder.addParameter("page_size", search.getPage_size());
            }

            if (StringUtil.isNotBlank(search.getRange_list())) {
                builder.addParameter("range_list", search.getRange_list());
            }

            if (StringUtil.isNotBlank(search.getSign())) {
                builder.addParameter("sign", sign);
            }

            HttpPost post = new HttpPost(builder.build());
            HttpResponse response = httpClient.execute(post);
            HttpEntity entity = response.getEntity();
            String respStr = EntityUtils.toString(entity);
            LOGGER.debug("success Response: {}", respStr);

            DuoGoodsSearchResult result = JSONObject.parseObject(respStr,
                    DuoGoodsSearchResult.class);
            boolean bl = (StringUtil.isBlank(result.getError_code())
                    || StringUtil.isBlank(result.getError_msg()));
            DuoGoodsSearchResult.GoodsSearchResponseBean goodsSearchResponse = result
                    .getGoods_search_response();
            if (goodsSearchResponse != null) {
                count = goodsSearchResponse.getTotal_count();
                List<DuoGoodsSearchResult.GoodsSearchResponseBean.GoodsListBean> goodsList = goodsSearchResponse
                        .getGoods_list();
                if (!isEmpty(goodsList)) {
                    collect = goodsList.stream().map(i -> {
                        GoodsSearchInfoResponse infoResponse = new GoodsSearchInfoResponse();
                        BeanUtils.copyProperties(i, infoResponse);
                        return infoResponse;
                    }).collect(Collectors.toList());
                }
            }
        } catch (URISyntaxException | IOException ignored) {
        }
        boolean empty = !CollectionUtils.isEmpty(collect);
        long end = System.currentTimeMillis();
        LOGGER.debug("测试优雅结束,ms:{}", end - start);
        LOGGER.info("search.empty:{}", empty ? "Y" : "N");
        return ResultBuilder.succTPage(collect, infoRequest.getPage(), infoRequest.getRows(),
                count);
    }

    @Override
    public BaseResult updateTable() {
        return null;
    }

    @Override
    public TSingleResult<GoodsTabelDTO> queryGoodsTable() {
        return null;
    }

    @Override
    public TPageResult<DuoduoGoodsInfoDTO> searchCouponGoods(GetDuoduoGoodsListRequest request) {
        GoodsSearchInfoRequest infoRequest = new GoodsSearchInfoRequest();
        infoRequest.setKeyword(request.getKeyword());
        infoRequest.setSort_type(request.getSortType() + "");
        infoRequest.setCat_id(request.getCatId());
        infoRequest.setPage(request.getPage());
        infoRequest.setRows(request.getPageSize());
        if (request.getHasCoupon() != null && request.getHasCoupon()) {
            infoRequest.setWith_coupon("true");
        } else {
            infoRequest.setWith_coupon("false");
        }

        //设置优惠券金额
        if (request.getCouponPrice() > 0) {
            List<GoodsSearchInfoRangeRequest> rangeRequestList = new ArrayList<>();
            GoodsSearchInfoRangeRequest rangeRequest = new GoodsSearchInfoRangeRequest();
            rangeRequest.setRange_from(request.getCouponPrice() * 100);
            rangeRequest.setRange_to(request.getCouponPrice() * 100);
            rangeRequest.setRange_id(3);
            rangeRequestList.add(rangeRequest);
            infoRequest.setRange_list(rangeRequestList);
        }
        TPageResult<GoodsSearchInfoResponse> search = search(infoRequest);

        List<DuoduoGoodsInfoDTO> list = new ArrayList<>();

        if (search == null) {
            return ResultBuilder.failTPage(0, "无数据");
        }

        if (search.getValues() != null && search.getValues().size() > 0) {
            search.getValues().stream().filter((item) -> item.getGoods_id() != null)
                    .forEach((detailInfo) -> {
                        DuoduoGoodsInfoDTO info = new DuoduoGoodsInfoDTO();
                        info.setGoodsId(Long.parseLong(detailInfo.getGoods_id()));
                        info.setGoodsName(detailInfo.getGoods_name());
                        info.setGoodsDesc(detailInfo.getGoods_desc());
                        info.setGoodsThumbnailUrl(detailInfo.getGoods_thumbnail_url());
                        info.setGoodsImageUrl(detailInfo.getGoods_image_url());
                        info.setSoldQuantity(detailInfo.getSold_quantity());
                        info.setMallName(detailInfo.getMall_name());
                        info.setMinNormalPrice(detailInfo.getMin_normal_price());
                        info.setMinGroupPrice(detailInfo.getMin_group_price());
                        info.setAvgServ(detailInfo.getAvg_serv());
                        info.setAvgLgst(detailInfo.getAvg_lgst());
                        info.setAvgDesc(detailInfo.getAvg_desc());
                        info.setGoodsEvalCount(detailInfo.getGoods_eval_count());
                        info.setPromotionRate(detailInfo.getPromotion_rate());
                        info.setGoodsGalleryUrls(detailInfo.getGoods_gallery_urls());
                        info.setGoodsDesc(detailInfo.getGoods_desc());
                        info.setLevelOne(detailInfo.getCat_id());
                        info.setCouponDiscount(detailInfo.getCoupon_discount());
                        info.setHasCoupon(detailInfo.isHas_coupon());
                        if (detailInfo.isHas_coupon()) {
                            //优惠券
                            String coupon_end_time = detailInfo.getCoupon_end_time();
                            String coupon_start_time = detailInfo.getCoupon_start_time();
                            Long endTime = Long.parseLong(coupon_end_time) * 1000;
                            Long startTime = Long.parseLong(coupon_start_time) * 1000;
                            info.setCouponEndTime(new Date(endTime));
                            info.setCouponStartTime(new Date(startTime));
                            info.setCouponRemainQuantity(detailInfo.getCoupon_remain_quantity());
                            info.setCouponTotalQuantity(detailInfo.getCoupon_total_quantity());
                            info.setCouponDiscount(detailInfo.getCoupon_discount());
                            info.setCouponMinOrderAmount(detailInfo.getCoupon_min_order_amount());
                            info.setState(GoodsStateEnum.INIT.getCode());
                        } else {
                            info.setState(GoodsStateEnum.ON.getCode());
                        }

                        list.add(info);
                    });
        }

        int count = search.getTotalRows() > 10000 ? 10000 : search.getTotalRows();

        return ResultBuilder.succTPage(list, infoRequest.getPage(), infoRequest.getRows(), count);
    }

    @Override
    public BaseResult record(GoodSearchRecordRequest infoRequest) {
        return ResultBuilder.succ();
    }

    /**
     * 查询商品 详情是否更新
     *
     * @param request
     * @return
     */
    @Override
    public TSingleResult<DuoduoGoodsInfoDTO> queryGoodsDetail(DuoduoGoodsInfoRequest request) {
        DuoduoGoodsInfoDTO response = null;
        ServiceAssert.notNull(request, Errors.Commons.REQUEST_PARAMETER_ERROR);
        Long goodsId = request.getGoodsId();
        ServiceAssert.notNull(goodsId, Errors.Commons.REQUEST_PARAMETER_ERROR);
        DuoGoodsInfo duoGoodsInfo = duoGoodsInfoRepository.selectByGoodsId(goodsId);
        if (duoGoodsInfo != null) {
            Date now = new Date();
            Date detailUpdate = duoGoodsInfo.getDetailUpdate();
            //更新时间为空 或者间隔大一天
            if (detailUpdate == null || DateUtils.getDiffDays(now, detailUpdate) >= 1) {
                //更新多多商品信息
                duoduoGoodsManager.updateDuoduoGoodDetail(duoGoodsInfo);
                //再次查询
                duoGoodsInfo = duoGoodsInfoRepository.selectByGoodsId(goodsId);
            }
        } else {
            //查询多多详情--调用平多多接口
            //默认时间数据
            duoGoodsInfo = duoduoGoodsManager.getDuoduoGoodDetail(goodsId);
            if (duoGoodsInfo != null) {
                duoGoodsInfo.setGmtCreate(Calendar.getInstance().getTime());
                duoGoodsInfo.setGmtModified(Calendar.getInstance().getTime());
                duoGoodsInfo.setDetailUpdate(Calendar.getInstance().getTime());
                long insert = duoGoodsInfoRepository.insert(duoGoodsInfo);
            }
        }

        if (duoGoodsInfo != null) {
            response = new DuoduoGoodsInfoDTO();
            BeanUtils.copyProperties(duoGoodsInfo, response);
            response.setHasCoupon(Boolean.parseBoolean(duoGoodsInfo.getHasCoupon()));
            return ResultBuilder.succTSingle(response);
        } else {
            return ResultBuilder.succTSingle(null);
        }

    }

    @Override
    public TSingleResult<DuoduoGoodsInfoDTO> queryGoodsDetailNO(DuoduoGoodsInfoRequest request) {
        DuoduoGoodsInfoDTO response = null;
        ServiceAssert.notNull(request, Errors.Commons.REQUEST_PARAMETER_ERROR);
        Long goodsId = request.getGoodsId();
        ServiceAssert.notNull(goodsId, Errors.Commons.REQUEST_PARAMETER_ERROR);
        DuoGoodsInfo duoGoodsInfo = duoGoodsInfoRepository.selectByGoodsId(goodsId);
        if (duoGoodsInfo != null) {
            Date now = new Date();
            Date detailUpdate = duoGoodsInfo.getDetailUpdate();
            //更新时间为空 或者间隔大一天
            if (detailUpdate == null || DateUtils.getDiffDays(now, detailUpdate) >= 1) {
                //更新多多商品信息
                duoduoGoodsManager.updateDuoduoGoodDetail(duoGoodsInfo);
                //再次查询
                duoGoodsInfo = duoGoodsInfoRepository.selectByGoodsId(goodsId);
            }

        } else {
            duoGoodsInfo = duoduoGoodsManager.getDuoduoGoodDetail(goodsId);
        }
        if (duoGoodsInfo != null) {
            response = new DuoduoGoodsInfoDTO();
            BeanUtils.copyProperties(duoGoodsInfo, response);
            response.setHasCoupon(Boolean.parseBoolean(duoGoodsInfo.getHasCoupon()));
        }
        return ResultBuilder.succTSingle(response);
    }

    @Override
    public TPageResult<DuoduoGoodsInfoDTO> queryGoodsInfo(DuoduoGoodsInfoRequest infoRequest) {

        ExtDuoduoGoodsInfoExample example = createExapmle(infoRequest);

        List<DuoGoodsInfo> duoGoodsInfos = duoGoodsInfoRepository.selectByExample(example);
        if (CollectionUtils.isEmpty(duoGoodsInfos)) {
            return ResultBuilder.succTPage(Lists.newArrayList(), infoRequest.getPage(),
                    infoRequest.getRows(), 0);
        }

        //查询条数
        long count = duoGoodsInfoRepository.count(example);
        List<DuoduoGoodsInfoDTO> collect = convertModel(duoGoodsInfos);

        return ResultBuilder.succTPage(collect, infoRequest.getPage(), infoRequest.getRows(),
                (int) count);
    }

    @Override
    public TPageResult<DuoduoGoodsInfoDTO> queryGoodsInfoWithMark(DuoduoGoodsInfoRequest infoRequest) {

        ExtDuoduoGoodsInfoExample example = createExapmle(infoRequest);

        List<DuoGoodsInfo> duoGoodsInfos = duoGoodsInfoRepository
                .selectByExtExample(example);
        if (CollectionUtils.isEmpty(duoGoodsInfos)) {
            return ResultBuilder.succTPage(Lists.newArrayList(), infoRequest.getPage(),
                    infoRequest.getRows(), 0);
        }

        //查询条数
        long count = duoGoodsInfoRepository.countByExtExample(example);
        List<DuoduoGoodsInfoDTO> collect = convertModel(duoGoodsInfos);

        return ResultBuilder.succTPage(collect, infoRequest.getPage(), infoRequest.getRows(),
                (int) count);
    }

    private List<DuoduoGoodsInfoDTO> convertModel(List<DuoGoodsInfo> duoGoodsInfos) {
        return duoGoodsInfos.stream().map(i -> {
            DuoduoGoodsInfoDTO response = new DuoduoGoodsInfoDTO();
            BeanUtils.copyProperties(i, response);
            response.setHasCoupon(Boolean.parseBoolean(i.getHasCoupon()));
            return response;
        }).collect(Collectors.toList());
    }

    /**
     * 查询条件
     *
     * @param infoRequest
     * @return
     */
    private ExtDuoduoGoodsInfoExample createExapmle(DuoduoGoodsInfoRequest infoRequest) {
        ServiceAssert.notNull(infoRequest, Errors.Commons.REQUEST_PARAMETER_ERROR);
        ExtDuoduoGoodsInfoExample example = new ExtDuoduoGoodsInfoExample();
        DuoduoGoodsInfoExample.Criteria criteria = example.createCriteria();
        if (infoRequest.getGoodsId() != null) {
            criteria.andGoodsIdEqualTo(infoRequest.getGoodsId());
        }
        if (infoRequest.getLevelOne() != null) {
            criteria.andLevelOneEqualTo(infoRequest.getLevelOne());
        }
        if (infoRequest.getLevelTwo() != null) {
            criteria.andLevelTwoEqualTo(infoRequest.getLevelTwo());
        }
        if (StringUtil.isNotEmpty(infoRequest.getState())) {
            criteria.andStateEqualTo(infoRequest.getState());
        }
        if (StringUtil.isNotEmpty(infoRequest.getOrderByClause())) {
            example.setOrderByClause(infoRequest.getOrderByClause());
        }
        if (infoRequest.getLevelThree() != null) {
            criteria.andLevelThreeEqualTo(infoRequest.getLevelThree());
        }
        if (StringUtil.isNotEmpty(infoRequest.getIsChoose())) {
            criteria.andIsChooseEqualTo(infoRequest.getIsChoose());
        }
        if (StringUtil.isNotEmpty(infoRequest.getHasCoupon())) {
            criteria.andHasCouponEqualTo(infoRequest.getHasCoupon());
        }
        if (StringUtil.isNotEmpty(infoRequest.getGoodsName())) {
            criteria.andGoodsNameLike("%" + infoRequest.getGoodsName() + "%");
        }
        if (infoRequest.getId() != null) {
            criteria.andIdEqualTo(infoRequest.getId());
        }
        if (infoRequest.getMarkId() != null) {
            example.setMarkId(infoRequest.getMarkId());
        }

        example.setOffset(infoRequest.start4Mysql());
        example.setLimit(infoRequest.getRows());

        return example;
    }

    @Override
    public TPageResult<DuoduoGoodsInfoDTO> queryGoodsListInfo(DuoduoGoodsInfoRequest infoRequest) {
        ServiceAssert.notNull(infoRequest, Errors.Commons.REQUEST_PARAMETER_ERROR);
        DuoduoGoodsInfoExample example = new DuoduoGoodsInfoExample();

        DuoduoGoodsInfoExample.Criteria criteria = example.createCriteria();

        if (infoRequest.getLevelOne() != null) {
            criteria.andLevelOneEqualTo(infoRequest.getLevelOne());
        }
        if (infoRequest.getLevelTwo() != null) {
            criteria.andLevelTwoEqualTo(infoRequest.getLevelTwo());
        }
        if (StringUtil.isNotEmpty(infoRequest.getState())) {
            criteria.andStateEqualTo(infoRequest.getState());
        }
        if (StringUtil.isNotEmpty(infoRequest.getOrderByClause())) {
            example.setOrderByClause(infoRequest.getOrderByClause());
        }

        if (StringUtil.isNotEmpty(infoRequest.getIsChoose())) {
            criteria.andIsChooseEqualTo(infoRequest.getIsChoose());
        }

        example.setOffset(infoRequest.start4Mysql());
        example.setLimit(infoRequest.getRows());

        List<DuoGoodsInfo> duoGoodsInfos = duoGoodsInfoRepository
                .selectListByExample(example);
        long totalCount = duoGoodsInfoRepository.count(example);

        if (CollectionUtils.isEmpty(duoGoodsInfos)) {
            if (infoRequest.getIsChoose().equals(GoodsChooseEnum.NO.getCode())) {
                DuoduoGoodsInfoExample infoExample = new DuoduoGoodsInfoExample();
                long count = duoGoodsInfoRepository.count(infoExample);
                if (count <= 0) {
                    redisUtils.incr(RedisContent.DUODUO_GOODS_TABLE, 1);
                    updateTable();
                    JOB_GOODS_LOGGER.info("数据修改,原表无数据");
                }
            }
            return ResultBuilder.succTPage(Lists.newArrayList(), infoRequest.getPage(),
                    infoRequest.getRows(), 0);
        }

        List<DuoduoGoodsInfoDTO> collect = convertModel(duoGoodsInfos);

        return ResultBuilder.succTPage(collect, infoRequest.getPage(), infoRequest.getRows(), (int) totalCount);
    }

    @Override
    public BaseResult updateGoodsInfo(DuoduoGoodsInfoRequest infoRequest) {
        ServiceAssert.notNull(infoRequest, Errors.Commons.REQUEST_PARAMETER_ERROR);
        DuoGoodsInfo duoGoodsInfo = new DuoGoodsInfo();
        BeanUtils.copyProperties(infoRequest, duoGoodsInfo);
        int i = duoGoodsInfoRepository.updateByPrimaryKeySelective(duoGoodsInfo);
        return i > 0 ? ResultBuilder.succ() : ResultBuilder.fail(1001, "商品更新失败");
    }

    @Override
    public BaseResult insertGoodsInfo(DuoduoGoodsInfoRequest infoRequest) {
        ServiceAssert.notNull(infoRequest, Errors.Commons.REQUEST_PARAMETER_ERROR);

        //拉起多多商品详情
        DuoGoodsInfo duoGoodsInfo = duoduoGoodsManager
                .getDuoduoGoodDetail(infoRequest.getGoodsId());

        //赋值
        convertGoodsInfo(duoGoodsInfo, infoRequest);

        //默认时间数据
        duoGoodsInfo.setGmtCreate(Calendar.getInstance().getTime());
        duoGoodsInfo.setGmtModified(Calendar.getInstance().getTime());
        duoGoodsInfo.setDetailUpdate(Calendar.getInstance().getTime());

        long i = duoGoodsInfoRepository.insert(duoGoodsInfo);
        return i > 0 ? ResultBuilder.succ() : ResultBuilder.fail(1001, "商品插入失败");
    }


    /**
     * 查询商品id
     *
     * @param goodsId
     * @return
     */
    @Override
    public TSingleResult<Long> queryIdByGoodsId(Long goodsId) {

        DuoGoodsInfo goodsInfo = duoGoodsInfoRepository.selectByGoodsId(goodsId);
        if (goodsInfo != null) {
            return ResultBuilder.succTSingle(goodsInfo.getId().longValue());
        }

        return ResultBuilder.succTSingle(null);
    }

    /**
     * 更新拼多多商品
     *
     * @param
     * @return
     */
    @Override
    public TSingleResult<Boolean> updateGoodsFromPDD(Long goodsId) {
        DuoGoodsInfo duoGoodsInfo = duoGoodsInfoRepository
                .selectByGoodsId(goodsId);
        duoduoGoodsManager.updateDuoduoGoodDetail(duoGoodsInfo);
        return ResultBuilder.succTSingle(true);
    }

    @Override
    public BaseResult updateGoodsState(DuoduoGoodsInfoUpdateRequest infoRequest) {
        int i = duoGoodsInfoRepository.updateGoodsState(infoRequest);
        return i > 0 ? ResultBuilder.succ() : ResultBuilder.fail(1001, "商品状态更新失败");
    }

    /**
     * 商品数据转换
     *
     * @param temInfoVO
     * @param infoVO
     */
    private void convertGoodsInfo(DuoGoodsInfo temInfoVO, DuoduoGoodsInfoRequest infoVO) {
        //修改的值
        if (infoVO.getGoodsName() != null) {
            temInfoVO.setGoodsName(infoVO.getGoodsName());
        }
        if (infoVO.getGoodsImageUrl() != null) {
            temInfoVO.setGoodsImageUrl(infoVO.getGoodsImageUrl());
        }
        if (infoVO.getGoodsDesc() != null) {
            temInfoVO.setGoodsDesc(infoVO.getGoodsDesc());
        }
        if (infoVO.getCouponEndTime() != null) {
            temInfoVO.setCouponEndTime(infoVO.getCouponEndTime());
        }
        if (infoVO.getCouponStartTime() != null) {
            temInfoVO.setCouponStartTime(infoVO.getCouponStartTime());
        }
        if (infoVO.getState() != null) {
            temInfoVO.setState(infoVO.getState());
        }
        if (infoVO.getMinGroupPrice() != null) {
            temInfoVO.setMinGroupPrice(infoVO.getMinGroupPrice());
        }
        if (infoVO.getMinNormalPrice() != null) {
            temInfoVO.setMinNormalPrice(infoVO.getMinNormalPrice());
        }
        if (infoVO.getSort() != null) {
            temInfoVO.setSort(infoVO.getSort());
        }
        if (infoVO.getChooseSort() != null) {
            temInfoVO.setChooseSort(infoVO.getChooseSort());
        }
        if (infoVO.getIsChoose() != null) {
            temInfoVO.setIsChoose(infoVO.getIsChoose());
        }
    }

    /**
     * 批量更新数据
     *
     * @param
     * @return
     */
    @Override
    public BaseResult updateGoods() {
        boolean b = duoduoGoodsManager.saveOrUpdateDuoduoGoods();
        return b ? ResultBuilder.succ() : ResultBuilder.fail(1001, "商品批量更新失败");
    }


    @Override
    public TPageResult<DuoduoGoodsInfoDTO> queryChannelGoods(GoodsInfoRecommendRequest infoRequest) {
        ServiceAssert.notNull(infoRequest, Errors.Commons.REQUEST_PARAMETER_ERROR);
        List<DuoGoodsInfo> infoList = duoduoGoodsManager.queryChannelGoods(infoRequest);
        if (CollectionUtils.isEmpty(infoList)) {
            return ResultBuilder.succTPage(Lists.newArrayList(), infoRequest.getPage(),
                    infoRequest.getRows(), 0);
        }

        List<DuoduoGoodsInfoDTO> collect = infoList.stream().map(i -> {
            if (i.getGoodsId() == null) {
                DuoduoGoodsInfoDTO response = new DuoduoGoodsInfoDTO();
                BeanUtils.copyProperties(i, response);
                return response;
            } else {
                DuoduoGoodsInfoDTO response = new DuoduoGoodsInfoDTO();
                BeanUtils.copyProperties(i, response);
                response.setHasCoupon(Boolean.parseBoolean(i.getHasCoupon()));
                return response;
            }
        }).collect(Collectors.toList());

        return ResultBuilder.succTPage(collect, infoRequest.getPage(), infoRequest.getRows(), 0);

    }

    @Override
    public BaseResult saveGoods() {
        boolean b = duoduoGoodsManager.saveDuoduoGoods();
        return b ? ResultBuilder.succ() : ResultBuilder.fail(1001, "商品批量更新失败");
    }

    @Override
    public BaseResult checkGoods(DuoduoGoodsCheckRequest request) {
        boolean b = duoduoGoodsManager.checkDuoduoGoods(request);
        return b ? ResultBuilder.succ() : ResultBuilder.fail(1001, "商品check失败");
    }

    @Override
    public BaseResult deleteAll() {
        int i = duoGoodsInfoRepository.deleteAll();
        return i > 0 ? ResultBuilder.succ() : ResultBuilder.fail(1001, "商品批量更新失败");
    }

    @Override
    public TSingleResult<GoodsSearchResponse> searchGoods(GoodsSearchRequest request) {

        GoodsSearchResponse response = duoduoGoodsManager.duoduoGoodsSearch(request.getPage(),
                request.getRows(), request.getTotalPage(), request, request.getIsChoose());
        return ResultBuilder.succTSingle(response);
    }

    @Override
    public List<DuoduoGoodsInfoDTO> getList(GetStoreGoodsRequest getStoreGoodsRequest) {
        if (getStoreGoodsRequest.getGoodsIds().size() > 0) {
            DuoduoGoodsInfoExample goodsInfoExample = new DuoduoGoodsInfoExample();
            goodsInfoExample.createCriteria().andGoodsIdIn(getStoreGoodsRequest.getGoodsIds());
            List<DuoGoodsInfo> list = duoGoodsInfoRepository
                    .selectByExample(goodsInfoExample);
            List<DuoduoGoodsInfoDTO> arrayList = convertModel(list);
            return arrayList;
        } else {
            return new ArrayList<>();
        }
    }

    @Override
    public BaseResult deleteOldAutoChoice(Date endUpdate) {

        duoGoodsInfoRepository.deleteOldChoice(endUpdate);

        return ResultBuilder.succ();
    }
}
