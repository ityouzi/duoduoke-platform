package com.fulihui.duoduoke.demo.api.dto.sign;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.near.toolkit.model.ToString;

import java.util.Date;

/**
 * @author Administrator
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SignUserRecordDTO extends ToString {
    private static final long serialVersionUID = 8887706862913842352L;
    /**
     * sign_user_record.id
     */
    private Integer id;

    /**
     * sign_user_record.user_id
     * 用户唯一标识
     */
    private String userId;

    /**
     * sign_user_record.sign_time
     * 签到时间
     */
    private Date signTime;

    /**
     * sign_user_record.sign_time_ext
     * 签到时间扩展
     */
    private Date signTimeExt;

    /**
     * sign_user_record.sign_type
     * 签到类型
     */
    private String signType;

    /**
     * sign_user_record.gmt_create
     * 创建时间
     */
    private Date gmtCreate;

    /**
     * sign_user_record.gmt_modified
     * 修改时间
     */
    private Date gmtModified;

    /**
     * sign_user_record.cycle_time
     * 用户签到周期
     */
    private Date cycleTime;

    /**
     * sign_user_record.sign_status
     * [1：已签到,0:未签到]
     */
    private String signStatus;

    /**
     * sign_user_record.sign_in_prize
     * 签到奖品信息
     *
     * @mbg.generated 2018-10-12 14:48:38
     */
    private String signInPrize;

    private String signHelpUserId;

    /**
     * sign_user_record.sign_flop_count
     * 签到翻牌机会
     *
     * @mbg.generated 2018-10-15 13:26:35
     */
    private Integer signFlopCount;

    /**
     * sign_user_record.share_flop_count
     * 分享翻牌机会
     *
     * @mbg.generated 2018-10-15 13:26:35
     */
    private Integer shareFlopCount;

    public SignUserRecordDTO(String userId, String signStatus) {
        this.userId = userId;
        this.signStatus = signStatus;
    }
}