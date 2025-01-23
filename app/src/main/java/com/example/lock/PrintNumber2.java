package com.example.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 一个线程打印奇数
 * 一个线程打印偶数
 * Condition： 有几种情况就有几种 Condition
 * 现在有奇数和偶数所有有 2个 Condition
 */
public class PrintNumber2 {
    static int count = 0;
    static final int MAX = 50;
    static ReentrantLock lock = new ReentrantLock();
    static Condition conditionEven = lock.newCondition();//偶数条件
    static Condition condition = lock.newCondition();//奇数条件

    public static void main(String[] args) {

        //打印偶数
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lock.lock();
                    while (count < MAX) {
                        while (count % 2 != 0) {
                            conditionEven.await();
                        }
                        System.out.println("whl *** " + count++);
                        condition.signal();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }).start();

        //打印奇数
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lock.lock();
                    while (count < MAX) {
                        while (count % 2 == 0) {
                            condition.await();
                        }
                        System.out.println("whl *** " + count++);
                        conditionEven.signal();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }).start();
    }
}
