package com.ytx.example.design.pattern.proxy.lazyload;

import com.sun.deploy.util.ReflectionUtil;
import javassist.*;
import javassist.util.proxy.MethodHandler;
import javassist.util.proxy.ProxyFactory;
import javassist.util.proxy.ProxyObject;

import java.lang.reflect.Method;

/**
 * @author Rosan
 * @version 1.0
 * @date 2018/11/5
 */
public class JavassistDynDbQueryHandler implements MethodHandler {
    private IDBQuery real = null;

    @Override
    public Object invoke(Object o, Method method, Method method1, Object[] objects) throws Throwable {
        if (real == null) {
            real = new DBQuery();
        }
        return real.request();
    }

    public static IDBQuery createJavasistDynProxy() throws IllegalAccessException, InstantiationException {
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setInterfaces(new Class[]{IDBQuery.class});
        Class proxyClass = proxyFactory.createClass();
        IDBQuery javassistProxy = (IDBQuery) proxyClass.newInstance();
        ((ProxyObject) javassistProxy).setHandler(new JavassistDynDbQueryHandler());
        return javassistProxy;
    }

    public static IDBQuery createJavassistBytecodeDynamicProxy() throws NotFoundException, CannotCompileException, IllegalAccessException, InstantiationException {
        ClassPool mPool = new ClassPool();
        ClassClassPath classPath = new ClassClassPath(JavassistDynDbQueryHandler.class.getClass());
        mPool.insertClassPath(classPath);
        //定义类名
        CtClass mCtc = mPool.makeClass(IDBQuery.class.getName() + "JavassistBytecodeProxy");

        //需要实现的接口
        mCtc.addInterface(mPool.get(IDBQuery.class.getName()));
        //添加构造函数
        mCtc.addConstructor(CtNewConstructor.defaultConstructor(mCtc));
        //添加类的字段信息，使用动态java代码
        mCtc.addField(CtField.make("public " + IDBQuery.class.getName() + " real;", mCtc));

        String dbQueryName = DBQuery.class.getName();
        //添加方法，使用动态Java代码指定内部逻辑
        mCtc.addMethod(CtNewMethod.make("public String request(){ if (real == null) { real = new " + dbQueryName + "();} return real.request();}", mCtc));
        //获取以上信息，生成动态类
        Class pc = mCtc.toClass();
        //生成动态类实例
        IDBQuery byteCodeProxy = (IDBQuery) pc.newInstance();
        return byteCodeProxy;
    }
}
