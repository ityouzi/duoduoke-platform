package com.fulihui.duoduoke.demo.web.weixin.duoapi.result;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * Created by lizhi on 2018-12-05.
 */
@Data
public class DuoCmsPromUrlGenerateResult extends DuoJsonResult {


    @JsonProperty("cms_promotion_url_generate_response")
    private CmsPromotionUrlGenerateResponseBean cms_promotion_url_generate_response;

    @Data
    public static class CmsPromotionUrlGenerateResponseBean {


        private int total;
        private List<UrlListBean> url_list;


        @Data
        public static class UrlListBean {


            private String url;
            private String short_url;
            private String mobile_url;
            private String mobile_short_url;
            private String multi_group_url;
            private String multi_group_short_url;
            private String multi_group_mobile_url;
            private String multi_group_mobile_short_url;


        }
    }
}
