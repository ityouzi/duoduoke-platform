package com.fulihui.duoduoke.demo.web.weixin.duoapi.result;

import lombok.Data;

import java.util.List;

/**
 * 生成红包推广链接
 * Created by lizhi on 2018-12-06.
 */
@Data
public class RpPromUrlGenerateResult extends DuoJsonResult {
    private static final long serialVersionUID = -3046711033820289690L;

    /**
     * rp_promotion_url_generate_response : {"url_list":[{"url":"https://m.hutaojie.com/duo_red_packet.html?pid=60005_612&duoduo_type=2&sign=kRt7Ka4ENaHDDp8PFGwNSw%3D%3D","short_url":"http://apiv2.hutaojie.com/api/d/nmEzjq","mobile_url":"https://m.hutaojie.com/app.html?launch_url=duo_red_packet.html%3Fpid%3D60005_612%26duoduo_type%3D2%26sign%3DkRt7Ka4ENaHDDp8PFGwNSw%253D%253D","mobile_short_url":"http://apiv2.hutaojie.com/api/d/nmEzjr","multi_group_url":"https://m.hutaojie.com/duo_red_packet.html?pid=60005_612&duoduo_type=3&sign=kRt7Ka4ENaHDDp8PFGwNSw%3D%3D","multi_group_short_url":"http://apiv2.hutaojie.com/api/d/nmEzjs","multi_group_mobile_url":"https://m.hutaojie.com/app.html?launch_url=duo_red_packet.html%3Fpid%3D60005_612%26duoduo_type%3D3%26sign%3DkRt7Ka4ENaHDDp8PFGwNSw%253D%253D","multi_group_mobile_short_url":"http://apiv2.hutaojie.com/api/d/nmEzjt"}]}
     */

    private RpPromotionUrlGenerateResponseBean rp_promotion_url_generate_response;


    @Data
    public static class RpPromotionUrlGenerateResponseBean {
        private List<UrlListBean> url_list;


        @Data
        public static class UrlListBean {
            /**
             * url : https://m.hutaojie.com/duo_red_packet.html?pid=60005_612&duoduo_type=2&sign=kRt7Ka4ENaHDDp8PFGwNSw%3D%3D
             * short_url : http://apiv2.hutaojie.com/api/d/nmEzjq
             * mobile_url : https://m.hutaojie.com/app.html?launch_url=duo_red_packet.html%3Fpid%3D60005_612%26duoduo_type%3D2%26sign%3DkRt7Ka4ENaHDDp8PFGwNSw%253D%253D
             * mobile_short_url : http://apiv2.hutaojie.com/api/d/nmEzjr
             * multi_group_url : https://m.hutaojie.com/duo_red_packet.html?pid=60005_612&duoduo_type=3&sign=kRt7Ka4ENaHDDp8PFGwNSw%3D%3D
             * multi_group_short_url : http://apiv2.hutaojie.com/api/d/nmEzjs
             * multi_group_mobile_url : https://m.hutaojie.com/app.html?launch_url=duo_red_packet.html%3Fpid%3D60005_612%26duoduo_type%3D3%26sign%3DkRt7Ka4ENaHDDp8PFGwNSw%253D%253D
             * multi_group_mobile_short_url : http://apiv2.hutaojie.com/api/d/nmEzjt
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
