package com.fulihui.duoduoke.demo.api.dto;

import lombok.Getter;
import lombok.Setter;
import org.near.toolkit.model.ToString;

import java.util.Date;

/**
 * @author: JY
 * @date: 2018/7/11 16:35
 */
@Setter
@Getter
public class GoodsCatInfoDTO extends ToString {

  private static final long serialVersionUID = -3375465829342621575L;
  /** goods_cat_info.id */
  private Integer id;

  /** goods_cat_info.level 层级 */
  private String level;

  /** goods_cat_info.cat_id 商品标签ID */
  private Integer catId;

  /** goods_cat_info.parent_cat_id id所属父ID，其中，parent_id=0时为顶级节点 */
  private Integer parentCatId;

  /** goods_cat_info.cat_name 商品标签名 */
  private String catName;

  /** goods_cat_info.gmt_create 创建时间 */
  private Date gmtCreate;

  /** goods_cat_info.gmt_modified 修改时间 */
  private Date gmtModified;

  /** goods_cat_info.img 分类图 */
  private String img;

  /** goods_cat_info.icon 首页分类图标 */
  private String icon;

  /** goods_cat_info.sort_index 分类排序值 */
  private Integer sortIndex;

  /** goods_cat_info.status 是否显示 */
  private String status;
}
