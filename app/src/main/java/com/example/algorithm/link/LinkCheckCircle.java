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
        System.out.println("是否有环路：" + (checkCircle(header) ? "有" : "无") + ",入环的第一结点为 " + detectCycle(header).data);

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

    /**
     * 检测入环的第一个结点
     * 快慢指针相遇后，慢指针回到起点，
     * 这时候快慢指针一样的速度走，
     * 相遇时，就是入环点
     *
     * @param head
     * @return
     */
    public static Node detectCycle(Node head) {
        if (head == null) {
            return null;
        }
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            //快慢指针相等表示有环
            if (slow == fast) {
                //回到起点一起相同速度走
                while (head != fast) {
                    head = head.next;
                    fast = fast.next;
                }
                return head;
            }

        }
        return null;
    }
}
































