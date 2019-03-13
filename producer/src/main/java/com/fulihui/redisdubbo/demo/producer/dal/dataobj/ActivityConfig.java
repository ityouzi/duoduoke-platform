package com.fulihui.redisdubbo.demo.producer.dal.dataobj;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ActivityConfig implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * activity_config.id
     * 标识列
     *
     * @mbg.generated 2018-11-13 10:20:28
     */
    private Integer id;
    /**
     * activity_config.type
     * 活动类型 [1:签到活动] [2:翻牌活动]
     *
     * @mbg.generated 2018-11-13 10:20:28
     */
    private Integer type;
    /**
     * activity_config.title
     * 活动标题
     *
     * @mbg.generated 2018-11-13 10:20:28
     */
    private String title;
    /**
     * activity_config.start_time
     * 活动开始时间
     *
     * @mbg.generated 2018-11-13 10:20:28
     */
    private Date startTime;
    /**
     * activity_config.end_time
     * 活动结束时间
     *
     * @mbg.generated 2018-11-13 10:20:28
     */
    private Date endTime;
    /**
     * activity_config.state
     * 活动状态 [1:有效][2:无效]
     *
     * @mbg.generated 2018-11-13 10:20:28
     */
    private Integer state;
    /**
     * activity_config.extend
     * 扩展字段
     *
     * @mbg.generated 2018-11-13 10:20:28
     */
    private String extend;
    /**
     * activity_config.gmt_create
     * 创建时间
     *
     * @mbg.generated 2018-11-13 10:20:28
     */
    private Date gmtCreate;
    /**
     * activity_config.gmt_modified
     * 修改时间
     *
     * @mbg.generated 2018-11-13 10:20:28
     */
    private Date gmtModified;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", type=").append(type);
        sb.append(", title=").append(title);
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", state=").append(state);
        sb.append(", extend=").append(extend);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", gmtModified=").append(gmtModified);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}