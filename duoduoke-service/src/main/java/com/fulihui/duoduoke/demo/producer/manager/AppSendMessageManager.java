package com.fulihui.duoduoke.demo.producer.manager;


import com.fulihui.duoduoke.demo.api.enums.MessageChannelEnum;

import java.awt.image.BufferedImage;
import java.io.InputStream;

/**
 * The interface App send message manager.
 *
 * @author lizhi
 * @date 2018 /7/7 0007
 */
public interface AppSendMessageManager {

    /**
     * 发送模板消息 type MessageChannelEnum
     *
     * @param type    the type
     * @param userId  the user id
     * @param content the content                <p> json 串 格式         content={                "keyword1": "",              "keyword2": "",                "keyword3": "",                "keyword4": "",                "keyword5": "",                "keyword6": ""                }
     * @param formId  the form id
     * @param page    the page
     * @return boolean boolean
     * @see MessageChannelEnum
     */
    boolean sendMessage(String type, String userId, String content, String formId, String page);

    /**
     * Convert content object.
     *
     * @param content the content
     * @return the object
     */
    Object convertContent(String content);

    /**
     * 获取小程序二维码
     *
     * @param scene the scene
     * @return weixin code
     */
    BufferedImage getWeixinCode(String scene);

    /**
     * Weixin code input stream.
     *
     * @param scene the scene
     * @param type  the type
     * @return the input stream
     */
    InputStream weixinCode(String scene, String type);

}
