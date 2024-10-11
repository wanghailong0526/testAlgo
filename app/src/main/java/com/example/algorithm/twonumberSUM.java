package com.example.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和等于 target
 * 使用哈希法，将遍历过的数据
 */
public class twonumberSUM {

    public static void main(String[] args) {
        int[] src = {2, 7, 7, 9, 3, 6};
        twoNumSum(src, src.length, 9);
    }

    public static void twoNumSum(int[] src, int srcLen, int target) {
        if (srcLen < 2) {
            return;
        }
        //使用 map 记录遍历过的数据
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < srcLen; i++) {
            int temp = target - src[i];
            if (map.containsKey(temp)) {
                System.out.println("whl ***" + "[ " + i + " ] = " + src[i] + "  [ " + map.get(temp) + " ] = " + temp);
            } else {
                map.put(src[i], i);
            }
        }
    }
}
