package com.ytx.example.design.pattern.proxy.lazyload;

import javassist.CannotCompileException;
import javassist.NotFoundException;

/**
 * @author Rosan
 * @version 1.0
 * @date 2018/11/5
 */
public class Main {
    private static int COUNT = 300000000;
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, NotFoundException, CannotCompileException {
        long beginTimillies = System.currentTimeMillis();
        //使用代理
        IDBQuery staticProxy = new DBQueryProxy();
        //真正使用的时候才创建正式代理对象
        System.out.println(staticProxy.request());
        for(int i = 0; i < COUNT;i++){
            staticProxy.request();
        }
        long staticProxyEndTimillies = System.currentTimeMillis();

        System.out.println("staticProxy cost:" + (staticProxyEndTimillies - beginTimillies) + "ms");
        IDBQuery jdkProxy = JdkDbQueryHandler.createJdkProxy();
        System.out.println(jdkProxy.request());
        for(int i = 0; i < COUNT;i++){
            jdkProxy.request();
        }

        long jdkProxyEndTimillies = System.currentTimeMillis();
        System.out.println("jdkProxy cost:" + (jdkProxyEndTimillies - staticProxyEndTimillies) + "ms");

        IDBQuery cglibProxy = CglibDbQueryInterceptor.createCglibProxy();
        System.out.println(cglibProxy.request());
        for(int i = 0; i < COUNT;i++){
            cglibProxy.request();
        }

        long cglibProxyEndTimillies = System.currentTimeMillis();
        System.out.println("cglibProxy cost:" + (cglibProxyEndTimillies - jdkProxyEndTimillies) + "ms");

        IDBQuery javassisit = JavassistDynDbQueryHandler.createJavasistDynProxy();
        System.out.println(javassisit.request());
        for(int i = 0; i < COUNT;i++){
            javassisit.request();
        }

        long javassisitProxyEndTimillies = System.currentTimeMillis();
        System.out.println("javassistProxy cost:" + (javassisitProxyEndTimillies - cglibProxyEndTimillies) + "ms");

        IDBQuery javassisitByCode = JavassistDynDbQueryHandler.createJavassistBytecodeDynamicProxy();
        System.out.println(javassisitByCode.request());
        for(int i = 0; i < COUNT;i++){
            javassisitByCode.request();
        }

        long javassisitByCodeProxyEndTimillies = System.currentTimeMillis();
        System.out.println("javasssistCodeProxy cost:" + (javassisitByCodeProxyEndTimillies - javassisitProxyEndTimillies) + "ms");
    }
}
