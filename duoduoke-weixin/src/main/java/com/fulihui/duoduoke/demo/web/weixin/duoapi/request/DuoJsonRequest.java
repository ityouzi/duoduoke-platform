package com.fulihui.duoduoke.demo.web.weixin.duoapi.request;

import java.util.Map;
import java.util.TreeMap;

import org.near.toolkit.common.StringUtil;

import com.fulihui.duoduoke.demo.web.weixin.duoapi.result.DuoJsonResult;

/**
 * @Description:
 * @Author: xiaoming
 * @version: v 0.1 2018/7/6 0006 16:08
 */
public abstract class DuoJsonRequest<T> extends DuoRequest<T> {

    private static final long serialVersionUID = 7676814609092840162L;


    private String type;

    private String client_id;

    private String access_token;

    private String timestamp;

    private String data_type = "JSON";

    private String version;

    private String sign;

    /**
     * 参数
     */
    protected Map<String, String> param = new TreeMap<>();

    @Override
    public Map<String, String> urlParam() {
        addParam("type", type);
        addParam("client_id", client_id);
        addParam("access_token", access_token);
        addParam("timestamp", timestamp);
        addParam("data_type", data_type);
        addParam("version", version);
        addParam("sign", sign);
        childParam();
        return param;
    }

    protected void addParam(String key, String value) {
        if (StringUtil.isNotBlank(value)) {
            param.put(key, value);
        }
    }

    protected void checkResult(DuoJsonResult result) {
        result.setSuccess(StringUtil.isBlank(result.getError_code())
                || StringUtil.isBlank(result.getError_msg()));
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getData_type() {
        return data_type;
    }

    public void setData_type(String data_type) {
        this.data_type = data_type;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}
