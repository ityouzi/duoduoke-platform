package com.fulihui.duoduoke.demo.web.controller;


import com.fulihui.duoduoke.demo.api.api.GoodsInfoService;
import com.fulihui.duoduoke.demo.api.api.HomeColumnService;
import com.fulihui.duoduoke.demo.api.api.UserPosterImgService;
import com.fulihui.duoduoke.demo.api.api.UserShareRecodeService;
import com.fulihui.duoduoke.demo.api.dto.GoodsInfoDTO;
import com.fulihui.duoduoke.demo.api.dto.HomeColumnDTO;
import com.fulihui.duoduoke.demo.api.dto.UserShareRecordDTO;
import com.fulihui.duoduoke.demo.api.enums.GoodsChooseEnum;
import com.fulihui.duoduoke.demo.api.enums.GoodsStateEnum;
import com.fulihui.duoduoke.demo.api.request.*;
import com.fulihui.duoduoke.demo.web.factory.AppConfigFactory;
import com.fulihui.duoduoke.demo.web.manager.GoodsInfoManager;
import com.fulihui.duoduoke.demo.web.param.GoodChannelParam;
import com.fulihui.duoduoke.demo.web.param.GoodInfoParam;
import com.fulihui.duoduoke.demo.web.param.GoodShareParam;
import com.fulihui.duoduoke.demo.web.util.Principal;
import com.fulihui.duoduoke.demo.web.util.PrincipalUtil;
import com.fulihui.duoduoke.demo.web.vo.GoodsInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.near.servicesupport.result.TPageResult;
import org.near.servicesupport.result.TSingleResult;
import org.near.servicesupport.util.ServiceResultUtil;
import org.near.toolkit.common.StringUtil;
import org.near.webmvcsupport.view.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.net.URL;
import java.util.List;

import static org.near.servicesupport.util.ServiceResultUtil.checkResult;

/**
 * Created by lizhi on 2018-7-7.
 */
@RestController
@RequestMapping("/goodsInfo")
@Api(description = "小程序商品信息")
public class GoodsInfoController {

    private static final Logger LOGGER = LoggerFactory.getLogger(GoodsInfoController.class);

    @Autowired
    GoodsInfoManager goodsInfoManager;

    /**
     * The Goods info service.
     */
    @org.apache.dubbo.config.annotation.Reference
    GoodsInfoService goodsInfoService;

    /**
     * The Commission config factory.
     */
    @Autowired
    AppConfigFactory appConfigFactory;

    @org.apache.dubbo.config.annotation.Reference
    HomeColumnService homeColumnService;

    @org.apache.dubbo.config.annotation.Reference
    UserPosterImgService userPosterImgService;

    @org.apache.dubbo.config.annotation.Reference
    UserShareRecodeService userShareRecodeService;

    /**
     * zpf 增加缓存 2018-8-27
     */
    @PostMapping("goodsListInfo")
    @ApiOperation("首页商品列表")
    public JsonResult<PageView<GoodsInfo>> goodsListInfo(@RequestBody GoodInfoParam param) {
        LOGGER.info("进入controller查询数据 首页商品列表");
        GoodsInfoRequest infoRequest = new GoodsInfoRequest();
        String isChoose = param.getIsChoose();
        BeanUtils.copyProperties(param, infoRequest);
        infoRequest.setOrderByClause("sort DESC,gmt_modified DESC");
        //优选
        if (StringUtil.isNotBlank(isChoose) && StringUtil.equals(isChoose, GoodsChooseEnum.IS.getCode())) {
            infoRequest.setOrderByClause("choose_sort DESC,sort DESC,gmt_modified DESC");
        } else {
            infoRequest.setIsChoose(GoodsChooseEnum.NO.getCode());
        }

        infoRequest.setPage(param.getPage());
        infoRequest.setRows(param.getRows());
        infoRequest.setState(GoodsStateEnum.ON.getCode());
        TPageResult<GoodsInfoDTO> result = goodsInfoService.queryGoodsListInfo(infoRequest);
        checkResult(result);

        List<GoodsInfo> voList = goodsInfoManager.toVOList(result.getValues());
        PageView<GoodsInfo> build = PageViewBuilder.build(voList, result.getPage(),
                result.getRows(), result.getTotalRows());

        return JsonResultBuilder.succ(build);
    }

    @PostMapping("goodsChooseListInfo")
    @ApiOperation("优选商品列表")
    public JsonResult<PageView<GoodsInfo>> goodsChooseListInfo(@RequestBody PageForm param) {
        GoodsInfoRequest infoRequest = new GoodsInfoRequest();
        infoRequest.setIsChoose(GoodsChooseEnum.IS.getCode());
        infoRequest.setOrderByClause("choose_sort DESC,sort DESC,gmt_modified DESC");

        infoRequest.setPage(param.getPage());
        infoRequest.setRows(param.getRows());
        infoRequest.setState(GoodsStateEnum.ON.getCode());
        TPageResult<GoodsInfoDTO> result = goodsInfoService.queryGoodsListInfo(infoRequest);
        checkResult(result);

        List<GoodsInfo> voList = goodsInfoManager.toVOList(result.getValues());
        PageView<GoodsInfo> build = PageViewBuilder.build(voList, result.getPage(),
                result.getRows(), result.getTotalRows());

        return JsonResultBuilder.succ(build);
    }


    @PostMapping("goodsChannelTypeList")
    @ApiOperation("栏目商品列表")
    public JsonResult<PageView<GoodsInfo>> goodsChannelTypeList(@RequestBody GoodChannelParam param) {
        LOGGER.info("进入controller查询数据 栏目商品列表");
        if (param.getColumnId() == null) {
            return JsonResultBuilder.fail("101", "参数错误");
        }
        HomeColumnRequest request = new HomeColumnRequest();
        request.setId(param.getColumnId());
        TSingleResult<HomeColumnDTO> columnResult = homeColumnService.querySingle(request);
        checkResult(columnResult);
        HomeColumnDTO column = columnResult.getValue();
        GoodsInfoRecommendRequest infoRequest = new GoodsInfoRecommendRequest();
        infoRequest.setChannelType(column.getChannelType());
        infoRequest.setPage(param.getPage());
        infoRequest.setRows(param.getRows());
        TPageResult<GoodsInfoDTO> result = goodsInfoService.queryChannelGoods(infoRequest);
        checkResult(result);

        List<GoodsInfoDTO> list = result.getValues();

        List<GoodsInfo> voList = goodsInfoManager.toVOList(list);

        PageView build = PageViewBuilder.build(voList, result.getPage(), result.getRows(),
                result.getTotalRows());

        return JsonResultBuilder.succ(build);
    }

    @PostMapping("hotPushGoodsList")
    @ApiOperation("热推爆品商品列表")
    public JsonResult<PageView<GoodsInfo>> hotPushGoods(@RequestBody PageForm pageForm) {
        PageView<GoodsInfo> goodsInfoVOS = goodsInfoManager.hotPushGoods(pageForm);
        return JsonResultBuilder.succ(goodsInfoVOS);
    }

    /**
     * Goods detail json result.
     *
     * @param param the param
     * @return the json result
     * <p>
     * zpf 增加缓存 2018-8-27
     */
    @PostMapping("goodsDetail")
    @ApiOperation("商品详情")
    public JsonResult<GoodsInfo> goodsDetail(HttpServletRequest servletRequest,
                                             @RequestBody GoodInfoParam param) {
        LOGGER.info("进入controller查询数据 商品详情");
        return v1(param);
    }

    private JsonResult<GoodsInfo> v1(@RequestBody GoodInfoParam param) {
        String scene = param.getScene();
        GoodsInfoRequest infoRequest = new GoodsInfoRequest();
        GoodsInfo goodsIfs = new GoodsInfo();
        if (StringUtil.isNotEmpty(scene)) {
            int id = Integer.parseInt(scene);
            UserShareRecordRequest recordRequest = new UserShareRecordRequest();
            recordRequest.setId(id);
            TSingleResult<UserShareRecordDTO> result = userShareRecodeService
                    .queryById(recordRequest);
            ServiceResultUtil.checkResult(result);
            UserShareRecordDTO dto = result.getValue();
            if (dto != null) {
                String goodsId = dto.getGoodId();
                String userId = dto.getUserId();
                if (StringUtil.isNotEmpty(goodsId)) {
                    infoRequest.setGoodsId(Long.parseLong(goodsId));
                    goodsIfs.setShareUserId(userId);
                    goodsIfs.setPid(dto.getPid());
                }
            }
        } else {
            if (param.getGoodsId() == null) {
                return JsonResultBuilder.fail("102", "商品参数错误");
            }
            BeanUtils.copyProperties(param, infoRequest);
        }
        infoRequest.setState(GoodsStateEnum.ON.getCode());
        TSingleResult<GoodsInfoDTO> result = goodsInfoService.queryGoodsDetailNO(infoRequest);
        checkResult(result);
        GoodsInfoDTO dto = result.getValue();
        //佣金
        if (dto != null) {
            Integer commission = appConfigFactory.getCommission().intValue();
            Integer shareProportion = appConfigFactory.getShareProportion().intValue();
            BigDecimal yuanBig = new BigDecimal(100);
            GoodsInfo goodsInfo = goodsInfoManager.toVO(dto, yuanBig, commission, shareProportion);
            goodsInfo.setShareUserId(goodsIfs.getShareUserId());
            goodsInfo.setPid(goodsIfs.getPid());
            return JsonResultBuilder.succ(goodsInfo);
        } else {
            return JsonResultBuilder.fail("101", "商品已下架");
        }
    }

    @PostMapping("goodsShareImg")
    @ApiOperation("商品分享图片")
    public JsonResult<String> goodsDetail(HttpServletRequest servletRequest,
                                          @RequestBody GoodShareParam param) {
        UserQrcodeImgRequest request = new UserQrcodeImgRequest();
        if (param != null) {
            Long goodsId = param.getGoodsId();
            request.setGoodsId(goodsId + "");
        }
        request.setSharePid("240009_18781174");
        Principal principal = PrincipalUtil.getPrincipal();
        request.setUid(principal.getUserId());

        TSingleResult<String> result = userPosterImgService.goodsQrcodeImg(request);
        ServiceResultUtil.checkResult(result);
        return JsonResultBuilder.succ(result.getValue());
    }

    @GetMapping("imgConvert")
    @ApiOperation("图片转化")
    public void goodsDetail(String img, HttpServletResponse servletResponse) {
        try {
            servletResponse.setContentType("image/jpg");
            URL urlInfo = new URL(img);
            InputStream inputStream = urlInfo.openConnection().getInputStream();

            ServletOutputStream writer = servletResponse.getOutputStream();

            ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
            //buff用于存放循环读取的临时数据
            byte[] buff = new byte[1024];
            int rc = 0;
            while ((rc = inputStream.read(buff, 0, 1024)) > 0) {
                swapStream.write(buff, 0, rc);
            }
            byte[] in_b = swapStream.toByteArray();

            writer.write(in_b);
            writer.flush();
        } catch (Exception e) {
            LOGGER.error("101", "转换错误");
        }
    }

}
