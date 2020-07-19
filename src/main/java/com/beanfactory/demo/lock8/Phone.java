package com.beanfactory.demo.lock8;

import java.util.concurrent.TimeUnit;

public class Phone {
    public static void main(String[] args) throws InterruptedException {
        Active active = new Active();
        new Thread(()->{
            active.sendSms();
        },"a").start();
        TimeUnit.SECONDS.sleep(1);
        new Thread(()->{
            active.call();
        },"b").start();

    }
}


class Active {
        //发短信
    public synchronized void sendSms(){

        System.out.println("send Sms");
    }

    //打电话
    public synchronized void call(){
        System.out.println("call");

    }

}


