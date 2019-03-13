package com.fulihui.duoduoke.demo.api.request;

import lombok.Getter;
import lombok.Setter;
import org.near.toolkit.model.ToString;

/**
 * @Description:
 * @Author: xiaoming
 * @version: v 0.1 2018/7/30 0030 19:11
 */
@Setter @Getter
public class UserPosterImgRequest extends ToString {

    private String userId;

    private String nickName;

    private String headImg;



}
