package com.fulihui.duoduoke.demo.web.weixin.duoduoapi.request;

import com.fulihui.duoduoke.demo.web.weixin.duoduoapi.result.LotteryUrlGenResult;
import com.fulihui.duoduoke.demo.web.weixin.weixin.http.HttpMethodEnum;

/**
 * Created by lizhi on 2018-12-06.
 */
public class LotteryUrlGenRequest extends DuoduoJsonRequest<LotteryUrlGenResult> {

    @Override
    protected void childParam() {

    }

    @Override
    public String service() {
        return null;
    }

    @Override
    public String urlEndStr() {
        return null;
    }

    @Override
    public LotteryUrlGenResult parseResult(String respStr) {
        return null;
    }

    @Override
    public HttpMethodEnum httpMethod() {
        return null;
    }

    @Override
    public String requestData() {
        return null;
    }
}
