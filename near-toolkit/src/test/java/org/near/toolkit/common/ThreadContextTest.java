package org.near.toolkit.common;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * @author Willard.Hu on 2016/11/15 0015.
 */
public class ThreadContextTest {

    /**
     * 10个线程并发测试实例创建的并发处理
     */
    @Test
    public void test_getInstance() {
        ExecutorService pool = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            pool.execute(() -> {
                ThreadContext instance = ThreadContext.getInstance();
                System.out.println(instance);
            });
        }
        pool.shutdown();
    }

    /**
     * 测试线程对象功能
     */
    @Test
    public void test_get_set() {
        ThreadContext context = ThreadContext.getInstance();
        ThreadContext context2 = new ThreadContext();
        context.setAttribute("KEY_1", "aaa");
        context2.setAttribute("KEY_2", "bbb");
        method(context, context2);
    }

    private void method(ThreadContext context, ThreadContext context2) {
        assertEquals("aaa", context.getAttribute("KEY_1"));
        assertEquals("bbb", context2.getAttribute("KEY_2"));

        assertNull(context.getAttribute("KEY_2"));
        assertNull(context2.getAttribute("KEY_1"));
    }
}
