package com.fulihui.duoduoke.demo.web.weixin.duoapi.result;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @author lizhi
 * @date 2018/7/6 0006
 */
@Data
public class DuoCatResult extends DuoJsonResult {
    private static final long serialVersionUID = -1639418036432904906L;


    /**
     * goods_cats_get_response : {"goods_cats_list":{"cat_id":0,"cat_name":"str","level":0,"parent_cat_id":0}}
     */
    @JsonProperty("goods_cats_get_response")
    private GoodsCatsGetResponseBean goodsCatsGetResponse;

    @Data
    public static class GoodsCatsGetResponseBean {
        /**
         * goods_cats_list : {"cat_id":0,"cat_name":"str","level":0,"parent_cat_id":0}
         */
        @JsonProperty("goods_cats_list")
        private List<GoodsCatsListBean> goodsCatsList;

        @Data
        public static class GoodsCatsListBean {
            /**
             * cat_id : 0
             * cat_name : str
             * level : 0
             * parent_cat_id : 0
             */
            @JsonProperty("cat_id")

            private String catId;
            @JsonProperty("cat_name")

            private String catName;
            @JsonProperty("level")

            private String level;
            @JsonProperty("parent_cat_id")
            private String parentCatId;


        }
    }
}

