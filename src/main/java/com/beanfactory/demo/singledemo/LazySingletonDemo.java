package com.beanfactory.demo.singledemo;
/*
* 懒汉模式
* */
public class LazySingletonDemo {
    private static volatile LazySingletonDemo instance ;
    private LazySingletonDemo(){


    }
//    public static synchronized LazySingletonDemo  getInstance(){
//        if(instance ==  null){
//            instance = new LazySingletonDemo();
//
//        }
//        return instance;
//    }

    /*
    *
    * 双重锁机制
    * */
    public static synchronized LazySingletonDemo getInstance(){
            if(instance == null){
                synchronized (LazySingletonDemo.class) {

                    instance = new LazySingletonDemo();
                }
            }
 return instance;

    }

}
