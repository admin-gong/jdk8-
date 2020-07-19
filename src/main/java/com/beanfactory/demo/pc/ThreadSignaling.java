package com.beanfactory.demo.pc;
/***
 * 线程之间的通信问题
 * 生产者和消费者
 * A NUM+1
 * B NUM-1
 * 通知  等待唤醒
 *
 * **/
public class ThreadSignaling {

    public static void main(String[] args) {
        Data data  = new Data();
        new Thread(()->{
            for(int i=0;i<10;i++){
                try {
                    data.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"a").start();

        new Thread(()->{
            for(int i=0;i<10;i++){
                try {
                    data.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"b").start();

        new Thread(()->{
            for(int i=0;i<10;i++){
                try {
                    data.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"c").start();

        new Thread(()->{
            for(int i=0;i<10;i++){
                try {
                    data.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"d").start();

    }
}
class Data{
    private int number = 0;
    //+1
    public  synchronized  void increment() throws InterruptedException {
        while(number!=0){
      //等待
            this.wait();
        }
        number ++;
        System.out.println(Thread.currentThread().getName()+"=>"+number);
        this.notify();
    }
 // 减1
    public  synchronized  void decrement() throws InterruptedException {
        while(number==0){
         //等待
         this.wait();
     }
     number --;
        System.out.println(Thread.currentThread().getName()+"=>"+number);
     this.notify();
     }

 }


