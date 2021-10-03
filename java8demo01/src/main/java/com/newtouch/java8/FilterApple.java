package com.newtouch.java8;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by grzha on 2021/10/3.
 */
public class FilterApple {

    @FunctionalInterface
    public interface AppleFilter {
        public boolean filter(Apple apple);
    }

    public static List<Apple> findApple(List<Apple> apples, AppleFilter appleFilter) {
        List<Apple> list = new ArrayList<>();
        for (Apple apple : apples) {
            if (appleFilter.filter(apple)) {
                list.add(apple);
            }
        }
        return list;
    }

    public static class GreenAndWeightFliter implements AppleFilter {

        @Override
        public boolean filter(Apple apple) {
            return StringUtils.equals("green", apple.getColor()) && apple.getWeight() >= 160;
        }
    }


    public static List<Apple> findGreenApple(List<Apple> apples) {
        List<Apple> list = new ArrayList<>();
        for (Apple apple : apples) {
            if (StringUtils.equals("green", apple.getColor())) {
                list.add(apple);
            }
        }
        return list;
    }


    public static void main(String[] args) {
        List<Apple> list = Arrays.asList(new Apple("green", 150), new Apple("yellow", 120), new Apple("green", 170));
//        List<Apple> greenApple = findGreenApple(list);
//        System.out.println(greenApple);

//        List<Apple> list1 = findApple(list, new GreenAndWeightFliter());
//        System.out.println(list1);

        List<Apple> list2 = findApple(list, (apple) -> {
            return StringUtils.equals("green", apple.getColor()) && apple.getWeight() > 150;
        });
        System.out.println(list2);

    }


}
