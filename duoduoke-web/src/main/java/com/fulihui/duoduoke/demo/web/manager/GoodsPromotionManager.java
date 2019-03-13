package com.fulihui.duoduoke.demo.web.manager;


import com.fulihui.duoduoke.demo.web.vo.GoodsPromotionUrlVO;

/**
 * The interface Good promotion manager.
 *
 * @author lizhi
 * @date 2018 -7-14
 */
public interface GoodsPromotionManager {
    /**
     * 生成商品推广链接
     *
     * @param userId        the user id
     * @param goodsId       the goods id
     * @param pid           the pid
     * @param shareId       the share id
     * @param generateWeApp the generate we app
     * @return goods promotion url vo
     */
    GoodsPromotionUrlVO goodsGenerate(String userId, String goodsId
            , String pid, String shareId, Boolean generateWeApp);


}
