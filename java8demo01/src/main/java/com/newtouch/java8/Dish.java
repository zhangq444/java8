package com.newtouch.java8;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by grzha on 2021/10/3.
 */
@Data
@AllArgsConstructor
public class Dish {

    private String name;
    private boolean vegetarian;
    private int calories;
    private Type type;



    public enum Type{
        MEAT,FISH,OTHER
    }



}
