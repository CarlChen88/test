package com.cx.test.guava;

import com.google.common.collect.*;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author chenxiang
 * @vesion 1.0
 * @Description TODO
 * @createTime 2022-09-05 10:39:39
 */
public class GuavaDemo1 {
    public static void main(String[] args) {
        //test1();
        test2();

    }

    private static void test1() {
        // 集合的创建
        Lists.newArrayList();
        Sets.newHashSet();
        Sets.newCopyOnWriteArraySet();
        Maps.newConcurrentMap();
        Maps.newConcurrentMap();
        ImmutableList.of("1","2");
        ImmutableList.copyOf(new String[]{"1"});
        ImmutableSet.of("1");
        ImmutableSet.copyOf(new String[]{"1"});
        ImmutableMap.of();
        ImmutableMap.copyOf(Maps.newHashMap());
    }

    private static void test2() {
        Multimap<String,String> multimap = ArrayListMultimap.create();
        multimap.put("key","value1");
        multimap.put("key","value2");
        System.out.println(multimap.get("key"));
        HashMultiset<String> multiset = HashMultiset.create();
        multiset.add("k1");
        multiset.add("k1");
        System.out.println(multiset.count("k1"));
    }



}
