package com.beanfactory.demo;

public class BubbleSortNormal {
    public static void main(String[] args) {
        int list[] = {1,2,3,45,65,76,34};
        int temp = 0;
        for(int i=0;i<list.length-1;i++){
            System.out.format("第 %d 遍：\n", i+1);
            for(int j=0;j<list.length-1-i;j++){
                if(list[j]<list[j+1]){
                        temp = list[j];
                        list[j]=list[j+1];
                        list[j+1]=temp;
                }
            }

        }
        System.out.println("排序过的数字");
       for (int count : list){
           System.out.println(count);
        }


    }
}
