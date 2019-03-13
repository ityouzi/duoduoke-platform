package com.fulihui.redisdubbo.demo.security.common;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


/**
 * @author lizhi
 */
@Setter
@Getter
public class JwtAuthenticationRequest implements Serializable {

    private static final long serialVersionUID = 5447308950117921472L;
    private String accountNo;
    private String password;

    /**
     * Instantiates a new Jwt authentication request.
     */
    public JwtAuthenticationRequest() {
        super();
    }

    /**
     * Instantiates a new Jwt authentication request.
     *
     * @param accountNo the accountNo
     * @param password  the password
     */
    public JwtAuthenticationRequest(String accountNo, String password) {
        this.setAccountNo(accountNo);
        this.setPassword(password);
    }
}
