package com.fulihui.duoduoke.demo.producer.dal.dataobj;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Position implements Serializable {
    /**
    *
    *
    * position.id
    
     *
     * @mbg.generated 2018-10-26 11:09:00
     */
    private Long id;

    /**
    *
    *
    * position.position_code
     * 位置编码： 如 duoduoke_xiaoxianbin_header ：小馅饼首页头banner位
     *
     * @mbg.generated 2018-10-26 11:09:00
     */
    private String positionCode;

    /**
    *
    *
    * position.position_name
     * 位置描述： 首页头banner位等
     *
     * @mbg.generated 2018-10-26 11:09:00
     */
    private String positionName;

    /**
    *
    *
    * position.module_code
     * 模块编码 ：如  duoduoke fulihui 等
     *
     * @mbg.generated 2018-10-26 11:09:00
     */
    private String moduleCode;

    /**
    *
    *
    * position.module_name
     * 模块名称 : 小馅饼小程序
     *
     * @mbg.generated 2018-10-26 11:09:00
     */
    private String moduleName;

    /**
    *
    *
    * position.gmt_create
     * 创建时间
     *
     * @mbg.generated 2018-10-26 11:09:00
     */
    private Date gmtCreate;

    /**
    *
    *
    * position.gmt_modified
     * 修改时间
     *
     * @mbg.generated 2018-10-26 11:09:00
     */
    private Date gmtModified;

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", positionCode=").append(positionCode);
        sb.append(", positionName=").append(positionName);
        sb.append(", moduleCode=").append(moduleCode);
        sb.append(", moduleName=").append(moduleName);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", gmtModified=").append(gmtModified);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}