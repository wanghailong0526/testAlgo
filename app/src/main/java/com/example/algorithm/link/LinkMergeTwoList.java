package com.example.algorithm.link;

import com.example.algorithm.LinkUtils;
import com.example.algorithm.Node;

/**
 * 合并两个单链表
 * 技巧：使用哨兵
 * 1.通过两个链表当前结点的值比较来让哨兵指针指向两个链表中的其中一个的当前结点
 * 2.移动哨兵指针
 * 3.若其它一个链接拼接结束退出循环，检查两个链表哪个不为 null 就让哨兵指针的下一个结点指向不为 null 的链表
 */
public class LinkMergeTwoList {
    public static void main(String[] args) {
        Node la = new Node(null, 0);
        Node node2 = new Node(null, 3);
        Node node3 = new Node(null, 2);
        la.next = node2;
        node2.next = node3;

        Node lb = new Node(null, 1);
        Node node4 = new Node(null, 4);
        Node node5 = new Node(null, 6);
        Node node6 = new Node(null, 9);
        lb.next = node4;
        node4.next = node5;
        node5.next = node6;

        System.out.println("la:");
        LinkUtils.printAll(la);
        System.out.println("\n");

        System.out.println("lb:");
        LinkUtils.printAll(lb);
        System.out.println("\n");

        System.out.println("链表合并后：");
        LinkUtils.printAll(mergeTwoLists(la, lb));


    }

    public static Node mergeTwoLink(Node la, Node lb) {
        Node solider = new Node(null, 0);
        Node p = solider;
        while (la != null && lb != null) {//1.通过两个链表当前结点的值比较来让哨兵指针指向两个链表中的其中一个的当前结点
            if (la.data > lb.data) {
                p.next = lb;
                lb = lb.next;
            } else {
                p.next = la;
                la = la.next;
            }
            p = p.next;//2.移动哨兵指针
        }
        //3.处理剩下的链表 若其它一个链接拼接结束退出循环，检查两个链表哪个不为 null 就让哨兵指针的下一个结点指向不为 null 链表
        if (la != null) {
            p.next = la;
        }
        if (lb != null) {
            p.next = lb;
        }
        return solider.next;
    }

    public static Node mergeTwoLists(Node l1, Node l2) {
        Node soldier = new Node(null, 0); //利用哨兵结点简化实现难度 技巧三
        Node p = soldier;

        while (l1 != null && l2 != null) {
            if (l1.data < l2.data) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }

        if (l1 != null) {
            p.next = l1;
        }
        if (l2 != null) {
            p.next = l2;
        }
        return soldier.next;
    }
}
