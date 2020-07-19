package com.beanfactory.demo.singledemo;

public class SingletonHug {
    private static SingletonHug instance = new SingletonHug();
    private SingletonHug (){}
    public static SingletonHug getInstance(){
        return instance;
    }

}
