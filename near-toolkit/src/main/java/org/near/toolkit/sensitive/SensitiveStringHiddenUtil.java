package org.near.toolkit.sensitive;

import org.near.toolkit.common.StringUtil;
import org.near.toolkit.validate.ValidateUtil;
import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * 敏感字符串隐藏类。可以在本类上进行扩展调用
 */
public class SensitiveStringHiddenUtil {

    /** 大陆身份证号正则表达式 */
    private static final String  ID_CARD_REGEXP    = "[0-9]{15}|[0-9]{18}|[0-9]{14}X|[0-9]{17}X";
    /** 银行卡号正则表达式 */
    private static final String  BANK_CARD_REGEXP  = "[0-9]{13,19}";
    /** 手机正则表达式 */
    private static final String  PHONE_TEL_REGEXP  = "[0-9]{11}";
    /** 大陆身份证号匹配模式 */
    private static final Pattern ID_CARD_PATTERN   = Pattern.compile(ID_CARD_REGEXP);
    /** 银行卡号匹配模式 */
    private static final Pattern BANK_CARD_PATTERN = Pattern.compile(BANK_CARD_REGEXP);
    /** 手机正则表达式 */
    private static final Pattern PHONE_TEL_PATTERN = Pattern.compile(PHONE_TEL_REGEXP);

    /**
     * 简单判断是否为空字符串
     *
     * @param str
     * @return
     */
    private static boolean isBlank(String str) {
        return StringUtil.isBlank(str);
    }

    /**
     * 本方法通过正则表达式"[0-9]{15}|[0-9]{18}|[0-9]{14}X|[0-9]{17}X"来判断是否是合法的大陆身份证号。
     *
     * @param idCardNo
     * @return
     */
    public static boolean isIdCardNo(String idCardNo) {
        if (isBlank(idCardNo)) {
            return false;
        } else {
            Matcher matcher = ID_CARD_PATTERN.matcher(idCardNo.trim());
            return matcher.matches();
        }
    }

    /**
     * 本方法通过正则表达式"[0-9]{13,19}"来判断是否是合法的银行卡号。
     *
     * @param bankCardNo
     * @return
     */
    public static boolean isBankCardNo(String bankCardNo) {
        if (isBlank(bankCardNo)) {
            return false;
        } else {
            Matcher matcher = BANK_CARD_PATTERN.matcher(bankCardNo.trim());
            return matcher.matches();
        }
    }

    /**
     * 本方法通过正则表达式"[0-9]{11}"来判断是否是合法的手机号码。
     *
     * @param phoneOrTelNo
     * @return
     */
    public static boolean isPhoneOrTelNo(String phoneOrTelNo) {
        if (isBlank(phoneOrTelNo)) {
            return false;
        } else {
            Matcher matcher = PHONE_TEL_PATTERN.matcher(phoneOrTelNo.trim());
            return matcher.matches();
        }
    }

    /**
     * 本方法通过是否含有@符号，简单判断是否是Email地址。
     *
     * @param email
     * @return
     */
    public static boolean isEmail(String email) {
        return email.indexOf('@') > 0;
    }

    /**
     * 对支付宝登陆帐号进行部分隐藏处理：如果是手机号，显示前3和后4位；如果是email，只显示用户名的前3位+*+@域名；如果都不是，显示前3和后4位（不足7个字符的，全部显示，超过7个字符的，中间的用'*'代替）。<br/>
     *
     * @param logonId 待部分隐藏处理的支付宝登陆帐号，可能是手机号或email。
     * @return
     */
    public static String alipayLogonIdHide(String logonId) {
        if (isBlank(logonId)) {
            return logonId;
        }
        if (isEmail(logonId)) {
            return emailHide(logonId, false);
        } else {
            return phoneNoHide(logonId);
        }
    }

    /**
     * 对大陆身份证号进行部分隐藏处理，只显示前6位和后4位，其他用*代替。<br/>
     * 如果入参不是合法的大陆身份证号，将按敏感信息缺省隐藏方式处理，显示前1/3和后1/3，其他用*代替。<br/>
     *
     * @param idCardNo 待部分隐藏处理的身份证号。
     * @param doValidate 是否做身份证号合法性校验。警告：做校验会进行正则匹配，性能上比不做校验的方法略有损耗。
     * @return 如果hideFlag为true，返回符合《支付宝敏感信息日志打印规范》的身份证号部分展示字符串；否则返回原数据。
     *
     */
    public static String idCardNoHide(String idCardNo, boolean doValidate) {

        if (isBlank(idCardNo)) {
            return idCardNo;
        }

        if (doValidate) {
            if (!isIdCardNo(idCardNo)) {
                return defaultHide(idCardNo); // 不是大陆身份证号，按缺省的隐藏显示方法。
            }
        }
        return customizeHide(idCardNo, 6, 4, idCardNo.length() - 10);
    }

    /**
     * 对大陆身份证号进行部分隐藏处理的简便方法，默认不做验证，由使用者自己保障。
     *
     * @param idCardNo
     * @return
     */
    public static String idCardNoHide(String idCardNo) {
        return idCardNoHide(idCardNo, false);
    }

    /**
     * 对银行卡号进行部分隐藏处理，只显示后4位，其他用2个*代替。<br/>
     * 如果入参不是合法的银行号，将按敏感信息缺省隐藏方式处理，显示前1/3和后1/3，其他用*代替。<br/>
     *
     * @param bankCardNo 待部分隐藏处理的银行卡号。
     * @param doValidate 是否做银行卡号合法性校验。警告：做校验会进行正则匹配，性能上比不做校验的方法略有损耗。
     * @return 如果hideFlag为true，返回符合《支付宝敏感信息日志打印规范》的银行卡号部分展示字符串；否则返回原数据。
     */
    public static String bankCardNoHide(String bankCardNo, boolean doValidate) {

        if (isBlank(bankCardNo)) {
            return bankCardNo;
        }
        if (doValidate) {
            if (!isBankCardNo(bankCardNo)) {
                return defaultHide(bankCardNo); // 不是银行卡号，按缺省的隐藏显示方法。
            }
        }
        return customizeHide(bankCardNo, 0, 4, 2);
    }

    /**
     * 创建掩码卡号
     *
     * @param cardNo 卡号 如6225123412341234
     * @return 隐藏过后的卡号，如************1234
     */
    public static String maskCardNo(String cardNo) {
        //截取卡号，加入掩码
        int maskIndex = StringUtils.length(cardNo) - 4;
        if (maskIndex < 0) {
            maskIndex = 0;
        }
        return StringUtils.overlay(cardNo, StringUtils.repeat("*", maskIndex), 0, maskIndex);
    }

    /**
     * 对银行卡号进行部分隐藏处理的简便方法，默认不做验证，由使用者自己保障。
     *
     * @param bankCardNo
     * @return
     */
    public static String bankCardNoHide(String bankCardNo) {
        return bankCardNoHide(bankCardNo, false);
    }

    /**
     * 对手机号进行部分隐藏处理，手机号只显示前3位和后4位，其他用*代替。<br/>
     * 不支持带分机的电话号码，将按敏感信息缺省隐藏方式处理，显示前1/3和后1/3，其他用*代替。
     *
     * @param phoneNo 待处理的电话号码
     * @param doValidate 是否做电话号码合法性校验。警告：做校验会进行正则匹配，性能上比不做校验的方法略有损耗。
     * @return 如果hideFlag为true，返回《支付宝敏感信息日志打印规范》中推荐的电话号码部分展示字符串；否则返回原数据。
     */
    public static String phoneNoHide(String phoneNo, boolean doValidate) {
        if (isBlank(phoneNo)) {
            return phoneNo;
        }
        String tmp = phoneNo.trim();
        if (doValidate) {
            if (!isPhoneOrTelNo(tmp)) {
                return defaultHide(tmp); // 不是电话号码，按缺省的隐藏显示方法。
            }
        }
        return customizeHide(tmp, 3, 4, tmp.length() - 7);
    }

    /**
     * 对手机号进行部分隐藏处理的简便方法，默认不做验证，由使用者自己保障。
     *
     * @param phoneOrTelNo
     * @return
     */
    public static String phoneNoHide(String phoneOrTelNo) {
        return phoneNoHide(phoneOrTelNo, false);
    }

    /**
     * 对Email进行部分隐藏处理，只显示用户名的前3位+**+@域名。如用户名不足3位，将显示用户名全部+**+@域名。如果不是email（不含‘@’）,将按敏感信息缺省隐藏方式处理，显示前1/3和后1/3。
     *
     * @param email 待处理的Email
     * @param doValidate 是否做Email合法性校验。警告：做校验会进行正则匹配，性能上比不做校验的方法略有损耗。
     * @return 如果hideFlag为true，返回《支付宝敏感信息日志打印规范》中推荐的Email部分展示字符串；否则返回原数据。
     */
    public static String emailHide(String email, boolean doValidate) {
        if (isBlank(email)) {
            return email;
        }

        if (doValidate) {
            if (!isEmail(email)) {
                return defaultHide(email); // 不是email账号，按缺省的隐藏显示方法。
            }
        }
        String tmp = email.trim();
        int atPos = tmp.indexOf('@');
        int frontNum = atPos < 3 ? atPos : 3;
        return customizeHide(tmp, frontNum, tmp.length() - atPos, 2);
    }

    /**
     * 对Email进行部分隐藏处理的简便方法，默认不做验证，由使用者自己保障。
     *
     * @param email
     * @return
     */
    public static String emailHide(String email) {
        return emailHide(email, false);
    }

    /**
     * 对姓名进行部分隐藏,显示第一个字
     *
     * @param name
     * @return
     */
    public static String nameHide(String name) {
        if (isBlank(name)) {
            return name;
        }
        return customizeHide(name, 1, 0, 2);
    }

    /**
     * 敏感信息缺省隐藏方式处理：显示前1/3和后1/3，其他*号代替。内容长度不能被3整除时，显示前ceil[length/3.0]和后floor[
     * length/3.0]
     *
     * <pre>
     * SensitiveDataUtil.defaultHide("ttt") = "t*t"
     * SensitiveDataUtil.defaultHide("tttttttt") = "ttt***tt"
     * </pre>
     *
     * @param sensitiveData
     *            待部分隐藏处理的敏感信息。
     * @returns 屏蔽后的数据; 如果hideFlag为flase，返回原数据。
     */
    public static String defaultHide(String sensitiveData) {
        if (isBlank(sensitiveData)) {
            return sensitiveData;
        }
        String tmp = sensitiveData.trim();
        int length = tmp.length();
        int headNum = (int) Math.ceil(length * 1 / 3.0);
        int tailNum = (int) Math.floor(length * 1 / 3.0);
        return customizeHide(tmp, headNum, tailNum, length - headNum - tailNum);
    }

    /**
     * 自定义屏蔽位数和屏蔽位置
     *
     * <pre>
     * SensitiveDataUtil.customizeHide("13568794561",3,4,4) = "135****4561"
     * SensitiveDataUtil.customizeHide("13568794561",0,4,4) = "****4561"
     * SensitiveDataUtil.customizeHide("13568794561",3,0,4) = "135****"
     * SensitiveDataUtil.customizeHide("13568794561",3,0,8) = "135********"
     * </pre>
     *
     * @param sensitiveData
     *            原数据
     * @param frontCharNum
     *            展示前几位
     * @param tailCharNum
     *            展示后几位
     * @param hiddenCharNum
     *            展示星号*的个数
     * @return 部分隐藏的敏感数据字符串
     */
    public static String customizeHide(final String sensitiveData, final int frontCharNum,
                                       final int tailCharNum, final int hiddenCharNum) {
        if (isBlank(sensitiveData)) {
            return sensitiveData;
        }
        String tmp = sensitiveData.trim();
        int length = tmp.length();
        // 合法性检查，如果参数不合法，返回源数据内容
        if (frontCharNum < 0 || tailCharNum < 0 || hiddenCharNum < 0
                || frontCharNum + tailCharNum > length) {
            return tmp;
        }

        int beginIndex = frontCharNum - 1;
        int endIndex = length - tailCharNum;

        // 原数据前半部分
        StringBuilder result = new StringBuilder();
        if (beginIndex >= 0 && beginIndex < length)
            result.append(tmp.substring(0, frontCharNum));

        // 中间*
        for (int i = 0; i < hiddenCharNum; i++)
            result.append('*');

        // 原数据后半部分
        if (endIndex >= 0 && endIndex < length)
            result.append(tmp.substring(endIndex));

        return result.toString();
    }

    /**
     * 返回隐藏的手机号码
     * @param mobileNum 手机号码
     * @return 返回隐藏的手机号码
     */

    public static String getHiddenMobileNum(String mobileNum) {
        if (StringUtil.isBlank(mobileNum)) {
            return null;
        }
        boolean isMobile = ValidateUtil.isValidMobile(StringUtil.trim(mobileNum));
        if (!isMobile) {
            return null;
        }

        String hiddenMobileNum = StringUtil.overlay(mobileNum, "****", 3, 7);

        return hiddenMobileNum;

    }

    /**
     * 返回隐藏的手机号码，支持国际号码
     * @param mobileNum 手机号码
     * @return 返回隐藏的手机号码
     */
    public static String getHiddenMobileNumPlus(String mobileNum) {
        if (StringUtil.isBlank(mobileNum)) {
            return null;
        }
        int tagPos = StringUtil.indexOf(mobileNum, "-");

        // 不存在“-”的为国内号码
        if (tagPos == -1) {
            return StringUtil.overlay(mobileNum, "****", 3, 7);
        }
        // 存在“-”的为国际号码
        else {
            int len = mobileNum.length();
            int start = tagPos + 3;
            int end = len - 2;
            int strLen = len - start - 2;
            String str = StringUtil.repeat("*", strLen);
            return StringUtil.overlay(mobileNum, str, start, end);
        }
    }

}

