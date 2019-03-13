package com.fulihui.redisdubbo.demo.vo;

import lombok.Getter;
import lombok.Setter;
import org.near.toolkit.model.ToString;

import java.util.List;

/**
 * @author lizhi
 * @date 2018/7/10 0010
 */
@Getter
@Setter
public class GoodsInfoVO extends ToString {

    private static final long serialVersionUID = 8347329260351678093L;

    private List<GoodsInfoList> list;


}
