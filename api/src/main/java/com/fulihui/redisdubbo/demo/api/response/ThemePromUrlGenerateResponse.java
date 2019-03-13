package com.fulihui.redisdubbo.demo.api.response;

import lombok.Data;
import org.near.toolkit.model.ToString;

/**
 * Created by lizhi on 2018-12-06.
 */
@Data
public class ThemePromUrlGenerateResponse extends ToString {
    private static final long serialVersionUID = 2736634633127983810L;

    private String            multi_we_app_web_view_url;
    private String            multi_group_mobile_short_url;
    private String            mobile_url;
    private String            multi_we_app_web_view_short_url;
    private String            multi_group_mobile_url;
    private String            url;
    private String            short_url;
    private String            multi_group_url;
    private String            multi_group_short_url;
    private String            we_app_info;
    private String            mobile_short_url;
    private String            we_app_web_view_url;
    private String            we_app_web_view_short_url;

}
