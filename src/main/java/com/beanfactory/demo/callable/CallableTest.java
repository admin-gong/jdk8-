package com.beanfactory.demo.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        new Thread().start();
        MyThread myThread =new MyThread();
        FutureTask futureTask = new FutureTask(myThread);
        new Thread(futureTask,"a").start();
        new Thread(futureTask,"b").start();
        Integer o = (Integer) futureTask.get();

        System.out.println(o);


    }
}
class MyThread implements Callable <Integer>{


    @Override
    public Integer call() throws Exception {
        System.out.println("callable");
        return 1024;
    }
}
