package com.ytx.example.proxy;

import sun.misc.ProxyGenerator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Proxy;

/**
 * @author Rosan
 * @version 1.0
 * @date 2018/10/25
 */
public class ProxyMain {
    public static void main(String[] args) {
        //static proxy
        InterfaceA interfaceA = new ProxyImplement();
        interfaceA.exec();
        //dynamic proxy
        CustomHandler handler = new CustomHandler(RealImplement.class);
        InterfaceA interfaceA2 = (InterfaceA) Proxy.newProxyInstance(ProxyMain.class.getClassLoader(), new Class[]{InterfaceA.class}, handler);
        interfaceA2.exec();
        //dynamic proxy class generate
        byte[] proxyClassFile = ProxyGenerator.generateProxyClass("$Proxy1", new Class[]{InterfaceA.class});
        FileOutputStream out = null;
        try {
            out = new FileOutputStream("D:/$Proxy1.class");
            out.write(proxyClassFile);
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
