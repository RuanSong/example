package com.ytx.example.unsafe.counter;

/**
 * @author Rosan
 * @version 1.0
 * @date 2018/10/17
 */
public class CounterClient implements Runnable {
    private ICounter c;
    private int num;

    public CounterClient(ICounter c, int num) {
        this.c = c;
        this.num = num;
    }

    @Override
    public void run() {
        for (int i = 0; i < num; i++) {
            c.increment();
        }
    }
}
