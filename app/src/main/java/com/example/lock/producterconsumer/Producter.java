package com.example.lock.producterconsumer;

/**
 * @author : wanghailong
 * @date :
 * @description:
 */
public class Producter implements Runnable {
    private Queue mQueue;

    public Producter(Queue queue) {
        mQueue = queue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            mQueue.put(i);
        }
    }
}
