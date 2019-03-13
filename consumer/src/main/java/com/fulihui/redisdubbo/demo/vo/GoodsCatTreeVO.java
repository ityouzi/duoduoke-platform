package com.fulihui.redisdubbo.demo.vo;


import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.near.toolkit.model.ToString;

import java.util.List;

/**
 * @author lizhi
 */
@Setter @Getter
public class GoodsCatTreeVO extends ToString {
    private static final long serialVersionUID = 5707924397145617587L;
    /**
     * goods_cat_info.cat_id
     * 商品标签ID
     */
    @ApiModelProperty(value = "商品标签ID")

    private Integer catId;
    /**
     * goods_cat_info.parent_cat_id
     * id所属父ID，其中，parent_id=0时为顶级节点
     */
    @ApiModelProperty(value = " id所属父ID，其中，parent_id=0时为顶级节点")

    private Integer parentCatId;

    /**
     * goods_cat_info.cat_name
     * 商品标签名
     */
    @ApiModelProperty(value = "商品标签名")

    private String catName;

    /**
     * goods_cat_info.level
     * 层级
     */
    @ApiModelProperty(value = "层级")

    private String level;

    /**
     * goods_cat_info.img
     * 分类图
     */
    @ApiModelProperty(value = "分类图")

    private String img;

    /**
     * goods_cat_info.icon
     * 首页分类图标
     */
    @ApiModelProperty(value = "首页分类图标")

    private String icon;
    /**
     * 子级
     */
    @ApiModelProperty(value = "子级")
    private List<GoodsCatTreeVO> children;


}
