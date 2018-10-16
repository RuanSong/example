package com.ytx.example.thread;

import java.util.HashMap;
import java.util.Objects;
import java.util.UUID;

/**
 * @author Rosan
 * @version 1.0
 * @date 2018/10/15
 */
public class HashMapThread {
    public static void main(String[] args) {
        final HashMap<String, String> map = new HashMap<String, String>();
        for (int i = 0; i < 100000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    map.put(UUID.randomUUID().toString(), "");
                }
            }).start();
        }
    }
}
