package com.example.algorithm.DP;

import java.util.Arrays;

/**
 * 不同路径
 * <p>
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * <p>
 * 问总共有多少条不同的路径？
 */
public class UniquePaths {
    public static void main(String[] args) {
        System.out.println("whl *** " + uniquePaths(7, 3));

        /**
         * 不同路径有障碍物
         */
        int[][] s = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        System.out.println(uniquePath3(s));
    }

    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    /**
     * 状态压缩
     *
     * @param m
     * @param n
     * @return
     */
    public static int uniquePaths2(int m, int n) {
        // 在二维dp数组中，当前值的计算只依赖正上方和正左方，因此可以压缩成一维数组。
        int[] dp = new int[n];
        // 初始化，第一行只能从正左方跳过来，所以只有一条路径。
        Arrays.fill(dp, 1);
        for (int i = 1; i < m; i++) {
            // 第一列也只有一条路，不用迭代，所以从第二列开始
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1]; // dp[j] = dp[j] (正上方)+ dp[j - 1] (正左方)
            }
        }
        return dp[n - 1];
    }
    /***********************************************/
    /**********************不同路径 二 *************************/
    /***********************************************/
    /**
     * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
     * <p>
     * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
     * <p>
     * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
     */

    public static int uniquePath3(int[][] s) {

        int m = s.length;
        int n = s[0].length;

        if (s[0][0] == 1 || s[m - 1][n - 1] == 1) return 0;

        int[][] dp = new int[m][n];
        for (int i = 0; i < m && s[i][0] == 0; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n && s[0][i] == 0; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = s[i][j] == 0 ? dp[i - 1][j] + dp[i][j - 1] : 0;
            }
        }
        return dp[m - 1][n - 1];
    }

    /***********************************************/
    /**********************整数拆分*************************/
    /***********************************************/
    /**
     * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
     */
    public static int integerBreak(int n) {
        //dp[i] 为正整数 i 拆分后的结果的最大乘积
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= i - j; j++) {
                // 这里的 j 其实最大值为 i-j,再大只不过是重复而已，
                //并且，在本题中，我们分析 dp[0], dp[1]都是无意义的，
                //j 最大到 i-j,就不会用到 dp[0]与dp[1]
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
                // j * (i - j) 是单纯的把整数 i 拆分为两个数 也就是 i,i-j ，再相乘
                //而j * dp[i - j]是将 i 拆分成两个以及两个以上的个数,再相乘。
            }
        }
        return dp[n];
    }

    /**
     * 本题也可以用贪心，每次拆成n个3，如果剩下是4，则保留4，然后相乘
     *
     * @param n
     * @return
     */
    public static int integerBreak2(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;
        if (n == 4) return 4;
        int result = 1;
        while (n > 4) {
            result *= 3;
            n -= 3;
        }
        result *= n;
        return result;
    }

    /***********************************************/
    /**********************01 背包问题*************************/
    /***********************************************/


}
