package com.ytx.example.proxy;

/**
 * @author Rosan
 * @version 1.0
 * @date 2018/10/25
 */
public class RealImplement implements InterfaceA {
    @Override
    public void exec() {
        System.out.println("real impl");
    }

}
