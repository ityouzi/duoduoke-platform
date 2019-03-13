package org.near.toolkit.validate;

import org.near.toolkit.common.StringUtil;
import org.near.toolkit.model.Money;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 数据格式校验类。
 * 该数据格式校验类包含如下通用方法
 * <li>判断输入的字符串是否和传入的正则是否匹配</li>
 * <li>判断输入的字符串是否是合法用户姓名,长度未限制</li>
 * <li>判断输入的字符串是否是合法email格式,长度未限制</li>
 * <li>判断输入的字符串是否是手机号码格式</li>
 * <li>判断输入的字符串是否是合法的固话</li>
 * <li>判断是否是合法的金额</li>
 * <li>利用money类转换判断输入的金额书否合法</li>
 */
public class ValidateUtil {

    /**手机格式的正则表达式*/
    public final static String REGEX_MOBILE            = "^1\\d{10}$";

    /**国外手机格式的正则表达式*/
    public final static String REGEX_FOREIGN_MOBILE    = CommonValidateUtil.REGEX_FOREIGN_MOBILE;

    /**支付宝登录号的正则表达式*/
    public final static String REGEX_LOGON_ID          = CommonValidateUtil.REGEX_LOGON_ID;

    /**手机6位数字校验码*/
    public final static String REGUX_VALIDATE_CODE     = "^\\d{6}$";

    /**16位纯数字流水号*/
    public final static String REGEX_VALIDATE_BIZ_NO   = "^\\d{16}$";

    /**4位图片校验码*/
    public final static String REGEX_PIC_CODE          = "^\\d{4}$";

    /**电话号码，只能由数字和"-"组成,6到25位。*/
    public final static String REGEX_PHONE             = "^[0-9,-]{6,25}$";

    /**电话号码，只能由数字和"-"组成,6到20位，或者为空。*/
    public final static String REGEX_PHONE_NULL        = "^[0-9,-]{6,20}$|^$";

    /**邮政编码,只能6位数字*/
    public final static String POST                    = "^\\d{1,6}$";

    /**用户姓名,只能由中文汉字、大写英文字母或.构成*/
    public final static String REGEX_USER_NAME         = "^[\u4e00-\u9fa5,0-9,a-z,A-Z,.]+$";

    /** 业务编码，只能由字母和数字组成 */
    public final static String REGEX_BIZ_CODE          = "^[0-9,a-z,A-Z]+$";

    /**资金账户备注名 只能由中文汉字，大小写英文字母，数字和指定特殊字符*/
    public final static String REGEX_ACCOUNT_MEMO      = "^(\\d)?[\u4e00-\u9fa5,0-9,a-z,A-Z]+$";

    /**纯数字*/
    public final static String NUM                     = "^(\\d)*$";

    /**金额，类似于-135,342,12.954*/
    public final static String REGEX_VALIDATE_MONEY    = "^[+-]?\\d+(,\\d{3})*(\\.\\d+)?$";

    /**手机动态口令，可以不输入，输入长度只能数字长度6位*/
    public final static String MOBILE_PROTECT_ACK_CODE = "^\\d{0}|\\d{6}$";

    /** URL地址校验*/
    public final static String URL_VALIDATE_CODE       = "^([a-zA-z]+://)?(\\w+(-\\w+)*)(\\.(\\w+(-\\w+)*))*(\\?\\S*)?$";

    /** 日期格式校验。格式为yyyy-MM-dd */
    public final static String WEB_DATE_VALIDATE       = "^[0-9]{4}(\\-)(((0[13578]|(10|12))(\\-)(0[1-9]|[1-2][0-9]|3[0-1]))|(02(\\-)(0[1-9]|[1-2][0-9]))|((0[469]|11)(\\-)(0[1-9]|[1-2][0-9]|3[0])))";

    /** 日期格式校验。格式为yyyy.MM.dd */
    public final static String SHORT_WEB_DATE_VALIDATE = "^[0-9]{4}(\\.)(((0[13578]|(10|12))(\\.)(0[1-9]|[1-2][0-9]|3[0-1]))|(02(\\.)(0[1-9]|[1-2][0-9]))|((0[469]|11)(\\.)(0[1-9]|[1-2][0-9]|3[0])))";

    /**
     * <pre>
     * 判断输入的字符串是否和传入的正则是否匹配
     * </pre>
     *
     * @param src 待判断的输入字符串
     * @param reg 正则表达式
     * @return True:输入的字符串是否和传入的正则匹配
     *         False:输入的字符串是否和传入的正则不匹配
     */
    public static boolean isValidReg(String src, String reg) {
        // 无效的输入，直接返回false
        if (StringUtil.isBlank(src)) {
            return false;
        }
        Pattern p = Pattern.compile(reg);
        Matcher pm = p.matcher(src);
        return pm.matches();
    }

    /**
     * 判断输入的字符串是否是有效的业务编号
     *
     * @param src
     * @return
     */
    public static boolean isValidBizCode(String src) {
        // 无效的输入，直接返回false
        if (StringUtil.isBlank(src)) {
            return false;
        }
        Pattern p = Pattern.compile(REGEX_BIZ_CODE);
        Matcher pm = p.matcher(src);
        return pm.matches();
    }

    /**
     * 判断是否是数字
     *
     * @param src
     * @return
     */
    public static boolean isNumber(String src) {
        // 无效的输入，直接返回false
        if (StringUtil.isBlank(src)) {
            return false;
        }
        Pattern p = Pattern.compile(NUM);
        Matcher pm = p.matcher(src);
        return pm.matches();
    }

    /**
     * <pre>
     * 判断输入的字符串是否是合法用户姓名,长度未限制
     * </pre>
     *
     * @param src 待判断的输入字符串
     * @return True:是合法的用户姓名;False:不是合法的用户姓名
     */
    public static boolean isValidUserName(String src) {
        // 无效的输入，直接返回false
        if (StringUtil.isBlank(src)) {
            return false;
        }
        Pattern p = Pattern.compile(REGEX_USER_NAME);
        Matcher pm = p.matcher(src);
        return pm.matches();
    }

    /**
     * <pre>
     * 判断输入的字符串是否是合法email格式,长度未限制
     * </pre>
     *
     * @param src 待判断的输入字符串
     * @return True:是合法的email;False:不是合法的email
     */
    public static boolean isValidEmail(String src) {
        // 无效的输入，直接返回false
        if (StringUtil.isBlank(src)) {
            return false;
        }
        Pattern p = Pattern.compile(REGEX_LOGON_ID);
        Matcher pm = p.matcher(src);
        return pm.matches();
    }

    /**
     * <pre>
     * 判断输入的字符串是否是手机号码格式
     * </pre>
     * 国内手机号验证规则
     * @param src 待判断的输入字符串
     * @return True:是合法的手机号码;False:不是合法的手机号码
     */
    public static boolean isValidMobile(String src) {
        // 无效的输入，直接返回false
        if (StringUtil.isBlank(src)) {
            return false;
        }
        Pattern p = Pattern.compile(REGEX_MOBILE);
        Matcher pm = p.matcher(src);
        return pm.matches();
    }

    /**
     * <pre>
     * 判断输入的字符串是否是手机号码格式
     * </pre>
     * 国外手机号验证规则
     * @param src 待判断的输入字符串
     * @return True:是合法的手机号码;False:不是合法的手机号码
     */
    public static boolean isValidForeignMobile(String src) {
        // 无效的输入，直接返回false
        if (StringUtil.isBlank(src)) {
            return false;
        }
        Pattern p = Pattern.compile(REGEX_FOREIGN_MOBILE);
        Matcher pm = p.matcher(src);
        return pm.matches();
    }

    /**
     * 是否是完整的电话号码
     *
     * @param src
     * @return
     */
    public static boolean isValidFullPhone(String src) {
        if (!isValidPhone(src)) {
            return false;
        }
        String[] numbers = StringUtil.split(src, "-");
        if (numbers.length > 3 || numbers.length < 2) {
            return false;
        }
        String areaCode = numbers[0];
        String phone = numbers[1];
        String extenCode = null;
        if (numbers.length == 3) {
            extenCode = numbers[2];
        }
        if (areaCode.length() > 4 || areaCode.length() < 3) {
            return false;
        }
        if (phone.length() > 8 || phone.length() < 7) {
            return false;
        }
        if (StringUtil.isNotBlank(extenCode) && extenCode.length() > 8) {
            return false;
        }
        return true;
    }

    /**
     * <pre>
     * 判断输入的字符串是否是合法的固话
     * </pre>
     *
     * @param src 待判断的输入字符串
     * @return True:合法;False:不合法
     */
    public static boolean isValidPhone(String src) {
        // 无效的输入，直接返回false
        if (StringUtil.isBlank(src)) {
            return false;
        }
        Pattern p = Pattern.compile(REGEX_PHONE);
        Matcher pm = p.matcher(src);
        return pm.matches();
    }

    /**
     * <pre>
     * 判断输入的字符串是否是合法的支付宝登录号
     * </pre>
     *
     * 支付宝登录号有两种格式。其一是手机号码；其二是Email（长度未限制）
     * @param src 待判断的输入字符串
     * @return True:是合法的登录号;False:不是合法的登录号
     */
    public static boolean isValidLogonId(String src) {
        // 无效的输入，直接返回false
        if (StringUtil.isBlank(src)) {
            return false;
        }
        Pattern p = Pattern.compile(REGEX_LOGON_ID);
        Matcher pm = p.matcher(src);
        return pm.matches();
    }

    /**
     * <pre>
     * 判断是否是合法的流水号，标准:流水号为16位纯数字
     * </pre>
     *
     * @param src 待判断的输入字符串
     * @return true是合法的流水号;false表示不是合法的流水号
     */
    public static boolean isValidBizNo(String src) {
        // 输入为空则直接返回false
        if (StringUtil.isBlank(src)) {
            return false;
        }

        Pattern p = Pattern.compile(REGEX_VALIDATE_BIZ_NO);
        Matcher pm = p.matcher(src);
        return pm.matches();
    }

    /**
     * <pre>
     * 判断是否是合法的金额，标准:
     * </pre>
     *
     * <ul>
     * <li>不为空</li>
     * <li>允许3个连续数字用,分隔</li>
     * <li>允许小数点</li>
     * <li>小数位允许超过多为的数字(多余2位将四舍五入)</li>
     * <li>允许正负金额</li>
     * </ul>
     * @param src 待判断的输入字符串
     * @return true表示是合法的金额;false表示不是合法的金额
     */
    public static boolean isValidMoney(String src) {
        // 无效的输入，直接返回false
        if (StringUtil.isBlank(src)) {
            return false;
        }

        Pattern p = Pattern.compile(REGEX_VALIDATE_MONEY);
        Matcher pm = p.matcher(src);
        return pm.matches();
    }

    /**
     *  <pre>
     * 第二种判断是否是合法的金额的方法，利用转化为Money对象的正确与否。注意:<br/>
     * 这样不能判别,分隔的多个数字情形，只是全部忽略掉。<li>
     *  </pre>
     *
     * @param src 待判断的输入字符串
     * @return true表示是合法的金额;false表示不是合法的金额
     */
    public static boolean isValidMoney2(String src) {
        // 无效的输入，直接返回false
        if (StringUtil.isBlank(src)) {
            return false;
        }

        String inSrc = StringUtil.replaceChars(src, ",", "");

        // 全部是,的，直接返回false
        if (StringUtil.isBlank(inSrc)) {
            return false;
        }

        try {
            new Money(inSrc);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    /**
     * 判断字符串
     *
     * @param str
     * @param minLength
     * @param maxLength
     * @return
     */
    public static boolean isValidLength(String str, int minLength, int maxLength) {
        int resultLength = 0;
        if (str == null) {
            resultLength = 0;
        } else {
            char[] s = str.toCharArray();
            resultLength = s.length;
            for (int i = 0; i < s.length; i++) {
                if (isChineseChar(String.valueOf(s[i]))) {
                    resultLength++;
                }
            }
        }
        if (minLength <= resultLength && resultLength <= maxLength) {
            return true;
        } else {
            return false;
        }
    }

    /**
     *
     *
     * @param str
     * @return
     */
    private static boolean isChineseChar(String str) {
        boolean temp = false;
        Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
        Matcher m = p.matcher(str);
        if (m.find()) {
            temp = true;
        }
        return temp;
    }
}