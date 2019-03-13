package com.fulihui.duoduoke.demo.web.controller;


import com.fulihui.duoduoke.demo.api.api.HomeColumnService;
import com.fulihui.duoduoke.demo.api.dto.HomeColumnDTO;
import com.fulihui.duoduoke.demo.api.request.HomeColumnRequest;
import com.fulihui.duoduoke.demo.web.param.GoodChannelParam;
import com.fulihui.duoduoke.demo.web.vo.HomeColumnVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import org.near.servicesupport.result.TMultiResult;
import org.near.servicesupport.result.TSingleResult;
import org.near.webmvcsupport.view.JsonResult;
import org.near.webmvcsupport.view.JsonResultBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static org.near.servicesupport.util.ServiceResultUtil.checkResult;

/**
 * @Description:
 * @Author: xiaoming
 * @version: v 0.1 2018/8/2 0002 15:03
 */
@RestController
@RequestMapping("/homeColumn")
@Api(description = "首页栏目信息")
public class HomeColumnController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HomeColumnController.class);

    @org.apache.dubbo.config.annotation.Reference
    HomeColumnService homeColumnService;

    private List<HomeColumnVO> list;

    private ScheduledExecutorService executorService;

    @PostMapping("columnList")
    @ApiOperation("栏目列表")
    public JsonResult<List<HomeColumnVO>> columnList() {
        return JsonResultBuilder.succ(getList());
    }

    @PostConstruct
    void init() {
        executorService = new ScheduledThreadPoolExecutor(1, new BasicThreadFactory.Builder()
                .namingPattern("HomeColumnController-schedule-pool-%d").daemon(true).build());
        executorService.scheduleAtFixedRate(() -> {
            try {
                HomeColumnRequest request = new HomeColumnRequest();
                TMultiResult<HomeColumnDTO> result = homeColumnService.queryPage(request);
                System.out.println(result);
                checkResult(result);
                list = result.getValues().stream().map(item -> {
                    HomeColumnVO vo = new HomeColumnVO();
                    BeanUtils.copyProperties(item, vo);
                    return vo;
                }).collect(Collectors.toList());
            } catch (Exception e) {
                LOGGER.error(e.getMessage(), e);
            }
        }, 0, 10, TimeUnit.MINUTES);
    }

    @PreDestroy
    void destroy() {
        if (null != executorService) {
            executorService.shutdown();
        }
    }

    /**
     * Setter method for property <tt>list</tt>.
     *
     * @param list value to be assigned to property list
     */
    public void setList(List<HomeColumnVO> list) {
        this.list = list;
    }

    /**
     * Getter method for property <tt>list</tt>
     *
     * @return property value of list
     */
    public List<HomeColumnVO> getList() {
        return list;
    }

    @PostMapping("columnImg")
    @ApiOperation("栏目banner图片")
    public JsonResult<String> columnList(@RequestBody GoodChannelParam param) {
        if (param.getColumnId() == null) {
            return JsonResultBuilder.fail("101", "参数错误");
        }
        HomeColumnRequest request = new HomeColumnRequest();
        request.setId(param.getColumnId());
        TSingleResult<HomeColumnDTO> result = homeColumnService.querySingle(request);
        checkResult(result);
        HomeColumnDTO column = result.getValue();
        return JsonResultBuilder.succ(column.getBannerImg());

    }

}
