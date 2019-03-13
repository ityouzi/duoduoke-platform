package com.fulihui.duoduoke.demo.producer.service.promotion;

import com.fulihui.duoduoke.demo.api.api.promotion.PromotionChannelsService;
import com.fulihui.duoduoke.demo.api.dto.promotion.PromotionChannelsDTO;
import com.fulihui.duoduoke.demo.api.dto.promotion.PromotionChannelsLogRecordDTO;
import com.fulihui.duoduoke.demo.api.enums.SwitchEnum;
import com.fulihui.duoduoke.demo.api.request.promition.PromotionChannelsRequest;
import com.fulihui.duoduoke.demo.producer.repository.PromotionChannelsRepository;
import com.fulihui.duoduoke.demo.producer.dal.dao.PromotionChannelsLogRecordMapper;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.PromotionChannels;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.PromotionChannelsExample;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.PromotionChannelsLogRecord;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.PromotionChannelsLogRecordExample;
import org.apache.dubbo.config.annotation.Service;
import org.near.servicesupport.error.Errors;
import org.near.servicesupport.result.ResultBuilder;
import org.near.servicesupport.result.TPageResult;
import org.near.servicesupport.result.TSingleResult;
import org.near.toolkit.common.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static org.near.servicesupport.util.ServiceAssert.notBlank;
import static org.near.servicesupport.util.ServiceAssert.notNull;
import static org.springframework.util.CollectionUtils.isEmpty;


/**
 * Created by lizhi on 2018-11-29.
 */
@Service(version = "${demo.service.version}")
public class PromotionChannelsServiceImpl implements PromotionChannelsService {

    private static final Logger LOGGER = LoggerFactory
            .getLogger(PromotionChannelsServiceImpl.class);
    @Autowired
    PromotionChannelsRepository promotionChannelsRepository;
    @Autowired
    PromotionChannelsLogRecordMapper promotionChannelsLogRecordMapper;

    private PromotionChannelsExample getPromotionChannelsExample(PromotionChannelsRequest request) {
        PromotionChannelsExample example = new PromotionChannelsExample();
        PromotionChannelsExample.Criteria criteria = example.createCriteria();
        if (StringUtil.isNotEmpty(request.getChannelsCode())) {
            criteria.andChannelsCodeEqualTo(request.getChannelsCode());
        }
        if (StringUtil.isNotEmpty(request.getChannelsName())) {
            criteria.andChannelsNameEqualTo(request.getChannelsName());
        }
        return example;
    }

    private PromotionChannelsExample toExample(PromotionChannelsRequest request) {
        PromotionChannelsExample example = getPromotionChannelsExample(request);
        example.setOffset(request.start4Mysql());
        example.setLimit(request.getRows());
        return example;
    }

    @Override
    public TPageResult<PromotionChannelsDTO> queryPage(PromotionChannelsRequest request) {

        notNull(request, Errors.Commons.REQUEST_PARAMETER_ERROR);
        PromotionChannelsExample example = toExample(request);
        List<PromotionChannelsDTO> list = promotionChannelsRepository.query(example);
        long count = 0;
        if (!isEmpty(list)) {
            count = promotionChannelsRepository.count(example);
        }
        return ResultBuilder.succTPage(list, request.getPage(), request.getRows(), (int) count);
    }

    @Override
    public TSingleResult<Long> insert(PromotionChannelsRequest request) {
        notNull(request, Errors.Commons.REQUEST_PARAMETER_ERROR);
        notBlank(request.getChannelsCode(), Errors.Commons.REQUEST_PARAMETER_ERROR);
        PromotionChannelsExample channelsExample = new PromotionChannelsExample();
        PromotionChannelsExample.Criteria criteria = channelsExample.createCriteria();
        criteria.andChannelsCodeEqualTo(request.getChannelsCode());
        List<PromotionChannelsDTO> list = promotionChannelsRepository.query(channelsExample);
        if (!CollectionUtils.isEmpty(list)) {
            return ResultBuilder.failTSingle(Errors.Commons.SYSTEM_ERROR);
        }
        PromotionChannels record = new PromotionChannels();
        BeanUtils.copyProperties(request, record);
        record.setAccountBalance(0);
        record.setChannelsIncome(0);
        int insert = promotionChannelsRepository.insert(record);
        return ResultBuilder.succTSingle((long) insert);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public TSingleResult<Long> update(PromotionChannelsRequest request) {
        notNull(request, Errors.Commons.REQUEST_PARAMETER_ERROR);
        notNull(request.getId(), Errors.Commons.REQUEST_PARAMETER_ERROR);
        PromotionChannelsDTO item = promotionChannelsRepository.queryByPk(request.getId());
        if (item == null) {
            return ResultBuilder.failTSingle(Errors.Commons.SYSTEM_ERROR);
        }
        PromotionChannels record = new PromotionChannels();
        record.setId(item.getId());
        record.setChannelsStatus(request.getChannelsStatus());
        record.setChannelsProportion(request.getChannelsProportion());
        record.setChannelsName(request.getChannelsName());
        record.setChannelsDesc(request.getChannelsDesc());
        record.setProportionLink(request.getProportionLink());
        promotionChannelsRepository.update(record);
        PromotionChannelsLogRecord logRecord = new PromotionChannelsLogRecord();
        logRecord.setPromotionChannelsId(item.getId());
        logRecord.setChannelsProportionBefore(item.getChannelsProportion());
        logRecord.setChannelsProportionAfter(request.getChannelsProportion());
        Date date = new Date();
        logRecord.setGmtCreate(date);
        logRecord.setGmtModified(date);
        promotionChannelsLogRecordMapper.insertSelective(logRecord);
        return ResultBuilder.succTSingle((long) item.getId());
    }

    @Override
    public TSingleResult<PromotionChannelsDTO> queryByPk(PromotionChannelsRequest request) {
        notNull(request, Errors.Commons.REQUEST_PARAMETER_ERROR);
        notNull(request.getId(), Errors.Commons.REQUEST_PARAMETER_ERROR);

        PromotionChannelsDTO item = promotionChannelsRepository.queryByPk(request.getId());
        if (item == null) {
            return ResultBuilder.succTSingle(null);
        }

        Integer id = item.getId();
        PromotionChannelsLogRecordExample example = new PromotionChannelsLogRecordExample();
        example.createCriteria().andPromotionChannelsIdEqualTo(id);
        List<PromotionChannelsLogRecord> logRecordList = promotionChannelsLogRecordMapper
                .selectByExample(example);
        if (CollectionUtils.isEmpty(logRecordList)) {
            return ResultBuilder.succTSingle(item);
        }
        List<PromotionChannelsLogRecordDTO> collect = logRecordList.stream().map(it -> {
            PromotionChannelsLogRecordDTO dto = new PromotionChannelsLogRecordDTO();
            BeanUtils.copyProperties(it, dto);
            return dto;
        }).collect(Collectors.toList());
        item.setDtoList(collect);
        return ResultBuilder.succTSingle(item);

    }

    @Override
    public TSingleResult<PromotionChannelsDTO> queryByPid(String pid) {
        List<PromotionChannelsDTO> itemList = promotionChannelsRepository.queryByPid(pid,
                SwitchEnum.ENABLE.getCode());
        if (CollectionUtils.isEmpty(itemList)) {
            return ResultBuilder.succTSingle(null);
        }
        return ResultBuilder.succTSingle(itemList.get(0));
    }

}
