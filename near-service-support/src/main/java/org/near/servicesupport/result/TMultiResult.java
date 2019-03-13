package org.near.servicesupport.result;

import java.util.List;

/**
 * 多泛型实例返回结果
 * Created by Willard.Hu on 2016/5/5.
 */
public class TMultiResult<T> extends BaseResult {
    private static final long serialVersionUID = 190397444860823473L;
    private List<T>           values;

    public List<T> getValues() {
        return values;
    }

    public void setValues(List<T> values) {
        this.values = values;
    }
}
