package com.fulihui.redisdubbo.demo.weixin.duoduoapi.request;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fulihui.redisdubbo.demo.weixin.duoduoapi.result.DuoduoGoodsRecommendResult;
import com.fulihui.redisdubbo.demo.weixin.weixin.http.HttpMethodEnum;

/**
 * @Description:
 * @Author: xiaoming
 * @version: v 0.1 2018/8/14 0014 17:11
 */
public class DuoduoGoodsRecommendRequest extends DuoduoJsonRequest<DuoduoGoodsRecommendResult> {

    private int offset;

    private int limit;

    private int channel_type;




    @Override
    protected void childParam() {
        addParam("offset",offset+"");
        addParam("limit",limit+"");
        addParam("channel_type",channel_type+"");
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
    public DuoduoGoodsRecommendResult parseResult(String respStr) {
        DuoduoGoodsRecommendResult result = new DuoduoGoodsRecommendResult();
        if(result != null){
            JSONObject jsonObject = JSONObject.parseObject(respStr);
            JSONObject personObject = jsonObject.getJSONObject("goods_basic_detail_response");
            if(personObject == null){
                JSONObject errorObject = jsonObject.getJSONObject("error_response");
                result = JSON.parseObject(errorObject.toString(), DuoduoGoodsRecommendResult.class);
                return result;
            }else {
                result = JSON.parseObject(personObject.toString(), DuoduoGoodsRecommendResult.class);
                checkResult(result);
                return result;
            }
        }
        return null;

    }

    @Override
    public HttpMethodEnum httpMethod() {
        return HttpMethodEnum.POST;
    }

    @Override
    public String requestData() {
        return null;
    }

    /**
     * Getter method for property <tt>offset</tt>
     *
     * @return property value of offset
     */
    public int getOffset() {
        return offset;
    }

    /**
     * Setter method for property <tt>offset</tt>.
     *
     * @param offset value to be assigned to property offset
     */
    public void setOffset(int offset) {
        this.offset = offset;
    }

    /**
     * Getter method for property <tt>limit</tt>
     *
     * @return property value of limit
     */
    public int getLimit() {
        return limit;
    }

    /**
     * Setter method for property <tt>limit</tt>.
     *
     * @param limit value to be assigned to property limit
     */
    public void setLimit(int limit) {
        this.limit = limit;
    }

    /**
     * Getter method for property <tt>channel_type</tt>
     *
     * @return property value of channel_type
     */
    public int getChannel_type() {
        return channel_type;
    }

    /**
     * Setter method for property <tt>channel_type</tt>.
     *
     * @param channel_type value to be assigned to property channel_type
     */
    public void setChannel_type(int channel_type) {
        this.channel_type = channel_type;
    }
}
