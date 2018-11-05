package com.ytx.example.design.pattern.decorator;

/**
 * 装饰实现类
 * @author Rosan
 * @version 1.0
 * @date 2018/11/5
 */
public class PacketHTTPHeaderCreator extends PacketDecorator {
    public PacketHTTPHeaderCreator(IPacketCreator component) {
        super(component);
    }

    @Override
    public String handleContent() {
        StringBuffer sb = new StringBuffer();
        sb.append("Cache-Control:no-cache\n");
        sb.append("Date:Mon,31Dec201204:25:57:GMT\n");
        sb.append(component.handleContent());
        return sb.toString();
    }
}
