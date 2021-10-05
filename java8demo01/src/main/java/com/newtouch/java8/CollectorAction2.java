package com.newtouch.java8;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

/**
 * Created by grzha on 2021/10/5.
 */
public class CollectorAction2 {

    public static final List<Dish> menu = Arrays.asList(
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

    public static void main(String[] args) {
        group01();
        group02();
        group03();
        joining();
        joining01();
        mapping();
        maxBy();


    }

    public static void group01() {
        ConcurrentMap<Dish.Type, List<Dish>> collect = menu.stream().collect(Collectors.groupingByConcurrent(Dish::getType));
        Optional.ofNullable(collect).ifPresent((t) -> System.out.println(t.getClass()));
        Optional.ofNullable(collect).ifPresent(System.out::println);

    }

    public static void group02() {
        Map<Dish.Type, Double> collect = menu.stream().collect(Collectors.groupingByConcurrent(Dish::getType, Collectors.averagingInt(Dish::getCalories)));
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }

    public static void group03() {
        Map<Dish.Type, Double> collect = menu.stream().collect(Collectors.groupingByConcurrent(Dish::getType, ConcurrentHashMap::new, Collectors.averagingInt(Dish::getCalories)));
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }

    public static void joining() {
        String collect = menu.stream()
                .map(Dish::getName)
                .collect(Collectors.joining(","));
        String s = Optional.ofNullable(collect).orElseGet(() -> "缺少");
        System.out.println(s);

    }

    public static void joining01() {
        String collect = menu.stream()
                .map(Dish::getName)
                .collect(Collectors.joining(",", "(", ")"));
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }

    public static void mapping(){
        Optional.ofNullable(menu.stream()
            .collect(Collectors.mapping(Dish::getName,Collectors.joining("|")))
        ).ifPresent(System.out::println);
    }

    public static void maxBy(){
        menu.stream().collect(Collectors.maxBy(Comparator.comparing(Dish::getCalories)))
                .ifPresent(System.out::println);
        menu.stream().map(Dish::getCalories).reduce(Integer::max)
                .ifPresent(System.out::println);
    }




}
