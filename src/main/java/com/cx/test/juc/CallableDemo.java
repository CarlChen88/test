package com.cx.test.juc;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @author chenxiang
 * @vesion 1.0
 * @Description TODO
 * @createTime 2022-04-19 21:24:24
 */
public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> futureTask = new FutureTask<String>(()->{
            TimeUnit.SECONDS.sleep(2);
            return "sss";
        });
        new Thread(futureTask).start();
        System.out.println(futureTask.get());
        System.out.println(futureTask.isDone());
    }
}
