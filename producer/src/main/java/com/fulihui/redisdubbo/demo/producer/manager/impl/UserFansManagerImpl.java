package com.fulihui.redisdubbo.demo.producer.manager.impl;


import com.fulihui.redisdubbo.demo.api.dto.UserDTO;
import com.fulihui.redisdubbo.demo.api.dto.UserFansDetailDTO;
import com.fulihui.redisdubbo.demo.producer.dal.dataobj.UserDetailExample;
import com.fulihui.redisdubbo.demo.producer.dal.dataobj.UserFansDetail;
import com.fulihui.redisdubbo.demo.producer.lock.DistributedLock;
import com.fulihui.redisdubbo.demo.producer.manager.UserFansManager;
import com.fulihui.redisdubbo.demo.producer.repository.UserFansDetailRepository;
import com.fulihui.redisdubbo.demo.producer.repository.UserRepository;
import com.fulihui.redisdubbo.demo.producer.util.Consts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static com.fulihui.redisdubbo.demo.api.util.Collections.isEmpty;
import static com.google.common.collect.Lists.newArrayList;

/**
 * The type Order fans detail manager.
 *
 * @author lizhi
 * @date 2018 -8-2
 */
@Component
public class UserFansManagerImpl implements UserFansManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserFansManagerImpl.class);

    private static final Logger ORDER_FANS_BIZ = LoggerFactory
            .getLogger(Consts.LoggerName.ORDER_FANS_BIZ);

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserFansDetailRepository userFansDetailRepository;
    @Resource
    DistributedLock zookeeperDistributedLock;

    private void takeFansNum(String userReferee, Integer oneFansNum, Integer twoFansNum,
                             Date date) {

        List<UserFansDetailDTO> list = userFansDetailRepository.query(userReferee, date);
        if (isEmpty(list)) {
            UserFansDetail userFansDetail = new UserFansDetail();
            userFansDetail.setStatisticsDate(date);
            userFansDetail.setUserId(userReferee);
            userFansDetail.setOneFansNum(oneFansNum);
            userFansDetail.setTwoFansNum(twoFansNum);
            userFansDetailRepository.insert(userFansDetail);
        } else {
            UserFansDetailDTO dto = list.get(0);
            UserFansDetail userFansDetail = new UserFansDetail();
            userFansDetail.setId(dto.getId());
            userFansDetail.setOneFansNum(oneFansNum);
            userFansDetail.setTwoFansNum(twoFansNum);
            userFansDetailRepository.update(userFansDetail);
        }
    }

    private void takeFansNumTwoFansNum(String userReferee,

                                       Integer twoFansNum, Date date) {

        List<UserFansDetailDTO> list = userFansDetailRepository.query(userReferee, date);
        if (isEmpty(list)) {
            UserFansDetail userFansDetail = new UserFansDetail();
            userFansDetail.setStatisticsDate(date);
            userFansDetail.setUserId(userReferee);
            userFansDetail.setTwoFansNum(twoFansNum);
            userFansDetailRepository.insert(userFansDetail);
        } else {
            UserFansDetailDTO dto = list.get(0);
            UserFansDetail userFansDetail = new UserFansDetail();
            userFansDetail.setId(dto.getId());
            userFansDetail.setTwoFansNum(twoFansNum);
            userFansDetailRepository.update(userFansDetail);
        }
    }

    private List<UserDTO> query(List<String> userReferee, Date regDate) {
        UserDetailExample example = new UserDetailExample();
        example.createCriteria().andUserRefereeIn(userReferee).andRegDateEqualTo(regDate);
        return userRepository.query(example);
    }

    private long count(List<String> userReferee, Date regDate) {
        UserDetailExample example = new UserDetailExample();
        example.createCriteria().andUserRefereeIn(userReferee).andRegDateEqualTo(regDate);
        return userRepository.count(example);
    }

    @Override
    public void saveFansNum(Date date, String userReferee) {
        String key = "lock_userReferee_" + userReferee;
        boolean result = zookeeperDistributedLock.lock(key, 5000);
        ORDER_FANS_BIZ.info(result ? "get lock success : " + key : "get lock failed : " + key);
        if (result) {
            try {
                //这是一级粉丝数量
                int oneFansNum = 0;
                //这是二级粉丝数量
                int twoFansNum = 0;
                //统计当前注册用户的上一级的推荐人 下面的一级粉丝数量
                List<UserDTO> list = query(newArrayList(userReferee), date);
                if (!isEmpty(list)) {
                    oneFansNum = list.size();
                }
                //当前注册用户的上一级的推荐人  下面的二级粉丝数量
                List<String> collect = list.stream().map(UserDTO::getUserId)
                        .collect(Collectors.toList());
                if (!isEmpty(collect)) {
                    twoFansNum = (int) count(collect, date);
                }
                takeFansNum(userReferee, oneFansNum, twoFansNum, date);
                //根据推荐人查询推荐人主体信息 查看推荐人挂靠的
                UserDTO dto = userRepository.queryByUserId(userReferee);
                if (dto != null) {
                    List<UserDTO> twoFansNumList = query(newArrayList(dto.getUserReferee()), date);
                    if (!CollectionUtils.isEmpty(twoFansNumList)) {
                        List<String> twoFansNumCollect = twoFansNumList.stream().map(UserDTO::getUserId)
                                .collect(Collectors.toList());
                        takeFansNumTwoFansNum(dto.getUserReferee(),
                                (int) count(twoFansNumCollect, date), date);
                    }
                }
            } catch (Exception e) {
                LOGGER.error(e.getMessage(), e);
            } finally {
                zookeeperDistributedLock.releaseLock(key);
                ORDER_FANS_BIZ.info("release lock : " + key);
            }
        }
    }

    @Override
    public void saveAmountOrderNum(Date date, Integer orderNum, Integer subsidyAmount,
                                   String userReferee) {
        List<UserFansDetailDTO> list = userFansDetailRepository.query(userReferee, date);
        if (isEmpty(list)) {
            UserFansDetail userFansDetail = new UserFansDetail();
            userFansDetail.setStatisticsDate(date);
            userFansDetail.setUserId(userReferee);
            userFansDetail.setOneFansNum(0);
            userFansDetail.setTwoFansNum(0);
            userFansDetail.setOrderNum(orderNum);
            userFansDetail.setSubsidyAmount(subsidyAmount);
            userFansDetailRepository.insert(userFansDetail);
        } else {
            UserFansDetailDTO dto = list.get(0);
            UserFansDetail userFansDetail = new UserFansDetail();
            userFansDetail.setId(dto.getId());
            ORDER_FANS_BIZ.debug("dto:{}", dto);
            if (dto.getSubsidyAmount() == null) {
                userFansDetail.setSubsidyAmount(subsidyAmount == null ? 0 : subsidyAmount);
            } else {
                userFansDetail.setSubsidyAmount(dto.getSubsidyAmount() + subsidyAmount);
            }
            if (dto.getOrderNum() == null) {
                userFansDetail.setOrderNum(orderNum == null ? 0 : orderNum);
            } else {
                userFansDetail.setOrderNum(dto.getOrderNum() + orderNum);
            }
            userFansDetailRepository.update(userFansDetail);
        }
    }
}
