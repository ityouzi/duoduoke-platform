package com.fulihui.duoduoke.demo.producer.manager.impl;

import com.fulihui.duoduoke.demo.api.enums.GoodsChooseEnum;
import com.fulihui.duoduoke.demo.api.enums.GoodsStateEnum;
import com.fulihui.duoduoke.demo.api.request.GetDuoduoGoodsListRequest;
import com.fulihui.duoduoke.demo.api.request.GoodsCheckRequest;
import com.fulihui.duoduoke.demo.api.request.GoodsInfoRecommendRequest;
import com.fulihui.duoduoke.demo.api.request.GoodsSearchRequest;
import com.fulihui.duoduoke.demo.api.response.GoodsSearchResponse;
import com.fulihui.duoduoke.demo.common.config.DuoDuoKeConfig;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.DuoGoodsInfo;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.GoodsInfo;
import com.fulihui.duoduoke.demo.producer.manager.GoodsManager;
import com.fulihui.duoduoke.demo.producer.repository.GoodsInfoRepository;
import com.fulihui.duoduoke.demo.producer.util.DateTimestampUtil;
import com.fulihui.duoduoke.demo.web.weixin.duoapi.DuoHttpClient;
import com.fulihui.duoduoke.demo.web.weixin.duoapi.request.DuoGoodsDetailRequest;
import com.fulihui.duoduoke.demo.web.weixin.duoapi.request.DuoGoodsRequest;
import com.fulihui.duoduoke.demo.web.weixin.duoapi.result.DuoGoodsDetailResult;
import com.fulihui.duoduoke.demo.web.weixin.duoapi.result.DuoGoodsResult;
import com.fulihui.duoduoke.demo.web.weixin.duoapi.result.DuoGoodsSearchResult;
import org.near.servicesupport.result.TPageResult;
import org.near.toolkit.common.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

import static com.fulihui.duoduoke.demo.producer.util.ClassFieldsUtil.obj2StrVal;
import static com.fulihui.duoduoke.demo.producer.util.ClassFieldsUtil.obj2StrValMap;
import static com.fulihui.duoduoke.demo.producer.util.SignUtil.genServiceSign;

@Component
public class GoodsManagerImpl implements GoodsManager {
    @Autowired
    DuoDuoKeConfig duoDuoKeConfig;

    @Autowired
    GoodsInfoRepository goodsInfoRepository;

    @Autowired
    DuoHttpClient duoHttpClient;

    /**
     * 保存更新拼的多多接口商品
     *
     * @param item
     * @return boolean
     */
    @Override
    public void saveGoods(DuoGoodsSearchResult.GoodsSearchResponseBean.GoodsListBean item) {
        if (StringUtil.isNotBlank(item.getGoodsImageUrl())) {
            GoodsInfo goodsInfo = goodsInfoRepository.selectByGoodsId(item.getGoodsId());
            if (goodsInfo == null) {
                GoodsInfo info = new GoodsInfo();
                build(item, info);
                goodsInfoRepository.insert(info);
            }
        }
    }

    private void build(DuoGoodsSearchResult.GoodsSearchResponseBean.GoodsListBean item, GoodsInfo info) {
        info.setGoodsDesc(item.getGoodsDesc());
        info.setGoodsGalleryUrls(item.getGoodsGalleryUrls());
        info.setGoodsId(item.getGoodsId());
        info.setGoodsName(item.getGoodsName());
        info.setGoodsDesc(item.getGoodsDesc());
        info.setGoodsThumbnailUrl(item.getGoodsThumbnailUrl());
        info.setGoodsImageUrl(item.getGoodsImageUrl());
        info.setSoldQuantity(item.getSoldQuantity());
        info.setMallName(item.getMallName());
        info.setMinNormalPrice(item.getMinNormalPrice());
        info.setMinGroupPrice(item.getMinGroupPrice());
        info.setOptName(item.getGoodsName());
        info.setOptId(item.getCatId());
        info.setCatIds(item.getCategoryId().toString());
        info.setHasCoupon(String.valueOf(item.isHasCoupon()));
        info.setGoodsEvalCount(item.getGoodsEvalCount());
        if (item.getGoodsEvalScore() != null) {
            info.setGoodsEvalScore(item.getGoodsEvalScore().toString());
        }
        info.setPromotionRate(item.getPromotionRate());
        info.setCouponEndTime(DateTimestampUtil.unixToDate(item.getCouponEndTime(), ""));
        info.setCouponStartTime(DateTimestampUtil.unixToDate(item.getCouponStartTime(), ""));
        info.setCouponRemainQuantity(item.getCouponRemainQuantity());
        info.setCouponTotalQuantity(item.getCouponTotalQuantity());
        info.setCouponDiscount(item.getCouponDiscount());
        info.setCouponMinOrderAmount(item.getCouponMinOrderAmount());


        info.setDetailUpdate(new Date());
        info.setSort(8);
        info.setIsChoose(GoodsChooseEnum.IS.getCode());
        info.setChooseSort(0);

        info.setState(GoodsStateEnum.ON.getCode());
    }


    /**
     * 保存拼的多多接口商品
     *
     * @return
     */
    @Override
    public boolean saveGoods() {
        return false;
    }


    /**
     * 查询多多商品详情
     *
     * @param goodsId
     * @return
     */
    @Override
    public GoodsInfo getGoodDetail(String goodsId) {
        DuoGoodsDetailRequest request = new DuoGoodsDetailRequest();
        request.setType("pdd.ddk.goods.detail");
        request.setClient_id(duoDuoKeConfig.getClientId());
        request.setTimestamp(String.valueOf(System.currentTimeMillis()));
        request.setGoods_id_list("[" + goodsId + "]");
        Map<String, Object> map = obj2StrValMap(request);
        String sign = genServiceSign(obj2StrVal(request), map, duoDuoKeConfig.getClientSecret());
        request.setSign(sign);
        DuoGoodsDetailResult detailResult = duoHttpClient.invokeService(request);
        if (detailResult.isSuccess()) {


        }

        return null;

    }

    @Override
    public void updateGoods(List<DuoGoodsInfo> result, Date saveDate, Integer saveDay) {

    }

    /**
     * check商品
     *
     * @param request
     * @return
     */
    @Override
    public boolean checkGoods(GoodsCheckRequest request) {
        return false;
    }

    @Override
    public void checkGoods(List<DuoGoodsInfo> duoGoodsInfos) {

    }

    @Override
    public List<DuoGoodsInfo> queryChannelGoods(GoodsInfoRecommendRequest infoRequest) {
        return null;
    }

    /**
     * 查询多多客商品
     *
     * @param getDuoduoGoodsListRequest
     * @return
     */
    @Override
    public TPageResult<DuoGoodsInfo> queryGoods(GetDuoduoGoodsListRequest getDuoduoGoodsListRequest) {
        return null;
    }

    @Override
    public DuoGoodsResult duoduoGoodsRequest(Integer page, Integer pageSize, DuoGoodsRequest request) {
        return null;
    }

    @Override
    public GoodsSearchResponse duoduoGoodsSearch(Integer page, Integer rows, Integer totalMaxPage, GoodsSearchRequest request, String isChoose) {
        return null;
    }
}
