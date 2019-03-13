package com.fulihui.duoduoke.demo.producer.dal.convert;

import com.fulihui.duoduoke.demo.api.dto.UserPosterImgDTO;
import com.fulihui.duoduoke.demo.api.util.Collections;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.UserPosterImg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;


/**
 * @Description:
 * @Author: xiaoming
 * @version: v 0.1 2018/8/1 0001 13:40
 */
public class UserPosterImgConvert {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    public static List<UserPosterImgDTO> convert(List<UserPosterImg> list) {
        if (CollectionUtils.isEmpty(list)) {
            return Collections.emptyList();
        }
        return list.stream().map(it -> {
            UserPosterImgDTO dto = new UserPosterImgDTO();
            BeanUtils.copyProperties(it, dto);
            return dto;
        }).collect(Collectors.toList());
    }
}
