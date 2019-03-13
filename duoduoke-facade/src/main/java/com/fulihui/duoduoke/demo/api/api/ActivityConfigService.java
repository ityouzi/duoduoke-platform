package com.fulihui.duoduoke.demo.api.api;


import com.fulihui.duoduoke.demo.api.enums.ActivityTypeEnum;
import com.fulihui.duoduoke.demo.api.request.ActivityConfigRequest;
import com.fulihui.duoduoke.demo.api.dto.ActivityConfigDTO;
import com.fulihui.duoduoke.demo.api.dto.ActivityConfigPrizeDTO;
import org.near.servicesupport.result.TPageResult;
import org.near.servicesupport.result.TSingleResult;

import java.util.List;

/**
 * @author: JY
 * @date: 2018/10/11 14:10
 */
public interface ActivityConfigService {

    TPageResult<ActivityConfigDTO> list(ActivityConfigRequest request);

    /**
     * 查询该活动已经停止的活动Id
     * @param activityTypeEnum
     * @return
     */
    TSingleResult<List<Integer>> getStopActivityIds(ActivityTypeEnum activityTypeEnum);

    /**
     * 插入数据
     * @param activityConfigDTO
     * @return
     */
    TSingleResult<Long> insert(ActivityConfigDTO activityConfigDTO);

    /**
     * 修改数据
     * @param activityConfigDTO
     * @return
     */
    TSingleResult<Long> update(ActivityConfigDTO activityConfigDTO);

    /**
     * 查询有效的活动
     * @param activityTypeEnum
     * @return
     */
    TSingleResult<ActivityConfigDTO> getByEnumType(ActivityTypeEnum activityTypeEnum);

    /**
     * 查询活动及活动商品
     * @param activityTypeEnum
     * @return
     */
    TSingleResult<ActivityConfigPrizeDTO> getUsingActivity(ActivityTypeEnum activityTypeEnum);

}
