package com.cx.test;

import com.cx.test.common.Student;
import com.google.common.collect.Lists;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;


/**
 * @author chenxiang
 * @vesion 1.0
 * @Description TODO
 * @createTime 2022-04-09 16:48:48
 */
public class CollectionsDemo2 {
    public static void main(String[] args) {
        List<Student> studentList = Lists.newArrayList(
                Student.builder().code("4322").name("王五").sex("male").grade(98).build(),
                Student.builder().code("123").name("张三").sex("female").grade(34).build(),
                Student.builder().code("456").name("李四").sex("male").grade(32).build());
        //分组
        Map<String, List<Student>> collect = studentList.stream().collect(groupingBy(Student::getSex));
        System.out.println("1=========="+collect);
        //分组后的操作 counting summing maxby minby mapping
        Map<String, Long> collect1 = studentList.stream().collect(groupingBy(Student::getSex, counting()));
        System.out.println("2=========="+collect1);
        Map<String, IntSummaryStatistics> collect2 = studentList.stream().collect(groupingBy(Student::getSex, summarizingInt(Student::getGrade)));
        System.out.println("3=========="+collect2);
        Map<String, Integer> collect3 = studentList.stream().collect(groupingBy(Student::getSex, summingInt(Student::getGrade)));
        System.out.println("4=========="+collect3);
        Map<String, Optional<Student>> collect4 = studentList.stream().collect(groupingBy(Student::getSex, maxBy(Comparator.comparing(Student::getGrade))));
        System.out.println("5=========="+collect4);

        //分类
        Map<Boolean, List<Student>> collect5 = studentList.stream().collect(groupingBy(student -> student.getSex().equals("male")));
        System.out.println("6=========="+collect5);
        // Map的merge功能
        Map<String,Integer> scoreMap = new HashMap<>();
        studentList.forEach(student -> {
            scoreMap.merge(student.getSex(),student.getGrade(),Integer::sum);
        });
        System.out.println("7=========="+scoreMap);

        //Collectors的joining功能
        String collect6 = studentList.stream().map(Student::getName).collect(joining());
        System.out.println("8=========="+collect6);
        String collect7 = studentList.stream().map(Student::getName).collect(joining(","));
        System.out.println("9=========="+collect7);
        String collect8 = studentList.stream().map(Student::getName).collect(joining(",", "[", "]"));
        System.out.println("10=========="+collect8);

        //统计功能
        DoubleSummaryStatistics doubleSummaryStatistics = studentList.stream().collect(summarizingDouble(Student::getGrade));
        System.out.println("11=========="+doubleSummaryStatistics);
    }
}
