package com.fulihui.duoduoke.demo.api.dto;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import sun.misc.BASE64Decoder;

import java.io.IOException;

/**
 * @author: JY
 * @date: 2018/8/17 9:59
 */
@Setter @Getter
public class UserFormIdDTO {
    private String userId;

    private String formId;

    private String nickname;

    private String openId;

    public String getDecodeName(){

        if(StringUtils.isEmpty(nickname)){
            return "";
        }
        try {
           return new String(new BASE64Decoder().decodeBuffer(nickname), "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
