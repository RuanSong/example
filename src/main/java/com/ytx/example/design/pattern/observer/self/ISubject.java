package com.ytx.example.design.pattern.observer.self;

/**
 * 主题接口
 * @author Rosan
 * @version 1.0
 * @date 2018/11/7
 */
public interface ISubject {
    void attach(IObserver observer);

    void detach(IObserver observer);

    void inform();
}
