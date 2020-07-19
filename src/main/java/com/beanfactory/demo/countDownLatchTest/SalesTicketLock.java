package com.beanfactory.demo.countDownLatchTest;

import org.apache.ibatis.javassist.bytecode.stackmap.BasicBlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SalesTicketLock {

    public static void main(String[] args) {
        Ticket1 ticket1 = new Ticket1();

        new Thread(() -> {
            for (int i = 1; i < 60; i++) ticket1.sales();
        }, "a").start();
        new Thread(() -> {
            for (int i = 1; i < 60; i++) ticket1.sales();
        }, "b").start();
        new Thread(() -> {
            for (int i = 1; i < 60; i++) ticket1.sales();
        }, "c").start();


    }
}
class Ticket1 {
    Lock lock = new ReentrantLock();
    private int number = 50;

    public void sales() {
        try {
            lock.lock();
            if (number > 0) {
                System.out.println(Thread.currentThread().getName() + "当前买了第" + number + "张票" + "剩余" + (number--) + "张票");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

