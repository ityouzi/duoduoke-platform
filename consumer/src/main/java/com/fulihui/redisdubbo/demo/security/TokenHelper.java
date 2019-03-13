package com.fulihui.redisdubbo.demo.security;


import com.fulihui.redisdubbo.demo.security.common.AuthUserModel;
import com.fulihui.redisdubbo.demo.security.common.TimeProvider;
import com.google.common.collect.Maps;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;


/**
 * The type Token helper.
 *
 * @author lizhi
 */
@Component
public class TokenHelper {
    private static final Logger LOGGER = LoggerFactory.getLogger(TokenHelper.class);

    @Value("${spring.application.name}")
    private String APP_NAME;

    /**
     * The Secret.
     */
    @Value("${jwt.secret}")
    public String SECRET;

    @Value("${jwt.expires_in}")
    private int EXPIRES_IN;

    @Value("${jwt.mobile_expires_in}")
    private int MOBILE_EXPIRES_IN;

    @Value("${jwt.header}")
    private String AUTH_HEADER;

    /**
     * The Audience unknown.
     */
    static final String AUDIENCE_UNKNOWN = "unknown";
    /**
     * The Audience web.
     */
    static final String AUDIENCE_WEB = "web";
    /**
     * The Audience mobile.
     */
    static final String AUDIENCE_MOBILE = "mobile";
    /**
     * The Audience tablet.
     */
    static final String AUDIENCE_TABLET = "tablet";

    /**
     * The Claims password.
     */
    static final String CLAIMS_PASSWORD = "password";
    /**
     * The Time provider.
     */
    @Autowired
    TimeProvider timeProvider;

    private SignatureAlgorithm SIGNATURE_ALGORITHM = SignatureAlgorithm.HS512;

    /**
     * Gets account no from token.
     *
     * @param token the token
     * @return the account no from token
     */
    public String getAccountNoFromToken(String token) {
        String accountNo;
        try {
            final Claims claims = this.getAllClaimsFromToken(token);
            accountNo = claims.getSubject();
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            accountNo = null;
        }
        return accountNo;
    }


    /**
     * Refresh token string.
     *
     * @param token the token
     * @return the string
     */
    public String refreshToken(String token) {
        String refreshedToken;
        Date a = timeProvider.now();
        try {
            final Claims claims = getAllClaimsFromToken(token);
            claims.setIssuedAt(a);
            refreshedToken = Jwts.builder()
                    .setClaims(claims)
                    .signWith(SIGNATURE_ALGORITHM, SECRET)
                    .compact();
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            refreshedToken = null;
        }
        return refreshedToken;
    }

    /**
     * Generate token string.
     *
     * @param accountNo the accountNo
     * @param password  the password
     * @return the string
     */
    public String generateToken(String accountNo, String password) {
        Map<String, Object> claims = Maps.newHashMap();
        claims.put(Claims.ISSUER, APP_NAME);
        claims.put(Claims.SUBJECT, accountNo);

        claims.put(Claims.ISSUED_AT, timeProvider.now());
        claims.put(CLAIMS_PASSWORD, password);
        return Jwts.builder().setClaims(claims)
                .signWith(SIGNATURE_ALGORITHM, SECRET)
                .compact();
    }


    private Claims getAllClaimsFromToken(String token) {
        Claims claims;
        try {
            claims = Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            claims = null;
        }
        return claims;
    }


    /**
     * Gets expired in.
     *
     * @param device the device
     * @return the expired in
     */


    /**
     * 验证token
     *
     * @param token       the token
     * @param userDetails the user details
     * @return the boolean
     */
    public Boolean validateToken(String token, UserDetails userDetails) {
        AuthUserModel user = (AuthUserModel) userDetails;
        final String userId = getAccountNoFromToken(token);
        //相同的帐号
        return (userId != null && userId.equals(userDetails.getUsername()));
    }


    /**
     * Gets token.
     *
     * @param request the request
     * @return the token
     */
    public String getToken(HttpServletRequest request) {
        String authHeader = getAuthHeaderFromHeader(request);
        LOGGER.info("获取请求header-token值:{}", authHeader);
        return authHeader;
    }

    /**
     * Gets auth header from header.
     *
     * @param request the request
     * @return the auth header from header
     */
    public String getAuthHeaderFromHeader(HttpServletRequest request) {
        return request.getHeader(AUTH_HEADER);
    }

}