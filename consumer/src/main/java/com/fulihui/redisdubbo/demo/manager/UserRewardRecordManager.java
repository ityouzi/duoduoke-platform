package com.fulihui.redisdubbo.demo.manager;


import com.fulihui.redisdubbo.demo.vo.UserRewardInfoVO;
import com.fulihui.redisdubbo.demo.vo.UserRewardRecordVO;
import com.fulihui.redisdubbo.demo.vo.UserRewardVO;
import org.near.webmvcsupport.view.JsonResult;

import java.util.List;

/**
 * @Description:
 * @Author: xiaoming
 * @version: v 0.1 2018/9/3 0003 17:27
 */
public interface UserRewardRecordManager {

    JsonResult<UserRewardVO> insert(String helpUserId, String orderSn, String userId);

    List<UserRewardRecordVO> query(String orderSn);

    Double sumPercent(String orderSn, String userId);

    UserRewardInfoVO queryInfo(String rewardUserId, String orderSn, String userId);


}
