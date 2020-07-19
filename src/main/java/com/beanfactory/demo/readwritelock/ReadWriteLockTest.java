package com.beanfactory.demo.readwritelock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/*
*
* ReadWriteLock
* 内置俩个锁 读锁是共享锁，可以多个线程一起使用，写锁是独占锁，一次只能是一个线程占有。达到读写分离的要求
*
* */
public class ReadWriteLockTest
{
    public static void main(String[] args) {
        MyCache myCache = new MyCache();
        //写入
        for(int i=1;i<=5;i++){
            final int temp = i;
            new Thread(()->{
                myCache.put(temp+"",temp+"");
            },String.valueOf(i)).start();
        }
        //读取
        for(int i=1;i<=5;i++){
            final int temp = i;
            new Thread(()->{
                myCache.get(temp+"");
            },String.valueOf(i)).start();
        }

    }

}
class MyCache{
    private volatile Map<String,Object> map = new HashMap<>(16);
    private ReadWriteLock readwritelock = new ReentrantReadWriteLock();
    public void put(String key,Object value){
        readwritelock.writeLock().lock();


        try {
            System.out.println(Thread.currentThread().getName()+"写入"+key);
            map.put(key,value);
            System.out.println(Thread.currentThread().getName()+"写入完成");
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            readwritelock.writeLock().unlock();
        }


    }
    public void get(String key){
        readwritelock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"读取"+key);
            Object o = map.get(key);
            System.out.println(Thread.currentThread().getName()+"读取完成 ");
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            readwritelock.readLock().unlock();
        }


    }


}
