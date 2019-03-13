package com.fulihui.duoduoke.demo.producer.manager;

import com.fulihui.duoduoke.demo.api.request.DuoduoGoodsCheckRequest;
import com.fulihui.duoduoke.demo.api.request.GetDuoduoGoodsListRequest;
import com.fulihui.duoduoke.demo.api.request.GoodsInfoRecommendRequest;
import com.fulihui.duoduoke.demo.api.request.GoodsSearchRequest;
import com.fulihui.duoduoke.demo.api.response.GoodsSearchResponse;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.DuoduoGoodsInfo;
import com.fulihui.duoduoke.demo.web.weixin.duoduoapi.request.DuoduoGoodsRequest;
import com.fulihui.duoduoke.demo.web.weixin.duoduoapi.result.DuoduoGoodsResult;
import org.near.servicesupport.result.TPageResult;

import java.util.Date;
import java.util.List;


/**
 * Created by lizhi on 2018/7/7 0007.
 */
public interface DuoduoGoodsManager {

    /**
     * 保存更新拼的多多接口商品
     *
     * @return
     */
    boolean saveOrUpdateDuoduoGoods();


    /**
     * 保存拼的多多接口商品
     *
     * @return
     */
    boolean saveDuoduoGoods();

    /**
     * 更新拼多多商品详情
     *
     * @param info
     * @return
     */
    DuoduoGoodsInfo updateDuoduoGoodDetail(DuoduoGoodsInfo info);

    /**
     * 查询多多商品详情
     *
     * @param goodsId
     * @return
     */
    DuoduoGoodsInfo getDuoduoGoodDetail(Long goodsId);


    void updateGoods(List<DuoduoGoodsInfo> result, Date saveDate, Integer saveDay);

    /**
     * check商品
     *
     * @return
     */
    boolean checkDuoduoGoods(DuoduoGoodsCheckRequest request);


    void checkGoods(List<DuoduoGoodsInfo> duoduoGoodsInfos);


    List<DuoduoGoodsInfo> queryChannelGoods(GoodsInfoRecommendRequest infoRequest);

    /**
     * 查询多多客商品
     *
     * @param getDuoduoGoodsListRequest
     * @return
     */
    TPageResult<DuoduoGoodsInfo> queryGoods(GetDuoduoGoodsListRequest getDuoduoGoodsListRequest);

    DuoduoGoodsResult duoduoGoodsRequest(Integer page, Integer pageSize, DuoduoGoodsRequest request);

    GoodsSearchResponse duoduoGoodsSearch(Integer page, Integer rows, Integer totalMaxPage, GoodsSearchRequest request, String isChoose);

}
