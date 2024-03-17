package com.cx.test.huawei.od;

import java.util.Scanner;
import java.util.*;

/**
 * @author chenxiang
 * @vesion 1.0
 * @Description 5G网络建设
 * @createTime 2024-03-16 14:54:54
 */
public class Demo07 {
        public static class UF {
            int root[];
            int rank[];
            int count;
            UF(int size) {
                root = new int[size+1];
                rank = new int[size+1];
                count = 0;
                for (int i = 0; i < size+1; i++) {
                    root[i] = i;
                    rank[i] = 1;
                }
            }
            // root[4] {0,1,2,3}
            // rank[4] {0,1,2,3}
            // find(1) 1==
            int find(int x) {
                if (x == root[x]) {
                    return x;
                }
                return root[x] = find(root[x]);
            }
            void union(int x, int y) {
                root[find(x)] = find(y);
                count+=1;
            };

            int get_count() {
                return count;
            }
        }

        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            int m = in.nextInt();
            in.nextLine();
            UF uf = new UF(n);

            List<int[]> networks = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                String input_str = in.nextLine();
                String[] tmp2 = input_str.split(" ");
                int[] nums = new int[tmp2.length];
                for (int j = 0; j < tmp2.length; j++) {
                    nums[j] = Integer.parseInt(tmp2[j]);
                }
                if (nums[3] == 1) {
                    if (uf.find(nums[0]) != uf.find(nums[1])) {
                        uf.union(nums[0], nums[1]);
                    }
                } else {
                    networks.add(new int[]{nums[0],nums[1],nums[2]});
                }
            }

            networks.sort(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[2]-o2[2];
                }
            });

            int result = 0;
            int i=0;
            while(true){
                if(i>=networks.size()){
                    break;
                } else {
                    if (uf.find(networks.get(i)[0]) != uf.find(networks.get(i)[1])) {
                        uf.union(networks.get(i)[0], networks.get(i)[1]);
                        result += networks.get(i)[2];
                        if (uf.get_count() == n - 1) {
                            break;
                        }
                    }
                }
                i+=1;
            }

            if(uf.get_count() != n - 1){
                result = -1;
            }
            System.out.println(result);
        }
}
