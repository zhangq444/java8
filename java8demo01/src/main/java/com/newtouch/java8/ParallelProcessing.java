package com.newtouch.java8;

import java.util.function.Function;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * Created by grzha on 2021/10/6.
 */
public class ParallelProcessing {

    public static void main(String[] args) {
        System.out.println("nomalAdd:"+measureSumTime(ParallelProcessing::nomalAdd,10000000));
        System.out.println("iterateStream:"+measureSumTime(ParallelProcessing::iterateStream,10000000));
//        System.out.println("iterateStreamParallel:"+measureSumTime(ParallelProcessing::iterateStreamParallel,10000000));
        System.out.println("iterateStreamParallel2:"+measureSumTime(ParallelProcessing::iterateStreamParallel2,10000000));
        System.out.println("iterateStreamParallel3:"+measureSumTime(ParallelProcessing::iterateStreamParallel3,10000000));

    }

    public static long measureSumTime(Function<Long, Long> function, long limit) {
        Long fastest = Long.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            long startTime = System.currentTimeMillis();
            Long result = function.apply(limit);
            long endTime = System.currentTimeMillis();
            long duration = endTime - startTime;
//            System.out.println("the result sum :" + result);
            if (duration < fastest) {
                fastest = duration;
            }
        }
        return fastest;
    }


    public static long iterateStream(long limit) {
        return Stream.iterate(1L, i -> i + 1).limit(limit).reduce(0L, Long::sum);
    }

    public static long iterateStreamParallel(long limit) {
        return Stream.iterate(1L, i -> i + 1).parallel().limit(limit).reduce(0L, Long::sum);
    }

    public static long iterateStreamParallel2(long limit) {
        return Stream.iterate(1L, i -> i + 1).mapToLong(Long::intValue).parallel().limit(limit).reduce(0L, Long::sum);
    }

    public static long iterateStreamParallel3(long limit) {
        return LongStream.rangeClosed(1,limit).parallel().sum();
    }

    public static long nomalAdd(long limit) {
        long result = 0L;
        for (long i = 1L; i <= limit; i++) {
            result += i;
        }
        return result;
    }


}
