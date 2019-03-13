package com.fulihui.redisdubbo.demo.producer.service.promotion;

import com.fulihui.redisdubbo.demo.api.api.promotion.PromotionChannelsLinkService;
import com.fulihui.redisdubbo.demo.api.dto.promotion.PromotionChannelsLinkDTO;
import com.fulihui.redisdubbo.demo.api.request.promition.PromotionChannelsLinkRequest;
import com.fulihui.redisdubbo.demo.producer.dal.dao.PromotionChannelsLinkMapper;
import com.fulihui.redisdubbo.demo.producer.dal.dataobj.PromotionChannelsLink;
import com.fulihui.redisdubbo.demo.producer.dal.dataobj.PromotionChannelsLinkExample;
import org.apache.dubbo.config.annotation.Service;
import org.near.servicesupport.error.Errors;
import org.near.servicesupport.result.ResultBuilder;
import org.near.servicesupport.result.TSingleResult;
import org.near.servicesupport.util.ServiceAssert;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lizhi
 * @date 2018-12-07
 */

@Service(version = "${demo.service.version}")
public class PromotionChannelsLinkServiceImpl implements PromotionChannelsLinkService {

    @Autowired
    PromotionChannelsLinkMapper promotionChannelsLinkMapper;

    @Override
    public TSingleResult<PromotionChannelsLinkDTO> queryByCode(PromotionChannelsLinkRequest request) {
        ServiceAssert.notNull(request, Errors.Commons.REQUEST_PARAMETER_ERROR);
        ServiceAssert.notNull(request.getChannelsCode(), Errors.Commons.REQUEST_PARAMETER_ERROR);
        List<PromotionChannelsLink> list = getPromotionChannelsLinks(request.getChannelsCode());
        if (CollectionUtils.isEmpty(list)) {
            return ResultBuilder.succTSingle(null);
        }
        List<PromotionChannelsLinkDTO> collect = list.stream().map(this::convert)
                .collect(Collectors.toList());
        return ResultBuilder.succTSingle(collect.stream().findFirst().get());
    }

    private List<PromotionChannelsLink> getPromotionChannelsLinks(String channelsCode) {
        PromotionChannelsLinkExample example = new PromotionChannelsLinkExample();
        example.createCriteria().andChannelsCodeEqualTo(channelsCode);
        return promotionChannelsLinkMapper.selectByExample(example);
    }

    @Override
    public TSingleResult<Boolean> saveUpdate(PromotionChannelsLinkRequest request) {
        ServiceAssert.notNull(request, Errors.Commons.REQUEST_PARAMETER_ERROR);
        ServiceAssert.notNull(request.getChannelsCode(), Errors.Commons.REQUEST_PARAMETER_ERROR);

        PromotionChannelsLink record = new PromotionChannelsLink();
        BeanUtils.copyProperties(request, record);
        List<PromotionChannelsLink> list = getPromotionChannelsLinks(request.getChannelsCode());
        if (CollectionUtils.isEmpty(list)) {
            Date now = new Date();
            record.setGmtCreate(now);
            record.setGmtModified(now);
            int i = promotionChannelsLinkMapper.insertSelective(record);
            return ResultBuilder.succTSingle(i > 0);
        } else {
            PromotionChannelsLink item = list.get(0);
            record.setId(item.getId());
            record.setGmtModified(new Date());
            int i = promotionChannelsLinkMapper.updateByPrimaryKeySelective(record);
            return ResultBuilder.succTSingle(i > 0);
        }
    }

    private PromotionChannelsLinkDTO convert(PromotionChannelsLink link) {
        if (link == null) {
            return null;
        }
        PromotionChannelsLinkDTO dto = new PromotionChannelsLinkDTO();
        BeanUtils.copyProperties(link, dto);
        return dto;
    }
}
