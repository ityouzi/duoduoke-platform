package com.fulihui.redisdubbo.demo.api.dto.promotion;

import lombok.Data;
import org.near.toolkit.model.ToString;

import java.util.Date;

/**
 * @author wahaha
 */
@Data
public class GroupChannelsOrderDTO extends ToString {

    private static final long serialVersionUID = 196316263318514056L;
    private Date orderPayTimeExt;
    private String pId;
    private String promoType;
    private Integer count;
    private Integer orderAmount;
    private Integer promotionAmount;
    private Date orderModifyAtExt;
}
