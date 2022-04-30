package com.cx.test.tool;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author chenxiang
 * @vesion 1.0
 * @Description countDownLatch
 * @createTime 2022-04-30 09:47:47
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);

        for(int i=0;i<3;++i){
            new Thread(()->{
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {

                }finally {
                    countDownLatch.countDown();
                }
            }).start();
        }
        boolean await = countDownLatch.await(3, TimeUnit.SECONDS);
        System.out.println(await);
    }
}
