package com.fulihui.redisdubbo.demo.weixin.weixin.util;


import org.near.toolkit.model.ToString;

import lombok.Getter;
import lombok.Setter;

/**
 * @author lizhi
 */
@Setter
@Getter
public class CertInfo extends ToString {
    private static final long serialVersionUID = -8044151685114698428L;
    private String certFile;
    private String certPwd;

}
