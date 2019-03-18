package com.fulihui.duoduoke.demo.web.weixin.duoduoapi.result;

import java.util.List;

import org.near.toolkit.model.ToString;

/**
 * @author lizhi
 * @date 2018-7-8
 */
public class GoodsPromotionUrlGenerateResult extends DuoJsonResult {
    /**
     * goods_promotion_url_generate_response : {"goods_promotion_url_list":[{"url":"http://m.hutaojie.com/xxx.html?goods_id=10060234&pid=81_1812886&t=8yOvLw9Qjf9MhoZd8MmOS457aKLZUvx_WWYosfUHsPE=","short_url":"http://apiv2.hutaojie.com/api/d/dCBnwc"}]}
     */

    private GoodsPromotionUrlGenerateResponseBean goods_promotion_url_generate_response;

    public GoodsPromotionUrlGenerateResponseBean getGoods_promotion_url_generate_response() {
        return goods_promotion_url_generate_response;
    }

    public void setGoods_promotion_url_generate_response(GoodsPromotionUrlGenerateResponseBean goods_promotion_url_generate_response) {
        this.goods_promotion_url_generate_response = goods_promotion_url_generate_response;
    }

    public static class GoodsPromotionUrlGenerateResponseBean  extends ToString {
        private static final long serialVersionUID = -4152101327777709649L;
        private List<GoodsPromotionUrlListBean> goods_promotion_url_list;

        public List<GoodsPromotionUrlListBean> getGoods_promotion_url_list() {
            return goods_promotion_url_list;
        }

        public void setGoods_promotion_url_list(List<GoodsPromotionUrlListBean> goods_promotion_url_list) {
            this.goods_promotion_url_list = goods_promotion_url_list;
        }

        public static class GoodsPromotionUrlListBean  extends ToString {
            private static final long serialVersionUID = -7978136147297876455L;
            /**
             * url : http://m.hutaojie.com/xxx.html?goods_id=10060234&pid=81_1812886&t=8yOvLw9Qjf9MhoZd8MmOS457aKLZUvx_WWYosfUHsPE=
             * short_url : http://apiv2.hutaojie.com/api/d/dCBnwc
             */

            private String url;
            private String short_url;

            private GoodsPromotionUrlWeAPPBean we_app_info;

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

            public GoodsPromotionUrlWeAPPBean getWe_app_info() {
                return we_app_info;
            }

            public void setWe_app_info(GoodsPromotionUrlWeAPPBean we_app_info) {
                this.we_app_info = we_app_info;
            }
        }


        public static class GoodsPromotionUrlWeAPPBean  extends ToString {
            private static final long serialVersionUID = -7978136147297876455L;


            private String app_id;
            private String page_path;

            public String getApp_id() {
                return app_id;
            }

            public void setApp_id(String app_id) {
                this.app_id = app_id;
            }

            public String getPage_path() {
                return page_path;
            }

            public void setPage_path(String page_path) {
                this.page_path = page_path;
            }
        }
    }
}
