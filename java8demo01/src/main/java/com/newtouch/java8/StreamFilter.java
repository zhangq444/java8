package com.newtouch.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by grzha on 2021/10/3.
 */
public class StreamFilter {

    public static void main(String[] args) {

        List<Integer> list= Arrays.asList(10,5,32,54,37,18,68,84,41,5,10,37,37,18);
        list.stream().filter(integer -> integer%2==0).forEach(System.out::println);
        System.out.println("==========================");
        list.stream().distinct().forEach(System.out::println);
        System.out.println("=================================");
        System.out.println(list.stream().distinct().skip(3).limit(5).collect(Collectors.toList()));


    }


}
