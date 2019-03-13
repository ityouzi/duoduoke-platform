package com.fulihui.duoduoke.demo.web.weixin.duoduoapi.result;

import org.near.toolkit.model.ToString;

/**
 * Created by lizhi on 2018/7/6 0006.
 */
public class DuoduoOptApiResult extends ToString{

    private String level;

    private String parent_opt_id;

    private String opt_name;

    private String opt_id;

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getParent_opt_id() {
        return parent_opt_id;
    }

    public void setParent_opt_id(String parent_opt_id) {
        this.parent_opt_id = parent_opt_id;
    }

    public String getOpt_name() {
        return opt_name;
    }

    public void setOpt_name(String opt_name) {
        this.opt_name = opt_name;
    }

    public String getOpt_id() {
        return opt_id;
    }

    public void setOpt_id(String opt_id) {
        this.opt_id = opt_id;
    }
}
