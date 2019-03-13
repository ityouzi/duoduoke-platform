package com.fulihui.duoduoke.demo.api.dto;

import lombok.Getter;
import lombok.Setter;
import org.near.toolkit.model.ToString;

import java.util.Date;

/** @author lizhi */
@Setter
@Getter
public class GoodSearchRecordDTO extends ToString {
  private static final long serialVersionUID = -5408471901390257404L;
  /** good_search_record.id */
  private Integer id;

  /** good_search_record.user_id 用户id */
  private String userId;

  /** good_search_record.search_content 搜索内容 */
  private String searchContent;

  /** good_search_record.is_result */
  private String isResult;

  /** good_search_record.gmt_create */
  private Date gmtCreate;
}
