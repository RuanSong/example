package com.ytx.example.design.pattern.proxy.lazyload;

/**
 * 静态代理
 *
 * @author Rosan
 * @version 1.0
 * @date 2018/11/5
 */
public class DBQueryProxy implements IDBQuery {
    private IDBQuery real = null;

    @Override
    public String request() {
        //真正使用的时候采取创建
        if (real == null) {
            real = new DBQuery();
        }
        return real.request();
    }
}
