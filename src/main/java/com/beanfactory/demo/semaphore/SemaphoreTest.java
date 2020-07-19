package com.beanfactory.demo.semaphore;



import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
//原理 ： aquire 获取  （假设已经满了，等待，等待被释放为止）
// relase 释放  会将当前的信号释放量+1 然后 唤醒等待的线程
// 作用： 多个共享资源的使用，并发限流 ，控制最大的线程数
public class SemaphoreTest {
    public static void main(String[] args) {
        //线程数量： 停车位
        Semaphore semaphore = new Semaphore(3);
        for(int i=1;i<=6;i++){
            new Thread(()->{
                //acquire 得到
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"抢到车位");
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println(Thread.currentThread().getName()+"离开车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                }

            },String.valueOf(i)).start();

        }
    }
}
