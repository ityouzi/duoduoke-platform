package com.fulihui.duoduoke.demo.producer.repository.impl;


import com.fulihui.duoduoke.demo.api.dto.OrderFansDetailDTO;
import com.fulihui.duoduoke.demo.api.util.Collections;
import com.fulihui.duoduoke.demo.producer.repository.OrderFansDetailRepository;
import com.fulihui.duoduoke.demo.producer.dal.dao.OrderFansDetailMapper;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.OrderFansDetail;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.OrderFansDetailExample;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @author lizhi
 * @date 2018-7-31
 */
@Repository
public class OrderFansDetailRepositoryImpl implements OrderFansDetailRepository {

    @Autowired
    OrderFansDetailMapper orderFansDetailMapper;


    @Override
    public int insert(OrderFansDetail info) {
        info.setGmtCreate(new Date());
        info.setGmtModified(new Date());
        orderFansDetailMapper.insertSelective(info);
        return info.getId();
    }

    @Override
    public int update(OrderFansDetail info) {
        info.setGmtModified(new Date());
        orderFansDetailMapper.updateByPrimaryKeySelective(info);
        return info.getId();
    }

    @Override
    public List<OrderFansDetailDTO> queryOrderSn(String orderSn) {
        OrderFansDetailExample example = new OrderFansDetailExample();
        example.createCriteria().andOrderSnEqualTo(orderSn);
        List<OrderFansDetail> list = orderFansDetailMapper.selectByExample(example);
        return convert(list);
    }

    @Override
    public List<OrderFansDetailDTO> queryOrderSn(String orderSn, String userId, String pUserId) {
        OrderFansDetailExample example = new OrderFansDetailExample();
        example.createCriteria().andOrderSnEqualTo(orderSn).andUserIdEqualTo(userId).andPUserIdEqualTo(pUserId);
        List<OrderFansDetail> list = orderFansDetailMapper.selectByExample(example);
        return convert(list);
    }

    @Override
    public long count(OrderFansDetailExample example) {
        return orderFansDetailMapper.countByExample(example);
    }

    @Override
    public List<OrderFansDetailDTO> query(OrderFansDetailExample example) {
        List<OrderFansDetail> list = orderFansDetailMapper.selectByExample(example);
        return convert(list);
    }

    private List<OrderFansDetailDTO> convert(List<OrderFansDetail> list) {
        if (Collections.isEmpty(list)) {
            return Collections.emptyList();
        }
        return Collections.transform(list, this::convert);
    }

    private OrderFansDetailDTO convert(OrderFansDetail item) {
        if (item == null) {
            return null;
        }
        OrderFansDetailDTO fansDetailDTO = new OrderFansDetailDTO();
        BeanUtils.copyProperties(item, fansDetailDTO);
        return fansDetailDTO;
    }


}
