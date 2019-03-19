package com.fulihui.duoduoke.demo.api.api;


import com.fulihui.duoduoke.demo.api.request.GoodsCatInfoRequest;
import com.fulihui.duoduoke.demo.api.dto.GoodsCatInfoDTO;
import com.fulihui.duoduoke.demo.api.dto.GoodsCatInfoTreeNodeDTO;
import org.near.servicesupport.result.TMultiResult;
import org.near.servicesupport.result.TPageResult;
import org.near.servicesupport.result.TSingleResult;

import java.util.List;

/**
 * The interface Goods opt info service.
 *
 * @author lizhi
 * @date 2018 -7-7
 */
public interface GoodsCatInfoService {


    /**
     * Query tree t page result.
     *
     * @param request the request
     * @return the t page result
     */
    TPageResult<GoodsCatInfoTreeNodeDTO> queryTree(GoodsCatInfoRequest request);

    /**
     * @param request
     * @return
     */
    TMultiResult<GoodsCatInfoTreeNodeDTO> tree(GoodsCatInfoRequest request);

    /**
     * 保存商品分类
     *
     * @param infoRequest
     * @return
     */
    TSingleResult<Boolean> update(GoodsCatInfoRequest infoRequest);

    /**
     * 查询分类名称
     *
     * @param
     * @return
     */
    TSingleResult<List<GoodsCatInfoDTO>> queryByCatIdArrays(List<Integer> list);


    TMultiResult<GoodsCatInfoDTO> selectByLevel(GoodsCatInfoRequest request);


}
