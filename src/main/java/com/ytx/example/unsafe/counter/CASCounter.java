package com.ytx.example.unsafe.counter;

import com.ytx.example.unsafe.UnSafeTest;
import sun.misc.Unsafe;

/**
 * CAS操作数据自增
 * <p>
 * CAS多线程下结果正确，速度适中,8000ms~9000ms
 *
 * @author Rosan
 * @version 1.0
 * @date 2018/10/17
 */
public class CASCounter implements ICounter {
    private volatile long counter = 0;
    private Unsafe unsafe;
    private long offset;

    public CASCounter() throws Exception {
        unsafe = UnSafeTest.getUnsafeInstance();
        offset = unsafe.objectFieldOffset(CASCounter.class.getDeclaredField("counter"));
    }

    @Override
    public String getName() {
        return "CASCounter";
    }

    @Override
    public void increment() {
        long before = counter;
        while (!unsafe.compareAndSwapLong(this, offset, before, before + 1)) {
            before = counter;
        }
    }

    @Override
    public long getCounter() {
        return counter;
    }
}
