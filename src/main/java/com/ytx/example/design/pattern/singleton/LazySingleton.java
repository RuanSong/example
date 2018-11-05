package com.ytx.example.design.pattern.singleton;

/**
 * 延时单例，首次加载较快，解决了延时加载问题，多线程并发环境下会比较慢
 *
 * @author Rosan
 * @version 1.0
 * @date 2018/11/5
 */
public class LazySingleton {
    private static LazySingleton lazySingleton = null;

    private LazySingleton() {
        System.out.println("LazySingleton");
    }

    public static synchronized LazySingleton getInstance() {
        if (lazySingleton == null) {
            lazySingleton = new LazySingleton();
        }
        return lazySingleton;
    }
}
