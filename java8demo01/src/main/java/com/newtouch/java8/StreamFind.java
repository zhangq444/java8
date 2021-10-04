package com.newtouch.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Created by grzha on 2021/10/4.
 */
public class StreamFind {
    public static void main(String[] args) {

        List<Integer> integers = Arrays.asList(2, 4, 7, 9, 5, 3, 4, 6, 8);

        System.out.println(integers.stream().filter(integer -> integer % 2 == 0).findAny());
        System.out.println(integers.stream().filter(integer -> integer % 2 == 0).findFirst());
        Optional<Integer> any = integers.stream().filter(integer -> integer % 2 == 0).findAny();
        Integer integer = any.get();
        System.out.println(integer);

        System.out.println(integers.stream().filter(integer1 -> integer1 > 2).findAny().orElse(-1));
        int result = find(integers, -1, integer1 -> integer1 > 2);
        System.out.println(result);

        Optional<Integer> first = integers.stream().filter(i -> i % 2 == 0).findFirst();
        first.ifPresent(System.out::println);
        System.out.println(first.filter(i -> i > 0).get());

    }

    public static int find(List<Integer> values, int defaultValue, Predicate<Integer> predicate) {
        for (Integer value : values) {
            if (predicate.test(value)) {
                return value;
            }
        }
        return defaultValue;
    }


}
