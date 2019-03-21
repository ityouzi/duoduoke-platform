package com.fulihui.duoduoke.demo.api.request;

import lombok.Data;
import org.near.toolkit.model.ToString;

/**
 * @Description: pdd.ddk.goods.search（多多进宝商品查询）
 * @Author: xiaoming
 * @version: v 0.1 2018/7/7 0007 13:54
 */
@Data
public class DuoduoGoodsRange extends ToString {

    private long range_from;

    private long range_id;


}
