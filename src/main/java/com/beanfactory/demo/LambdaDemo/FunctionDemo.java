package com.beanfactory.demo.LambdaDemo;

import java.util.function.Function;
/*
* 函数式接口  一个输入阐述 一个输出阐述
*
* */
public class FunctionDemo
{
    public static void main(String[] args) {
//        Function function = new Function<String,String>() {
//            @Override
//            public String apply(String str) {
//                return str;
//            }
//        };

    Function function  = (str)->{return  str;};
        System.out.println(function.apply("123"));

    }
}
