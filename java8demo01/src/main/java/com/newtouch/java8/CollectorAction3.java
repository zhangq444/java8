package com.newtouch.java8;

import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

/**
 * Created by grzha on 2021/10/5.
 */
public class CollectorAction3 {

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
        partition();
        partition01();
        reduce01();
        reduce02();
        reduce03();
        summary01();
        testsort();


    }

    public static void partition() {
        Map<Boolean, List<Dish>> collect = menu.stream().collect(Collectors.partitioningBy(Dish::isVegetarian));
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }

    public static void partition01() {
        Map<Boolean, Double> collect = menu.stream().collect(Collectors.partitioningBy(Dish::isVegetarian, Collectors.averagingInt(Dish::getCalories)));
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }

    public static void reduce01() {
        menu.stream().collect(Collectors.reducing(BinaryOperator.maxBy(Comparator.comparing(Dish::getCalories)))).ifPresent(System.out::println);
    }

    public static void reduce02() {
        Integer collect = menu.stream().map(Dish::getCalories).collect(Collectors.reducing(0, Integer::sum));
        System.out.println(collect);
    }

    public static void reduce03() {
        Integer collect = menu.stream().collect(Collectors.reducing(0, Dish::getCalories, Integer::sum));
        System.out.println(collect);
    }

    public static void summary01(){
        DoubleSummaryStatistics collect = menu.stream().collect(Collectors.summarizingDouble(Dish::getCalories));
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }

    public static void testsort(){
        menu.stream().sorted(Comparator.comparing(Dish::getCalories).reversed()).forEach(System.out::println);
        System.out.println("----------------------------------");
        menu.stream().sorted(Comparator.comparing(dish -> dish.getCalories(),Comparator.reverseOrder())).forEach(System.out::println);
    }




}
