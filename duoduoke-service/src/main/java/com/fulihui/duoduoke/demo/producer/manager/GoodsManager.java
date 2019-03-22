package com.fulihui.duoduoke.demo.producer.manager;

import com.fulihui.duoduoke.demo.api.request.GetDuoduoGoodsListRequest;
import com.fulihui.duoduoke.demo.api.request.GoodsCheckRequest;
import com.fulihui.duoduoke.demo.api.request.GoodsInfoRecommendRequest;
import com.fulihui.duoduoke.demo.api.request.GoodsSearchRequest;
import com.fulihui.duoduoke.demo.api.response.GoodsSearchResponse;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.DuoGoodsInfo;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.GoodsInfo;
import com.fulihui.duoduoke.demo.web.weixin.duoapi.request.DuoGoodsRequest;
import com.fulihui.duoduoke.demo.web.weixin.duoapi.result.DuoGoodsResult;
import com.fulihui.duoduoke.demo.web.weixin.duoapi.result.DuoGoodsSearchResult;
import org.near.servicesupport.result.TPageResult;

import java.util.Date;
import java.util.List;


/**
 * The interface Goods manager.
 *
 * @author lizhi
 * @date 2018 /7/7 0007
 */
public interface GoodsManager {

    /**
     * 保存更新拼的多多接口商品
     *
     * @return boolean
     */
    void saveGoods(DuoGoodsSearchResult.GoodsSearchResponseBean.GoodsListBean item);


    /**
     * 保存拼的多多接口商品
     *
     * @return boolean
     */
    boolean saveGoods();


    /**
     * 查询多多商品详情
     *
     * @param goodsId the goods id
     * @return good detail
     */
    GoodsInfo getGoodDetail(String goodsId);


    /**
     * Update goods.
     *
     * @param result   the result
     * @param saveDate the save date
     * @param saveDay  the save day
     */
    void updateGoods(List<DuoGoodsInfo> result, Date saveDate, Integer saveDay);

    /**
     * check商品
     *
     * @param request the request
     * @return boolean
     */
    boolean checkGoods(GoodsCheckRequest request);


    /**
     * Check goods.
     *
     * @param duoGoodsInfos the duo goods infos
     */
    void checkGoods(List<DuoGoodsInfo> duoGoodsInfos);


    /**
     * Query channel goods list.
     *
     * @param infoRequest the info request
     * @return the list
     */
    List<DuoGoodsInfo> queryChannelGoods(GoodsInfoRecommendRequest infoRequest);

    /**
     * 查询多多客商品
     *
     * @param getDuoduoGoodsListRequest the get duoduo goods list request
     * @return t page result
     */
    TPageResult<DuoGoodsInfo> queryGoods(GetDuoduoGoodsListRequest getDuoduoGoodsListRequest);

    /**
     * Duoduo goods request duo goods result.
     *
     * @param page     the page
     * @param pageSize the page size
     * @param request  the request
     * @return the duo goods result
     */
    DuoGoodsResult duoduoGoodsRequest(Integer page, Integer pageSize, DuoGoodsRequest request);

    /**
     * Duoduo goods search goods search response.
     *
     * @param page         the page
     * @param rows         the rows
     * @param totalMaxPage the total max page
     * @param request      the request
     * @param isChoose     the is choose
     * @return the goods search response
     */
    GoodsSearchResponse duoduoGoodsSearch(Integer page, Integer rows, Integer totalMaxPage, GoodsSearchRequest request, String isChoose);

}
