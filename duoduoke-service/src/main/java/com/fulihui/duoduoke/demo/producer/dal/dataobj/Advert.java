package com.fulihui.duoduoke.demo.producer.dal.dataobj;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
public class Advert implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * advert.id
     *
     * @mbg.generated 2018-08-02 16:18:19
     */
    private Integer id;
    /**
     * advert.advert_img
     * 广告图
     *
     * @mbg.generated 2018-08-02 16:18:19
     */
    private String advertImg;
    /**
     * advert.remark
     * 备注
     *
     * @mbg.generated 2018-08-02 16:18:19
     */
    private String remark;
    /**
     * advert.img_url
     * h5地址
     *
     * @mbg.generated 2018-08-02 16:18:19
     */
    private String imgUrl;
    /**
     * advert.type
     * 小程序地址
     *
     * @mbg.generated 2018-08-02 16:18:19
     */
    private String type;
    /**
     * advert.state
     * 状态[1:启用,0:禁用]
     *
     * @mbg.generated 2018-08-02 16:18:19
     */
    private String state;
    /**
     * advert.start_time
     * 开始时间
     *
     * @mbg.generated 2018-08-02 16:18:19
     */
    private Date startTime;
    /**
     * advert.stop_time
     * 结束时间
     *
     * @mbg.generated 2018-08-02 16:18:19
     */
    private Date stopTime;
    /**
     * advert.gmt_create
     * 创建时间
     *
     * @mbg.generated 2018-08-02 16:18:19
     */
    private Date gmtCreate;
    /**
     * advert.gmt_modified
     * 修改时间
     *
     * @mbg.generated 2018-08-02 16:18:19
     */
    private Date gmtModified;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", advertImg=").append(advertImg);
        sb.append(", remark=").append(remark);
        sb.append(", imgUrl=").append(imgUrl);
        sb.append(", type=").append(type);
        sb.append(", state=").append(state);
        sb.append(", startTime=").append(startTime);
        sb.append(", stopTime=").append(stopTime);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", gmtModified=").append(gmtModified);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}