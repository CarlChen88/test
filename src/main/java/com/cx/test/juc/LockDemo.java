package com.cx.test.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author chenxiang
 * @vesion 1.0
 * @Description TODO
 * @createTime 2022-04-16 22:03:03
 */
public class LockDemo {
    public static void main(String[] args) {

    }

    public static void test1() {
        Lock lock = new ReentrantLock();
        try {
            lock.lock();
        } catch (Exception exception) {

        } finally {
            lock.unlock();
        }
    }
}
