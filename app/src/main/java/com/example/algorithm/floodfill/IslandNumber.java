package com.example.algorithm.floodfill;

/**
 * @author : wanghailong
 * @date :
 * @description: <p>
 * 1.求岛屿数量，最简单也是最经典的一道岛屿问题，
 * 2.二维数组grid，其中只包含0或者1，0代表海水，1代表陆地，且假设该矩阵四周都是被海水包围着的。
 * 3.我们说连成片的陆地形成岛屿，那么请你写一个算法，计算这个矩阵grid中岛屿的个数
 * 思路 ：
 * 1.使用 DFS 算法 深度优先遍历
 * 2.只要发现陆地，就将它上，下，左，右变成海水
 */
public class IslandNumber {

    public static void main(String[] args) {
        int grid[][] = {{1, 1, 0, 1, 1},
                {1, 0, 0, 0, 0},
                {0, 0, 0, 0, 1},
                {1, 1, 0, 1, 1}};
        System.out.println("whl ** 共有陆地 " + numIslands(grid) + " 块!");
    }

    public static int numIslands(int[][] grid) {
        int res = 0;//结果
        int m = grid.length;//行
        int n = grid[0].length;//列
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {//是陆地,将它上下左右都设置为海水
                    res++;
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }

    private static void dfs(int[][] grid, int i, int j) {
        int m = grid.length, n = grid[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n) {//超出索引边界就返回
            return;
        }
        if (grid[i][j] == 0) {//如果已经是海水了就返回
            return;
        }
        grid[i][j] = 0;//将i,j 位置变成海水

        //让上下左右都变成海水
        dfs(grid, i - 1, j);//上
        dfs(grid, i + 1, j);//下
        dfs(grid, i, j - 1);//左
        dfs(grid, i, j + 1);//右
    }
}
