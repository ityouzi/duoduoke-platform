package com.fulihui.duoduoke.demo.api.response;

import lombok.Getter;
import lombok.Setter;
import org.near.toolkit.model.ToString;

import java.util.List;

/**
 * @author lizhi
 * @date 2018-7-9
 */
@Setter
@Getter
public class GoodsSearchResponse extends ToString {

    /**
     * 成功入库个数
     */
    private Integer success;

    /**
     * 重复商品个数
     */
    private Integer repeat;

    /**
     * 异常商品数据个数
     */
    private Integer exception;

    /**
     * 成功商品
     */
    private List<String> goodsId;


}
