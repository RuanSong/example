package com.ytx.example.unsafe.counter;

/**
 * 同步数据统计
 * 方法同步速度最慢19000~24000ms，结果是正确的
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
