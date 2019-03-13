package com.fulihui.redisdubbo.demo.producer.dal.convert;

import com.fulihui.redisdubbo.demo.api.dto.sign.SignInConfigDTO;
import com.fulihui.redisdubbo.demo.api.util.Collections;
import com.fulihui.redisdubbo.demo.producer.dal.dataobj.SignInConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;


/**
 * @author Administrator
 */
public class SignInConfigConvert {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    public static List<SignInConfigDTO> convert(List<SignInConfig> list) {
        if (CollectionUtils.isEmpty(list)) {
            return Collections.emptyList();
        }
        return list.stream().map(it -> {
            SignInConfigDTO dto = new SignInConfigDTO();
            BeanUtils.copyProperties(it, dto);
            return dto;
        }).collect(Collectors.toList());
    }

    public static SignInConfigDTO convert(SignInConfig item) {

        if (item == null) {
            return null;
        }

        SignInConfigDTO dto = new SignInConfigDTO();
        BeanUtils.copyProperties(item, dto);
        return dto;

    }
}