package com.fulihui.duoduoke.demo.producer.biz.model;


import lombok.Getter;
import lombok.Setter;
import org.near.toolkit.model.ToString;

/**
 * @author lizhi
 */
@Setter
@Getter
public class WechatTokenModel extends ToString {
    private static final long serialVersionUID = 745149211138129751L;
    /**
     * {"access_token":"10_PxTabSyqO6vGJFi3xuVPM1bZe40UA_soLDU01WBnApgFLNsRcpTu4Q25YJZ249wXprAHc5mTl1kUsedyZdQDqlEANZuvS5fGp-PKGBuzUeKEXcqeVn0Zt5W4wmCjYYP77c2hV4fW0CLHIsrqMMGbAAAFFZ","expires_in":7200}
     */


    private String access_token;

    private Integer expires_in;

}
