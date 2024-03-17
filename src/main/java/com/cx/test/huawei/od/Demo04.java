package com.cx.test.huawei.od;
import java.util.Scanner;
import java.util.*;
import java.util.stream.Collectors;
/**
 * @author chenxiang
 * @vesion 1.0
 * @Description 找出作弊的人
 * @createTime 2024-03-16 10:05:05
 * 输入：
 * 5
 * 1 90
 * 2 91
 * 3 92
 * 4 85
 * 5 86
 * 输出：
 * 1 2
 * 2 3
 * 4 5
 */
public class Demo04 {
    public static void compareScore(List<Employee> list) {
        List<Employee2> employee2List = new ArrayList<>();
        for(int i=0;i<list.size();i++){
            Employee e1 = list.get(i);
            for(int j=i+1;j<list.size();j++){
                Employee e2 = list.get(j);
                int score = e2.getScore()>e1.getScore() ? e2.getScore()- e1.getScore() : e1.getScore()-e2.getScore();
                employee2List.add(new Employee2(e1.getId(),e2.getId(),score));
            }
        }
        int minScore = employee2List.stream().min(Comparator.comparing(Employee2::getScore)).get().getScore();
        List<Employee2> collect = employee2List.stream().filter(employee2 -> minScore == employee2.getScore()).sorted(Comparator.comparingInt(Employee2::getP1).thenComparingInt(Employee2::getP2)).collect(Collectors.toList());
        collect.forEach(employee2 -> {
            System.out.println(employee2.getP1()+" "+employee2.getP2());
        });
    }


        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int count = in.nextInt();
            List<Employee> all_employee = new ArrayList<>();
            for(int i=0; i<count; i++){
                int a = in.nextInt();
                int b = in.nextInt();
                Employee employee = new Employee(a,b);
                all_employee.add(employee);
            }
            compareScore(all_employee);
    }
}

class Employee{
            int id;
            int score;
            public Employee(int id, int score){
                this.id = id;
                this.score = score;
            }

            public int getId() {
                return id;
            }

            public int getScore() {
                return score;
            }
}

class Employee2{
    int p1;
    int p2;
    int score;

    public Employee2(int p1, int p2, int score) {
        this.p1 = p1;
        this.p2 = p2;
        this.score = score;
    }

    public int getP1() {
        return p1;
    }


    public int getP2() {
        return p2;
    }

    public int getScore() {
        return score;
    }

}
