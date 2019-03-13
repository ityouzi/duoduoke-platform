package com.fulihui.redisdubbo.demo.weixin.duoduoapi.request;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fulihui.redisdubbo.demo.weixin.duoduoapi.result.DuoduoCatResult;
import com.fulihui.redisdubbo.demo.weixin.weixin.http.HttpMethodEnum;

/**类目查询
 * Created by lizhi on 2018/7/6 0006.
 */
public class DuoduoCatRequest extends DuoduoJsonRequest<DuoduoCatResult> {

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
    public DuoduoCatResult parseResult(String respStr) {
        JSONObject jsonObject = JSONObject.parseObject(respStr);
        JSONObject personObject = jsonObject.getJSONObject("goods_cats_get_response");
        DuoduoCatResult result = JSON.parseObject(personObject.toString(), DuoduoCatResult.class);
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

    public String getParent_cat_id() {
        return parent_cat_id;
    }

    public void setParent_cat_id(String parent_cat_id) {
        this.parent_cat_id = parent_cat_id;
    }
}
