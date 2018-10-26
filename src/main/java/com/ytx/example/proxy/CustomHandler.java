package com.ytx.example.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author Rosan
 * @version 1.0
 * @date 2018/10/25
 */
public class CustomHandler implements InvocationHandler {
    private Object target;

    public CustomHandler(Class clazz) {
        try {
            this.target = clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object result = method.invoke(target, args);
        after();
        System.out.printf("proxy class = %s", proxy.getClass());
        return result;
    }

    private void before() {
        System.out.println("handler before");
    }

    private void after() {
        System.out.println("handler after");
    }
}
