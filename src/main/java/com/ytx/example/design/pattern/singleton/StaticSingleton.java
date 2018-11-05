package com.ytx.example.design.pattern.singleton;

/**
 * 内部类方式单例，加载时间较快，也不会有多线程问题
 *
 * @author Rosan
 * @version 1.0
 * @date 2018/11/5
 */
public class StaticSingleton {
    private StaticSingleton() {
        System.out.println("static Singleton");
    }

    private static class SingletonHolder {
        private static StaticSingleton instance = new StaticSingleton();
    }

    public static StaticSingleton getInstance() {
        return SingletonHolder.instance;
    }
}
