package com.example.algorithm;

/**
 * @author : wanghailong
 * @date :
 * @description:判断一个数正整数是否是完全平方数
 */
public class PrefectSquare {

    public static void main(String[] args) {
        int n = 49 * 49;
        System.out.println(n + ":" + (isPrefectSquare(n) ? "是完全平方数" : "不是完全平方数"));
    }

    /**
     * 二分法 给定正整数 n
     * 1.若 n<2 return true
     * 2.left = 2 , right = n/2 , x , guess
     * 3. while left <= right
     * 4.x = left + (right - left)/2
     * 5.guess = x * x
     * 6.若 guess == n return true;
     * 7.若 guess > n right = x -1;
     * 8.若 guess <= n left = x+1;
     *
     * @param n
     * @return
     */
    private static boolean isPrefectSquare(int n) {
        if (n < 2) {
            return true;
        }
        long left = 2, right = n / 2, x, guess;
        while (left <= right) {
            x = left + (right - left) / 2;
            guess = x * x;

            if (guess == n) {
                System.out.println(x + " x " + x + " = " + n);
                return true;
            }
            if (guess > n) {
                right = x - 1;
            } else {
                left = x + 1;
            }
        }

        return false;
    }
}
