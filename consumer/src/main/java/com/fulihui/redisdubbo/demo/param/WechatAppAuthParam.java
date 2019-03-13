package com.fulihui.redisdubbo.demo.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.near.toolkit.model.ToString;

/**
 * Created by IntelliJ IDEA.
 * User:   lizhi
 * Date: 2018-5-30
 * Time: 17:59
 *
 * @author lizhi
 */
@Setter
@Getter
public class WechatAppAuthParam extends ToString {
    private static final long serialVersionUID = 6207131546454549415L;
    /**
     * code
     */
    @ApiModelProperty(value = "小程序code")
    private String            code;
    @ApiModelProperty(value = "小程序用户加密后的数据")
    private String            encryptedData;
    @ApiModelProperty(value = "加密算法的初始向量")
    private String            iv;
    @ApiModelProperty(value = "用户推荐人")
    private String            userReferee;
    @ApiModelProperty(value = "用户注册来源,help_activity =助力,red_activity =红包专场,flop_sharing=翻牌分享,sign_in=签到补签")
    private String            userSource;

    /**
     * user_detail.reg_url
     * 注册页面路径
     *
     * @mbg.generated 2018-09-18 10:55:29
     */
    @ApiModelProperty(value = "注册页面路径")
    private String            regUrl;
}
