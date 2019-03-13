package com.fulihui.duoduoke.demo.web.weixin.weixin.util;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.near.toolkit.common.ArrayUtil;

/**
 *
 * Created by Willard on 2015/9/17.
 */
public class XMLUtil {

    static String[] ignore = { "utf8Encoding", "serialVersionUID" };

    /**
     * 对象转换xml字符串
     */
    public static <T> String toXMLString(T t) {
        if (t == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        List<Field> fields = ClassFieldsUtil.loopFileds(t.getClass());

        sb.append("<xml>");
        try {
            for (Field field : fields) {
                String fieldName = field.getName();
                if (ArrayUtil.contains(ignore, fieldName)) {
                    continue;
                }
                Object value = field.get(t);
                if (value == null || "".equals(value)) {
                    continue;
                }
                String startTag = "<" + fieldName + ">";
                String endTag = "</" + fieldName + ">";
                sb.append(startTag);
                if (field.getType() == String.class) {
                    sb.append("<![CDATA[");
                }
                sb.append(value);
                if (field.getType() == String.class) {
                    sb.append("]]>");
                }
                sb.append(endTag);
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        sb.append("</xml>");
        return sb.toString();
    }

    public static <T> T parseObject(InputStream in, Class<T> clz) {
        try {
            SAXReader reader = new SAXReader();
            return parseObject(reader.read(in), clz);
        } catch (DocumentException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * xml字符串解析成对象
     */
    public static <T> T parseObject(String xml, Class<T> clz) {
        try {
            return parseObject(DocumentHelper.parseText(xml), clz);
        } catch (DocumentException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T parseObject(Document doc, Class<T> clz) {
        try {
            T inst = clz.newInstance();
            List<Field> fields = ClassFieldsUtil.loopFileds(clz);
            Element root = doc.getRootElement();
            for (Field field : fields) {
                XmlElement xmlElement = field.getAnnotation(XmlElement.class);
                String fieldName;
                if (xmlElement != null) {
                    fieldName = xmlElement.name();
                } else {
                    fieldName = field.getName();
                }
                Class<?> type = field.getType();
                // 列表元素处理
                if (type == List.class) {
                    List list = new LinkedList();
                    int n = 0;
                    while (true) {
                        Element lstItem = root.element(fieldName + "_" + n);
                        if (lstItem == null) {
                            break;
                        }
                        Type genericType = field.getGenericType();
                        if (genericType != null && genericType instanceof ParameterizedType) {
                            ParameterizedType parameterizedType = (ParameterizedType) genericType;
                            Class<?> genericClazz = (Class<?>) parameterizedType
                                .getActualTypeArguments()[0];
                            list.add(formatValue(lstItem.getStringValue(), genericClazz));
                        } else {
                            list.add(lstItem.getStringValue());
                        }
                        n++;
                    }
                    field.set(inst, list);
                } else {
                    // 单个元素处理
                    Element elem = root.element(fieldName);
                    if (elem != null) {
                        field.set(inst, formatValue(elem.getStringValue(), type));
                    }
                }
            }
            return inst;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     *
     * @param value
     * @param type
     * @return
     */
    private static Object formatValue(String value, Class<?> type) {
        // XXX 简单的类型处理，没有处理嵌套
        Object result;
        if (type == String.class) {
            result = value;
        } else if (type == Integer.class || type == int.class) {
            result = Integer.parseInt(value);
        } else if (type == Long.class || type == long.class) {
            result = Long.parseLong(value);
        } else if (type == Float.class || type == float.class) {
            result = Float.parseFloat(value);
        } else if (type == Double.class || type == double.class) {
            result = Double.parseDouble(value);
        } else if (type == Boolean.class || type == boolean.class) {
            result = Boolean.parseBoolean(value);
        } else {
            throw new UnsupportedOperationException("Unsupport " + type.getName());
        }
        return result;
    }

}
