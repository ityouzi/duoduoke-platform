package com.fulihui.redisdubbo.demo.api.dto;

import lombok.Getter;
import lombok.Setter;
import org.near.toolkit.model.ToString;

import java.util.Date;

/**
 * @author: JY
 * @date: 2018/7/26 13:44
 */
@Setter
@Getter
public class AppConfigDTO extends ToString {

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
     *
     * @mbg.generated 2018-07-26 13:40:51
     */
    private Date gmtModified;

}
