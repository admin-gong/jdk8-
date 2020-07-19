package com.beanfactory.demo;

import sun.security.util.Length;

public class BubbleSortDemo01 {
    public static void main(String[] args) {
        int list [] =  {1,5,32,545,67} ;
          int temp = 0;
        int flag = 1;
         for(int i=0;i<list.length-1;i++){
             for(int j=0;j<list.length-1-i;j++){
                 if(list[j]<list[j+1]){
                     temp =list[j];
                     list[j] = list[j+1];
                     list[j+1]=temp;
                     flag =0;
                 }
             }
         }
         for (int count : list){

             System.out.println("排序后的+"+count);
         }
       if(flag == 1){

            return ;
       }
    }
}
