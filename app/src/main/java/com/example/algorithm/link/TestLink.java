package com.example.algorithm.link;

import com.example.algorithm.Node;

/**
 * @author : wanghailong
 * @date :
 * @description: TODO
 */
public class TestLink {
    public static void main(String[] args) {

    }

    //链表反转
    public static Node linkReverse(Node list) {
        Node curr = list, p = null;
        while (curr != null) {
            Node next = curr.next;
            curr.next = p;
            p = curr;
            curr = next;
        }
        return p;
    }

    //删除倒数第K个结点
    public static Node deleteLastK(Node list, int k) {
        Node fast = list;
        int i = 1;
        while (fast != null && i < k) {
            fast = fast.next;
            ++i;
        }
        if (fast == null) {//超过了链表长度
            return list;
        }
        Node slow = list;
        Node prev = null;//待删除结点的前驱结点
        while (fast.next != null) {
            fast = fast.next;
            prev = slow;
            slow = slow.next;
        }
        if (prev == null) {//证明删除的是第一个结点
            list = list.next;
        } else {
            prev.next = prev.next.next;//删除结点
        }
        return list;
    }

    /**
     * 环路检测
     */
    public static boolean checkCircle(Node head) {
        Node fast = head, slow = head;
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
     */
    public static Node findFirstIntoCircle(Node head) {
        Node fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                slow = head;
                while (slow != fast) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }
}
