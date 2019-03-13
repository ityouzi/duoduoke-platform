package com.fulihui.redisdubbo.demo.manager.impl;


import com.fulihui.redisdubbo.demo.api.api.ActivityConfigService;
import com.fulihui.redisdubbo.demo.api.dto.ActivityConfigDTO;
import com.fulihui.redisdubbo.demo.api.dto.ExemptionGoodsDTO;
import com.fulihui.redisdubbo.demo.api.dto.UserExemptionGoodsDTO;
import com.fulihui.redisdubbo.demo.api.enums.ExemptionGoodsStateEnum;
import com.fulihui.redisdubbo.demo.api.enums.UserExemptionStateEnum;
import com.fulihui.redisdubbo.demo.api.request.IdRequest;
import com.fulihui.redisdubbo.demo.integration.ExemptionServiceClient;
import com.fulihui.redisdubbo.demo.manager.AppConfigManager;
import com.fulihui.redisdubbo.demo.manager.ExemptionGoodsManager;
import com.fulihui.redisdubbo.demo.param.ExemptionGoodInfoParam;
import com.fulihui.redisdubbo.demo.util.Principal;
import com.fulihui.redisdubbo.demo.util.PrincipalUtil;
import com.fulihui.redisdubbo.demo.vo.UserExemptionVO;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.near.servicesupport.result.BaseResult;
import org.near.webmvcsupport.view.JsonResult;
import org.near.webmvcsupport.view.JsonResultBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author: xiaoming
 * @version: v 0.1 2018/11/14 0014 16:24
 */
@Component
public class ExemptionGoodsManagerImpl implements ExemptionGoodsManager {

    @Autowired
    ExemptionServiceClient exemptionServiceClient;

    @org.apache.dubbo.config.annotation.Reference(version = "1.0.0")
    ActivityConfigService activityConfigService;

    @Autowired
    AppConfigManager appConfigManager;

    @Autowired
    CuratorFramework curatorFramework;

    private static final Logger logger = LoggerFactory.getLogger(ExemptionGoodsManagerImpl.class);

    @Override
    public JsonResult robbingOrder(ExemptionGoodInfoParam param) {
        UserExemptionVO userExemptionVO = new UserExemptionVO();
        Principal principal = PrincipalUtil.getPrincipal();
        String userId = principal.getUserId();
        Integer activityId = param.getActivityId();
        Long goodsId = param.getGoodsId();
        Date now = new Date();
        //查询活动，判断活动状态
        String key = "/duoduokeLock/robbingOrder" + userId + goodsId;

        InterProcessMutex lock = new InterProcessMutex(curatorFramework, key);
        try {
            boolean acquire = lock.acquire(50, TimeUnit.SECONDS);
            logger.info(acquire ? "get lock success : " + key : "get lock failed : " + key);
            ActivityConfigDTO activityConfigDTO = exemptionServiceClient.queryActivity(activityId);
            if (activityConfigDTO != null) {
                Date endTime = activityConfigDTO.getEndTime();
                if (now.getTime() < endTime.getTime()) {
                    //活动进行中
                    IdRequest idRequest = new IdRequest();
                    Integer id = param.getId();
                    idRequest.setId(id);
                    ExemptionGoodsDTO exemptionGoodsDTO = exemptionServiceClient.select(idRequest);
                    if (exemptionGoodsDTO != null) {
                        Integer goodsState = exemptionGoodsDTO.getState();
                        if (ExemptionGoodsStateEnum.ON.getCode() == goodsState) {
                            //免单商品进行中
                            //判断用户是否有该商品免单资格
                            UserExemptionGoodsDTO dto = new UserExemptionGoodsDTO();
                            dto.setActivityId(activityId);
                            dto.setUserId(userId);
                            dto.setGoodsId(goodsId);
                            List<String> states = new ArrayList<>();
                            states.add(UserExemptionStateEnum.NOUSED.getCode());
                            states.add(UserExemptionStateEnum.USED.getCode());
                            states.add(UserExemptionStateEnum.SETTLE.getCode());
                            dto.setStates(states);
                            List<UserExemptionGoodsDTO> userExemptionGoodsDTOS = exemptionServiceClient
                                    .queryUserExemptionGoods(dto);
                            if (!CollectionUtils.isEmpty(userExemptionGoodsDTOS)) {
                                UserExemptionGoodsDTO userExemptionGoodsDTO = userExemptionGoodsDTOS
                                        .get(0);
                                if (userExemptionGoodsDTO != null) {
                                    String userState = userExemptionGoodsDTO.getState();
                                    if (userState.equals(UserExemptionStateEnum.NOUSED.getCode())) {
                                        userExemptionVO.setErrorCode("104");
                                        userExemptionVO.setErrorMessage("已有获得过免单抢购资格,如尚未下单,可继续下单");
                                    } else if (userState
                                            .equals(UserExemptionStateEnum.USED.getCode())
                                            || userState.equals(
                                            UserExemptionStateEnum.SETTLE.getCode())) {
                                        userExemptionVO.setErrorCode("105");
                                        userExemptionVO.setErrorMessage("本期您已抢过该商品的免单,每个商品限免单一件");
                                    }
                                }
                            } else {
                                //无该商品免单资格 判断商品剩余数量
                                Integer surplusNum = exemptionGoodsDTO.getSurplusNum();
                                if (surplusNum > 0) {
                                    // 商品剩余数量-1 ，领取数量 +1
                                    ExemptionGoodsDTO egoodsDto = new ExemptionGoodsDTO();
                                    egoodsDto.setId(exemptionGoodsDTO.getId());
                                    egoodsDto.setReceiveNum(1);
                                    egoodsDto.setSurplusNum(1);
                                    egoodsDto.setGmtReceive(new Date());

                                    //获取免单资格
                                    UserExemptionGoodsDTO userExemptionGoodsDTO = new UserExemptionGoodsDTO();
                                    userExemptionGoodsDTO.setUserId(userId);
                                    userExemptionGoodsDTO.setActivityId(activityId);
                                    userExemptionGoodsDTO.setGoodsId(goodsId);
                                    userExemptionGoodsDTO
                                            .setState(UserExemptionStateEnum.NOUSED.getCode());
                                    userExemptionGoodsDTO
                                            .setBackAmount(exemptionGoodsDTO.getBackAmount());
                                    userExemptionGoodsDTO
                                            .setPayAmount(exemptionGoodsDTO.getPayAmount());
                                    userExemptionGoodsDTO.setExemptionGoodsId(id);
                                    BaseResult result = exemptionServiceClient.robbingOrder(egoodsDto, userExemptionGoodsDTO);
                                    logger.info("抢单结果:{}",result.toString());
                                    if (result.getErrcode() == BaseResult.SUCCESS) {
                                        userExemptionVO.setSuccess(true);
                                    } else {
                                        return JsonResultBuilder.fail("1001", "抢单失败");
                                    }
                                } else {
                                    userExemptionVO.setErrorCode("106");
                                    userExemptionVO.setErrorMessage("来晚了,本免单商品已抢光");
                                }

                            }
                        } else {
                            userExemptionVO.setErrorCode("103");
                            userExemptionVO.setErrorMessage("来晚了,本免单商品已抢光");
                        }
                    } else {
                        userExemptionVO.setErrorCode("103");
                        userExemptionVO.setErrorMessage("来晚了,本免单商品已抢光");
                    }
                } else {
                    //已结束关闭
                    userExemptionVO.setErrorCode("102");
                    userExemptionVO.setErrorMessage("来晚了,本免单商品已抢光");
                }

            } else {
                userExemptionVO.setErrorCode("102");
                userExemptionVO.setErrorMessage("来晚了,本免单商品已抢光");
            }
            return JsonResultBuilder.succ(userExemptionVO);

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        } finally {
            try {
                lock.release();
            } catch (Exception e) {
                logger.error("lock.release error={}", e.getMessage(), e);
            }
        }
        return JsonResultBuilder.fail("101", "抢单失败");
    }

}
