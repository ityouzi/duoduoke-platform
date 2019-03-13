package com.fulihui.redisdubbo.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.fulihui.redisdubbo.demo.api.dto.UserDTO;
import com.fulihui.redisdubbo.demo.api.enums.UserTypeEnum;
import com.fulihui.redisdubbo.demo.api.request.UserUpdateRequest;
import com.fulihui.redisdubbo.demo.api.request.UserWechatLoginRequest;
import com.fulihui.redisdubbo.demo.integration.UserServiceClient;
import com.fulihui.redisdubbo.demo.manager.UserFormManager;
import com.fulihui.redisdubbo.demo.manager.UserManager;
import com.fulihui.redisdubbo.demo.manager.WeChatManager;
import com.fulihui.redisdubbo.demo.model.AuthSuccessModel;
import com.fulihui.redisdubbo.demo.model.UserInfoModel;
import com.fulihui.redisdubbo.demo.param.FormIdParam;
import com.fulihui.redisdubbo.demo.param.GetUserParam;
import com.fulihui.redisdubbo.demo.param.WechatAppAuthParam;
import com.fulihui.redisdubbo.demo.security.TokenHelper;
import com.fulihui.redisdubbo.demo.util.Principal;
import com.fulihui.redisdubbo.demo.util.PrincipalUtil;
import com.fulihui.redisdubbo.demo.vo.AuthTokenVO;
import com.fulihui.redisdubbo.demo.weixin.common.config.DuoDuoKeConfig;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.near.servicesupport.result.TSingleResult;
import org.near.toolkit.common.StringUtil;
import org.near.webmvcsupport.view.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.near.webmvcsupport.view.JsonResultBuilder.fail;
import static org.near.webmvcsupport.view.JsonResultBuilder.succ;

/**
 * The type Wechat auth app auth controller.
 *
 * @author lizhi
 * @date 2018 -7-7
 */
@RestController
@RequestMapping("/wechatAuth")
@Api(description = "用户授权")
public class WechatAuthAppAuthController {

    private static final Logger LOGGER = LoggerFactory.getLogger(WechatAuthAppAuthController.class);

    /**
     * The Wechat manager.
     */
    @Autowired
    WeChatManager wechatManager;

    /**
     * The User form manager.
     */
    @Autowired
    UserFormManager userFormManager;

    /**
     * The Duo duo ke config.
     */
    @Autowired
    DuoDuoKeConfig duoDuoKeConfig;

    /**
     * The User service.
     */
    @Autowired
    UserServiceClient userServiceClient;

    /**
     * The Authentication manager.
     */
    @Autowired
    AuthenticationManager authenticationManager;

    /**
     * The Principal util.
     */
    @Autowired
    PrincipalUtil principalUtil;

    /**
     * The Token helper.
     */
    @Autowired
    TokenHelper tokenHelper;

    @Autowired
    UserManager userManager;

    /**
     * Gets user.
     *
     * @param param   the param
     * @param request the request
     * @return the user
     */
    @PostMapping("takeUserInfo")
    @ApiOperation("小程序用户信息")
    public JsonResult takeUserInfo(@RequestBody GetUserParam param, HttpServletRequest request) {
        LOGGER.info("param:{}", param);
        String userInfo = param.getUserInfo();
        if (StringUtil.isNotBlank(userInfo)) {
            UserInfoModel model = JSONObject.parseObject(userInfo, UserInfoModel.class);
            Principal principal = PrincipalUtil.getPrincipal();
            UserUpdateRequest updateRequest = new UserUpdateRequest();
            updateRequest.setGender(model.getUserInfo().getGender());
            updateRequest.setUserId(principal.getUserId());
            updateRequest.setNickName(model.getUserInfo().getNickName());
            updateRequest.setAvatarUrl(model.getUserInfo().getAvatarUrl());
            userServiceClient.update(updateRequest);
        }
        return succ();
    }

    /**
     * Entry json result.
     *
     * @param param   the param
     * @param request the request
     * @return the json result
     */
    @PostMapping("entry")
    @ApiOperation("小程序formId录入")
    public JsonResult entry(@RequestBody FormIdParam param, HttpServletRequest request) {
        Principal principal = PrincipalUtil.getPrincipal();
        userFormManager.add(principal.getOpenId(), principal.getUserId(), param.getFormId());
        return succ();
    }

    /**
     * Auth json result.
     *
     * @param param    the param
     * @param response the response
     * @param request  the request
     * @return the json result
     */
    @PostMapping("auth")
    @ApiOperation("多多小程序授权接口")
    public JsonResult auth(@RequestBody WechatAppAuthParam param, HttpServletResponse response, HttpServletRequest request) {
        LOGGER.debug("多多小程序授权接口开始,根据code兑换openId");

        String openIdByCode = wechatManager.getOpenIdByCode(param.getCode());
        LOGGER.info("多多小程序授权接口,openIdByCode:{},code:{},encryptedData:{},userReferee:{}",
                openIdByCode, param.getCode(), param.getEncryptedData(), param.getUserReferee());
        if (StringUtil.isBlank(openIdByCode)) {
            LOGGER.error("根据code兑换微信openId失败");
            return fail("101", "根据code获取openId失败!");
        }
        AuthSuccessModel model = JSONObject.parseObject(openIdByCode, AuthSuccessModel.class);
        if (model == null) {
            LOGGER.error("微信返回openId模型转换失败");
            return fail("101", "根据code获取openId失败");
        }

        UserWechatLoginRequest loginRequest = new UserWechatLoginRequest();
        loginRequest.setOpenId(model.getOpenId());
        loginRequest.setAppid(duoDuoKeConfig.getMiniAppid());
        //推荐人
        loginRequest.setUserReferee(param.getUserReferee());
        loginRequest.setUserSource(param.getUserSource());
        loginRequest.setRegUrl(param.getRegUrl());
        //openId关联用户体系 小程序登录
        loginRequest.setUserType(UserTypeEnum.MINI_USER.getCode());
        TSingleResult<UserDTO> result = userServiceClient.wechatLogin(loginRequest);
        UserDTO user = result.getValue();
        if (user == null) {
            LOGGER.error("根据openId查询用户主体信息失败");
            return fail("101", "根据code获取openId失败");
        }

        Authentication authenticate;
        try {
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                    user.getUserId(), user.getUserId());
            authenticate = authenticationManager.authenticate(authenticationToken);
        } catch (AuthenticationException e) {
            LOGGER.error(e.getLocalizedMessage(), e);
            if (e instanceof UsernameNotFoundException) {
                return fail("101", "根据code获取openId失败");
            }
            return fail("101", "根据code获取openId失败");
        }

        // Inject into security context
        SecurityContextHolder.getContext().setAuthentication(authenticate);
        //token值
        String jws = tokenHelper.generateToken(user.getUserId(), user.getUserId());
        //失效时间
        int expiresIn = (int) System.currentTimeMillis();
        // Return the token
        AuthTokenVO authTokenVO = new AuthTokenVO(user.getUserId(), jws, (long) expiresIn,
                user.getId());
        LOGGER.info("授权信息:{}", authTokenVO);
        return succ(authTokenVO);
    }

    @PostMapping("visitToday")
    @ApiOperation("今日第一次访问")
    public JsonResult visitToday(HttpServletRequest request) {
        Principal principal = PrincipalUtil.getPrincipal();
        userManager.visitToday(principal.getUserId());
        return succ();
    }

    /**
     * 用户打开模板消息
     *
     * @param templateParams {"templateParams":"{\"batchId\":\"1534841400\",\"taskId\":11}"}
     * @return
     */
    @PostMapping("openTemplateMsg")
    @ApiOperation("用户打开模板消息")
    public JsonResult openTemplateMsg(@RequestBody @ApiParam(value = "模板连接参数", required = false) String templateParams,
                                      HttpServletRequest request) {
        LOGGER.info("用户打开模板消息:{}", templateParams);

        //获取参数
        String jsonStr = JSONObject.parseObject(templateParams).getString("templateParams");
        if (StringUtil.isEmpty(jsonStr)) {
            return succ();
        }

        //解析对象
        JSONObject jsonObject = JSONObject.parseObject(jsonStr);

        //获取用户信息
        Principal principal = PrincipalUtil.getPrincipal();

        //打开记录
        userManager.userOpenTemplate(principal.getUserId(), jsonObject.getInteger("taskId"),
                jsonObject.getString("batchId"));
        return succ();
    }

}
