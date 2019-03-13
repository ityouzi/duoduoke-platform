package com.fulihui.duoduoke.demo.api.dto.ext;

import lombok.Data;

/**
 * @author: JY 免单活动扩展字段
 * @date: 2018/11/13 10:59
 */
@Data
public class ExtExemptionActivityDTO {

    /**
     * 免单类型 1：普通免单 2：邀请好友免单
     */
    Integer exemptionType;

    /**
     * 邀请人数
     */
    Integer invitations;

    /**
     * 红包专场Id
     */
    String redPackageId;

    /**
     * 分享标题
     */
    String shareTitle;

    /**
     * 分享图片
     */
    String shareImg;

}
