package com.fulihui.redisdubbo.demo.api.request;

import lombok.Getter;
import lombok.Setter;
import org.near.toolkit.model.ToString;

/**
 * @Description:
 * @Author: xiaoming
 * @version: v 0.1 2018/7/30 0030 19:11
 */
@Setter @Getter
public class UserQrcodeImgRequest extends ToString {

    private String uid;

    private String goodsId;

    private String sharePid;



}
