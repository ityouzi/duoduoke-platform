package com.fulihui.duoduoke.demo.producer.dal.dataobj;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class CornerMark implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * corner_mark.id
     *
     * @mbg.generated 2018-09-18 14:41:02
     */
    private Integer id;
    /**
     * corner_mark.mark_name
     * 角标名称
     *
     * @mbg.generated 2018-09-18 14:41:02
     */
    private String markName;
    /**
     * corner_mark.mark_url
     * 角标url
     *
     * @mbg.generated 2018-09-18 14:41:02
     */
    private String markUrl;
    /**
     * corner_mark.gmt_create
     * 创建时间
     *
     * @mbg.generated 2018-09-18 14:41:02
     */
    private Date gmtCreate;
    /**
     * corner_mark.gmt_modified
     * 修改时间
     *
     * @mbg.generated 2018-09-18 14:41:02
     */
    private Date gmtModified;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", markName=").append(markName);
        sb.append(", markUrl=").append(markUrl);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", gmtModified=").append(gmtModified);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}