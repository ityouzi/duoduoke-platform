package com.fulihui.duoduoke.demo.producer.service;

import com.fulihui.duoduoke.demo.api.api.RedPackageFieldService;
import com.fulihui.duoduoke.demo.api.dto.RedPackageFieldDTO;
import com.fulihui.duoduoke.demo.api.dto.UserRedPackageRecordDTO;
import com.fulihui.duoduoke.demo.api.request.RedPackageFieldRequest;
import com.fulihui.duoduoke.demo.api.request.UserRedPackageRecordRequest;
import com.fulihui.duoduoke.demo.api.util.Collections;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.RedPackageField;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.RedPackageFieldExample;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.UserRedPackageRecord;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.UserRedPackageRecordExample;
import com.fulihui.duoduoke.demo.producer.dal.dao.RedPackageFieldMapper;
import com.fulihui.duoduoke.demo.producer.dal.dao.UserRedPackageRecordMapper;
import com.fulihui.duoduoke.demo.common.util.BeanConvUtil;
import org.apache.dubbo.config.annotation.Service;
import org.near.servicesupport.result.ResultBuilder;
import org.near.servicesupport.result.TMultiResult;
import org.near.servicesupport.result.TPageResult;
import org.near.toolkit.common.StringUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: JY
 * @date: 2018/9/3 15:20
 */
@Service(version = "${demo.service.version}")

public class RedPackageFieldServiceImpl implements RedPackageFieldService {

    @Autowired
    RedPackageFieldMapper redPackageFieldMapper;

    @Autowired
    UserRedPackageRecordMapper userRedPackageRecordMapper;

    /**
     * 插入
     *
     * @param model
     * @return
     */
    @Override
    public Boolean insert(RedPackageFieldDTO model) {

        RedPackageField fieldModel = BeanConvUtil.copy(model, RedPackageField.class);

        fieldModel.setGmtCreate(new Date());
        fieldModel.setGmtModified(new Date());

        return redPackageFieldMapper.insert(fieldModel) > 0;
    }

    @Override
    public TMultiResult<UserRedPackageRecordDTO> queryRecord(UserRedPackageRecordRequest request) {

        UserRedPackageRecordExample example = new UserRedPackageRecordExample();
        UserRedPackageRecordExample.Criteria criteria = example.createCriteria();
        criteria.andFieldIdEqualTo(request.getFieldId());
        criteria.andUserIdEqualTo(request.getUserId());

        if (StringUtil.isNotBlank(request.getSortInfo())) {
            example.setOrderByClause(request.getSortInfo());
        }

        List<UserRedPackageRecord> list = userRedPackageRecordMapper.selectByExample(example);

        if (CollectionUtils.isEmpty(list)) {
            return ResultBuilder.succTMulti(Collections.emptyList());
        }
        List<UserRedPackageRecordDTO> collect = list.stream().map(item -> {
            UserRedPackageRecordDTO recordDTO = new UserRedPackageRecordDTO();
            BeanUtils.copyProperties(item, recordDTO);
            return recordDTO;
        }).collect(Collectors.toList());
        return ResultBuilder.succTMulti(collect);
    }

    @Override
    public Long insertUserRedPackage(UserRedPackageRecordDTO dto) {
        UserRedPackageRecord record = BeanConvUtil.copy(dto, UserRedPackageRecord.class);
        record.setGmtCreate(new Date());
        record.setGmtModified(new Date());
        userRedPackageRecordMapper.insertSelective(record);
        return Long.valueOf(record.getId());
    }

    @Override
    public Boolean update(UserRedPackageRecordDTO dto) {

        UserRedPackageRecordExample example = new UserRedPackageRecordExample();
        example.createCriteria().andUserIdEqualTo(dto.getUserId());
        example.createCriteria().andFieldIdEqualTo(dto.getFieldId());
        example.createCriteria().andIdEqualTo(dto.getId());
        example.setOrderByClause(" gmt_create desc");
        List<UserRedPackageRecord> list = userRedPackageRecordMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(list)) {
            return Boolean.FALSE;
        }

        UserRedPackageRecord record = new UserRedPackageRecord();
        record.setHelp(dto.getHelp());
        record.setGmtModified(new Date());

        UserRedPackageRecordExample recordExample = new UserRedPackageRecordExample();

        recordExample.createCriteria().andIdEqualTo(list.get(0).getId());
        return userRedPackageRecordMapper.updateByExampleSelective(record, recordExample) > 0;

    }

    /**
     * 修改
     *
     * @param model
     * @return
     */
    @Override
    public Boolean modify(RedPackageFieldDTO model) {

        if (model.getId() == null) {
            return false;
        }

        RedPackageField fieldModel = BeanConvUtil.copy(model, RedPackageField.class);
        fieldModel.setGmtModified(new Date());
        return redPackageFieldMapper.updateByPrimaryKeySelective(fieldModel) > 0;
    }

    @Override
    public RedPackageFieldDTO getModel(Integer id) {

        RedPackageField fieldModel = redPackageFieldMapper.selectByPrimaryKey(id);

        RedPackageFieldDTO fieldDTO = null;

        if (fieldModel != null) {
            fieldDTO = BeanConvUtil.copy(fieldModel, RedPackageFieldDTO.class);
        }

        return fieldDTO;
    }

    /**
     * 查询列表
     *
     * @param request
     * @return
     */
    @Override
    public TPageResult<RedPackageFieldDTO> list(RedPackageFieldRequest request) {

        RedPackageFieldExample example = new RedPackageFieldExample();

        RedPackageFieldExample.Criteria criteria = example.createCriteria();

        if (request.getId() != null) {
            criteria.andIdEqualTo(request.getId());
        }

        if (request.getState() != null) {
            criteria.andStateEqualTo(request.getState());
        }
        long count = redPackageFieldMapper.countByExample(example);

        example.setOffset(request.start4Mysql());
        example.setLimit(request.getRows());

        List<RedPackageField> list = redPackageFieldMapper.selectByExample(example);

        List<RedPackageFieldDTO> dtoList;

        if (list != null && list.size() > 0) {
            dtoList = BeanConvUtil.copy(list, RedPackageFieldDTO.class);
        } else {
            dtoList = new ArrayList<>();
        }

        return ResultBuilder.succTPage(dtoList, request.getPage(), request.getRows(), (int) count);
    }
}
