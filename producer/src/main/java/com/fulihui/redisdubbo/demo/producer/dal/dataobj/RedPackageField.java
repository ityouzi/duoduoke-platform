package com.fulihui.redisdubbo.demo.producer.dal.dataobj;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class RedPackageField implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * red_package_field.id
     * 主键
     *
     * @mbg.generated 2018-10-09 10:37:55
     */
    private Integer id;
    /**
     * red_package_field.title
     * 专场名称
     *
     * @mbg.generated 2018-10-09 10:37:55
     */
    private String title;
    /**
     * red_package_field.state
     * 专场状态[1:有效][2:无效]
     *
     * @mbg.generated 2018-10-09 10:37:55
     */
    private Short state;
    /**
     * red_package_field.type
     * 专场类型 [1:红包专场] [2:无助力红包专场]
     *
     * @mbg.generated 2018-10-09 10:37:55
     */
    private Integer type;
    /**
     * red_package_field.valid_time
     * 有效时间
     *
     * @mbg.generated 2018-10-09 10:37:55
     */
    private Integer validTime;
    /**
     * red_package_field.order_pid
     * 订单pid
     *
     * @mbg.generated 2018-10-09 10:37:55
     */
    private String orderPid;
    /**
     * red_package_field.base_red_packet
     * 基础红包金额
     *
     * @mbg.generated 2018-10-09 10:37:55
     */
    private Integer baseRedPacket;
    /**
     * red_package_field.assistance_red_packet
     * 助力红包金额
     *
     * @mbg.generated 2018-10-09 10:37:55
     */
    private Integer assistanceRedPacket;
    /**
     * red_package_field.share_title
     * 分享的标题
     *
     * @mbg.generated 2018-10-09 10:37:55
     */
    private String shareTitle;
    /**
     * red_package_field.share_img
     * 分享的图片
     *
     * @mbg.generated 2018-10-09 10:37:55
     */
    private String shareImg;
    /**
     * red_package_field.gmt_create
     * 创建时间
     *
     * @mbg.generated 2018-10-09 10:37:55
     */
    private Date gmtCreate;
    /**
     * red_package_field.gmt_modified
     * 修改时间
     *
     * @mbg.generated 2018-10-09 10:37:55
     */
    private Date gmtModified;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", title=").append(title);
        sb.append(", state=").append(state);
        sb.append(", type=").append(type);
        sb.append(", validTime=").append(validTime);
        sb.append(", orderPid=").append(orderPid);
        sb.append(", baseRedPacket=").append(baseRedPacket);
        sb.append(", assistanceRedPacket=").append(assistanceRedPacket);
        sb.append(", shareTitle=").append(shareTitle);
        sb.append(", shareImg=").append(shareImg);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", gmtModified=").append(gmtModified);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}