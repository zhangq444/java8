package com.newtouch.java8;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;

/**
 * Created by grzha on 2021/10/3.
 */
public class LambdaUsage {

    public static List<Apple> filter(List<Apple> source, Predicate<Apple> predicate) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : source) {
            if (predicate.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> filterByWeight(List<Apple> source, IntPredicate predicate) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : source) {
            if (predicate.test(apple.getWeight())) {
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> filterByBiPredicate(List<Apple> source, BiPredicate<String,Integer> predicate) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : source) {
            if (predicate.test(apple.getColor(), apple.getWeight())) {
                result.add(apple);
            }
        }
        return result;
    }

    public static void simpleTestConsumer(List<Apple> source, Consumer<Apple> consumer) {
        for (Apple apple : source) {
            consumer.accept(apple);
        }
    }

    public static void simpleTestBiConsumer(String person, List<Apple> source, BiConsumer<Apple, String> consumer) {
        for (Apple apple : source) {
            consumer.accept(apple,person);
        }
    }

    public static String testFunction(Apple apple,Function<Apple,String > function){
        return function.apply(apple);
    }

    public static Apple testBiFunction(String color,int weight,BiFunction<String,Integer,Apple> function){
        return function.apply(color,weight);
    }



    public static void main(String[] args) {
        List<Apple> list = Arrays.asList(new Apple("green", 150), new Apple("yellow", 120), new Apple("green", 170));
        List<Apple> apples = filter(list, o -> StringUtils.equals("green", o.getColor()));
        System.out.println(apples);

        List<Apple> list1 = filterByWeight(list, o -> o > 150);
        System.out.println(list1);

        List<Apple> list2 = filterByBiPredicate(list, (color, weight) -> "green".equals(color) && weight > 160);
        System.out.println(list2);

        simpleTestConsumer(list,apple -> System.out.println(apple.getColor()+":"+apple.getWeight()));

        simpleTestBiConsumer("小明",list,((apple, s) -> System.out.println(s+"吃了"+apple)));

        String result = testFunction(list.get(0), apple -> String.valueOf(apple.getWeight() * 10));
        System.out.println(result);

        System.out.println(testBiFunction("红色",180,Apple::new));
        System.out.println(testBiFunction("红色",180,(color,weight)->new Apple(color,weight)));

        System.out.println(createApple(()->new Apple("紫色",200)));

    }

    public static Apple createApple(Supplier<Apple> supplier){
        return supplier.get();
    }




}
