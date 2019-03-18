package com.fulihui.duoduoke.demo.web.weixin.duoduoapi.request;

import com.alibaba.fastjson.JSONObject;
import com.fulihui.duoduoke.demo.web.weixin.duoduoapi.result.DuoGoodsPidResult;
import com.fulihui.duoduoke.demo.web.weixin.weixin.http.HttpMethodEnum;

import lombok.Getter;
import lombok.Setter;

/**
 * 查询已经生成的推广位信息
 * Created by lizhi on 2018-7-9.
 */
@Setter
@Getter
public class DuoGoodsPidRequest extends DuoJsonRequest<DuoGoodsPidResult> {


    private static final long serialVersionUID = -4630586958245008164L;
    private String page;


    private String page_size;

    @Override
    protected void childParam() {

        addParam("page", page);
        addParam("page_size", page_size);
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
    public DuoGoodsPidResult parseResult(String respStr) {
        DuoGoodsPidResult duoduoGoodsPidResult = JSONObject.parseObject(respStr, DuoGoodsPidResult.class);
        checkResult(duoduoGoodsPidResult);
        return duoduoGoodsPidResult;
    }

    @Override
    public HttpMethodEnum httpMethod() {
        return HttpMethodEnum.POST;
    }

    @Override
    public String requestData() {
        return null;
    }

    //pdd.ddk.goods.pid.query
}
