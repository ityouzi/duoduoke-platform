package com.fulihui.duoduoke.demo.web.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.near.toolkit.model.ToString;

/**
 * @author lizhi
 * @date 2018-8-8
 */
@Setter
@Getter
public class UserInfoModel extends ToString {


    private String errMsg;

    @ApiModelProperty("不包括敏感信息的原始数据字符串，用于计算签名。")
    private String rawData;
    @ApiModelProperty("使用 sha1( rawData + sessionkey ) 得到字符串，用于校验用户信息，参考文档 signature。")
    private String signature;
    @ApiModelProperty("包括敏感数据在内的完整用户信息的加密数据，详细见加密数据解密算法")
    private String encryptedData;
    @ApiModelProperty("加密算法的初始向量，详细见加密数据解密算法")
    private String iv;

    private UserInfo userInfo;

    private static final long serialVersionUID = -8779068592962531155L;

    @Setter
    @Getter
    public static class UserInfo extends ToString {

        private static final long serialVersionUID = 64906328925736318L;
        /**
         * 用户昵称
         */
        private String nickName;
        /**
         * 用户头像，最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表132*132正方形头像），用户没有头像时该项为空。若用户更换头像，原有头像URL将失效。
         */
        private String avatarUrl;
        /**
         * 用户的性别，值为1时是男性，值为2时是女性，值为0时是未知
         */
        private String gender;
        /**
         * 用户所在城市
         */
        private String city;
        /**
         * 用户所在省份
         */
        private String province;
        /**
         * 用户所在国家
         */
        private String country;
        /**
         * 用户的语言，简体中文为zh_CN
         */
        private String language;
    }

}
