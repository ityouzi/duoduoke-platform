package com.fulihui.duoduoke.demo.common.result;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author: JY
 * @date: 2018/7/6 18:46
 */
@Getter
@Setter
@ToString
public class WebPageResult<T> extends WebResult<T> {

    /**
     * 条数
     */
    private Integer count;
}
