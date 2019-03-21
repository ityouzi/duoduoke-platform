package com.fulihui.duoduoke.demo.web.controller;

import com.fulihui.duoduoke.demo.web.manager.GoodsPromotionManager;
import com.fulihui.duoduoke.demo.web.param.GoodsPromotionGenerateParam;
import com.fulihui.duoduoke.demo.web.util.Principal;
import com.fulihui.duoduoke.demo.web.util.PrincipalUtil;
import com.fulihui.duoduoke.demo.web.vo.GoodsPromotionUrlVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
 * @author lizhi
 * @date 2018-7-5
 */
@RestController
@RequestMapping("/goodPromotion")
@Api(description = "生成多多进宝商品推广链接")
public class GoodsPromotionController {

    private static final Logger LOGGER = LoggerFactory.getLogger(GoodsPromotionController.class);

    @Autowired
    GoodsPromotionManager goodsPromotionManager;


    @PostMapping("/promotion")
    @ApiOperation("生成多多进宝商品推广链接")
    JsonResult<GoodsPromotionUrlVO> promotion(@RequestBody GoodsPromotionGenerateParam param) {
        Principal principal = PrincipalUtil.getPrincipal();
        String pId = "1808329_56644863";
        LOGGER.info("GoodsPromotionController.param:{},pId:{}", param, pId);
        GoodsPromotionUrlVO vo = goodsPromotionManager.goodsGenerate(principal.getUserId(),
                param.getGoodsId(), pId, param.getShareId(), Boolean.TRUE);
        LOGGER.info("GoodsPromotionController.promotion:{}", vo);
        return JsonResultBuilder.succ(vo);
    }


}
