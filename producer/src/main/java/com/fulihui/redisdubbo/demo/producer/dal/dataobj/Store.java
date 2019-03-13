package com.fulihui.redisdubbo.demo.producer.dal.dataobj;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Store implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * store.id
     *
     * @mbg.generated 2018-10-16 13:58:18
     */
    private Long id;
    /**
     * store.store_name
     * 专场名称
     *
     * @mbg.generated 2018-10-16 13:58:18
     */
    private String storeName;
    /**
     * store.store_url
     *
     * @mbg.generated 2018-10-16 13:58:18
     */
    private String storeUrl;
    /**
     * store.recommendation
     * 推荐语
     *
     * @mbg.generated 2018-10-16 13:58:18
     */
    private String recommendation;
    /**
     * store.start_time
     * 专场开始时间
     *
     * @mbg.generated 2018-10-16 13:58:18
     */
    private Date startTime;
    /**
     * store.end_time
     * 专场结束时间
     *
     * @mbg.generated 2018-10-16 13:58:18
     */
    private Date endTime;
    /**
     * store.status
     * 专场状态 : 0关闭 1开启
     *
     * @mbg.generated 2018-10-16 13:58:18
     */
    private String status;
    /**
     * store.presentation
     * 展现形式:0 一行一个 1 一行两个
     *
     * @mbg.generated 2018-10-16 13:58:18
     */
    private String presentation;
    /**
     * store.is_preference
     * 是否优选显示: 0不显示 1显示
     *
     * @mbg.generated 2018-10-16 13:58:18
     */
    private String isPreference;
    /**
     * store.preference_number
     * 第几个优选显示
     *
     * @mbg.generated 2018-10-16 13:58:18
     */
    private Integer preferenceNumber;
    /**
     * store.preference_url
     * 优选入口图
     *
     * @mbg.generated 2018-10-16 13:58:18
     */
    private String preferenceUrl;
    /**
     * store.pid
     * 专场PID
     *
     * @mbg.generated 2018-10-16 13:58:18
     */
    private String pid;
    /**
     * store.share_titile
     * 分享标题
     *
     * @mbg.generated 2018-10-16 13:58:18
     */
    private String shareTitile;
    /**
     * store.share_url
     * 分享图
     *
     * @mbg.generated 2018-10-16 13:58:18
     */
    private String shareUrl;
    /**
     * store.gmt_create
     * 创建时间
     *
     * @mbg.generated 2018-10-16 13:58:18
     */
    private Date gmtCreate;
    /**
     * store.gmt_modified
     * 修改时间
     *
     * @mbg.generated 2018-10-16 13:58:18
     */
    private Date gmtModified;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", storeName=").append(storeName);
        sb.append(", storeUrl=").append(storeUrl);
        sb.append(", recommendation=").append(recommendation);
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", status=").append(status);
        sb.append(", presentation=").append(presentation);
        sb.append(", isPreference=").append(isPreference);
        sb.append(", preferenceNumber=").append(preferenceNumber);
        sb.append(", preferenceUrl=").append(preferenceUrl);
        sb.append(", pid=").append(pid);
        sb.append(", shareTitile=").append(shareTitile);
        sb.append(", shareUrl=").append(shareUrl);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", gmtModified=").append(gmtModified);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}