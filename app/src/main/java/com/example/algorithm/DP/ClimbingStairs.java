package com.example.algorithm.DP;

/**
 * 动规的五部曲：
 * <p>
 * 确定dp数组（dp table）以及下标的含义
 * 确定递推公式
 * dp数组如何初始化
 * 确定遍历顺序
 * 举例推导dp数组
 * <p>
 * <p>
 * 使用最小花费爬楼梯
 * <p>
 * 示例 1：
 * 输入：cost = [10, 15, 20]
 * 输出：15
 * 解释：最低花费是从 cost[1] 开始，然后走两步即可到阶梯顶，一共花费 15 。
 * <p>
 * 示例 2：
 * 输入：cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
 * 输出：6
 * 解释：最低花费方式是从 cost[0] 开始，逐个经过那些 1 ，跳过 cost[3] ，一共花费 6 。
 * <p>
 * 提示：
 * cost 的长度范围是 [2, 1000]。
 * cost[i] 将会是一个整型数据，范围为 [0, 999] 。
 */
public class ClimbingStairs {
    public static void main(String[] args) {
        int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println("whl *** " + climbStairs(cost));

    }

    /**
     * 方式一：第一步不支付费用
     *
     * @param cost
     * @return
     */
    public static int climbStairs(int[] cost) {
        int len = cost.length;
        int[] dp = new int[len + 1];

        // 从下标为 0 或下标为 1 的台阶开始，因此支付费用为0
        dp[0] = 0;
        dp[1] = 0;

        // 计算到达每一层台阶的最小费用
        for (int i = 2; i <= len; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }

        return dp[len];
    }

    /**
     * 方式二：第一步支付费用
     */
    public static int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < cost.length; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }
        //最后一步，如果是由倒数第二步爬，则最后一步的体力花费可以不用算
        return Math.min(dp[cost.length - 1], dp[cost.length - 2]);
    }

    /**
     * 状态压缩，使用三个变量来代替数组
     *
     * @param cost
     * @return
     */
    public static int minCostClimbingStairs2(int[] cost) {
        // 以下三个变量分别表示前两个台阶的最少费用、前一个的、当前的。
        int beforeTwoCost = 0, beforeOneCost = 0, currentCost = 0;
        // 前两个台阶不需要费用就能上到，因此从下标2开始；因为最后一个台阶需要跨越，所以需要遍历到cost.length
        for (int i = 2; i <= cost.length; i++) {
            // 此处遍历的是cost[i - 1]，不会越界
            currentCost = Math.min(beforeOneCost + cost[i - 1], beforeTwoCost + cost[i - 2]);
            beforeTwoCost = beforeOneCost;
            beforeOneCost = currentCost;
        }
        return currentCost;
    }

}
