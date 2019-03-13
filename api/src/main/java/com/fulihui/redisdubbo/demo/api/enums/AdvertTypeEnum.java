package com.fulihui.redisdubbo.demo.api.enums;

import lombok.Getter;
import org.near.toolkit.model.BaseEnum;

/**
 * @Description:
 * @Author: xiaoming
 * @version: v 0.1 2018/8/2 0002 15:01
 */
@Getter
public enum AdvertTypeEnum implements BaseEnum {

    /**
     * h5
     */
    H5("0", "h5"),
    /**
     * 小程序
     */
    MINI("1", "MINI"),

    /**
     * 浮层
     */
    FLOAT("2", "FLOAT"),

    /**
     * 签到活动
     */
    SIGN_ACTIVITY("3","AIGN_ACTIVITY"),

    /**
     * 小程序首页banner
     */
    DUODUOKE_BANNER("4","DUODUOKE_BANNER"),

    /**
     * 小程序栏目
     */
    DUODUOKE_COLUMN("5","DUODUOKE_COLUMN"),

    /**
     * 首页h5banner
     */
    H5_BANNER("6","H5_BANNER"),

    /**
     * h5 栏目
     */
    H5_COLUMN("7","H5_COLUMN"),

    ;
 ;

    String code;
    String desc;

    AdvertTypeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

}
