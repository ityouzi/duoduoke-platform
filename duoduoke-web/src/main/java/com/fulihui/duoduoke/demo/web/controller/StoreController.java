package com.fulihui.duoduoke.demo.web.controller;

import com.fulihui.duoduoke.demo.api.api.StoreService;
import com.fulihui.duoduoke.demo.api.dto.StoreDTO;
import com.fulihui.duoduoke.demo.web.vo.StoreVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.Reference;
import org.near.webmvcsupport.view.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static org.near.webmvcsupport.view.JsonResultBuilder.succ;

@RestController
@RequestMapping("/store")
@Api(description = "专场")
public class StoreController {

    private static final Logger LOGGER = LoggerFactory.getLogger(StoreController.class);
    @Reference
    StoreService storeService;

    @PostMapping("/list")
    @ApiOperation("获得有效的专场")
    public JsonResult list() {
        List<StoreDTO> list = storeService.getGoingStoreList();
        List<StoreVo> array = list.stream().map(item -> {
            StoreVo storeVo = new StoreVo();
            storeVo.setId(item.getId());
            storeVo.setPreferenceNumber(item.getPreferenceNumber());
            storeVo.setStoreUrl(item.getPreferenceUrl());
            return storeVo;
        }).collect(Collectors.toList());
        return succ(array);
    }


}
