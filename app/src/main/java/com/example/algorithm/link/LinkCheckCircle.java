package com.example.algorithm.link;

import com.example.algorithm.LinkUtils;
import com.example.algorithm.Node;

/**
 * 链表环检测
 * 快慢指针
 * 1.快指针一次走两步
 * 2.慢指针一次走一步
 * 3.若两个指针指向同个对象就是有环，否则没有环
 */
public class LinkCheckCircle {
    public static void main(String[] args) {
        Node node = new Node(null, 0);
        Node header = node;
        Node link = LinkUtils.createLink(node);
        System.out.println("链表：");
        LinkUtils.printAll(header);
        System.out.println();
        link.next = header;
        System.out.println("是否有环路：" + (checkCircle(header) ? "有" : "无"));

    }

    /**
     * 链表环路检测
     *
     * @param list
     * @return
     */
    public static boolean checkCircle(Node list) {
        Node fast = list.next;
        Node slow = list;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
































