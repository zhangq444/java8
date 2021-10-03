package com.newtouch.java8;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Created by grzha on 2021/10/3.
 */
public class MethodReference {

    public static void main(String[] args) {

        useConsumer((String t) -> System.out.println(t.length()), "zhangqiang");
        useConsumer(System.out::println, "张强");
        List<Apple> list = Arrays.asList(new Apple("green", 150), new Apple("yellow", 120), new Apple("green", 170));
        System.out.println(list);
        list.sort((o1, o2) -> o1.getColor().compareTo(o2.getColor()));
        System.out.println(list);

        BiFunction<String ,Integer,Character> function=String::charAt;
        System.out.println(function.apply("zhangqiang",5));

        String temp="chinaUSA";
        Function<Integer,Character> function1=temp::charAt;
        System.out.println(function1.apply(5));

        BiFunction<String,Integer,Apple> function2=Apple::new;
        System.out.println(function2.apply("蓝色",220));

        Function<Map<String,Object>,ComplexApple> function3=map -> new ComplexApple((String)map.get("color"),(Integer) map.get("weight"),(String)map.get("name"));
        HashMap<String, Object> appleMap = new HashMap<>();
        appleMap.put("color","黑色");
        appleMap.put("weight",211);
        appleMap.put("name","红富士");
        System.out.println(function3.apply(appleMap));

        ThreeFunction<ComplexApple,String,Integer,String> function4=ComplexApple::new;
        System.out.println(function4.apply("黑色1",122,"蛇果"));



    }

    public static <T> void useConsumer(Consumer<T> consumer, T t) {
        consumer.accept(t);
    }


}
