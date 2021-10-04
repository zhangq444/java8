package com.newtouch.java8;

import java.util.Optional;

/**
 * Created by grzha on 2021/10/5.
 */
public class OptionalUsage {

    public static void main(String[] args) {
        Optional<Insurance> empty = Optional.empty();
        Optional<Insurance> insurance = Optional.of(new Insurance());
        Optional<Insurance> o = Optional.ofNullable(null);

        Insurance 平安 = insurance.orElse(new Insurance("平安"));
        Insurance insurance1 = insurance.orElseGet(Insurance::new);
        Insurance insurance2 = insurance.orElseThrow(() -> new RuntimeException("没有对象"));

        Optional<String> stringOptional = insurance.map(i -> i.getName());
        System.out.println(stringOptional.orElse("空值"));

        System.out.println(getInsurance(null));
        System.out.println(getInsuranceByOptional(null));

    }

    public static String getInsurance(Insurance insurance){
        if(null==insurance){
            return "UNKNOW";
        }
        return insurance.getName();
    }

    public static String getInsuranceByOptional(Insurance insurance){
        return Optional.ofNullable(insurance).map(Insurance::getName).orElse("UNKNOW");
    }





}
