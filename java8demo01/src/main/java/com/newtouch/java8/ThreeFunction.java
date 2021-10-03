package com.newtouch.java8;

/**
 * Created by grzha on 2021/10/3.
 */
@FunctionalInterface
public interface ThreeFunction<T,U,R,S> {

    T apply(U u,R r,S s);

}
