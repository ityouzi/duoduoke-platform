package com.fulihui.redisdubbo.demo.producer.service;


import com.fulihui.redisdubbo.demo.api.api.AdvertService;
import com.fulihui.redisdubbo.demo.api.dto.AdvertDTO;
import com.fulihui.redisdubbo.demo.api.request.AdvertIdRequest;
import com.fulihui.redisdubbo.demo.api.request.AdvertRequest;
import com.fulihui.redisdubbo.demo.producer.dal.dataobj.Advert;
import com.fulihui.redisdubbo.demo.producer.repository.AdvertRepository;
import com.fulihui.redisdubbo.demo.weixin.common.util.BeanConvUtil;
import org.apache.dubbo.config.annotation.Service;
import org.near.servicesupport.error.Errors;
import org.near.servicesupport.result.ResultBuilder;
import org.near.servicesupport.result.TMultiResult;
import org.near.servicesupport.result.TSingleResult;
import org.near.servicesupport.util.ServiceAssert;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description:
 * @Author: xiaoming
 * @version: v 0.1 2018/8/2 0002 14:55
 */
@Service(version = "${demo.service.version}")

public class AdvertServiceImpl implements AdvertService {

    @Autowired
    private AdvertRepository advertRepository;

    @Override
    public TMultiResult<AdvertDTO> queryAdvert(AdvertRequest request) {
        ServiceAssert.notNull(request, Errors.Commons.REQUEST_PARAMETER_ERROR);

        Advert advert = new Advert();

        //数据转换
        BeanUtils.copyProperties(request, advert);

        List<Advert> adverts = advertRepository.selectByExample(advert);
        List<AdvertDTO> convert = convert(adverts);
        return ResultBuilder.succTMulti(convert);
    }

    @Override
    public TSingleResult<Boolean> insert(AdvertDTO advertDTO) {

        Advert advert = BeanConvUtil.copy(advertDTO, Advert.class);

        //初始时间
        boolean success = advertRepository.insert(advert) > 0;

        return ResultBuilder.succTSingle(success);
    }

    @Override
    public TSingleResult<Boolean> update(AdvertDTO advertDTO) {

        Advert advert = BeanConvUtil.copy(advertDTO, Advert.class);

        boolean success = advertRepository.update(advert) > 0;

        return ResultBuilder.succTSingle(success);
    }

    @Override
    public TSingleResult<Boolean> del(AdvertIdRequest request) {

        boolean success = advertRepository.del(request.getId()) > 0;

        return ResultBuilder.succTSingle(success);
    }

    private List<AdvertDTO> convert(List<Advert> adverts) {
        if (CollectionUtils.isEmpty(adverts)) {
            return Collections.emptyList();
        }
        return adverts.stream().map(i -> {
            AdvertDTO advertDTO = new AdvertDTO();
            BeanUtils.copyProperties(i, advertDTO);
            return advertDTO;
        }).collect(Collectors.toList());
    }
}
