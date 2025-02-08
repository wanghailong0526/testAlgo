package com.example.algorithm.twopointer;

/**
 * 滑动窗口实现
 * 乘积小于 K 的 连续子数组的个数
 */
public class SubArray {
    public static void main(String[] args) {
        int[] nums = {10, 5, 2, 6};
        int k = 100;
        subArray(nums, nums.length, k);
    }

    /**
     * left 左指针
     * right 右指针
     * value 当前乘积和
     *
     * @param src    [] 数据源
     * @param srcLen 数据源长度
     * @param k      乘积和
     * @return 连续子数组个数
     */
    public static int subArray(int[] src, int srcLen, int k) {
        if (k <= 1) return 0;//如果k<=1,任何乘积都不会小于k
        int left = 0, right = 0, count = 0, product = 1;

        //使用滑动窗口
        while (right < src.length) {
            product *= src[right];//扩展窗口，乘积乘上右指针指向的元素

            //如果乘积大于等于k，缩小窗口
            while (product >= k) {
                product /= src[left];
                left++;
            }

            //所有子数组的乘积都小于k，个数是(right-left+1)
            count += right - left + 1;
            right++;
        }

        return count;

    }

}
