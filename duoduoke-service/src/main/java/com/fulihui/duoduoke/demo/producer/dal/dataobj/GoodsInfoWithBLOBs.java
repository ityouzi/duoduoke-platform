package com.fulihui.duoduoke.demo.producer.dal.dataobj;

import java.io.Serializable;
import lombok.Data;

@Data
public class GoodsInfoWithBLOBs extends GoodsInfo implements Serializable {
    /**
    *
    *
    * goods_info.goods_desc
     * 商品描述
     *
     * @mbg.generated 2019-03-20 12:58:25
     */
    private String goodsDesc;

    /**
    *
    *
    * goods_info.goods_gallery_urls
     * 商品轮播列表
     *
     * @mbg.generated 2019-03-20 12:58:25
     */
    private String goodsGalleryUrls;

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", goodsDesc=").append(goodsDesc);
        sb.append(", goodsGalleryUrls=").append(goodsGalleryUrls);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}