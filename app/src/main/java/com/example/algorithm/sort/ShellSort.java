package com.example.algorithm.sort;

import java.util.Arrays;

/**
 * @author : wanghailong
 * @date :
 * @description: 希尔排序
 * 希尔排序目的为了加快速度改进了插入排序，
 * 交换不相邻的元素对数组的局部进行排序，并最终用插入排序将局部有序的数组排序。
 * 在此我们选择增量 gap=length/2，缩小增量以 gap = gap/2 的方式，用序列 {n/2,(n/2)/2...1} 来表示
 */
public class ShellSort {
    
    public static void main(String[] args) {
        int a[] = {7, 6, 9, 3, 1, 5, 2, 4};
        System.out.println("排序前：" + Arrays.toString(a));
        shellSort(a, a.length);
        System.out.println("排序后：" + Arrays.toString(a));
    }

    private static void shellSort(int[] src, int srcLen) {
        if (srcLen == 1) return;
        int step = srcLen / 2;
        while (step >= 1) {
            for (int i = step; i < srcLen; i++) {
                int value = src[i];
                int j = i - step;
                for (; j >= 0; j -= step) {
                    if (value < src[j]) {
                        src[j + step] = src[j];
                    } else {
                        break;
                    }
                }
                src[j + step] = value;
            }
            step = step / 2;
        }
    }
}
