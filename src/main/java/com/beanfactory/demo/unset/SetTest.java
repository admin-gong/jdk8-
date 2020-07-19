package com.beanfactory.demo.unset;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
//hashSet底层： hashmap  数组+链表+红黑树
//set 本质是key key是无法重复的
public class SetTest {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
      for(int i=0;i<10;i++){
          new Thread(()->{
              set.add(UUID.randomUUID().toString().substring(0,5));
          },String.valueOf(i)).start();
      }
    }



}
