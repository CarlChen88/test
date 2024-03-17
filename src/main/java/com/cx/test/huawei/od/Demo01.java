package com.cx.test.huawei.od;

import java.util.Scanner;

/**
 * @author chenxiang
 * @vesion 1.0
 * @Description 题目：
 * 给定一个数组，数组中的每个元素代表该位置的海拔高度。
 * 0表示平地，>=1时表示属于某个山峰，山峰的定义为当某个位置的左右海拔均小于自己的海拔时，该位置为山峰。
 * 数组起始位置计算时只可满足一边的条件。
 * 输入描述
 * 输入一个数组
 * 输出描述
 * 输出符合条件的山峰的个数
 * @createTime 2024-03-10 07:49:49
 */
public class Demo01 {
    public static void main(String[] args) {
        //输入0,1,2,3,2,4
        Scanner in = new Scanner(System.in);
        String input_str = in.nextLine();
        String[] tmp2 = input_str.split(",");
        int[] nums = new int[tmp2.length];
        for(int i =0;i<tmp2.length;i++){
            nums[i]= Integer.parseInt(tmp2[i]);
        }
        System.out.println(validMountainCount(nums));
    }
    public static int validMountainCount(int[] arr){
        int result =0;
        int i=0;
       int arr_len = arr.length;
       while(true){
           if(i>=arr_len){
               return result;
           }
           if(i==0){
               if(arr[i]>arr[i+1] && arr[i] >0){
                   result = result +1;
               }

           }else if (i==arr_len-1){
               if(arr[i]>arr[i-1] && arr[i]>0){
                   result = result +1;
               }
           }else{
               if (arr[i] > arr[i-1] && arr[i]>arr[i+1]) {
                   result = result +1;
               }
           }
           i++;
        }
    }


}
