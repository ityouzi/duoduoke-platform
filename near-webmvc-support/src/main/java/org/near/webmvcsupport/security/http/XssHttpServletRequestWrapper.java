package org.near.webmvcsupport.security.http;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.commons.lang3.StringEscapeUtils;

/**
 * xss http 请求封装
 * Created by Willard on 2015/9/21.
 */
public class XssHttpServletRequestWrapper extends HttpServletRequestWrapper {

    public XssHttpServletRequestWrapper(HttpServletRequest request) {
        super(request);
    }

    @Override
    public String getHeader(String name) {
        return escape(super.getHeader(name));
    }

    @Override
    public String getParameter(String name) {
        return escape(super.getParameter(name));
    }

    @Override
    public String[] getParameterValues(String name) {
        String[] values = super.getParameterValues(name);
        if (values != null) {
            int length = values.length;
            String[] escapseValues = new String[length];
            for (int i = 0; i < length; i++) {
                escapseValues[i] = escape(values[i]);
            }
            return escapseValues;
        }
        return super.getParameterValues(name);
    }

    private String escape(String input) {
        if (input == null) {
            return null;
        }
        String tmp = StringEscapeUtils.escapeHtml4(input);
        return StringEscapeUtils.escapeEcmaScript(tmp);
    }

}
