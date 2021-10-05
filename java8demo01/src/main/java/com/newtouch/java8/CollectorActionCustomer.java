package com.newtouch.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;

/**
 * Created by grzha on 2021/10/5.
 */
public class CollectorActionCustomer {

    public static void main(String[] args) {
        Collector<String,List<String>,List<String>> collector=new ToListCollector<>();
        String[] arrays=new String[]{"Hello","World","zhang","qiang","lambda","java8"};

        List<String> collect = Arrays.stream(arrays).filter(s -> s.length() > 5).collect(collector);
        System.out.println(collect);


    }


}
