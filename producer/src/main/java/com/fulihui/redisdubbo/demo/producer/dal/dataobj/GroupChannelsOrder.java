package com.fulihui.redisdubbo.demo.producer.dal.dataobj;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author wahaha
 */
@Data
public class GroupChannelsOrder implements Serializable {

    private static final long serialVersionUID = -7130106975389269505L;
    private Date orderPayTimeExt;
    private String pId;
    private String promoType;
    private Integer count;
    private Integer orderAmount;
    private Integer promotionAmount;
    private Date orderModifyAtExt;
}