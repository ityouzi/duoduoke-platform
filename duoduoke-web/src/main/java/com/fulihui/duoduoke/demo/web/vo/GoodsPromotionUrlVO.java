package com.fulihui.duoduoke.demo.web.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.near.toolkit.model.ToString;

/**
 * @author lizhi
 * @date 2018-7-14
 */
@Setter @Getter
public class GoodsPromotionUrlVO extends ToString {
    private static final long serialVersionUID = 6284851014301307330L;
    /**
     * appid
     */
    @ApiModelProperty(value = "appID")

    private String appId;
    /**
     * page_path
     */
    @ApiModelProperty(value = "pagePath")
    private String pagePath;
}
