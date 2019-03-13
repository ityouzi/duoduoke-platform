/*
 * Copyright (c) 2017. Dawn Group.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.fulihui.duoduoke.demo.common.sequence;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 计数器序列
 * @author Willard.Hu on 2017/10/30.
 */
public class CounterSequence implements Sequence<Long> {
    /** 计数器 */
    private AtomicLong counter;
    /** 跨步 */
    private int        step;

    /**
     * 无参构造函数，默认0开始，步长为1
     */
    public CounterSequence() {
        this(0, 1);
    }

    /**
     * 构造函数，指定默认值，步长为1
     * @param start 起始值
     */
    public CounterSequence(long start) {
        this(start, 1);
    }

    /**
     * 构造函数，指定步长，默认0开始
     * @param step 步长
     */
    public CounterSequence(int step) {
        this(0, step);
    }

    /**
     * 构造函数，指定步长和起始值
     * @param start 起始值
     * @param step 步长
     */
    public CounterSequence(long start, int step) {
        counter = new AtomicLong(start);
        this.step = step;
    }

    @Override
    public Long nextId() {
        return counter.addAndGet(step);
    }
}
