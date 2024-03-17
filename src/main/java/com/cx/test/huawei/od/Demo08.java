package com.cx.test.huawei.od;

import java.util.Scanner;

/**
 * 中庸行者
 */
public class Demo08 {
    public static int[][] matrix;
    public static int[][] visited;
    public static int m;
    public static int n;
    public static int result = 0;
    public static int[] directions = {-1, 0, 1, 0, -1};
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        m = in.nextInt();
        n = in.nextInt();
        matrix = new int[m][n];
        visited = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = in.nextInt();
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(i,j, 0, true);
                dfs(i,j, 0, false);
            }
        }
        System.out.println(result);
    }

    public static void dfs(int x, int y, int step_count, boolean flag) {
        if(step_count>result){
            result = step_count;
        }
        visited[x][y] = 1;
        int i=1;
        while(true){
            if(i>=5){
                break;
            } else {
                int xx = x + directions[i- 1];
                int yy = y + directions[i];
                if (xx < 0 || yy < 0 || xx >= m || yy >= n || visited[xx][yy] == 1
                        || matrix[xx][yy] == matrix[x][y] || ((flag && matrix[xx][yy] > matrix[x][y]) || (!flag && matrix[xx][yy] < matrix[x][y]))) {
                    i+=1;
                    continue;
                }
                dfs(xx, yy, step_count + 1, !flag);
            }
            i+=1;
        }
        visited[x][y] = 0;
    }
}
