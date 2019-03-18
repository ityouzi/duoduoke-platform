package com.fulihui.duoduoke.demo.producer.dal.dataobj;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class PositionBanner implements Serializable {
    /**
    *
    *
    * position_banner.id
    
     *
     * @mbg.generated 2018-10-29 14:21:16
     */
    private Long id;

    /**
    *
    *
    * position_banner.position_code
     * 位置编码: 只是为了方便快速查询和识别
     *
     * @mbg.generated 2018-10-29 14:21:16
     */
    private String positionCode;

    /**
    *
    *
    * position_banner.position_id
     * 位置ID
     *
     * @mbg.generated 2018-10-29 14:21:16
     */
    private Long positionId;

    /**
    *
    *
    * position_banner.banner_id
     * banner ID
     *
     * @mbg.generated 2018-10-29 14:21:16
     */
    private Long bannerId;

    /**
    *
    *
    * position_banner.param_json
     * 业务独有的参数 可传字符串或者json
     *
     * @mbg.generated 2018-10-29 14:21:16
     */
    private String paramJson;

    /**
    *
    *
    * position_banner.status
     * 状态 :1 启用 0 不启用
     *
     * @mbg.generated 2018-10-29 14:21:16
     */
    private String status;

    /**
    *
    *
    * position_banner.order_by
     * 排序 
     *
     * @mbg.generated 2018-10-29 14:21:16
     */
    private Integer orderBy;

    /**
    *
    *
    * position_banner.gmt_create
     * 创建时间
     *
     * @mbg.generated 2018-10-29 14:21:16
     */
    private Date gmtCreate;

    /**
    *
    *
    * position_banner.gmt_modified
     * 修改时间
     *
     * @mbg.generated 2018-10-29 14:21:16
     */
    private Date gmtModified;

    /**
    *
    *
    * position_banner.start_time
    
     *
     * @mbg.generated 2018-10-29 14:21:16
     */
    private Date startTime;

    /**
    *
    *
    * position_banner.end_time
    
     *
     * @mbg.generated 2018-10-29 14:21:16
     */
    private Date endTime;

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", positionCode=").append(positionCode);
        sb.append(", positionId=").append(positionId);
        sb.append(", bannerId=").append(bannerId);
        sb.append(", paramJson=").append(paramJson);
        sb.append(", status=").append(status);
        sb.append(", orderBy=").append(orderBy);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", gmtModified=").append(gmtModified);
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}