package com.cx.test.huawei.od;

import java.util.*;

/**
 * @author chenxiang
 * @vesion 1.0
 * @Description 会议室占用时间
 * @createTime 2024-03-17 15:19:19
 * 输入：[[3,4], [2,5],[7,14], [13,18]]
 * 输出：[[2, 5], [7, 18]]
 */
public class Demo09 {

        public static void main(String[] args) {
            int[][] meetings = {{3,4}, {2,5},{7,14}, {13,18}};
            merge(meetings);
        }

        public static int[][] merge(int[][] meetings) {
            Arrays.sort(meetings, (a, b) -> (a[0] - b[0]));
            LinkedList<int[]> result = new LinkedList<>();
            int[] begin = meetings[0];
            int i=1;
            while(true){
                if(i>=meetings.length){
                    break;
                } else {
                    if (begin[1] >= meetings[i][0] && begin[1] <= meetings[i][1]) {
                        begin[1] = meetings[i][1];
                    } else if(begin[1] > meetings[i][1]){

                    } else {
                        result.add(begin);
                        begin = meetings[i];
                    }
                }
                i+=1;
            }
            result.add(begin);
            int[][] return_data= new int[result.size()][2];
            for (int j=0;j<result.size();j++){
                return_data[j][0] = result.get(j)[0];
                return_data[j][1] = result.get(j)[1];
            }
            System.out.println(Arrays.deepToString(return_data));
            return return_data;
        }
}
