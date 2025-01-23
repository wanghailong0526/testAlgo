package com.example.algorithm.recursion;

/**
 * 计算 1！+2！+3！……+n!
 */
public class Fact {
    public static void main(String[] args) {


        System.out.println("whl *** " + sum(5));
        System.out.println("whl *** " + sum2(5));
    }

    public static long sum(int n) {
        if (n == 0) return 1;
        long res = 1;
        long sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += fact(i, res);
        }
        return sum;
    }

    public static long fact(int n, long res) {
        if (n == 1) return res;
        return fact(n - 1, res * n);
    }

    /**
     * 方法二
     *
     * @param n
     * @return
     */
    public static long sum2(int n) {
        if (n == 0) return 1;
        long sum = 0;
        long fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
            sum += fact;
        }
        return sum;
    }

}
