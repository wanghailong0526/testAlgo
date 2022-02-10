package com.example.algorithm.link;

import com.example.algorithm.LinkUtils;
import com.example.algorithm.Node;

/**
 * 求链表中间结点
 * 使用快慢指针
 * 1.快指针一次走两步
 * 2.慢指针一次走一步
 * 3.当快指针走到终点，慢指针就是链表中间结点
 * 4.如果链表长度为偶数没有中间结点，提前让fast指针走一步获取到前一个值，若fast与slow在同一起始点获取到后一个值
 * 例：0 1 2 3  fast与slow在同一起始点获取到2  fast提前走一步获取到1
 */
public class LinkFindMiddleNode {
    public static void main(String[] args) {
        Node node = new Node(null, 0);
        Node header = node;
        LinkUtils.createLink(node);
        LinkUtils.printAll(header);
        System.out.println("中间结点：" + findMiddleNode(header).data);
    }

    public static Node findMiddleNode(Node list) {
        // Node  fast = list.next;//若链表长度为偶数，这两个操作获取到的值不同
        Node fast = list;
        Node slow = list;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}





























