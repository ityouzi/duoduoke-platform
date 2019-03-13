package com.fulihui.duoduoke.demo.producer.service;

import com.fulihui.duoduoke.demo.api.api.ActivitySignPrizeService;
import com.fulihui.duoduoke.demo.api.dto.ActivitySignPrizeDTO;
import com.fulihui.duoduoke.demo.api.request.ActivitySignPrizeRequest;
import com.fulihui.duoduoke.demo.producer.dal.dao.ActivitySignPrizeMapper;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.ActivitySignPrize;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.ActivitySignPrizeExample;
import com.fulihui.duoduoke.demo.common.util.BeanConvUtil;
import org.apache.dubbo.config.annotation.Service;
import org.near.servicesupport.result.ResultBuilder;
import org.near.servicesupport.result.TMultiResult;
import org.near.servicesupport.result.TSingleResult;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;


/**
 * @author: JY
 * @date: 2018/10/11 14:16
 */
@Service(version = "${demo.service.version}")

public class ActivitySignPrizeServiceImpl implements ActivitySignPrizeService {

    @Autowired
    ActivitySignPrizeMapper activitySignPrizeMapper;

    @Override
    public TMultiResult<ActivitySignPrizeDTO> list(ActivitySignPrizeRequest request) {

        ActivitySignPrizeExample example = new ActivitySignPrizeExample();

        ActivitySignPrizeExample.Criteria criteria = example.createCriteria();
        criteria.andActivityIdEqualTo(request.getActivityId());

        List<ActivitySignPrize> activityConfigs = activitySignPrizeMapper.selectByExample(example);

        List<ActivitySignPrizeDTO> result = null;
        if (activityConfigs != null && activityConfigs.size() > 0) {
            result = BeanConvUtil.copy(activityConfigs, ActivitySignPrizeDTO.class);
        }

        return ResultBuilder.succTMulti(result);
    }

    @Override
    public TSingleResult<Boolean> insert(ActivitySignPrizeDTO signPrizeDTO) {

        ActivitySignPrize model = BeanConvUtil.copy(signPrizeDTO, ActivitySignPrize.class);

        model.setGmtCreate(new Date());
        model.setGmtModified(new Date());

        //插入数据
        boolean success = activitySignPrizeMapper.insert(model) > 0;

        return ResultBuilder.succTSingle(success);
    }

    @Override
    public TSingleResult<Boolean> update(ActivitySignPrizeDTO signPrizeDTO) {

        ActivitySignPrize model = BeanConvUtil.copy(signPrizeDTO, ActivitySignPrize.class);

        model.setGmtModified(new Date());

        //插入数据
        boolean success = activitySignPrizeMapper.updateByPrimaryKeySelective(model) > 0;

        return ResultBuilder.succTSingle(success);
    }


}
