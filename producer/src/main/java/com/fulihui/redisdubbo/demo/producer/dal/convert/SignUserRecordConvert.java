package com.fulihui.redisdubbo.demo.producer.dal.convert;

import com.fulihui.redisdubbo.demo.api.dto.sign.SignUserRecordDTO;
import com.fulihui.redisdubbo.demo.api.util.Collections;
import com.fulihui.redisdubbo.demo.producer.dal.dataobj.SignUserRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;


/**
 * @author lizhi
 * @date 2018-10-12
 */
public class SignUserRecordConvert {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    public static List<SignUserRecordDTO> convert(List<SignUserRecord> list) {
        if (CollectionUtils.isEmpty(list)) {
            return Collections.emptyList();
        }
        return list.stream().map(it -> {
            SignUserRecordDTO dto = new SignUserRecordDTO();
            BeanUtils.copyProperties(it, dto);
            return dto;
        }).collect(Collectors.toList());
    }

    public static SignUserRecordDTO convert(SignUserRecord item) {

        if (item == null) {
            return null;
        }

        SignUserRecordDTO dto = new SignUserRecordDTO();
        BeanUtils.copyProperties(item, dto);
        return dto;

    }
}
