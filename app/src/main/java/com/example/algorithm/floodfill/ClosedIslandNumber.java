package com.example.algorithm.floodfill;

/**
 * @author : wanghailong
 * @date :
 * @description:求封闭岛屿数量 <p>
 * 思路
 * 1.在求岛屿数量的方法基础上，去掉靠边的岛屿就是封闭岛屿数量
 * 2.1_海水 0_陆地
 */
public class ClosedIslandNumber {
    public static void main(String[] args) {
        int grid[][] = {{1, 1, 1, 1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 1, 1, 0},
                {1, 0, 1, 0, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 1, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 0}};

        System.out.println("封闭岛屿数量：" + closedIsland(grid) + "块");
    }

    private static int closedIsland(int[][] grid) {
        int res = 0;
        int m = grid.length, n = grid[0].length;
        //1.将靠边的陆地设置为海水
        for (int j = 0; j < n; j++) {
            //将靠上边的陆地设置为海水
            dfs(grid, 0, j);
            //将靠下边的陆地设置为海水
            dfs(grid, m - 1, j);
        }

        for (int i = 0; i < m; i++) {
            //将靠左边的陆地设置为海水
            dfs(grid, i, 0);
            //将靠右边的陆地设置为海水
            dfs(grid, i, n - 1);
        }

        //2.剩下的岛屿就是封闭的岛屿
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    res++;
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }


    private static void dfs(int[][] grid, int i, int j) {
        int m = grid.length, n = grid[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n) {//索引超出边界
            return;
        }

        if (grid[i][j] == 1) {//已经是海水了
            return;
        }

        grid[i][j] = 1;//i,j位置设置为海水

        //i,j 上下左右设置为海水
        dfs(grid, i + 1, j);//上
        dfs(grid, i - 1, j);//下
        dfs(grid, i, j - 1);//左
        dfs(grid, i, j + 1);//右
    }
}
