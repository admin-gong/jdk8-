package com.beanfactory.demo.unmap;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class MapTest {
    public static void main(String[] args) {
        Map<String,String> map1 = new HashMap<>(16, (float) 0.75);
        for(int i=1;i<=30;i++){
            new Thread(()->{
                map1.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(0,5));
            }).start();

        }


    }
}
