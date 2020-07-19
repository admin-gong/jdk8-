package com.beanfactory.demo.unlist;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.Vector;

public class UnSofaList {

    public static void main(String[] args) {
        List<String> alist = new Vector<>();
        for (int i=1;i<10;i++){
            new Thread(()->{
                alist.add(UUID.randomUUID().toString().substring(0,5));
                System.out.println(alist);
            }, String.valueOf(i)).start();
        }

    }


}
