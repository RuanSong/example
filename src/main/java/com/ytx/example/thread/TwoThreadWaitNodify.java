package com.ytx.example.thread;

/**
 * 这里的线程 A 和线程 B 都对同一个对象 TwoThreadWaitNotify.class 获取锁，A 线程调用了同步对象的 wait() 方法释放了锁并进入 WAITING 状态。
 * <p>
 * B 线程调用了 notify() 方法，这样 A 线程收到通知之后就可以从 wait() 方法中返回。
 * <p>
 * 这里利用了 TwoThreadWaitNotify.class 对象完成了通信。
 * <p>
 * 有一些需要注意:
 * <p>
 * 1.wait() 、nofify() 、nofityAll() 调用的前提都是获得了对象的锁(也可称为对象监视器)。
 * 2.调用 wait() 方法后线程会释放锁，进入 WAITING 状态，该线程也会被移动到等待队列中。
 * 3.调用 notify() 方法会将等待队列中的线程移动到同步队列中，线程状态也会更新为 BLOCKED
 * 4.从 wait() 方法返回的前提是调用 notify() 方法的线程释放锁，wait() 方法的线程获得锁。
 * 等待通知有着一个经典范式：
 * <p>
 * 线程 A 作为消费者：
 * <p>
 * 获取对象的锁。
 * 进入 while(判断条件)，并调用 wait() 方法。
 * 当条件满足跳出循环执行具体处理逻辑。
 * 线程 B 作为生产者:
 * <p>
 * 获取对象锁。
 * 更改与线程 A 共用的判断条件。
 * 调用 notify() 方法。
 * 伪代码如下:
 * <p>
 * //Thread A
 * <p>
 * synchronized(Object){
 * while(条件){
 * Object.wait();
 * }
 * //do something
 * }
 * <p>
 * //Thread B
 * synchronized(Object){
 * 条件=false;//改变条件
 * Object.notify();
 * }
 *
 * @author Rosan
 * @version 1.0
 * @date 2018/10/14
 */
public class TwoThreadWaitNodify {
    private int start = 1;
    private boolean flag = false;

    public static void main(String[] args) {
        TwoThreadWaitNodify twoThreadWaitNodify = new TwoThreadWaitNodify();
        Thread ouNumThread = new Thread(new OuNum(twoThreadWaitNodify));
        ouNumThread.setName("线程A");
        Thread jiNumThread = new Thread(new JiNum(twoThreadWaitNodify));
        jiNumThread.setName("线程B");
        ouNumThread.start();
        jiNumThread.start();
    }

    /**
     * 偶数线程
     */
    public static class OuNum implements Runnable {
        private TwoThreadWaitNodify number;

        public OuNum(TwoThreadWaitNodify number) {
            this.number = number;
        }

        public void run() {
            //线程执行条件
            while (number.start <= 100) {
                System.out.println("偶数线程抢到锁了");
                //获取线程对象锁
                synchronized (TwoThreadWaitNodify.class) {
                    //判断执行条件
                    if (number.flag) {
                        System.out.println(Thread.currentThread().getName() + "++偶数" + number.start);
                        number.start++;
                        number.flag = false;
                        //释放锁，notify()放啊发执行后线程更新为BLOCKED装阿嚏
                        TwoThreadWaitNodify.class.notify();
                    } else {
                        try {
                            //不满足执行条件继续等待，wait()方法执行后线程进入 WAITING状态
                            TwoThreadWaitNodify.class.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    /**
     * 奇数线程
     */
    public static class JiNum implements Runnable {
        private TwoThreadWaitNodify number;

        public JiNum(TwoThreadWaitNodify number) {
            this.number = number;
        }

        public void run() {
            //线程执行条件
            while (number.start <= 100) {
                //获取线程对象锁
                synchronized (TwoThreadWaitNodify.class) {
                    System.out.println("奇数线程抢到锁了");
                    //判断执行条件
                    if (!number.flag) {
                        System.out.println(Thread.currentThread().getName() + "++奇数" + number.start);
                        number.start++;
                        number.flag = true;
                        //释放锁，notify()放啊发执行后线程更新为BLOCKED装阿嚏
                        TwoThreadWaitNodify.class.notify();
                    } else {
                        try {
                            //不满足执行条件继续等待，wait()方法执行后线程进入 WAITING状态
                            TwoThreadWaitNodify.class.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
