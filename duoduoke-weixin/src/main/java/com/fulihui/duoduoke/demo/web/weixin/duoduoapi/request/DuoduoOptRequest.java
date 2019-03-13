package com.fulihui.duoduoke.demo.web.weixin.duoduoapi.request;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fulihui.duoduoke.demo.web.weixin.duoduoapi.result.DuoduoOptResult;
import com.fulihui.duoduoke.demo.web.weixin.weixin.http.HttpMethodEnum;

/**类目查询
 * Created by lizhi on 2018/7/6 0006.
 */
    public class DuoduoOptRequest extends DuoduoJsonRequest<DuoduoOptResult> {

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
    public DuoduoOptResult parseResult(String respStr) {
        JSONObject jsonObject = JSONObject.parseObject(respStr);
        JSONObject personObject = jsonObject.getJSONObject("goods_opt_get_response");
        DuoduoOptResult result = JSON.parseObject(personObject.toString(), DuoduoOptResult.class);
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

    public String getParent_opt_id() {
        return parent_opt_id;
    }

    public void setParent_opt_id(String parent_opt_id) {
        this.parent_opt_id = parent_opt_id;
    }
}
