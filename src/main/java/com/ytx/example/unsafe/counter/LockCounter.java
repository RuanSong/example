package com.ytx.example.unsafe.counter;


import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 写锁数据自增
 *
 * @author Rosan
 * @version 1.0
 * @date 2018/10/17
 */
public class LockCounter implements ICounter {
    private long counter = 0;
    private ReentrantReadWriteLock.WriteLock lock = new ReentrantReadWriteLock().writeLock();

    @Override
    public String getName() {
        return "LockCounter";
    }

    @Override
    public void increment() {
        lock.lock();
        counter++;
        lock.unlock();
    }

    @Override
    public long getCounter() {
        return counter;
    }
}
