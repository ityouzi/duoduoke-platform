package com.fulihui.duoduoke.demo.api.dto;

import lombok.Getter;
import lombok.Setter;
import org.near.toolkit.model.ToString;

import java.util.Date;

/** @author Administrator */
@Setter
@Getter
public class GoodsKeywordInfoDTO extends ToString {

  /**
   * goods_keyword_info.id
   *
   * @mbg.generated 2018-07-16 18:20:31
   */
  private Integer id;

  /**
   * goods_keyword_info.keyword 关键字
   *
   * @mbg.generated 2018-07-16 18:20:31
   */
  private String keyword;

  /**
   * goods_keyword_info.sort 排序
   *
   * @mbg.generated 2018-07-16 18:20:31
   */
  private Integer sort;

  /**
   * goods_keyword_info.gmt_create 创建时间
   *
   * @mbg.generated 2018-07-16 18:20:31
   */
  private Date gmtCreate;

  /**
   * goods_keyword_info.gmt_modified 修改时间
   *
   * @mbg.generated 2018-07-16 18:20:31
   */
  private Date gmtModified;
}
