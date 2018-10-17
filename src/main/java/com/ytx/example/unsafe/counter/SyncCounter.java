package com.ytx.example.unsafe.counter;

/**
 * 同步数据统计
 *
 * @author Rosan
 * @version 1.0
 * @date 2018/10/17
 */
public class SyncCounter implements ICounter {
    private long counter = 0;

    @Override
    public String getName() {
        return "SyncCounter";
    }

    @Override
    public synchronized void increment() {
        counter++;
    }

    @Override
    public long getCounter() {
        return counter;
    }
}
