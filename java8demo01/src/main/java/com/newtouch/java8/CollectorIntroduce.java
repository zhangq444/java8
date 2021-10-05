package com.newtouch.java8;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by grzha on 2021/10/5.
 */
public class CollectorIntroduce {

    public static void main(String[] args) {
        List<Apple> list = Arrays.asList(
                new Apple("green", 150),
                new Apple("yellow", 120),
                new Apple("green", 170),
                new Apple("red", 180),
                new Apple("blue", 220),
                new Apple("black", 130)
        );

        list.stream().filter(apple -> StringUtils.equals("red", apple.getColor()))
                .collect(Collectors.toList()).forEach(System.out::println);
        System.out.println("---------------------------");
        Map<String, List<Apple>> result = new HashMap<>();
        list.stream().forEach(apple -> {
            List<Apple> color1 = result.get(apple.getColor());
            if (ObjectUtils.isEmpty(color1)) {
                List<Apple> temp = new ArrayList<>();
                temp.add(apple);
                result.put(apple.getColor(), temp);
            } else {
                color1.add(apple);
            }
        });
        System.out.println(result);
        Map<String, List<Apple>> result1 = result;
        result1 = new HashMap<>();
        System.out.println("----------------------");
        System.out.println(groupByFunction(list));
        System.out.println("----------------------");
        System.out.println(groupByCollector(list));

    }


    public static Map<String, List<Apple>> groupByFunction(List<Apple> list) {
        Map<String, List<Apple>> result = new HashMap<>();
        list.stream().forEach(apple -> {
            List<Apple> list1 = Optional.ofNullable(result.get(apple.getColor())).orElseGet(() -> {
                List<Apple> color = new ArrayList<>();
                result.put(apple.getColor(), color);
                return color;
            });
            list1.add(apple);
        });
        return result;
    }

    public static Map<String, List<Apple>> groupByCollector(List<Apple> list) {
        Map<String, List<Apple>> collect = list.stream().collect(Collectors.groupingBy(Apple::getColor));
        return collect;

    }





}
