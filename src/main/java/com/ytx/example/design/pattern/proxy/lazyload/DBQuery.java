package com.ytx.example.design.pattern.proxy.lazyload;

/**
 * @author Rosan
 * @version 1.0
 * @date 2018/11/5
 */
public class DBQuery implements IDBQuery {
    public DBQuery(){

    }
    @Override
    public String request() {
        return "request string";
    }
}
