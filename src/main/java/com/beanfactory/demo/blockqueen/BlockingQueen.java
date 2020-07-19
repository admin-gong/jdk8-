package com.beanfactory.demo.blockqueen;

import javafx.scene.effect.Blend;

import java.util.Collection;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

//什么情况下会使用blockingqueen  多线程抢矿下 线程池里面用
//四组api
/*
* 1. 抛出异常
* 2.不会抛出异常
* 3.阻塞等待
* 4 超时等待
*
* */



public class BlockingQueen {
    public static void main(String[] args) {
        //List set  collection
        Test2();
    }
    //1.抛出异常 add 加入元素  remove 移除元素   element 查看队首元素
    public static void Test1(){
        //添加add  移除remove
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue<>(3);

        System.out.println(arrayBlockingQueue.add("a"));
        System.out.println(arrayBlockingQueue.add("b"));
        System.out.println(arrayBlockingQueue.add("c"));
        //查看队首元素
        arrayBlockingQueue.element();
        //抛出异常
      //  System.out.println(arrayBlockingQueue.add("d"));
        System.out.println(arrayBlockingQueue.remove());
        System.out.println(arrayBlockingQueue.remove());
        System.out.println(arrayBlockingQueue.remove());

    }

    //2 不会抛出异常offer加入元素 poll移除元素  peek 查看队首元素
    public static void Test2(){
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue<>(3);

        System.out.println(arrayBlockingQueue.offer("a"));
        System.out.println( arrayBlockingQueue.offer("b"));
        System.out.println( arrayBlockingQueue.offer("c"));
        //不会抛出异常
       // System.out.println( arrayBlockingQueue.offer("d"));
        System.out.println("======================");
        System.out.println(arrayBlockingQueue.poll());
        System.out.println( arrayBlockingQueue.poll());
        System.out.println( arrayBlockingQueue.poll());
        //队列为空返回null
        System.out.println( arrayBlockingQueue.poll());

    }


    //等待阻塞  （一直阻塞）
    // put take

    public static  void Test3() throws InterruptedException {
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue<>(3);
        arrayBlockingQueue.put("a");
        arrayBlockingQueue.put("b");
        arrayBlockingQueue.put("c");
        //队列没有位置一直阻塞
      //  arrayBlockingQueue.put("d");
        arrayBlockingQueue.take();
        arrayBlockingQueue.take();
        arrayBlockingQueue.take();
        //没有这个元素了，一直阻塞状态
        //arrayBlockingQueue.take();
    }


    //4超时退出 还是offer而 poll
    public static  void Test4() throws InterruptedException {
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue<>(3);
        arrayBlockingQueue.offer("a");
        arrayBlockingQueue.offer("b");
        arrayBlockingQueue.offer("c");

         arrayBlockingQueue.offer("d", 2, TimeUnit.SECONDS);
        System.out.println("============");
        arrayBlockingQueue.poll();
        arrayBlockingQueue.poll();
        arrayBlockingQueue.poll();
        arrayBlockingQueue.poll(2,TimeUnit.SECONDS);

    }


}

