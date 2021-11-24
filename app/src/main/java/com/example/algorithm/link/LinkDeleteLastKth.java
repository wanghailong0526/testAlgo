package com.example.algorithm.link;

import com.example.algorithm.LinkUtils;
import com.example.algorithm.Node;

/**
 * @author : wanghailong
 * @date :
 * @description:删除链表倒数第K个结点
 */
public class LinkDeleteLastKth {
    public static void main(String[] args) {
        Node node = new Node(null, 0);
        Node header = node;
        LinkUtils.createLink(node);
        LinkUtils.printAll(header);
        header = deleteLastKth(header, 2);
        LinkUtils.printAll(header);
    }

    /**
     * 删除倒数第K个结点 使用快慢指针
     * 1.让快指针先走 k 步
     * 2.慢指针指向链表头结点和快指针再一起走
     * 3.快指针走到最后一个结点，慢指针指向的就是倒数第 K 个结点
     */
    public static Node deleteLastKth(Node list, int k) {
        Node fast = list;
        int i = 1;
        while (fast != null && i < k) {
            fast = fast.next;
            ++i;
        }

        if (fast == null) return list;//倒数这个结点超过了链表长度

        Node slow = list;
        Node prev = null;//倒数第k个结点的前驱结点
        while (fast.next != null) {
            fast = fast.next;
            prev = slow;
            slow = slow.next;
        }
        System.out.println("倒数第 " + k + " 个数为:" + slow.data);
        if (prev == null) {//如果删除的是第一个结点
            list = list.next;
        } else {//如果删除的不是第一个结点
            System.out.println("delete num:" + prev.next.data);
            prev.next = prev.next.next;
        }
        return list;
    }


}


