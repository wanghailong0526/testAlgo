package com.example.lock.producterconsumer;

import java.util.LinkedList;

/**
 * @author : wanghailong
 * @date :
 * @description: 生产者消费者队列 提供取数据和存数据功能
 */
public class Queue {
    private static final int MAX_VALUE = 100;
    private LinkedList<Integer> list = new LinkedList<>();

    //存数据，判断是否满了，满了wait(),之后存
    public synchronized void put(int n) {
        while (MAX_VALUE == list.size()) {//防止虚假唤醒造成死锁
            try {
                wait();////执行到此处时，下面的list.add(n)将不被执行，直到不满足循环条件
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        list.add(n);
        System.out.println("生产出：" + list.size() + "个宝贝");
        notify();
    }

    //取数据，判断是否为空，为空wait(),之后再取
    public synchronized void get() {
        while (0 == list.size()) {//防止虚假唤醒造成死锁
            try {
                wait(); //执行到此处时，下面的list.poll()将不被执行，直到不满足循环条
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("消费了：" + list.poll() + "，剩余宝贝数量：" + list.size());
        notify();
    }
}
