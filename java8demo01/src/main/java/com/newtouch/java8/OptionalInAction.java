package com.newtouch.java8;

import java.util.Optional;

/**
 * Created by grzha on 2021/10/5.
 */
public class OptionalInAction {

    public static void main(String[] args) {
//        System.out.println(getNameByOptional(null));
//        Optional.ofNullable(getNameByOptional(null)).ifPresent(System.out::println);
        System.out.println(getNameByOptional(null));
        System.out.println(getNameByOptional(new Person()));
        System.out.println(getNameByOptional(new Person(new Car())));
        System.out.println(getNameByOptional(new Person(new Car(new Insurance()))));
        System.out.println(getNameByOptional(new Person(new Car(new Insurance("人寿")))));

        System.out.println("---------------------------------------------");
        System.out.println(getName(null));
        System.out.println(getName(new Person()));
        System.out.println(getName(new Person(new Car())));
        System.out.println(getName(new Person(new Car(new Insurance()))));
        System.out.println(getName(new Person(new Car(new Insurance("人寿")))));





    }

    public static String getNameByOptional(Person person) {
        return Optional.ofNullable(person)
                .flatMap(peo -> Optional.ofNullable(peo.getCar()))
                .flatMap(car -> Optional.ofNullable(car.getInsurance()))
                .flatMap(insurance -> Optional.ofNullable(insurance.getName()))
                .orElse("nokown");
    }

    public static String getName(Person person){
        return Optional.ofNullable(person)
                .map(Person::getCar)
                .map(Car::getInsurance)
                .map(Insurance::getName)
                .orElse("未知");



    }






}
