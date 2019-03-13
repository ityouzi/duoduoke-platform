package com.fulihui.redisdubbo.demo.api.request;

import lombok.Data;

/**
 * @author: JY
 * @date: 2018/9/13 16:40
 */
@Data
public class GoodsSearchInfoRangeRequest {

    //如果左区间不限制，range_from传空就行，右区间不限制，range_to传空就行
    private int range_to;

    //如果左区间不限制，range_from传空就行，右区间不限制，range_to传空就行
    private int range_from;

    //0-商品拼团价格区间，1-商品券后价价格区间，2-佣金比例区间，3-优惠券金额区间，4-加入多多进宝时间区间，5-销量区间，6-佣金金额区间，7-店铺描述评分区间，8-店铺物流评分区间，9-店铺服务评分区间
    private int range_id;

}
