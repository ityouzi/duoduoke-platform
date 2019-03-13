package com.fulihui.redisdubbo.demo.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author lizhi
 * @date 2018-7-5
 */
@RestController
public class IndexController {

    @GetMapping("/index")
    @ApiOperation("首页")
    String index() {

        return "index";
    }
}
