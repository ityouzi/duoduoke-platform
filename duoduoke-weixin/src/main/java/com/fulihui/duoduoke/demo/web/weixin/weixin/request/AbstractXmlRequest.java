package com.fulihui.duoduoke.demo.web.weixin.weixin.request;


import com.fulihui.duoduoke.demo.web.weixin.weixin.util.XStreams;

/**
 * @author Willard.Hu on 2017/11/28.
 */
public abstract class AbstractXmlRequest<T> extends WeixinRequest<T> {
    private static final long serialVersionUID = 7857126946015185564L;

    public String toXML() {
        return XStreams.build(AbstractXmlRequest.class, getClass()).toXML(this);
    }

    @Override
    protected void childParam() {
    }

    @Override
    public String urlEndStr() {
        return null;
    }
}
