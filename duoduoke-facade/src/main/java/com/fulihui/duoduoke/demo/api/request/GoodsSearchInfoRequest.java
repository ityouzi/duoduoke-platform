package com.fulihui.duoduoke.demo.api.request;

import lombok.Getter;
import lombok.Setter;
import org.near.servicesupport.request.PageRequest;

import java.util.List;

/**
 * @author lizhi
 * @date 2018-7-7
 */
@Setter
@Getter
public class GoodsSearchInfoRequest extends PageRequest {

    private static final long serialVersionUID = 4748373293701655008L;
    /**
     * 必填
     * 排序方式：0-综合排序；
     * 1-按佣金比率升序；
     * 2-按佣金比例降序；
     * 3-按价格升序；
     * 4-按价格降序；
     * 5-按销量升序；
     * 6-按销量降序；
     * 7-优惠券金额排序升序；
     * 8-优惠券金额排序降序；
     * 9-券后价升序排序；
     * 10-券后价降序排序；
     * 11-按照加入多多进宝时间升序；
     * 12-按照加入多多进宝时间降序；
     * 13-按佣金金额升序排序；
     * 14-按佣金金额降序排序；
     * 15-店铺描述评分升序；
     * 16-店铺描述评分降序；
     * 17-店铺物流评分升序；
     * 18-店铺物流评分降序；
     * 19-店铺服务评分升序；
     * 20-店铺服务评分降序
     */
    private String sort_type;

    /**
     * 关键词
     */
    private String keyword;

    /**
     * 必填
     * 是否只返回优惠券的商品，false返回所有商品，true只返回有优惠券的商品
     */
    private String with_coupon;

    /**
     * 类目Id
     */
    private String cat_id;

    /**
     * 范围列表
     */
    List<GoodsSearchInfoRangeRequest> range_list;
    /**
     *  goodsId list
     *
     * */
    private List<String> goods_id_list;
}
