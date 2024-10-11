package com.example.algorithm.link;

import com.example.algorithm.LinkUtils;
import com.example.algorithm.Node;

import java.util.ArrayList;

/**
 * 重排链表
 * 给定一个有序链表 重新排序为 L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * 输入：head = [1,2,3,4]
 * 输出：[1,4,2,3]
 * 思路 先排第1个，再排倒数第1个，接着排第2个，紧接着倒数第2个
 */
public class ReorderList {

    public static void main(String[] args) {
        Node node = new Node(null, 1);
        Node head = node;
        LinkUtils.createLink(node, 2, 6);
        LinkUtils.printAll(head);
        System.out.println("重排链表后");
        reOrderList(head);
        LinkUtils.printAll(head);
    }

    /**
     * 重排链表
     *
     * @param head
     */
    public static void reOrderList(Node head) {
        if (head == null) {
            return;
        }
        ArrayList<Node> list = new ArrayList<>();
        Node node = head;
        while (node != null) {
            list.add(node);
            node = node.next;
        }
        int i = 0, j = list.size() - 1;
        while (i < j) {
            list.get(i).next = list.get(j);
            ++i;
            if (i == j) {
                break;
            }
            list.get(j).next = list.get(i);
            --j;
        }
        list.get(i).next = null;//最后一个结点的 next 指向空
    }
}
