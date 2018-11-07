package com.ytx.example.design.pattern.observer.self;

import java.util.EventObject;

/**
 * 观察者实现
 *
 * @author Rosan
 * @version 1.0
 * @date 2018/11/7
 */
public class ConcreteObserver implements IObserver {
    @Override
    public void update(EventObject evt) {
        System.out.println("observer receive information" + evt);
    }
}
