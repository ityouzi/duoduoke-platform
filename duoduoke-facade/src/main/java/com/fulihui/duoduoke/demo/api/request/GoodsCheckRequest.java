package com.fulihui.duoduoke.demo.api.request;

import lombok.Getter;
import lombok.Setter;
import org.near.toolkit.model.ToString;

import java.util.Date;

@Setter @Getter
public class GoodsCheckRequest extends ToString {
    private static final long serialVersionUID = -4254698836990658501L;


    /**
    *
    *
    * duoduo_goods_info.gmt_modified
     * 修改时间
     *
     *
     */
    private Date gmtModified;

    private boolean isChoose;




}