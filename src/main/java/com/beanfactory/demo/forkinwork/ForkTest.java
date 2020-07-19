package com.beanfactory.demo.forkinwork;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

public class ForkTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
       // test1();
        //test2();
        test3();
    }
    public static  void test1(){
        Long sum = 0l;
        Long start = System.currentTimeMillis();
        for (Long i = 1l; i <=10_0000_000; i++) {
            sum += i;
        }
        Long end = System.currentTimeMillis();

        System.out.println("sum="+sum+"耗费时间"+(end-start));
    }

    public static  void test2() throws ExecutionException, InterruptedException {
        Long start = System.currentTimeMillis();
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoin forkJoin = new ForkJoin(0L, 10_0000_000L);
        ForkJoinTask<Long> submit = forkJoinPool.submit(forkJoin);
        submit.get();
        Long end = System.currentTimeMillis();
        Long sum =   submit.get();

        System.out.println("sum="+sum+"耗费时间"+(end-start));
    }
    public static  void test3(){
        Long end = System.currentTimeMillis();
        //stream并行流10000
        long reduce = LongStream.rangeClosed(0L, 100000000L).reduce(0, Long::sum);
        Long start = System.currentTimeMillis();
        System.out.println("sum为"+reduce+"耗费时间"+(end-start));
    }

}
