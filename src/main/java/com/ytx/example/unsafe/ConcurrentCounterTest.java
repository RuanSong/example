package com.ytx.example.unsafe;

import com.ytx.example.unsafe.counter.*;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Rosan
 * @version 1.0
 * @date 2018/10/17
 */
public class ConcurrentCounterTest {
    private static int NUMBER_OF_THREADS = 1000;
    private static int NUMBER_OF_INCREMENTS = 100000;

    public static void main(String[] args) throws Exception {
        System.out.println("except result: " + NUMBER_OF_THREADS * NUMBER_OF_INCREMENTS);
        testCounter(new StupidCounter());
        System.out.println("-----------------------------------------");
        testCounter(new SyncCounter());
        System.out.println("-----------------------------------------");
        testCounter(new LockCounter());
        System.out.println("-----------------------------------------");
        testCounter(new AtomicCounter());
        System.out.println("-----------------------------------------");
        testCounter(new CASCounter());
    }

    public static void testCounter(ICounter counter) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < NUMBER_OF_THREADS; i++) {
            service.submit(new CounterClient(counter, NUMBER_OF_INCREMENTS));
        }
        service.shutdown();
        service.awaitTermination(1, TimeUnit.MINUTES);
        long endTime = System.currentTimeMillis();
        System.out.println(counter.getName() + " result: " + counter.getCounter());
        System.out.println(counter.getName() + " result is " + (counter.getCounter() == NUMBER_OF_INCREMENTS * NUMBER_OF_THREADS));
        System.out.println(counter.getName() + " time passed in ms:" + (endTime - startTime));

    }
}
