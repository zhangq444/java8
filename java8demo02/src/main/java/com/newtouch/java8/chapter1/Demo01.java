package com.newtouch.java8.chapter1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by grzha on 2021/11/17.
 */
public class Demo01 {

    public static void main(String[] args) {
        List<Apple> apples = Arrays.asList(new Apple(120, "绿色"),
                new Apple(140, "红色"),
                new Apple(150, "绿色"),
                new Apple(100, "绿色"));
        List<Apple> apples1 = filterApple(apples, Demo01::isGreen);
        System.out.println(apples1);
        List<Apple> apples2 = filterApple(apples, (Apple a) -> a.getWeight() > 120 && "红色".equals(a.getColor()));
        System.out.println(apples2);


    }


    public static boolean isHeavy(Apple apple){
        return 110>apple.getWeight();
    }

    public static boolean isGreen(Apple apple){
        return "绿色".equals(apple.getColor());
    }

    public static List<Apple> filterApple(List<Apple> appleList, Predicate<Apple> p){
        ArrayList<Apple> result = new ArrayList<>();
        for (Apple apple : appleList) {
            if(p.test(apple)){
                result.add(apple);
            }
        }
        return result;
    }




    public static class Apple {
        private int weight = 0;
        private String color = "";

        public Apple(int weight, String color){
            this.weight = weight;
            this.color = color;
        }

        public Integer getWeight() {
            return weight;
        }

        public void setWeight(Integer weight) {
            this.weight = weight;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String toString() {
            return "Apple{" +
                    "color='" + color + '\'' +
                    ", weight=" + weight +
                    '}';
        }
    }






}
