package com.example.algorithm.DP;

/**
 * @author : wanghailong
 * @date :
 * @description: 动态规划
 */
public class DP {
    private static int[] weight = {2, 2, 4, 6, 3}; // 物品重量
    private static int[] value = {3, 4, 8, 9, 6}; // 物品的价值
    private static int n = 5; // 物品个数
    private static int w = 9; // 背包承受的最大重量

    public static void main(String[] args) {
//        knapsack(weight, n, w);
//        knapsack2(weight, n, w);
        knapsack3(weight, value, n, w);
    }

    //weight:物品重量，n:物品个数，w:背包可承载重量   行_物品个数   列_背包承受总重量
    public static int knapsack(int[] weight, int n, int w) {
        boolean[][] states = new boolean[n][w + 1]; // 默认值false
        states[0][0] = true;  // 第一行的数据要特殊处理，可以利用哨兵优化
        if (weight[0] <= w) {
            states[0][weight[0]] = true;
        }
        for (int i = 1; i < n; ++i) { // 动态规划状态转移
            for (int j = 0; j <= w; ++j) {// 不把第i个物品放入背包 就要根据上一层的状态来确定这层的状态，就是复制上层的状态
                if (states[i - 1][j] == true) states[i][j] = states[i - 1][j];
            }

            for (int j = 0; j <= w - weight[i]; ++j) {//把第i个物品放入背包
                if (states[i - 1][j] == true) states[i][j + weight[i]] = true;
            }
        }
        for (int i = w; i >= 0; --i) { // 输出最后一层的结果就是解
            if (states[n - 1][i] == true) {
                System.out.print("whl ** i: " + i);
//                return i;
            }
        }
        System.out.println();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < w; j++) {
                System.out.print(states[i][j] ? "1 " : "0 ");
            }
            System.out.println();
        }
        return 0;
    }

    public static int knapsack2(int[] items, int n, int w) {
        boolean[] states = new boolean[w + 1]; // 默认值false
        states[0] = true;  // 第一行的数据要特殊处理，可以利用哨兵优化
        if (items[0] <= w) {
            states[items[0]] = true;
        }
        for (int i = 1; i < n; ++i) { // 动态规划
            for (int j = w - items[i]; j >= 0; --j) {//把第i个物品放入背包
                if (states[j] == true) states[j + items[i]] = true;
            }
        }
        for (int i = w; i >= 0; --i) { // 输出结果
            System.out.println("whl ** i: " + i);
//            if (states[i] == true) return i;
        }
        return 0;
    }


    //在满足背包最大重量限制的前提下，背包中可装入物品的总价值最大值
    public static int knapsack3(int[] weight, int[] value, int n, int w) {
        int[][] states = new int[n][w + 1];
        for (int i = 0; i < n; ++i) { // 初始化states
            for (int j = 0; j < w + 1; ++j) {
                states[i][j] = -1;
            }
        }
        states[0][0] = 0;
        if (weight[0] <= w) {
            states[0][weight[0]] = value[0];
        }
        for (int i = 1; i < n; ++i) { //动态规划，状态转移
            for (int j = 0; j <= w; ++j) { // 不选择第i个物品
                if (states[i - 1][j] >= 0) states[i][j] = states[i - 1][j];
            }
            for (int j = 0; j <= w - weight[i]; ++j) { // 选择第i个物品
                if (states[i - 1][j] >= 0) {
                    int v = states[i - 1][j] + value[i];
                    if (v > states[i][j + weight[i]]) {
                        states[i][j + weight[i]] = v;
                    }
                }
            }
        }
        // 找出最大值
        int maxvalue = -1;
        for (int j = 0; j <= w; ++j) {
            if (states[n - 1][j] > maxvalue) maxvalue = states[n - 1][j];
        }
        System.out.println("whl ** " + "maxvalue：" + maxvalue);
        return maxvalue;
    }

}
