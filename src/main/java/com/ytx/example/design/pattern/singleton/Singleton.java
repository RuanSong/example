package com.ytx.example.design.pattern.singleton;

/**
 * 普通单例模式，首次加载较慢
 *
 * @author Rosan
 * @version 1.0
 * @date 2018/11/5
 */
public class Singleton {
    private static Singleton singleton = new Singleton();

    private Singleton() {
        System.out.println("Singleton");

    }

    public static Singleton getInstance() {
        return singleton;
    }
}
