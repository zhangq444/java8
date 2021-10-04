package com.newtouch.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by grzha on 2021/10/4.
 */
public class NumericStream {
    public static void main(String[] args) {

        List<Integer> integers = Arrays.asList(2, 4, 7, 9, 5, 3, 4, 6, 8);

        IntStream intStream = integers.stream().mapToInt(i -> i.intValue());
        OptionalDouble average = intStream.average();
        average.ifPresent(System.out::println);

        integers.stream().mapToInt(i -> i.intValue()).boxed().reduce((i,j)->i+j).ifPresent(System.out::println);

        List<Integer> list=new ArrayList<>();
        for (int i = 1; i <=1000 ; i++) {
            list.add(i);
        }

        /*我写的查找1000以内和3组成勾股定律的数*/
        list.stream().filter(integer -> {
            int temp = integer * integer + 9;
            double sqrt = Math.sqrt(temp);
            if((int)sqrt-sqrt==0){
                return true;
            }
            return false;
        }).forEach(System.out::println);
        //视频中教的java8
        int a=3;
        IntStream.rangeClosed(1, 1000)
                .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                .boxed()
                .map(b -> new Integer[]{a, b, (int) Math.sqrt(a * a + b * b)})
                .forEach(c-> System.out.println(Arrays.toString(c)));

    }


}
