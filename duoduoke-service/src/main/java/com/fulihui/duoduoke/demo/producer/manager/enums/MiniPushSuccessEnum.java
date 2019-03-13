package com.fulihui.duoduoke.demo.producer.manager.enums;

import lombok.Getter;
import org.near.toolkit.model.BaseEnum;

/**
 * @author lizhi
 */
@Getter
public enum MiniPushSuccessEnum implements BaseEnum {
    /**
     * template_id不正确
     */

    T("40037", "template_id不正确"),
    /**
     * form_id不正确，或者过期
     */
    F("41028", "form_id不正确，或者过期"),
    /**
     * form_id已被使用
     */
    Y("41029", "form_id已被使用"),
    /**
     * page不正确
     */
    p("41030", "page不正确"),
    /**
     * 接口调用超过限额（目前默认每个帐号日调用限额为100万）
     */
    J("45009", "接口调用超过限额（目前默认每个帐号日调用限额为100万）"),
    /**
     * 用户的openid与 （AppId和AppSecret ) 对应不上
     */
    U("40003", "用户的openid与 （AppId和AppSecret ) 对应不上"),
    /**
     * ok
     */
    S("0", "ok"),
    ;


    private String code;

    private String desc;

    MiniPushSuccessEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }


}
