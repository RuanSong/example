package com.ytx.example.design.pattern.singleton;

import java.io.*;

/**
 * 串行化单例
 *
 * @author Rosan
 * @version 1.0
 * @date 2018/11/5
 */
public class SerializeSingleton implements Serializable {
    private String name;

    private SerializeSingleton() {
        System.out.println("serialize singleton to be created");
        name = "SerializeSingleton";
    }

    private static SerializeSingleton instance = new SerializeSingleton();

    public static SerializeSingleton getInstance() {
        return instance;
    }
    //单例反序列化读去的函数
    private Object readResolve() {
        System.out.println("read resolve");
        return instance;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        SerializeSingleton s1 = null;
        SerializeSingleton s = SerializeSingleton.getInstance();
        //单例序列化到文件
        FileOutputStream fos = new FileOutputStream("d://serialize.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(s);
        oos.flush();
        oos.close();
        //从文件读出单例
        FileInputStream fis = new FileInputStream("d://serialize.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        s1 = (SerializeSingleton) ois.readObject();
        System.out.println(s1.equals(s));
    }
}
