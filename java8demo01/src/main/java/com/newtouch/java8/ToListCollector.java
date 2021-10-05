package com.newtouch.java8;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 * Created by grzha on 2021/10/5.
 */
public class ToListCollector<T> implements Collector<T, List<T>, List<T>> {

    private void log(String string){
        System.out.println(Thread.currentThread().getName()+"--"+string);
    }

    @Override
    public Supplier<List<T>> supplier() {
        log("supplier");
        return ArrayList::new;
    }

    @Override
    public BiConsumer<List<T>, T> accumulator() {
        log("accumulator");
        return List::add;
    }

    @Override
    public BinaryOperator<List<T>> combiner() {
        log("combiner");
        return ((list, list2) -> {
            list.addAll(list2);
            return list;
        });
    }

    @Override
    public Function<List<T>, List<T>> finisher() {
        log("finisher");
        return Function.identity();
    }

    @Override
    public Set<Characteristics> characteristics() {
        log("characteristics");
        return Collections.unmodifiableSet(EnumSet.of(Characteristics.IDENTITY_FINISH,Characteristics.CONCURRENT));
    }
}
