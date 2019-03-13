package com.fulihui.redisdubbo.demo.producer.service;

import com.fulihui.redisdubbo.demo.api.api.UserFormService;
import com.fulihui.redisdubbo.demo.api.dto.UserFormIdDTO;
import com.fulihui.redisdubbo.demo.api.dto.UserFormRecordDTO;
import com.fulihui.redisdubbo.demo.api.enums.SwitchEnum;
import com.fulihui.redisdubbo.demo.api.request.UserFormInsertRequest;
import com.fulihui.redisdubbo.demo.api.request.UserFormInvalidRequest;
import com.fulihui.redisdubbo.demo.api.request.UserFormRequest;
import com.fulihui.redisdubbo.demo.producer.dal.dao.ExtUserFormRecordMapper;
import com.fulihui.redisdubbo.demo.producer.dal.dataobj.UserFormId;
import com.fulihui.redisdubbo.demo.producer.dal.dataobj.UserFormRecord;
import com.fulihui.redisdubbo.demo.producer.dal.dataobj.UserFormRecordExample;
import com.fulihui.redisdubbo.demo.producer.repository.UserFormRepository;
import com.fulihui.redisdubbo.demo.weixin.common.util.BeanConvUtil;
import org.apache.dubbo.config.annotation.Service;
import org.near.servicesupport.error.Errors;
import org.near.servicesupport.result.*;
import org.near.toolkit.common.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Calendar;
import java.util.List;

import static org.near.servicesupport.util.ServiceAssert.notBlank;
import static org.near.servicesupport.util.ServiceAssert.notNull;
import static org.springframework.util.CollectionUtils.isEmpty;

/**
 * @author lizhi
 * @date 2018-7-13
 */
@Service(version = "${demo.service.version}")

public class UserFormServiceImpl implements UserFormService {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderInfoServiceImpl.class);

    @Autowired
    UserFormRepository userFormRepository;

    @Autowired
    ExtUserFormRecordMapper recordMapper;

    @Override
    public TPageResult<UserFormRecordDTO> queryPage(UserFormRequest request) {

        notNull(request, Errors.Commons.REQUEST_PARAMETER_ERROR);
        UserFormRecordExample example = toExample(request);
        List<UserFormRecordDTO> list = userFormRepository.query(example);
        long count = 0;
        if (!isEmpty(list)) {
            count = userFormRepository.count(example);
        }
        return ResultBuilder.succTPage(list, request.getPage(), request.getRows(), (int) count);
    }

    @Override
    public BaseResult updateInvalid(UserFormInvalidRequest request) {
        notNull(request, Errors.Commons.REQUEST_PARAMETER_ERROR);
        notBlank(request.getFormStatus(), Errors.Commons.REQUEST_PARAMETER_ERROR);
        notNull(request.getDay(), Errors.Commons.REQUEST_PARAMETER_ERROR);
        try {
            userFormRepository.updateInvalid(request.getFormStatus(), request.getDay(),
                    request.getDesc());
            return ResultBuilder.succ();
        } catch (Exception e) {
            return ResultBuilder.fail(Errors.Commons.SYSTEM_ERROR);
        }
    }

    @Override
    public void setFormIdUsed(List<String> formIds, String desc) {
        recordMapper.updateFormIdState(formIds, SwitchEnum.DISABLE.getCode(), desc);

    }

    @Override
    public TSingleResult<Integer> insert(UserFormInsertRequest request) {
        notNull(request, Errors.Commons.REQUEST_PARAMETER_ERROR);
        UserFormRecord record = new UserFormRecord();
        record.setFormStatus(SwitchEnum.ENABLE.getCode());
        record.setAppId(request.getAppId());
        record.setOpenId(request.getOpenId());
        record.setUserId(request.getUserId());
        record.setFormId(request.getFormId());
        try {
            userFormRepository.insert(record);
            return ResultBuilder.succTSingle(record.getId());
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            return ResultBuilder.failTSingle(Errors.Commons.SYSTEM_ERROR);
        }
    }

    @Override
    public List<UserFormIdDTO> queryFormIdByUserIds(List<String> userIds) {

        Calendar dateNow = Calendar.getInstance();
        dateNow.add(Calendar.DATE, -7);

        List<UserFormId> userFormIds = recordMapper.queryFormIdByUserIds(userIds,
                dateNow.getTime());

        return BeanConvUtil.copy(userFormIds, UserFormIdDTO.class);
    }

    @Override
    public TMultiResult<UserFormRecordDTO> query(String userId, String code) {
        List<UserFormRecordDTO> query = userFormRepository.query(userId, code);
        return ResultBuilder.succTMulti(query);
    }

    private UserFormRecordExample toExample(UserFormRequest request) {
        UserFormRecordExample example = new UserFormRecordExample();
        UserFormRecordExample.Criteria criteria = example.createCriteria();
        if (request.getStartDate() != null && request.getEndDate() != null) {
            criteria.andCreateTimeBetween(request.getStartDate(), request.getEndDate());
        }
        if (StringUtil.isNotBlank(request.getStatus())) {
            criteria.andFormStatusEqualTo(request.getStatus());
        }
        return example;
    }
}
