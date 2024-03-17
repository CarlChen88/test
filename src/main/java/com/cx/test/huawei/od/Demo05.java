package com.cx.test.huawei.od;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author chenxiang
 * @vesion 1.0
 * @Description 转盘寿司
 * @createTime 2024-03-16 11:11:11
 */
public class Demo05 {
    public static List<Integer> totalPriceList(List<Integer> list) {
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<list.size();i++){
            List<Integer> compareList = new ArrayList<>();
            if(i==0){
                compareList = list.subList(1, list.size());
            }else if (i== list.size()-1){
                compareList= list.subList(0, list.size()-1);
            }else{
                compareList.addAll(list.subList(i+1,list.size()));
                compareList.addAll(list.subList(0,i));
            }
            int price = list.get(i);
            int totalPrice = price;
            for(Integer nextPrice : compareList){
                if(nextPrice<price){
                    totalPrice+=nextPrice;
                    break;
                }
            }
            result.add(totalPrice);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> collect = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        System.out.println(totalPriceList(collect));
    }
}
