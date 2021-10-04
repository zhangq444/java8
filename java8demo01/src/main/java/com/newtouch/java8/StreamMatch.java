package com.newtouch.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by grzha on 2021/10/4.
 */
public class StreamMatch {

    public static void main(String[] args) {

        Stream<Integer> list= Arrays.stream(new Integer[]{2,4,7,9,5,3,4,6,8});

        System.out.println(list.allMatch(integer -> integer>0));
        List<Integer> integers = Arrays.asList(2, 4, 7, 9, 5, 3, 4, 6, 8);
        System.out.println(integers.stream().anyMatch(integer -> integer>10));
        System.out.println(integers.stream().noneMatch(integer -> integer>10));






    }








}
