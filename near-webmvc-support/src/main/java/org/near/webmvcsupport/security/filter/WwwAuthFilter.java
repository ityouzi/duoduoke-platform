/*
 * Copyright 1999-2015 dangdang.com.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * </p>
 */

package org.near.webmvcsupport.security.filter;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.codec.binary.Base64;
import org.near.toolkit.common.StringUtil;
import org.near.webmvcsupport.security.model.BasicAuthConfig;
import org.near.webmvcsupport.security.model.BasicAuthStaff;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * 浏览器自带Basic Auth权限处理过滤
 * Created by LeeSon on 2016/6/28 0028.
 */
public final class WwwAuthFilter implements Filter {
    private final Logger        LOG                  = LoggerFactory.getLogger(getClass());

    /** Basic Auth Http请求头 */
    private static final String AUTH_PREFIX          = "Basic ";

    private static final long   DEFAULT_EXPIRES_TIME = 20;

    /** Basic Auth 权限配置 */
    private BasicAuthConfig     basicAuthConfig;

    /** 失效时间，单位（分钟），默认20分钟 */
    private long                expiresTime          = DEFAULT_EXPIRES_TIME;

    /**
     * Filter 初始化处理
     * @param filterConfig {@link FilterConfig}
     * @throws ServletException ServletException
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String authPath = filterConfig.getInitParameter("authPath");

        if (StringUtil.isBlank(authPath)) {
            LOG.warn("Cannot found auth config, use default auth config.");
        } else {
            // 解析文件
            try (BufferedReader br = new BufferedReader(new FileReader(authPath))) {
                String jsonLine;
                StringBuilder json = new StringBuilder();
                while ((jsonLine = br.readLine()) != null) {
                    json.append(jsonLine);
                }
                this.basicAuthConfig = JSONObject.parseObject(json.toString(),
                    BasicAuthConfig.class);
                if (this.basicAuthConfig.getAuthExpires() > 0) {
                    this.expiresTime = this.basicAuthConfig.getAuthExpires();
                }
            } catch (Exception e) {
                throw new ServletException(e);
            }
        }
    }

    /**
     * Filter 销毁处理
     */
    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(final ServletRequest request, final ServletResponse response,
                         final FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        String authorization = httpRequest.getHeader("authorization");
        boolean authed = false;
        if (null != authorization && authorization.length() > AUTH_PREFIX.length()) {
            final String authStaff = authorization.substring(AUTH_PREFIX.length(),
                authorization.length());
            if (basicAuthConfig != null && basicAuthConfig.getStaffList() != null) {
                for (BasicAuthStaff staff : basicAuthConfig.getStaffList()) {
                    if (StringUtil.equals(staff.getUser() + ":" + staff.getPasswd(), new String(
                        Base64.decodeBase64(authStaff)))) {
                        authed = true;
                        break;
                    }
                }
            }
        }
        if (authed) {
            authenticateSuccess(httpResponse);
            chain.doFilter(httpRequest, httpResponse);
        } else {
            needAuthenticate(httpResponse);
        }
    }

    private void authenticateSuccess(HttpServletResponse response) {
        response.setStatus(200);
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-store");
        response.setDateHeader("Expires",
            System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(this.expiresTime));
    }

    private void needAuthenticate(HttpServletResponse response) {
        response.setStatus(401);
        response.setHeader("Cache-Control", "no-store");
        response.setDateHeader("Expires", 0);
        response.setHeader("WWW-authenticate", AUTH_PREFIX + "Realm=\"Fulihui BizManage Auth\"");
    }

}
