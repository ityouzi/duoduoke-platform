package com.fulihui.redisdubbo.demo.producer.service.promotion;

import com.fulihui.redisdubbo.demo.api.api.promotion.PromotionTelevisionLinkService;
import com.fulihui.redisdubbo.demo.api.dto.PromotionTelevisionLinkDTO;
import com.fulihui.redisdubbo.demo.api.request.promition.PromotionTelevisionLinkRequest;
import com.fulihui.redisdubbo.demo.producer.dal.dataobj.PromotionTelevisionLink;
import com.fulihui.redisdubbo.demo.producer.dal.dataobj.PromotionTelevisionLinkExample;
import com.fulihui.redisdubbo.demo.producer.repository.PromotionTelevisionLinkRepository;
import org.apache.dubbo.config.annotation.Service;
import org.near.servicesupport.error.Errors;
import org.near.servicesupport.result.ResultBuilder;
import org.near.servicesupport.result.TPageResult;
import org.near.servicesupport.result.TSingleResult;
import org.near.servicesupport.util.ServiceAssert;
import org.near.toolkit.common.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author lizhi
 * @date 2018-12-06
 */
@Service(version = "${demo.service.version}")
public class PromotionTelevisionLinkServiceImpl implements PromotionTelevisionLinkService {
    @Autowired
    PromotionTelevisionLinkRepository promotionTelevisionLinkRepository;

    @Override
    public TSingleResult<Long> insert(PromotionTelevisionLinkRequest request) {
        ServiceAssert.notNull(request, Errors.Commons.REQUEST_PARAMETER_ERROR);
        ServiceAssert.notBlank(request.getChannelsCode(), Errors.Commons.REQUEST_PARAMETER_ERROR);
        ServiceAssert.notBlank(request.getLink(), Errors.Commons.REQUEST_PARAMETER_ERROR);
        ServiceAssert.notBlank(request.getTelevisionType(), Errors.Commons.REQUEST_PARAMETER_ERROR);

        PromotionTelevisionLink record = new PromotionTelevisionLink();
        record.setTelevisionType(request.getTelevisionType());
        record.setLink(request.getLink());
        record.setChannelsCode(request.getChannelsCode());
        int i = promotionTelevisionLinkRepository.insertSelective(record);
        return ResultBuilder.succTSingle((long) i);
    }

    @Override
    public TPageResult<PromotionTelevisionLinkDTO> queryPage(PromotionTelevisionLinkRequest request) {
        ServiceAssert.notNull(request, Errors.Commons.REQUEST_PARAMETER_ERROR);
        PromotionTelevisionLinkExample example = new PromotionTelevisionLinkExample();
        PromotionTelevisionLinkExample.Criteria criteria = example.createCriteria();
        example.setLimit(request.getRows());
        example.setOffset(request.start4Mysql());
        example.setOrderByClause("  gmt_modified DESC");

        if (StringUtil.isNotBlank(request.getTelevisionType())) {
            criteria.andTelevisionTypeEqualTo(request.getTelevisionType());
        }

        List<PromotionTelevisionLinkDTO> dtoList = promotionTelevisionLinkRepository
                .selectByExample(example);
        int count = 0;
        if (!CollectionUtils.isEmpty(dtoList)) {
            count = (int) promotionTelevisionLinkRepository.countByExample(example);
        }
        return ResultBuilder.succTPage(dtoList, request.getPage(), request.getRows(), count);
    }
}
