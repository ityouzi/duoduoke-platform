package com.fulihui.redisdubbo.demo.api.api;

import com.fulihui.redisdubbo.demo.api.dto.CornerMarkDTO;
import com.fulihui.redisdubbo.demo.api.dto.GoodsMarkDTO;
import com.fulihui.redisdubbo.demo.api.request.CornerMarkRequest;
import com.fulihui.redisdubbo.demo.api.request.GoodsMarkRequest;
import org.near.servicesupport.result.TMultiResult;
import org.near.servicesupport.result.TSingleResult;

/**
 * @Description:
 * @Author: xiaoming
 * @version: v 0.1 2018/8/2 0002 14:30
 */
public interface MarkService {

    /**
     * @param request
     * @return
     */
    TMultiResult<CornerMarkDTO> queryCornerMark(CornerMarkRequest request);

    TSingleResult<CornerMarkDTO> queryCornerMarkById(CornerMarkRequest request);

    /**
     * 插入数据
     * @param
     * @return
     */
    TSingleResult<Boolean> insertCornerMark(CornerMarkDTO cornerMarkDTO);

    /**
     * 修改数据
     * @param
     * @return
     */
    TSingleResult<Boolean> updateCornerMark(CornerMarkDTO cornerMarkDTO);

    /**
     * 删除
     * @param request
     * @return
     */
    TSingleResult<Boolean> delCornerMark(CornerMarkRequest request);

    /**
     * @param request
     * @return
     */
    TMultiResult<GoodsMarkDTO> queryGoodsMark(GoodsMarkRequest request);

    /**
     * 查询角标缓存数据
     * @return
     */
    TMultiResult<GoodsMarkDTO> queryGoodsMarkInCache(boolean refresh);

    TSingleResult<GoodsMarkDTO> queryGoodsMarkById(GoodsMarkRequest request);

    /**
     * 根据商品id，时间，id查询角标关联
     *
     * @param request
     * @return  带角标url 角标名称
     */
    TSingleResult<GoodsMarkDTO> queryGoodsMarkSingle(GoodsMarkRequest request);

    /**
     * 插入数据
     * @param
     * @return
     */
    TSingleResult<Boolean> insertGoodsMark(GoodsMarkDTO cornerMarkDTO);

    /**
     * 修改数据
     * @param
     * @return
     */
    TSingleResult<Boolean> updateGoodsMark(GoodsMarkDTO cornerMarkDTO);

    /**
     * 修改商品关联的角标
     * @param
     * @return
     */
    TSingleResult<Boolean> updateGoodsMarkByMarkId(Integer markId, String markUrl);

    /**
     * 删除
     * @param request
     * @return
     */
    TSingleResult<Boolean> delGoodsMark(GoodsMarkRequest request);
}
