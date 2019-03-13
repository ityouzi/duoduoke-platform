package org.near.servicesupport.request;

import org.near.toolkit.model.ToString;

/**
 * <p>泛型请求对象，已废弃，后续基础类只要继承 {@link ToString} 就行了，</p>
 * <p>服务请求通过 dubbo 自带的 rpc_access.log 功能记录</p>
 *
 * @author Willard.Hu
 * @date 2016/5/5
 */

public class TRequest<T> extends BaseRequest {
    private static final long serialVersionUID = 8256420723435390590L;
    private T condition;

    public T getCondition() {
        return condition;
    }

    public void setCondition(T condition) {
        this.condition = condition;
    }
}
