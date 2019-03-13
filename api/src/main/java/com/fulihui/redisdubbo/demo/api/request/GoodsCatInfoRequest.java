package com.fulihui.redisdubbo.demo.api.request;

import lombok.Getter;
import lombok.Setter;
import org.near.servicesupport.request.PageRequest;

import java.util.Date;
import java.util.List;

/**
 * @author lizhi
 * @date 2018-7-7
 */
@Setter
@Getter
public class GoodsCatInfoRequest extends PageRequest {
    private static final long serialVersionUID = -2350585820288137138L;
    /**
     * goods_cat_info.id
     */
    private Integer id;

    /**
     * goods_cat_info.level
     * 层级
     */
    private String level;
    /**
     * 层级 集合
     */
    private List levelList;

    /**
     * goods_cat_info.cat_id
     * 商品标签ID
     */
    private Integer catId;

    /**
     * goods_cat_info.parent_cat_id
     * id所属父ID，其中，parent_id=0时为顶级节点
     */
    private Integer parentCatId;

    /**
     * goods_cat_info.cat_name
     * 商品标签名
     */
    private String catName;

    /**
     * goods_cat_info.gmt_create
     * 创建时间
     */
    private Date gmtCreate;

    /**
     * goods_cat_info.gmt_modified
     * 修改时间
     */
    private Date gmtModified;

    /**
     * goods_cat_info.img
     * 分类图
     */
    private String img;

    /**
     * goods_cat_info.icon
     * 首页分类图标
     */
    private String icon;

    /**
     * goods_cat_info.sort_index
     * 分类排序值
     */
    private Integer sortIndex;

    /**
     * goods_cat_info.status
     * 是否显示
     */
    private String status;

    private String orderByClause;
}
