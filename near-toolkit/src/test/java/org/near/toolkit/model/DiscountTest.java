package org.near.toolkit.model;

import org.junit.Test;

/**
 *
 * Created by willa on 2015/12/24.
 */
public class DiscountTest {

    @Test
    public void test_01() {
        Discount discount = Discount.valueOf(95);
        System.out.println(discount.getDiscountPrice(10000));
        System.out.println(discount.toString());
    }

    @Test
    public void test_02() {
        Discount discount = Discount.valueOf("8.5");
        System.out.println(discount.getDiscountPrice(10000));
        System.out.println(discount.toString());
    }

    @Test
    public void test_03() {
        Discount discount = Discount.valueOf("8");
        System.out.println(discount.getDiscountPrice(10000));
        System.out.println(discount.toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_e_01() {
        Discount.valueOf(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_e_02() {
        Discount.valueOf(100);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_e_03() {
        Discount.valueOf("10");
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_e_04() {
        Discount.valueOf("9.50");
    }
}
