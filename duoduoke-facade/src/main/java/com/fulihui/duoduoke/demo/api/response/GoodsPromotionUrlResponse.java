package com.fulihui.duoduoke.demo.api.response;

import lombok.Getter;
import lombok.Setter;
import org.near.toolkit.model.ToString;

/**
 *
 * @author lizhi
 * @date 2018-7-8
 */
@Setter
@Getter
public class GoodsPromotionUrlResponse extends ToString {
    private static final long serialVersionUID = 6576010029937138438L;
    /**
     * 推广长链接
     */
    private String url;
    /**
     * 推广短链接
     */
    private String short_url;

    private String app_id;

    private String page_path;
}
