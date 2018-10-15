package com.ytx.example.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * CountDownLatch 也是基于 AQS(AbstractQueuedSynchronizer) 实现的，更多实现参考 ReentrantLock 实现原理
 * <p>
 * 初始化一个 CountDownLatch 时告诉并发的线程，然后在每个线程处理完毕之后调用 countDown() 方法。
 * 该方法会将 AQS 内置的一个 state 状态 -1 。
 * 最终在主线程调用 await() 方法，它会阻塞直到 state == 0 的时候返回。
 *
 * @author Rosan
 * @version 1.0
 * @date 2018/10/14
 */
public class CountDownLatchThread {
    public static void main(String[] args) throws InterruptedException {
        countDownLatch();
    }

    private static void countDownLatch() throws InterruptedException {
        int thread = 3;
        long start = System.currentTimeMillis();
        final CountDownLatch countDownLatch = new CountDownLatch(thread);
        for (int i = 0; i < thread; i++) {
            int finalI = i;
            new Thread(() -> {
                System.out.println("thread" + finalI + "- run");
                try {
                    TimeUnit.SECONDS.sleep(3);
                    countDownLatch.countDown();
                    System.out.println("thread " + finalI + " - end");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        countDownLatch.await();
        long stop = System.currentTimeMillis();
        System.out.println("主线程执行完毕,time:" + (stop - start));
    }

}
