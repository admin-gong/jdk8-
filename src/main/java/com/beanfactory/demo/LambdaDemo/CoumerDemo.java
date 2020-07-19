package com.beanfactory.demo.LambdaDemo;

import java.util.function.Consumer;

/**
 *
 * 消费型接口
 *
 *消费者只有输入没有返回值
 *
 * */
public class CoumerDemo {
    public static void main(String[] args) {
//        Consumer<String> consumer = new Consumer<String>() {
//            @Override
//            public void accept(String o) {
//                System.out.println(o);
//
//            }
//        };
        Consumer<String> consumer = (str)->{
            System.out.println(str);

        };
        consumer.accept("123");

    }




}
