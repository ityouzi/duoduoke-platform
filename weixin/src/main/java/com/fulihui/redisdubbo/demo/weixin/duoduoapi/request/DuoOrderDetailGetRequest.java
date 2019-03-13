package com.fulihui.redisdubbo.demo.weixin.duoduoapi.request;

import com.alibaba.fastjson.JSONObject;
import com.fulihui.redisdubbo.demo.weixin.duoduoapi.result.DuoOrderDetailGetResult;
import com.fulihui.redisdubbo.demo.weixin.weixin.http.HttpMethodEnum;

/**
 * @author wahaha
 */
public class DuoOrderDetailGetRequest   extends DuoduoJsonRequest<DuoOrderDetailGetResult> {


    /**
     */
    private String order_sn;

    public String getOrder_sn() {
        return order_sn;
    }

    public void setOrder_sn(String order_sn) {
        this.order_sn = order_sn;
    }

    @Override
    protected void childParam() {
        addParam("order_sn", order_sn);


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
    public DuoOrderDetailGetResult parseResult(String respStr) {
        DuoOrderDetailGetResult result = JSONObject.parseObject(respStr, DuoOrderDetailGetResult.class);
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
