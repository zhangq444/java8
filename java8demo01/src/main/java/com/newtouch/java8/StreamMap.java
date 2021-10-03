package com.newtouch.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by grzha on 2021/10/4.
 */
public class StreamMap {
    public static void main(String[] args) {
        List<Integer> list= Arrays.asList(10,5,32,54,37,18,68,84,41,5,10,37,37,18);

        System.out.println(list.stream().map(integer -> integer*2).collect(Collectors.toList()));
        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH)
        );

        System.out.println(menu.stream().map(Dish::getName).collect(Collectors.toList()));

        String[] words={"hello","world","zhang","qiang"};
        List<String> strings = Arrays.asList(words).stream()
                .flatMap(str -> Arrays.asList(str.split("")).stream())
                .distinct()
                .collect(Collectors.toList());
        System.out.println(strings);


    }
}
