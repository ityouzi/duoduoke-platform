package com.fulihui.redisdubbo.demo.api.dto;

import lombok.Getter;
import lombok.Setter;
import org.near.toolkit.model.ToString;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author: JY
 * @date: 2018/8/16 17:34
 */
@Setter
@Getter
public class WxTemplateSendDTO extends ToString {

  private static final long serialVersionUID = -4661780249647278894L;
  private String touser;

  private String templateId;

  private String page;

  private String formId;

  private String userId;

  /** 加粗的字段 列如：keyword1.DATA */
  private String emphasisKeyword;

  /** 页面参数 */
  private Map<String, Object> params;

  /** 任务Id */
  private Integer taskId;

  private LinkedHashMap<String, String> keywords;
}
