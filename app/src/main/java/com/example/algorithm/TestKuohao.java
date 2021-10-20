package com.example.algorithm;

import java.util.Stack;

/**
 * @author : wanghailong
 * @date :
 * @description:括号匹配算法 <p>
 * 1.遍历数组的每个元素
 * 2.查找每个元素在左右括号数组中的位置
 * 3.如果找到了左括号入栈 否则 如果找到了右括号判断栈不为空且栈顶元素等于左括号
 * (栈顶元素等于左括号的判断使用右括号的位置去左括号数组中取元素)此时栈顶出栈 否则 return false
 * 最后返回栈是否为空(为空匹配成功，不为空匹配失败)
 */
public class TestKuohao {

    static String[] lefts = {"{", "b", "r", "a", "c", "e", "*", "&", "^", "[", "s", "q", "u", "a", "r", "e", "(", "r", "o", "u", "n", "d", ")", "]", "e", "n", "d", "}"};
    static String[] rights = {"{", "b", "r", "a", "c", "e", "*", "&", "^", "[", "s", "q", "u", "a", "r", "e", "(", "r", "o", "u", "n", "d", "]", ")", "e", "n", "d", "}"};
    static String str = "{brace*&^[square(round)]end}";
    static String str2 = "{brace*&^[square(round])end}";

    static String[] leftkh = {"{", "[", "("};
    static String[] rightkh = {"}", "]", ")"};
    static String leftkhs = "{[(";
    static String rightkhs = "}])";

    public static void main(String[] args) {
        System.out.println("whl **" + "结果：" + check(lefts, lefts.length));
        System.out.println("whl **" + "结果：" + check(rights, rights.length));
    }

    private static boolean check(String[] s, int n) {
        if (n < 1) {
            return false;
        }
        int indexLeft = -1, indexRight = -1;
        Stack<String> stack = new Stack<String>();
        for (int i = 0; i < n; i++) {
            String ch = s[i];
            indexLeft = leftkhs.indexOf(ch);
            indexRight = rightkhs.indexOf(ch);

            if (indexLeft >= 0) {
                stack.push(ch);
            } else if (indexRight >= 0) {
                if (!stack.empty() && stack.peek().equals(leftkh[indexRight])) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.empty();
    }
}
