package com.ytx.example.nio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author Rosan
 * @version 1.0
 * @date 2018/11/8
 */
public class NioTest {
    private static void testFileChannel() throws IOException {
        FileInputStream fis = new FileInputStream(new File("D:\\1.tmp"));
        FileChannel fileChannel = fis.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        fileChannel.close();
        byteBuffer.flip();
    }

    private static void copyFile(String resource, String dest) throws IOException {
        FileInputStream fis = new FileInputStream(resource);
        FileOutputStream fos = new FileOutputStream(dest);
        byte[] buffer = new byte[1024];
        while (fis.read(buffer) != -1) {
            fos.write(buffer);
        }
        fis.close();
        fos.close();
    }

    private static void bufferCopyFile(String resource, String dest) throws IOException {
        BufferedInputStream fis = new BufferedInputStream(new FileInputStream(resource));
        BufferedOutputStream fos = new BufferedOutputStream(new FileOutputStream(dest));
        byte[] buffer = new byte[1024];
        while (fis.read(buffer) != -1) {
            fos.write(buffer);
        }
        fis.close();
        fos.close();
    }

    private static void nioCopyFile(String resource, String dest) throws IOException {
        FileInputStream fis = new FileInputStream(resource);
        FileOutputStream fos = new FileOutputStream(dest);
        //读取文件数据通道
        FileChannel readChannel = fis.getChannel();
        //写文件数据通道
        FileChannel writeChannel = fos.getChannel();
        //读入文件缓存
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        while (true) {
            buffer.clear();
            int len = readChannel.read(buffer);
            //读取到文件结束位置，读取完毕
            if (len == -1) {
                break;
            }
            buffer.flip();
            //写文件
            writeChannel.write(buffer);
        }
        readChannel.close();
        writeChannel.close();
    }

    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            nioCopyFile("D:\\1.tmp", "D:\\nio\\" + i + ".tmp");
        }
        long nioEndTime = System.currentTimeMillis();
        System.out.println("nio copy file cost:" + (nioEndTime - startTime) + "ms");
        for (int i = 0; i < 10; i++) {
            copyFile("D:\\1.tmp", "D:\\copy\\" + i + ".tmp");
        }
        long copyFileEndTime = System.currentTimeMillis();
        System.out.println("copy file cost:" + (copyFileEndTime - nioEndTime) + "ms");
        for (int i = 0; i < 10; i++) {
            bufferCopyFile("D:\\1.tmp", "D:\\buffer\\" + i + ".tmp");
        }
        long bufferFileEndTime = System.currentTimeMillis();
        System.out.println("buffer copy file cost:" + (bufferFileEndTime - copyFileEndTime) + "ms");

    }

}
