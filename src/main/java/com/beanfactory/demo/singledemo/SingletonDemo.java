package com.beanfactory.demo.singledemo;
/*
* 饿汉模式
* */
public class SingletonDemo {
     private  static  SingletonDemo instance = new SingletonDemo();
     private SingletonDemo(){

    }
    public static SingletonDemo getInstance()
    {

        return instance;
    }
}
