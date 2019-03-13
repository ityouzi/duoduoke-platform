package org.near.servicesupport.result;

/**
 * 单个泛型实例返回结果
 * Created by Willard.Hu on 2016/5/5.
 */
public class TSingleResult<T> extends BaseResult {
    private static final long serialVersionUID = 4648290766510705991L;
    private T                 value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
