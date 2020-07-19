package com.beanfactory.demo.CycliBarrierDemo;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CycliBarrierTest {
    public static void main(String[] args) {
        /***
         * 集齐七颗龙珠 召唤神龙
         *
         *
         */
        //召唤神龙的线程
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7,()->{
            System.out.println("召唤神龙成功");

        });
        for(int i=1;i<=7;i++){
            final int  temp = i;
          new Thread(()->{
              System.out.println(Thread.currentThread().getName()+"收集"+temp+"个龙珠");
              try{
                  cyclicBarrier.await();
              } catch (InterruptedException e) {
                  e.printStackTrace();
              } catch (BrokenBarrierException e) {
                  e.printStackTrace();
              }
          }).start();

        }


    }
}
