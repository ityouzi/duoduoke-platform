package com.fulihui.redisdubbo.demo.api.request.sign;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.near.servicesupport.request.PageRequest;

import java.util.Date;
import java.util.List;

/**
 *
 * @author lizhi
 * @date 2018-10-11
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SignUserRecordRequest extends PageRequest {

    private static final long serialVersionUID = 1961358351127358844L;

    public SignUserRecordRequest(Integer id) {
        this.id = id;
    }

    private Integer      id;

    /**
     * USERID
     */
    private String       userId;
    /**
     * 签到时间
     */
    private Date         signTimeExt;
    /**
     * 排序信息
     */
    private String       sortInfo;
    /**
     * 签到周期
     */
    private Date         cycleTime;

    /**
     * 签到类型
     */
    private String       signType;

    private String       signHelpUserId;
    /**
     * 签到状态
     */
    private List<String> signStatus;
    /**
     * sign_user_record.sign_flop_count
     * 签到翻牌机会
     *
      */
    private Integer      signFlopCount;

    /**
     * sign_user_record.share_flop_count
     * 分享翻牌机会
      */
    private Integer      shareFlopCount;

}
