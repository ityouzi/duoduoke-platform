package com.fulihui.duoduoke.demo.web.weixin.duoapi.request;

import com.fulihui.duoduoke.demo.web.weixin.duoapi.result.LotteryUrlGenResult;
import com.fulihui.duoduoke.demo.web.weixin.weixin.http.HttpMethodEnum;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by lizhi on 2018-12-06.
 */
@Setter
@Getter
public class LotteryUrlGenRequest extends DuoJsonRequest<LotteryUrlGenResult> {

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
