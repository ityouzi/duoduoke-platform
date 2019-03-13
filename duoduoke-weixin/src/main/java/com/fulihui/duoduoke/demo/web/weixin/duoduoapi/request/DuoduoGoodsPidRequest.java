package com.fulihui.duoduoke.demo.web.weixin.duoduoapi.request;

import com.alibaba.fastjson.JSONObject;
import com.fulihui.duoduoke.demo.web.weixin.duoduoapi.result.DuoduoGoodsPidResult;
import com.fulihui.duoduoke.demo.web.weixin.weixin.http.HttpMethodEnum;

import lombok.Getter;
import lombok.Setter;

/**
 * 查询已经生成的推广位信息
 * Created by lizhi on 2018-7-9.
 */
@Setter
@Getter
public class DuoduoGoodsPidRequest extends DuoduoJsonRequest<DuoduoGoodsPidResult> {


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
    public DuoduoGoodsPidResult parseResult(String respStr) {
        DuoduoGoodsPidResult duoduoGoodsPidResult = JSONObject.parseObject(respStr, DuoduoGoodsPidResult.class);
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
