package com.fulihui.duoduoke.demo.web.manager;


import com.fulihui.duoduoke.demo.web.vo.UserInvitationVO;
import com.fulihui.duoduoke.demo.web.vo.UserShareFansVO;

/**
 * The interface User fans detail manager.
 *
 * @author lizhi
 * @date 2018 -8-1
 */
public interface UserFansDetailManager {


    /**
     * 邀请总览明细
     *
     * @param userId the user id
     * @return the user invitation vo
     */
    UserInvitationVO invitation(String userId);


    /**
     * 邀请总览统计
     *
     * @param userId the user id
     * @return the user share fans vo
     */
    UserShareFansVO accumulative(String userId);


}
