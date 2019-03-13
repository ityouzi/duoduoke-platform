package com.fulihui.redisdubbo.demo.api.request;

import org.near.toolkit.model.ToString;

/**
 * @Description: pdd.ddk.goods.search（多多进宝商品查询）
 * @Author: xiaoming
 * @version: v 0.1 2018/7/7 0007 13:54
 */
public class DuoduoGoodsRange extends ToString {

    private long range_from;

    private long range_id;



    /**
     * Getter method for property <tt>range_from</tt>
     *
     * @return property value of range_from
     */
    public long getRange_from() {
        return range_from;
    }

    /**
     * Setter method for property <tt>range_from</tt>.
     *
     * @param range_from value to be assigned to property range_from
     */
    public void setRange_from(long range_from) {
        this.range_from = range_from;
    }

    /**
     * Getter method for property <tt>range_id</tt>
     *
     * @return property value of range_id
     */
    public long getRange_id() {
        return range_id;
    }

    /**
     * Setter method for property <tt>range_id</tt>.
     *
     * @param range_id value to be assigned to property range_id
     */
    public void setRange_id(long range_id) {
        this.range_id = range_id;
    }
}
