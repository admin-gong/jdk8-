package com.beanfactory.demo.forkinwork;

import java.util.concurrent.RecursiveTask;

/**
 * 求和：
 *如何使用fprkjoin  ForkJoinPoll
 *
 *
 * @author beegxj*/
public class ForkJoin extends RecursiveTask<Long> {
    private Long start;
    private Long end;
    private Long temp = 10000l;

    public ForkJoin(Long start, Long end) {
        this.start = start;
        this.end = end;

    }

    @Override
    protected Long compute() {
        if (end - start < temp) {
            Long sum = 0l;
            for (Long i = start; i <=end; i++) {
                sum += i;
            }
            return sum;
        } else {
            Long middle = (start + end) / 2;  //算中间值
            ForkJoin task1 = new ForkJoin(start, middle);
            task1.fork();

            ForkJoin task2 = new ForkJoin(middle + 1, end);
            task2.fork();
            return task1.join()+task2.join();

        }

    }



//    public void Test(){
//        if(end-start>temp){
//
//            //分支合并计算
//
//        }else {
//
//
//        }
//
//
//    }
}
