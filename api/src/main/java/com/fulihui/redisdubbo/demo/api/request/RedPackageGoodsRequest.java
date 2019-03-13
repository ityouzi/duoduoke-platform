package com.fulihui.redisdubbo.demo.api.request;

import lombok.Data;
import org.near.servicesupport.request.PageRequest;

/**
 * @author: JY
 * @date: 2018/9/4 15:17
 */
@Data
public class RedPackageGoodsRequest extends PageRequest {

    /**
     * 红包专场id
     */
    private Integer rpfId;

    /**
     * 普通专场 或 助力专场
     */
    private Integer rpfType;

    private String goodsName;

    private Integer goodsId;

    private Integer state;

    private String orderByClause;

}
