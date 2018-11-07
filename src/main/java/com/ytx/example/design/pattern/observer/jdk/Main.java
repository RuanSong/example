package com.ytx.example.design.pattern.observer.jdk;

import java.util.Observable;
import java.util.Observer;

/**
 * @author Rosan
 * @version 1.0
 * @date 2018/11/7
 */
public class Main {
    public static void main(String[] args) {
        Observable observable = new MyConcerateObserver(10);


        Observer observer1 = new MyObserver();
        Observer observer2 = new MyObserver();
        observable.addObserver(observer1);
        observable.addObserver(observer2);
        ((MyConcerateObserver) observable).setNumber(10);
        ((MyConcerateObserver) observable).setNumber(11);
    }
}
