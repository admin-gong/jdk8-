package com.beanfactory.demo.ThreadPool;

import java.sql.Time;
import java.util.concurrent.*;
/**
 * new ThreadPoolExecutor.AbortPolicy() // 银行满了，还有人进来，不处理这个人的，抛出异
 常
 * new ThreadPoolExecutor.CallerRunsPolicy() // 哪来的去哪里！
 * new ThreadPoolExecutor.DiscardPolicy() //队列满了，丢掉任务，不会抛出异常！
 * new ThreadPoolExecutor.DiscardOldestPolicy() //队列满了，尝试去和最早的竞争，也不会
 抛出异常！
 */

/**
 * 最大线程该如何定义
 * cpu 密集型 几核定义为几  保证cpu的效率最高
* System.out.println(Runtime.getRuntime().availableProcessors()); 获取当前的机器的线程
 *io密集型 : 判断线程池中占据io大的线程 一般为当前io的俩被
 *
 *
 **/

public class RejectThreadPool {
    public static void main(String[] args) {
           ExecutorService threadPool = new ThreadPoolExecutor(2,3,2, TimeUnit.SECONDS,
                   new LinkedBlockingQueue<>(3),
                   Executors.defaultThreadFactory(),
                   new ThreadPoolExecutor.AbortPolicy()); //银行满了，还有人进来，不处理这个人，抛出异常


    }
}
