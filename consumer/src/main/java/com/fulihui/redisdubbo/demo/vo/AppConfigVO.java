package com.fulihui.redisdubbo.demo.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author: JY
 * @date: 2018/7/26 14:17
 */
@Setter @Getter
public class AppConfigVO {
    /**
     * 主键
     *
     * @mbg.generated 2018-07-26 13:40:51
     */
    private Integer id;

    /**
     * 配置值
     *
     * @mbg.generated 2018-07-26 13:40:51
     */
    private String configVal;

    /**
     * 扩展值
     *
     * @mbg.generated 2018-07-26 13:40:51
     */
    private String configExtendVal;

    /**
     * 更新时间
     * @mbg.generated 2018-07-26 13:40:51
     */
    private Date gmtModified;
}
