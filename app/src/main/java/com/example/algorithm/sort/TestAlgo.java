package com.example.algorithm.sort;

import java.util.Arrays;

/**
 * @author : wanghailong
 * @date :
 * @description: TODO
 */
public class TestAlgo {
    public static void main(String[] args) {
        int a[] = {3, 2, 1, 4, 7, 9, 5};
        System.out.println("排序前：" + Arrays.toString(a));
//        bubbleSort(a, a.length);
        insertSort(a, a.length);
//        quickSort(a, a.length);
        System.out.println("排序后：" + Arrays.toString(a));
    }

    //冒泡排序

    /**
     * 快排
     *
     * @param a
     * @param n
     */
    public static void quickSort(int a[], int n) {
        if (n <= 1) {
            return;
        }
        quickSortInternaly(a, 0, n - 1);

    }

    private static void quickSortInternaly(int[] a, int p, int r) {
        if (p >= r) return;
        int q = partition(a, p, r);
        quickSortInternaly(a, p, q - 1);
        quickSortInternaly(a, q, r);
    }

    private static int partition(int[] a, int p, int r) {
        int pivot = a[r];
        int i = p;
        for (int j = p; j < r; ++j) {
            if (a[j] < pivot) {
                if (i == j) {
                    ++i;
                } else {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
        int temp = a[i];
        a[i] = a[r];
        a[r] = temp;
        return i;
    }

    /**
     * 插入排序
     */
    public static void insertSort(int a[], int n) {
        if (n <= 1) return;
        for (int i = 1; i < n; ++i) {
            int pivot = a[i];
            int j = i - 1;
            for (; j >= 0; --j) {
                if (a[j] > pivot) {
                    a[j + 1] = a[j];//将前面较大的数向后移动位置
                } else {
                    break;
                }
            }
            a[j + 1] = pivot;
        }
    }

}
