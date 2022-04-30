package com.cx.test.tool;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @author chenxiang
 * @vesion 1.0
 * @Description TODO
 * @createTime 2022-04-10 10:56:56
 */
public class CompletableFutureDemo2 {
    public static void main(String[] args) {
        test();
    }

    public static void test(){
        List<String> list = Lists.newArrayList("one","two");
        Map<String,String> map = new ConcurrentHashMap<>();
        CompletableFuture.anyOf(list.stream().map(str->CompletableFuture.runAsync(()->{
            map.put(str,str);
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        })).toArray(CompletableFuture[]::new)).join();
        System.out.println(map);
    }
}
