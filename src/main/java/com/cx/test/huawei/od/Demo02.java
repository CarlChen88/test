package com.cx.test.huawei.od;

/**
 * @author chenxiang
 * @vesion 1.0
 * @Description 数据变量单元的替换
 * @createTime 2024-03-10 20:27:27
 * 输入：123<B>32,24<C>,34
 * 输出：123243432,2434,34
 */

import java.util.Scanner;

public class Demo02 {
    public static String[] cells;
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        String input_str = in.nextLine();
        cells = input_str.split(",");
        for(int i=0;i<cells.length;i++){
            if(!changeChar(cells[i], i)){
                System.out.println(-1);
                return;
            }
        }
        for(int i=0;i<cells.length;i++){
            System.out.print(cells[i]);
            if(i!=cells.length-1){
                System.out.print(",");
            }
        }
    }

       /* public static boolean change(String cur_str, int index){
            int result1 = cur_str.indexOf("<");
            int result2 = cur_str.indexOf(">");

            if (result1==-1 && result2==-1){
                return true;
            } else if (result1==-1 || result2==-1){
                //异常
                return false;
            } else if (result1 > result2 || result2-result1 != 2){
                //异常
                return false;
            } else {
                char target_pos = cur_str.substring(result1+1, result2).charAt(0);
                char cur_pos = (char)(index+'A');
                if(!(target_pos>='A' && target_pos<='Z')){
                    //异常
                    return false;
                }
                if(cur_pos==target_pos){
                    //异常
                    return false;
                }
                int target_index = target_pos-'A';
                if (!change(cells[target_index], target_index)){
                    return false;
                }
                String temp_result = "";
                temp_result += cur_str.substring(0, result1);
                temp_result += cells[target_index];
                temp_result += cur_str.substring(result2+1);
                cells[index] = temp_result;
            }
            return true;
        }*/

        public static boolean changeChar(String str,int index){
            int result1 = str.indexOf("<");
            int result2 = str.indexOf(">");
            if(result1==-1&&result2==-1){
                return true;
            }else if (result1==-1 || result2==-1){
                return false;
            }else if (result1>result2 || result2-result1!=2){
                return false;
            }else{
                //123<A>323
                char target_pos = str.substring(result1+1,result2).charAt(0);
                char cur_pos = (char)(index+'A');
                if(!(target_pos>='A' && target_pos <='Z')){
                    return false;
                }
                if(cur_pos==target_pos){
                    return false;
                }
                int target_index = target_pos - 'A';
                if(!changeChar(cells[target_index],target_index)){
                    return false;
                }
                String temp_str="";
                temp_str+=str.substring(0,result1);
                temp_str+=cells[target_index];
                temp_str+=str.substring(result2+1);
                cells[index] = temp_str;
            }
            return true;
        }
}
