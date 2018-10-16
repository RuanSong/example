package com.ytx.example.unsafe;

import com.ytx.example.thread.JoinThread;
import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author Rosan
 * @version 1.0
 * @date 2018/10/16
 */
public class UnSafeTest {
    public static void main(String[] args) throws Exception {
        /**
         Unsafe unsafe = Unsafe.getUnsafe();
         unsafe.addressSize();
         throw a SecurityException: Unsafe
         **/
        /**
         * so use getUnsafeInstance() get Unsafe instance
         */
        Unsafe unsafe = getUnsafeInstance();
        Class joinThreadClass = JoinThread.class;
        JoinThread joinThread = (JoinThread) unsafe.allocateInstance(joinThreadClass);
        int addressSize = unsafe.addressSize();
        System.out.println("addressSize:" + addressSize);
        joinThread.join();

    }

    public static Unsafe getUnsafeInstance() throws Exception {
        Field unsafeStaticField =
                Unsafe.class.getDeclaredField("theUnsafe");
        unsafeStaticField.setAccessible(true);
        return (Unsafe) unsafeStaticField.get(Unsafe.class);
    }


}
