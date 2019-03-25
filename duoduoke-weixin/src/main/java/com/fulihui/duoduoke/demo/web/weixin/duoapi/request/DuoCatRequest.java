package com.fulihui.duoduoke.demo.web.weixin.duoapi.request;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.fulihui.duoduoke.demo.web.weixin.duoapi.result.DuoCatResult;
import com.fulihui.duoduoke.demo.web.weixin.weixin.http.HttpMethodEnum;
import lombok.Getter;
import lombok.Setter;

/**
 * 类目查询
 * Created by lizhi on 2018/7/6 0006.
 */
@Setter
@Getter
public class DuoCatRequest extends DuoJsonRequest<DuoCatResult> {

    private static final long serialVersionUID = -5405273311249508029L;


    private String parent_cat_id;


    @Override
    protected void childParam() {
        addParam("parent_cat_id", parent_cat_id);
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
    public DuoCatResult parseResult(String respStr) {
        DuoCatResult result = JSONObject.parseObject(respStr, DuoCatResult.class, new Feature[0]);
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
