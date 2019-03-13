package com.fulihui.redisdubbo.demo.producer.dal.dataobj;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class SignUserRecord implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * sign_user_record.id
     *
     * @mbg.generated 2018-10-18 13:07:30
     */
    private Integer id;
    /**
     * sign_user_record.user_id
     * 用户唯一标识
     *
     * @mbg.generated 2018-10-18 13:07:30
     */
    private String userId;
    /**
     * sign_user_record.sign_time
     * 签到时间
     *
     * @mbg.generated 2018-10-18 13:07:30
     */
    private Date signTime;
    /**
     * sign_user_record.sign_time_ext
     * 签到时间扩展
     *
     * @mbg.generated 2018-10-18 13:07:30
     */
    private Date signTimeExt;
    /**
     * sign_user_record.sign_type
     * 签到类型
     *
     * @mbg.generated 2018-10-18 13:07:30
     */
    private String signType;
    /**
     * sign_user_record.cycle_time
     * 用户签到周期
     *
     * @mbg.generated 2018-10-18 13:07:30
     */
    private Date cycleTime;
    /**
     * sign_user_record.sign_status
     * [1：已签到,0:未签到]
     *
     * @mbg.generated 2018-10-18 13:07:30
     */
    private String signStatus;
    /**
     * sign_user_record.sign_help_user_id
     * 补签帮助者
     *
     * @mbg.generated 2018-10-18 13:07:30
     */
    private String signHelpUserId;
    /**
     * sign_user_record.sign_flop_count
     * 签到翻牌机会
     *
     * @mbg.generated 2018-10-18 13:07:30
     */
    private Integer signFlopCount;
    /**
     * sign_user_record.share_flop_count
     * 分享翻牌机会
     *
     * @mbg.generated 2018-10-18 13:07:30
     */
    private Integer shareFlopCount;
    /**
     * sign_user_record.sign_in_prize
     * 签到奖品信息
     *
     * @mbg.generated 2018-10-18 13:07:30
     */
    private String signInPrize;
    /**
     * sign_user_record.gmt_create
     * 创建时间
     *
     * @mbg.generated 2018-10-18 13:07:30
     */
    private Date gmtCreate;
    /**
     * sign_user_record.gmt_modified
     * 修改时间
     *
     * @mbg.generated 2018-10-18 13:07:30
     */
    private Date gmtModified;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", signTime=").append(signTime);
        sb.append(", signTimeExt=").append(signTimeExt);
        sb.append(", signType=").append(signType);
        sb.append(", cycleTime=").append(cycleTime);
        sb.append(", signStatus=").append(signStatus);
        sb.append(", signHelpUserId=").append(signHelpUserId);
        sb.append(", signFlopCount=").append(signFlopCount);
        sb.append(", shareFlopCount=").append(shareFlopCount);
        sb.append(", signInPrize=").append(signInPrize);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", gmtModified=").append(gmtModified);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}