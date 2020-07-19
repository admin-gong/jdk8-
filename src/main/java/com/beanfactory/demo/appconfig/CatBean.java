package com.beanfactory.demo.appconfig;

import com.beanfactory.demo.entity.cat;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CatBean {
    @Bean(name="cat")
    public cat configureCat() {

        return new cat();

    }

    public static void main(String[] args) {
        String a ="123";
        String b = "123";
        System.out.println(a.equals(b));
    }



}
