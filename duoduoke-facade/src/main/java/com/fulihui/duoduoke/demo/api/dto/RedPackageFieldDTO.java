package com.fulihui.duoduoke.demo.api.dto;

import lombok.Data;
import org.near.toolkit.model.ToString;

import java.util.Date;

/**
 * @author: JY
 * @date: 2018/9/3 15:28
 */
@Data
public class RedPackageFieldDTO extends ToString {

    /**
     * 主键
     */
    private Integer id;

    /**
     * 专场名称
     */
    private String title;

    /**
     * 专场状态[1:有效][2:无效]
     */
    private Short state;

    /**
     * 专场类型[1:红包专场][2:无助力红包专场]
     */
    private Integer type;

    /**
     * 有效时间
     */
    private Integer validTime;

    /**
     * 订单pid
     */
    private String orderPid;

    /**
     * 基础红包金额
     */
    private Integer baseRedPacket;

    /**
     * 助力红包金额
     */
    private Integer assistanceRedPacket;

    /**
     * 分享的标题
     */
    private String shareTitle;

    /**
     * 分享的图片
     */
    private String shareImg;

    /**
     * 创建时间
     */
    private Date gmtCreate;

    /**
     * 修改时间
     */
    private Date gmtModified;

}
