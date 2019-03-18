package com.fulihui.duoduoke.demo.producer.job.schedule;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by lizhi on 2018-10-16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootApplication
@EnableTransactionManagement
@ComponentScan(basePackages = { "com.fulihui.duoduoke" })

public class SignAwardSettlementJobTest {

    @Test
    public void execute() {
    }
}