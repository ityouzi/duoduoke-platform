package com.fulihui.redisdubbo.demo.controller;


import com.fulihui.redisdubbo.demo.manager.UserRewardRecordManager;
import com.fulihui.redisdubbo.demo.param.UserRewardRecordParam;
import com.fulihui.redisdubbo.demo.util.Principal;
import com.fulihui.redisdubbo.demo.util.PrincipalUtil;
import com.fulihui.redisdubbo.demo.vo.UserRewardInfoVO;
import com.fulihui.redisdubbo.demo.vo.UserRewardVO;
import com.fulihui.redisdubbo.demo.weixin.common.except.BizException;
import com.fulihui.redisdubbo.demo.weixin.common.except.CommonErrors;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.near.toolkit.common.StringUtil;
import org.near.webmvcsupport.view.JsonResult;
import org.near.webmvcsupport.view.JsonResultBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: xiaoming
 * @version: v 0.1 2018/9/4 0004 14:57
 */
@RestController
@RequestMapping("/userRewardRecord")
@Api(description = "奖励翻倍")
public class UserRewardRecordController {
    protected Logger                logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserRewardRecordManager userRewardRecordManager;

    @PostMapping("/userHelp")
    @ApiOperation(value = "用户助力")
    public JsonResult<UserRewardVO> userHelp(@RequestBody UserRewardRecordParam param) {
        if (StringUtil.isBlank(param.getUserId()) || StringUtil.isBlank(param.getOrderSn())) {
            throw new BizException(CommonErrors.ILLIGEAL_REQUEST_ERROR);
        }
        Principal principal = PrincipalUtil.getPrincipal();
        return userRewardRecordManager.insert(principal.getUserId(), param.getOrderSn(),
            param.getUserId());
    }

    @PostMapping("/userHelpInfo")
    @ApiOperation(value = "助力信息")
    public JsonResult<UserRewardInfoVO> userHelpInfo(@RequestBody UserRewardRecordParam param) {
        Principal principal = PrincipalUtil.getPrincipal();
        UserRewardInfoVO userRewardInfoVO = userRewardRecordManager.queryInfo(principal.getUserId(),
            param.getOrderSn(), param.getUserId());
        return JsonResultBuilder.succ(userRewardInfoVO);
    }

}
