package com.fulihui.redisdubbo.demo.security;


import com.fulihui.redisdubbo.demo.security.common.AuthUserModel;
import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lizhi
 * @date 2016-10-19
 */
public class TokenAuthenticationFilter extends OncePerRequestFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(TokenAuthenticationFilter.class);

    TokenHelper tokenHelper;

    UserDetailsService userDetailsService;

    /**
     * Instantiates a new Token authentication filter.
     *
     * @param tokenHelper        the token helper
     * @param userDetailsService the user details service
     */
    public TokenAuthenticationFilter(TokenHelper tokenHelper, UserDetailsService userDetailsService) {
        this.tokenHelper = tokenHelper;
        this.userDetailsService = userDetailsService;
    }


    @Override
    public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {

        String accountNo;
        String authToken = tokenHelper.getToken(request);

        if (authToken != null) {
            // 从前端header提交token值获取用户Id 账号信息
            accountNo = tokenHelper.getAccountNoFromToken(authToken);
            if (accountNo != null) {
                // //根据userId查询用户主体信息
                UserDetails userDetails;
                try {
                    userDetails = userDetailsService.loadUserByUsername(accountNo);
                } catch (UsernameNotFoundException e) {
                    LOGGER.error(e.getMessage(), e);
                    response.setStatus(HttpStatus.SC_UNAUTHORIZED);
                    chain.doFilter(request, response);
                    return;
                }
                //验证前端提交
                Boolean validateToken = tokenHelper.validateToken(authToken, userDetails);
                //如果验证成功
                if (validateToken) {
                    // create authentication
                    TokenBasedAuthentication authentication = new TokenBasedAuthentication(userDetails);
                    authentication.setToken(authToken);
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                    Authentication get = SecurityContextHolder.getContext().getAuthentication();
                    AuthUserModel principal = (AuthUserModel) get.getPrincipal();
                    LOGGER.debug("上下文信息,Authentication:{}", principal);

                }
            }
        }
        chain.doFilter(request, response);
    }

}