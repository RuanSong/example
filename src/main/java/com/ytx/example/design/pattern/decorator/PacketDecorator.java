package com.ytx.example.design.pattern.decorator;

/**
 * 装饰类
 *
 * @author Rosan
 * @version 1.0
 * @date 2018/11/5
 */
public abstract class PacketDecorator implements IPacketCreator {
    protected IPacketCreator component;

    public PacketDecorator(IPacketCreator component) {
        this.component = component;
    }
}
