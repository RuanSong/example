package com.ytx.example.proxy;

/**
 * @author Rosan
 * @version 1.0
 * @date 2018/10/25
 */
public class ProxyImplement implements InterfaceA {
    private InterfaceA interfaceA;

    public ProxyImplement() {
        this.interfaceA = new RealImplement();
    }

    @Override
    public void exec() {
        System.out.println("dosomethings before");
        interfaceA.exec();
        System.out.println("dosomethings after");

    }
}
