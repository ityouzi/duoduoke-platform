package com.fulihui.duoduoke.demo.producer.manager.impl;

import com.fulihui.duoduoke.demo.api.request.DuoduoGoodsCheckRequest;
import com.fulihui.duoduoke.demo.api.request.GetDuoduoGoodsListRequest;
import com.fulihui.duoduoke.demo.api.request.GoodsInfoRecommendRequest;
import com.fulihui.duoduoke.demo.api.request.GoodsSearchRequest;
import com.fulihui.duoduoke.demo.api.response.GoodsSearchResponse;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.DuoGoodsInfo;
import com.fulihui.duoduoke.demo.producer.manager.GoodsManager;
import com.fulihui.duoduoke.demo.web.weixin.duoapi.request.DuoGoodsRequest;
import com.fulihui.duoduoke.demo.web.weixin.duoapi.result.DuoGoodsResult;
import org.near.servicesupport.result.TPageResult;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class GoodsManagerImpl implements GoodsManager {
    /**
     * 保存更新拼的多多接口商品
     *
     * @return
     */
    @Override
    public boolean saveOrUpdateGoods() {
        return false;
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
     * 更新拼多多商品详情
     *
     * @param info
     * @return
     */
    @Override
    public DuoGoodsInfo updateGoodDetail(DuoGoodsInfo info) {
        return null;
    }

    /**
     * 查询多多商品详情
     *
     * @param goodsId
     * @return
     */
    @Override
    public DuoGoodsInfo getGoodDetail(Long goodsId) {
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
    public boolean checkDuoduoGoods(DuoduoGoodsCheckRequest request) {
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
