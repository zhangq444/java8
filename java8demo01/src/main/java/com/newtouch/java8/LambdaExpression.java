package com.newtouch.java8;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Created by grzha on 2021/10/3.
 */
public class LambdaExpression {

    public static void main(String[] args) {

        Comparator<Apple> comparator=new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return StringUtils.compare(o1.getColor(),o2.getColor());
            }
        };
        List<Apple> list = Arrays.asList(new Apple("green", 150), new Apple("yellow", 120), new Apple("green", 170));
//        list.sort(comparator);
//        System.out.println(list);
        list.sort(Comparator.comparing(Apple::getColor));
        System.out.println(list);
        list.sort(Comparator.comparing(Apple::getWeight));
        System.out.println(list);
        list.sort((o1,o2)->o1.getWeight()<o2.getWeight()==true?1:-1);
        System.out.println(list);

        Function<String,Integer> flambda=s -> s.length();
        Predicate<Apple> predicate= o->"green".equals(o.getColor());


    }





}
