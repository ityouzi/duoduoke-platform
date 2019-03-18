package com.fulihui.duoduoke.demo.web.weixin.duoapi.result;

import lombok.Getter;
import lombok.Setter;
import org.near.toolkit.model.ToString;

/**
 * Created by lizhi on 2018/7/6 0006.
 */
@Setter
@Getter
public class DuoOptApiResult extends ToString {

    private String level;

    private String parent_opt_id;

    private String opt_name;

    private String opt_id;

}
