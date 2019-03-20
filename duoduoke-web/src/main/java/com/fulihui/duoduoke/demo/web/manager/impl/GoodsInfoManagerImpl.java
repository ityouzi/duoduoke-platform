package com.fulihui.duoduoke.demo.web.manager.impl;

import com.fulihui.duoduoke.demo.api.api.GoodsInfoService;
import com.fulihui.duoduoke.demo.api.api.MarkService;
import com.fulihui.duoduoke.demo.api.dto.GoodsInfoDTO;
import com.fulihui.duoduoke.demo.api.dto.GoodsDoublesRewardDTO;
import com.fulihui.duoduoke.demo.api.dto.GoodsMarkDTO;
import com.fulihui.duoduoke.demo.api.enums.RedPackageConfigStatusEnum;
import com.fulihui.duoduoke.demo.api.request.GetDuoduoGoodsListRequest;
import com.fulihui.duoduoke.demo.api.request.GoodsMarkRequest;
import com.fulihui.duoduoke.demo.web.factory.AppConfigFactory;
import com.fulihui.duoduoke.demo.web.manager.GoodsInfoManager;
import com.fulihui.duoduoke.demo.web.vo.GoodsInfo;
import org.near.servicesupport.result.TPageResult;
import org.near.servicesupport.result.TSingleResult;
import org.near.servicesupport.util.ServiceResultUtil;
import org.near.toolkit.common.DateUtils;
import org.near.toolkit.common.StringUtil;
import org.near.toolkit.model.Money;
import org.near.webmvcsupport.view.PageForm;
import org.near.webmvcsupport.view.PageView;
import org.near.webmvcsupport.view.PageViewBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.util.CollectionUtils.isEmpty;

/**
 * @author lizhi
 * @date 2018-9-10
 */
@Service
public class GoodsInfoManagerImpl implements GoodsInfoManager {
    @Autowired
    AppConfigFactory appConfigFactory;

    @org.apache.dubbo.config.annotation.Reference
    MarkService markService;


    @org.apache.dubbo.config.annotation.Reference
    GoodsInfoService goodsInfoService;

    private static final Logger logger = LoggerFactory
            .getLogger(GoodsInfoManagerImpl.class);

    @Override
    public List<GoodsInfo> toVOList(List<GoodsInfoDTO> list) {
        //返利佣金配置百分比
        Integer commission = appConfigFactory.getCommission().intValue();
        //分享配置百分比
        Integer shareProportion = appConfigFactory.getShareProportion().intValue();

        List<GoodsInfo> goodsList = new ArrayList<>();
        BigDecimal yuanBig = new BigDecimal(100);
        if (!isEmpty(list)) {
            goodsList = list.stream().map(i -> toVO(i, yuanBig, commission, shareProportion))
                    .collect(Collectors.toList());
        }
        return goodsList;
    }

    /**
     * 热推爆品商品列表
     *
     * @param pageForm
     * @return
     */
    @Override
    public PageView<GoodsInfo> hotPushGoods(PageForm pageForm) {
        GetDuoduoGoodsListRequest listRequest = new GetDuoduoGoodsListRequest();
        listRequest.setPage(pageForm.getPage() + 2);
        listRequest.setPageSize(pageForm.getRows());
        //默认综合排序
        listRequest.setSortType(0);
        listRequest.setHasCoupon(true);

        TPageResult<GoodsInfoDTO> result = goodsInfoService.searchCouponGoods(listRequest);

        List<GoodsInfo> list = null;

        if (result != null && result.getValues() != null && result.getValues().size() > 0) {
            list = toVOList(result.getValues());
            //接口返回数据不足请求条数 补充总条数
            if (list.size() < pageForm.getRows() && result.getTotalPage() > (pageForm.getRows() * pageForm.getPage())) {
                for (int i = list.size(); i < pageForm.getRows(); i++) {
                    list.add(new GoodsInfo());
                }
            }
        }

        return PageViewBuilder.build(list, result.getPage(), result.getRows(), result.getTotalRows());
    }

    @Override
    public GoodsInfo toVO(GoodsInfoDTO dto, BigDecimal yuanBig, Integer commission,
                          Integer shareProportion) {
        if (dto == null || dto.getGoodsId() == null) {
            return null;
        }
        GoodsInfo info = new GoodsInfo();
        BeanUtils.copyProperties(dto, info);
        //拼团价格
        Integer minGroupPrice = dto.getMinGroupPrice();
        //佣金比例
        Integer promotionRate = dto.getPromotionRate();
        if (Boolean.parseBoolean(dto.getHasCoupon())) {
            //优惠券价格
            Integer couponDiscount = dto.getCouponDiscount();
            build(couponDiscount, minGroupPrice, promotionRate, info, commission, dto.getGoodsId());
            info.setCouponDiscount(new BigDecimal(couponDiscount).divide(yuanBig).toString());
            info.setCouponStartTime(DateUtils.format(dto.getCouponStartTime(), "yyyy.MM.dd"));
            info.setCouponEndTime(DateUtils.format(dto.getCouponEndTime(), "yyyy.MM.dd"));
        } else {
            build(0, minGroupPrice, promotionRate, info, commission, dto.getGoodsId());
        }
        String goodsGalleryUrls = dto.getGoodsGalleryUrls();
        if (StringUtil.isNotEmpty(goodsGalleryUrls)) {
            String substring = goodsGalleryUrls.substring(1, goodsGalleryUrls.length() - 1)
                    .replace("\"", "");
            info.setGoodsGalleryUrls(substring.split(","));
        }

        GoodsMarkDTO goodsMarkDTO = queryGoodsMark(dto.getGoodsId());
        if (goodsMarkDTO != null) {
            info.setMarkUrl(goodsMarkDTO.getMarkUrl());
        }
        info.setNowTime(System.currentTimeMillis());
        return info;

    }

    /**
     * @param couponDiscount 优惠券价格
     * @param minGroupPrice  拼团价格
     * @param promotionRate  佣金比例
     * @param vo
     * @param commission     返利佣金配置百分比
     * @param goodsId
     */
    private void build(Integer couponDiscount, Integer minGroupPrice, Integer promotionRate,
                       GoodsInfo vo, int commission, String goodsId) {
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
        long platAmount = salePriceMoney.getCent() * promotionRate;
        long amount = platAmount * commission;

        //拼多多佣金比例是千分比，我们设置的佣金比例是百分比
        long awardPrice = amount / 1000 / 100;

        Money awardPriceMoney = new Money();
        awardPriceMoney.setCent(awardPrice);
        //todo 2018-09-19 修改奖励金额 = 基础金额(原奖励金额) + 加倍金额
        vo.setAwardPrice(awardPriceMoney.toString());
        vo.setBasicsPrice(awardPriceMoney.toString());

        vo.setSharePrice(awardPriceMoney.toString());

        GoodsDoublesRewardDTO goodsDoublesRewardDTO = queryDoubleReward(goodsId);
        Integer integer = queryDoubleRewardList(goodsId);
        if (goodsDoublesRewardDTO != null) {
            vo.setActivityStopTime(goodsDoublesRewardDTO.getActivityStopTime().getTime());
            vo.setDoubleStopTime(goodsDoublesRewardDTO.getStopTime().getTime());
            Date stopTime = goodsDoublesRewardDTO.getStopTime();
            Date date = new Date();
            if (stopTime.getTime() < date.getTime()) {
                vo.setDoubleState(RedPackageConfigStatusEnum.OFF.getCode());
            } else {
                vo.setDoubleState(RedPackageConfigStatusEnum.ON.getCode());
                //奖励翻倍金额
                BigDecimal doubleAward = new BigDecimal(platAmount).multiply(new BigDecimal(Float.toString(
                        goodsDoublesRewardDTO.getRewardPercent()))).divide(new BigDecimal(10000000), 2, BigDecimal.ROUND_DOWN);
                vo.setDoublePrice(doubleAward.toString());
                BigDecimal totalMoney = awardPriceMoney.getAmount().add(doubleAward);
                vo.setAwardPrice(totalMoney.toString());
            }
            vo.setIsActivity("0");

        } else {
            if (integer > 0) {
                vo.setIsActivity("0");
            }
        }

    }


    public GoodsMarkDTO queryGoodsMark(String goodsId) {
        try {
            GoodsMarkRequest request = new GoodsMarkRequest();
            request.setGoodsId(goodsId);
            Date date = new Date();
            request.setStartTimeLessThanOrEqualTo(date);
            request.setStopTimeGreaterThanOrEqualTo(date);
            TSingleResult<GoodsMarkDTO> result = markService.queryGoodsMarkSingle(request);
            ServiceResultUtil.checkResult(result);
            return result.getValue();
        } catch (Exception e) {
            logger.error("查询角标错误", e);
        }
        return null;

    }

    public GoodsDoublesRewardDTO queryDoubleReward(String goodsId) {

        return null;
    }


    public Integer queryDoubleRewardList(String goodsId) {

        return 0;
    }


}
