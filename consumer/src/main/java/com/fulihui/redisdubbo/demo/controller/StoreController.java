package com.fulihui.redisdubbo.demo.controller;

import com.fulihui.redisdubbo.demo.api.request.GetGoingStoreGoodsRequest;
import com.fulihui.redisdubbo.demo.manager.StoreManager;
import com.fulihui.redisdubbo.demo.vo.StoreInfoVo;
import com.fulihui.redisdubbo.demo.vo.StoreVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.near.webmvcsupport.view.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

import static org.near.webmvcsupport.view.JsonResultBuilder.succ;

@RestController
@RequestMapping("/store")
@Api(description = "专场")
public class StoreController {

    private static final Logger LOGGER = LoggerFactory.getLogger(StoreController.class);

    @Autowired
    StoreManager storeManager;

    //1.获得有效的专场
    @PostMapping("/list")
    @ApiOperation("获得有效的专场")
    public JsonResult list() {
        List<StoreVo> list = storeManager.getList();
        return succ(list);
    }

    //2.获得专场详情 包括商品
    @PostMapping("/get")
    @ApiOperation("获得专场详情")
    public JsonResult get(@RequestBody GetGoingStoreGoodsRequest getGoingStoreGoodsRequest) {
        StoreInfoVo storeInfoVo = storeManager.getInfo(getGoingStoreGoodsRequest);
        Date endTime = storeInfoVo.getEndTime();
        try {
            if (System.currentTimeMillis() > endTime.getTime()) {
                storeInfoVo.setStatus("2");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return succ(storeInfoVo);
    }

}
