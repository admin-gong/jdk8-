package com.beanfactory.demo.LambdaDemo;

import java.util.function.Supplier;

/**
 * @author  gxj
 * 供给型接口
 *
 */
public class SuppliarDemo {
    public static void main(String[] args) {
//        Supplier objectSupplier = new Supplier<Integer>() {
////            @Override
////            public Integer get() {
////                return 1024;
////            }
////        };
        Supplier objectSupplier = ()->{
            return 1024;
        };
        System.out.println(objectSupplier.get());

    }

}
