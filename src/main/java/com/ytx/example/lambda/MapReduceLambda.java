package com.ytx.example.lambda;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 * @author Rosan
 * @version 1.0
 * @date 2018/10/29
 */
public class MapReduceLambda {
    public static void main(String[] args) {
        List<BigDecimal> costBeforeTax = Arrays.asList(new BigDecimal(100),new BigDecimal(200),new BigDecimal(300),new BigDecimal(400),new BigDecimal(500),new BigDecimal(100),new BigDecimal(600),new BigDecimal(700));
        //with out lambda
        for (BigDecimal cost : costBeforeTax) {
            BigDecimal price = cost.add(cost.multiply(new BigDecimal("0.12")));
            System.out.println(price);
        }
        System.out.println("-------------------------");
        costBeforeTax.stream().map((cost)-> cost.add(new BigDecimal("0.12").multiply(cost))).forEach(System.out::println);
        System.out.println("-------------------------");
        BigDecimal totalCost = costBeforeTax.stream().map((cost)-> cost.add(cost.multiply(new BigDecimal("0.12")))).reduce((sum,cost)->sum.add(cost)).get();
        System.out.println(totalCost);
    }
}
