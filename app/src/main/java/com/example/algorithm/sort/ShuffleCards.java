package com.example.algorithm.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * 公平洗牌算法
 */
public class ShuffleCards {

    public static void main(String[] args) {
        int[] src = {3, 2, 1, 9, 7, 6};
        shuffleCards(src, src.length);
        System.out.println(Arrays.toString(src));
    }

    public static void shuffleCards(int[] src, int srcLen) {
        Random random = new Random();
        while (!isSorted(src, srcLen)) {
            //打乱顺序
            for (int i = srcLen - 1; i >= 0; --i) {
                swap(src, i, random.nextInt(i + 1));
            }
        }

    }

    public static void swap(int[] src, int i, int j) {
        int tmp = src[i];
        src[i] = src[j];
        src[j] = tmp;
    }

    /**
     * @param src    数据源 数组
     * @param srcLen 数组长度
     * @return 是否升序
     */
    public static boolean isSorted(int[] src, int srcLen) {
        for (int i = 0; i < srcLen - 1; ++i) {
            if (src[i + 1] < src[i]) {//后面比前面小证明不是升序
                return false;
            }
        }
        return true;
    }
}
