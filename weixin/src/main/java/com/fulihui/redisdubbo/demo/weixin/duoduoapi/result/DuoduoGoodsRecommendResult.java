package com.fulihui.redisdubbo.demo.weixin.duoduoapi.result;

import java.util.List;

/**
 * Created by lizhi on 2018/7/6 0006.
 */
public class DuoduoGoodsRecommendResult extends DuoduoJsonResult{


    private List<DuoduoGoodsApiResult> list;

    private String total;


    /**
     * Getter method for property <tt>list</tt>
     *
     * @return property value of list
     */
    public List<DuoduoGoodsApiResult> getList() {
        return list;
    }

    /**
     * Setter method for property <tt>list</tt>.
     *
     * @param list value to be assigned to property list
     */
    public void setList(List<DuoduoGoodsApiResult> list) {
        this.list = list;
    }

    /**
     * Getter method for property <tt>total</tt>
     *
     * @return property value of total
     */
    public String getTotal() {
        return total;
    }

    /**
     * Setter method for property <tt>total</tt>.
     *
     * @param total value to be assigned to property total
     */
    public void setTotal(String total) {
        this.total = total;
    }
}
