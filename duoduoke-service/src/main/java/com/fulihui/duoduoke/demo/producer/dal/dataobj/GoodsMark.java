package com.fulihui.duoduoke.demo.producer.dal.dataobj;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class GoodsMark implements Serializable {
    /**
    *
    *
    * goods_mark.id
    
     *
     * @mbg.generated 2019-03-20 17:37:26
     */
    private Integer id;

    /**
    *
    *
    * goods_mark.goods_id
     * 商品编码
     *
     * @mbg.generated 2019-03-20 17:37:26
     */
    private String goodsId;

    /**
    *
    *
    * goods_mark.mark_id
     * 角标id
     *
     * @mbg.generated 2019-03-20 17:37:26
     */
    private Integer markId;

    /**
    *
    *
    * goods_mark.start_time
     * 角标开始时间
     *
     * @mbg.generated 2019-03-20 17:37:26
     */
    private Date startTime;

    /**
    *
    *
    * goods_mark.stop_time
     * 角标结束时间
     *
     * @mbg.generated 2019-03-20 17:37:26
     */
    private Date stopTime;

    /**
    *
    *
    * goods_mark.gmt_create
     * 创建时间
     *
     * @mbg.generated 2019-03-20 17:37:26
     */
    private Date gmtCreate;

    /**
    *
    *
    * goods_mark.gmt_modified
     * 修改时间
     *
     * @mbg.generated 2019-03-20 17:37:26
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
        sb.append(", goodsId=").append(goodsId);
        sb.append(", markId=").append(markId);
        sb.append(", startTime=").append(startTime);
        sb.append(", stopTime=").append(stopTime);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", gmtModified=").append(gmtModified);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}