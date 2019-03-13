package com.fulihui.duoduoke.demo.api.dto;

import lombok.Getter;
import lombok.Setter;
import org.near.toolkit.model.ToString;

import java.util.Date;

/**
 * @author Administrator
 */
@Setter
@Getter
public class GoodsTabelDTO extends ToString {
    /**
     * goods_tabel.id
     *
     * @mbg.generated 2018-08-08 19:31:41
     */
    private Integer id;

    /**
     * goods_tabel.table_id
     * 表
     *
     * @mbg.generated 2018-08-08 19:31:41
     */
    private Long tableId;

    /**
     * goods_tabel.gmt_create
     * 创建时间
     *
     * @mbg.generated 2018-08-08 19:31:41
     */
    private Date gmtCreate;

    /**
     * goods_tabel.gmt_modified
     * 修改时间
     *
     * @mbg.generated 2018-08-08 19:31:41
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
        sb.append(", tableId=").append(tableId);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", gmtModified=").append(gmtModified);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}