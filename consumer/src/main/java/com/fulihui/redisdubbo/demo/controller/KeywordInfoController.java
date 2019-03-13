package com.fulihui.redisdubbo.demo.controller;


import com.fulihui.redisdubbo.demo.api.api.KeywordInfoService;
import com.fulihui.redisdubbo.demo.api.dto.GoodsKeywordInfoDTO;
import com.fulihui.redisdubbo.demo.api.request.GoodsKeywordInfoRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import org.near.servicesupport.result.TPageResult;
import org.near.webmvcsupport.view.JsonResult;
import org.near.webmvcsupport.view.JsonResultBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static org.near.servicesupport.util.ServiceResultUtil.checkResult;
import static org.springframework.util.CollectionUtils.isEmpty;

/**
 * @author lizhi
 * @date 2018-7-7
 */
@RestController
@RequestMapping("/keyWordInfo")
@Api(description = "热搜词信息")
public class KeywordInfoController {

    private static final Logger      LOGGER = LoggerFactory.getLogger(KeywordInfoController.class);

    @org.apache.dubbo.config.annotation.Reference
    KeywordInfoService keywordInfoService;

    private List<String>             keywords;

    private ScheduledExecutorService executorService;

    @PreDestroy
    void destroy() {
        if (null != executorService) {
            executorService.shutdown();
        }
    }

    @PostMapping("keyWordListInfo")
    @ApiOperation("热搜词列表")
    public JsonResult<List<String>> keyWordInfo() {

        return JsonResultBuilder.succ(getKeywords());
    }

    @PostConstruct
    void init() {
        executorService = new ScheduledThreadPoolExecutor(1, new BasicThreadFactory.Builder()
            .namingPattern("KeywordInfoController-schedule-pool-%d").daemon(true).build());
        executorService.scheduleAtFixedRate(() -> {
            try {
                GoodsKeywordInfoRequest request = new GoodsKeywordInfoRequest();
                TPageResult<GoodsKeywordInfoDTO> result = keywordInfoService.queryInfo(request);
                checkResult(result);
                keywords = convert(result.getValues());
            } catch (Exception e) {
                LOGGER.error(e.getMessage(), e);
            }
        }, 0, 60, TimeUnit.SECONDS);
    }

    private List<String> getKeywords() {
        return keywords;
    }

    private List<String> convert(List<GoodsKeywordInfoDTO> list) {
        if (isEmpty(list)) {
            return Collections.emptyList();
        }
        return list.stream().map(GoodsKeywordInfoDTO::getKeyword).collect(Collectors.toList());
    }

}
