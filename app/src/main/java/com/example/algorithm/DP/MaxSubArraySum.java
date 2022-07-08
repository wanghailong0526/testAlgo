package com.example.algorithm.DP;

/**
 * @author : wanghailong
 * @date :
 * @description: 求 最大和 子数组
 * 解决方法 dp(i) = Max( dp(i-1) + a[i] , a[i] )
 * a是数组
 * dp(i)的定义，是以元素A[i]为结尾的最大子数组的和，
 * 因此dp(i)的值要么就是A[i]连接上之前的一个子数组，
 * 要么不链接任何数组，
 * 那么最终的结果一定是以某个元素为结尾的子数组，
 * 因此我们从所有的dp(i)中取一个最大的就好了，
 * 依赖子问题解决当前问题的解就是所谓的动态规划。
 */
public class MaxSubArraySum {

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("最大子数组的和为：" + maxSubArray(nums, nums.length));
    }

    public static int maxSubArray(int[] nums, int n) {
        int[] dp = new int[n];
        int res = dp[0] = nums[0];
        for (int i = 1; i < n; ++i) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            res = Math.max(res, dp[i]);
        }
        return res;
    }


    public static void maxArraySub(int[] nums, int n) {
        int sum = sum(nums, n);
        int states[][] = new int[n][sum];
//        states[0][0] = true;
    }

    public static int sum(int[] nums, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (i > 0) {
                sum = sum + i;
            }
        }
        return sum;
    }
}
