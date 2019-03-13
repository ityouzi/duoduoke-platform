package com.fulihui.redisdubbo.demo.controller;


import com.fulihui.redisdubbo.demo.api.api.UserPosterImgService;
import com.fulihui.redisdubbo.demo.api.dto.UserPosterImgDTO;
import com.fulihui.redisdubbo.demo.api.request.UserPosterImgRequest;
import com.fulihui.redisdubbo.demo.param.UserImgParam;
import com.fulihui.redisdubbo.demo.util.Principal;
import com.fulihui.redisdubbo.demo.util.PrincipalUtil;
import com.fulihui.redisdubbo.demo.vo.UserPosterImgVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.near.servicesupport.result.TMultiResult;
import org.near.toolkit.common.StringUtil;
import org.near.webmvcsupport.view.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static org.near.servicesupport.util.ServiceResultUtil.checkResult;
import static org.near.webmvcsupport.view.JsonResultBuilder.fail;
import static org.near.webmvcsupport.view.JsonResultBuilder.succ;

/**
 * @Description:
 * @Author: xiaoming
 * @version: v 0.1 2018/7/31 0031 15:00
 */
@RestController
@RequestMapping("/userPosterImg")
@Api(description = "用户海报")
public class UserPosterImgController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserPosterImgController.class);

    @org.apache.dubbo.config.annotation.Reference
    UserPosterImgService userPosterImgService;

    @PostMapping("queryUserImg")
    @ApiOperation("用户海报接口")
    public JsonResult<List<UserPosterImgVO>> queryUserImg(@RequestBody UserImgParam param) {
        Principal principal = PrincipalUtil.getPrincipal();
        LOGGER.info("request parpm:{}", param.toString());
        if (StringUtil.isEmpty(param.getAvatarUrl()) || StringUtil.isEmpty(param.getNickName())) {
            return fail("101", "参数错误");
        }
        UserPosterImgRequest request = new UserPosterImgRequest();
        request.setUserId(principal.getUserId());
        request.setNickName(param.getNickName());
        request.setHeadImg(param.getAvatarUrl());
        TMultiResult<UserPosterImgDTO> result = userPosterImgService.query(request);

        checkResult(result);
        List<UserPosterImgDTO> list = result.getValues();
        if (!CollectionUtils.isEmpty(list)) {
            List<UserPosterImgVO> values = result.getValues().stream().map(item -> {
                UserPosterImgVO userPosterImgVO = new UserPosterImgVO();
                BeanUtils.copyProperties(item, userPosterImgVO);
                return userPosterImgVO;
            }).collect(Collectors.toList());
            return succ(values);
        }
        return succ();

    }

}
