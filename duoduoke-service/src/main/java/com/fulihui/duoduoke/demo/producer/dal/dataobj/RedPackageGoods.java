package com.fulihui.duoduoke.demo.producer.dal.dataobj;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class RedPackageGoods implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * red_package_goods.id
     * 主键
     *
     * @mbg.generated 2018-09-03 15:14:52
     */
    private Integer id;
    /**
     * red_package_goods.rpf_id
     * 红包专场id
     *
     * @mbg.generated 2018-09-03 15:14:52
     */
    private Integer rpfId;
    /**
     * red_package_goods.goods_id
     * 商品id
     *
     * @mbg.generated 2018-09-03 15:14:52
     */
    private Long goodsId;
    /**
     * red_package_goods.sort
     * 排序
     *
     * @mbg.generated 2018-09-03 15:14:52
     */
    private Integer sort;
    /**
     * red_package_goods.rpf_type
     * 1:基础红包专场商品  2:助力红包专场商品
     *
     * @mbg.generated 2018-09-03 15:14:52
     */
    private Integer rpfType;
    /**
     * red_package_goods.gmt_create
     * 创建时间
     *
     * @mbg.generated 2018-09-03 15:14:52
     */
    private Date gmtCreate;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", rpfId=").append(rpfId);
        sb.append(", goodsId=").append(goodsId);
        sb.append(", sort=").append(sort);
        sb.append(", rpfType=").append(rpfType);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}