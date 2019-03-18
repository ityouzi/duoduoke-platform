package com.fulihui.duoduoke.demo.api.request;

import lombok.Getter;
import lombok.Setter;
import org.near.toolkit.model.ToString;

import java.util.Date;

@Getter
@Setter
public class BannerUpdateRequest extends ToString {

    private Long positionBannerId;
    //模块名称
    private String moduleName;
    //模块编码
    private String moduleCode;
    //位置名称
    private String positionName;
    //位置编码
    private String positionCode;
    //图片地址
    private String imageUrl;
    //反应动作地址
    private String actionUrl;
    //排序
    private Integer orderBy;
    //状态
    private String status;
    //额外描述JSON
    private String paramsJson;

    private Date startTime;

    private Date endTime;
}
