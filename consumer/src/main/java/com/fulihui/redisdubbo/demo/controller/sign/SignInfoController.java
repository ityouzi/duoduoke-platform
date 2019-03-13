package com.fulihui.redisdubbo.demo.controller.sign;

import com.alibaba.fastjson.JSONArray;
import com.fulihui.redisdubbo.demo.api.api.ActivityConfigService;
import com.fulihui.redisdubbo.demo.api.api.AppConfigService;
import com.fulihui.redisdubbo.demo.api.dto.ActivityConfigPrizeDTO;
import com.fulihui.redisdubbo.demo.api.dto.ActivitySignPrizeDTO;
import com.fulihui.redisdubbo.demo.api.dto.AppConfigDTO;
import com.fulihui.redisdubbo.demo.api.dto.sign.SignUserConfigDTO;
import com.fulihui.redisdubbo.demo.api.dto.sign.SignUserRecordDTO;
import com.fulihui.redisdubbo.demo.api.enums.*;
import com.fulihui.redisdubbo.demo.api.request.sign.SignAwardRequest;
import com.fulihui.redisdubbo.demo.api.request.sign.SignUserRecordRequest;
import com.fulihui.redisdubbo.demo.api.response.ProbabilityDrawResponse;
import com.fulihui.redisdubbo.demo.factory.AppConfigFactory;
import com.fulihui.redisdubbo.demo.integration.SignAwardServiceClient;
import com.fulihui.redisdubbo.demo.integration.SignUserConfigServiceClient;
import com.fulihui.redisdubbo.demo.integration.SignUserRecordServiceClient;
import com.fulihui.redisdubbo.demo.param.SignUserConfigParam;
import com.fulihui.redisdubbo.demo.param.sgin.DrawParam;
import com.fulihui.redisdubbo.demo.param.sgin.SignShareParam;
import com.fulihui.redisdubbo.demo.param.sgin.SignUserParam;
import com.fulihui.redisdubbo.demo.util.Principal;
import com.fulihui.redisdubbo.demo.util.PrincipalUtil;
import com.fulihui.redisdubbo.demo.vo.sign.*;
import com.fulihui.redisdubbo.demo.weixin.common.except.BizException;
import com.fulihui.redisdubbo.demo.weixin.common.except.CommonErrors;
import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Lists;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.near.servicesupport.result.TMultiResult;
import org.near.servicesupport.result.TPageResult;
import org.near.servicesupport.result.TSingleResult;
import org.near.servicesupport.util.ServiceResultUtil;
import org.near.toolkit.common.DateUtils;
import org.near.toolkit.common.EnumUtil;
import org.near.toolkit.common.StringUtil;
import org.near.toolkit.model.Money;
import org.near.webmvcsupport.view.JsonResult;
import org.near.webmvcsupport.view.JsonResultBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.fulihui.redisdubbo.demo.api.enums.AppConfigEnum.FLOP_WITH_SHARE;
import static org.near.toolkit.common.DateUtils.formatWebFormat;

/**
 * @author lizhi
 * @date 2018-10-11
 */
@RestController
@RequestMapping("/signInfo")
@Api(description = "用户签到信息")
public class SignInfoController {
    @Autowired
    SignUserConfigServiceClient signUserConfigServiceClient;
    @Autowired
    SignUserRecordServiceClient signUserRecordServiceClient;

    @Autowired
    SignAwardServiceClient signAwardServiceClient;
    @org.apache.dubbo.config.annotation.Reference
    ActivityConfigService activityConfigService;

    @Autowired
    AppConfigFactory appConfigFactory;

    @org.apache.dubbo.config.annotation.Reference
    AppConfigService appConfigService;

    @Autowired
    ThreadPoolTaskExecutor      threadPoolTaskExecutor;

    private static final Logger LOGGER = LoggerFactory.getLogger(SignInfoController.class);

    @PostMapping("shareCount")
    @ApiOperation("分享加翻牌机会")
    public JsonResult shareCount(@RequestBody SignShareParam param) {

        if (param == null || param.getSignId() == null) {
            LOGGER.error("分享加翻牌机会参数为空,param:{}", param);
            throw new BizException(CommonErrors.ILLIGEAL_REQUEST_ERROR);
        }

        Principal principal = PrincipalUtil.getPrincipal();
        SignUserRecordRequest request = new SignUserRecordRequest();
        request.setUserId(principal.getUserId());
        request.setId(param.getSignId());
        TSingleResult<SignUserRecordDTO> takeShareCount = signUserRecordServiceClient
            .takeShareCount(request);
        return JsonResultBuilder.succ(takeShareCount.getValue() != null);
    }

    @PostMapping("querySignConfig")
    @ApiOperation("查询用户签到提醒开关")
    public JsonResult<SignUserConfigVO> querySignConfig() {
        Principal principal = PrincipalUtil.getPrincipal();
        TSingleResult<SignUserConfigDTO> result = signUserConfigServiceClient
            .takeUserConfig(principal.getUserId());
        SignUserConfigDTO value = result.getValue();
        SignUserConfigVO configVO = new SignUserConfigVO();
        if (value != null) {
            String state = value.getState();
            configVO.setState(state);
        }
        return JsonResultBuilder.succ(configVO);
    }

    @PostMapping("settingConfig")
    @ApiOperation("设置开关")
    public JsonResult<SignUserConfigVO> settingConfig(@RequestBody SignUserConfigParam param) {
        LOGGER.debug("settingConfig.param:{}", param);
        Principal principal = PrincipalUtil.getPrincipal();
        if (StringUtil.isBlank(param.getState())) {
            throw new BizException(CommonErrors.ILLIGEAL_REQUEST_ERROR);
        }
        String state = param.getState();
        SwitchEnum switchEnum = EnumUtil.queryByCode(state, SwitchEnum.class);
        if (switchEnum == null) {
            throw new BizException(CommonErrors.ILLIGEAL_REQUEST_ERROR);
        }
        //异步执行
        threadPoolTaskExecutor.execute(() -> {
            TSingleResult<SignUserConfigDTO> result = signUserConfigServiceClient
                .updateUserConfig(principal.getUserId(), param.getState());
            LOGGER.info("result:{}", result);
        });
        SignUserConfigVO configVO = new SignUserConfigVO();
        configVO.setState(state);
        return JsonResultBuilder.succ(configVO);
    }

    @PostMapping("supplementSign")
    @ApiOperation("用户补签")
    public JsonResult<SupplementSignVO> supplementSign(@RequestBody SignUserParam param) {
        if (param == null) {
            throw new BizException(CommonErrors.ILLIGEAL_REQUEST_ERROR);
        }
        if (param.getSignHelpUserId() == null) {
            throw new BizException(CommonErrors.ILLIGEAL_REQUEST_ERROR);
        }
        if (param.getCycleTime() == null) {
            throw new BizException(CommonErrors.ILLIGEAL_REQUEST_ERROR);
        }

        Date cycleTime;
        try {
            cycleTime = DateUtils.parseWebFormat(param.getCycleTime());
        } catch (ParseException e) {
            LOGGER.error(e.getMessage(), e);
            throw new BizException(CommonErrors.ILLIGEAL_REQUEST_ERROR);
        }

        Principal principal = PrincipalUtil.getPrincipal();
        LOGGER.info("补签周期:{},被补签者的用户id:{},补签者:{}", param.getCycleTime(), param.getSignHelpUserId(),
            principal.getUserId());
        SupplementSignVO vo = new SupplementSignVO();
        if (StringUtil.equals(principal.getUserId(), param.getSignHelpUserId())) {
            vo.setSupplementStatus("1");
            return JsonResultBuilder.succ(vo);
        }
        Date check = DateUtils.addDays(cycleTime, 6);
        LOGGER.info("check周期时间,补签者:{}", DateUtils.formatWebFormat(check));
        Date now = new Date();
        if (now.after(check)) {
            vo.setSupplementStatus("2");
            return JsonResultBuilder.succ(vo);
        }
        List<SignUserRecordDTO> values = querySign(cycleTime, param.getSignHelpUserId());
        int indexDay = getIndexDay(now, values);
        int id = 0;
        for (int j = 0; j < values.size(); j++) {
            SignUserRecordDTO item = values.get(j);
            if (j < indexDay && !item.getSignStatus().equals(SignStatusEnum.Y.getCode())) {
                if (item.getSignStatus().equals(SignStatusEnum.S.getCode())) {
                    Date signTime = item.getSignTime();
                    String s = DateUtils.formatWebFormat(signTime);
                    //如果当天已经已补签
                    if (s.equals(formatWebFormat(now))) {
                        //如果是同一个人
                        if (item.getSignHelpUserId().equals(principal.getUserId())) {
                            vo.setSupplementStatus("3");
                            return JsonResultBuilder.succ(vo);
                        } else {
                            vo.setSupplementStatus("4");
                            return JsonResultBuilder.succ(vo);
                        }
                    }
                } else {
                    //执行补签
                    id = item.getId();
                    break;
                }
            }
        }

        String userId = principal.getUserId();
        SignUserRecordRequest request = new SignUserRecordRequest();
        request.setUserId(userId);
        request.setSignHelpUserId(param.getSignHelpUserId());
        request.setId(id);
        request.setSignType(SignTypeEnum.SUPPLEMENT.getCode());
        TSingleResult<SignUserRecordDTO> result = signUserRecordServiceClient
            .supplementSign(request);
        if (result.getValue() != null) {
            vo.setSupplementStatus("5");
            return JsonResultBuilder.succ(vo);
        }

        return JsonResultBuilder.succ(vo);
    }

    @PostMapping("draw")
    @ApiOperation("用户抽奖")
    public JsonResult<DrawVO> draw(@RequestBody DrawParam param) {
        if (param == null || param.getSignId() == null) {
            throw new BizException(CommonErrors.ILLIGEAL_REQUEST_ERROR);
        }
        Principal principal = PrincipalUtil.getPrincipal();
        SignUserRecordRequest request = new SignUserRecordRequest();
        request.setId(param.getSignId());
        request.setUserId(principal.getUserId());
        TSingleResult<SignUserRecordDTO> tSingleResult = signUserRecordServiceClient
            .queryByPk(request);
        if (tSingleResult.getValue() == null) {
            throw new BizException(CommonErrors.ILLIGEAL_REQUEST_ERROR);
        }
        boolean bl;
        Integer signFlopCount = tSingleResult.getValue().getSignFlopCount();
        //签到翻牌机会 消耗了
        if (signFlopCount == null || signFlopCount == 0) {
            //check
            Integer shareFlopCount = tSingleResult.getValue().getShareFlopCount();
            //分享翻牌机会 消耗了
            if (shareFlopCount == null || shareFlopCount == 0) {
                LOGGER.error("抽奖机会没有,userId:{},value:{}", principal.getUserId(),
                    tSingleResult.getValue());
                throw new BizException(CommonErrors.ILLIGEAL_REQUEST_ERROR);
            } else {
                request.setShareFlopCount(-1);
                bl = false;
            }
        } else {
            //签到抽奖翻牌
            request.setSignFlopCount(-1);
            bl = true;
        }

        DrawVO vo = new DrawVO();
        vo.setShareAgain(bl);
        //抽奖
        TSingleResult<ProbabilityDrawResponse> result = signUserRecordServiceClient
            .probabilityDraw(request);
        //自己
        List<ActivitySignPrizeDTO> self = result.getValue().getActivityPrize().stream()
            .filter(item -> item.getId().equals(result.getValue().getPrizeId()))
            .collect(Collectors.toList());
        if (CollectionUtils.isEmpty(self)) {
            LOGGER.error("抽奖配置信息原数据不存在:{},{}", principal.getUserId(), self);
            throw new BizException(CommonErrors.ILLIGEAL_REQUEST_ERROR);
        }

        List<ActivitySignPrizeDTO> itemList = Lists.newArrayList();
        itemList.add(self.get(0));
        //非自己
        List<ActivitySignPrizeDTO> collect = result.getValue().getActivityPrize().stream()
            .filter(item -> !item.getId().equals(result.getValue().getPrizeId()))
            .collect(Collectors.toList());
        if (!CollectionUtils.isEmpty(collect)) {
            collect.sort(
                (t, t1) -> ComparisonChain.start().compare(t1.getPrizeType(), t.getPrizeType())
                    .compare(t1.getPrizeMoney(), t.getPrizeMoney()).result());
            try {
                Stream<ActivitySignPrizeDTO> limit = collect.stream().limit(2);
                limit.forEach(itemList::add);
            } catch (Exception ignored) {

            }
        }
        vo.setList(convert(itemList));
        vo.setPrizeId(result.getValue().getPrizeId());
        vo.setSignAwardId(result.getValue().getSignAwardId());
        return JsonResultBuilder.succ(vo);
    }

    @PostMapping("sign")
    @ApiOperation("用户签到")
    public JsonResult<SignVO> sign(@RequestBody SignUserParam param) {
        if (param == null) {
            throw new BizException(CommonErrors.ILLIGEAL_REQUEST_ERROR);
        }
        if (StringUtil.isBlank(param.getSignType())) {
            throw new BizException(CommonErrors.ILLIGEAL_REQUEST_ERROR);
        }
        Principal principal = PrincipalUtil.getPrincipal();
        SignUserRecordRequest request = new SignUserRecordRequest();
        request.setUserId(principal.getUserId());
        request.setId(param.getId());
        if (StringUtil.equals(param.getSignType(), SignTypeEnum.SUPPLEMENT.getCode())) {
            if (StringUtil.isBlank(param.getSignHelpUserId())) {
                throw new BizException(CommonErrors.ILLIGEAL_REQUEST_ERROR);
            }
            if (StringUtil.equals(param.getSignHelpUserId(), principal.getUserId())) {
                LOGGER.error("用户签到补签,自己不能跟自己补签,userId:{},signHelpUserId:{}", principal.getUserId(),
                    param.getSignHelpUserId());
                throw new BizException(CommonErrors.USER_SUPPLEMENT_SELF_ERROR);
            }
            request.setSignHelpUserId(param.getSignHelpUserId());
        }
        SignVO vo = new SignVO();
        request.setSignType(SignTypeEnum.SELF.getCode());
        request.setCycleTime(new Date());
        request.setSortInfo(" sign_time_ext asc");
        TSingleResult<SignUserRecordDTO> result = signUserRecordServiceClient.sign(request);
        SignUserRecordDTO value = result.getValue();
        boolean b = value != null;
        //如果签到成功
        if (b) {
            vo.setSignStatus(Boolean.TRUE);
            Boolean aBoolean = queryFlop();
            if (aBoolean) {
                vo.setFlopStatus(Boolean.TRUE);
                TSingleResult<AppConfigDTO> model = appConfigService.getModel(FLOP_WITH_SHARE);
                AppConfigDTO configDTO = model.getValue();
                if (configDTO != null) {
                    FlopShareVO shareVO = new FlopShareVO();
                    shareVO.setTitle(configDTO.getConfigVal());
                    shareVO.setImgUrl(configDTO.getConfigExtendVal());
                    vo.setShareVO(shareVO);
                }
                TSingleResult<ActivityConfigPrizeDTO> singleResult = activityConfigService
                    .getUsingActivity(ActivityTypeEnum.Flop);
                ServiceResultUtil.checkResult(singleResult);
                ActivityConfigPrizeDTO prizeDTO = singleResult.getValue();
                if (prizeDTO != null) {
                    List<ActivitySignPrizeDTO> activityPrize = prizeDTO.getActivityPrize();
                    List<SignInPrizeVO> list = convert(activityPrize);
                    vo.setList(list);
                }
            } else {
                vo.setFlopStatus(Boolean.FALSE);
            }
        }
        return JsonResultBuilder.succ(vo);
    }

    private List<SignInPrizeVO> convert(List<ActivitySignPrizeDTO> activityPrize) {
        return activityPrize.stream().map(i -> {
            SignInPrizeVO prizeVO = new SignInPrizeVO();
            prizeVO.setPrizeId(i.getId());
            prizeVO.setPrizeType(i.getPrizeType());
            Money m = new Money();
            m.setCent(i.getPrizeMoney());
            prizeVO.setSignAmount(m.toString());
            return prizeVO;
        }).collect(Collectors.toList());
    }

    List<SignUserRecordDTO> querySign(Date date, String userId) {
        SignUserRecordRequest request = new SignUserRecordRequest();
        request.setUserId(userId);
        request.setCycleTime(date);
        request.setSortInfo(" sign_time_ext asc");
        TMultiResult<SignUserRecordDTO> result = signUserRecordServiceClient.querySign(request);
        return result.getValues();
    }

    @PostMapping("querySign")
    @ApiOperation("查询用户签到情况")
    public JsonResult<SignUserRecordVO> querySign() {
        SignUserRecordVO recordVO = new SignUserRecordVO();
        Principal principal = PrincipalUtil.getPrincipal();
        Date date = new Date();
        List<SignUserRecordDTO> values = querySign(date, principal.getUserId());
        //周期累计签到数据
        int cycleSignNum = 0;
        List<SignUserRecordDetailVO> list = Lists.newArrayList();
        int indexDay = getIndexDay(date, values);
        if (!CollectionUtils.isEmpty(values)) {
            int i = 1;
            boolean isSupplement = false;
            for (int j = 0; j < values.size(); j++) {
                SignUserRecordDTO item = values.get(j);
                SignUserRecordDetailVO vo = new SignUserRecordDetailVO();
                vo.setCycleTime(formatWebFormat(item.getCycleTime()));
                vo.setSignStatus(item.getSignStatus());
                vo.setId(item.getId());
                vo.setSignFlopCount(item.getSignFlopCount());
                vo.setShareFlopCount(item.getShareFlopCount());
                String webFormat = formatWebFormat(item.getSignTimeExt());
                vo.setSignTimeExt(webFormat);
                //判断是不是今天  如果true 是今天, false 不是今天
                boolean equals = StringUtil.equals(webFormat, formatWebFormat(date));
                if (equals) {
                    //今天的下标
                    int index = values.indexOf(item);
                    recordVO.setDays(index + 1);
                    recordVO.setId(item.getId());
                    boolean isSign = item.getSignStatus().equals(SignStatusEnum.Y.getCode());
                    //如果今天没有签到
                    if (!isSign) {
                        //1=立即签到,
                        recordVO.setSignStatus(1);
                    } else {
                        //假如翻牌活动总开关着
                        boolean isFlopOpen = queryFlop();
                        if (!isFlopOpen) {
                            //今日已签到
                            recordVO.setSignStatus(4);
                        } else {
                            //今日有没有 签到 sign_flop_count 翻牌
                            Integer signFlopCount = item.getSignFlopCount();
                            //如果今天已经翻牌过
                            if (signFlopCount != null && signFlopCount == 0) {
                                //查询分享过有没有
                                Integer shareFlopCount = item.getShareFlopCount();
                                //如果分享机会已经赠送并且分享的机会已经翻牌了
                                if (shareFlopCount == null) {
                                    //分享可得一次翻牌机会
                                    recordVO.setSignStatus(3);
                                } else {
                                    // 分享可得一次翻牌机会 已经使用
                                    if (shareFlopCount == 0) {
                                        //4=今日已签到
                                        recordVO.setSignStatus(4);
                                    } else {
                                        //今日分享有翻牌机会
                                        recordVO.setSignStatus(5);
                                    }
                                }
                            } else {
                                //今日有一次翻牌机会
                                recordVO.setSignStatus(2);
                            }
                        }
                    }
                }
                //补签逻辑
                if (j < indexDay
                    && values.get(j).getSignStatus().equals(SignStatusEnum.N.getCode())) {
                    isSupplement = true;
                }

                vo.setIsSign(equals);
                vo.setDays(i++);
                recordVO.setIsSupplement(isSupplement);
                list.add(vo);
                if (StringUtil.equals(item.getSignStatus(), SignStatusEnum.Y.getCode())
                    || StringUtil.equals(item.getSignStatus(), SignStatusEnum.S.getCode())) {
                    cycleSignNum++;
                }
            }

            String signInPrize = values.get(0).getSignInPrize();
            List<ActivitySignPrizeDTO> prizeList = JSONArray.parseArray(signInPrize,
                ActivitySignPrizeDTO.class);
            if (!CollectionUtils.isEmpty(prizeList)) {
                List<SignInPrizeVO> collect = prizeList.stream().map(it -> {
                    SignInPrizeVO prizeVO = new SignInPrizeVO();
                    prizeVO.setSignCount(it.getSignCount());
                    Money money = new Money();
                    money.setCent(it.getPrizeMoney());
                    prizeVO.setSignAmount(money.toString());
                    return prizeVO;
                }).collect(Collectors.toList());
                recordVO.setPrizeList(collect);
            }
        }
        recordVO.setList(list);
        recordVO.setCycleSignNum(cycleSignNum);

        String bonus = bonus(principal.getUserId());
        recordVO.setNotSignedBonus(bonus);
        return JsonResultBuilder.succ(recordVO);
    }

    private String bonus(String userId) {

        try {
            long bonus = 0;
            SignAwardRequest awardRequest = new SignAwardRequest();
            awardRequest.setUserId(userId);
            awardRequest.setPrizeStatus(Lists.newArrayList(SignPrizeStatusEnum.UNUSED.getCode()));
            awardRequest.setPrizeType(ActivitySignPrizeTypeEnum.BONUS.getCode());
            TSingleResult<Long> result;
            result = signAwardServiceClient.sumPrizeMoney(awardRequest);
            if (result.getValue() != null) {
                bonus = result.getValue();
            }
            Money money = new Money();
            money.setCent(bonus);
            return money.toString();
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        return null;
    }

    private int getIndexDay(Date date, List<SignUserRecordDTO> values) {
        int indexDay = 0;
        for (int j = 0; j < values.size(); j++) {
            SignUserRecordDTO item = values.get(j);
            String webFormat = formatWebFormat(item.getSignTimeExt());
            boolean equals = StringUtil.equals(webFormat, formatWebFormat(date));
            if (equals) {
                //今天的下标
                indexDay = values.indexOf(item);
                break;
            }
        }
        return indexDay;
    }

    private Boolean queryFlop() {
        Boolean flopOpen = appConfigFactory.getFlopOpen();
        //如果翻牌总开关 关着
        if (!flopOpen) {
            return false;
        }

        //翻牌活动
        TSingleResult<ActivityConfigPrizeDTO> result = activityConfigService
            .getUsingActivity(ActivityTypeEnum.Flop);
        ServiceResultUtil.checkResult(result);
        return result.getValue() != null;
    }

    @PostMapping("querySupplement")
    @ApiOperation("查询用户能不能补签")
    public JsonResult<SignQuerySupplementVO> querySupplement() {
        SignQuerySupplementVO vo = new SignQuerySupplementVO();
        Principal principal = PrincipalUtil.getPrincipal();
        Date date = new Date();
        List<SignUserRecordDTO> values = querySign(date, principal.getUserId());
        if (CollectionUtils.isEmpty(values)) {
            throw new BizException(CommonErrors.ILLIGEAL_REQUEST_ERROR);
        }
        int indexDay = getIndexDay(date, values);
        boolean bl = true;
        for (int j = 0; j < values.size(); j++) {
            SignUserRecordDTO item = values.get(j);
            if (j < indexDay && item.getSignStatus().equals(SignStatusEnum.S.getCode())) {
                Date signTime = item.getSignTime();
                String s = DateUtils.formatWebFormat(signTime);
                //是不是今天补签
                if (StringUtil.equals(s, formatWebFormat(date))) {
                    bl = false;
                    break;
                }
            }
        }
        vo.setIsSupplement(bl);
        vo.setCycleTime(DateUtils.formatWebFormat(values.get(0).getCycleTime()));
        try {
            TSingleResult<AppConfigDTO> result = appConfigService
                .getModel(AppConfigEnum.SIGN_WITH_SHARE);
            ServiceResultUtil.checkResult(result);
            AppConfigDTO value = result.getValue();
            vo.setImgUrl(value.getConfigExtendVal());
            vo.setTitle(value.getConfigVal());
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        return JsonResultBuilder.succ(vo);
    }

    @PostMapping("signInRecord")
    @ApiOperation("查询签到记录")
    public JsonResult<List<SignUserRecordExtVO>> signInRecord() {
        Principal principal = PrincipalUtil.getPrincipal();
        SignUserRecordRequest request = new SignUserRecordRequest();
        request.setUserId(principal.getUserId());
        request.setPage(1);
        request.setRows(15);
        request.setSignStatus(
            Lists.newArrayList(SignStatusEnum.Y.getCode(), SignStatusEnum.S.getCode()));
        request.setSortInfo(" sign_time_ext desc");
        TPageResult<SignUserRecordDTO> result = signUserRecordServiceClient.queryPage(request);
        if (CollectionUtils.isEmpty(result.getValues())) {
            return JsonResultBuilder.succ(Lists.newArrayList());
        }
        List<SignUserRecordExtVO> collect = result.getValues().stream().map(item -> {
            SignUserRecordExtVO vo = new SignUserRecordExtVO();
            vo.setSignTimeExt(formatWebFormat(item.getSignTimeExt()));
            vo.setSignType(item.getSignType());
            return vo;
        }).collect(Collectors.toList());

        return JsonResultBuilder.succ(collect);
    }

}