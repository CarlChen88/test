package com.cx.test.tool;

import com.google.common.base.Stopwatch;

import java.util.concurrent.TimeUnit;

/**
 * @author chenxiang
 * @vesion 1.0
 * @Description TODO
 * @createTime 2022-04-16 21:37:37
 */
public class StopWatchDemo {
    public static void main(String[] args) throws InterruptedException {
        Stopwatch stopwatch = Stopwatch.createStarted();
        TimeUnit.SECONDS.sleep(2);
        System.out.println(stopwatch.elapsed(TimeUnit.MILLISECONDS));
    }

}
