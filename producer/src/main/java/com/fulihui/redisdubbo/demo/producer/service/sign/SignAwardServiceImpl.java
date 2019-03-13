package com.fulihui.redisdubbo.demo.producer.service.sign;


import com.alibaba.fastjson.JSONObject;
import com.fulihui.redisdubbo.demo.api.api.sign.SignAwardService;
import com.fulihui.redisdubbo.demo.api.dto.UserFormRecordDTO;
import com.fulihui.redisdubbo.demo.api.dto.sign.SignAwardDTO;
import com.fulihui.redisdubbo.demo.api.enums.ActivitySignPrizeTypeEnum;
import com.fulihui.redisdubbo.demo.api.enums.SignPrizeStatusEnum;
import com.fulihui.redisdubbo.demo.api.enums.UserAccountBizCode;
import com.fulihui.redisdubbo.demo.api.request.sign.SignAwardRequest;
import com.fulihui.redisdubbo.demo.producer.dal.dataobj.SignAward;
import com.fulihui.redisdubbo.demo.producer.dal.dataobj.SignAwardExample;
import com.fulihui.redisdubbo.demo.producer.dal.dataobj.UserFormRecord;
import com.fulihui.redisdubbo.demo.producer.manager.AppSendMessageManager;
import com.fulihui.redisdubbo.demo.producer.manager.SignOrderReceiptManager;
import com.fulihui.redisdubbo.demo.producer.repository.SignAwardRepository;
import com.fulihui.redisdubbo.demo.producer.repository.UserFormRepository;
import com.fulihui.redisdubbo.demo.producer.util.Consts;
import com.google.common.collect.*;
import org.apache.dubbo.config.annotation.Service;
import org.near.servicesupport.error.Errors;
import org.near.servicesupport.result.*;
import org.near.toolkit.common.DateUtils;
import org.near.toolkit.common.StringUtil;
import org.near.toolkit.model.Money;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.text.ParseException;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static com.fulihui.redisdubbo.demo.api.enums.MessageChannelEnum.SIGN_THE_ORDER;
import static com.fulihui.redisdubbo.demo.api.enums.SwitchEnum.DISABLE;
import static com.fulihui.redisdubbo.demo.api.enums.SwitchEnum.ENABLE;
import static org.near.servicesupport.util.ServiceAssert.*;
import static org.near.servicesupport.util.ServiceResultUtil.isSuccess;
import static org.springframework.util.CollectionUtils.isEmpty;

/**
 * @author lizhi
 * @date 2018-10-17
 */
@Service(version = "${demo.service.version}")
public class SignAwardServiceImpl implements SignAwardService {
    private static final Logger ORDER_FANS_BIZ_LOGGER = LoggerFactory
            .getLogger(Consts.LoggerName.ORDER_FANS_BIZ);

    private static final Logger LOGGER = LoggerFactory
            .getLogger(SignAwardServiceImpl.class);
    @Autowired
    SignAwardRepository signAwardRepository;
    @Autowired
    AppSendMessageManager appSendMessageManager;
    @Autowired
    UserFormRepository userFormRepository;
    @Autowired
    ThreadPoolTaskExecutor threadPoolTaskExecutor;
    @Autowired
    SignOrderReceiptManager signOrderReceiptManager;

    public static void main(String[] args) throws ParseException {

        Date now = DateUtils.parseWebFormat("2018-10-01");
        now.setHours(23);
        now.setMinutes(59);
        now.setSeconds(59);

        Date days = DateUtils.addDays(now, 7);

        System.out.println(DateUtils.formatWebFormat(now) + "--" + DateUtils.formatNewFormat(days));

        List<SignAwardDTO> list = Lists.newArrayList();

        SignAwardDTO f = new SignAwardDTO();
        f.setId(1);
        f.setOverOrderMoney(2);
        f.setGmtCreate(new Date());
        f.setUsefulDay(2);
        f.setPrizeType("2");
        f.setPrizeMoney(10);

        SignAwardDTO f1 = new SignAwardDTO();
        f1.setId(2);
        f1.setOverOrderMoney(3);
        f1.setGmtCreate(new Date());
        f1.setUsefulDay(3);
        f1.setPrizeType("2");
        f1.setPrizeMoney(13);

        SignAwardDTO f3 = new SignAwardDTO();
        f3.setId(4);
        f3.setOverOrderMoney(3);
        f3.setGmtCreate(new Date());
        f3.setUsefulDay(4);
        f3.setPrizeType("1");
        f3.setPrizeMoney(11);

        list.add(f);
        list.add(f1);
        list.add(f3);

        list.sort((t, t1) -> ComparisonChain.start().compare(t1.getPrizeType(), t.getPrizeType())
                .compare(t1.getPrizeMoney(), t.getPrizeMoney()).result());

        for (SignAwardDTO signAwardDTO : list) {
            System.out.println(signAwardDTO.getPrizeType() + "--" + signAwardDTO.getPrizeMoney());
        }

        Date start = DateUtils.addDays(new Date(), -1);
        start.setHours(0);
        start.setSeconds(0);
        start.setMinutes(0);
        System.out.println(DateUtils.formatNewFormat(start));

    }

    @Override
    public TPageResult<SignAwardDTO> queryPage(SignAwardRequest request) {
        notNull(request, Errors.Commons.REQUEST_PARAMETER_ERROR);
        SignAwardExample example = toExample(request);
        List<SignAwardDTO> list = signAwardRepository.selectByExample(example);

        long count = 0;
        if (!isEmpty(list)) {
            count = signAwardRepository.countByExample(example);
        }
        return ResultBuilder.succTPage(list, request.getPage(), request.getRows(), (int) count);
    }

    @Override
    public TSingleResult<SignAwardDTO> selectByPrimaryKey(SignAwardRequest request) {
        notNull(request, Errors.Commons.REQUEST_PARAMETER_ERROR);
        notNull(request.getId(), Errors.Commons.REQUEST_PARAMETER_ERROR);

        SignAwardDTO dto = signAwardRepository.selectByPrimaryKey(request.getId());
        return ResultBuilder.succTSingle(dto);
    }

    @Override
    public TPageResult<SignAwardDTO> queryReceipt(SignAwardRequest request) {
        notNull(request, Errors.Commons.REQUEST_PARAMETER_ERROR);
        notEmpty(request.getPrizeStatus(), Errors.Commons.REQUEST_PARAMETER_ERROR);
        notBlank(request.getBindOrderStatus(), Errors.Commons.REQUEST_PARAMETER_ERROR);

        List<SignAwardDTO> list = signAwardRepository.queryExceedDay(
                request.getPrizeStatus().get(0), request.getBindOrderStatus(), request.start4Mysql(),
                request.getRows());
        long count = 0;
        if (!CollectionUtils.isEmpty(list)) {
            count = signAwardRepository.queryExceedDayCount(request.getPrizeStatus().get(0),
                    request.getBindOrderStatus());
        }
        return ResultBuilder.succTPage(list, request.getPage(), request.getRows(), (int) count);
    }

    @Override
    @Transactional
    public TSingleResult<SignAwardDTO> confirmReceiptAddBalance(SignAwardRequest request) {
        notNull(request, Errors.Commons.REQUEST_PARAMETER_ERROR);
        notNull(request.getId(), Errors.Commons.REQUEST_PARAMETER_ERROR);
        SignAwardDTO value = signAwardRepository.selectByPrimaryKey(request.getId());
        //如果不等于空
        if (value != null) {
            //奖金已发放
            if (StringUtil.equals(SignPrizeStatusEnum.ISSUED.getCode(), value.getPrizeStatus())) {
                return ResultBuilder.succTSingle(value);
            }

            long prizeMoney = value.getPrizeMoney().longValue();
            SignAwardRequest update = new SignAwardRequest();
            update.setId(value.getId());
            update.setPrizeStatus(Lists.newArrayList(SignPrizeStatusEnum.ISSUED.getCode()));
            BaseResult baseResult = update(update);
            if (isSuccess(baseResult)) {
                String orderSn = value.getOrderSn();
                String userId = value.getUserId();
                signOrderReceiptManager.addMoneyToBalance(orderSn, prizeMoney, userId, "签到奖励",
                        UserAccountBizCode.ORDER_SIGN_REWARD.getCode());
                //发送模板消息
                signOrderReceiptManager.send(userId);
            }
        } else {
            return ResultBuilder.failTSingle(Errors.Commons.SYSTEM_ERROR);
        }

        SignAwardDTO newValue = signAwardRepository.selectByPrimaryKey(request.getId());
        return ResultBuilder.succTSingle(newValue);

    }

    @Override
    public TSingleResult<Integer> bindOrder(SignAwardRequest request) {
        notNull(request, Errors.Commons.REQUEST_PARAMETER_ERROR);
        notNull(request.getOrderSn(), Errors.Commons.REQUEST_PARAMETER_ERROR);
        notNull(request.getUserId(), Errors.Commons.REQUEST_PARAMETER_ERROR);
        //订单金额满多少可用',
        notNull(request.getOverOrderMoney(), Errors.Commons.REQUEST_PARAMETER_ERROR);

        SignAwardExample example = new SignAwardExample();
        SignAwardExample.Criteria criteria = example.createCriteria();
        //未使用
        criteria.andPrizeStatusEqualTo(SignPrizeStatusEnum.UNUSED.getCode());
        //用户id
        criteria.andUserIdEqualTo(request.getUserId());
        criteria.andPrizeTypeEqualTo(ActivitySignPrizeTypeEnum.BONUS.getCode());
        //订单金额满多少可使用
        criteria.andOverOrderMoneyLessThanOrEqualTo(request.getOverOrderMoney());
        LOGGER.info("bindOrder.request:{}", request);
        List<SignAwardDTO> list = signAwardRepository.selectByExample(example);

        if (CollectionUtils.isEmpty(list)) {
            LOGGER.info("没有可以绑定使用的签到奖金,user:{}", request.getUserId());
            return ResultBuilder.succTSingle(0);
        }
        // 排序 获取最大的 并且  按照失效最近优先绑定。
        //  一个订单付款后，只会绑定1个未使用的签到奖金。满足签到奖金使用条件的，
        // 当有多个签到奖金时，
        // 优先按照签到奖金面额大的优先绑定，相同面额的签到奖金，按照失效最近优先绑定。
        list.sort((t, t1) -> ComparisonChain.start()
                .compare(t1.getOverOrderMoney(), t.getOverOrderMoney())
                .compare(DateUtils.addDays(t.getGmtCreate(), t.getUsefulDay()),
                        DateUtils.addDays(t1.getGmtCreate(), t1.getUsefulDay()))
                .result());
        SignAwardDTO signAwardDTO = list.get(0);
        SignAward record = new SignAward();
        record.setId(signAwardDTO.getId());
        record.setOrderSn(request.getOrderSn());
        record.setPrizeStatus(SignPrizeStatusEnum.BIND.getCode());
        record.setBindOrderStatus(request.getBindOrderStatus());
        int i = signAwardRepository.updateByPrimaryKeySelective(record);
        if (i > 0) {
            send(request.getUserId(), signAwardDTO.getPrizeMoney());
        }
        return ResultBuilder.succTSingle(record.getId());
    }

    private void send(String userId, Integer prizeMoney) {
        //发送绑定模板信息
        threadPoolTaskExecutor.execute(() -> {
            ORDER_FANS_BIZ_LOGGER.info("订单签到绑定金额推送模板消息开始,userId:{}", userId);
            Map<String, String> propertyMap = Maps.newHashMap();
            Money money = new Money();
            money.setCent(prizeMoney);
            propertyMap.put("keyword1", money.toString() + "元签到奖金激活成功");
            propertyMap.put("keyword2", "无");
            propertyMap.put("keyword3", "该签到奖金已激活！订单确定收货7天后即可到账！点此了解更多>>");
            String content = JSONObject.toJSONString(propertyMap);
            //查询有效的formId
            List<UserFormRecordDTO> recordList = userFormRepository.query(userId, ENABLE.getCode());
            if (!isEmpty(recordList)) {
                UserFormRecordDTO formRecord = recordList.get(0);
                boolean b = appSendMessageManager.sendMessage(SIGN_THE_ORDER.getCode(), userId,
                        content, formRecord.getFormId(), null);
                if (b) {
                    UserFormRecord newRecord = new UserFormRecord();
                    newRecord.setId(formRecord.getId());
                    newRecord.setFormStatus(DISABLE.getCode());
                    newRecord.setFormDesc("分享赚消息推送成功过期");
                    userFormRepository.update(newRecord);
                } else {
                    ORDER_FANS_BIZ_LOGGER.info("订单签到绑定金额,发送模板消息失败,该用户userId:{}", userId);
                }
            } else {
                ORDER_FANS_BIZ_LOGGER.info("订单签到绑定金额,发送模板消息未查询到可使用的formId,该用户userId:{}", userId);
            }
        });
    }

    @Override
    public TSingleResult<SignAwardDTO> queryUserIdOrderSn(SignAwardRequest request) {
        notNull(request, Errors.Commons.REQUEST_PARAMETER_ERROR);
        notNull(request.getOrderSn(), Errors.Commons.REQUEST_PARAMETER_ERROR);
        notBlank(request.getUserId(), Errors.Commons.REQUEST_PARAMETER_ERROR);
        SignAwardExample example = new SignAwardExample();
        SignAwardExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(request.getUserId());
        criteria.andOrderSnEqualTo(request.getOrderSn());
        if (!isEmpty(request.getPrizeStatus())) {
            criteria.andPrizeStatusIn(request.getPrizeStatus());
        }
        List<SignAwardDTO> list = signAwardRepository.selectByExample(example);
        if (CollectionUtils.isEmpty(list)) {
            return ResultBuilder.succTSingle(null);
        }
        return ResultBuilder.succTSingle(list.get(0));
    }

    @Override
    public TSingleResult<Long> sumPrizeMoney(SignAwardRequest request) {
        notNull(request, Errors.Commons.REQUEST_PARAMETER_ERROR);
        notNull(request.getUserId(), Errors.Commons.REQUEST_PARAMETER_ERROR);

        List<String> prizeType = null;
        if (StringUtil.isNotBlank(request.getPrizeType())) {
            prizeType = Lists.newArrayList(request.getPrizeType());
        }
        List<String> activityType = null;
        if (StringUtil.isNotBlank(request.getActivityType())) {
            activityType = Lists.newArrayList(request.getActivityType());
        }

        long prizeMoney = signAwardRepository.sumPrizeMoney(request.getUserId(), prizeType,
                request.getPrizeStatus(), activityType);
        return ResultBuilder.succTSingle(prizeMoney);
    }

    @Override
    public TSingleResult<Integer> insert(SignAwardRequest request) {
        notNull(request, Errors.Commons.REQUEST_PARAMETER_ERROR);
        notBlank(request.getUserId(), Errors.Commons.REQUEST_PARAMETER_ERROR);

        SignAward award = new SignAward();
        award.setUserId(request.getUserId());
        award.setActivityType(request.getActivityType());
        award.setSignCount(request.getSignCount());
        award.setPrizeStatus(SignPrizeStatusEnum.UNUSED.getCode());
        award.setPrizeType(request.getPrizeType());
        award.setPrizePercent(request.getPrizePercent());
        award.setPrizeMoney(request.getPrizeMoney());
        award.setOverOrderMoney(request.getOverOrderMoney());
        award.setUsefulDay(request.getUsefulDay());
        award.setCycleTime(request.getCycleTime());
        signAwardRepository.insertSelective(award);
        return ResultBuilder.succTSingle(award.getId());

    }

    @Override
    public BaseResult failure(SignAwardRequest request) {
        notNull(request, Errors.Commons.REQUEST_PARAMETER_ERROR);
        notBlank(request.getUserId(), Errors.Commons.REQUEST_PARAMETER_ERROR);
        notBlank(request.getOrderSn(), Errors.Commons.REQUEST_PARAMETER_ERROR);
        SignAwardExample example = new SignAwardExample();
        SignAwardExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(request.getUserId());
        criteria.andOrderSnEqualTo(request.getOrderSn());
        List<SignAwardDTO> list = signAwardRepository.selectByExample(example);
        LOGGER.info("订单无效处理,request:{},list{};", request, list);
        if (!CollectionUtils.isEmpty(list)) {
            SignAward newAward = new SignAward();
            SignAwardDTO dto = list.get(0);
            Date now = new Date();
            Date gmtCreate = dto.getGmtCreate();
            gmtCreate.setHours(23);
            gmtCreate.setMinutes(59);
            gmtCreate.setSeconds(59);
            Date days = DateUtils.addDays(dto.getGmtCreate(), dto.getUsefulDay());
            if (now.after(days)) {
                //已过期
                newAward.setPrizeStatus(SignPrizeStatusEnum.EXPIRED.getCode());
            } else {
                newAward.setPrizeStatus(SignPrizeStatusEnum.UNUSED.getCode());
            }
            newAward.setId(dto.getId());
            signAwardRepository.updateByPrimaryKeySelective(newAward);
        }
        return ResultBuilder.succ();
    }

    @Override
    public BaseResult update(SignAwardRequest request) {
        notNull(request, Errors.Commons.REQUEST_PARAMETER_ERROR);
        notNull(request.getId(), Errors.Commons.REQUEST_PARAMETER_ERROR);

        SignAward newAward = new SignAward();
        newAward.setId(request.getId());
        if (!CollectionUtils.isEmpty(request.getPrizeStatus())) {
            newAward.setPrizeStatus(request.getPrizeStatus().get(0));
        }
        newAward.setBindOrderStatus(request.getBindOrderStatus());
        signAwardRepository.updateByPrimaryKeySelective(newAward);
        return ResultBuilder.succ();
    }

    @Override
    public TMultiResult<SignAwardDTO> queryAsOfGmtCreate(SignAwardRequest request) {
        notNull(request, Errors.Commons.REQUEST_PARAMETER_ERROR);
        notNull(request.getGmtCreate(), Errors.Commons.REQUEST_PARAMETER_ERROR);
        Date gmtCreate = request.getGmtCreate();
        // 2018-10-21 21:00:00
        Date start = DateUtils.addDays(gmtCreate, -1);
        start.setHours(0);
        start.setSeconds(0);
        start.setMinutes(0);

        SignAwardExample example = new SignAwardExample();
        SignAwardExample.Criteria criteria = example.createCriteria();
        criteria.andGmtCreateGreaterThanOrEqualTo(start);
        criteria.andGmtCreateLessThanOrEqualTo(gmtCreate);
        criteria.andPrizeStatusEqualTo(SignPrizeStatusEnum.UNUSED.getCode());
        criteria.andPrizeTypeEqualTo(ActivitySignPrizeTypeEnum.BONUS.getCode());
        criteria.andOrderSnIsNull();
        List<SignAwardDTO> list = signAwardRepository.selectByExample(example);
        if (CollectionUtils.isEmpty(list)) {
            return ResultBuilder.succTMulti(Lists.newArrayList());
        }
        List<SignAwardDTO> success = asBuild(list);
        return ResultBuilder.succTMulti(success);
    }

    private List<SignAwardDTO> asBuild(List<SignAwardDTO> list) {
        List<SignAwardDTO> success = Lists.newArrayList();
        ImmutableListMultimap multimap = Multimaps.index(list, input -> {
            assert input != null;
            return input.getUserId();
        });
        ImmutableMap<String, Collection<SignAwardDTO>> asMap = multimap.asMap();
        asMap.forEach((userId, v) -> {
            int sum = v.stream().mapToInt(SignAwardDTO::getPrizeMoney).sum();
            SignAwardDTO item = new SignAwardDTO();
            item.setPrizeMoney(sum);
            item.setUserId(userId);
            success.add(item);
        });
        return success;
    }

    @Override
    public TMultiResult<SignAwardDTO> queryLastValidity(SignAwardRequest request) {
        notNull(request, Errors.Commons.REQUEST_PARAMETER_ERROR);
        notNull(request.getGmtCreate(), Errors.Commons.REQUEST_PARAMETER_ERROR);
        List<SignAwardDTO> list = signAwardRepository.queryLastValidity(
                ActivitySignPrizeTypeEnum.BONUS.getCode(), SignPrizeStatusEnum.UNUSED.getCode(),
                request.getActivityType());
        if (CollectionUtils.isEmpty(list)) {
            return ResultBuilder.succTMulti(list);
        }
        List<SignAwardDTO> success = asBuild(list);
        return ResultBuilder.succTMulti(success);
    }

    private SignAwardExample toExample(SignAwardRequest request) {
        SignAwardExample example = getSignAwardExample(request);
        example.setOffset(request.start4Mysql());
        example.setLimit(request.getRows());
        if (StringUtil.isNotBlank(request.getSortInfo())) {
            example.setOrderByClause(request.getSortInfo());
        }

        return example;
    }

    private SignAwardExample getSignAwardExample(SignAwardRequest request) {
        SignAwardExample example = new SignAwardExample();
        SignAwardExample.Criteria criteria = example.createCriteria();
        if (StringUtil.isNotBlank(request.getUserId())) {
            criteria.andUserIdEqualTo(request.getUserId());
        }
        if (StringUtil.isNotBlank(request.getActivityType())) {
            criteria.andActivityTypeEqualTo(request.getActivityType());
        }

        if (request.getCycleTime() != null) {
            criteria.andCycleTimeEqualTo(request.getCycleTime());
        }

        if (request.getOrderSn() != null) {
            criteria.andOrderSnEqualTo(request.getOrderSn());
        }
        if (!isEmpty(request.getPrizeStatus())) {
            criteria.andPrizeStatusIn(request.getPrizeStatus());
        }
        return example;
    }
}
