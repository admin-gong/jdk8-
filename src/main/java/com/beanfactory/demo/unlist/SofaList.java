package com.beanfactory.demo.unlist;


import java.util.Arrays;
import java.util.List;
/**
*
* @author  gxj
 * 单线程情况下List 是安全的,多线程情况下不安全
*
*
*
* */

public class SofaList {
    public static void main(String[] args) {
        List<String> list1 =  Arrays.asList("1","2","3");
        list1.forEach(System.out::println);

    }



}
