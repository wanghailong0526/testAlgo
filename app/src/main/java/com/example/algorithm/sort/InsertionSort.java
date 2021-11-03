package com.example.algorithm.sort;

import java.util.Arrays;

/**
 * 插入排序
 */
public class InsertionSort {

    public static void main(String[] args) {
        int a[] = {3, 2, 1, 4, 7, 9};
        System.out.println("排序前：" + Arrays.toString(a));
        insertionSort(a, a.length);
        System.out.println("排序后：" + Arrays.toString(a));
    }

    private static void insertionSort(int a[], int n) {
        if (n <= 1) {
            return;
        }
        for (int i = 1; i < n; i++) {
            int value = a[i];
            int j = i - 1;//交换次数和比较次数
            for (; j >= 0; j--) {
                //移动数据
                if (a[j] > value) {//前面的数比后面的数大就移动数据
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            a[j + 1] = value;//插入数据
        }
    }
}























