package org.near.webmvcsupport.view;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Created by Willard.Hu on 2016/7/28 0028.
 */
public class JsonResultBuilderTest {
    private final transient Logger LOG = LoggerFactory.getLogger(getClass());

    @Test
    public void test_succ_t() {
        JsonResult<String> jsonResult = JsonResultBuilder.succ("data");
        LOG.info("{}", jsonResult);
    }

    @Test
    public void test_succ() {
        JsonResult jsonResult = JsonResultBuilder.succ();
        LOG.info("{}", jsonResult);
    }

    @Test
    public void test_fail_t() {
        JsonResult<String> jsonResult = JsonResultBuilder.fail("err", "err");
        LOG.info("{}", jsonResult);
    }

    @Test
    public void test_fail() {
        JsonResult jsonResult = JsonResultBuilder.fail("err", "err");
        LOG.info("{}", jsonResult);
    }

}
