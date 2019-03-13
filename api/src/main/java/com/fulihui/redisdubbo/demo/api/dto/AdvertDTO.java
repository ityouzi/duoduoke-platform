package com.fulihui.redisdubbo.demo.api.dto;

import lombok.Getter;
import lombok.Setter;
import org.near.toolkit.model.ToString;

import java.util.Date;

/**
 * @author Administrator
 */
@Setter
@Getter
public class AdvertDTO extends ToString {
  private static final long serialVersionUID = 6254431985927269116L;
  /**
   * advert.id
   *
   * @mbg.generated 2018-08-02 16:18:19
   */
  private Integer id;

  /**
   * advert.advert_img 广告图
   *
   * @mbg.generated 2018-08-02 16:18:19
   */
  private String advertImg;

  /**
   * advert.remark 备注
   *
   * @mbg.generated 2018-08-02 16:18:19
   */
  private String remark;

  /**
   * advert.img_url h5地址
   *
   * @mbg.generated 2018-08-02 16:18:19
   */
  private String imgUrl;

  /**
   * advert.type 小程序地址
   *
   * @mbg.generated 2018-08-02 16:18:19
   */
  private String type;

  /**
   * advert.state 状态[1:启用,0:禁用]
   *
   * @mbg.generated 2018-08-02 16:18:19
   */
  private String state;

  /**
   * advert.start_time 开始时间
   *
   * @mbg.generated 2018-08-02 16:18:19
   */
  private Date startTime;

  /**
   * advert.stop_time 结束时间
   *
   * @mbg.generated 2018-08-02 16:18:19
   */
  private Date stopTime;

  /**
   * advert.gmt_create 创建时间
   *
   * @mbg.generated 2018-08-02 16:18:19
   */
  private Date gmtCreate;

  /**
   * advert.gmt_modified 修改时间
   *
   * @mbg.generated 2018-08-02 16:18:19
   */
  private Date gmtModified;
}
