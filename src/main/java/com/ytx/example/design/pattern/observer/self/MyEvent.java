package com.ytx.example.design.pattern.observer.self;


import java.util.EventObject;

/**
 * @author Rosan
 * @version 1.0
 * @date 2018/11/7
 */
public class MyEvent extends EventObject {

    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public MyEvent(Object source) {
        super(source);
    }
}
