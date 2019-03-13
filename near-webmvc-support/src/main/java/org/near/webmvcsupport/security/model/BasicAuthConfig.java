package org.near.webmvcsupport.security.model;

import java.util.List;

import org.near.toolkit.model.ToString;

/**
 * Basic auth 权限配置
 * @author Created by Willard.Hu on 2016/7/29 0029.
 */
public class BasicAuthConfig extends ToString {
    private static final long    serialVersionUID = 8355110553477547714L;

    /** 授权有效时间，单位（分） */
    private long                 authExpires;

    /** 员工权限列表 */
    private List<BasicAuthStaff> staffList;

    public long getAuthExpires() {
        return authExpires;
    }

    public void setAuthExpires(long authExpires) {
        this.authExpires = authExpires;
    }

    public List<BasicAuthStaff> getStaffList() {
        return staffList;
    }

    public void setStaffList(List<BasicAuthStaff> staffList) {
        this.staffList = staffList;
    }
}
