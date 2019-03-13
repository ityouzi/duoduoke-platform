package com.fulihui.redisdubbo.demo.producer.dal.convert;

import com.fulihui.redisdubbo.demo.api.dto.HomeColumnDTO;
import com.fulihui.redisdubbo.demo.api.util.Collections;
import com.fulihui.redisdubbo.demo.producer.dal.dataobj.HomeColumn;
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
public class HomeColumnConvert {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    public static List<HomeColumnDTO> convert(List<HomeColumn> list) {
        if (CollectionUtils.isEmpty(list)) {
            return Collections.emptyList();
        }
        return list.stream().map(it -> {
            HomeColumnDTO dto = new HomeColumnDTO();
            BeanUtils.copyProperties(it, dto);
            return dto;
        }).collect(Collectors.toList());
    }
}