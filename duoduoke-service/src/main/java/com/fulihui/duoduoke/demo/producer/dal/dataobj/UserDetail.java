package com.fulihui.duoduoke.demo.producer.dal.dataobj;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class UserDetail implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * user_detail.id
     *
     * @mbg.generated 2018-09-18 10:55:29
     */
    private Integer id;
    /**
     * user_detail.user_id
     * 用户唯一标识
     *
     * @mbg.generated 2018-09-18 10:55:29
     */
    private String userId;
    /**
     * user_detail.nickname
     * 昵称
     *
     * @mbg.generated 2018-09-18 10:55:29
     */
    private String nickname;
    /**
     * user_detail.name
     * 用户姓名
     *
     * @mbg.generated 2018-09-18 10:55:29
     */
    private String name;
    /**
     * user_detail.gender
     * 用户性别
     *
     * @mbg.generated 2018-09-18 10:55:29
     */
    private String gender;
    /**
     * user_detail.id_card
     * 身份证号
     *
     * @mbg.generated 2018-09-18 10:55:29
     */
    private String idCard;
    /**
     * user_detail.mobile_no
     * 手机号
     *
     * @mbg.generated 2018-09-18 10:55:29
     */
    private String mobileNo;
    /**
     * user_detail.birthday
     * 生日yyyyMMdd
     *
     * @mbg.generated 2018-09-18 10:55:29
     */
    private String birthday;
    /**
     * user_detail.gmt_create
     * 创建时间
     *
     * @mbg.generated 2018-09-18 10:55:29
     */
    private Date gmtCreate;
    /**
     * user_detail.create_by
     *
     * @mbg.generated 2018-09-18 10:55:29
     */
    private String createBy;
    /**
     * user_detail.gmt_modified
     * 修改时间
     *
     * @mbg.generated 2018-09-18 10:55:29
     */
    private Date gmtModified;
    /**
     * user_detail.modified_by
     *
     * @mbg.generated 2018-09-18 10:55:29
     */
    private String modifiedBy;
    /**
     * user_detail.user_source
     * 用户注册来源
     *
     * @mbg.generated 2018-09-18 10:55:29
     */
    private String userSource;
    /**
     * user_detail.user_referee
     * 用户推荐人
     *
     * @mbg.generated 2018-09-18 10:55:29
     */
    private String userReferee;
    /**
     * user_detail.user_referee_ids
     *
     * @mbg.generated 2018-09-18 10:55:29
     */
    private String userRefereeIds;
    /**
     * user_detail.marker
     *
     * @mbg.generated 2018-09-18 10:55:29
     */
    private String marker;
    /**
     * user_detail.reg_date
     * 注册时间
     *
     * @mbg.generated 2018-09-18 10:55:29
     */
    private Date regDate;
    /**
     * user_detail.level
     *
     * @mbg.generated 2018-09-18 10:55:29
     */
    private Integer level;
    /**
     * user_detail.avatar_url
     * 用户头像地址
     *
     * @mbg.generated 2018-09-18 10:55:29
     */
    private String avatarUrl;
    /**
     * user_detail.reg_url
     * 注册页面路径
     *
     * @mbg.generated 2018-09-18 10:55:29
     */
    private String regUrl;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", nickname=").append(nickname);
        sb.append(", name=").append(name);
        sb.append(", gender=").append(gender);
        sb.append(", idCard=").append(idCard);
        sb.append(", mobileNo=").append(mobileNo);
        sb.append(", birthday=").append(birthday);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", createBy=").append(createBy);
        sb.append(", gmtModified=").append(gmtModified);
        sb.append(", modifiedBy=").append(modifiedBy);
        sb.append(", userSource=").append(userSource);
        sb.append(", userReferee=").append(userReferee);
        sb.append(", userRefereeIds=").append(userRefereeIds);
        sb.append(", marker=").append(marker);
        sb.append(", regDate=").append(regDate);
        sb.append(", level=").append(level);
        sb.append(", avatarUrl=").append(avatarUrl);
        sb.append(", regUrl=").append(regUrl);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}