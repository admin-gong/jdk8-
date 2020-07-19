package com.beanfactory.demo.singledemo;

public class SingletonLazy {
    private static volatile  SingletonLazy instance ;
    private SingletonLazy(){};
    public static synchronized SingletonLazy getInstance(){
        if(instance == null){
               synchronized (SingletonLazy.class) {
                   instance = new SingletonLazy();
               }
        }
            return instance;
    }
}
