package com.beanfactory.demo.LambdaDemo;

import java.sql.SQLOutput;
import java.util.function.Predicate;

/*
* 断定型接口
*
*
* */
public class PredicateDemo {


    public static void main(String[] args) {
        //    Predicate predicate = new Predicate<String>() {
//        @Override
//        public boolean test(String o) {
//
//            return o.isEmpty();
//        }
//    };
        Predicate<String> predicate1 = (str)->{return str.isEmpty();};
        System.out.println(predicate1.test(""));

    }




}
