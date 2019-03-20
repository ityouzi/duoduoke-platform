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
    @JsonProperty("goods_cats_list")
    private List<DuoCatApiResult> goodsCatsList;


}

