package com.example.lock.producterconsumer;

/**
 * @author : wanghailong
 * @date :
 * @description:
 */
public class TestProducterConsumer {
    public static void main(String[] args) {
        Queue queue = new Queue();
        Thread producter = new Thread(new Producter(queue));
        Thread consumer = new Thread(new Consumer(queue));
        producter.start();
        consumer.start();
    }
}
