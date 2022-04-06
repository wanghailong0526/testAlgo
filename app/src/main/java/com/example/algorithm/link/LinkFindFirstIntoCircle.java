package com.example.algorithm.link;

import com.example.algorithm.LinkUtils;
import com.example.algorithm.Node;

/**
 * @author : wanghailong
 * @date :
 * @description: 检测入环的第一个结点
 */
public class LinkFindFirstIntoCircle {

    public static void main(String[] args) {
        Node node = new Node(null, 0);
        Node header = node;//头结点
        Node link = LinkUtils.createLink(node);//link是尾结点
        System.out.println("打印结点：");
        LinkUtils.printAll(header);

        link.next = header;//最后一个结点指向首结点，入环的第一个结点为首结点
        System.out.println("第一个入环结点为: " + detectCycle(header).data);
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
