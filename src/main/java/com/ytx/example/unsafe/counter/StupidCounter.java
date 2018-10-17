package com.ytx.example.unsafe.counter;

/**
 * 无锁数据自增
 * 速度最快300~400ms，多线程环境下线程自增数量会出现问题，导致最终自增的记过不正确
 *
 * @author Rosan
 * @version 1.0
 * @date 2018/10/17
 */
public class StupidCounter implements ICounter {
    private long counter = 0;

    @Override
    public String getName() {
        return "StupidCounter";
    }

    @Override
    public void increment() {
        counter++;
    }

    @Override
    public long getCounter() {
        return counter;
    }
}
