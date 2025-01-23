package com.example.algorithm.DP;

/**
 * 斐波那契数列
 */
public class Fib {
    public static void main(String[] args) {
//        System.out.println("whl *** " + fib3(1, 1, 1));
        System.out.println("whl *** " + fib4(4, 2));

    }

    public static int fib(int n) {
        if (n <= 1) return n;
        int a = 0;
        int b = 1;
        for (int i = 2; i <= n; i++) {
            int sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    /**
     * 执行效率差
     * 时间复杂度 O(n)
     *
     * @param n
     * @return
     */
    public static int fib2(int n) {
        if (n < 2) return n;
        return fib2(n - 1) + fib2(n - 2);
    }

    /**
     * 效率高，
     * 时间复杂度 O(logn)
     * 调用 fib3(1 , 1 , 5);
     *
     * @param f
     * @param s
     * @param n
     * @return
     */
    public static int fib3(int f, int s, int n) {
        if (n <= 0) return 0;
        if (n < 3) {
            return 1;
        } else if (n == 3) {
            return f + s;
        } else {
            return fib3(s, f + s, n - 1);
        }
    }

    /**
     * @param n 一共多少台阶
     * @param m 一次可以走多少台阶
     * @return
     */
    public static int fib4(int n, int m) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) { // 把m换成2，就可以AC爬楼梯这道题
                if (i - j >= 0) dp[i] += dp[i - j];
            }
        }
        return dp[n];
    }
}
