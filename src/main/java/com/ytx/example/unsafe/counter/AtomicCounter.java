package com.ytx.example.unsafe.counter;


import java.util.concurrent.atomic.AtomicLong;

/**
 * 原子操作数据自增
 *
 * @author Rosan
 * @version 1.0
 * @date 2018/10/17
 */
public class AtomicCounter implements ICounter {
    private AtomicLong counter = new AtomicLong(0);

    @Override
    public String getName() {
        return "AtomicCounter";
    }

    @Override
    public void increment() {
        counter.incrementAndGet();
    }

    @Override
    public long getCounter() {
        return counter.get();
    }
}
