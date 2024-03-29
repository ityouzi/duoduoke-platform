package com.fulihui.duoduoke.demo.api.api;


import com.fulihui.duoduoke.demo.api.dto.GoodsInfoDTO;
import com.fulihui.duoduoke.demo.api.dto.GoodsTabelDTO;
import com.fulihui.duoduoke.demo.api.request.*;
import com.fulihui.duoduoke.demo.api.response.GoodsSearchInfoResponse;
import com.fulihui.duoduoke.demo.api.response.GoodsSearchResponse;
import org.near.servicesupport.result.BaseResult;
import org.near.servicesupport.result.TPageResult;
import org.near.servicesupport.result.TSingleResult;

import java.util.Date;
import java.util.List;

/**
 * 商品服务
 *
 * @author lizhi
 * @date 2018 -7-9
 */
public interface GoodsInfoService {

    /**
     * Search t page result.
     *
     * @param infoRequest the request
     * @return the t page result
     */
    TPageResult<GoodsSearchInfoResponse> search(GoodsSearchInfoRequest infoRequest);

    /**
     * 搜索优惠券商品
     *
     * @param request
     * @return
     */
    TPageResult<GoodsInfoDTO> searchCouponGoods(GetDuoduoGoodsListRequest request);

    /**
     * 记录
     *
     * @param infoRequest the info request
     * @return the base result
     */
    BaseResult record(GoodSearchRecordRequest infoRequest);

    /**
     * 查询商品
     *
     * @param infoRequest
     * @return
     */
    TPageResult<GoodsInfoDTO> queryGoodsInfo(GoodsInfoRequest infoRequest);

    /**
     * 查询数据
     *
     * @param infoRequest
     * @return
     */
    TPageResult<GoodsInfoDTO> queryGoodsInfoWithMark(GoodsInfoRequest infoRequest);


    /**
     * 查询列表商品
     *
     * @param infoRequest
     * @return
     */
    TPageResult<GoodsInfoDTO> queryGoodsListInfo(GoodsInfoRequest infoRequest);

    /**
     * 前端查询商品详情
     *
     * @param request
     * @return
     */
    TSingleResult<GoodsInfoDTO> queryGoodsDetail(GoodsInfoRequest request);

    /**
     * 更新商品
     *
     * @param infoRequest
     * @return
     */
    BaseResult updateGoodsInfo(GoodsInfoRequest infoRequest);

    /**
     * 插入商品
     *
     * @param infoRequest
     * @return
     */
    BaseResult insertGoodsInfo(GoodsInfoRequest infoRequest);


    /**
     * 更新平多多商品
     *
     * @return
     */
    TSingleResult<Boolean> updateGoodsFromPDD(Long goodsId);

    /**
     * 更新状态
     *
     * @param infoRequest
     * @return
     */
    BaseResult updateGoodsState(GoodsInfoUpdateRequest infoRequest);

    /**
     * 批量更新商品
     *
     * @return
     */
    BaseResult updateGoods();


    /**
     * 批量insert商品
     *
     * @return
     */
    BaseResult saveGoods();

    /**
     * 根据平多多id 查询数据库id
     *
     * @param goodsId
     * @return
     */
    TSingleResult<Long> queryIdByGoodsId(Long goodsId);


    /**
     * 批量更新商品
     *
     * @return
     */
    BaseResult checkGoods(GoodsCheckRequest request);


    BaseResult deleteAll();

    TSingleResult<GoodsInfoDTO> queryGoodsDetailNO(GoodsInfoRequest request);


    BaseResult updateTable();


    TSingleResult<GoodsTabelDTO> queryGoodsTable();

    TPageResult<GoodsInfoDTO> queryChannelGoods(GoodsInfoRecommendRequest infoRequest);


    TSingleResult<GoodsSearchResponse> searchGoods(GoodsSearchRequest request);

    List<GoodsInfoDTO> getList(GetStoreGoodsRequest getStoreGoodsRequest);

    BaseResult deleteOldAutoChoice(Date endUpdate);

}