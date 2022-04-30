package com.cx.test.common;

import java.util.Arrays;
import java.util.List;

/**
 * @author chenxiang
 * @vesion 1.0
 * @Description Arrays 示例
 * @createTime 2022-04-30 18:35:35
 */
public class ArraysDemo {
    public static void main(String[] args) {
        String[] strings = new String[]{"a","b"};
        List<String> list = Arrays.asList(strings);
        System.out.println(list);
        //
        list.add("c");
        System.out.println(list);
    }
}
