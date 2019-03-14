package com.ytx.example.nio;

import java.nio.ByteBuffer;

/**
 * @author Rosan
 * @version 1.0
 * @date 2018/11/8
 */
public class NioWorkTest {
    public static void main(String[] args) {
        /**                 写模式                                                 读模式
         * positon  位置    当前缓冲区位置，将从position的下一个位置写数据           当前缓冲区读取的位置，从这个位置后读取数据
         * capacity 容量    缓冲区的总容量上限                                       缓冲区总容量上线
         * limit    上限    缓冲区实际上限，总是<=容量，通常与容量相等           代表可读取的总容量，和上次写入的数量相等
         * mark     标记
         */
        /**
         * flip()操作（防止读模式中，读到根本没有进行操作的区域）
         * 1.重置当前pisition为0
         * 2.将limit设置到当前position的位置
         */
        /**
         *              rewind()                        clear()                    flip()
         * position     置零                              置零                     置零
         * mark         清空                              清空                     清空
         * limit        未改动                            设置为capacity           设置为position
         * 作用         为读取Buffer中有效数据做准备     为重新写入Buffer做准备    在读写切换时候调用
         */
        ByteBuffer byteBuffer = ByteBuffer.allocate(15);
        System.out.println("init ");
        System.out.println("limit=" + byteBuffer.limit() + " capacity=" + byteBuffer.capacity() + " position=" + byteBuffer.position());
        for (int i = 0; i < 10; i++) {
            byteBuffer.put((byte) i);
        }
        System.out.println("after put ten byte: ");
        System.out.println("limit=" + byteBuffer.limit() + " capacity=" + byteBuffer.capacity() + " position=" + byteBuffer.position());
        byteBuffer.flip();
        System.out.println("after flip:");

        System.out.println("limit=" + byteBuffer.limit() + " capacity=" + byteBuffer.capacity() + " position=" + byteBuffer.position());

        for (int i = 0; i < 5; i++) {
            System.out.print(byteBuffer.get());
        }
        System.out.println();
        System.out.println("after read five byte:");
        System.out.println("limit=" + byteBuffer.limit() + " capacity=" + byteBuffer.capacity() + " position=" + byteBuffer.position());
        byteBuffer.flip();
        System.out.println("after flip:");
        System.out.println("limit=" + byteBuffer.limit() + " capacity=" + byteBuffer.capacity() + " position=" + byteBuffer.position());
    }
}
