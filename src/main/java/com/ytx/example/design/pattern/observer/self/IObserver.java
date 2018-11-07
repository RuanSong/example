package com.ytx.example.design.pattern.observer.self;

import java.util.EventObject;

/**
 * 观察者接口，定义了观察者的基本方法，当依赖发生改变的时候，主题接口会调用观察者的update()方法
 *
 * @author Rosan
 * @version 1.0
 * @date 2018/11/7
 */
public interface IObserver {
    void update(EventObject evt);
}
