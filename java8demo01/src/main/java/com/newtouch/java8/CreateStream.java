package com.newtouch.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by grzha on 2021/10/3.
 */
public class CreateStream {

    public static void main(String[] args) {
        fromCollection().forEach(System.out::println);
        fromValues().forEach(System.out::println);
        fromArrays().forEach(System.out::println);

    }

    public static Stream<String> fromCollection(){
        List<String> strings = Arrays.asList("hello", "zhangqiang", "world", "java", "lambda");
        return strings.stream();
    }

    public static Stream<String> fromValues(){
        return Stream.of("hello", "zhangqiang", "world", "java", "lambda");
    }

    public static Stream<String>  fromArrays(){
        return Arrays.stream(new String[]{"hello", "zhangqiang", "world", "java", "lambda"});
    }

}
