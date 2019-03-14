package com.ytx.example.performance.optionmization.string;

import java.util.StringTokenizer;

/**
 * @author Rosan
 * @version 1.0
 * @date 2018/11/8
 */
public class StringOptionmization {
    private static String getOrginStr() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 10000; i++) {
            sb.append(i);
            sb.append(";");
        }
        return sb.toString();
    }

    private static void splitStr() {
        String orginString = getOrginStr();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            orginString.split(";");
        }
        long endTime = System.currentTimeMillis();
        System.out.println("use split str cost :" + (endTime - startTime) + "ms");
    }

    private static void stringTokenizer() {
        String orginString = getOrginStr();
        long startTime = System.currentTimeMillis();
        StringTokenizer st = new StringTokenizer(orginString, ";");
        for (int i = 0; i < 10000; i++) {
            while (st.hasMoreTokens()) {
                st.nextToken();
            }
            st = new StringTokenizer(orginString, ";");
        }
        long endTime = System.currentTimeMillis();
        System.out.println("use stringTokenizer str cost :" + (endTime - startTime) + "ms");

    }

    private static void indexOfString() {
        String orginString = getOrginStr();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            while (true) {
                String splitStr = null;
                int j = orginString.indexOf(";");
                if (j < 0) {
                    break;
                }
                splitStr = orginString.substring(0, j);
                orginString = orginString.substring(j + 1);
            }
            orginString = getOrginStr();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("use indexOf str cost :" + (endTime - startTime) + "ms");

    }

    public static void main(String[] args) {
        //splitStr();
        //stringTokenizer();
        indexOfString();
    }
}
