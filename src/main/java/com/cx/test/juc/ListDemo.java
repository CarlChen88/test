package com.cx.test.juc;

import com.google.common.collect.Lists;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;


/**
 * @author chenxiang
 * @vesion 1.0
 * @Description TODO
 * @createTime 2022-09-03 09:23:23
 */
public class ListDemo {
    public static void main(String[] args) {
       //test1();
       test2();
    }

    private static void test2() {
        List<String> list = new CopyOnWriteArrayList<>();
        for (int i=0;i<10;i++){
            final int j = i;
            new Thread(()->{
                list.add(j+"");
                System.out.println(list);
            }).start();
        }
    }
    private static void test3() {
       Set<String> set = new CopyOnWriteArraySet<>();
        for (int i=0;i<10;i++){
            final int j = i;
            new Thread(()->{
                set.add(j+"");
                System.out.println(set);
            }).start();
        }
    }
    private static void test4() {
        Map<String,String> map = new ConcurrentHashMap<>();
        for (int i=0;i<10;i++){
            final int j = i;
            new Thread(()->{
               map.put(j+j+"",j+"");
                System.out.println(map);
            }).start();
        }
    }

    private static void test1() {
        List<String> list = Lists.newArrayList();
        for (int i=0;i<10;i++){
            final int j = i;
            new Thread(()->{
                list.add(j+"");
                System.out.println(list);
            }).start();
        }
    }
}
