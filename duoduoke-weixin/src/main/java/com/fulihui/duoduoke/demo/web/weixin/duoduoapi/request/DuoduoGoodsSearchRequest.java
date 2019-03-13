package com.fulihui.duoduoke.demo.web.weixin.duoduoapi.request;

import com.alibaba.fastjson.JSONObject;
import com.fulihui.duoduoke.demo.web.weixin.duoduoapi.result.DuoduoGoodsSearchResult;
import com.fulihui.duoduoke.demo.web.weixin.weixin.http.HttpMethodEnum;

import lombok.Getter;
import lombok.Setter;

/**
 * pdd.ddk.goods.search（多多进宝商品查询）
 *
 * @author lizhi
 * @date 2018-7-9
 */
@Setter
@Getter
public class DuoduoGoodsSearchRequest extends DuoduoJsonRequest<DuoduoGoodsSearchResult> {

    /**
     * 非必填
     * 与opt_id字段选填一个或全部填写
     */
    private String keyword;
    /**
     * 非必填
     */
    private String opt_id;
    /**
     * 非必填
     * 默认值1，商品分页数
     */
    private String page;
    /**
     * 非必填
     * <p>
     * 默认100，每页商品数量
     */
    private String page_size;
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
     * 必填
     * <p>
     * 是否只返回优惠券的商品，false返回所有商品，true只返回有优惠券的商品
     */
    private String with_coupon;

    /**
     * 商品类目ID，使用pdd.goods.cats.get接口获取
     */
    private String cat_id;
    /**
     * 商品ID列表。例如：[123456,123]，当入参带有goods_id_list字段，将不会以opt_id、 cat_id、keyword维度筛选商品
     */
    private String goods_id_list;
    /**
     * [{"range_id":0,"range_from":1,"range_to":1500},{"range_id":1,"range_from":1,"range_to":1500}]
     */
    public String range_list;

    @Setter @Getter
    public static class Range {

        private String range_id;
        private String range_from;
        private String range_to;


    }

    @Override
    protected void childParam() {
        addParam("keyword", keyword);
        addParam("opt_id", opt_id);
        addParam("page", page);
        addParam("page_size", page_size);
        addParam("sort_type", sort_type);
        addParam("with_coupon", with_coupon);
        addParam("cat_id", cat_id);
        addParam("range_list", range_list);
        addParam("goods_id_list", goods_id_list);

    }

    @Override
    public String service() {
        return "http://gw-api.pinduoduo.com/api/router";

    }


    @Override
    public String urlEndStr() {
        return null;
    }

    @Override
    public DuoduoGoodsSearchResult parseResult(String respStr) {
        DuoduoGoodsSearchResult result = JSONObject.parseObject(respStr, DuoduoGoodsSearchResult.class);
        checkResult(result);
        return result;
    }

    @Override
    public HttpMethodEnum httpMethod() {
        return HttpMethodEnum.POST;
    }

    @Override
    public String requestData() {
        return null;
    }
}

