package com.fulihui.duoduoke.demo.web.weixin.duoapi.result;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * Created by lizhi on 2018-12-05.
 */
@Data
public class DuoCmsPromUrlGenerateResult extends DuoJsonResult {

    /**
     * cms_promotion_url_generate_response : {"total":1,"url_list":[{"url":"http://m.moremorepin.com/index.html?pid=60005_612&duoduo_type=2&authDuoId=60005&sign=_LU9QoQ3pOX3DSeYl_XhNQ%3D%3D","short_url":"http://apiv2.hutaojie.com/api/d/nzErgA","mobile_url":"https://m.hutaojie.com/app.html?launch_url=index.html%3Fpid%3D60005_612%26duoduo_type%3D2%26authDuoId%3D60005%26sign%3D_LU9QoQ3pOX3DSeYl_XhNQ%253D%253D","mobile_short_url":"http://apiv2.hutaojie.com/api/d/nzErgB","multi_group_url":"http://m.moremorepin.com/index.html?pid=60005_612&duoduo_type=3&authDuoId=60005&sign=_LU9QoQ3pOX3DSeYl_XhNQ%3D%3D","multi_group_short_url":"http://apiv2.hutaojie.com/api/d/nzErgC","multi_group_mobile_url":"https://m.hutaojie.com/app.html?launch_url=index.html%3Fpid%3D60005_612%26duoduo_type%3D3%26authDuoId%3D60005%26sign%3D_LU9QoQ3pOX3DSeYl_XhNQ%253D%253D","multi_group_mobile_short_url":"http://apiv2.hutaojie.com/api/d/nzErgD"}]}
     */
    @JsonProperty("cms_promotion_url_generate_response")
    private CmsPromotionUrlGenerateResponseBean cms_promotion_url_generate_response;

    @Data
    public static class CmsPromotionUrlGenerateResponseBean {
        /**
         * total : 1
         * url_list : [{"url":"http://m.moremorepin.com/index.html?pid=60005_612&duoduo_type=2&authDuoId=60005&sign=_LU9QoQ3pOX3DSeYl_XhNQ%3D%3D","short_url":"http://apiv2.hutaojie.com/api/d/nzErgA","mobile_url":"https://m.hutaojie.com/app.html?launch_url=index.html%3Fpid%3D60005_612%26duoduo_type%3D2%26authDuoId%3D60005%26sign%3D_LU9QoQ3pOX3DSeYl_XhNQ%253D%253D","mobile_short_url":"http://apiv2.hutaojie.com/api/d/nzErgB","multi_group_url":"http://m.moremorepin.com/index.html?pid=60005_612&duoduo_type=3&authDuoId=60005&sign=_LU9QoQ3pOX3DSeYl_XhNQ%3D%3D","multi_group_short_url":"http://apiv2.hutaojie.com/api/d/nzErgC","multi_group_mobile_url":"https://m.hutaojie.com/app.html?launch_url=index.html%3Fpid%3D60005_612%26duoduo_type%3D3%26authDuoId%3D60005%26sign%3D_LU9QoQ3pOX3DSeYl_XhNQ%253D%253D","multi_group_mobile_short_url":"http://apiv2.hutaojie.com/api/d/nzErgD"}]
         */

        private int total;
        private List<UrlListBean> url_list;


        @Data
        public static class UrlListBean {
            /**
             * url : http://m.moremorepin.com/index.html?pid=60005_612&duoduo_type=2&authDuoId=60005&sign=_LU9QoQ3pOX3DSeYl_XhNQ%3D%3D
             * short_url : http://apiv2.hutaojie.com/api/d/nzErgA
             * mobile_url : https://m.hutaojie.com/app.html?launch_url=index.html%3Fpid%3D60005_612%26duoduo_type%3D2%26authDuoId%3D60005%26sign%3D_LU9QoQ3pOX3DSeYl_XhNQ%253D%253D
             * mobile_short_url : http://apiv2.hutaojie.com/api/d/nzErgB
             * multi_group_url : http://m.moremorepin.com/index.html?pid=60005_612&duoduo_type=3&authDuoId=60005&sign=_LU9QoQ3pOX3DSeYl_XhNQ%3D%3D
             * multi_group_short_url : http://apiv2.hutaojie.com/api/d/nzErgC
             * multi_group_mobile_url : https://m.hutaojie.com/app.html?launch_url=index.html%3Fpid%3D60005_612%26duoduo_type%3D3%26authDuoId%3D60005%26sign%3D_LU9QoQ3pOX3DSeYl_XhNQ%253D%253D
             * multi_group_mobile_short_url : http://apiv2.hutaojie.com/api/d/nzErgD
             */

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
