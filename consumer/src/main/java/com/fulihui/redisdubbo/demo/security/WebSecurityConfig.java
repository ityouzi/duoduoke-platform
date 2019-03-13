package com.fulihui.redisdubbo.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.userdetails.DaoAuthenticationConfigurer;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsUtils;

/**
 * @author lizhi
 * @date 2016-10-19
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Order(1)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    RestAuthenticationEntryPoint restAuthenticationEntryPoint;


    @Autowired
    UserDetailsServiceImpl userDetailsService;


    @Autowired
    TokenHelper tokenHelper;


    @Bean(name = "authenticationManager")
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }


    /**
     * Configure global.
     *
     * @param auth the auth
     * @throws Exception the exception
     */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        DaoAuthenticationConfigurer<AuthenticationManagerBuilder, UserDetailsServiceImpl> configurer = auth.userDetailsService(userDetailsService);


    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .exceptionHandling().authenticationEntryPoint(restAuthenticationEntryPoint).and()
                .authorizeRequests().
                requestMatchers(CorsUtils::isPreFlightRequest).permitAll().antMatchers("/wechatAuth/auth").permitAll()
                .anyRequest().authenticated().and()
                .addFilterBefore(new TokenAuthenticationFilter(tokenHelper, userDetailsService), BasicAuthenticationFilter.class);

        http.csrf().disable();
    }


    /**
     * http
     * // 由于使用的是JWT，我们这里不需要csrf
     * .csrf().disable()
     * // 基于token，所以不需要session
     * .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
     * .authorizeRequests()
     * // 所有 / 的所有请求 都放行
     * .requestMatchers(CorsUtils::isPreFlightRequest).permitAll()    //对preflight放行
     * .antMatchers("/*").permitAll()
     * .antMatchers("/u").denyAll()
     * .antMatchers("/article/**").permitAll()
     * .antMatchers("/video/**").permitAll()
     * .antMatchers("/api/**").permitAll()
     * .antMatchers("/v2/api-docs", "/configuration/ui", "/swagger-resources/**", "/configuration/**","/swagger-ui.html", "/webjars/**")
     * .permitAll()
     * .antMatchers("/manage/**").hasRole("ADMIN") // 需要相应的角色才能访问
     * // 除上面外的所有请求全部需要鉴权认证
     * .anyRequest().authenticated();
     * <p>
     * // 禁用缓存
     * http.headers().cacheControl();
     * // 添加JWT filter
     * http.addFilterBefore(authenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class);
     * //添加未授权处理
     * http.exceptionHandling().authenticationEntryPoint(getAuthenticationEntryPoint());
     * //权限不足处理
     * http.exceptionHandling().accessDeniedHandler(getAccessDeniedHandler());
     *
     * @param web
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        // TokenAuthenticationFilter will ignore the below paths
//        忽略
        web.ignoring().antMatchers("/wechatAuth/auth",
                "/goodsCatInfo/goodsCatTreeInfo",
                "/goodsCatInfo/search",
                "/goodsCatInfo/goodsCatInfo",
                "/goodsInfo/goodsChannelTypeList",
                "/goodsInfo/goodsList",
                "/goodsInfo/goodsListInfo",
                "/goodsInfo/goodsDetail",
                "/homeColumn/columnList",
                "/homeColumn/columnImg",
                "/keyWordInfo/keyWordListInfo",
                "/advert/advertList",
                "/duoAuth/auth",
                "/duoAuth/callback",
                "/duoAuth/refreshToken",
                "/goodsInfo/imgConvert",
                "/banner/bannerList"


        );

        //忽略
        web.ignoring().antMatchers(
                HttpMethod.GET,
                "/",
                "/**/webjars/**",
                "/**/store/**",
                "/**/swagger-resources",
                "/**/configuration/security",
                "/**/configuration/ui",
                "/**/swagger-ui.html",
                "/**/static/**",
                "/**/sofaboot/**",
                "/**/health/**",
                "/**/doc.html",
                "/*.html",
                "/**/v2/api-docs",
                "/**/favicon.ico",
                "/**/*.html",
                "/duoAuth/auth",
                "/duoAuth/callback",
                "/duoAuth/refreshToken",
                "/**/*.css",
                "/**/*.js"
        );
        web.ignoring().antMatchers(
                HttpMethod.POST,
                "/",
                "/**/store/**"
        );
    }
}
