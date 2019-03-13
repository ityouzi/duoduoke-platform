package org.near.webmvcsupport.security.model;

import org.near.toolkit.model.ToString;

/**
 * Basic auth 登录的员工模型
 * @author Created by Willard.Hu on 2016/7/29 0029.
 */
public class BasicAuthStaff extends ToString {
    private static final long serialVersionUID = 4043734084079174883L;
    /** 用户名 */
    private String            user;
    /** 密码 */
    private String            passwd;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}
