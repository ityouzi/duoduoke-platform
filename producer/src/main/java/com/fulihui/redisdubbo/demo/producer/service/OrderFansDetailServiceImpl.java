package com.fulihui.redisdubbo.demo.producer.service;

import com.fulihui.redisdubbo.demo.api.api.OrderFansDetailService;
import com.fulihui.redisdubbo.demo.api.dto.OrderFansDetailDTO;
import com.fulihui.redisdubbo.demo.api.request.OrderFansDetailRequest;
import com.fulihui.redisdubbo.demo.producer.dal.dataobj.OrderFansDetailExample;
import com.fulihui.redisdubbo.demo.producer.repository.OrderFansDetailRepository;
import org.apache.dubbo.config.annotation.Service;
import org.near.servicesupport.result.ResultBuilder;
import org.near.servicesupport.result.TPageResult;
import org.near.toolkit.common.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author lizhi
 * @date 2018-7-31
 */
@Service(version = "${demo.service.version}")

public class OrderFansDetailServiceImpl implements OrderFansDetailService {
    @Autowired
    OrderFansDetailRepository orderFansDetailRepository;

    @Override
    public TPageResult<OrderFansDetailDTO> queryPage(OrderFansDetailRequest request) {
        OrderFansDetailExample example = new OrderFansDetailExample();

        String sortInfo = request.getSortInfo();
        if (StringUtil.isNotBlank(sortInfo)) {
            example.setOrderByClause(sortInfo);
        }
        OrderFansDetailExample.Criteria criteria = example.createCriteria();

        example.setOffset(request.start4Mysql());
        example.setLimit(request.getRows());

        criteria.andPUserIdEqualTo(request.getPUserId());

        if (!CollectionUtils.isEmpty(request.getOrderStatus())) {
            criteria.andOrderStatusIn(request.getOrderStatus());
        }
        if (request.getLevel() != null) {
            criteria.andLevelEqualTo(request.getLevel());
        }
        if (StringUtil.isNotBlank(request.getFansType())) {
            criteria.andFansTypeEqualTo(request.getFansType());
        }
        if (request.getFansAmount() != null) {
            criteria.andFansAmountGreaterThan(request.getFansAmount());
        }
        List<OrderFansDetailDTO> list = orderFansDetailRepository.query(example);
        long count = 0;
        if (!CollectionUtils.isEmpty(list)) {
            count = orderFansDetailRepository.count(example);
        }
        return ResultBuilder.succTPage(list, request.getPage(), request.getRows(), (int) count);
    }
}
