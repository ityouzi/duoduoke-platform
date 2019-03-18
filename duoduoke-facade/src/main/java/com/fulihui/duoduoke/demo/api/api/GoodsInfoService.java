package com.fulihui.duoduoke.demo.api.api;


import com.fulihui.duoduoke.demo.api.dto.DuoduoGoodsInfoDTO;
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
    TPageResult<DuoduoGoodsInfoDTO> searchCouponGoods(GetDuoduoGoodsListRequest request);

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
    TPageResult<DuoduoGoodsInfoDTO> queryGoodsInfo(DuoduoGoodsInfoRequest infoRequest);

    /**
     * 查询数据
     *
     * @param infoRequest
     * @return
     */
    TPageResult<DuoduoGoodsInfoDTO> queryGoodsInfoWithMark(DuoduoGoodsInfoRequest infoRequest);


    /**
     * 查询列表商品
     *
     * @param infoRequest
     * @return
     */
    TPageResult<DuoduoGoodsInfoDTO> queryGoodsListInfo(DuoduoGoodsInfoRequest infoRequest);

    /**
     * 前端查询商品详情
     *
     * @param request
     * @return
     */
    TSingleResult<DuoduoGoodsInfoDTO> queryGoodsDetail(DuoduoGoodsInfoRequest request);

    /**
     * 更新商品
     *
     * @param infoRequest
     * @return
     */
    BaseResult updateGoodsInfo(DuoduoGoodsInfoRequest infoRequest);

    /**
     * 插入商品
     *
     * @param infoRequest
     * @return
     */
    BaseResult insertGoodsInfo(DuoduoGoodsInfoRequest infoRequest);


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
    BaseResult updateGoodsState(DuoduoGoodsInfoUpdateRequest infoRequest);

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
    BaseResult checkGoods(DuoduoGoodsCheckRequest request);


    BaseResult deleteAll();

    TSingleResult<DuoduoGoodsInfoDTO> queryGoodsDetailNO(DuoduoGoodsInfoRequest request);


    BaseResult updateTable();


    TSingleResult<GoodsTabelDTO> queryGoodsTable();

    TPageResult<DuoduoGoodsInfoDTO> queryChannelGoods(GoodsInfoRecommendRequest infoRequest);


    TSingleResult<GoodsSearchResponse> searchGoods(GoodsSearchRequest request);

    List<DuoduoGoodsInfoDTO> getList(GetStoreGoodsRequest getStoreGoodsRequest);

    BaseResult deleteOldAutoChoice(Date endUpdate);

}