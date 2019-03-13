package com.fulihui.duoduoke.demo.web.vo.sign;

import lombok.Getter;
import lombok.Setter;
import org.near.toolkit.model.ToString;

/**
 * @author Administrator
 */
@Setter
@Getter
public class SignInConfigVO extends ToString {
    private static final long serialVersionUID = -8939922037931218305L;

    private Long              id;

    private Integer           days;

}