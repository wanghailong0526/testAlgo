package com.example.algorithm.link;

import com.example.algorithm.LinkUtils;
import com.example.algorithm.Node;

/**
 * @author : wanghailong
 * @date :
 * @description:找到链表倒数第K个结点
 */
public class LinkFindLastKth {
    public static void main(String[] args) {
        Node node = new Node(null, 0);
        Node header = node;
        LinkUtils.createLink(node);
        LinkUtils.printAll(header);
        header = findLastKth(header, 3);
//        LinkUtils.printAll(header);
    }

    private static Node findLastKth(Node list, int k) {
        Node fast = list;
        int i = 1;
        //快指针先走 K 步
        while (fast != null && i < k) {
            fast = fast.next;
            ++i;
        }

        if (fast == null) return list;

        Node slow = list;
        //快慢指针再一起走
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        System.out.println("倒数第 " + k + " 个元素值：" + slow.data);

        return slow;//结果
    }
}
