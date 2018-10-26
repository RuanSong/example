package com.ytx.example.util;

import java.util.BitSet;

/**
 * BitSet底层是long数组，size()方法返回的是对当前的整数位
 * bitset解决快速查找，判重，删除，可以在耗费较小内存情况下下达到效果
 *
 * @author Rosan
 * @version 1.0
 * @date 2018/10/24
 */
public class BitSetTest {
    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 22, 0, 3, 63};
        BitSet bitSet = new BitSet(1);
        System.out.println(bitSet.size());   //64
        bitSet = new BitSet(65);
        System.out.println(bitSet.size());   //128
        bitSet = new BitSet(23);
        System.out.println(bitSet.size());   //64

        //将数组内容组bitmap
        for (int i = 0; i < array.length; i++) {
            bitSet.set(array[i], true);
        }

        System.out.println(bitSet.get(22));
        System.out.println(bitSet.get(60));

        System.out.println("下面开始遍历BitSet：");
        for (int i = 0; i < bitSet.size(); i++) {
            System.out.println(bitSet.get(i));
        }
    }
}
