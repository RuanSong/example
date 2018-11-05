package com.ytx.example.design.pattern.decorator;

/**
 * 装饰实现类
 *
 * @author Rosan
 * @version 1.0
 * @date 2018/11/5
 */
public class PacketHtmlHeaderCreator extends PacketDecorator {

    public PacketHtmlHeaderCreator(IPacketCreator component) {
        super(component);
    }

    @Override
    public String handleContent() {
        StringBuffer sb = new StringBuffer();
        sb.append("<html>");
        sb.append("<body>");
        sb.append(component.handleContent());
        sb.append("</body>");
        sb.append("</html>");
        return sb.toString();
    }
}
