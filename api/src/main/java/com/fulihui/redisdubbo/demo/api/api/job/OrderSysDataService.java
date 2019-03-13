package com.fulihui.redisdubbo.demo.api.api.job;

import java.util.Date;

/**
 * @author wahaha
 */
public interface OrderSysDataService {

    void fetchColor(Date date, boolean ignoreModifyAt);
}
