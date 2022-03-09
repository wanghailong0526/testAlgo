package com.example.algorithm.link;

import com.example.algorithm.Node;

import static com.example.algorithm.LinkUtils.createLink;
import static com.example.algorithm.LinkUtils.printAll;

/**
 * 链表反转
 */
public class LinkReverse {

    public static void main(String[] args) {
        Node node = new Node(null, 0);
        Node header = node;
        createLink(node);
        System.out.println("反转前：");
        printAll(header);
        System.out.println("反转后：");
        Node reverse = reverse(header);
        header = reverse;
        printAll(header);
    }

    /**
     * 链表反转
     *
     * @param list
     * @return
     */
    public static Node reverse(Node list) {
        Node curr = list, p = null;
        while (curr != null) {
            Node next = curr.next;//1.首先保存下一个结点，因为反转要修改指向 原始链表: 0->1->2->3->4  反转后: 0<-1<-2<-3<-4
            curr.next = p;//2.将链表的下一个结点指向新的前一个结点
            p = curr;//3.更新前一个结点的值
            curr = next;//4.移动指针
        }
        return p;
    }

}
































