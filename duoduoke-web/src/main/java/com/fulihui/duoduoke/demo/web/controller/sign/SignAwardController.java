package com.fulihui.duoduoke.demo.web.controller.sign;


import com.fulihui.duoduoke.demo.api.api.AppConfigService;
import com.fulihui.duoduoke.demo.api.dto.AppConfigDTO;
import com.fulihui.duoduoke.demo.api.dto.sign.SignAwardDTO;
import com.fulihui.duoduoke.demo.api.enums.AppConfigEnum;
import com.fulihui.duoduoke.demo.api.enums.SignPrizeStatusEnum;
import com.fulihui.duoduoke.demo.api.request.sign.SignAwardRequest;
import com.fulihui.duoduoke.demo.web.vo.sign.FlopShareVO;
import com.fulihui.duoduoke.demo.web.vo.sign.UserSignAwardVO;
import com.fulihui.duoduoke.demo.web.integration.SignAwardServiceClient;
import com.fulihui.duoduoke.demo.web.param.sgin.FlopTypeParam;
import com.fulihui.duoduoke.demo.web.param.sgin.SignAwardParam;
import com.fulihui.duoduoke.demo.web.param.sgin.UserSignAwardParam;
import com.fulihui.duoduoke.demo.web.util.Principal;
import com.fulihui.duoduoke.demo.web.util.PrincipalUtil;
import com.fulihui.duoduoke.demo.common.except.BizException;
import com.fulihui.duoduoke.demo.common.except.CommonErrors;
import com.google.common.collect.Lists;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.Reference;
import org.near.servicesupport.result.TPageResult;
import org.near.servicesupport.result.TSingleResult;
import org.near.servicesupport.util.ServiceResultUtil;
import org.near.toolkit.common.DateUtils;
import org.near.toolkit.common.EnumUtil;
import org.near.toolkit.common.StringUtil;
import org.near.toolkit.model.Money;
import org.near.webmvcsupport.view.JsonResult;
import org.near.webmvcsupport.view.JsonResultBuilder;
import org.near.webmvcsupport.view.PageView;
import org.near.webmvcsupport.view.PageViewBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by lizhi on 2018-10-17.
 */
@RestController
@RequestMapping("/signAward")
@Api(description = "用户签到我的奖品信息")
public class SignAwardController {

    private static final Logger LOGGER = LoggerFactory
            .getLogger(SignAwardController.class);
    @Autowired
    SignAwardServiceClient awardServiceClient;
    @Reference
    AppConfigService appConfigService;

    public final static String CHINESEDTFORMAT = "MM月dd日";

    @PostMapping("signAward")
    @ApiOperation("我的奖品")
    public JsonResult<PageView<UserSignAwardVO>> signAward(@RequestBody UserSignAwardParam param) {
        if (param == null || StringUtil.isBlank(param.getAwardStatus())) {
            LOGGER.error("请求我的奖品接口参数错误");
            throw new BizException(CommonErrors.ILLIGEAL_REQUEST_ERROR);
        }

        Principal principal = PrincipalUtil.getPrincipal();
        SignAwardRequest request = new SignAwardRequest();
        request.setUserId(principal.getUserId());
        SignPrizeStatusEnum statusEnum = EnumUtil.queryByCode(param.getAwardStatus(),
                SignPrizeStatusEnum.class);
        request.setPrizeStatus(Lists.newArrayList(param.getAwardStatus()));
        request.setSortInfo(statusEnum.getSortInfo());
        request.setPage(param.getPage());
        request.setRows(param.getRows());
        TPageResult<SignAwardDTO> result = awardServiceClient.queryPage(request);
        List<SignAwardDTO> values = result.getValues();
        List<UserSignAwardVO> collect = values.stream().map(item -> {

            UserSignAwardVO vo = new UserSignAwardVO();
            vo.setSignAwardId(item.getId());
            vo.setAwardDate(DateUtils.formatWebFormat(item.getGmtCreate()));
            vo.setOrderSn(item.getOrderSn());
            vo.setActivityType(item.getActivityType());
            Money prizeMoney = new Money();
            prizeMoney.setCent(item.getPrizeMoney());
            vo.setPrizeMoney(prizeMoney.toString());

            Money overOrderMoney = new Money();
            overOrderMoney.setCent(item.getOverOrderMoney());
            vo.setOverOrderMoney(overOrderMoney.toString());

            Date gmtCreate = item.getGmtCreate();
            //结束有效期
            Date date = DateUtils.addDays(gmtCreate, item.getUsefulDay());
            vo.setValidityPeriod(DateUtils.format(gmtCreate, CHINESEDTFORMAT) + "~"
                    + DateUtils.format(date, CHINESEDTFORMAT));
            return vo;

        }).collect(Collectors.toList());
        //List<T> values, int page, int rows, int totalSize
        PageView<UserSignAwardVO> build = PageViewBuilder.build(collect, request.getPage(),
                request.getRows(), result.getTotalRows());
        return JsonResultBuilder.succ(build);
    }


    @PostMapping("useSignAward")
    @ApiOperation("使用签到奖金")
    public JsonResult<UserSignAwardVO> useSignAward(@RequestBody SignAwardParam param) {
        if (param == null || param.getSignAwardId() == 0) {
            LOGGER.error("请求签到奖金接口参数错误");
            throw new BizException(CommonErrors.ILLIGEAL_REQUEST_ERROR);
        }

        SignAwardRequest request = new SignAwardRequest();
        request.setId(param.getSignAwardId());
        TSingleResult<SignAwardDTO> result = awardServiceClient.selectByPrimaryKey(request);
        SignAwardDTO signAwardDTO = result.getValue();
        if (signAwardDTO != null) {
            UserSignAwardVO vo = new UserSignAwardVO();
            Money prizeMoney = new Money();
            prizeMoney.setCent(signAwardDTO.getPrizeMoney());
            vo.setPrizeMoney(prizeMoney.toString());

            Money overOrderMoney = new Money();
            overOrderMoney.setCent(signAwardDTO.getOverOrderMoney());
            vo.setOverOrderMoney(overOrderMoney.toString());
            return JsonResultBuilder.succ(vo);
        }

        return JsonResultBuilder.succ();

    }

    @PostMapping("signActivityRule")
    @ApiOperation("签到活动规则")
    public JsonResult<String> signActivityRule() {
        TSingleResult<AppConfigDTO> result = appConfigService
                .getModel(AppConfigEnum.SIGN_DESCRIBE_CONFIG);
        ServiceResultUtil.checkResult(result);
        AppConfigDTO value = result.getValue();
        if (value != null) {
            return JsonResultBuilder.succ(value.getConfigVal());
        }
        return JsonResultBuilder.succ("");
    }

    @PostMapping("flopShareContent")
    @ApiOperation("分享文案内容")
    public JsonResult<FlopShareVO> flopShareContent(@RequestBody FlopTypeParam param) {

        if (param == null || StringUtil.isBlank(param.getFlopType())) {
            LOGGER.error("请求分享文案内容接口参数错误");
            throw new BizException(CommonErrors.ILLIGEAL_REQUEST_ERROR);
        }
        AppConfigEnum configEnum;
        if ("1".equals(param.getFlopType())) {
            configEnum = AppConfigEnum.SIGN_WITH_SHARE;
        } else if ("2".equals(param.getFlopType())) {
            configEnum = AppConfigEnum.FLOP_WITH_SHARE;
        } else {
            throw new BizException(CommonErrors.ILLIGEAL_REQUEST_ERROR);
        }

        TSingleResult<AppConfigDTO> result = appConfigService.getModel(configEnum);
        FlopShareVO vo = new FlopShareVO();
        if (result.getValue() != null) {
            vo.setTitle(result.getValue().getConfigVal());
            vo.setImgUrl(result.getValue().getConfigExtendVal());
        }

        return JsonResultBuilder.succ(vo);
    }
}
