package com.fulihui.duoduoke.demo.web.security.common;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by fanjin on 2017-10-07.
 */
@Component
public class TimeProvider implements Serializable {

    private static final long serialVersionUID = -3301695478208950415L;

    /**
     * Now date.
     *
     * @return the date
     */
    public Date now() {
        return new Date();
    }
}