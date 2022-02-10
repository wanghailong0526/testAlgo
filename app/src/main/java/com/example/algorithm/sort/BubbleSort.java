package com.example.algorithm.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class BubbleSort {
    public static void main(String[] args) {
        int a[] = {3, 2, 1, 4, 7, 9, 5};
        System.out.println("排序前：" + Arrays.toString(a));
        bubbleSort(a, a.length);
        System.out.println("排序后：" + Arrays.toString(a));

        int a1[] = {2, 2, 3, 4, 0, 0, 4};
        System.out.println("数组中的元素：" + Arrays.toString(a1));
        findOnlyOneNumber(a1, a1.length);
    }


    /**
     * 冒泡排序
     *
     * @param a 待排序数组
     * @param n 待排序数组个数
     */
    public static void bubbleSort(int[] a, int n) {
        if (n <= 1) {
            return;
        }
        for (int i = 0; i < n; i++) {
            boolean flag = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
    }

    private static void swap(int a, int b) {

    }

    /**
     * 找到数组中只出现一次的数
     * 给定一个非空整数数组,除了某个元素只出现一次以外,
     * 其余每个元素均出现两次.找出那个只出现了一次的元素
     *
     * @param a
     * @param n
     */
    public static void findOnlyOneNumber(int a[], int n) {
        if (n <= 1) {
            return;
        }
        for (int i = 1; i < n; i++) {
            a[0] = a[0] ^ a[i];
        }
        System.out.println("使用异或运算，数组中只出现一次的元素：" + a[0]);
    }
}
