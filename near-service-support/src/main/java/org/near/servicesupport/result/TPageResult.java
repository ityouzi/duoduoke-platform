package org.near.servicesupport.result;

import java.util.List;

/**
 * 分页多泛型实例返回结果
 * Created by Willard.Hu on 2016/5/5.
 */
public class TPageResult<T> extends PageResult {
    private static final long serialVersionUID = -8398284666092886110L;
    private List<T>           values;

    public List<T> getValues() {
        return values;
    }

    public void setValues(List<T> values) {
        this.values = values;
    }
}
