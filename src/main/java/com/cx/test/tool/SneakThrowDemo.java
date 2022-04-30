package com.cx.test.tool;

import lombok.SneakyThrows;

/**
 * @author chenxiang
 * @vesion 1.0
 * @Description TODO
 * @createTime 2022-04-10 14:30:30
 */
public class SneakThrowDemo {

    public static void main(String[] args) {
        test();
    }


    //@SneakyThrows(Exception.class)
    public static void test(){
        int i = 2/0;
    }
}
