package com.fulihui.redisdubbo.demo.manager;


import com.fulihui.redisdubbo.demo.weixin.weixin.result.transfer.TransfersQueryWeixinResult;
import com.fulihui.redisdubbo.demo.weixin.weixin.result.transfer.TransfersWeixinResult;

/**
 * The interface Wechat manager.
 *
 * @author lizhi
 * @date 2018 -7-7
 */
public interface WeChatManager {

    /**
     * 小程序根据code获取openId
     * @param code the code
     * @return the code open id
     */
    String getOpenIdByCode(String code);

    /**
     * 获取 access_token
     *
     * @return the string
     */
    String takeAccessToken();

    /**
     * 微信提现到余额
     *
     * @param openId    用户openid
     * @param miniAppId the mini app id
     * @param tradeNo   本地交易号
     * @param amount    金额，分
     * @param desc      交易描述
     * @return {@link TransfersWeixinResult}
     */
    TransfersWeixinResult transfers(String openId, String miniAppId, String tradeNo, int amount,
                                    String desc);

    /**
     * 企业微信转账查询(公众号->个人)
     *
     * @param userId  the user id
     * @param appId   the app id
     * @param tradeNO 商户订单号
     * @return transfers order query weixin result
     */
    TransfersQueryWeixinResult transferQuery(String userId, String appId, String tradeNO);
}
