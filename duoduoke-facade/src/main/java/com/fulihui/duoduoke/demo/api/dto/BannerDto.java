package com.fulihui.duoduoke.demo.api.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class BannerDto {
    //位置的Banner Id
    private Long positionBannerId;
    //位置编码
    private String positionCode;
    //模块编码
    private String moduleCode;

    private String positionName;

    private String moduleName;
    //排序
    private Integer orderBy;
    //状态 1 启用  0 不启用
    private String status;
    //其他传参
    private String paramJson;
    //Banner图片地址
    private String imageUrl;
    //Banner链接地址
    private String actionUrl;

    private Date startTime;

    private Date endTime;

    private Date gmtCreate;

    private Date gmtModified;

}
