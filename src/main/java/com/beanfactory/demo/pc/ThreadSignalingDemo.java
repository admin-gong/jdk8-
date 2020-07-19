package com.beanfactory.demo.pc;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

import java.util.concurrent.locks.ReentrantLock;

/**
* @author gxj
 *
 * 使用lock 精准的唤醒锁
*
* */
public class ThreadSignalingDemo {
    public static void main(String[] args) {
        Data3  data3 = new Data3();

        new Thread(()->{for(int i=0;i<10;i++) {
            data3.printA();
        }
        },"a").start();
        new Thread(()->{for(int i=0;i<10;i++) {
            data3.printB();
        }},"b").start();
        new Thread(()->{for(int i=0;i<10;i++) {
            data3.printC();
        }},"c").start();
    }
}
class Data3{
   private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();
    private int number =1;
   public void printA(){
       lock.lock();
       try {
           while (number!=1){
               condition1.await();
           }
           System.out.println(Thread.currentThread().getName()+"=>AAAAAAAAAAAAAAAAAAA");
           number =2 ;
           condition2.signal();

       } catch (Exception e) {
           e.printStackTrace();
       }
       finally {
           lock.unlock();
       }

   }
    public void printB(){

        lock.lock();
        try {
            while (number!=2){
                condition2.await();
            }
            System.out.println(Thread.currentThread().getName()+"=>bbbbbbbbbbbbbbbbbbbbbbbb");
            number =3 ;
            condition3.signal();

        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            lock.unlock();
        }


    }

    public void printC(){
        lock.lock();
        try {
            while (number!=3){
                condition1.await();
            }
            System.out.println(Thread.currentThread().getName()+"=>cccccccccccccccccccccccc");
            number =1;

            condition1.signal();

        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            lock.unlock();
        }

    }




}

