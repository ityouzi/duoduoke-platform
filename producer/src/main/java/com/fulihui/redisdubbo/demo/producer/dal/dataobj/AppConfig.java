package com.fulihui.redisdubbo.demo.producer.dal.dataobj;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
public class AppConfig implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * app_config.id
     * 主键
     *
     * @mbg.generated 2018-07-26 13:40:51
     */
    private Integer id;
    /**
     * app_config.config_val
     * 配置值
     *
     * @mbg.generated 2018-07-26 13:40:51
     */
    private String configVal;
    /**
     * app_config.config_extend_val
     * 扩展值
     *
     * @mbg.generated 2018-07-26 13:40:51
     */
    private String configExtendVal;
    /**
     * app_config.gmt_modified
     * 更新时间
     *
     * @mbg.generated 2018-07-26 13:40:51
     */
    private Date gmtModified;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", configVal=").append(configVal);
        sb.append(", configExtendVal=").append(configExtendVal);
        sb.append(", gmtModified=").append(gmtModified);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}