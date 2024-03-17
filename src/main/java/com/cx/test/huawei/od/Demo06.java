package com.cx.test.huawei.od;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author chenxiang
 * @vesion 1.0
 * @Description 体育馆找座位
 * 输入10001
 * 输出1
 * 输入0101
 * 输出0
 * @createTime 2024-03-16 14:27:27
 */
public class Demo06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = Arrays.stream(scanner.nextLine().split("")).mapToInt(Integer::parseInt).toArray();
        System.out.println(findSeat(array));
    }
    public static int findSeat(int[] nums){
        int n = nums.length;
        int count = 0;
        if(n==1 && nums[0]==0){
            return 1;
        }else if(n==1 && nums[0]==1){
            return 0;
        }
        for(int i=0;i<n;i++){
            if(i>=n) return count;
            if(i==0){
                if(nums[i]==0 && nums[i+1]==0){
                    nums[i]=1;
                    count+=1;
                }
            }else if (i==nums.length-1){
                if(nums[i-1]==0 && nums[i]==0){
                    nums[i]=1;
                    count+=1;
                }
            }else{
                if(nums[i]==0 && nums[i-1]==0 &&nums[i+1]==0){
                    nums[i]=1;
                    count+=1;
                }
            }
        }
        return count;
    }
}
