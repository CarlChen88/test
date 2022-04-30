package com.cx.test.juc;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author chenxiang
 * @vesion 1.0
 * @Description TODO
 * @createTime 2022-04-17 09:17:17
 */
public class CopyOnWriteDemo {
    public static void main(String[] args) {
        //ConcurrentModificationException
       /* List<String> list = new ArrayList<>();
        for (int i=0;i<40;i++){
            new Thread(()->{
                list.add(UUID.randomUUID().toString());
                System.out.println(list);
            }).start();
        }*/

        //写入时复制 读写分离
        List<String> list2 = new CopyOnWriteArrayList<>();
        for (int i=0;i<40;i++){
            new Thread(()->{
                list2.add(UUID.randomUUID().toString());
                System.out.println(list2);
            }).start();
        }

    }
}
