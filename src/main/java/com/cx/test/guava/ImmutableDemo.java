package com.cx.test.guava;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.ImmutableTriple;

/**
 * @author chenxiang
 * @vesion 1.0
 * @Description TODO
 * @createTime 2022-10-13 23:09:09
 */
public class ImmutableDemo {
    public static void main(String[] args) {
        ImmutablePair<String,String> immutablePair = new ImmutablePair<>("zhangsan","lisi");
        System.out.println(immutablePair.left);
        ImmutableTriple<String,Integer,String> immutableTriple = ImmutableTriple.of("cx",3,"ds");
    }
}
