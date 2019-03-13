package com.fulihui.duoduoke.demo.producer.service.sign;


import com.alibaba.fastjson.JSONObject;
import com.fulihui.duoduoke.demo.api.api.ActivityConfigService;
import com.fulihui.duoduoke.demo.api.api.AppConfigService;
import com.fulihui.duoduoke.demo.api.api.sign.SignUserConfigService;
import com.fulihui.duoduoke.demo.api.api.sign.SignUserRecordService;
import com.fulihui.duoduoke.demo.api.dto.ActivityConfigPrizeDTO;
import com.fulihui.duoduoke.demo.api.dto.ActivitySignPrizeDTO;
import com.fulihui.duoduoke.demo.api.dto.AppConfigDTO;
import com.fulihui.duoduoke.demo.api.dto.sign.SignInConfigDTO;
import com.fulihui.duoduoke.demo.api.dto.sign.SignUserConfigDTO;
import com.fulihui.duoduoke.demo.api.dto.sign.SignUserRecordDTO;
import com.fulihui.duoduoke.demo.api.enums.*;
import com.fulihui.duoduoke.demo.api.request.UserAccountOperatorRequest;
import com.fulihui.duoduoke.demo.api.request.sign.SignUserRecordRequest;
import com.fulihui.duoduoke.demo.api.response.ProbabilityDrawResponse;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.*;
import com.fulihui.duoduoke.demo.producer.manager.SignUserCountCountManager;
import com.fulihui.duoduoke.demo.producer.manager.TakeAccountAmountManager;
import com.fulihui.duoduoke.demo.producer.repository.SignAwardRepository;
import com.fulihui.duoduoke.demo.producer.repository.SignInConfigRepository;
import com.fulihui.duoduoke.demo.producer.repository.SignUserConfigRepository;
import com.fulihui.duoduoke.demo.producer.repository.SignUserRecordRepository;
import com.fulihui.duoduoke.demo.producer.util.ActivitySignPrizeModel;
import com.fulihui.duoduoke.demo.producer.dal.convert.SignUserRecordConvert;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.*;
import com.fulihui.duoduoke.demo.producer.util.WeightRandom;
import com.google.common.collect.Lists;
import javafx.util.Pair;
import org.apache.dubbo.config.annotation.Service;
import org.near.servicesupport.error.Errors;
import org.near.servicesupport.result.ResultBuilder;
import org.near.servicesupport.result.TMultiResult;
import org.near.servicesupport.result.TPageResult;
import org.near.servicesupport.result.TSingleResult;
import org.near.servicesupport.util.ServiceAssert;
import org.near.servicesupport.util.ServiceResultUtil;
import org.near.toolkit.common.EnumUtil;
import org.near.toolkit.common.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static org.near.servicesupport.util.ServiceResultUtil.checkResult;
import static org.near.toolkit.common.DateUtils.*;
import static org.springframework.util.CollectionUtils.isEmpty;

/**
 * The type Sign user record service.
 *
 * @author lizhi
 * @date 2018 -10-11
 */
@Service(version = "${demo.service.version}")
public class SignUserRecordServiceImpl implements SignUserRecordService {
    private final static Logger LOGGER = LoggerFactory.getLogger(SignUserRecordServiceImpl.class);

    /**
     * The Sign in config repository.
     */
    @Autowired
    SignInConfigRepository signInConfigRepository;
    /**
     * The Sign user record repository.
     */
    @Autowired
    SignUserRecordRepository signUserRecordRepository;
    /**
     * The Sign user count count manager.
     */
    @Autowired
    SignUserCountCountManager signUserCountCountManager;
    /**
     * The Sign user config repository.
     */
    @Autowired
    SignUserConfigRepository signUserConfigRepository;

    /**
     * The Thread pool task executor.
     */
    @Autowired
    ThreadPoolTaskExecutor threadPoolTaskExecutor;

    /**
     * The Sign user config service.
     */
    @Autowired
    SignUserConfigService signUserConfigService;
    /**
     * The Activity config service.
     */
    @Autowired
    ActivityConfigService activityConfigService;
    /**
     * The App config service.
     */
    @Autowired
    AppConfigService appConfigService;

    @Autowired
    SignAwardRepository signAwardRepository;
    @Autowired
    TakeAccountAmountManager takeAccountAmountManager;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public TSingleResult<SignUserRecordDTO> sign(SignUserRecordRequest request) {
        ServiceAssert.notNull(request, Errors.Commons.REQUEST_PARAMETER_ERROR);
        ServiceAssert.notBlank(request.getUserId(), Errors.Commons.REQUEST_PARAMETER_ERROR);
        //初始化周期
        if (request.getId() == null) {
            List<SignInConfigDTO> configList = signInConfigRepository
                    .selectByExample(new SignInConfigExample());
            if (!isEmpty(configList)) {
                List<SignUserRecordDTO> convert = signUserRecordRepository.queryByCycleTime(
                        request.getUserId(), request.getCycleTime(), request.getSortInfo());
                List<SignUserRecordDTO> list = Lists.newArrayList();
                if (isEmpty(convert)) {
                    List<SignUserRecordDTO> dtoList = signUserRecordRepository.queryBySignTimeExt(
                            request.getUserId(), request.getCycleTime(), request.getSortInfo());
                    if (isEmpty(dtoList)) {
                        for (int i = 0; i < configList.get(0).getDays(); i++) {
                            SignUserRecord record = new SignUserRecord();
                            record.setSignTimeExt(addDays(request.getCycleTime(), i));
                            record.setCycleTime(request.getCycleTime());
                            record.setUserId(request.getUserId());
                            record.setSignStatus(SignStatusEnum.N.getCode());
                            record.setSignInPrize(getActivityPrize());
                            signUserRecordRepository.insertSelective(record);
                            list.add(SignUserRecordConvert.convert(record));
                        }
                        request.setId(list.get(0).getId());
                    }
                }
            }
        }

        List<SignUserRecordDTO> list = signUserRecordRepository.queryPk(request.getUserId(),
                request.getId());
        if (isEmpty(list)) {
            return ResultBuilder.failTSingle(Errors.Commons.SYSTEM_ERROR);
        }
        SignUserRecordDTO dto = list.get(0);
        Date now = new Date();
        //判断是不是当天签到
        if (!formatWebFormat(dto.getSignTimeExt()).equals(formatWebFormat(now))) {
            return ResultBuilder.failTSingle(Errors.Commons.SYSTEM_ERROR);
        }
        if (StringUtil.equals(dto.getSignStatus(), SignStatusEnum.Y.getCode())) {
            return ResultBuilder.succTSingle(dto);
        }
        LOGGER.info("用户签到成功,userId:{},当前时间now:{}", request.getUserId(), formatWebFormat(now));
        SignUserRecord record = new SignUserRecord();
        record.setSignTime(now);
        record.setSignStatus(SignStatusEnum.Y.getCode());
        record.setSignType(request.getSignType());
        record.setId(dto.getId());
        //签到赠送翻牌机会
        TSingleResult<AppConfigDTO> result = appConfigService
                .getModel(AppConfigEnum.FLOP_ACTIVITY_USING);
        checkResult(result);
        AppConfigDTO value = result.getValue();
        if (Boolean.parseBoolean(value.getConfigVal())) {
            record.setSignFlopCount(1);
        }

        boolean update = signUserRecordRepository.update(record);
        if (!update) {
            return ResultBuilder.failTSingle(Errors.Commons.SYSTEM_ERROR);
        }

        boolean sign = signUserCountCountManager.calculateSign(request.getUserId(), now,
                dto.getCycleTime());
        if (sign) {
            try {
                xxx(request, dto);
            } catch (Exception e) {
                LOGGER.error(e.getMessage(), e);
            }
            List<SignUserRecordDTO> newDTO = signUserRecordRepository.queryPk(request.getUserId(),
                    request.getId());
            return ResultBuilder.succTSingle(newDTO.get(0));
        } else {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return ResultBuilder.failTSingle(Errors.Commons.SYSTEM_ERROR);
        }
    }

    @Override
    public TSingleResult<SignUserRecordDTO> supplementSign(SignUserRecordRequest request) {
        ServiceAssert.notNull(request, Errors.Commons.REQUEST_PARAMETER_ERROR);
        //补签者
        ServiceAssert.notBlank(request.getUserId(), Errors.Commons.REQUEST_PARAMETER_ERROR);
        //被补签者
        ServiceAssert.notBlank(request.getSignHelpUserId(), Errors.Commons.REQUEST_PARAMETER_ERROR);
        //查询被补签者的  漏签的数据
        List<SignUserRecordDTO> list = signUserRecordRepository.queryPk(request.getSignHelpUserId(),
                request.getId());
        if (isEmpty(list)) {
            return ResultBuilder.failTSingle(Errors.Commons.REQUEST_PARAMETER_ERROR);
        }
        SignUserRecordDTO dto = list.get(0);
        SignUserRecord record = new SignUserRecord();
        record.setSignTime(new Date());
        record.setSignStatus(SignStatusEnum.S.getCode());
        record.setSignType(request.getSignType());
        record.setSignHelpUserId(request.getUserId());
        record.setId(dto.getId());
        boolean update = signUserRecordRepository.update(record);
        if (update) {

            //判断 绑定奖品信息 XXX待商榷
            if (StringUtil.isBlank(dto.getSignInPrize())) {
                threadPoolTaskExecutor.execute(() -> {
                    try {
                        String activityPrize = getActivityPrize();
                        SignUserRecord newR = new SignUserRecord();
                        newR.setSignInPrize(activityPrize);
                        SignUserRecordExample example = new SignUserRecordExample();
                        example.createCriteria().andCycleTimeEqualTo(dto.getCycleTime())
                                .andUserIdEqualTo(dto.getUserId());
                        signUserRecordRepository.updateByExampleSelective(newR, example);
                    } catch (Exception e) {
                        LOGGER.error(e.getMessage(), e);
                    }
                });
            }

            List<SignUserRecordDTO> newDTO = signUserRecordRepository
                    .queryPk(request.getSignHelpUserId(), request.getId());
            return ResultBuilder.succTSingle(newDTO.get(0));
        }
        return ResultBuilder.failTSingle(Errors.Commons.REQUEST_PARAMETER_ERROR);

    }

    private void xxx(SignUserRecordRequest request, SignUserRecordDTO recordDTO) {
        threadPoolTaskExecutor.execute(() -> {
            try {
                SignUserConfigDTO dto = signUserConfigRepository
                        .selectByPrimaryKey(request.getUserId());
                if (dto != null && dto.getState().equals(SwitchEnum.DISABLE.getCode())) {
                    SignUserConfig userConfig = new SignUserConfig();
                    userConfig.setUserId(request.getUserId());
                    userConfig.setState(SwitchEnum.ENABLE.getCode());
                    signUserConfigRepository.updateSelective(userConfig);
                }

                //判断 绑定奖品信息 XXX待商榷
                if (StringUtil.isBlank(recordDTO.getSignInPrize())) {
                    threadPoolTaskExecutor.execute(() -> {
                        try {
                            String activityPrize = getActivityPrize();
                            SignUserRecord newR = new SignUserRecord();
                            newR.setSignInPrize(activityPrize);
                            SignUserRecordExample example = new SignUserRecordExample();
                            example.createCriteria().andCycleTimeEqualTo(recordDTO.getCycleTime())
                                    .andUserIdEqualTo(recordDTO.getUserId());
                            signUserRecordRepository.updateByExampleSelective(newR, example);
                        } catch (Exception e) {
                            LOGGER.error(e.getMessage(), e);
                        }
                    });

                }

            } catch (Exception e) {
                LOGGER.error(e.getMessage(), e);
            }
        });
    }

    @Override
    public TMultiResult<SignUserRecordDTO> querySign(SignUserRecordRequest request) {
        ServiceAssert.notNull(request, Errors.Commons.REQUEST_PARAMETER_ERROR);
        ServiceAssert.notBlank(request.getUserId(), Errors.Commons.REQUEST_PARAMETER_ERROR);
        List<SignInConfigDTO> configList = signInConfigRepository
                .selectByExample(new SignInConfigExample());
        if (isEmpty(configList)) {
            LOGGER.error("签到初始化配置信息未配置");
            return ResultBuilder.failTMulti(Errors.Commons.REQUEST_PARAMETER_ERROR);
        }

        List<SignUserRecordDTO> convert = signUserRecordRepository
                .queryByCycleTime(request.getUserId(), request.getCycleTime(), request.getSortInfo());
        List<SignUserRecordDTO> list = Lists.newArrayList();
        if (isEmpty(convert)) {
            List<SignUserRecordDTO> dtoList = signUserRecordRepository.queryBySignTimeExt(
                    request.getUserId(), request.getCycleTime(), request.getSortInfo());
            if (isEmpty(dtoList)) {
                xxx(request, configList, list);
            } else {
                //获取周期   
                SignUserRecordDTO recordDTO = dtoList.get(0);
                Date cycleTime = recordDTO.getCycleTime();
                list = signUserRecordRepository.queryByCycleTime(request.getUserId(), cycleTime,
                        request.getSortInfo());
            }
        } else {
            list = convert;
        }
        return ResultBuilder.succTMulti(list);
    }

    private void xxx(SignUserRecordRequest request, List<SignInConfigDTO> configDTOList,
                     List<SignUserRecordDTO> list) {
        for (int i = 0; i < configDTOList.get(0).getDays(); i++) {
            SignUserRecord record = new SignUserRecord();
            record.setSignTimeExt(addDays(request.getCycleTime(), i));
            record.setCycleTime(request.getCycleTime());
            record.setUserId(request.getUserId());
            record.setSignStatus(SignStatusEnum.N.getCode());
            try {
                record.setSignInPrize(getActivityPrize());
            } catch (Exception e) {
                LOGGER.error(e.getMessage(), e);
            }

            list.add(SignUserRecordConvert.convert(record));
        }
    }

    private String getActivityPrize() {
        //查询奖品做关联
        String string = null;
        TSingleResult<ActivityConfigPrizeDTO> activity = activityConfigService
                .getUsingActivity(ActivityTypeEnum.Sign);
        checkResult(activity);
        if (activity.getValue() != null && !isEmpty(activity.getValue().getActivityPrize())) {
            List<ActivitySignPrizeDTO> activityPrize = activity.getValue().getActivityPrize();
            string = JSONObject.toJSONString(activityPrize);
        }
        return string;
    }

    @Override
    public TSingleResult<SignUserRecordDTO> queryByPk(SignUserRecordRequest request) {
        ServiceAssert.notNull(request, Errors.Commons.REQUEST_PARAMETER_ERROR);
        ServiceAssert.notBlank(request.getUserId(), Errors.Commons.REQUEST_PARAMETER_ERROR);
        ServiceAssert.notNull(request.getId(), Errors.Commons.REQUEST_PARAMETER_ERROR);
        List<SignUserRecordDTO> list = signUserRecordRepository.queryPk(request.getUserId(),
                request.getId());
        return ResultBuilder.succTSingle(isEmpty(list) ? null : list.get(0));
    }

    @Override
    @Transactional
    public TSingleResult<ProbabilityDrawResponse> probabilityDraw(SignUserRecordRequest request) {
        ServiceAssert.notNull(request, Errors.Commons.REQUEST_PARAMETER_ERROR);
        ServiceAssert.notBlank(request.getUserId(), Errors.Commons.REQUEST_PARAMETER_ERROR);
        ServiceAssert.notNull(request.getId(), Errors.Commons.REQUEST_PARAMETER_ERROR);

        TSingleResult<ActivityConfigPrizeDTO> result = activityConfigService
                .getUsingActivity(ActivityTypeEnum.Flop);
        checkResult(result);
        if (result.getValue() == null
                || CollectionUtils.isEmpty(result.getValue().getActivityPrize())) {
            LOGGER.error("抽奖接口,翻牌奖品信息未配置");
            return ResultBuilder.failTSingle(Errors.Commons.SYSTEM_ERROR);
        }

        TSingleResult<SignUserRecordDTO> singleResult = modifyLotteryCount(request);
        ServiceResultUtil.checkResult(singleResult);

        ProbabilityDrawResponse response = new ProbabilityDrawResponse();

        List<Pair<Double, ActivitySignPrizeModel>> randomItems = getPairs(
                result.getValue().getActivityPrize());

        WeightRandom weightRandom = new WeightRandom<>(randomItems);
        ActivitySignPrizeModel win = (ActivitySignPrizeModel) weightRandom.random();
        //中奖id
        response.setPrizeId(win.getId());
        ActivitySignPrizeTypeEnum prizeTypeEnum = EnumUtil
                .queryByCode(win.getPrizeType().toString(), ActivitySignPrizeTypeEnum.class);
        switch (prizeTypeEnum) {
            //签到奖金
            case BONUS:
                Integer signAwardId = insert(result.getValue().getType().toString(),
                        request.getUserId(), win);
                response.setSignAwardId(signAwardId);
                break;
            case BALANCE:
                //  将中奖 账户余额类型 记录到账户余额中
                addLuckMoneyToBalance(win.getId(), win.getPrizeMoney(), request.getUserId(),
                        UserAccountBizCode.SIGN_USER_FLOP.getCode());
                break;
            default:
                break;
        }
        response.setUserId(request.getUserId());
        response.setActivityPrize(result.getValue().getActivityPrize());
        return ResultBuilder.succTSingle(response);
    }

    private List<Pair<Double, ActivitySignPrizeModel>> getPairs(List<ActivitySignPrizeDTO> activityPrize) {
        return activityPrize.stream().map(it -> {
            ActivitySignPrizeModel model = new ActivitySignPrizeModel();
            BeanUtils.copyProperties(it, model);
            return new Pair<>(model.weight(), model);
        }).collect(Collectors.toList());
    }

    private Integer insert(String activityType, String userId, ActivitySignPrizeModel win) {
        SignAward award = new SignAward();
        //活动类型
        award.setActivityType(activityType);
        award.setUserId(userId);
        award.setPrizeStatus(SignPrizeStatusEnum.UNUSED.getCode());
        award.setPrizeType(win.getPrizeType().toString());
        award.setPrizePercent(win.getPrizePercent());
        award.setPrizeMoney(win.getPrizeMoney());
        award.setOverOrderMoney(win.getOverOrderMoney());
        award.setUsefulDay(win.getUsefulDay());
        signAwardRepository.insertSelective(award);
        return award.getId();
    }

    /**
     * 将签到翻牌中奖的账户余额类型 金额加到账户余额中
     *
     * @return 红包金额，单位分
     */
    private long addLuckMoneyToBalance(Integer id, long amount, String userId, String bizCode) {
        UserAccountOperatorRequest accOptReq = new UserAccountOperatorRequest();
        accOptReq.setAmount(amount);
        accOptReq.setUserId(userId);
        accOptReq.setBizCode(bizCode);
        accOptReq.setOptType(UserAccountOptTypeEnum.INCOME.getCode());
        accOptReq.setRemark("签到翻牌");
        accOptReq.setSourceCode(String.valueOf(id));
        takeAccountAmountManager.addBalance(accOptReq);
        return amount;
    }

    @Override
    public TSingleResult<SignUserRecordDTO> modifyLotteryCount(SignUserRecordRequest request) {
        ServiceAssert.notNull(request, Errors.Commons.REQUEST_PARAMETER_ERROR);
        ServiceAssert.notBlank(request.getUserId(), Errors.Commons.REQUEST_PARAMETER_ERROR);
        ServiceAssert.notNull(request.getId(), Errors.Commons.REQUEST_PARAMETER_ERROR);
        List<SignUserRecordDTO> dtoList = signUserRecordRepository.queryPk(request.getUserId(),
                request.getId());
        if (isEmpty(dtoList)) {
            return ResultBuilder.failTSingle(Errors.Commons.SYSTEM_ERROR);
        }
        SignUserRecordDTO dto = dtoList.get(0);
        SignUserRecord record = new SignUserRecord();
        record.setUserId(request.getUserId());
        record.setId(dto.getId());
        record.setSignFlopCount(request.getSignFlopCount());
        record.setShareFlopCount(request.getShareFlopCount());
        //判断修改后的值不会小于0
        if (request.getSignFlopCount() != null
                && (dto.getSignFlopCount() + request.getSignFlopCount()) < 0
                || request.getShareFlopCount() != null
                && (dto.getShareFlopCount() + request.getShareFlopCount()) < 0) {
            LOGGER.error("用户抽奖机会不足,活动id:{},userId:{}", request.getId(), request.getUserId());
            return ResultBuilder.failTSingle(Errors.Commons.SYSTEM_ERROR);
        }
        boolean b = signUserRecordRepository.modifyCount(record);
        if (!b) {
            return ResultBuilder.failTSingle(Errors.Commons.SYSTEM_ERROR);
        }
        List<SignUserRecordDTO> newList = signUserRecordRepository.queryPk(request.getUserId(),
                request.getId());
        return ResultBuilder.succTSingle(isEmpty(newList) ? null : newList.get(0));

    }

    @Override
    public TPageResult<SignUserRecordDTO> queryPage(SignUserRecordRequest request) {
        ServiceAssert.notNull(request, Errors.Commons.REQUEST_PARAMETER_ERROR);
        SignUserRecordExample example = toExample(request);
        List<SignUserRecordDTO> list = signUserRecordRepository.selectByExample(example);
        long count = 0;
        if (!isEmpty(list)) {
            count = signUserRecordRepository.countByExample(example);
        }
        return ResultBuilder.succTPage(list, request.getPage(), request.getRows(), (int) count);
    }

    @Override
    public TSingleResult<SignUserRecordDTO> takeShareCount(SignUserRecordRequest request) {
        ServiceAssert.notNull(request, Errors.Commons.REQUEST_PARAMETER_ERROR);
        ServiceAssert.notNull(request.getId(), Errors.Commons.REQUEST_PARAMETER_ERROR);
        ServiceAssert.notBlank(request.getUserId(), Errors.Commons.REQUEST_PARAMETER_ERROR);

        List<SignUserRecordDTO> dtoList = signUserRecordRepository.queryPk(request.getUserId(),
                request.getId());
        if (isEmpty(dtoList)) {
            return ResultBuilder.failTSingle(Errors.Commons.SYSTEM_ERROR);
        }

        SignUserRecord record = new SignUserRecord();
        record.setShareFlopCount(1);
        record.setId(request.getId());
        boolean update = signUserRecordRepository.update(record);
        if (!update) {
            return ResultBuilder.failTSingle(Errors.Commons.REQUEST_PARAMETER_ERROR);
        }
        List<SignUserRecordDTO> list = signUserRecordRepository.queryPk(request.getUserId(),
                request.getId());
        return ResultBuilder.succTSingle(isEmpty(list) ? null : list.get(0));
    }

    @Override
    public TSingleResult<SignUserRecordDTO> querySignByUser(SignUserRecordRequest request) {
        ServiceAssert.notNull(request, Errors.Commons.REQUEST_PARAMETER_ERROR);
        ServiceAssert.notBlank(request.getUserId(), Errors.Commons.REQUEST_PARAMETER_ERROR);
        ServiceAssert.notNull(request.getSignTimeExt(), Errors.Commons.REQUEST_PARAMETER_ERROR);
        List<SignUserRecordDTO> dtoList = signUserRecordRepository.queryBySignTimeExt(
                request.getUserId(), request.getSignTimeExt(), request.getSortInfo());
        return ResultBuilder.succTSingle(isEmpty(dtoList) ? null : dtoList.get(0));
    }

    @Override
    public TMultiResult<SignUserRecordDTO> queryCurrentCycle(SignUserRecordRequest request) {
        ServiceAssert.notNull(request, Errors.Commons.REQUEST_PARAMETER_ERROR);
        ServiceAssert.notNull(request.getSignTimeExt(), Errors.Commons.REQUEST_PARAMETER_ERROR);
        List<SignUserRecordDTO> convert = signUserRecordRepository
                .queryBySignTimeExt(request.getSignTimeExt(), request.getSortInfo(), 1, 1);
        if (isEmpty(convert)) {
            return ResultBuilder.succTMulti(Lists.newArrayList());
        }
        SignUserRecordDTO dto = convert.get(0);
        //分组取一天信息 用户信息
        List<SignUserRecordDTO> dtoList = signUserRecordRepository.select(dto.getCycleTime());

        if (CollectionUtils.isEmpty(dtoList)) {
            return ResultBuilder.succTMulti(Lists.newArrayList());
        }

        List<SignUserRecordDTO> success = Lists.newArrayList();
        for (SignUserRecordDTO item : dtoList) {
            SignUserRecordExample example = new SignUserRecordExample();
            SignUserRecordExample.Criteria criteria = example.createCriteria();
            criteria.andUserIdEqualTo(item.getUserId());
            criteria.andCycleTimeEqualTo(item.getCycleTime());
            criteria.andSignTimeExtGreaterThanOrEqualTo(item.getCycleTime());
            criteria.andSignTimeExtLessThanOrEqualTo(request.getSignTimeExt());
            example.setOrderByClause(" sign_time_ext desc");
            List<SignUserRecordDTO> list = signUserRecordRepository.selectByExample(example);
            if (CollectionUtils.isEmpty(list)) {
                continue;
            }
            //今天的数据
            SignUserRecordDTO recordDTO = list.get(0);
            //未签到
            if (recordDTO.getSignStatus().equals(SignStatusEnum.N.getCode())) {
                List<SignUserRecordDTO> collect = list.stream().filter(it -> {
                    // 当天的签到时间
                    Date signTimeExt = recordDTO.getSignTimeExt();
                    long diffDays = getDiffDays(signTimeExt, it.getSignTimeExt());
                    LOGGER.info("diffDays:{}", diffDays);
                    boolean equals = it.getSignStatus().equals(SignStatusEnum.Y.getCode());
                    return ((diffDays == 2 || diffDays == 1) && equals);
                }).collect(Collectors.toList());
                if (CollectionUtils.isEmpty(collect)) {
                    continue;
                }
                success.add(collect.get(0));
            }
        }
        return ResultBuilder.succTMulti(success);
    }

    @Override
    public TMultiResult<SignUserRecordDTO> queryNearingEnd(SignUserRecordRequest request) {
        ServiceAssert.notNull(request, Errors.Commons.REQUEST_PARAMETER_ERROR);
        ServiceAssert.notNull(request.getSignTimeExt(), Errors.Commons.REQUEST_PARAMETER_ERROR);
        List<SignUserRecordDTO> convert = signUserRecordRepository
                .queryBySignTimeExt(request.getSignTimeExt(), request.getSortInfo(), 1, 1);
        if (isEmpty(convert)) {
            return ResultBuilder.succTMulti(Lists.newArrayList());
        }
        SignUserRecordDTO dto = convert.get(0);
        //分组取一天信息 用户信息
        List<SignUserRecordDTO> dtoList = signUserRecordRepository.select(dto.getCycleTime());

        if (CollectionUtils.isEmpty(dtoList)) {
            return ResultBuilder.succTMulti(Lists.newArrayList());
        }
        List<SignUserRecordDTO> success = Lists.newArrayList();
        for (SignUserRecordDTO item : dtoList) {
            SignUserRecordExample example = new SignUserRecordExample();
            SignUserRecordExample.Criteria criteria = example.createCriteria();
            criteria.andUserIdEqualTo(item.getUserId());
            criteria.andCycleTimeEqualTo(item.getCycleTime());
            criteria.andSignTimeExtGreaterThanOrEqualTo(item.getCycleTime());
            criteria.andSignTimeExtLessThanOrEqualTo(request.getSignTimeExt());
            example.setOrderByClause(" sign_time_ext desc");
            List<SignUserRecordDTO> list = signUserRecordRepository.selectByExample(example);
            if (CollectionUtils.isEmpty(list)) {
                continue;

            }
            //今天的数据
            SignUserRecordDTO recordDTO = list.get(0);
            if (recordDTO.getSignStatus().equals(SignStatusEnum.Y.getCode())) {
                continue;

            }
            //周期已满足
            if (list.size() == 7 || list.size() == 6) {
                success.add(list.get(0));
            }
        }
        return ResultBuilder.succTMulti(success);
    }

    @Override
    public TMultiResult<SignUserRecordDTO> queryBeforeSignUser(SignUserRecordRequest request) {
        ServiceAssert.notNull(request, Errors.Commons.REQUEST_PARAMETER_ERROR);
        List<SignUserRecordDTO> list = signUserRecordRepository
                .queryBeforeSignUser(request.start4Mysql(), request.getRows());
        if (CollectionUtils.isEmpty(list)) {
            return ResultBuilder.succTMulti(Lists.newArrayList());
        }
        return ResultBuilder.succTMulti(list);

    }

    private SignUserRecordExample getSignUserRecordExample(SignUserRecordRequest request) {
        SignUserRecordExample example = new SignUserRecordExample();
        SignUserRecordExample.Criteria criteria = example.createCriteria();
        if (StringUtil.isNotBlank(request.getUserId())) {
            criteria.andUserIdEqualTo(request.getUserId());
        }

        if (request.getCycleTime() != null) {
            criteria.andCycleTimeEqualTo(request.getCycleTime());
        }

        if (request.getSignTimeExt() != null) {
            criteria.andSignTimeExtEqualTo(request.getSignTimeExt());
        }
        if (!isEmpty(request.getSignStatus())) {
            criteria.andSignStatusIn(request.getSignStatus());
        }

        return example;
    }

    private SignUserRecordExample toExample(SignUserRecordRequest request) {
        SignUserRecordExample example = getSignUserRecordExample(request);
        example.setOffset(request.start4Mysql());
        example.setLimit(request.getRows());
        if (StringUtil.isNotBlank(request.getSortInfo())) {
            example.setOrderByClause(request.getSortInfo());
        }

        return example;
    }

}
