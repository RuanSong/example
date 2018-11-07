package com.ytx.example.design.pattern.observer.jdk;


import java.util.Observable;
import java.util.Observer;

/**
 * @author Rosan
 * @version 1.0
 * @date 2018/11/7
 */
public class MyObserver implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("revive observer" +"arg:" +arg);
    }
}
