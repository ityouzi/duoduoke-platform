package com.fulihui.duoduoke.demo.producer.service;

import com.fulihui.duoduoke.demo.api.api.ActivityConfigService;
import com.fulihui.duoduoke.demo.api.dto.ActivityConfigDTO;
import com.fulihui.duoduoke.demo.api.dto.ActivityConfigPrizeDTO;
import com.fulihui.duoduoke.demo.api.dto.ActivitySignPrizeDTO;
import com.fulihui.duoduoke.demo.api.enums.ActivityStateEnum;
import com.fulihui.duoduoke.demo.api.enums.ActivityTypeEnum;
import com.fulihui.duoduoke.demo.api.request.ActivityConfigRequest;
import com.fulihui.duoduoke.demo.producer.dal.dao.ActivityConfigMapper;
import com.fulihui.duoduoke.demo.producer.dal.dao.ExtActivityConfigMapper;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.ActivityConfig;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.ActivityConfigExample;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.ExtActivityConfig;
import com.fulihui.duoduoke.demo.common.util.BeanConvUtil;
import org.apache.dubbo.config.annotation.Service;
import org.near.servicesupport.result.ResultBuilder;
import org.near.servicesupport.result.TPageResult;
import org.near.servicesupport.result.TSingleResult;
import org.near.toolkit.common.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @author: JY
 * @date: 2018/10/11 14:09
 */
@Service(version = "${demo.service.version}")
public class ActivityConfigServiceImpl implements ActivityConfigService {

    @Autowired
    ActivityConfigMapper activityConfigMapper;

    @Autowired
    ExtActivityConfigMapper extActivityConfigMapper;

    @Override
    public TPageResult<ActivityConfigDTO> list(ActivityConfigRequest request) {

        ActivityConfigExample example = new ActivityConfigExample();

        ActivityConfigExample.Criteria criteria = example.createCriteria();

        if (request.getType() != null) {
            criteria.andTypeEqualTo(request.getType());
        }
        if (request.getId() != null) {
            criteria.andIdEqualTo(request.getId());
        }
        if (request.getState() != null) {
            criteria.andStateEqualTo(request.getState());
        }
        if (request.getStartTime() != null) {
            criteria.andStartTimeLessThan(request.getStartTime());
        }
        if (request.getEndTime() != null) {
            criteria.andStartTimeGreaterThan(request.getEndTime());
        }

        //总条数
        Long count = activityConfigMapper.countByExample(example);

        //分页查询
        example.setLimit(request.getRows());
        example.setOffset(request.start4Mysql());

        List<ActivityConfig> activityConfigs = activityConfigMapper.selectByExample(example);

        List<ActivityConfigDTO> result = null;
        if (activityConfigs != null && activityConfigs.size() > 0) {
            result = BeanConvUtil.copy(activityConfigs, ActivityConfigDTO.class);
        }

        return ResultBuilder.succTPage(result, request.getPage(), request.getRows(),
                count.intValue());
    }

    @Override
    public TSingleResult<List<Integer>> getStopActivityIds(ActivityTypeEnum activityTypeEnum) {

        ActivityConfigExample example = new ActivityConfigExample();

        ActivityConfigExample.Criteria criteria = example.createCriteria();
        criteria.andTypeEqualTo(Integer.parseInt(activityTypeEnum.getCode()));
        criteria.andEndTimeLessThan(new Date());
        criteria.andStateEqualTo(ActivityStateEnum.ON.getCode());

        //查询数据
        List<ActivityConfig> activityConfigs = activityConfigMapper.selectByExample(example);

        //获取Id
        List<Integer> idArray = activityConfigs.stream().map(ActivityConfig::getId).collect(Collectors.toList());

        return ResultBuilder.succTSingle(idArray);
    }

    @Override
    public TSingleResult<Long> insert(ActivityConfigDTO activityConfigDTO) {

        ActivityConfig model = BeanConvUtil.copy(activityConfigDTO, ActivityConfig.class);

        //查询活动是否冲突
        TSingleResult<Boolean> hasConflict = queryConflict(model);

        TSingleResult<Long> result = ResultBuilder.succTSingle(-1L);

        if (!hasConflict.getValue()) {
            result.setErrmsg(hasConflict.getErrmsg());
            return result;
        }

        model.setGmtCreate(new Date());
        model.setGmtModified(new Date());

        //插入数据
        activityConfigMapper.insert(model);

        return ResultBuilder.succTSingle((long) model.getId());
    }

    @Override
    public TSingleResult<Long> update(ActivityConfigDTO activityConfigDTO) {

        ActivityConfig model = BeanConvUtil.copy(activityConfigDTO, ActivityConfig.class);

        //查询活动是否冲突
        TSingleResult<Boolean> hasConflict = queryConflict(model);

        TSingleResult<Long> result = ResultBuilder.succTSingle(-1L);

        if (!hasConflict.getValue()) {
            result.setErrmsg(hasConflict.getErrmsg());
            return result;
        }

        model.setGmtModified(new Date());
        activityConfigMapper.updateByPrimaryKeySelective(model);

        return ResultBuilder.succTSingle((long) model.getId());
    }

    /**
     * 当前查询有效的活动
     *
     * @param activityTypeEnum
     * @return
     */
    @Override
    public TSingleResult<ActivityConfigDTO> getByEnumType(ActivityTypeEnum activityTypeEnum) {

        ActivityConfigExample configExample = new ActivityConfigExample();
        ActivityConfigExample.Criteria criteria = configExample.createCriteria();
        criteria.andTypeEqualTo(Integer.parseInt(activityTypeEnum.getCode()));
        //开始时间小于当前时间
        criteria.andStartTimeLessThanOrEqualTo(new Date());
        //结束时间大于当前时间
        criteria.andEndTimeGreaterThanOrEqualTo(new Date());

        List<ActivityConfig> list = activityConfigMapper.selectByExample(configExample);

        if (list != null && list.size() > 0) {
            return ResultBuilder.succTSingle(BeanConvUtil.copy(list.get(0), ActivityConfigDTO.class));
        }

        return ResultBuilder.succTSingle(null);
    }

    /**
     * 当前有效的活动和活动商品
     *
     * @param activityTypeEnum
     * @return
     */
    @Override
    public TSingleResult<ActivityConfigPrizeDTO> getUsingActivity(ActivityTypeEnum activityTypeEnum) {

        ExtActivityConfig model = extActivityConfigMapper.queryUsingActivity(Integer.parseInt(activityTypeEnum.getCode()));

        ActivityConfigPrizeDTO result = null;

        if (model != null) {
            result = BeanConvUtil.copy(model, ActivityConfigPrizeDTO.class);
            result.setActivityPrize(BeanConvUtil.copy(model.getActivityPrize(), ActivitySignPrizeDTO.class));
        }

        return ResultBuilder.succTSingle(result);
    }

    /**
     * 查询冲突的活动
     *
     * @param model
     * @return
     */
    private TSingleResult<Boolean> queryConflict(ActivityConfig model) {

        TSingleResult<Boolean> result = ResultBuilder.succTSingle(true);

        //活动设为启动时 查询时间范围冲突的活动
        if (model.getState() == 1) {
            List<ActivityConfig> activityConfigs = extActivityConfigMapper.queryConflict(model.getStartTime(), model.getEndTime(), model.getType());


            if (model.getId() > 0) {
                //排除当前活动
                activityConfigs = activityConfigs.stream().filter((item) -> {
                    return !item.getId().equals(model.getId());
                }).collect(Collectors.toList());
            }

            if (activityConfigs.size() > 0) {
                result.setValue(false);
                //拼接字符串
                StringBuilder stringBuilder = new StringBuilder();
                for (ActivityConfig item : activityConfigs) {
                    stringBuilder.append("【" + item.getTitle() + "（" + DateUtils.format(item.getStartTime(), "yyyy-MM-dd HH:mm:ss") + "-" + DateUtils.format(item.getEndTime(), "yyyy-MM-dd HH:mm:ss") + "）】\n");
                }
                result.setErrmsg(stringBuilder.toString());
            }
        }

        return result;
    }
}
