package com.fulihui.duoduoke.demo.producer.config;

import com.fulihui.duoduoke.demo.common.sequence.ConcurrentSequence;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;


/**
 * The type Concurrent sequence config.
 *
 * @author lizhi
 * @date
 */
@Configuration
public class ConcurrentSequenceConfig {
    /**
     * Concurrent sequence concurrent sequence.
     *
     * @param environment the environment
     * @return the concurrent sequence
     */
    @Bean
    public ConcurrentSequence concurrentSequence(Environment environment) {
        Long workId = environment.getProperty("sequence.workerId", Long.class);
        return new ConcurrentSequence(workId);
    }

    /**
     * Thread pool task executor thread pool task executor.
     *
     * @return the thread pool task executor
     */


}
