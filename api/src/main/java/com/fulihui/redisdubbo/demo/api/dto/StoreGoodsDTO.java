package com.fulihui.redisdubbo.demo.api.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class StoreGoodsDTO  implements Serializable{
    /**
     *
     *
     * store_goods.id

     *
     * @mbg.generated 2018-10-16 13:58:18
     */
    private Long id;

    /**
     *
     *
     * store_goods.store_id
     * 专场ID
     *
     * @mbg.generated 2018-10-16 13:58:18
     */
    private Long storeId;

    /**
     *
     *
     * store_goods.goods_name
     * 商品标题
     *
     * @mbg.generated 2018-10-16 13:58:18
     */
    private String goodsName;

    /**
     *
     *
     * store_goods.goods_id
     * 多多客商品ID
     *
     * @mbg.generated 2018-10-16 13:58:18
     */
    private Long goodsId;

    /**
     *
     *
     * store_goods.status
     * 专题内显示 0关闭 1启用
     *
     * @mbg.generated 2018-10-16 13:58:18
     */
    private String status;

    /**
     *
     *
     * store_goods.order_by
     * 排序值
     *
     * @mbg.generated 2018-10-16 13:58:18
     */
    private Integer orderBy;

    /**
     *
     *
     * store_goods.gmt_create
     * 创建时间
     *
     * @mbg.generated 2018-10-16 13:58:18
     */
    private Date gmtCreate;

    /**
     *
     *
     * store_goods.gmt_modified
     * 修改时间
     *
     * @mbg.generated 2018-10-16 13:58:18
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
        sb.append(", storeId=").append(storeId);
        sb.append(", goodsName=").append(goodsName);
        sb.append(", goodsId=").append(goodsId);
        sb.append(", status=").append(status);
        sb.append(", orderBy=").append(orderBy);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", gmtModified=").append(gmtModified);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
