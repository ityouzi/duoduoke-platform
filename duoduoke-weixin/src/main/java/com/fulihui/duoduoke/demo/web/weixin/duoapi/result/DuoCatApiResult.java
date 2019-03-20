package com.fulihui.duoduoke.demo.web.weixin.duoapi.result;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.near.toolkit.model.ToString;

/**
 * @author lizhi
 * @date 2018/7/6 0006
 */
@Data
public class DuoCatApiResult extends ToString {

    @JsonProperty("level")
    private String level;
    @JsonProperty("parent_cat_id")
    private String parentCatId;
    @JsonProperty("cat_name")
    private String catName;
    @JsonProperty("cat_id")
    private String catId;


}
