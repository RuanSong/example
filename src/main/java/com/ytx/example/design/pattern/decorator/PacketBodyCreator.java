package com.ytx.example.design.pattern.decorator;

/**
 * 被装饰类
 *
 * @author Rosan
 * @version 1.0
 * @date 2018/11/5
 */
public class PacketBodyCreator implements IPacketCreator {
    @Override
    public String handleContent() {
        return "Content of Packet";//构造核心数据，不包括格式
    }
}
