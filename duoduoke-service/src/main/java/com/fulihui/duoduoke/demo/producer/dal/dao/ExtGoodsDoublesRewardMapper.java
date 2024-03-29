package com.fulihui.duoduoke.demo.producer.dal.dao;

import com.fulihui.duoduoke.demo.api.dto.GoodsDoublesRewardInfoDTO;
import com.fulihui.duoduoke.demo.api.request.GoodsDoubleRewardJobRequest;
import com.fulihui.duoduoke.demo.api.request.GoodsDoublesRewardRequest;
import com.fulihui.duoduoke.demo.api.request.GoodsDoublesRewardSelectRequest;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.GoodsDoublesReward;

import java.util.List;


public interface ExtGoodsDoublesRewardMapper {

    List<GoodsDoublesReward> selectGoodsDoublesReward(GoodsDoublesRewardRequest goodsDoublesRewardRequest);

    List<GoodsDoublesRewardInfoDTO> list(GoodsDoublesRewardSelectRequest goodsDoublesRewardSelectRequest);

    int listSum(GoodsDoublesRewardSelectRequest goodsDoublesRewardSelectRequest);

    List<GoodsDoublesReward> selectGoodsDoublesRewardByGoodsId(String goodsId);

    GoodsDoublesRewardInfoDTO singleById(String id);

    void updateGoodsDoubleRewardNowBegin(GoodsDoubleRewardJobRequest nowBegin);

    void updateGoodsDoubleRewardNowEnd(GoodsDoubleRewardJobRequest nowBegin);

    void updateGoodsDoubleRewardNowEndAct(GoodsDoubleRewardJobRequest nowBegin);

    List<Integer> getUpdateGoodsDoubleRewardNowBegin(GoodsDoubleRewardJobRequest nowBegin);

    List<Integer> getUpdateGoodsDoubleRewardNowEnd(GoodsDoubleRewardJobRequest nowBegin);

    List<Integer> getUpdateGoodsDoubleRewardNowEndAct(GoodsDoubleRewardJobRequest nowBegin);

    Float getMaxDoubleRate();
}
