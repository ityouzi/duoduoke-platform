package com.fulihui.duoduoke.demo.producer.service;


import com.fulihui.duoduoke.demo.api.api.MarkService;
import com.fulihui.duoduoke.demo.api.dto.CornerMarkDTO;
import com.fulihui.duoduoke.demo.api.dto.GoodsMarkDTO;
import com.fulihui.duoduoke.demo.api.request.CornerMarkRequest;
import com.fulihui.duoduoke.demo.api.request.GoodsMarkRequest;
import com.fulihui.duoduoke.demo.producer.repository.CornerMarkRepository;
import com.fulihui.duoduoke.demo.producer.repository.GoodsMarkRepository;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.CornerMark;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.GoodsMark;
import com.fulihui.duoduoke.demo.common.util.BeanConvUtil;
import com.fulihui.duoduoke.demo.common.util.RedisUtils;
import org.apache.dubbo.config.annotation.Service;
import org.near.servicesupport.error.Errors;
import org.near.servicesupport.result.ResultBuilder;
import org.near.servicesupport.result.TMultiResult;
import org.near.servicesupport.result.TSingleResult;
import org.near.servicesupport.util.ServiceAssert;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description:
 * @Author: xiaoming
 * @version: v 0.1 2018/8/2 0002 14:55
 */
@Service(version = "${demo.service.version}")

public class MarkServiceImpl implements MarkService {

    /**
     * redis缓存
     */
    private static final String REDIS_GOODS_MARK_LIST_KEY = "DUODUOKE_GOODS_MARK_LIST_KEY";
    @Autowired
    private GoodsMarkRepository goodsMarkRepository;
    @Autowired
    private CornerMarkRepository cornerMarkRepository;
    @Autowired
    private RedisUtils redisUtils;

    private List<CornerMarkDTO> convert(List<CornerMark> cornerMarks) {
        if (CollectionUtils.isEmpty(cornerMarks)) {
            return Collections.emptyList();
        }
        return cornerMarks.stream().map(i -> {
            CornerMarkDTO cornerMarkDTO = new CornerMarkDTO();
            BeanUtils.copyProperties(i, cornerMarkDTO);
            return cornerMarkDTO;
        }).collect(Collectors.toList());
    }


    private List<GoodsMarkDTO> convertGoods(List<GoodsMark> goodsMarks) {
        if (CollectionUtils.isEmpty(goodsMarks)) {
            return Collections.emptyList();
        }
        return goodsMarks.stream().map(i -> {
            GoodsMarkDTO goodsMarkDTO = new GoodsMarkDTO();
            BeanUtils.copyProperties(i, goodsMarkDTO);
            return goodsMarkDTO;
        }).collect(Collectors.toList());
    }

    @Override
    public TMultiResult<CornerMarkDTO> queryCornerMark(CornerMarkRequest request) {
        ServiceAssert.notNull(request, Errors.Commons.REQUEST_PARAMETER_ERROR);

        CornerMark cornerMark = new CornerMark();

        //数据转换
        BeanUtils.copyProperties(request, cornerMark);

        List<CornerMark> cornerMarks = cornerMarkRepository.selectByExample(cornerMark);
        List<CornerMarkDTO> convert = convert(cornerMarks);
        return ResultBuilder.succTMulti(convert);
    }

    @Override
    public TSingleResult<CornerMarkDTO> queryCornerMarkById(CornerMarkRequest request) {
        ServiceAssert.notNull(request, Errors.Commons.REQUEST_PARAMETER_ERROR);
        Integer id = request.getId();

        CornerMark cornerMark = cornerMarkRepository.selectByPrimaryKey(id);
        CornerMarkDTO cornerMarkDTO = new CornerMarkDTO();
        BeanUtils.copyProperties(cornerMark, cornerMarkDTO);
        return ResultBuilder.succTSingle(cornerMarkDTO);
    }

    @Override
    public TSingleResult<Boolean> insertCornerMark(CornerMarkDTO cornerMarkDTO) {
        CornerMark cornerMark = BeanConvUtil.copy(cornerMarkDTO, CornerMark.class);

        //初始时间
        boolean success = cornerMarkRepository.insert(cornerMark) > 0;

        return ResultBuilder.succTSingle(success);
    }

    @Override
    public TSingleResult<Boolean> updateCornerMark(CornerMarkDTO cornerMarkDTO) {
        CornerMark cornerMark = BeanConvUtil.copy(cornerMarkDTO, CornerMark.class);

        boolean success = cornerMarkRepository.update(cornerMark) > 0;

        return ResultBuilder.succTSingle(success);
    }

    @Override
    public TSingleResult<Boolean> delCornerMark(CornerMarkRequest request) {
        boolean success = cornerMarkRepository.del(request.getId()) > 0;

        return ResultBuilder.succTSingle(success);
    }

    @Override
    public TMultiResult<GoodsMarkDTO> queryGoodsMark(GoodsMarkRequest request) {
        ServiceAssert.notNull(request, Errors.Commons.REQUEST_PARAMETER_ERROR);

        GoodsMark goodsMark = new GoodsMark();

        //数据转换
        BeanUtils.copyProperties(request, goodsMark);
        if (request.getStartTimeLessThanOrEqualTo() != null) {
            goodsMark.setStartTime(request.getStartTimeLessThanOrEqualTo());
        }
        if (request.getStopTimeGreaterThanOrEqualTo() != null) {
            goodsMark.setStopTime(request.getStopTimeGreaterThanOrEqualTo());
        }

        List<GoodsMark> goodsMarks = goodsMarkRepository.selectByExample(goodsMark);
        List<GoodsMarkDTO> convert = convertGoods(goodsMarks);
        return ResultBuilder.succTMulti(convert);
    }

    /**
     * 查询商品角标关联数据
     *
     * @return
     */
    @Override
    public TMultiResult<GoodsMarkDTO> queryGoodsMarkInCache(boolean refresh) {

        List<GoodsMarkDTO> cacheResult = (List<GoodsMarkDTO>) redisUtils.get(REDIS_GOODS_MARK_LIST_KEY);
        //查询数据
        if (cacheResult == null || refresh) {
            List<GoodsMark> goodsMarks = goodsMarkRepository.queryUsingGoodsMark();
            cacheResult = convertGoods(goodsMarks);
        }
        return ResultBuilder.succTMulti(cacheResult);
    }

    @Override
    public TSingleResult<GoodsMarkDTO> queryGoodsMarkById(GoodsMarkRequest request) {
        ServiceAssert.notNull(request, Errors.Commons.REQUEST_PARAMETER_ERROR);

        GoodsMark goodsMark = null;

        if (request.getId() != null) {
            Integer id = request.getId();
            goodsMark = goodsMarkRepository.selectByPrimaryKey(id);
        } else {
            goodsMark = goodsMarkRepository.selectByGoodsId(request.getGoodsId());
        }

        GoodsMarkDTO goodsMarkDTO = new GoodsMarkDTO();
        if (goodsMark != null) {
            BeanUtils.copyProperties(goodsMark, goodsMarkDTO);
            Integer markId = goodsMark.getMarkId();
            CornerMark cornerMark = cornerMarkRepository.selectByPrimaryKey(markId);
            goodsMarkDTO.setMarkUrl(cornerMark.getMarkUrl());
            goodsMarkDTO.setMarkName(cornerMark.getMarkName());
        }
        return ResultBuilder.succTSingle(goodsMarkDTO);
    }

    @Override
    public TSingleResult<GoodsMarkDTO> queryGoodsMarkSingle(GoodsMarkRequest request) {
        ServiceAssert.notNull(request, Errors.Commons.REQUEST_PARAMETER_ERROR);
        ServiceAssert.notNull(request.getGoodsId(), Errors.Commons.REQUEST_PARAMETER_ERROR);

        GoodsMark goodsMark = new GoodsMark();

        //数据转换
        BeanUtils.copyProperties(request, goodsMark);
        if (request.getStartTimeLessThanOrEqualTo() != null) {
            goodsMark.setStartTime(request.getStartTimeLessThanOrEqualTo());
        }
        if (request.getStopTimeGreaterThanOrEqualTo() != null) {
            goodsMark.setStopTime(request.getStopTimeGreaterThanOrEqualTo());
        }

        GoodsMark result = goodsMarkRepository.selectByIdTime(goodsMark);
        if (result != null) {
            GoodsMarkDTO goodsMarkDTO = new GoodsMarkDTO();
            BeanUtils.copyProperties(result, goodsMarkDTO);
            return ResultBuilder.succTSingle(goodsMarkDTO);
        } else {
            return ResultBuilder.succTSingle(null);
        }
    }

    @Override
    public TSingleResult<Boolean> insertGoodsMark(GoodsMarkDTO goodsMarkDTO) {
        GoodsMark goodsMark = BeanConvUtil.copy(goodsMarkDTO, GoodsMark.class);

        //初始时间
        boolean success = goodsMarkRepository.insert(goodsMark) > 0;

        return ResultBuilder.succTSingle(success);
    }

    @Override
    public TSingleResult<Boolean> updateGoodsMark(GoodsMarkDTO goodsMarkDTO) {
        GoodsMark goodsMark = BeanConvUtil.copy(goodsMarkDTO, GoodsMark.class);

        boolean success = goodsMarkRepository.update(goodsMark) > 0;

        return ResultBuilder.succTSingle(success);
    }

    @Override
    public TSingleResult<Boolean> updateGoodsMarkByMarkId(Integer markId, String markUrl) {

        boolean success = goodsMarkRepository.updateGoodsMarkByMarkId(markId, markUrl) > 0;

        return ResultBuilder.succTSingle(success);
    }

    @Override
    public TSingleResult<Boolean> delGoodsMark(GoodsMarkRequest request) {
        boolean success = goodsMarkRepository.del(request.getId()) > 0;

        return ResultBuilder.succTSingle(success);
    }
}
