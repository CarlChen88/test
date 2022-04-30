package com.cx.test.juc;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author chenxiang
 * @vesion 1.0
 * @Description TODO
 * @createTime 2022-04-21 22:13:13
 */
public class VolatileDemo {
    private volatile static int num=0;
    private static AtomicInteger atomicInteger = new AtomicInteger(0);
    public static void main(String[] args) {
        for(int i=0;i<10;i++){
            new Thread(()->{
                for(int j=0;j<1000;j++){
                    add();
                    add2();
                }
            }).start();
        }
        while (Thread.activeCount()>2){

        }
        System.out.println(num);
        System.out.println(atomicInteger.get());

    }
    public static void add(){
        num++;
    }

    public synchronized static void add1(){
        num++;
    }
    public  static void add2(){
        atomicInteger.getAndIncrement();
    }
}
