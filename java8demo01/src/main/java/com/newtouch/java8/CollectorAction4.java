package com.newtouch.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by grzha on 2021/10/5.
 */
public class CollectorAction4 {

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
        summing();
        toMap();
        toMap01();
        toSet();




    }

    public static void summing(){
        Optional.ofNullable(menu.stream().collect(Collectors.summingDouble(Dish::getCalories))).ifPresent(System.out::println);
        System.out.println(menu.stream().map(Dish::getCalories).mapToInt(Integer::intValue).sum());
        System.out.println(menu.stream().map(Dish::getCalories).reduce(0, Integer::sum));
    }

    public static void toMap(){
        Optional.ofNullable(menu.stream().collect(Collectors.toMap(Dish::getName,Dish::getCalories))).ifPresent(System.out::println);
    }

    public static void toMap01(){
        Map<Dish.Type, Integer> collect = menu.stream().collect(Collectors.toMap(Dish::getType, dish -> 1, Integer::sum));
        System.out.println(collect);
    }

    public static void toSet(){
        Optional.ofNullable(menu.stream().collect(Collectors.toSet())).ifPresent(System.out::println);
    }


}
