package com.fulihui.duoduoke.demo.web.param;


import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by IntelliJ IDEA.
 * User:   lizhi
 * Date: 2018-5-30
 * Time: 17:59
 *
 * @author lizhi
 */
@Setter
@Getter
public class GoodSearchParam extends FormIdParam {
    private static final long serialVersionUID = 6207131546454549415L;
    /**
     * code
     */
    @ApiModelProperty("搜索关键字")
    private String keyword;


    @ApiModelProperty("排序方式:0-综合排序；销量：5-按销量升序；价格：9-券后价升序排序;价格：9-券后价升序排序；券金额：7-优惠券金额排序升序;券金额：7-优惠券金额排序升序;")
    private String sortType;


    @ApiModelProperty("订单最低额")
    private String rangeFrom;
}