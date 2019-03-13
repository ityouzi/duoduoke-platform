package com.fulihui.duoduoke.demo.producer.service;

import com.fulihui.duoduoke.demo.api.api.UserShareRecodeService;
import com.fulihui.duoduoke.demo.api.dto.UserShareRecordDTO;
import com.fulihui.duoduoke.demo.api.request.UserShareRecordRequest;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.UserShareRecord;
import com.fulihui.duoduoke.demo.producer.repository.UserShareRecodeRepository;
import org.apache.dubbo.config.annotation.Service;
import org.near.servicesupport.error.Errors;
import org.near.servicesupport.result.ResultBuilder;
import org.near.servicesupport.result.TSingleResult;
import org.near.servicesupport.util.ServiceAssert;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description:
 * @Author: xiaoming
 * @version: v 0.1 2018/8/2 0002 14:55
 */
@Service(version = "${demo.service.version}")


public class UserShareRecodeServiceImpl implements UserShareRecodeService {

    @Autowired
    private UserShareRecodeRepository userShareRecodeRepository;

    @Override
    public TSingleResult<UserShareRecordDTO> queryById(UserShareRecordRequest request) {
        ServiceAssert.notNull(request, Errors.Commons.REQUEST_PARAMETER_ERROR);
        UserShareRecord record = userShareRecodeRepository.selectByPrimaryKey(request.getId());
        if (record == null) {
            return ResultBuilder.succTSingle(null);
        }
        UserShareRecordDTO dto = new UserShareRecordDTO();
        BeanUtils.copyProperties(record, dto);
        return ResultBuilder.succTSingle(dto);
    }
}
