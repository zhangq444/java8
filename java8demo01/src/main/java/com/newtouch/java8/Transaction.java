package com.newtouch.java8;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by grzha on 2021/10/4.
 */
@Data
@AllArgsConstructor
public class Transaction {
    private Trader trader;
    private int year;
    private int value;



}
