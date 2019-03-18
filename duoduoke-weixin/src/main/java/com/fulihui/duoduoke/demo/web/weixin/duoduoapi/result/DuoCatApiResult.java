package com.fulihui.duoduoke.demo.web.weixin.duoduoapi.result;

import org.near.toolkit.model.ToString;

/**
 * Created by lizhi on 2018/7/6 0006.
 */
public class DuoCatApiResult extends ToString{

    private String level;

    private String parent_cat_id;

    private String cat_name;

    private String cat_id;

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getParent_cat_id() {
        return parent_cat_id;
    }

    public void setParent_cat_id(String parent_cat_id) {
        this.parent_cat_id = parent_cat_id;
    }

    public String getCat_name() {
        return cat_name;
    }

    public void setCat_name(String cat_name) {
        this.cat_name = cat_name;
    }

    public String getCat_id() {
        return cat_id;
    }

    public void setCat_id(String cat_id) {
        this.cat_id = cat_id;
    }
}
