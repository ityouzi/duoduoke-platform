package com.fulihui.duoduoke.demo.web.security;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;


/**
 * @author lizhi
 */
public class TokenBasedAuthentication extends AbstractAuthenticationToken {

    private static final long serialVersionUID = 3985353406899799774L;
    private String token;
    private final UserDetails principle;

    /**
     * Instantiates a new Token based authentication.
     *
     * @param principle the principle
     */
    public TokenBasedAuthentication(UserDetails principle) {
        super(principle.getAuthorities());
        this.principle = principle;
    }

    /**
     * Gets token.
     *
     * @return the token
     */
    public String getToken() {
        return token;
    }

    /**
     * Sets token.
     *
     * @param token the token
     */
    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public boolean isAuthenticated() {
        return true;
    }

    @Override
    public Object getCredentials() {
        return token;
    }

    @Override
    public UserDetails getPrincipal() {
        return principle;
    }

}
