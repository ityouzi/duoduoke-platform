package com.fulihui.duoduoke.demo.web.weixin.duoapi.request;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fulihui.duoduoke.demo.web.weixin.duoapi.result.DuoOptResult;
import com.fulihui.duoduoke.demo.web.weixin.weixin.http.HttpMethodEnum;
import lombok.Getter;
import lombok.Setter;

/**
 * 类目查询
 * Created by lizhi on 2018/7/6 0006.
 */
@Setter
@Getter
public class DuoOptRequest extends DuoJsonRequest<DuoOptResult> {

    private static final long serialVersionUID = -5405273311249508029L;
    private String parent_opt_id;


    @Override
    protected void childParam() {
        addParam("parent_opt_id", parent_opt_id);
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
    public DuoOptResult parseResult(String respStr) {
        JSONObject jsonObject = JSONObject.parseObject(respStr);
        JSONObject personObject = jsonObject.getJSONObject("goods_opt_get_response");
        DuoOptResult result = JSON.parseObject(personObject.toString(), DuoOptResult.class);
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
