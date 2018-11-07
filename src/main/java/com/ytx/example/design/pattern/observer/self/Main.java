package com.ytx.example.design.pattern.observer.self;

/**
 * @author Rosan
 * @version 1.0
 * @date 2018/11/7
 */
public class Main {
    public static void main(String[] args) {
        IObserver observer = new ConcreteObserver();
        IObserver observer2 = new MyConcreteObserver();

        ISubject subject = new ConcreteSubject();

        subject.attach(observer);
        subject.attach(observer2);

        subject.inform();

        subject.detach(observer);
        subject.inform();

    }
}
