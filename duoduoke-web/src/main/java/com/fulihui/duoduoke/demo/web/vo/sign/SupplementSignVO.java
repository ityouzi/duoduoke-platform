package com.fulihui.duoduoke.demo.web.vo.sign;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.near.toolkit.model.ToString;

/**
 * Created by lizhi on 2018-10-17.
 */
@Getter
@Setter
public class SupplementSignVO extends ToString {
    private static final long serialVersionUID = 3754148107977293283L;
    @ApiModelProperty(value = "补签状态,[1=自己不能给自己补签,2=补签已过期,3=你已经助力过,4=已达到上线]")
    private String            supplementStatus;
}
