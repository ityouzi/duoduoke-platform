package com.fulihui.duoduoke.demo.api.dto;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class RedPackageDBLConfigDTO {
    /**
     *
     *
     * red_package_doubling_config.id

     *
     * @mbg.generated 2018-09-04 09:47:08
     */
    private Integer id;

    /**
     *
     *
     * red_package_doubling_config.status
     * 状态[1:有效][2:无效]
     *
     * @mbg.generated 2018-09-04 09:47:08
     */
    private String status;

    /**
     *
     *
     * red_package_doubling_config.ongoing
     * 进行中的红包专场ID
     *
     * @mbg.generated 2018-09-04 09:47:08
     */
    private String ongoing;

    /**
     *
     *
     * red_package_doubling_config.expired
     * 已过期的红包专场ID
     *
     * @mbg.generated 2018-09-04 09:47:08
     */
    private String expired;


    /**
     *
     *
     * red_package_doubling_config.failed
     * 助力失败红包专场ID
     *
     * @mbg.generated 2018-09-07 11:03:08
     */
    private String failed;

    /**
     *
     *
     * red_package_doubling_config.succeed
     * 成功助理的红包专场ID
     *
     * @mbg.generated 2018-09-04 09:47:08
     */
    private String succeed;

    /**
     *
     *
     * red_package_doubling_config.title
     * 分享标题
     *
     * @mbg.generated 2018-09-04 09:47:08
     */
    private String title;

    /**
     *
     *
     * red_package_doubling_config.image
     * 分享图
     *
     * @mbg.generated 2018-09-04 09:47:08
     */
    private String image;

    /**
     *
     *
     * red_package_doubling_config.scale
     * 单个助力增加比例 xx%
     *
     * @mbg.generated 2018-09-04 09:47:08
     */
    private Float scale;

    /**
     *
     *
     * red_package_doubling_config.gmt_create
     * 创建时间
     *
     * @mbg.generated 2018-09-04 09:47:08
     */
    private Date gmtCreate;

    /**
     *
     *
     * red_package_doubling_config.gmt_modified
     * 修改时间
     *
     * @mbg.generated 2018-09-04 09:47:08
     */
    private Date gmtModified;

}
