package com.fulihui.redisdubbo.demo.controller;


import com.fulihui.redisdubbo.demo.api.api.GoodsCatInfoService;
import com.fulihui.redisdubbo.demo.api.api.GoodsInfoService;
import com.fulihui.redisdubbo.demo.api.dto.GoodsCatInfoDTO;
import com.fulihui.redisdubbo.demo.api.dto.GoodsCatInfoTreeNodeDTO;
import com.fulihui.redisdubbo.demo.api.enums.DuoDuoGoodsLevelEnum;
import com.fulihui.redisdubbo.demo.api.enums.GoodsCatInfoStatusEnum;
import com.fulihui.redisdubbo.demo.api.request.GoodSearchRecordRequest;
import com.fulihui.redisdubbo.demo.api.request.GoodsCatInfoRequest;
import com.fulihui.redisdubbo.demo.api.request.GoodsSearchInfoRangeRequest;
import com.fulihui.redisdubbo.demo.api.request.GoodsSearchInfoRequest;
import com.fulihui.redisdubbo.demo.api.response.GoodsSearchInfoResponse;
import com.fulihui.redisdubbo.demo.factory.AppConfigFactory;
import com.fulihui.redisdubbo.demo.manager.WeChatManager;
import com.fulihui.redisdubbo.demo.param.GoodCatParam;
import com.fulihui.redisdubbo.demo.param.GoodSearchParam;
import com.fulihui.redisdubbo.demo.util.Principal;
import com.fulihui.redisdubbo.demo.util.PrincipalUtil;
import com.fulihui.redisdubbo.demo.vo.GoodsCatInfoVO;
import com.fulihui.redisdubbo.demo.vo.GoodsCatTreeVO;
import com.fulihui.redisdubbo.demo.vo.GoodsSearchInfoVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.near.servicesupport.result.TMultiResult;
import org.near.servicesupport.result.TPageResult;
import org.near.toolkit.common.DateUtils;
import org.near.toolkit.common.StringUtil;
import org.near.toolkit.model.Money;
import org.near.webmvcsupport.view.JsonResult;
import org.near.webmvcsupport.view.JsonResultBuilder;
import org.near.webmvcsupport.view.PageView;
import org.near.webmvcsupport.view.PageViewBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.*;
import java.util.stream.Collectors;

import static com.google.common.collect.Lists.newArrayList;
import static org.near.servicesupport.util.ServiceResultUtil.checkResult;
import static org.near.webmvcsupport.view.JsonResultBuilder.succ;

/**
 * @author lizhi
 * @date 2018-7-7
 */
@RestController
@RequestMapping("/goodsCatInfo")
@Api(description = "小程序商品类目")
public class GoodsCatInfoController {
    @Autowired
    PrincipalUtil principalUtil;

    private static final Logger LOGGER = LoggerFactory.getLogger(GoodsCatInfoController.class);

    @Autowired
    WeChatManager wechatManager;

    @org.apache.dubbo.config.annotation.Reference
    GoodsCatInfoService goodsCatInfoService;

    @org.apache.dubbo.config.annotation.Reference
    GoodsInfoService goodsInfoService;

    @Autowired
    AppConfigFactory appConfigFactory;

    private PageView<GoodsCatInfoVO> build;

    public PageView<GoodsCatInfoVO> getBuild() {
        if (build != null) {
            return build;
        }
        return parentInfo();
    }

    /**
     * zpf 增加缓存 2018-8-27
     */
     @PostMapping("goodsCatInfo")
    @ApiOperation("多多小程序类目接口")
    public JsonResult<PageView> goodsCatInfo(@RequestBody GoodCatParam param) {
        LOGGER.info("进入controller查询数据 多多小程序类目接口");
        GoodsCatInfoRequest infoRequest = new GoodsCatInfoRequest();
        if (param != null && param.getCatId() != null) {
            infoRequest.setParentCatId(param.getCatId());
            PageView<GoodsCatInfoVO> build = getGoodsCatInfoVOPageView(infoRequest);
            return succ(build);
        }

        PageView<GoodsCatInfoVO> build = getBuild();
        return succ(build);
    }

    @PostConstruct
    @Scheduled(cron = "*/60 * * * * *")
    PageView<GoodsCatInfoVO> parentInfo() {
        GoodsCatInfoRequest infoRequest = new GoodsCatInfoRequest();
        infoRequest.setParentCatId(0);
        try {

        } catch (Exception e) {
            build = getGoodsCatInfoVOPageView(infoRequest);
        }
        return build;
    }

    private PageView<GoodsCatInfoVO> getGoodsCatInfoVOPageView(GoodsCatInfoRequest infoRequest) {
        infoRequest.setStatus(GoodsCatInfoStatusEnum.IS.getCode());
        infoRequest.setPage(1);
        infoRequest.setRows(Integer.MAX_VALUE);
        TPageResult<GoodsCatInfoTreeNodeDTO> result = goodsCatInfoService.queryTree(infoRequest);
        checkResult(result);

        List<GoodsCatInfoVO> values = result.getValues().stream().map(item -> {
            GoodsCatInfoVO catInfoVO = new GoodsCatInfoVO();
            BeanUtils.copyProperties(item, catInfoVO);
            return catInfoVO;
        }).collect(Collectors.toList());
        return PageViewBuilder.build(values, result.getPage(), result.getRows(),
                result.getTotalRows(), result.getTotalPage());
    }

    /**
     * zpf 增加缓存 2018-8-27
     */
     @PostMapping("goodsCatTreeInfo")
    @ApiOperation("多多小程序查询分类树接口")
    public JsonResult goodsCatTreeInfo(Map map) {
        LOGGER.info("进入controller查询数据 多多小程序查询分类树接口");
        //一级类目
        GoodsCatInfoRequest infoRequest = new GoodsCatInfoRequest();
        infoRequest.setLevel(DuoDuoGoodsLevelEnum.ONE.getCode() + "");
        TMultiResult<GoodsCatInfoDTO> result = goodsCatInfoService.selectBylevel(infoRequest);
        //二级类目
        GoodsCatInfoRequest twoRequest = new GoodsCatInfoRequest();
        twoRequest.setLevel(DuoDuoGoodsLevelEnum.TWO.getCode() + "");
        TMultiResult<GoodsCatInfoDTO> twoResult = goodsCatInfoService.selectBylevel(twoRequest);
        checkResult(twoResult);
        List<GoodsCatInfoDTO> twoCats = twoResult.getValues();
        List<GoodsCatTreeVO> newArrayList = newArrayList();
        Map<Integer, List<GoodsCatTreeVO>> childrenMap = new HashMap<>();
        if (!CollectionUtils.isEmpty(twoCats)) {
            for (GoodsCatInfoDTO dto : twoCats) {
                GoodsCatTreeVO myTree = toVO(dto);
                Integer parentCatId = dto.getParentCatId();
                List<GoodsCatTreeVO> goodsCatTreeVOs = childrenMap.get(parentCatId);
                if (CollectionUtils.isEmpty(goodsCatTreeVOs)) {
                    List<GoodsCatTreeVO> myTrees = newArrayList(myTree);
                    childrenMap.put(parentCatId, myTrees);
                } else {
                    goodsCatTreeVOs.add(myTree);
                    childrenMap.put(parentCatId, goodsCatTreeVOs);
                }
            }
        }
        List<GoodsCatInfoDTO> oneLevelResult = result.getValues();
        if (!CollectionUtils.isEmpty(oneLevelResult)) {
            for (GoodsCatInfoDTO dto : oneLevelResult) {
                GoodsCatTreeVO myTree = toVO(dto);
                Integer catId = dto.getCatId();
                List<GoodsCatTreeVO> goodsCatTreeVOs = childrenMap.get(catId);
                myTree.setChildren(goodsCatTreeVOs);
                newArrayList.add(myTree);
            }
        }

        return JsonResultBuilder.succ(newArrayList);
    }

    public GoodsCatTreeVO toVO(GoodsCatInfoDTO dto) {
        GoodsCatTreeVO myTree = new GoodsCatTreeVO();
        myTree.setCatId(dto.getCatId());
        myTree.setParentCatId(dto.getParentCatId());
        myTree.setCatName(dto.getCatName());
        myTree.setLevel(dto.getLevel());
        myTree.setImg(dto.getImg());
        myTree.setIcon(dto.getIcon());
        return myTree;
    }

    @ApiOperation("多多小程序搜索")
    @PostMapping("search")
    public JsonResult<PageView<GoodsSearchInfoVO>> search(@RequestBody GoodSearchParam param,
                                                          HttpServletRequest servletRequest) {

        GoodsSearchInfoRequest infoRequest = new GoodsSearchInfoRequest();
        String keyword = param.getKeyword();
        if (StringUtil.isNotEmpty(keyword)) {
            infoRequest.setKeyword(keyword);
        }
        infoRequest.setRows(param.getRows());
        infoRequest.setPage(param.getPage());
        if (StringUtil.isEmpty(param.getSortType())) {
            infoRequest.setSort_type("0");
        } else {
            infoRequest.setSort_type(param.getSortType());
        }
        if (StringUtil.isNotEmpty(param.getRangeFrom())) {
            List<GoodsSearchInfoRangeRequest> rangeRequestList = new ArrayList<>();
            GoodsSearchInfoRangeRequest rangeRequest = new GoodsSearchInfoRangeRequest();
            Money overOrderMoney = new Money();
            overOrderMoney.setAmount(new BigDecimal(param.getRangeFrom()));
            rangeRequest.setRange_from((int) overOrderMoney.getCent());
            rangeRequest.setRange_to(20000);
            rangeRequest.setRange_id(1);
            rangeRequestList.add(rangeRequest);
            infoRequest.setRange_list(rangeRequestList);
        }
        infoRequest.setWith_coupon(Boolean.FALSE.toString());
        TPageResult<GoodsSearchInfoResponse> result = goodsInfoService.search(infoRequest);
        checkResult(result);
        try {
            boolean empty = !CollectionUtils.isEmpty(result.getValues());
            String status = empty ? "Y" : "N";
            GoodSearchRecordRequest recordRequest = convert(param, servletRequest, status);
            goodsInfoService.record(recordRequest);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        List<GoodsSearchInfoVO> collect = result.getValues().stream()
                .map(this::getGoodsSearchInfoVO).collect(Collectors.toList());
        PageView<GoodsSearchInfoVO> build = PageViewBuilder.build(collect, result.getPage(),
                result.getRows(), result.getTotalRows());
        return succ(build);

    }

    private GoodSearchRecordRequest convert(@RequestBody GoodSearchParam param,
                                            HttpServletRequest servletRequest, String status) {
        Principal principal = principalUtil.getPrincipal(servletRequest);
        GoodSearchRecordRequest recordRequest = new GoodSearchRecordRequest();
        recordRequest.setIsResult(status);
        recordRequest.setSearchContent(param.getKeyword());
        recordRequest.setUserId(principal.getUserId());
        recordRequest.setOpenId(principal.getOpenId());
        return recordRequest;
    }

    private GoodsSearchInfoVO getGoodsSearchInfoVO(GoodsSearchInfoResponse it) {
        GoodsSearchInfoVO vo = new GoodsSearchInfoVO();
        vo.setGoodsId(String.valueOf(it.getGoods_id()));
        vo.setGoodsName(it.getGoods_name());
        vo.setGoodsDesc(it.getGoods_desc());
        vo.setGoodsThumbnailUrl(it.getGoods_thumbnail_url());
        vo.setGoodsImageUrl(it.getGoods_image_url());
        vo.setGoodsGalleryUrls(it.getGoods_gallery_urls());
        vo.setSoldQuantity(String.valueOf(it.getSold_quantity()));
        vo.setMinNormalPrice(String.valueOf(it.getMin_normal_price()));
        vo.setMallName(it.getMall_name());
        vo.setCategoryId(String.valueOf(it.getCategory_id()));
        vo.setCategoryName(it.getCategory_name());
        vo.setHasCoupon(it.isHas_coupon());
        vo.setCouponMinOrderAmount(String.valueOf(it.getCoupon_min_order_amount()));

        //查询返佣比例配置
        int commission = appConfigFactory.getCommission().intValue();
        //查询分享佣金比例配置
        int shareProportion = appConfigFactory.getShareProportion().intValue();

        //如果有优惠券面额
        if (it.getCoupon_discount() != null && it.isHas_coupon()) {
            build(it.getCoupon_discount(), it.getMin_group_price(), it.getPromotion_rate(), vo,
                    commission, shareProportion);
        } else {
            //没有优惠
            build(0, it.getMin_group_price(), it.getPromotion_rate(), vo, commission,
                    shareProportion);
        }
        vo.setCouponTotalQuantity(String.valueOf(it.getCoupon_total_quantity()));
        vo.setCouponRemainQuantity(String.valueOf(it.getCoupon_remain_quantity()));
        vo.setCouponStartTime(String.valueOf(it.getCoupon_start_time()));
        vo.setCouponEndTime(String.valueOf(it.getCoupon_end_time()));
        vo.setPromotionPate(String.valueOf(it.getPromotion_rate()));
        vo.setGoodsEvalScore(String.valueOf(it.getGoods_eval_score()));
        vo.setGoodsEvalCount(String.valueOf(it.getGoods_eval_count()));
        vo.setCatId(String.valueOf(it.getCat_id()));
        vo.setAvgDesc(String.valueOf(it.getAvg_desc()));
        vo.setAvgLgst(String.valueOf(it.getAvg_lgst()));
        vo.setAvgServ(String.valueOf(it.getAvg_serv()));
        return vo;
    }

    private void build(Integer couponDiscount, Integer minGroupPrice, Integer promotionRate,
                       GoodsSearchInfoVO vo, int commission, int shareProportion) {
        Money couponDiscountMoney = new Money();
        couponDiscountMoney.setCent(couponDiscount);
        vo.setCouponDiscount(couponDiscountMoney.toString());
        //最小拼团价格
        Money minGroupPriceMoney = new Money();
        minGroupPriceMoney.setCent(minGroupPrice);
        vo.setMinGroupPrice(minGroupPriceMoney.getAmount().toString());
        //voucherPrice 券后价  =最小拼团价格 - 优惠券
        Money salePriceMoney = minGroupPriceMoney.subtract(couponDiscountMoney);
        vo.setSalePrice(salePriceMoney.toString());
        //返利给平台 的佣金比例
        long amount = salePriceMoney.getCent() * promotionRate * commission;

        long awardPrice = amount / 1000 / 100;

        Money awardPriceMoney = new Money();
        awardPriceMoney.setCent(awardPrice);
        vo.setAwardPrice(awardPriceMoney.toString());
        //分享赚
        long sharePrice = amount * shareProportion / 1000 / 100 / 100;

        Date now = new Date();
        if (now.after(getTime())) {
            sharePrice = awardPrice;
        }
        Money sharePriceMoney = new Money();
        sharePriceMoney.setCent(sharePrice);
        vo.setSharePrice(sharePriceMoney.toString());
    }

    Date getTime() {
        Date date = null;
        try {
            date = DateUtils.parseWebFormat("2018-09-01");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

}
