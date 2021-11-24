package com.example.algorithm.recursion;

/**
 * @author : wanghailong
 * @date :
 * @description:100个台阶，一次走1步，2步，3步，4步，问一共有多少种走法
 */
public class taijie {
    public static void main(String[] args) {
        int taijie = 4;
//        System.out.println("共有走法：" + step(taijie) + " 种！");

//下面是非递归的算法
//        int steps = 0;
//        int fir = 0;
//        int sec = 1;
//        for (int i = 1; i <= taijie; i++) {
//            steps = fir + sec;
//            fir = sec;
//            sec = steps;
//        }
//        System.out.println("共有 " + steps + " 种走法");

        //这是
        System.out.println("共有 " + waysToStep(taijie) + " 种走法");

    }

    private static int step(int n) {//n台阶数量
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (n == 3) {
            return 3;
        }
//        if (n == 4) {
//            return 4;
//        }
        return step(n - 1) + step(n - 2) + step(n - 3) /*+ step(n - 4)*/;

    }

    /**
     * @param n n阶台阶
     * @return 走法
     */
    public static int waysToStep(int n) {

        //动态规划：
        // n 阶可以往前退一步，可以时n-1阶所有情况之和 + n-2阶所有情况之和 + n-3阶所有情况之和
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 3;
        long dp1 = 1;
        long dp2 = 2;
        long dp3 = 3;
        long A = 1000000007;

        for (int i = 4; i <= n; i++) {

            long tmp = dp1;
            dp1 = dp2;
            dp2 = dp3;
            dp3 = (tmp + dp1 + dp2) % A;

        }
        return (int) dp3;
    }
}
