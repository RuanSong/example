package com.ytx.example.thread;

import java.util.concurrent.TimeUnit;

/**
 * 这里的 flag 存放于主内存中，所以主线程和线程 A 都可以看到。
 *
 * flag 采用 volatile 修饰主要是为了内存可见性
 *
 * volatile
 *
 * @author Rosan
 * @version 1.0
 * @date 2018/10/14
 */
public class VolatileThread implements Runnable {
    private static volatile boolean flag = true;
    @Override
    public void run() {
        while(flag){
            System.out.println(Thread.currentThread().getName()+"正在运行");
        }
        System.out.println(Thread.currentThread().getName() +"执行完毕");
    }
    public static void main(String[] args) throws InterruptedException {
        VolatileThread aVolatileThread = new VolatileThread();
        new Thread(aVolatileThread,"thread A").start();
        System.out.println("main 线程正在运行") ;
        TimeUnit.MILLISECONDS.sleep(10) ;
        aVolatileThread.stopThread();
    }
    private void stopThread(){
        flag = false ;
    }

}
