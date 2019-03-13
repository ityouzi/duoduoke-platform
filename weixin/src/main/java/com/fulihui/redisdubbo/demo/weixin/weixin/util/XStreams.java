package com.fulihui.redisdubbo.demo.weixin.weixin.util;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.XmlFriendlyNameCoder;
import com.thoughtworks.xstream.io.xml.XppDriver;

/**
 * @author Willard.Hu on 2017/11/28.
 */
public class XStreams {

    /**
     * 构建 XStreams 对象
     * @param types 待解析构造的类
     * @return {@link XStream}
     */
    public static XStream build(Class... types) {
        XStream xStream = new XStream(new XppDriver(new XmlFriendlyNameCoder("_-", "_")));
        xStream.processAnnotations(types);
        xStream.aliasSystemAttribute(null, "class");
        return xStream;
    }
}
