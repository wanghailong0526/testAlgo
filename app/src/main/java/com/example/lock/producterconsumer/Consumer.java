package com.example.lock.producterconsumer;

/**
 * @author : wanghailong
 * @date :
 * @description:
 */
public class Consumer implements Runnable {
    private Queue mQueue;

    public Consumer(Queue queue) {
        mQueue = queue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            mQueue.get();
        }
    }
}
