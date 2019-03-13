package org.near.toolkit.model;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.regex.Pattern;

/**
 * 折扣类封装
 * Created by willa on 2015/12/24.
 */
public class Discount implements Serializable {
    private static final long    serialVersionUID = 7139811876159243916L;
    private static final Pattern checker          = Pattern.compile("^\\d|\\d\\.\\d$");

    private int                  value;

    public Discount() {
    }

    /**
     * 折扣字符串初始化折扣对象，如"8.5"、"7"、"9.5"
     */
    public static Discount valueOf(String value) {
        if (!checker.matcher(value).matches()) {
            throw new IllegalArgumentException("生成折扣错误，折扣必须时'#.#'或'#'的格式");
        }
        return valueOf((int) (Float.valueOf(value) * 10));
    }

    /**
     * 通过整形初始化生成折扣对象，如85，70, 95
     */
    public static Discount valueOf(int value) {
        if (value < 1 || value > 99) {
            throw new IllegalArgumentException("生成折扣错误，折扣值必须大于0，小于100");
        }
        Discount discount = new Discount();
        discount.value = value;
        return discount;
    }

    /**
     * 获取折扣价格，参数是单位为分的金额
     */
    public Money getDiscountPrice(long priceCent) {
        Money price = new Money();
        price.setCent(priceCent);
        return getDiscountPrice(price);
    }

    /**
     * 获取折扣价格，参数是 Money 对象
     */
    public Money getDiscountPrice(Money price) {
        if (price == null) {
            return null;
        }
        Money discountPrice = new Money();
        discountPrice.setCent(price.getCent() * this.value / 100);
        return discountPrice;
    }

    public String toString() {
        DecimalFormat df = new DecimalFormat("#.0");
        return df.format(value / 10.0);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
