package com.fulihui.duoduoke.demo.producer.manager;

import com.fulihui.duoduoke.demo.api.request.GoodsCheckRequest;
import com.fulihui.duoduoke.demo.api.request.GetDuoduoGoodsListRequest;
import com.fulihui.duoduoke.demo.api.request.GoodsInfoRecommendRequest;
import com.fulihui.duoduoke.demo.api.request.GoodsSearchRequest;
import com.fulihui.duoduoke.demo.api.response.GoodsSearchResponse;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.DuoGoodsInfo;
import com.fulihui.duoduoke.demo.web.weixin.duoapi.request.DuoGoodsRequest;
import com.fulihui.duoduoke.demo.web.weixin.duoapi.result.DuoGoodsResult;
import org.near.servicesupport.result.TPageResult;

import java.util.Date;
import java.util.List;


/**
 *
 * @author lizhi
 * @date 2018/7/7 0007
 */
public interface GoodsManager {

    /**
     * 保存更新拼的多多接口商品
     *
     * @return
     */
    boolean saveOrUpdateGoods();


    /**
     * 保存拼的多多接口商品
     *
     * @return
     */
    boolean saveGoods();

    /**
     * 更新拼多多商品详情
     *
     * @param info
     * @return
     */
    DuoGoodsInfo updateGoodDetail(DuoGoodsInfo info);

    /**
     * 查询多多商品详情
     *
     * @param goodsId
     * @return
     */
    DuoGoodsInfo getGoodDetail(Long goodsId);


    void updateGoods(List<DuoGoodsInfo> result, Date saveDate, Integer saveDay);

    /**
     * check商品
     *
     * @return
     */
    boolean checkGoods(GoodsCheckRequest request);


    void checkGoods(List<DuoGoodsInfo> duoGoodsInfos);


    List<DuoGoodsInfo> queryChannelGoods(GoodsInfoRecommendRequest infoRequest);

    /**
     * 查询多多客商品
     *
     * @param getDuoduoGoodsListRequest
     * @return
     */
    TPageResult<DuoGoodsInfo> queryGoods(GetDuoduoGoodsListRequest getDuoduoGoodsListRequest);

    DuoGoodsResult duoduoGoodsRequest(Integer page, Integer pageSize, DuoGoodsRequest request);

    GoodsSearchResponse duoduoGoodsSearch(Integer page, Integer rows, Integer totalMaxPage, GoodsSearchRequest request, String isChoose);

}
