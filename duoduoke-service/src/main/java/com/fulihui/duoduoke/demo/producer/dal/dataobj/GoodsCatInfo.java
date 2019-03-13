package com.fulihui.duoduoke.demo.producer.dal.dataobj;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
public class GoodsCatInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * goods_cat_info.id
     *
     * @mbg.generated 2018-07-10 14:47:36
     */
    private Integer id;
    /**
     * goods_cat_info.level
     * 层级
     *
     * @mbg.generated 2018-07-10 14:47:36
     */
    private String level;
    /**
     * goods_cat_info.cat_id
     * 商品标签ID
     *
     * @mbg.generated 2018-07-10 14:47:36
     */
    private Integer catId;
    /**
     * goods_cat_info.parent_cat_id
     * id所属父ID，其中，parent_id=0时为顶级节点
     *
     * @mbg.generated 2018-07-10 14:47:36
     */
    private Integer parentCatId;
    /**
     * goods_cat_info.cat_name
     * 商品标签名
     *
     * @mbg.generated 2018-07-10 14:47:36
     */
    private String catName;
    /**
     * goods_cat_info.gmt_create
     * 创建时间
     *
     * @mbg.generated 2018-07-10 14:47:36
     */
    private Date gmtCreate;
    /**
     * goods_cat_info.gmt_modified
     * 修改时间
     *
     * @mbg.generated 2018-07-10 14:47:36
     */
    private Date gmtModified;
    /**
     * goods_cat_info.img
     * 分类图
     *
     * @mbg.generated 2018-07-10 14:47:36
     */
    private String img;
    /**
     * goods_cat_info.icon
     * 首页分类图标
     *
     * @mbg.generated 2018-07-10 14:47:36
     */
    private String icon;
    /**
     * goods_cat_info.sort_index
     * 分类排序值
     *
     * @mbg.generated 2018-07-10 14:47:36
     */
    private Integer sortIndex;
    /**
     * goods_cat_info.status
     * 是否显示
     *
     * @mbg.generated 2018-07-10 14:47:36
     */
    private String status;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", level=").append(level);
        sb.append(", catId=").append(catId);
        sb.append(", parentCatId=").append(parentCatId);
        sb.append(", catName=").append(catName);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", gmtModified=").append(gmtModified);
        sb.append(", img=").append(img);
        sb.append(", icon=").append(icon);
        sb.append(", sortIndex=").append(sortIndex);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}