package com.ytx.example.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrier 中文名叫做屏障或者是栅栏，也可以用于线程间通信。
 * <p>
 * 它可以等待 N 个线程都达到某个状态后继续运行的效果。
 * <p>
 * 1.首先初始化线程参与者。
 * 2.调用 await() 将会在所有参与者线程都调用之前等待。
 * 3.直到所有参与者都调用了 await() 后，所有线程从 await() 返回继续后续逻辑。
 *
 * @author Rosan
 * @version 1.0
 * @date 2018/10/15
 */
public class CyclicBarrierThread {
    public static void main(String[] args) {
        cyclicBarrier();
    }

    private static void cyclicBarrier() {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
        new Thread(() -> {
            System.out.println("thread1 run");
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println("thread1 end do something");
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread2 run");
                try {
                    cyclicBarrier.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                System.out.println("thread2 end do something");
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread3 run");
                try {
                    Thread.sleep(5000);
                    cyclicBarrier.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("thread3 end do something");
            }
        }).start();
        System.out.println("main thread");
    }
}
