package org.near.toolkit.common;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Created by Willard.Hu on 2016/6/8.
 */
public class RandomCharsetTest {
    private final transient Logger LOG = LoggerFactory.getLogger(getClass());

    @Test
    public void test_randomNumber() {
        for (int i = 0; i < 100; i++) {
            LOG.info("str:{}", RandomCharset.randomNumber(6));
        }
    }

    @Test
    public void test_randomLetter() {
        for (int i = 0; i < 100; i++) {
            LOG.info("str:{}", RandomCharset.randomLetter(6));
        }
    }

    @Test
    public void test_randomMixture() {
        for (int i = 0; i < 2; i++) {
            LOG.info("str:{}", RandomCharset.randomMixture(32));
        }
    }
}
