package com.ytx.example.thread;

/**
 *
 * 在 t1.join() 时会一直阻塞到 t1 执行完毕，所以最终主线程会等待 t1 和 t2 线程执行完毕。
 *
 * 其实从源码可以看出，join() 也是利用的等待通知机制：
 *
 * 核心逻辑:
 *
 *     while (isAlive()) {
 *         wait(0);
 *     }
 * 在 join 线程完成后会调用 notifyAll() 方法，是在 JVM 实现中调用，所以这里看不出来。
 *
 * Join 线程
 * @author Rosan
 * @version 1.0
 * @date 2018/10/14
 */
public class JoinThread {
    public static void main(String[] args) throws InterruptedException {
        join();
    }
    public static void join() throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"-running");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName()+"-running2");
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        t2.start();
        //等待线程1终止
        t1.join();
        //等待线程2终止
        t2.join();
        System.out.println("主线程结束");
    }
}
