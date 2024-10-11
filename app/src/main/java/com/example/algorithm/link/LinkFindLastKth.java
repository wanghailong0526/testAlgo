package com.example.algorithm.link;

import com.example.algorithm.LinkUtils;
import com.example.algorithm.Node;

/**
 * @author : wanghailong
 * @date :
 * @description:查找链表倒数第K个结点
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

    /**
     * 使用快慢指针
     * 1.快指针先走K步 如果快指针为 null 返回list
     * 2.慢指针和快指针再一起走
     * 3.当快指针指向最后一个结点时，慢指针指向的就是倒数第K个结点
     *
     * @param list
     * @param k
     * @return
     */
    private static Node findLastKth(Node list, int k) {
        Node fast = list;
        int i = 1;
        //快指针先走 K 步
        while (fast != null && i < k) {
            fast = fast.next;
            ++i;
        }

        if (fast == null) return list;//倒数这个结点超过了链表长度

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


























