package com.beanfactory.demo.countDownLatchTest;


import javax.naming.Name;

public class SalesTicket {

    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        new Thread(() ->{
            for(int i=1;i<60;i++){
                ticket.sales();
            }
        },"a").start();

        new Thread(() ->{
            for(int i=1;i<60;i++){
                ticket.sales();
            }
        },"b").start();

        new Thread(() ->{
            for(int i=1;i<60;i++){
                ticket.sales();
            }
        },"c").start();
    }



}

     class Ticket {
        private int number = 50;

        public synchronized void sales() {
            if(number>0){
                System.out.println(Thread.currentThread().getName()+"当前买了第"+number+"张票"+"剩余"+(number--)+"张票");
            }
        }


    }


