package org.near.servicesupport.request;

/**
 * 泛型分页查询请求
 * <p>使用 {@link PageRequest} 作为基类扩展</p>
 * Created by Willard.Hu on 2016/5/5.
 */

public class TPageRequest<T> extends PageRequest {
    private static final long serialVersionUID = -8011206062731891048L;
    private T condition;

    public T getCondition() {
        return condition;
    }

    public void setCondition(T condition) {
        this.condition = condition;
    }
}
