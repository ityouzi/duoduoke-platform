package com.fulihui.duoduoke.demo.api.api;


import com.fulihui.duoduoke.demo.api.request.GoodsKeywordInfoRequest;
import com.fulihui.duoduoke.demo.api.dto.GoodsKeywordInfoDTO;
import org.near.servicesupport.result.TPageResult;
import org.near.servicesupport.result.TSingleResult;

/**
 * @Description:
 * @Author: xiaoming
 * @version: v 0.1 2018/7/16 0016 18:31
 */
public interface KeywordInfoService {

    TPageResult<GoodsKeywordInfoDTO> queryInfo(GoodsKeywordInfoRequest request);

    /**
     * 修改
     *
     * @param keywordInfoDTO
     * @return
     */
    TSingleResult<Boolean> modifyById(GoodsKeywordInfoDTO keywordInfoDTO);

    /**
     * 插入
     *
     * @param keywordInfoDTO
     * @return
     */
    TSingleResult<Integer> insert(GoodsKeywordInfoDTO keywordInfoDTO);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    TSingleResult<Boolean> delById(Integer id);

}
