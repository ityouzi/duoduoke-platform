package com.fulihui.duoduoke.demo.web.weixin.duoapi.result;

import lombok.Data;

import java.util.List;

/**
 * /**
 * 多多进宝主题推广链接生成
 *
 * @author lizhi
 * @date 2018-12-06
 */
@Data
public class ThemePromUrlGenerateResult extends DuoJsonResult {
    private static final long serialVersionUID = 7407789860621194121L;

    /**
     * theme_promotion_url_generate_response : {"url_list":[{"url":"http://m.hutaojie.com/duo_theme_activity.html?themeId=124&pid=210035_947&duoduo_type=2&customParameters=222&sign=B0bUWJqnQWFD3LVjQGVl2GSknreRU0ruQehkkj2NSlI%3D","short_url":"http://apiv2.hutaojie.com/api/d/sVYCbe","mobile_url":"http://m.hutaojie.com/app.html?launch_url=duo_theme_activity.html%3FthemeId%3D124%26pid%3D210035_947%26duoduo_type%3D2%26customParameters%3D222%26sign%3DB0bUWJqnQWFD3LVjQGVl2GSknreRU0ruQehkkj2NSlI%253D","mobile_short_url":"http://apiv2.hutaojie.com/api/d/sVYCbf","multi_group_url":"http://m.hutaojie.com/duo_theme_activity.html?themeId=124&pid=210035_947&duoduo_type=3&customParameters=222&sign=B0bUWJqnQWFD3LVjQGVl2GSknreRU0ruQehkkj2NSlI%3D","multi_group_short_url":"http://apiv2.hutaojie.com/api/d/sVYCbg","multi_group_mobile_url":"http://m.hutaojie.com/app.html?launch_url=duo_theme_activity.html%3FthemeId%3D124%26pid%3D210035_947%26duoduo_type%3D3%26customParameters%3D222%26sign%3DB0bUWJqnQWFD3LVjQGVl2GSknreRU0ruQehkkj2NSlI%253D","multi_group_mobile_short_url":"http://apiv2.hutaojie.com/api/d/sVYCbh"}]}
     */

    private ThemePromotionUrlGenerateResponseBean theme_promotion_url_generate_response;


    @Data
    public static class ThemePromotionUrlGenerateResponseBean {
        private List<UrlListBean> url_list;

        @Data
        public static class UrlListBean {
            /**
             * url : http://m.hutaojie.com/duo_theme_activity.html?themeId=124&pid=210035_947&duoduo_type=2&customParameters=222&sign=B0bUWJqnQWFD3LVjQGVl2GSknreRU0ruQehkkj2NSlI%3D
             * short_url : http://apiv2.hutaojie.com/api/d/sVYCbe
             * mobile_url : http://m.hutaojie.com/app.html?launch_url=duo_theme_activity.html%3FthemeId%3D124%26pid%3D210035_947%26duoduo_type%3D2%26customParameters%3D222%26sign%3DB0bUWJqnQWFD3LVjQGVl2GSknreRU0ruQehkkj2NSlI%253D
             * mobile_short_url : http://apiv2.hutaojie.com/api/d/sVYCbf
             * multi_group_url : http://m.hutaojie.com/duo_theme_activity.html?themeId=124&pid=210035_947&duoduo_type=3&customParameters=222&sign=B0bUWJqnQWFD3LVjQGVl2GSknreRU0ruQehkkj2NSlI%3D
             * multi_group_short_url : http://apiv2.hutaojie.com/api/d/sVYCbg
             * multi_group_mobile_url : http://m.hutaojie.com/app.html?launch_url=duo_theme_activity.html%3FthemeId%3D124%26pid%3D210035_947%26duoduo_type%3D3%26customParameters%3D222%26sign%3DB0bUWJqnQWFD3LVjQGVl2GSknreRU0ruQehkkj2NSlI%253D
             * multi_group_mobile_short_url : http://apiv2.hutaojie.com/api/d/sVYCbh
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
