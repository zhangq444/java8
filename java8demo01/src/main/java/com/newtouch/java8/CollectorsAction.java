package com.newtouch.java8;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by grzha on 2021/10/5.
 */
public class CollectorsAction {


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
        getAvage();
        getAvageInt();
        collectorThen();
        counting();
        group01();
        group02();
        group03();
        summary();


    }


    public static void getAvage() {
        Double collect = menu.stream().collect(Collectors.averagingDouble(Dish::getCalories));
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }

    public static void getAvageInt() {
        Double collect = menu.stream()
                .collect(Collectors.averagingInt(Dish::getCalories));
        Optional.ofNullable(collect
        ).ifPresent(System.out::println);
    }

    public static void collectorThen() {
        String collect = menu.stream().collect(Collectors.collectingAndThen(Collectors.averagingInt(Dish::getCalories),
                a -> "the avage is->" + a));
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }

    public static void counting() {
        Optional.ofNullable(menu.stream().collect(Collectors.counting())).ifPresent(System.out::println);
        System.out.println(menu.stream().count());
    }

    public static void group01() {
        Map<Dish.Type, List<Dish>> collect = menu.stream().collect(Collectors.groupingBy(Dish::getType));
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }

    public static void group02() {
        Map<Dish.Type, Long> collect1 = menu.stream().collect(Collectors.groupingBy(Dish::getType, Collectors.counting()));
        Optional.ofNullable(collect1).ifPresent(System.out::println);
        Map<Dish.Type, Double> collect = menu.stream().collect(Collectors.groupingBy(Dish::getType, Collectors.averagingInt(Dish::getCalories)));
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }

    public static void group03(){
        TreeMap<Dish.Type, Double> treeMap = menu.stream().collect(Collectors.groupingBy(Dish::getType, TreeMap::new, Collectors.averagingInt(Dish::getCalories)));
        Optional.ofNullable(treeMap).ifPresent(map-> System.out.println(map.getClass()));
        Optional.ofNullable(treeMap).ifPresent(System.out::println);
    }

    public static void summary(){
        IntSummaryStatistics statistics = menu.stream().collect(Collectors.summarizingInt(Dish::getCalories));
        Optional.ofNullable(statistics).ifPresent(System.out::println);

    }




}
