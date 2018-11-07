package com.ytx.example.design.pattern.observer.self;

import java.util.EventObject;

/**
 * @author Rosan
 * @version 1.0
 * @date 2018/11/7
 */
public class MyConcreteObserver implements IObserver {
    @Override
    public void update(EventObject evt) {
        System.out.println("my observer receive information" + evt);
    }
}
