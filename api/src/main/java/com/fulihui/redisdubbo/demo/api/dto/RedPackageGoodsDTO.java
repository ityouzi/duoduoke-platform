package com.fulihui.redisdubbo.demo.api.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author: JY
 * @date: 2018/9/3 15:31
 */
@Data
public class RedPackageGoodsDTO extends DuoduoGoodsInfoDTO {

    /**
     * 主键
     */
    private Integer id;

    /**
     * 红包专场id
     */
    private Integer rpfId;

    /**
     * 商品id
     */
    private Long goodsId;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 1:基础红包专场商品  2:助力红包专场商品
     */
    private Integer rpfType;

    /**
     * 创建时间
     */
    private Date gmtCreate;

}
