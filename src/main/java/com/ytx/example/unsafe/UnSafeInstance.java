package com.ytx.example.unsafe;

import com.ytx.example.algorithm.SnowflakeIdWorker;
import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashSet;


/**
 * @author Rosan
 * @version 1.0
 * @date 2018/10/16
 */
public class UnSafeInstance {
    public static void main(String[] args) {
        System.out.println(sizeOf(new SnowflakeIdWorker(0, 0)));
        System.out.println(sizeOf(new String()));
    }

    /**
     * 获取Unsafe实例
     *
     * @return
     * @throws Exception
     */
    private static Unsafe getUnsafe() {
        Unsafe unsafe = null;
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            unsafe = (Unsafe) field.get(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return unsafe;
    }

    /**
     * java 版本sizeOf
     *
     * @param o
     * @return
     */
    public static long sizeOf(Object o) {
        Unsafe unsafe = getUnsafe();
        HashSet<Field> fields = new HashSet<>();
        Class c = o.getClass();
        while (c != Object.class) {
            for (Field f : c.getDeclaredFields()) {
                if ((f.getModifiers() & Modifier.STATIC) == 0) {
                    fields.add(f);
                }
            }
            c = c.getSuperclass();
        }
        //get offset
        long maxSize = 0;
        for (Field f : fields) {
            long offset = unsafe.objectFieldOffset(f);
            if (offset > maxSize) {
                maxSize = offset;
            }
        }
        //padding
        return ((maxSize / 8) + 1) * 8;
    }

}
