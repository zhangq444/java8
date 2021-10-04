package com.newtouch.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Created by grzha on 2021/10/4.
 */
public class StreamReduce {

    public static void main(String[] args) {

        List<Integer> integers = Arrays.asList(2, 4, 7, 9, 5, 3, 4, 6, 8);

        Integer total = integers.stream().reduce(0, (identity, integer) -> identity + integer);
        System.out.println(total);

        integers.stream().reduce(Integer::sum).ifPresent(System.out::println);
        integers.stream().reduce((i, j) -> i * j).ifPresent(System.out::println);
        integers.stream().reduce((i,j)->{
            return i>j?i:j;
        }).ifPresent(System.out::println);
        System.out.println(integers.stream().reduce(Integer::min).get());
        Optional<Integer> sum = integers.stream().reduce(Integer::sum);
        sum.ifPresent(System.out::println);


    }


}
