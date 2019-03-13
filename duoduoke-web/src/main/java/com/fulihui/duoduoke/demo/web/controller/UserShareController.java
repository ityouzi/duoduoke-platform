package com.fulihui.duoduoke.demo.web.controller;


import com.fulihui.duoduoke.demo.api.dto.OrderFansDetailDTO;
import com.fulihui.duoduoke.demo.api.dto.OrderInfoDTO;
import com.fulihui.duoduoke.demo.api.dto.UserDTO;
import com.fulihui.duoduoke.demo.api.enums.OrderFansTypeEnum;
import com.fulihui.duoduoke.demo.api.request.OrderFansDetailRequest;
import com.fulihui.duoduoke.demo.api.request.OrderQueryInfoRequest;
import com.fulihui.duoduoke.demo.api.request.UserQueryRequest;
import com.fulihui.duoduoke.demo.web.integration.OrderFansDetailServiceClient;
import com.fulihui.duoduoke.demo.web.integration.OrderInfoServiceClient;
import com.fulihui.duoduoke.demo.web.integration.UserServiceClient;
import com.fulihui.duoduoke.demo.web.manager.UserFansDetailManager;
import com.fulihui.duoduoke.demo.web.param.FansOrderParam;
import com.fulihui.duoduoke.demo.web.param.UserFansParam;
import com.fulihui.duoduoke.demo.web.util.Principal;
import com.fulihui.duoduoke.demo.web.util.PrincipalUtil;
import com.fulihui.duoduoke.demo.web.vo.UserFansVO;
import com.fulihui.duoduoke.demo.web.vo.UserInvitationVO;
import com.fulihui.duoduoke.demo.web.vo.UserOrderVO;
import com.fulihui.duoduoke.demo.web.vo.UserShareFansVO;
import com.fulihui.duoduoke.demo.common.except.BizException;
import com.fulihui.duoduoke.demo.common.except.CommonErrors;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.near.servicesupport.result.TPageResult;
import org.near.servicesupport.result.TSingleResult;
import org.near.toolkit.common.DateUtils;
import org.near.toolkit.common.EnumUtil;
import org.near.toolkit.common.StringUtil;
import org.near.toolkit.model.Money;
import org.near.webmvcsupport.view.JsonResult;
import org.near.webmvcsupport.view.PageView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

import static com.google.common.collect.Lists.newArrayList;
import static org.near.servicesupport.util.ServiceResultUtil.checkResult;
import static org.near.webmvcsupport.view.JsonResultBuilder.succ;
import static org.near.webmvcsupport.view.PageViewBuilder.build;

/**
 * @author lizhi
 * @date 2018-7-31
 */
@RestController
@RequestMapping("/userShare")
@Api(description = "邀请信息api")
public class UserShareController {

    private static final Logger  LOGGER = LoggerFactory.getLogger(UserAccountController.class);
    @Autowired
    UserFansDetailManager userFansDetailManager;

    @Autowired
    UserServiceClient userServiceClient;
    @Autowired
    OrderInfoServiceClient orderInfoServiceClient;
    @Autowired
    OrderFansDetailServiceClient orderFansDetailServiceClient;

    /**
     * 邀请总览统计
     */
    @PostMapping("/statistics")
    @ApiOperation(value = "邀请总览统计")
    JsonResult<UserShareFansVO> statistics(HttpServletRequest request) {
        Principal principal = PrincipalUtil.getPrincipal();
        UserShareFansVO fansVO = userFansDetailManager.accumulative(principal.getUserId());
        return succ(fansVO);
    }

    /**
     * 邀请总览明细
     */
    @PostMapping("/detail")
    @ApiOperation(value = "邀请总览明细")
    JsonResult<UserInvitationVO> detail(HttpServletRequest request) {
        Principal principal = PrincipalUtil.getPrincipal();
        UserInvitationVO invitation = userFansDetailManager.invitation(principal.getUserId());
        return succ(invitation);
    }

    /**
     * 我的粉丝订单
     */
    @PostMapping("/fansOrder")
    @ApiOperation(value = "我的粉丝订单")
    JsonResult<PageView<UserOrderVO>> fansOrder(HttpServletRequest request,
                                                @RequestBody FansOrderParam param) {

        Principal principal = PrincipalUtil.getPrincipal();
        OrderFansDetailRequest detailRequest = new OrderFansDetailRequest();

        detailRequest.setPUserId(principal.getUserId());
        detailRequest.setPage(param.getPage());
        detailRequest.setRows(param.getRows());
        detailRequest.setFansAmount(0);
        detailRequest.setFansType(OrderFansTypeEnum.SHARE.getCode());
        String orderStatus = param.getOrderStatus();
        if (StringUtil.equals(orderStatus, "-1")) {
            detailRequest.setOrderStatus(newArrayList("-1"));
            detailRequest.setSortInfo("  order_create_time desc");
        } else if (StringUtil.equals(orderStatus, "1")) {
            detailRequest.setOrderStatus(newArrayList("1", "0", "2"));
            detailRequest.setSortInfo("  order_create_time desc");
        } else if (StringUtil.equals(orderStatus, "3")) {
            detailRequest.setSortInfo("  gmt_modified desc");
            detailRequest.setOrderStatus(newArrayList("3", "5"));
        } else if (StringUtil.equals(orderStatus, "4")) {
            detailRequest.setSortInfo("  gmt_modified desc");
            detailRequest.setOrderStatus(newArrayList("4", "8", "10"));
        } else {
            throw new BizException(CommonErrors.ILLIGEAL_REQUEST_ERROR);
        }

        TPageResult<OrderFansDetailDTO> result = orderFansDetailServiceClient
            .queryPage(detailRequest);
        List<OrderFansDetailDTO> values = result.getValues();
        List<UserOrderVO> collect = values.stream().map(this::apply).collect(Collectors.toList());
        PageView<UserOrderVO> build = build(collect, result.getPage(), result.getRows(),
            result.getTotalRows());
        return succ(build);
    }

    /**
     * 我的粉丝列表
     */
    @PostMapping("/queryFans")
    @ApiOperation(value = "我的粉丝列表")
    JsonResult<PageView<UserFansVO>> queryFans(@RequestBody UserFansParam param) {
        Principal principal = PrincipalUtil.getPrincipal();
        if (StringUtil.equals(param.getLevel(), "1")) {
            UserQueryRequest queryRequest = new UserQueryRequest();
            queryRequest.setRows(param.getRows());
            queryRequest.setPage(param.getPage());
            queryRequest.setSortInfo(" gmt_create desc");
            queryRequest.setUserReferee(newArrayList(principal.getUserId()));
            TPageResult<UserDTO> result = userServiceClient.queryPage(queryRequest);
            checkResult(result);
            List<UserDTO> values = result.getValues();
            List<UserFansVO> collect = convert(values);
            PageView<UserFansVO> build = build(collect, result.getPage(), result.getRows(),
                result.getTotalRows());
            return succ(build);
        } else if (StringUtil.equals(param.getLevel(), "2")) {
            UserQueryRequest queryRequest = new UserQueryRequest();
            queryRequest.setRows(Integer.MAX_VALUE);
            queryRequest.setPage(1);
            queryRequest.setUserReferee(newArrayList(principal.getUserId()));
            TPageResult<UserDTO> result = userServiceClient.queryPage(queryRequest);
            checkResult(result);
            List<String> transform = result.getValues().stream().map(UserDTO::getUserId)
                .collect(Collectors.toList());
            UserQueryRequest pageReq = new UserQueryRequest();
            pageReq.setRows(param.getRows());
            pageReq.setPage(param.getPage());
            pageReq.setUserReferee(transform);
            pageReq.setSortInfo(" gmt_create desc");
            TPageResult<UserDTO> tPageResult = userServiceClient.queryPage(pageReq);
            checkResult(tPageResult);
            List<UserFansVO> collect = convert(tPageResult.getValues());
            PageView<UserFansVO> build = build(collect, tPageResult.getPage(),
                tPageResult.getRows(), tPageResult.getTotalRows());
            return succ(build);
        } else {
            throw new BizException(CommonErrors.ILLIGEAL_REQUEST_ERROR);
        }
    }

    private List<UserFansVO> convert(List<UserDTO> values) {
        return values.stream().map(it -> {
            UserFansVO fansVO = new UserFansVO();
            fansVO.setUserId(it.getUserId());
            fansVO.setGmtCreate(DateUtils.formatNewFormat(it.getGmtCreate()));
            fansVO.setAvatarUrl(it.getAvatarUrl());
            fansVO.setNickName(it.getNickname());
            return fansVO;
        }).collect(Collectors.toList());
    }

    private UserOrderVO apply(OrderFansDetailDTO item) {
        UserOrderVO vo = new UserOrderVO();
        String fansType = item.getFansType();
        OrderFansTypeEnum statusEnum = EnumUtil.queryByCode(fansType, OrderFansTypeEnum.class);
        if (statusEnum != null) {
            if (item.getLevel() != null) {
                vo.setTag(
                    String.format(statusEnum.getOrderDesc(), item.getLevel() == 1 ? "一" : "二"));
            }
        }

        vo.setOrderSn(item.getOrderSn());
        vo.setLevel(item.getLevel());
        vo.setOrderCreateTime(DateUtils.formatWebFormat(item.getOrderCreateTime()));
        Money money = new Money();
        money.setCent(item.getFansAmount() == null ? 0 : item.getFansAmount());
        vo.setRebateAmount(money.getAmount().toString());

        String string = DateUtils.formatWebFormat(item.getGmtModified());
        if (StringUtil.equals(item.getOrderStatus(), "4")
            || StringUtil.equals(item.getOrderStatus(), "8")
            || StringUtil.equals(item.getOrderStatus(), "10")) {
            vo.setOrderDesc("失效:" + string);
        } else if (StringUtil.equals(item.getOrderStatus(), "3")
                   || StringUtil.equals(item.getOrderStatus(), "5")) {
            vo.setOrderDesc(string + "已补贴");
        } else {
            vo.setOrderDesc(string);
        }
        OrderQueryInfoRequest infoRequest = new OrderQueryInfoRequest();
        infoRequest.setUserId(item.getUserId());
        infoRequest.setOrderSn(item.getOrderSn());
        TSingleResult<OrderInfoDTO> result = orderInfoServiceClient.queryByOrderSn(infoRequest);
        OrderInfoDTO value = result.getValue();
        if (value != null) {
            vo.setGoodsThumbnailUrl(value.getGoodsThumbnailUrl());
            vo.setGoodsName(value.getGoodsName());
        }
        return vo;
    }
}