package org.near.toolkit.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by IntelliJ IDEA.
 * User:   lizhi
 * Date: 2018-6-1
 * Time: 10:41
 * @author lizhi
 */
public class DoMainUtil {

    private final static String REGEX_DOMAIN = "(?<=http://|\\.)[^.]*?\\.(com|cn|net|org|biz|info|cc|tv)";

    private static Pattern      p            = Pattern.compile(REGEX_DOMAIN,
        Pattern.CASE_INSENSITIVE);

    /**
     * 根据url地址获取域名
     * @param url  请求地址
     * @return 域名
     */
    public static String getDoMain(String url) {
        if (StringUtil.isBlank(url)) {
            return null;
        }
        Matcher matcher = p.matcher(url);
        if (matcher.find()) {
            return matcher.group();
        }
        return null;
    }
}
