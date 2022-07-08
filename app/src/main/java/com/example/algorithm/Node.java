package com.example.algorithm;

/**
 * 结点类
 */
public class Node {
    public Node next;
    public int data;

    public Node() {
    }

    public Node(Node next, int data) {
        this.next = next;
        this.data = data;
    }

    public Node(int data) {
        this.data = data;
    }
}
