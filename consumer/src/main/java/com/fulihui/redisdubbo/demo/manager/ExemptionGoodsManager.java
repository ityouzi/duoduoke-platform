package com.fulihui.redisdubbo.demo.manager;


import com.fulihui.redisdubbo.demo.param.ExemptionGoodInfoParam;
import org.near.webmvcsupport.view.JsonResult;

/**
 * @Description:
 * @Author: xiaoming
 * @version: v 0.1 2018/11/14 0014 16:26
 */
public interface ExemptionGoodsManager {

    JsonResult robbingOrder(ExemptionGoodInfoParam param);

}
