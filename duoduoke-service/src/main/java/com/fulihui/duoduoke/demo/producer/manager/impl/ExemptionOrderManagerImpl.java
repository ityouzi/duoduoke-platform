package com.fulihui.duoduoke.demo.producer.manager.impl;

import com.fulihui.duoduoke.demo.api.enums.ActivityStateEnum;
import com.fulihui.duoduoke.demo.api.enums.ExemptionGoodsStateEnum;
import com.fulihui.duoduoke.demo.api.enums.UserExemptionStateEnum;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.UserExemptionGoods;
import com.fulihui.duoduoke.demo.producer.manager.ExemptionOrderManager;
import com.fulihui.duoduoke.demo.producer.dal.dao.ActivityConfigMapper;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.ActivityConfig;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.ExemptionGoods;
import com.fulihui.duoduoke.demo.producer.repository.ExemptionGoodsRepository;
import com.fulihui.duoduoke.demo.producer.repository.UserExemptionGoodsRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;


/**
 * Created by lizhi on 2018-11-22.
 */
@Component
public class ExemptionOrderManagerImpl implements ExemptionOrderManager {
    @Autowired
    UserExemptionGoodsRepository userExemptionGoodsRepository;
    @Autowired
    ExemptionGoodsRepository exemptionGoodsRepository;
    @Autowired
    ActivityConfigMapper activityConfigMapper;

    @Override
    public void invalid(String userId, String orderSn, String goodsId, String orderStatus) {
        UserExemptionGoods record = new UserExemptionGoods();
        record.setUserId(userId);
        record.setGoodsId(Long.valueOf(goodsId));
        record.setOrderSn(orderSn);

        List<UserExemptionGoods> list = userExemptionGoodsRepository.selectByExample(record);
        if (!CollectionUtils.isEmpty(list)) {
            UserExemptionGoods goods = list.get(0);
            //如果商品关联的活动还有效
            boolean check = check(goods.getActivityId());
            if (check) {
                //查询商品是否开启
                ExemptionGoods exemptionGoods = new ExemptionGoods();
                exemptionGoods.setGoodsId(goods.getGoodsId());
                List<ExemptionGoods> goodsList = exemptionGoodsRepository
                        .selectByExample(exemptionGoods);
                if (!CollectionUtils.isEmpty(goodsList)) {
                    ExemptionGoods exemption = goodsList.get(0);
                    //商品状态开启
                    boolean b = exemption.getState() == ExemptionGoodsStateEnum.ON.getCode();
                    if (b) {
                        UserExemptionGoods item = new UserExemptionGoods();
                        item.setId(goods.getId());
                        item.setState(UserExemptionStateEnum.NOUSED.getCode());
                        //订单号置为空
                        // FIXME: 2018-11-17  //产品确认 订单号怎么处理
                        item.setOrderSn("");
                        userExemptionGoodsRepository.updateById(item);
                    } else {
                        if (!StringUtils.equals(goods.getState(),
                                UserExemptionStateEnum.INVALID.getCode())) {
                            UserExemptionGoods item = new UserExemptionGoods();
                            item.setId(goods.getId());
                            item.setState(UserExemptionStateEnum.INVALID.getCode());
                            userExemptionGoodsRepository.updateById(item);
                        }
                    }
                }
            } else {
                //置为无效
                if (!StringUtils.equals(goods.getState(),
                        UserExemptionStateEnum.INVALID.getCode())) {
                    UserExemptionGoods item = new UserExemptionGoods();
                    item.setId(goods.getId());
                    item.setBindOrderStatus(orderStatus);
                    item.setState(UserExemptionStateEnum.INVALID.getCode());
                    userExemptionGoodsRepository.updateById(item);
                }
            }
        }
    }

    private boolean check(Integer activityId) {
        ActivityConfig config = activityConfigMapper.selectByPrimaryKey(activityId);
        if (config == null) {
            return false;
        }
        long l = System.currentTimeMillis();
        return config.getState() == ActivityStateEnum.ON.getCode()
                && l >= config.getStartTime().getTime() && l <= config.getEndTime().getTime();
    }
}
