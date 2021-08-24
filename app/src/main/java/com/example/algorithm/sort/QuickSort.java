package com.example.algorithm.sort;

import java.util.Arrays;

/**
 * 快速排序 分治思想 将原始数据分为两部分
 * 时间复杂度O(nlogn)
 * 原生排序算法
 * 非稳定排序算法，数值相等的数据在排序后位置可能会交换或改变
 */
public class QuickSort {


    public static void main(String[] args) {
        int a[] = {3, 2, 1, 4, 7, 9};
//        int a[] = {1, 2, 3, 4, 5, 6};
        System.out.println("排序前：" + Arrays.toString(a));
        quickSort(a, a.length);
        System.out.println("排序后：" + Arrays.toString(a));
    }

    // 快速排序，a是数组，n表示数组的大小
    public static void quickSort(int[] a, int n) {
        quickSortInternally(a, 0, n - 1);
    }

    // 快速排序递归函数，p起始下标,r为结束下标
    private static void quickSortInternally(int[] a, int p, int r) {
        if (p >= r) return;

        int q = partition(a, p, r); // 获取分区点
        System.out.println("p=" + p + " r=" + (q - 1));
        System.out.println("执行了前半部分！！！");
        quickSortInternally(a, p, q - 1);

        System.out.println("q=" + (q + 1) + " r=" + r);
        quickSortInternally(a, q + 1, r);
        System.out.println("执行了后半部分！！！");
    }

    /**
     * 查找分区点
     *
     * @param a
     * @param p
     * @param r
     * @return
     */
    private static int partition(int[] a, int p, int r) {
        int pivot = a[r];
        int i = p;
        for (int j = p; j < r; ++j) {
            if (a[j] < pivot) {
                if (i == j) {
                    ++i;
                } else {
                    int tmp = a[i];
                    a[i++] = a[j];
                    a[j] = tmp;
                }
            }
        }

        int tmp = a[i];
        a[i] = a[r];
        a[r] = tmp;

        System.out.println("i=" + i);
        return i;
    }

}
