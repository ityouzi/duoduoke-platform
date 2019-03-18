package com.fulihui.duoduoke.demo.producer.dal.dataobj;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Banner implements Serializable {
    /**
    *
    *
    * banner.id
    
     *
     * @mbg.generated 2018-10-26 10:56:50
     */
    private Long id;

    /**
    *
    *
    * banner.image_url
    
     *
     * @mbg.generated 2018-10-26 10:56:50
     */
    private String imageUrl;

    /**
    *
    *
    * banner.action_url
    
     *
     * @mbg.generated 2018-10-26 10:56:50
     */
    private String actionUrl;

    /**
    *
    *
    * banner.status
    
     *
     * @mbg.generated 2018-10-26 10:56:50
     */
    private String status;

    /**
    *
    *
    * banner.gmt_create
     * 创建时间
     *
     * @mbg.generated 2018-10-26 10:56:50
     */
    private Date gmtCreate;

    /**
    *
    *
    * banner.gmt_modified
     * 修改时间
     *
     * @mbg.generated 2018-10-26 10:56:50
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
        sb.append(", imageUrl=").append(imageUrl);
        sb.append(", actionUrl=").append(actionUrl);
        sb.append(", status=").append(status);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", gmtModified=").append(gmtModified);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}