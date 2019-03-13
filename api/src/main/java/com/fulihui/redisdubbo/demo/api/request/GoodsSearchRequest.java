package com.fulihui.redisdubbo.demo.api.request;

import lombok.Getter;
import lombok.Setter;
import org.near.servicesupport.request.PageRequest;

/**
 * @Description:
 * @Author: xiaoming
 * @version: v 0.1 2018/8/23 0023 11:00
 */
@Setter
@Getter
public class GoodsSearchRequest extends PageRequest {




    /**
     * 必填
     * 是否只返回优惠券的商品，false返回所有商品，true只返回有优惠券的商品
     */
    private boolean with_coupon;


    private String range_list;

    /**
     * 总页数
     */
    private Integer totalPage;

    /**
     * 格式[id,id]
     * 以逗号分隔
     */
    private String goodIds;

    private String isChoose;

    /**
     * 排序方式:0-综合排序;1-按佣金比率升序;
     * 2-按佣金比例降序;
     * 3-按价格升序;
     * 4-按价格降序;
     * 5-按销量升序;
     * 6-按销量降序;
     * 7-优惠券金额排序升序;
     * 8-优惠券金额排序降序;
     * 9-券后价升序排序;
     * 10-券后价降序排序;
     * 11-按照加入多多进宝时间升序;
     * 12-按照加入多多进宝时间降序;
     * 13-按佣金金额升序排序;
     * 14-按佣金金额降序排序;
     * 15-店铺描述评分升序;
     * 16-店铺描述评分降序;
     * 17-店铺物流评分升序;
     * 18-店铺物流评分降序;
     * 19-店铺服务评分升序;
     * 20-店铺服务评分降序;
     * 27-描述评分击败同类店铺百分比升序，
     * 28-描述评分击败同类店铺百分比降序，
     * 29-物流评分击败同类店铺百分比升序，
     * 30-物流评分击败同类店铺百分比降序，
     * 31-服务评分击败同类店铺百分比升序，
     * 32-服务评分击败同类店铺百分比降序
     */
    private int sort_type;//排序方式


    /**
     * 数据保存天数
     */
    private Integer saveDay;



}
