package com.fulihui.duoduoke.demo.producer.service;


import com.fulihui.duoduoke.demo.api.api.ExemptionService;
import com.fulihui.duoduoke.demo.api.dto.ExemptionGoodsDTO;
import com.fulihui.duoduoke.demo.api.enums.ExemptionGoodsStateEnum;
import com.fulihui.duoduoke.demo.api.request.ExemptionRequest;
import com.fulihui.duoduoke.demo.api.request.IdRequest;
import com.fulihui.duoduoke.demo.producer.repository.ExemptionGoodsRepository;
import com.fulihui.duoduoke.demo.producer.repository.UserExemptionGoodsRepository;
import com.fulihui.duoduoke.demo.producer.dal.dao.ExemptionGoodsMapper;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.ExemptionGoods;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.ExemptionGoodsExample;
import com.fulihui.duoduoke.demo.common.util.BeanConvUtil;
import org.apache.dubbo.config.annotation.Service;
import org.near.servicesupport.error.Errors;
import org.near.servicesupport.result.ResultBuilder;
import org.near.servicesupport.result.TMultiResult;
import org.near.servicesupport.result.TPageResult;
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

public class ExemptionServiceImpl implements ExemptionService {

    @Autowired
    ExemptionGoodsMapper exemptionGoodsMapper;

    @Autowired
    private ExemptionGoodsRepository exemptionGoodsRepository;
    @Autowired
    private UserExemptionGoodsRepository userExemptionGoodsRepository;

    @Override
    public TMultiResult<ExemptionGoodsDTO> query(ExemptionRequest request) {
        ServiceAssert.notNull(request, Errors.Commons.REQUEST_PARAMETER_ERROR);

        ExemptionGoods exemptionGoods = new ExemptionGoods();

        //数据转换
        BeanUtils.copyProperties(request, exemptionGoods);

        List<ExemptionGoods> list = exemptionGoodsRepository.selectByExample(exemptionGoods);
        List<ExemptionGoodsDTO> convert = convert(list);
        return ResultBuilder.succTMulti(convert);
    }

    @Override
    public TPageResult<ExemptionGoodsDTO> queryPage(ExemptionRequest request) {
        ServiceAssert.notNull(request, Errors.Commons.REQUEST_PARAMETER_ERROR);

        //查询条件
        ExemptionGoodsExample example = new ExemptionGoodsExample();
        example.setOrderByClause("sort DESC");
        ExemptionGoodsExample.Criteria criteria = example.createCriteria();
        criteria.andStateNotEqualTo(ExemptionGoodsStateEnum.OVER.getCode());
        if (request.getActivityIds() != null) {
            criteria.andActivityIdIn(request.getActivityIds());
        }
        example.setOffset(request.start4Mysql());
        example.setLimit(request.getRows());

        //查询数据
        List<ExemptionGoods> list = exemptionGoodsMapper.selectByExample(example);
        List<ExemptionGoodsDTO> convert = convert(list);

        //查询总条数
        long total = exemptionGoodsMapper.countByExample(example);

        return ResultBuilder.succTPage(convert, request.getPage(), request.getRows(), (int) total);
    }

    @Override
    public TSingleResult<Boolean> insert(ExemptionGoodsDTO exemptionGoodsDTO) {

        ExemptionGoods exemptionGoods = BeanConvUtil.copy(exemptionGoodsDTO, ExemptionGoods.class);

        //初始时间
        boolean success = exemptionGoodsRepository.insert(exemptionGoods) > 0;

        return ResultBuilder.succTSingle(success);
    }

    @Override
    public TSingleResult<Boolean> update(ExemptionGoodsDTO exemptionGoodsDTO) {

        ExemptionGoods exemptionGoods = BeanConvUtil.copy(exemptionGoodsDTO, ExemptionGoods.class);

        boolean success = exemptionGoodsRepository.update(exemptionGoods) > 0;

        return ResultBuilder.succTSingle(success);
    }

    @Override
    public TSingleResult<Boolean> del(IdRequest request) {
        ServiceAssert.notNull(request, Errors.Commons.REQUEST_PARAMETER_ERROR);
        ServiceAssert.notNull(request.getId(), Errors.Commons.REQUEST_PARAMETER_ERROR);

        boolean success = exemptionGoodsRepository.del(request.getId()) > 0;

        return ResultBuilder.succTSingle(success);
    }

    @Override
    public TSingleResult<ExemptionGoodsDTO> selectByPrimaryKey(IdRequest request) {
        ServiceAssert.notNull(request, Errors.Commons.REQUEST_PARAMETER_ERROR);
        ServiceAssert.notNull(request.getId(), Errors.Commons.REQUEST_PARAMETER_ERROR);
        ExemptionGoods exemptionGoods = exemptionGoodsRepository
                .selectByPrimaryKey(request.getId());
        ExemptionGoodsDTO exemptionGoodsDTO = new ExemptionGoodsDTO();
        BeanUtils.copyProperties(exemptionGoods, exemptionGoodsDTO);
        return ResultBuilder.succTSingle(exemptionGoodsDTO);
    }

    @Override
    public boolean modifyNum(ExemptionGoodsDTO exemptionGoodsDTO) {
        ServiceAssert.notNull(exemptionGoodsDTO, Errors.Commons.REQUEST_PARAMETER_ERROR);
        ServiceAssert.notNull(exemptionGoodsDTO.getId(), Errors.Commons.REQUEST_PARAMETER_ERROR);
        ExemptionGoods exemptionGoods = BeanConvUtil.copy(exemptionGoodsDTO, ExemptionGoods.class);
        int i = exemptionGoodsRepository.modifyNum(exemptionGoods);

        return i > 0;
    }

    private List<ExemptionGoodsDTO> convert(List<ExemptionGoods> exemptionGoods) {
        if (CollectionUtils.isEmpty(exemptionGoods)) {
            return Collections.emptyList();
        }
        return exemptionGoods.stream().map(i -> {
            ExemptionGoodsDTO exemptionGoodsDTO = new ExemptionGoodsDTO();
            BeanUtils.copyProperties(i, exemptionGoodsDTO);
            return exemptionGoodsDTO;
        }).collect(Collectors.toList());
    }

    @Override
    public boolean addReceiveNum(ExemptionGoodsDTO request) {
        ServiceAssert.notNull(request, Errors.Commons.REQUEST_PARAMETER_ERROR);
        ServiceAssert.notNull(request.getId(), Errors.Commons.REQUEST_PARAMETER_ERROR);
        ExemptionGoods exemptionGoods = BeanConvUtil.copy(request, ExemptionGoods.class);
        int i = exemptionGoodsRepository.addReceiveNum(exemptionGoods);

        return i > 0;
    }

    @Override
    public boolean subReceiveNum(ExemptionGoodsDTO request) {
        ServiceAssert.notNull(request, Errors.Commons.REQUEST_PARAMETER_ERROR);
        ServiceAssert.notNull(request.getId(), Errors.Commons.REQUEST_PARAMETER_ERROR);
        ExemptionGoods exemptionGoods = BeanConvUtil.copy(request, ExemptionGoods.class);
        int i = exemptionGoodsRepository.subReceiveNum(exemptionGoods);

        return i > 0;
    }
}
