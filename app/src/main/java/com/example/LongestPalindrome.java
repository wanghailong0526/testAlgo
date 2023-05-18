package com.example;

import android.animation.ValueAnimator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : wanghailong
 * @date :
 * @description: 查找最长回文子串
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        String s = "tattarrattat";
        String s1 = "";
        System.out.println("whl ** " + s + " 的最长回文子串为：" + (s1 = longestPalindrome2(s)) + " 长度为：" + s1.length());
    }

    public static int longestPalindrome(String s) {
        int n = s.length();
        boolean[][] pal = new boolean[n][n];
        //pal[i][j] 表示s[i...j]是否是回文串
        int maxLen = 0;
        for (int i = 0; i < n; i++) {  // i作为终点
            int j = i;    //j作为起点
            while (j >= 0) {
                if (s.charAt(j) == s.charAt(i) && (i - j < 2 || pal[j + 1][i - 1])) {
                    pal[j][i] = true;
                    maxLen = Math.max(maxLen, i - j + 1);
                }
                j--;
            }
        }
        System.out.println("");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (pal[j][i]) {
                    System.out.print(1);
                } else {
                    System.out.print(0);
                }
            }
            System.out.println("");
        }
        System.out.println("");
        return maxLen;
    }

    public static String longestPalindrome2(String s) {
        List<Character> s_new = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            s_new.add('#');
            s_new.add(s.charAt(i));
        }
        s_new.add('#');
        List<Integer> Len = new ArrayList<>();
        String sub = "";//最长回文子串
        int sub_midd = 0;//表示在i之前所得到的Len数组中的最大值所在位置
        int sub_side = 0;//表示以sub_midd为中心的最长回文子串的最右端在S_new中的位置
        Len.add(1);
        for (int i = 1; i < s_new.size(); i++) {
            if (i < sub_side) {//i < sub_side时，在Len[j]和sub_side - i中取最小值，省去了j的判断
                int j = 2 * sub_midd - i;
                if (j >= 2 * sub_midd - sub_side && Len.get(j) <= sub_side - i) {
                    Len.add(Len.get(j));
                } else
                    Len.add(sub_side - i + 1);
            } else//i >= sub_side时，从头开始匹配
                Len.add(1);
            while ((i - Len.get(i) >= 0 && i + Len.get(i) < s_new.size()) && (s_new.get(i - Len.get(i)) == s_new.get(i + Len.get(i))))
                Len.set(i, Len.get(i) + 1);//s_new[i]两端开始扩展匹配，直到匹配失败时停止
            if (Len.get(i) >= Len.get(sub_midd)) {//匹配的新回文子串长度大于原有的长度
                sub_side = Len.get(i) + i - 1;
                sub_midd = i;
            }
        }
        sub = s.substring((2 * sub_midd - sub_side) / 2, sub_side / 2);//在s中找到最长回文子串的位置
        return sub;

    }
}
