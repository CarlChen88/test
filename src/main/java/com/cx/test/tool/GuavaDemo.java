package com.cx.test.tool;

import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicates;
import com.google.common.base.Splitter;
import com.google.common.collect.*;

import java.util.*;

/**
 * @author chenxiang
 * @vesion 1.0
 * @Description TODO
 * @createTime 2022-04-13 21:24:24
 */
public class GuavaDemo {
    public static void main(String[] args) {
        test();
    }

    public static void test(){
        //普通Collection的创建
        List<String> list = Lists.newArrayList();
        Set<String> set = Sets.newHashSet();
        Map<String,String> map = Maps.newHashMap();
        //不变Collection的创建
        ImmutableList<String> immutableList = ImmutableList.of("one","two","three");
        System.out.println("1========"+immutableList.stream().noneMatch(s -> s.equals("a")));
        System.out.println("2========"+immutableList.contains("three"));
        System.out.println("3========"+immutableList.stream().reduce("a",(a,b)->{
            return a+b;
        }));
        System.out.println("4========"+immutableList.stream().max(Comparator.comparing(String::length)));
        System.out.println("5========"+immutableList.stream().toArray());
        ImmutableSet<String> immutableSet = ImmutableSet.of("one","two","three");
        ImmutableMap immutableMap = ImmutableMap.of("k1","v1","k2","v2");
    }

    public static void test1(){
        Multimap<String,Integer> multimap = ArrayListMultimap.create();
        multimap.put("a",1);
        multimap.put("a",2);
        Collection<Integer> collection = multimap.get("a");
        System.out.println(collection);
        System.out.println("===================================");
        Multiset<String> multiset = HashMultiset.create();
        multiset.add("one");
        multiset.add("one");
        System.out.println();
        System.out.println(multiset.count("one"));
        System.out.println("===================================");
        BiMap<String,String> biMap = HashBiMap.create();
        biMap.put("one","one");
        biMap.put("one","two");
        System.out.println(biMap);
        System.out.println("===================================");
        Table<String,String,Integer> table = HashBasedTable.create();
        table.put("one","two",2);
        table.put("one","two",3);
        System.out.println(table);
        Integer integer = table.get("two", "one");
        System.out.println(integer);
    }

    public static void test2(){
        List<String> list = Lists.newArrayList();
        list.add("a");
        list.add("b");
        list.add("c");
        String join = Joiner.on("-").join(list);
        System.out.println(join);
        StringBuilder stringBuilder = Joiner.on("=").appendTo(new StringBuilder("chenxiang"), list);
        System.out.println(stringBuilder);
        Map<String,Integer> map = Maps.newHashMap();
        map.put("one",1);
        map.put("two",2);
        String joinMap = Joiner.on(",").withKeyValueSeparator("=").join(map);
        System.out.println(joinMap);
        System.out.println("===========================================");
        List<String> splitToList = Splitter.on("-").splitToList("a-b-c");
        System.out.println(splitToList);
        List<String> splitToList1 = Splitter.on('-').omitEmptyStrings().trimResults().splitToList("a -b -c  ");
        System.out.println(splitToList1);
        List<String> splitToList2 = Splitter.onPattern("[.|,]").omitEmptyStrings().trimResults().splitToList("aa.ddd,ff..");
        System.out.println(splitToList2);
    }

    public static void test3() {
        //集合过滤
        ImmutableList<String> immutableList = ImmutableList.of("begin", "code", "Guava", "java");
        Iterable<String> filter = Iterables.filter(immutableList, Predicates.or(Predicates.equalTo("java"), Predicates.equalTo("Guava")));
        System.out.println(filter);
        boolean aa = Predicates.and(Predicates.isNull()).apply("aa");
        System.out.println(aa);
    }

    public static void test4() {
        String str = "aaa";
        try {
            Preconditions.checkArgument(str.equals("aa"),"参数不符合");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        Preconditions.checkNotNull(null,"参数不能为空");
        Preconditions.checkState(str.equals("aa"),"参数不符合2");
    }

    public static void  test5() {
        Ordering<String> ordering = Ordering.natural().onResultOf((a)->a);
        ordering.compare("one","two");
    }

    public static void test6(){
        HashSet<Integer> setA = Sets.newHashSet(1,2,129,3);
        HashSet<Integer> setB = Sets.newHashSet(7,2,129,9);
        Sets.SetView<Integer> union = Sets.union(setA, setB);
        union.stream().forEach(System.out::print);
        System.out.println("=====================");
        Sets.SetView<Integer> difference = Sets.difference(setA, setB);
        difference.stream().forEach(System.out::println);
        System.out.println("=====================");
        Sets.SetView<Integer> intersection = Sets.intersection(setA, setB);
        intersection.stream().forEach(System.out::println);
    }

    public static void test7(){
        //校验最多两位小数
        /**
         * 正则表达式
         * +标识1次或多次
         * ?标识1次或0次
         * *标识0次或多次
         * |或者
         * [0-9]数字
         * {1，3}标识前面的数字出现1到3次
         */
        boolean apply = Predicates.containsPattern("^(0|([1-9][0-9]*))(.[0-9]{1,2})?$").apply("1.22");
        System.out.println(apply);
    }
}
