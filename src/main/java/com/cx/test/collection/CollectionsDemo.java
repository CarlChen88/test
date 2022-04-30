package com.cx.test.collection;

import com.cx.test.common.Student;
import com.cx.test.common.Teacher;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/**
 * @author chenxiang
 * @vesion 1.0
 * @Description TODO
 * @createTime 2022-04-09 08:31:31
 */
public class CollectionsDemo {
    public static void main(String[] args) {
        List<Student> studentList = Lists.newArrayList(
                Student.builder().code("432").name("王五").build(),
                Student.builder().code("123").name("张三").build(),
                Student.builder().code("456").name("李四").build());
        List<Teacher> teacherList = studentList.stream().map(student -> Teacher.builder().code(student.getCode()).name(student.getName()).build()).collect(Collectors.toList());

        List<String> list1 = Lists.newArrayList("1","2","3","4");
        List<String> list2 = Lists.newArrayList("3","4","5");
        //交集
        List<String> intersect = list1.stream().filter(list2::contains).collect(toList());
        System.out.println(intersect);
        //差集 list1 - list2
        List<String> reduceList = list1.stream().filter(s -> !list2.contains(s)).collect(toList());
        System.out.println(reduceList);
        list1.addAll(list2);
        List<String> collect = list1.stream().distinct().collect(toList());
        System.out.println(collect);
        //过滤
        String s1 = collect.stream().filter(s -> "21".equals(s)).findAny().orElse(null);
        System.out.println(s1);
        //Map To List
        Map<String,Object> map = new HashMap<>();
        map.put("one",23);
        map.put("two",44);
        List<String> stringList = map.entrySet().stream().map(
                e -> e.getKey() + e.getValue()
        ).collect(toList());
        System.out.println(stringList);
        //排序
        List<Integer> sortList = Lists.newArrayList(34,21,14,59);
        List<Integer> collect1 = sortList.stream().sorted().collect(toList());
        System.out.println(collect1);
        List<Student> collect2 = studentList.stream().sorted(Comparator.comparing(Student::getCode).reversed()).collect(toList());
        System.out.println(collect2);
        //Collectors to Map
        Map<String, String> stringMap = studentList.stream().collect(Collectors.toMap(Student::getCode, Student::getName));
        System.out.println(stringMap);
        stringMap.forEach((key,value)->{
            System.out.println(key + ":" + value);
        });
    }

}
