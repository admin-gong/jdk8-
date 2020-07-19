package com.beanfactory.demo;

import com.beanfactory.demo.appconfig.CatBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanTest {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext ac  = new AnnotationConfigApplicationContext(CatBean.class);
        System.out.println(ac.getBean("cat"));


    }
}
