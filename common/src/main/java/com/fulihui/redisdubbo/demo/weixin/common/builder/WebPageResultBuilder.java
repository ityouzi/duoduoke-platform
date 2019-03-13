package com.fulihui.redisdubbo.demo.weixin.common.builder;

import com.fulihui.redisdubbo.demo.weixin.common.result.WebPageResult;
import com.fulihui.redisdubbo.demo.weixin.common.result.WebResult;
import org.springframework.beans.BeanUtils;

/**
 * @author: JY
 * @date: 2018/7/6 18:53
 */
public class WebPageResultBuilder{

    protected WebPageResult pageResult;

    public WebPageResultBuilder(WebResult result){
        pageResult = new WebPageResult();
        BeanUtils.copyProperties(result,pageResult);
    }

    /**
     * 设置分页条数
     * @param count
     * @return
     */
    public WebPageResultBuilder count(Integer count){

        pageResult.setCount(count);

        return  this;
    }

    public WebPageResult builder() {
        return pageResult;
    }
}
