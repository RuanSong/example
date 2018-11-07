package com.ytx.example.design.pattern.observer.jdk;

import java.util.Observable;

/**
 * @author Rosan
 * @version 1.0
 * @date 2018/11/7
 */
public class MyConcerateObserver extends Observable {
    private int num;

    public MyConcerateObserver(int num) {
        this.num = num;
    }

    public void setNumber(int num) {
        if (this.num != num) {
            this.num = num;
            setChanged();//必须设置改变值之后才能正常通知
            notifyObservers(num);
        }
    }
}
