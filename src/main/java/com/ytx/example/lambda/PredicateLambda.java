package com.ytx.example.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author Rosan
 * @version 1.0
 * @date 2018/10/29
 */
public class PredicateLambda {
    public static void main(String[] args) {
        List<String> mobiles = Arrays.asList("13871579742", "1358798744", "156988", "d21213", "d13871579742","123698654784");
        filter(mobiles, (str) -> str.length() == 11);
        System.out.println("--------------------");
        filter(mobiles, (str) -> true);
        System.out.println("--------------------");
        filter(mobiles, (str) -> false);
        System.out.println("--------------------");
        filter(mobiles, (str) -> str.startsWith("d"));
        System.out.println("--------------------");
        Predicate<String> startWidthD = (str) -> str.startsWith("d");
        Predicate<String> lengthWIdth12 = (str) -> str.length() == 12;
        filter(mobiles, startWidthD.and(lengthWIdth12));
        System.out.println("--------------------");
        filter(mobiles, startWidthD.or(lengthWIdth12));
        System.out.println("--------------------");



    }

    private static void filter(List<String> mobileList, Predicate<String> predicate) {
        for (String mobile : mobileList) {
            if (predicate.test(mobile)) {
                System.out.println(mobile);
            }
        }
    }
}
