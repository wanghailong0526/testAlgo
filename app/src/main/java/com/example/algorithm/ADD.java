package com.example.algorithm;

/**
 * @author : wanghailong
 * @date :
 * @description: 求加法
 * 「求加法」问题大多考察「列竖式」求和
 * <p>
 * 「两数之和」通常与其他形式表示的数字结合起来：
 * 1.两个字符串形式的数字相加（第 415 题）
 * 2.两个链表形式的数字相加（第 2 、445、369 题）
 * 3.数组形式的数字相加（第 66 、989题）
 * 4.两个二进制形式的数字相加（第 67 题）
 * <p>
 * 使用「竖式」计算十进制的加法的方式：
 * 1.两个「加数」的右端对齐；
 * 2.从最右侧开始，从右向左依次计算对应的两位数字的和，如果有进位需要加上进位。如果和大于等于 10，则把和的个位数字计入结果，并向前面进位；
 * 3.重复步骤 2；
 * 4.当两个「加数」的每个位置都计算完成，如果最后仍有进位，需要把进位数字保留到计算结果中。
 * <p>
 * 在实现中需要注意的有：
 * 1.不可以把链表/字符串表示的「加数」先转化成 int 型数字再求和，因为可能溢出；
 * 2.两个「加数」的字符串长度可能不同；
 * 3.在最后，如果进位 carry 不为 0，那么最后需要计算进位。
 * 4.注意 结果数字 是否为低位结果在前，根据题目要求判断最后是否要反转结果。
 */
public class ADD {

    public static void main(String[] args) {
//        String s = "234";
//        int p = s.length() - 1;//s的长度
//        int d = s.charAt(p) - '0';
//        System.out.println(d);
        String n1 = "910910910910910910910910910910910910910910910910910910910910910910910910910910910910910910910910910910910910910910910910910910910910910910910910910910910910910910910910910910910";
        String n2 = "123123123123123123123123123123123123123123123123123123123123123123123123123123123123123123123123123123123123123123123123123123123123";
        System.out.println(n1 + " + " + n2 + " = " + addString(n1, n2));
        System.out.println(n1 + " + " + n2 + " = " + addStrings(n1, n2));

        /****************链表形式的数字相加****************/
        Node l1 = new Node(2);
        l1.next = new Node(4);
        l1.next.next = new Node(3);

        Node l2 = new Node(5);
        l2.next = new Node(6);
        l2.next.next = new Node(4);
        System.out.print("l1" + " + " + "l2" + " = ");
        Node res = addString(l1, l2);
        while (res != null) {
            System.out.print(res.data);
            res = res.next;
        }
        System.out.println();


    }

    /*******************************字符串形式的数字相加*******************************/

    /**
     * 给定两个字符串形式的非负整数 num1 和 num2 ，计算它们的和并同样以字符串形式返回。
     * 你不能使用任何内建的用于处理大整数的库（比如 BigInteger）， 也不能直接将输入的字符串转换为整数形式。
     * 示例 1：
     * 输入：num1 = "11", num2 = "123"
     * 输出："134"
     * <p>
     * 复杂度分析
     * 时间复杂度：O(max(M,N))，M 和 N 分别是字符串 num1 和 num2 的长度；
     * 空间复杂度：O(1)，只使用了常数的空间。
     */
    public static String addString(String n1, String n2) {
        StringBuilder res = new StringBuilder();//返回结果
        int p1 = n1.length() - 1;//遍历到 n1 的位置
        int p2 = n2.length() - 1;//遍历到 n2 的位置
        int carry = 0;//存储进位
        while (p1 >= 0 || p2 >= 0 || carry != 0) {//n1未遍历完 或 n2未遍历完 或 有进位
            int d1 = p1 >= 0 ? n1.charAt(p1) - '0' : 0;//当前位置n1的取值
            int d2 = p2 >= 0 ? n2.charAt(p2) - '0' : 0;//当前位置n2的取值
            int add = d1 + d2 + carry;//当前位置相加结果
            carry = add >= 10 ? 1 : 0;//是否有进位
            add = add >= 10 ? add - 10 : add;//去除进位后留下的数字
            res.append(add);//拼接结果
            --p1;//向左移动n1位置
            --p2;//向左移动n2位置
        }
        return res.reverse().toString();
    }

    public static String addStrings(String num1, String num2) {
        int len1 = num1.length() - 1, len2 = num2.length() - 1;
        char ch1[] = num1.toCharArray();
        char ch2[] = num2.toCharArray();

        StringBuilder sb = new StringBuilder();
        int remainder = 0;//计算余数
        while (len1 >= 0 || len2 >= 0) {
            int n1 = len1 >= 0 ? (ch1[len1--] - '0') : 0;
            int n2 = len2 >= 0 ? (ch2[len2--] - '0') : 0;
            int num = n1 + n2 + remainder;//求和对应数字
            remainder = num / 10;//是否进位
            sb.append(num % 10);// 添加到结果字符串中
        }

        if (remainder > 0)//是否还需要进位
        {
            sb.append(remainder);
        }
        //反装即为结果
        return sb.reverse().toString();
    }

    /*******************************链表形式的数字相加*******************************/

    /**
     * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
     * <p>
     * 请你将两个数相加，并以相同形式返回一个表示和的链表。
     * <p>
     * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     * <p>
     * 示例 1：
     * <p>
     * 输入：l1 = [2,4,3], l2 = [5,6,4]
     * <p>
     * 输出：[7,0,8]
     * <p>
     * 解释：342 + 465 = 807
     */
    public static Node addString(Node l1, Node l2) {
        Node res = new Node(0);
        Node curr = res;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int d1 = l1 != null ? l1.data : 0;
            int d2 = l2 != null ? l2.data : 0;
            int add = d1 + d2 + carry;
            carry = add >= 10 ? 1 : 0;
            add = add >= 10 ? add - 10 : add;
            curr.next = new Node(add);
            curr = curr.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        return res.next;
    }


}
