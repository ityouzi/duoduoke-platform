package com.fulihui.duoduoke.demo.producer.dal.dataobj;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
public class GoodsKeywordInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * goods_keyword_info.id
     *
     * @mbg.generated 2018-07-16 18:20:31
     */
    private Integer id;
    /**
     * goods_keyword_info.keyword
     * 关键字
     *
     * @mbg.generated 2018-07-16 18:20:31
     */
    private String keyword;
    /**
     * goods_keyword_info.sort
     * 排序
     *
     * @mbg.generated 2018-07-16 18:20:31
     */
    private Integer sort;
    /**
     * goods_keyword_info.gmt_create
     * 创建时间
     *
     * @mbg.generated 2018-07-16 18:20:31
     */
    private Date gmtCreate;
    /**
     * goods_keyword_info.gmt_modified
     * 修改时间
     *
     * @mbg.generated 2018-07-16 18:20:31
     */
    private Date gmtModified;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", keyword=").append(keyword);
        sb.append(", sort=").append(sort);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", gmtModified=").append(gmtModified);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}