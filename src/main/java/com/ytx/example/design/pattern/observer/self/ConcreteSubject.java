package com.ytx.example.design.pattern.observer.self;

import java.util.EventObject;
import java.util.Vector;

/**
 * 具体观察主题实现
 *
 * @author Rosan
 * @version 1.0
 * @date 2018/11/7
 */
public class ConcreteSubject implements ISubject {
    private Vector<IObserver> observers = new Vector<>();

    @Override
    public void attach(IObserver observer) {
        observers.addElement(observer);
    }

    @Override
    public void detach(IObserver observer) {
        observers.removeElement(observer);
    }

    @Override
    public void inform() {
        EventObject eventObject = new MyEvent("event info ");
        for (IObserver observer : observers) {
            //通知观察者
            observer.update(eventObject);
        }
    }
}
