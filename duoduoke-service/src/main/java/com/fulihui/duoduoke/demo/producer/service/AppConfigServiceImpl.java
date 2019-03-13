package com.fulihui.duoduoke.demo.producer.service;

import com.fulihui.duoduoke.demo.api.api.AppConfigService;
import com.fulihui.duoduoke.demo.api.dto.AppConfigDTO;
import com.fulihui.duoduoke.demo.api.enums.AppConfigEnum;
import com.fulihui.duoduoke.demo.api.request.AppConfigRequest;
import com.fulihui.duoduoke.demo.producer.dal.dao.AppConfigMapper;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.AppConfig;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.AppConfigExample;
import com.fulihui.duoduoke.demo.common.util.RedisUtils;
import org.apache.dubbo.config.annotation.Service;
import org.near.servicesupport.result.ResultBuilder;
import org.near.servicesupport.result.TMultiResult;
import org.near.servicesupport.result.TSingleResult;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


/**
 * @author: JY
 * @date: 2018/7/26 13:43
 */
@Service(version = "${demo.service.version}")

public class AppConfigServiceImpl implements AppConfigService {

    private static final String APP_CONFIG_KEY = "APP_CONFIG_KEY_";
    @Autowired
    AppConfigMapper appConfigMapper;
    @Autowired
    RedisUtils redisUtils;

    /**
     * 获取单个详情
     *
     * @param configEnum
     * @return
     */
    @Override
    public TSingleResult<AppConfigDTO> getModel(AppConfigEnum configEnum) {

        AppConfig appConfig = appConfigMapper
                .selectByPrimaryKey(Integer.parseInt(configEnum.getCode()));

        AppConfigDTO configDTO = null;

        if (appConfig != null) {
            configDTO = new AppConfigDTO();
            BeanUtils.copyProperties(appConfig, configDTO);
        }
        return ResultBuilder.succTSingle(configDTO);
    }

    @Override
    public TSingleResult<Boolean> modify(AppConfigDTO appConfigDTO) {
        AppConfig model = new AppConfig();
        BeanUtils.copyProperties(appConfigDTO, model);
        model.setGmtModified(Calendar.getInstance().getTime());
        return ResultBuilder.succTSingle(appConfigMapper.updateByPrimaryKeySelective(model) > 0);
    }

    /**
     * 查询列表
     *
     * @param request
     * @return
     */
    @Override
    public TMultiResult<AppConfigDTO> getList(AppConfigRequest request) {
        //拼接条件
        AppConfigExample configExample = new AppConfigExample();
        AppConfigExample.Criteria criteria = configExample.createCriteria();
        if (request.getId() != null) {
            criteria.andIdEqualTo(request.getId());
        }

        //查询
        List<AppConfig> appConfigs = appConfigMapper.selectByExample(configExample);

        List<AppConfigDTO> listResult = new ArrayList<>();
        //数据转换
        if (appConfigs != null && appConfigs.size() > 0) {
            appConfigs.forEach((item) -> {
                AppConfigDTO configDTO = new AppConfigDTO();
                BeanUtils.copyProperties(item, configDTO);
                listResult.add(configDTO);
            });
        }
        return ResultBuilder.succTMulti(listResult);
    }

    /**
     * 获取缓存的值
     *
     * @return
     */
    @Override
    public TSingleResult<Long> getCacheCommision() {

        Integer commissionVal = (Integer) redisUtils
                .get(APP_CONFIG_KEY + AppConfigEnum.COMMISSION_PERCENTAGE.getCode());

        if (commissionVal == null) {
            //数据库查询
            AppConfig appConfig = appConfigMapper.selectByPrimaryKey(
                    Integer.parseInt(AppConfigEnum.COMMISSION_PERCENTAGE.getCode()));
            if (appConfig != null) {
                commissionVal = Integer.parseInt(appConfig.getConfigVal());
                //设置redis
                redisUtils.set(APP_CONFIG_KEY + AppConfigEnum.COMMISSION_PERCENTAGE.getCode(),
                        commissionVal, getPastTime());
            }
        }
        assert commissionVal != null;
        return ResultBuilder.succTSingle(commissionVal.longValue());
    }

    /**
     * 获取当前时间距离固定时间段剩余的秒数
     *
     * @return
     */
    private Long getPastTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        return (calendar.getTime().getTime() - Calendar.getInstance().getTime().getTime()) / 1000;
    }

}
