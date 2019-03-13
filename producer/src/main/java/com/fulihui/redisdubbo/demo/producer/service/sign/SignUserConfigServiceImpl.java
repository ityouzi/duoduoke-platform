package com.fulihui.redisdubbo.demo.producer.service.sign;


import com.fulihui.redisdubbo.demo.api.api.sign.SignUserConfigService;
import com.fulihui.redisdubbo.demo.api.dto.sign.SignUserConfigDTO;
import com.fulihui.redisdubbo.demo.api.enums.SwitchEnum;
import com.fulihui.redisdubbo.demo.producer.dal.dao.SignUserConfigMapper;
import com.fulihui.redisdubbo.demo.producer.dal.dataobj.SignUserConfig;
import org.apache.dubbo.config.annotation.Service;
import org.near.servicesupport.error.Errors;
import org.near.servicesupport.result.ResultBuilder;
import org.near.servicesupport.result.TSingleResult;
import org.near.servicesupport.util.ServiceAssert;
import org.near.toolkit.common.StringUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * @author lizhi
 * @date 2018-10-11
 */
@Service(version = "${demo.service.version}")
public class SignUserConfigServiceImpl implements SignUserConfigService {
    @Autowired
    SignUserConfigMapper signUserConfigMapper;

    @Override
    public TSingleResult<SignUserConfigDTO> takeUserConfig(String userId) {
        ServiceAssert.notBlank(userId, Errors.Commons.REQUEST_PARAMETER_ERROR);
        SignUserConfigDTO dto = new SignUserConfigDTO();
        SignUserConfig userConfig = signUserConfigMapper.selectByPrimaryKey(userId);
        if (userConfig != null) {
            BeanUtils.copyProperties(userConfig, dto);
        } else {
            SignUserConfig config = new SignUserConfig();
            config.setState(SwitchEnum.ENABLE.getCode());
            config.setUserId(userId);
            config.setGmtModified(new Date());
            config.setGmtCreate(new Date());
            signUserConfigMapper.insertSelective(config);
            BeanUtils.copyProperties(config, dto);
        }
        return ResultBuilder.succTSingle(dto);
    }

    @Override
    public TSingleResult<SignUserConfigDTO> updateUserConfig(String userId, String state) {
        ServiceAssert.notBlank(userId, Errors.Commons.REQUEST_PARAMETER_ERROR);
        ServiceAssert.notBlank(state, Errors.Commons.REQUEST_PARAMETER_ERROR);
        SignUserConfig userConfig = signUserConfigMapper.selectByPrimaryKey(userId);
        if (userConfig == null) {
            return ResultBuilder.failTSingle(Errors.Commons.SYSTEM_ERROR);
        }

        if (StringUtil.equals(userConfig.getState(), state)) {
            // TODO: 2018-10-11
        }

        SignUserConfig config = new SignUserConfig();
        config.setUserId(userId);
        config.setState(state);
        config.setGmtModified(new Date());
        signUserConfigMapper.updateByPrimaryKeySelective(config);
        SignUserConfigDTO dto = new SignUserConfigDTO();
        dto.setGmtModified(config.getGmtModified());
        dto.setState(state);
        dto.setUserId(userId);
        return ResultBuilder.succTSingle(dto);
    }
}
