package com.fulihui.duoduoke.demo.web.weixin.duoapi.result;

import lombok.Data;
import org.near.toolkit.model.ToString;

import java.util.List;

/**
 * @author lizhi
 * @date 2018-7-8
 */
@Data
public class GoodsPromotionUrlGenerateResult extends DuoJsonResult {
    /**
     * goods_promotion_url_generate_response : {"goods_promotion_url_list":[{"url":"http://m.hutaojie.com/xxx.html?goods_id=10060234&pid=81_1812886&t=8yOvLw9Qjf9MhoZd8MmOS457aKLZUvx_WWYosfUHsPE=","short_url":"http://apiv2.hutaojie.com/api/d/dCBnwc"}]}
     */

    private GoodsPromotionUrlGenerateResponseBean goods_promotion_url_generate_response;


    @Data
    public static class GoodsPromotionUrlGenerateResponseBean extends ToString {
        private static final long serialVersionUID = -4152101327777709649L;
        private List<GoodsPromotionUrlListBean> goods_promotion_url_list;

        @Data
        public static class GoodsPromotionUrlListBean extends ToString {
            private static final long serialVersionUID = -7978136147297876455L;
            /**
             * url : http://m.hutaojie.com/xxx.html?goods_id=10060234&pid=81_1812886&t=8yOvLw9Qjf9MhoZd8MmOS457aKLZUvx_WWYosfUHsPE=
             * short_url : http://apiv2.hutaojie.com/api/d/dCBnwc
             */
            private String url;
            private String short_url;
            private GoodsPromotionUrlWeAPPBean we_app_info;

        }

        @Data
        public static class GoodsPromotionUrlWeAPPBean extends ToString {
            private static final long serialVersionUID = -7978136147297876455L;


            private String app_id;
            private String page_path;


        }
    }
}
