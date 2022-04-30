package com.cx.test.juc;

import java.util.concurrent.Semaphore;

/**
 * @author chenxiang
 * @vesion 1.0
 * @createTime 2022-04-17 20:28:28
 */
public class SemaphoreDemo {
    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(3);


        for (int i = 0; i < 8; i++) {

            final int num = i;
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(num + "号车停车");
                    System.out.println(num + "离开");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }


            }).start();

        }
    }
}
