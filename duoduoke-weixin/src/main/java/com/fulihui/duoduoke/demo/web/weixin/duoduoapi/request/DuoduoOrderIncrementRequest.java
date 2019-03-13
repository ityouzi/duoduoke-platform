package com.fulihui.duoduoke.demo.web.weixin.duoduoapi.request;

import com.alibaba.fastjson.JSONObject;
import com.fulihui.duoduoke.demo.web.weixin.duoduoapi.result.OrderSnIncrementResult;
import com.fulihui.duoduoke.demo.web.weixin.weixin.http.HttpMethodEnum;

import lombok.Getter;
import lombok.Setter;

/**
 * 订单增量接口
 * <p>
 *
 * @author lizhi
 * @date 2018-7-8
 */
@Setter
@Getter
public class DuoduoOrderIncrementRequest extends DuoduoJsonRequest<OrderSnIncrementResult> {
    private static final long serialVersionUID = -8966607925923725856L;

    /**
     */
    private String            start_update_time;
    /**
     */
    private String            end_update_time;
    /**
     */
    private String            p_id;
    private int               page_size;
    private int               page;

    private boolean           return_count;

    @Override
    protected void childParam() {
        addParam("start_update_time", start_update_time);
        addParam("end_update_time", end_update_time);
        addParam("p_id", p_id);
        addParam("page_size", page_size + "");
        addParam("page", page + "");
        addParam("return_count", return_count + "");

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
    public OrderSnIncrementResult parseResult(String respStr) {
        OrderSnIncrementResult result = JSONObject.parseObject(respStr,
            OrderSnIncrementResult.class);
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
