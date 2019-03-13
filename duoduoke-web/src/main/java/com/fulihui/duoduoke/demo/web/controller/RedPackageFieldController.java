package com.fulihui.duoduoke.demo.web.controller;


import com.fulihui.duoduoke.demo.api.dto.DuoduoGoodsInfoDTO;
import com.fulihui.duoduoke.demo.api.dto.RedPackageFieldDTO;
import com.fulihui.duoduoke.demo.api.dto.RedPackageGoodsDTO;
import com.fulihui.duoduoke.demo.api.dto.UserRedPackageRecordDTO;
import com.fulihui.duoduoke.demo.api.request.RedPackageFieldRequest;
import com.fulihui.duoduoke.demo.api.request.RedPackageGoodsRequest;
import com.fulihui.duoduoke.demo.api.request.UserRedPackageRecordRequest;
import com.fulihui.duoduoke.demo.web.integration.RedPackageFieldServiceClient;
import com.fulihui.duoduoke.demo.web.integration.RedPackageGoodsServiceClient;
import com.fulihui.duoduoke.demo.web.manager.GoodsInfoManager;
import com.fulihui.duoduoke.demo.web.param.RedPackageFieldParam;
import com.fulihui.duoduoke.demo.web.param.RedPackageGoodsParam;
import com.fulihui.duoduoke.demo.web.util.Principal;
import com.fulihui.duoduoke.demo.web.util.PrincipalUtil;
import com.fulihui.duoduoke.demo.web.vo.GoodsInfo;
import com.fulihui.duoduoke.demo.web.vo.RedPackageFieldVO;
import com.fulihui.duoduoke.demo.common.except.BizException;
import com.fulihui.duoduoke.demo.common.except.CommonErrors;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.near.servicesupport.result.TMultiResult;
import org.near.servicesupport.result.TPageResult;
import org.near.toolkit.common.DateUtils;
import org.near.toolkit.common.StringUtil;
import org.near.webmvcsupport.view.JsonResult;
import org.near.webmvcsupport.view.JsonResultBuilder;
import org.near.webmvcsupport.view.PageView;
import org.near.webmvcsupport.view.PageViewBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static org.near.servicesupport.util.ServiceResultUtil.checkResult;
import static org.springframework.util.CollectionUtils.isEmpty;

/**
 * @author lizhi
 * @date 2018-9-7
 */
@RestController
@RequestMapping("/redPackage")
@Api(description = "红包专场")
public class RedPackageFieldController {
    private static final Logger LOGGER = LoggerFactory.getLogger(RedPackageFieldController.class);

    @Autowired
    RedPackageFieldServiceClient redPackageFieldServiceClient;
    @Autowired
    RedPackageGoodsServiceClient redPackageGoodsServiceClient;

    @Autowired
    GoodsInfoManager goodsInfoManager;

    @PostMapping("share")
    @ApiOperation("分享")
    public JsonResult share(@RequestBody RedPackageGoodsParam param) {

        if (StringUtil.isBlank(param.getFieldId())) {
            LOGGER.error("红包专场,请求接口 商品信息参数,请求参数为空");
            throw new BizException(CommonErrors.ILLIGEAL_REQUEST_ERROR);
        }
        List<RedPackageFieldDTO> values = list(param.getFieldId());
        if (CollectionUtils.isEmpty(values)) {
            return JsonResultBuilder.succ(false);
        }
        RedPackageFieldDTO fieldDTO = values.get(0);
        Date now = new Date();
        UserRedPackageRecordDTO dto = new UserRedPackageRecordDTO();
        dto.setHelp("2");
        dto.setEndTime(DateUtils.addHours(now, fieldDTO.getValidTime()));
        dto.setId(Integer.valueOf(param.getRecordId()));
        dto.setFieldId(Integer.valueOf(param.getFieldId()));
        dto.setUserId(PrincipalUtil.getPrincipal().getUserId());
        Boolean update = redPackageFieldServiceClient.update(dto);
        return JsonResultBuilder.succ(update);
    }

    @PostMapping("queryRedProduct")
    @Cacheable(value = "queryRedProduct", keyGenerator = "cacheKeyGenerator")
    @ApiOperation("查询红包专场商品")
    public JsonResult<PageView<GoodsInfo>> queryRedProduct(@RequestBody RedPackageGoodsParam param) {

        if (StringUtil.isBlank(param.getFieldId()) || StringUtil.isBlank(param.getRpfType())) {
            LOGGER.error("红包专场,请求接口 商品信息参数,请求参数为空");
            throw new BizException(CommonErrors.ILLIGEAL_REQUEST_ERROR);
        }

        RedPackageGoodsRequest request = new RedPackageGoodsRequest();
        //红包专场id
        request.setRpfId(Integer.valueOf(param.getFieldId()));
        //红包专场类型
        request.setRpfType(Integer.valueOf(param.getRpfType()));
        request.setPage(param.getPage());
        request.setRows(param.getRows());
        TPageResult<RedPackageGoodsDTO> result = redPackageGoodsServiceClient.listInAPI(request);
        List<RedPackageGoodsDTO> values = result.getValues();

        List<DuoduoGoodsInfoDTO> list = values.stream().map(input -> {
            DuoduoGoodsInfoDTO infoDTO = new DuoduoGoodsInfoDTO();
            BeanUtils.copyProperties(input, infoDTO);
            return infoDTO;
        }).collect(Collectors.toList());

        List<GoodsInfo> voList = goodsInfoManager.toVOList(list);

        PageView<GoodsInfo> build = PageViewBuilder.build(voList, result.getPage(),
                result.getRows(), result.getTotalRows());

        return JsonResultBuilder.succ(build);
    }

    @PostMapping("queryRed")
    @ApiOperation("查询红包专场")
    public JsonResult<RedPackageFieldVO> queryRed(@RequestBody RedPackageFieldParam param) {
        if (StringUtil.isBlank(param.getFieldId())) {
            LOGGER.error("红包专场,请求接口 商品信息参数,请求参数为空");
            throw new BizException(CommonErrors.ILLIGEAL_REQUEST_ERROR);
        }
        RedPackageFieldVO vo = new RedPackageFieldVO();

        List<RedPackageFieldDTO> values = list(param.getFieldId());
        if (isEmpty(values)) {
            LOGGER.info("红包专场已关闭,id:{}", param.getFieldId());
            vo.setClose(Boolean.TRUE);
            return JsonResultBuilder.succ(vo);
        }

        RedPackageFieldDTO fieldDTO = values.get(0);
        BeanUtils.copyProperties(fieldDTO, vo);
        vo.setClose(Boolean.FALSE);

        Principal principal = PrincipalUtil.getPrincipal();

        UserRedPackageRecordRequest recordRequest = new UserRedPackageRecordRequest();
        recordRequest.setPage(1);
        recordRequest.setRows(1);
        recordRequest.setSortInfo(" gmt_create desc");
        recordRequest.setUserId(principal.getUserId());
        recordRequest.setFieldId(fieldDTO.getId());
        TMultiResult<UserRedPackageRecordDTO> record = redPackageFieldServiceClient
                .queryRecord(recordRequest);

        UserRedPackageRecordDTO dto = new UserRedPackageRecordDTO();
        dto.setUserId(principal.getUserId());
        dto.setFieldId(fieldDTO.getId());
        Date now = new Date();

        if (isEmpty(record.getValues())) {
            dto.setEndTime(DateUtils.addHours(now, fieldDTO.getValidTime()));
            dto.setHelp("1");
            Long aLong = redPackageFieldServiceClient.insertUserRedPackage(dto);
            vo.setRecordId(String.valueOf(aLong));
            vo.setNowTime(now);
            vo.setShow(Boolean.TRUE);
            vo.setHelp(dto.getHelp());
            vo.setEndTime(dto.getEndTime());
            return JsonResultBuilder.succ(vo);
        }

        UserRedPackageRecordDTO recordDTO = record.getValues().get(0);
        Date endTime = recordDTO.getEndTime();
        if (now.after(endTime)) {
            dto.setHelp("1");
            dto.setEndTime(DateUtils.addHours(now, fieldDTO.getValidTime()));
            Long aLong = redPackageFieldServiceClient.insertUserRedPackage(dto);
            vo.setNowTime(now);
            vo.setHelp(dto.getHelp());
            vo.setEndTime(dto.getEndTime());
            vo.setShow(Boolean.TRUE);
            vo.setRecordId(String.valueOf(aLong));
        } else {
            vo.setNowTime(now);
            vo.setHelp(recordDTO.getHelp());
            vo.setEndTime(recordDTO.getEndTime());
            vo.setShow(Boolean.FALSE);
            vo.setRecordId(String.valueOf(recordDTO.getId()));
        }
        return JsonResultBuilder.succ(vo);
    }

    private List<RedPackageFieldDTO> list(String fieldId) {
        RedPackageFieldRequest request = new RedPackageFieldRequest();
        request.setId(Integer.valueOf(fieldId));
        request.setState((short) 1);
        request.setPage(1);
        request.setRows(1);
        TPageResult<RedPackageFieldDTO> result = redPackageFieldServiceClient.list(request);
        checkResult(result);
        return result.getValues();
    }


}
