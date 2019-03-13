package com.fulihui.duoduoke.demo.api.enums;

import lombok.Getter;
import org.near.toolkit.model.BaseEnum;

/**
 * @author: JY
 * @date: 2018/7/26 13:46
 */
@Getter
public enum OrderFansTypeEnum implements BaseEnum {


    /**
     * 用户分享商品
     */
    SHARE("1", "用户分享商品", UserAccountBizCode.SHARE_ORDER, "分享赚"),
    /**
     * 推荐用户分销
     */
    REFERENCE("2", "推荐用户分销", UserAccountBizCode.FANS_ORDER, "%s级");

    String code;
    String desc;
    UserAccountBizCode bizCode;
    String orderDesc;

    OrderFansTypeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    OrderFansTypeEnum(String code, String desc, UserAccountBizCode bizCode, String orderDesc) {
        this.code = code;
        this.desc = desc;
        this.bizCode = bizCode;
        this.orderDesc = orderDesc;
    }

}
