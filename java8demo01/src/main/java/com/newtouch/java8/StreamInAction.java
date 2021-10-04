package com.newtouch.java8;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * Created by grzha on 2021/10/4.
 */
public class StreamInAction {

    public static void main(String[] args) {
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");
        Trader raoul = new Trader("Raoul", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        //2011年，按照名字排序
        transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(Comparator.comparing(transaction -> transaction.getTrader().getName()))
                .forEach(System.out::println);
        System.out.println("-------------------------------");
        //2011年，按照value排序
        transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .forEach(System.out::println);
        System.out.println("-------------------------------");
        //交易员都在哪些不同的城市工作过
        transactions.stream().map(transaction -> transaction.getTrader().getCity()).distinct().forEach(System.out::println);
        System.out.println("-------------------------------");
        //查找所有来自于剑桥的交易员，并按姓名排序
        transactions.stream().map(Transaction::getTrader).filter(trader -> StringUtils.equals("Cambridge",trader.getCity())).distinct()
                .sorted(Comparator.comparing(Trader::getName)).forEach(System.out::println);
        System.out.println("-------------------------------");
        //返回所有交易员的姓名字符串，按字母顺序排序
        transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted(Comparator.comparing(name -> name))
                .reduce((name1, name2) -> name1 + name2).ifPresent(System.out::println);
        System.out.println("-------------------------------");
        //有没有交易员是在米兰工作的
        boolean milan = transactions.stream()
                .map(Transaction::getTrader)
                .anyMatch(trader -> StringUtils.equals("Milan", trader.getCity()));
        System.out.println(milan);
        System.out.println("-------------------------------");
        //打印生活在剑桥的交易员的所有交易额
        transactions.stream()
                .filter(transaction -> StringUtils.equals("Cambridge",transaction.getTrader().getCity()))
                .map(Transaction::getValue)
                .reduce(Integer::sum)
                .ifPresent(System.out::println);
        System.out.println("-------------------------------");
        //所有交易中，最高的交易额是多少
        transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::max)
                .ifPresent(System.out::println);
        System.out.println("-------------------------------");
        //找到交易额最小的交易
        transactions.stream()
                .sorted(Comparator.comparing(Transaction::getValue))
                .limit(1)
                .forEach(System.out::println);
        System.out.println("-------------------------------");






    }


}
