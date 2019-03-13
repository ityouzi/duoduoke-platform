package com.fulihui.redisdubbo.demo.api.dto;

import lombok.Getter;
import lombok.Setter;
import org.near.toolkit.model.ToString;

import java.util.Date;

/**
 *
 * @author lizhi
 * @date 2018-7-7
 */
@Setter
@Getter
public class WechatAuthDTO extends ToString {

    private static final long serialVersionUID = 8548963751940886697L;
    /**
     *
     *
     * wechat_auth.id
     * 主键
     *
     * @mbg.generated 2018-07-07 10:19:33
     */
    private Integer id;

    /**
     *
     *
     * wechat_auth.open_id
     * open_id
     *
     * @mbg.generated 2018-07-07 10:19:33
     */
    private String openId;

    /**
     *
     *
     * wechat_auth.user_id
     * 主体唯一标识
     *
     * @mbg.generated 2018-07-07 10:19:33
     */
    private String userId;

    /**
     *
     *
     * wechat_auth.user_type
     * 主体类型
     *
     * @mbg.generated 2018-07-07 10:19:33
     */
    private String userType;

    /**
     *
     *
     * wechat_auth.appid
     * appid
     *
     * @mbg.generated 2018-07-07 10:19:33
     */
    private String appid;

    /**
     *
     *
     * wechat_auth.unionid
     * unionid
     *
     * @mbg.generated 2018-07-07 10:19:33
     */
    private String unionid;

    /**
     *
     *
     * wechat_auth.subscribe
     * 是否关注
     *
     * @mbg.generated 2018-07-07 10:19:33
     */
    private String subscribe;

    /**
     *
     *
     * wechat_auth.gmt_create

     *
     * @mbg.generated 2018-07-07 10:19:33
     */
    private Date gmtCreate;

    /**
     *
     *
     * wechat_auth.create_by

     *
     * @mbg.generated 2018-07-07 10:19:33
     */
    private String createBy;

    /**
     *
     *
     * wechat_auth.gmt_modified
     * 修改时间
     *
     * @mbg.generated 2018-07-07 10:19:33
     */
    private Date gmtModified;

    /**
     *
     *
     * wechat_auth.modified_by

     *
     * @mbg.generated 2018-07-07 10:19:33
     */
    private String modifiedBy;
}
