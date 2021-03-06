package com.newtouch.java8;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by grzha on 2021/10/3.
 */
public class SimpleStream {

    public static void main(String[] args) {
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

//        System.out.println(getDishName(menu));
        System.out.println(getDishName01(menu));


    }

    public static List<String> getDishName(List<Dish> menu) {
        /*List<Dish> low = new ArrayList<>();
        for (Dish dish : menu) {
            if (dish.getCalories() < 400) {
                low.add(dish);
            }
        }*/
        List<Dish> low = menu.stream().filter(dish -> dish.getCalories() < 400).collect(Collectors.toList());
        Collections.sort(low, Comparator.comparing(Dish::getCalories));
        List<String> list = low.stream().map(Dish::getName).collect(Collectors.toList());
        return list;
    }

    public static List<String> getDishName01(List<Dish> menu) {
        List<String> collect = menu.stream()
                .filter(dish -> dish.getCalories() < 400)
                .sorted(Comparator.comparing(Dish::getCalories))
                .map(Dish::getName)
                .collect(Collectors.toList());
        return collect;
    }


}
