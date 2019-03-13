package com.fulihui.redisdubbo.demo.producer.service.promotion;

import com.fulihui.redisdubbo.demo.api.api.promotion.PromotionChannelsOrderService;
import com.fulihui.redisdubbo.demo.api.dto.OrderInfoDTO;
import com.fulihui.redisdubbo.demo.api.dto.promotion.GroupChannelsOrderDTO;
import com.fulihui.redisdubbo.demo.api.request.OrderInfoRequest;
import com.fulihui.redisdubbo.demo.api.request.OrderQueryInfoRequest;
import com.fulihui.redisdubbo.demo.producer.dal.dataobj.PromotionChannelsOrderExample;
import com.fulihui.redisdubbo.demo.producer.repository.PromotionChannelsOrderRepository;
import org.apache.dubbo.config.annotation.Service;
import org.near.servicesupport.error.Errors;
import org.near.servicesupport.result.ResultBuilder;
import org.near.servicesupport.result.TPageResult;
import org.near.servicesupport.result.TSingleResult;
import org.near.servicesupport.util.ServiceAssert;
import org.near.toolkit.common.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

import static org.near.toolkit.common.StringUtil.isNotBlank;
import static org.springframework.util.CollectionUtils.isEmpty;

/**
 * Created by lizhi on 2018-12-13.
 */
@Service(version = "${demo.service.version}")
public class PromotionChannelsOrderServiceImpl implements PromotionChannelsOrderService {
    @Autowired
    PromotionChannelsOrderRepository promotionChannelsOrderRepository;

    @Override
    public TPageResult<OrderInfoDTO> queryPage(OrderQueryInfoRequest request) {
        ServiceAssert.notNull(request, Errors.Commons.REQUEST_PARAMETER_ERROR);
        PromotionChannelsOrderExample example = toExample(request);
        List<OrderInfoDTO> list = promotionChannelsOrderRepository.selectByExample(example);
        long count = 0;
        if (!isEmpty(list)) {
            count = promotionChannelsOrderRepository.countByExample(example);
        }
        return ResultBuilder.succTPage(list, request.getPage(), request.getRows(), (int) count);
    }

    private PromotionChannelsOrderExample getOrderInfoExample(OrderQueryInfoRequest request) {
        PromotionChannelsOrderExample example = new PromotionChannelsOrderExample();
        PromotionChannelsOrderExample.Criteria criteria = example.createCriteria();
        if (isNotBlank(request.getUserId())) {
            criteria.andCustomParametersEqualTo(request.getUserId());
        }
        List<String> userOrderStatus = request.getUserOrderStatus();
        if (!isEmpty(userOrderStatus)) {
            criteria.andUserOrderStatusIn(request.getUserOrderStatus());
        }

        List<String> orderStatus = request.getOrderStatus();
        if (!isEmpty(orderStatus)) {
            criteria.andOrderStatusIn(request.getOrderStatus());
        }

        Date startOrderCreateTime = request.getStartOrderCreateTime();
        if (startOrderCreateTime != null) {
            criteria.andOrderCreateTimeGreaterThanOrEqualTo(startOrderCreateTime);
        }
        Date endOrderCreateTime = request.getEndOrderCreateTime();

        if (endOrderCreateTime != null) {
            criteria.andOrderCreateTimeLessThanOrEqualTo(endOrderCreateTime);
        }

        Date startGmtCreateTime = request.getStartGmtCreateTime();
        if (startGmtCreateTime != null) {
            criteria.andGmtCreateGreaterThanOrEqualTo(startGmtCreateTime);
        }

        Date endGmtCreateTime = request.getEndGmtCreateTime();
        if (endGmtCreateTime != null) {
            criteria.andGmtCreateLessThanOrEqualTo(endGmtCreateTime);
        }

        if (request.getOrderSn() != null) {
            criteria.andOrderSnEqualTo(request.getOrderSn());
        }

        if (StringUtil.isNotBlank(request.getPromoType())) {
            criteria.andPromoTypeEqualTo(request.getPromoType());
        }
        if (StringUtil.isNotBlank(request.getPId())) {
            criteria.andPIdEqualTo(request.getPId());
        }

        if (StringUtil.isNotBlank(request.getPId())) {
            criteria.andPIdEqualTo(request.getPId());
        }

        if (request.getOrderPayDateExt() != null) {
            criteria.andOrderPayTimeExtEqualTo(request.getOrderPayDateExt());
        }

        if (request.getOrderModifyAtExt() != null) {
            criteria.andOrderModifyAtExtEqualTo(request.getOrderModifyAtExt());
        }

        if (request.getStartOrderPayDate() != null) {
            criteria.andOrderPayTimeBetween(request.getStartOrderPayDate(),
                    request.getEndOrderPayDate());
        }
        if (StringUtil.isNotBlank(request.getPromoType())) {
            criteria.andPromoTypeEqualTo(request.getPromoType());
        }

        return example;
    }

    private PromotionChannelsOrderExample toExample(OrderQueryInfoRequest request) {
        PromotionChannelsOrderExample example = getOrderInfoExample(request);
        example.setOffset(request.start4Mysql());
        example.setLimit(request.getRows());
        if (isNotBlank(request.getSortInfo())) {
            example.setOrderByClause(request.getSortInfo());
        }
        return example;
    }

    @Override
    public TSingleResult<OrderInfoDTO> queryByPk(OrderInfoRequest request) {
        return null;
    }

    @Override
    public TPageResult<GroupChannelsOrderDTO> queryGroupPage(OrderQueryInfoRequest request) {
        ServiceAssert.notNull(request, Errors.Commons.REQUEST_PARAMETER_ERROR);
        List<GroupChannelsOrderDTO> dtoList = promotionChannelsOrderRepository.queryGroup(
                request.start4Mysql(), request.getRows(), request.getChannelsCode(),
                request.getStartOrderPayDate(), request.getEndOrderPayDate(), request.getPromoType(),
                request.getOrderStatus(), request.getUserOrderStatus(), request.getStartDateModify(),
                request.getEndDateModify());
        int count = 0;
        if (!CollectionUtils.isEmpty(dtoList)) {
            count = promotionChannelsOrderRepository.queryGroupCount(request.getChannelsCode(),
                    request.getStartOrderPayDate(), request.getEndOrderPayDate(),
                    request.getPromoType(), request.getOrderStatus(), request.getUserOrderStatus(),
                    request.getStartDateModify(), request.getEndDateModify());
        }
        return ResultBuilder.succTPage(dtoList, request.getPage(), request.getRows(), count);
    }

    @Override
    public TPageResult<GroupChannelsOrderDTO> queryGroupPageModify(OrderQueryInfoRequest request) {
        ServiceAssert.notNull(request, Errors.Commons.REQUEST_PARAMETER_ERROR);
        List<GroupChannelsOrderDTO> dtoList = promotionChannelsOrderRepository.queryGroupModify(
                request.start4Mysql(), request.getRows(), request.getChannelsCode(),
                request.getStartOrderPayDate(), request.getEndOrderPayDate(), request.getPromoType(),
                request.getOrderStatus(), request.getUserOrderStatus(), request.getStartDateModify(),
                request.getEndDateModify());
        int count = 0;
        if (!CollectionUtils.isEmpty(dtoList)) {
            count = promotionChannelsOrderRepository.queryGroupCountModify(
                    request.getChannelsCode(), request.getStartOrderPayDate(),
                    request.getEndOrderPayDate(), request.getPromoType(), request.getOrderStatus(),
                    request.getUserOrderStatus(), request.getStartDateModify(),
                    request.getEndDateModify());
        }
        return ResultBuilder.succTPage(dtoList, request.getPage(), request.getRows(), count);
    }
}
