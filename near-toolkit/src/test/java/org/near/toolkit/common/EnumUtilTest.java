package org.near.toolkit.common;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Willard.Hu on 2015/8/3.
 */
public class EnumUtilTest {

    @Test
    public void test_queryByCode() {
        TestEnum testEnum = EnumUtil.queryByCode("A", TestEnum.class);
        Assert.assertTrue(testEnum != null);

        testEnum = EnumUtil.queryByCode("C", TestEnum.class);
        Assert.assertTrue(testEnum == null);
    }

}
