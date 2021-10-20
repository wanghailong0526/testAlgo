package com.example.algorithm;

public class LinkUtils {
    /**
     * 打印链表
     *
     * @param list
     */
    public static void printAll(Node list) {
        Node p = list;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println("\n");
    }

    /**
     * 根据头结点创建链表
     *
     * @param node
     * @return
     */
    public static Node createLink(Node node) {
        for (int i = 1; i < 4; i++) {
            Node node1 = new Node(null, i);
            node.next = node1;
            node = node.next;
        }
        return node;
    }

    /**
     * 创建结点
     *
     * @param data
     * @return
     */
    public static Node createNode(int data) {
        return new Node(null, data);
    }
}
