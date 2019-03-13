package com.fulihui.redisdubbo.demo.weixin.duoduoapi.request;

import com.alibaba.fastjson.JSONObject;
import com.fulihui.redisdubbo.demo.weixin.duoduoapi.result.OrderColorIncrementResult;
import com.fulihui.redisdubbo.demo.weixin.weixin.http.HttpMethodEnum;
import lombok.Getter;
import lombok.Setter;

/**
 * @author wahaha
 */
@Getter
@Setter
public class OrderColorIncrementRequest extends DuoduoJsonRequest<OrderColorIncrementResult> {
    private static final long serialVersionUID = -8966607925923725856L;

    /**
     */
    private String            start_update_time;
    /**
     */
    private String            end_update_time;
    /**
     */

    private int               page_size;
    private int               page;

    private boolean           return_count;

    @Override
    protected void childParam() {
        addParam("start_update_time", start_update_time);
        addParam("end_update_time", end_update_time);

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
    public OrderColorIncrementResult parseResult(String respStr) {
        OrderColorIncrementResult result = JSONObject.parseObject(respStr,
            OrderColorIncrementResult.class);
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