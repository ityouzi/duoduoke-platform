package com.fulihui.duoduoke.demo.producer.repository;

import com.fulihui.duoduoke.demo.api.dto.GoodsKeywordInfoDTO;

import java.util.List;


/**
 * @Description:
 * @Author: xiaoming
 * @version: v 0.1 2018/7/16 0016 18:26
 */
public interface KeywordInfoRepository {


    List<GoodsKeywordInfoDTO> queryKeywordInfo(String keyword, int page, int rows);

    long count(String keyword);

}