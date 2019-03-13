package com.fulihui.duoduoke.demo.api.request;

import lombok.Getter;
import lombok.Setter;
import org.near.servicesupport.request.PageRequest;

@Setter @Getter
public class GoodsInfoRecommendRequest extends PageRequest {


    /**
     * GoodsChannelTypeEnum
     */
    private int channelType;



}