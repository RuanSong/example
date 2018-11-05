package com.ytx.example.design.pattern.decorator;

/**
 * 装饰者模式可以有效分离性能组件和功能组件，从而提升模块的可维护性并曾家模块的复用性
 * <p>
 * 装饰者(Decorator)和被装饰者(ConcreteComponent)拥有相同过的接口Component
 * 被装饰者通常是系统的核心组件，完成特定的功能目标，而装饰者则可以再被装饰者的方法前后，加上特定的牵制处理和后置处理，增项被装饰者的功能
 *
 * InputStream 和OutPutStream就是采用的装饰者模式实现的
 * @author Rosan
 * @version 1.0
 * @date 2018/11/5
 */
public class Main {
    public static void main(String[] args) {
        IPacketCreator pc = new PacketHTTPHeaderCreator(
                new PacketHtmlHeaderCreator(
                        new PacketBodyCreator()
                ));
        System.out.println(pc.handleContent());
    }
}
