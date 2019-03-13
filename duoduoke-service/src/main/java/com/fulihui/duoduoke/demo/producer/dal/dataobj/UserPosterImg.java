package com.fulihui.duoduoke.demo.producer.dal.dataobj;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
public class UserPosterImg implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * user_poster_img.id
     *
     * @mbg.generated 2018-07-30 17:58:18
     */
    private Integer id;
    /**
     * user_poster_img.user_id
     * 用户唯一标识
     *
     * @mbg.generated 2018-07-30 17:58:18
     */
    private String userId;
    /**
     * user_poster_img.poster_img
     * 用户海报图
     *
     * @mbg.generated 2018-07-30 17:58:18
     */
    private String posterImg;
    /**
     * user_poster_img.gmt_create
     * 创建时间
     *
     * @mbg.generated 2018-07-30 17:58:18
     */
    private Date gmtCreate;
    /**
     * user_poster_img.gmt_modified
     * 修改时间
     *
     * @mbg.generated 2018-07-30 17:58:18
     */
    private Date gmtModified;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", posterImg=").append(posterImg);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", gmtModified=").append(gmtModified);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}