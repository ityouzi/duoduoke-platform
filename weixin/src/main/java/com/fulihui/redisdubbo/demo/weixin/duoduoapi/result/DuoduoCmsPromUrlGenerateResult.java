package com.fulihui.redisdubbo.demo.weixin.duoduoapi.result;

import java.util.List;

/**
 * Created by lizhi on 2018-12-05.
 */
public class DuoduoCmsPromUrlGenerateResult extends DuoduoJsonResult {

    /**
     * cms_promotion_url_generate_response : {"total":1,"url_list":[{"url":"http://m.moremorepin.com/index.html?pid=60005_612&duoduo_type=2&authDuoId=60005&sign=_LU9QoQ3pOX3DSeYl_XhNQ%3D%3D","short_url":"http://apiv2.hutaojie.com/api/d/nzErgA","mobile_url":"https://m.hutaojie.com/app.html?launch_url=index.html%3Fpid%3D60005_612%26duoduo_type%3D2%26authDuoId%3D60005%26sign%3D_LU9QoQ3pOX3DSeYl_XhNQ%253D%253D","mobile_short_url":"http://apiv2.hutaojie.com/api/d/nzErgB","multi_group_url":"http://m.moremorepin.com/index.html?pid=60005_612&duoduo_type=3&authDuoId=60005&sign=_LU9QoQ3pOX3DSeYl_XhNQ%3D%3D","multi_group_short_url":"http://apiv2.hutaojie.com/api/d/nzErgC","multi_group_mobile_url":"https://m.hutaojie.com/app.html?launch_url=index.html%3Fpid%3D60005_612%26duoduo_type%3D3%26authDuoId%3D60005%26sign%3D_LU9QoQ3pOX3DSeYl_XhNQ%253D%253D","multi_group_mobile_short_url":"http://apiv2.hutaojie.com/api/d/nzErgD"}]}
     */

    private CmsPromotionUrlGenerateResponseBean cms_promotion_url_generate_response;

    public CmsPromotionUrlGenerateResponseBean getCms_promotion_url_generate_response() {
        return cms_promotion_url_generate_response;
    }

    public void setCms_promotion_url_generate_response(CmsPromotionUrlGenerateResponseBean cms_promotion_url_generate_response) {
        this.cms_promotion_url_generate_response = cms_promotion_url_generate_response;
    }

    public static class CmsPromotionUrlGenerateResponseBean {
        /**
         * total : 1
         * url_list : [{"url":"http://m.moremorepin.com/index.html?pid=60005_612&duoduo_type=2&authDuoId=60005&sign=_LU9QoQ3pOX3DSeYl_XhNQ%3D%3D","short_url":"http://apiv2.hutaojie.com/api/d/nzErgA","mobile_url":"https://m.hutaojie.com/app.html?launch_url=index.html%3Fpid%3D60005_612%26duoduo_type%3D2%26authDuoId%3D60005%26sign%3D_LU9QoQ3pOX3DSeYl_XhNQ%253D%253D","mobile_short_url":"http://apiv2.hutaojie.com/api/d/nzErgB","multi_group_url":"http://m.moremorepin.com/index.html?pid=60005_612&duoduo_type=3&authDuoId=60005&sign=_LU9QoQ3pOX3DSeYl_XhNQ%3D%3D","multi_group_short_url":"http://apiv2.hutaojie.com/api/d/nzErgC","multi_group_mobile_url":"https://m.hutaojie.com/app.html?launch_url=index.html%3Fpid%3D60005_612%26duoduo_type%3D3%26authDuoId%3D60005%26sign%3D_LU9QoQ3pOX3DSeYl_XhNQ%253D%253D","multi_group_mobile_short_url":"http://apiv2.hutaojie.com/api/d/nzErgD"}]
         */

        private int               total;
        private List<UrlListBean> url_list;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public List<UrlListBean> getUrl_list() {
            return url_list;
        }

        public void setUrl_list(List<UrlListBean> url_list) {
            this.url_list = url_list;
        }

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

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getShort_url() {
                return short_url;
            }

            public void setShort_url(String short_url) {
                this.short_url = short_url;
            }

            public String getMobile_url() {
                return mobile_url;
            }

            public void setMobile_url(String mobile_url) {
                this.mobile_url = mobile_url;
            }

            public String getMobile_short_url() {
                return mobile_short_url;
            }

            public void setMobile_short_url(String mobile_short_url) {
                this.mobile_short_url = mobile_short_url;
            }

            public String getMulti_group_url() {
                return multi_group_url;
            }

            public void setMulti_group_url(String multi_group_url) {
                this.multi_group_url = multi_group_url;
            }

            public String getMulti_group_short_url() {
                return multi_group_short_url;
            }

            public void setMulti_group_short_url(String multi_group_short_url) {
                this.multi_group_short_url = multi_group_short_url;
            }

            public String getMulti_group_mobile_url() {
                return multi_group_mobile_url;
            }

            public void setMulti_group_mobile_url(String multi_group_mobile_url) {
                this.multi_group_mobile_url = multi_group_mobile_url;
            }

            public String getMulti_group_mobile_short_url() {
                return multi_group_mobile_short_url;
            }

            public void setMulti_group_mobile_short_url(String multi_group_mobile_short_url) {
                this.multi_group_mobile_short_url = multi_group_mobile_short_url;
            }
        }
    }
}
