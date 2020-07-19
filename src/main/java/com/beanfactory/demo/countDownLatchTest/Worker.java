package com.beanfactory.demo.countDownLatchTest;



import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class Worker implements  Runnable {

private CountDownLatch countDownLatch;
private String name;

    public Worker(CountDownLatch countDownLatch, String name) {
        this.countDownLatch = countDownLatch;
        this.name = name;
    }

    @Override
    public void run() {
        this.doWork();
        try {
            TimeUnit.SECONDS.sleep(new Random().nextInt(10));
        } catch (InterruptedException e) {
        }
        System.out.println(this.name+"活干完了");
        countDownLatch.countDown();

    }

    public void  doWork(){

        System.out.println(this.name+"工人正在工作");
    }
}
