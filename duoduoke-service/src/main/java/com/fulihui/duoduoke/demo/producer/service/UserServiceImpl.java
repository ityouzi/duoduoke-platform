/*
 * Copyright (c) 2017.  Willard Hu. All rights reserved.
 */

package com.fulihui.duoduoke.demo.producer.service;


import com.fulihui.duoduoke.demo.api.api.UserService;
import com.fulihui.duoduoke.demo.api.dto.UserDTO;
import com.fulihui.duoduoke.demo.api.dto.UserDetailAdminDTO;
import com.fulihui.duoduoke.demo.api.dto.WechatAuthDTO;
import com.fulihui.duoduoke.demo.api.enums.TemplateSendTaskBehaviorsEnum;
import com.fulihui.duoduoke.demo.api.enums.UserTypeEnum;
import com.fulihui.duoduoke.demo.api.request.UserDetailAdminRequest;
import com.fulihui.duoduoke.demo.api.request.UserQueryRequest;
import com.fulihui.duoduoke.demo.api.request.UserUpdateRequest;
import com.fulihui.duoduoke.demo.api.request.UserWechatLoginRequest;
import com.fulihui.duoduoke.demo.api.util.Collections;
import com.fulihui.duoduoke.demo.common.sequence.ConcurrentSequence;
import com.fulihui.duoduoke.demo.common.util.BeanConvUtil;
import com.fulihui.duoduoke.demo.common.util.RedisUtils;
import com.fulihui.duoduoke.demo.producer.dal.dao.ExtUserDetailMapper;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.UserDetail;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.UserDetailAdmin;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.UserDetailExample;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.WechatAuth;
import com.fulihui.duoduoke.demo.producer.lock.DistributedLock;
import com.fulihui.duoduoke.demo.producer.manager.PassiveTaskDefinition;
import com.fulihui.duoduoke.demo.producer.manager.UserFansManager;
import com.fulihui.duoduoke.demo.producer.model.UserModel;
import com.fulihui.duoduoke.demo.producer.repository.UserRepository;
import com.fulihui.duoduoke.demo.producer.repository.WechatAuthRepository;
import com.google.common.collect.Lists;
import org.apache.commons.codec.binary.Base64;
import org.apache.dubbo.config.annotation.Service;
import org.near.servicesupport.error.Errors;
import org.near.servicesupport.error.InvokeServiceException;
import org.near.servicesupport.result.*;
import org.near.servicesupport.util.ServiceAssert;
import org.near.toolkit.common.EnumUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.near.servicesupport.error.Errors.Commons.REQUEST_PARAMETER_ERROR;
import static org.near.servicesupport.error.Errors.Commons.SYSTEM_ERROR;
import static org.near.servicesupport.result.ResultBuilder.succTMulti;
import static org.near.servicesupport.result.ResultBuilder.succTPage;
import static org.near.toolkit.common.StringUtil.*;

/**
 * @author lizhi
 */
@Service(version = "${demo.service.version}")
public class UserServiceImpl implements UserService {

    public static final String GROUP = "DUODUO_KE";
    private static final String DUODUO_KE_USER = GROUP + ":DUODUO_KE_USER_USERREFEREE_";

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    PassiveTaskDefinition passiveTaskDefinition;
    @Autowired
    RedisUtils redisUtils;
    @Autowired
    private WechatAuthRepository wechatRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ConcurrentSequence concurrentSequence;
    @Autowired
    private UserFansManager userFansManager;
    @Autowired
    private ExtUserDetailMapper extUserDetailMapper;

    @Resource
    DistributedLock zookeeperDistributedLock;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public TSingleResult<UserDTO> wechatLogin(UserWechatLoginRequest request) {
        ServiceAssert.notNull(request, Errors.Commons.REQUEST_PARAMETER_ERROR);
        ServiceAssert.notBlank(request.getUserType(), Errors.Commons.REQUEST_PARAMETER_ERROR);

        String key = "wechatLogin_userInfo_" + request.getOpenId();
        boolean lockResult = zookeeperDistributedLock.lock(key, 3000);
        LOGGER.info(lockResult ? "order_sn_userInfo_.get lock success : " + key
                : "get lock failed : " + key);
        UserDTO res = null;
        if (lockResult) {
            try {
                UserTypeEnum userType = EnumUtil.queryByCode(request.getUserType(), UserTypeEnum.class);
                WechatAuthDTO weChat = wechatRepository.queryByOpenId(request.getOpenId(), userType);
                Date date = new Date();
                // 已注册
                if (weChat != null) {
                    res = userRepository.queryByUserId(weChat.getUserId());
                    if (res == null) {
                        String userId = takeUser(request, date, weChat.getUserId());
                        res = userRepository.queryByUserId(userId);
                    }
                } else { // 未注册
                    String userId = takeUser(request, date, String.valueOf(concurrentSequence.nextId()));
                    WechatAuth wRecord = new WechatAuth();
                    wRecord.setOpenId(request.getOpenId());
                    wRecord.setAppid(request.getAppid());
                    wRecord.setUnionid(request.getUnionid());
                    wRecord.setUserId(userId);
                    wRecord.setUserType(userType.getCode());
                    wechatRepository.insert(wRecord, null);
                    res = userRepository.queryByUserId(userId);

                }
            } catch (Exception e) {
                LOGGER.error(e.getMessage(), e);
            } finally {
                zookeeperDistributedLock.releaseLock(key);
                LOGGER.info("wechatLogin_userInfo_.release lock : " + key);
            }
        }
        return ResultBuilder.succTSingle(res);
    }

    private String takeUser(UserWechatLoginRequest request, Date date, String userId) {

        UserDetail uRecord = new UserDetail();
        uRecord.setUserId(userId);
        uRecord.setNickname(request.getNickName());
        uRecord.setGender(request.getGender());
        //用户来源
        uRecord.setUserSource(request.getUserSource());
        uRecord.setRegUrl(request.getRegUrl());
        uRecord.setRegDate(date);

        //用户推荐人
        String userReferee = request.getUserReferee();
        //如果上级不为空

        if (isNotBlank(userReferee)) {
            UserDTO dto = userRepository.queryByUserId(userReferee);
            if (dto != null) {
                String userRefereeIds = dto.getUserRefereeIds();
                uRecord.setUserReferee(userReferee);
                String str = isBlank(userRefereeIds) ? "" : userRefereeIds;
                uRecord.setUserRefereeIds("," + userReferee + str);
            }
        }
        userRepository.insert(uRecord, null);
        //如果上级不为空
        if (isNotBlank(userReferee)) {
            userFansManager.saveFansNum(date, userReferee);
        }
        return userId;
    }

    @Override
    public TSingleResult<UserDTO> queryByUserId(String userId) {
        return ResultBuilder.succTSingle(userRepository.queryByUserId(userId));
    }

    @Override
    public BaseResult update(UserUpdateRequest request) {
        ServiceAssert.notNull(request, REQUEST_PARAMETER_ERROR);
        ServiceAssert.notBlank(request.getUserId(), REQUEST_PARAMETER_ERROR);
        TSingleResult<UserDTO> result = queryByUserId(request.getUserId());
        UserDTO dto = result.getValue();
        if (result.getValue() == null) {
            throw new InvokeServiceException(SYSTEM_ERROR.getErrcode(), SYSTEM_ERROR.getErrmsg());
        }

        if (isNotBlank(dto.getGender()) && isNotBlank(dto.getNickname())
                && isNotBlank(dto.getAvatarUrl())) {
            return ResultBuilder.succ();
        }
        UserDetail detail = new UserDetail();
        detail.setUserId(request.getUserId());
        detail.setGender(request.getGender());
        detail.setAvatarUrl(request.getAvatarUrl());
        if (isNotBlank(request.getNickName())) {
            detail.setNickname(Base64.encodeBase64String(request.getNickName().getBytes()));
        }
        userRepository.update(detail, "SYSTEM");
        return ResultBuilder.succ();
    }

    @Override
    public TPageResult<UserDTO> queryPage(UserQueryRequest request) {

        UserDetailExample example = new UserDetailExample();
        example.setOffset(request.start4Mysql());
        example.setLimit(request.getRows());

        if (isNotBlank(request.getSortInfo())) {
            example.setOrderByClause(request.getSortInfo());
        }

        UserDetailExample.Criteria criteria = example.createCriteria();

        if (isNotBlank(request.getUserId())) {
            criteria.andUserIdEqualTo(request.getUserId());
        }
        //推荐人
        if (!CollectionUtils.isEmpty(request.getUserReferee())) {
            criteria.andUserRefereeIn(request.getUserReferee());
        }
        List<UserDTO> list = userRepository.query(example);
        if (Collections.isEmpty(list)) {
            return succTPage(Lists.newArrayList(), request.getPage(), request.getRows(), 0);
        }

        long count = userRepository.count(example);
        return succTPage(list, request.getPage(), request.getRows(), (int) count);
    }

    @Override
    public TMultiResult<UserDTO> query(UserQueryRequest request) {
        UserDetailExample example = new UserDetailExample();
        //推荐人
        UserDetailExample.Criteria criteria = example.createCriteria();
        if (!CollectionUtils.isEmpty(request.getUserReferee())) {
            criteria.andUserRefereeIn(request.getUserReferee());
        }
        List<UserDTO> list = userRepository.query(example);
        return succTMulti(list);
    }

    @Override
    public TPageResult<UserDetailAdminDTO> queryAdminList(UserDetailAdminRequest adminRequest) {

        Map<String, Object> queryParams = new HashMap<>();

        if (isNotEmpty(adminRequest.getUserId())) {
            queryParams.put("userId", adminRequest.getUserId());
        }
        if (isNotEmpty(adminRequest.getUserReferee())) {
            queryParams.put("userReferee", adminRequest.getUserReferee());
        }
        if (adminRequest.getStartTime() != null) {
            queryParams.put("startTime", adminRequest.getStartTime());
        }
        if (adminRequest.getEndTime() != null) {
            queryParams.put("endTime", adminRequest.getEndTime());
        }
        queryParams.put("offset", adminRequest.start4Mysql());
        queryParams.put("rows", adminRequest.getRows());

        List<UserDetailAdmin> userDetailAdmins = extUserDetailMapper.queryAdminList(queryParams);

        List<UserDetailAdminDTO> result = null;

        //总条数
        int totalCount = 0;

        if (userDetailAdmins != null) {
            result = BeanConvUtil.copy(userDetailAdmins, UserDetailAdminDTO.class);
            totalCount = extUserDetailMapper.count(queryParams);
        }

        return ResultBuilder.succTPage(result, adminRequest.getPage(), adminRequest.getRows(),
                totalCount);
    }

    @Override
    public void recordUserBehaviors(UserDTO userDTO, TemplateSendTaskBehaviorsEnum behaviorsEnum,
                                    UserTypeEnum userType) {

        UserModel userModel = new UserModel();
        userModel.setBehaviorTime(new Date());
        userModel.setUserBehaviors(behaviorsEnum);
        userModel.setUserId(userDTO.getUserId());
        userModel.setUserSex(userDTO.getGender());
        userModel.setUserType(userType);
        //添加发送任务
        passiveTaskDefinition.putUser(userModel);
    }

}
