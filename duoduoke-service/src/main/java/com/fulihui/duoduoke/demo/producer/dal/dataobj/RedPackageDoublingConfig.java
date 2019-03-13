package com.fulihui.duoduoke.demo.producer.dal.dataobj;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class RedPackageDoublingConfig implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * red_package_doubling_config.id
     *
     * @mbg.generated 2018-09-07 11:03:08
     */
    private Integer id;
    /**
     * red_package_doubling_config.status
     * 状态[on:有效][off:无效]
     *
     * @mbg.generated 2018-09-07 11:03:08
     */
    private String status;
    /**
     * red_package_doubling_config.ongoing
     * 进行中的红包专场ID
     *
     * @mbg.generated 2018-09-07 11:03:08
     */
    private String ongoing;
    /**
     * red_package_doubling_config.expired
     * 已过期的红包专场ID
     *
     * @mbg.generated 2018-09-07 11:03:08
     */
    private String expired;
    /**
     * red_package_doubling_config.failed
     * 助力失败红包专场ID
     *
     * @mbg.generated 2018-09-07 11:03:08
     */
    private String failed;
    /**
     * red_package_doubling_config.succeed
     * 成功助理的红包专场ID
     *
     * @mbg.generated 2018-09-07 11:03:08
     */
    private String succeed;
    /**
     * red_package_doubling_config.title
     * 分享标题
     *
     * @mbg.generated 2018-09-07 11:03:08
     */
    private String title;
    /**
     * red_package_doubling_config.image
     * 分享图
     *
     * @mbg.generated 2018-09-07 11:03:08
     */
    private String image;
    /**
     * red_package_doubling_config.scale
     * 单个助力增加比例 xx%
     *
     * @mbg.generated 2018-09-07 11:03:08
     */
    private Float scale;
    /**
     * red_package_doubling_config.gmt_create
     * 创建时间
     *
     * @mbg.generated 2018-09-07 11:03:08
     */
    private Date gmtCreate;
    /**
     * red_package_doubling_config.gmt_modified
     * 修改时间
     *
     * @mbg.generated 2018-09-07 11:03:08
     */
    private Date gmtModified;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", status=").append(status);
        sb.append(", ongoing=").append(ongoing);
        sb.append(", expired=").append(expired);
        sb.append(", failed=").append(failed);
        sb.append(", succeed=").append(succeed);
        sb.append(", title=").append(title);
        sb.append(", image=").append(image);
        sb.append(", scale=").append(scale);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", gmtModified=").append(gmtModified);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}