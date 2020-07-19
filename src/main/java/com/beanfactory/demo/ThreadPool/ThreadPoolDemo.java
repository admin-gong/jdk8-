package com.beanfactory.demo.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
* 程序的运行本质是占用系统资源 优化资源的使用
* 线程池  连接池  内存池  对象池
* 池化技术:  事先准备好一些资源 ，有人要用，就到我这里拿，用完之后给我
*
*线程池的好处: 降低资源消耗。  提高响应的速度 方便管理
*
* 核心作用： 线程复用 ，管理线程  调高效率
* */
public class ThreadPoolDemo {
    public static void main(String[] args) {
        //可缓冲线程池，遇强则强
        //ExecutorService threadPool = Executors.newCachedThreadPool();
        //单例的线程池 只能存在一个线程
       // ExecutorService threadPool = Executors.newSingleThreadExecutor();
        //固定数量线程池

        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        for(int i=0;i<100;i++){
            threadPool.execute(()->{
                System.out.println(Thread.currentThread().getName()+"ok");
            });
        }


    }


}
